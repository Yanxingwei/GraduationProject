package com.example.teachingaffairs.ui.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.example.teachingaffairs.R;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created by 闫星位 on 2018/1/8.
 */

public class SlidingMenu extends HorizontalScrollView {
    private LinearLayout mLinearLayout;//scrollview内嵌的唯一布局，linearlayout
    private ViewGroup mMenu, mContent;//菜单，内容的布局
    private int mScreenWidth;//屏幕宽度
    //dp
    private int mMenuRightMargin ;//菜单距离屏幕的右边距
    //为了防止onMeasure调用多次
    private boolean once;
    //侧滑菜单打开或关闭的状态
    private boolean isOpen;

    public SlidingMenu(Context context) {
        this(context,null);
    }

    public SlidingMenu(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public SlidingMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(outMetrics);
        mScreenWidth = outMetrics.widthPixels;

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SlidingMenu);
        mMenuRightMargin= (int) ta.getDimension(R.styleable.SlidingMenu_rightPadding, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics()));  //把dp转化为px
        ta.recycle();//回收，以防泄漏
    }

    //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!once) {
            mLinearLayout = (LinearLayout) this.getChildAt(0);//scrollView的唯一子View
            mMenu = (ViewGroup) mLinearLayout.getChildAt(0);
            mContent = (ViewGroup) mLinearLayout.getChildAt(1);

            //测量menu的宽和内容区域的宽
            mMenu.getLayoutParams().width = mScreenWidth - mMenuRightMargin;
            mContent.getLayoutParams().width = mScreenWidth;
            once = true;
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /*
     * 设置偏移量将menu隐藏（放置）
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            this.scrollTo(mMenu.getMeasuredWidth(), 0);
        }
    }

    //动画效果
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt)
    {
        super.onScrollChanged(l, t, oldl, oldt);
        float scale = l * 1.0f / mMenu.getWidth();
        float leftScale = 1 - 0.3f * scale;
        float rightScale = 0.8f + scale * 0.2f;

        ViewHelper.setScaleX(mMenu, leftScale);
        ViewHelper.setScaleY(mMenu, leftScale);
        ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
        ViewHelper.setTranslationX(mMenu, mMenu.getWidth() * scale * 0.7f);

        ViewHelper.setPivotX(mContent, 0);
        ViewHelper.setPivotY(mContent, mContent.getHeight() / 2);
        ViewHelper.setScaleX(mContent, rightScale);
        ViewHelper.setScaleY(mContent, rightScale);

    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                //无需重写这个case，scrollview自带scroller辅助类，会自动滑出来，这也是这样实现侧滑菜单的方便之处
                break;
            case MotionEvent.ACTION_UP:
                if(getScrollX()>mMenu.getMeasuredWidth()/2 ||(isOpen && ev.getX()>mMenu.getMeasuredWidth())){//菜单未滑出一半
                    this.smoothScrollTo(mMenu.getMeasuredWidth(),0);//平滑移动，带动画
                    isOpen = false;
                }else{
                    this.smoothScrollTo(0,0);
                    isOpen = true;
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }

    /**
     * 打开菜单
     */
    public void openMenu()
    {
        if (isOpen)
            return;
        this.smoothScrollTo(0, 0);
        isOpen = true;
    }

    /**
     * 关闭菜单
     */
    public void closeMenu()
    {
        if (isOpen)
        {
            this.smoothScrollTo(mMenu.getMeasuredWidth(), 0);
            isOpen = false;
        }
    }

    /**
     * 切换菜单状态
     */
    public void toggle()
    {
        if (isOpen)
        {
            closeMenu();
        } else
        {
            openMenu();
        }
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (!isOpen) {
            if (ev.getX() < mScreenWidth / 6) {
                return super.onInterceptTouchEvent(ev);
            } else {
                return false;
            }
        }else{
            if (ev.getX() > mScreenWidth - mMenu.getWidth()) {
                return true;
            }else {
                return super.onInterceptTouchEvent(ev);
            }
        }
    }
}
