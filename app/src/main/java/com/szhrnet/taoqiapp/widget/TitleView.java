package com.szhrnet.taoqiapp.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.szhrnet.taoqiapp.R;
import com.szhrnet.taoqiapp.utils.AppUtils;


/**
 * @author Zou Juequn
 * @date 2016.7.14
 */
public class TitleView extends RelativeLayout {

    private Context mContext;
    private View mParentView;
    private LinearLayout mLeftLayout;
    private ImageView mIvLeft;
    private TextView mTvLeft;
    private TextView mTitle;
    private LinearLayout mRightLayout;
    private ImageView mIvRight;
    private TextView mTvRight;
    private RelativeLayout mRlParent;


    public TitleView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public TitleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        init();
    }


    public void init() {
        mParentView = LayoutInflater.from(mContext).inflate(R.layout.widget_titleview, null);
        this.addView(mParentView);
        mRlParent = (RelativeLayout) findViewById(R.id.wt_rl_parent);
        mLeftLayout = (LinearLayout) findViewById(R.id.titleview_ll_left_parent);
        mRightLayout = (LinearLayout) findViewById(R.id.titleview_ll_right_parent);
        mIvLeft = (ImageView) findViewById(R.id.titleview_iv_left_back);
        mIvRight = (ImageView) findViewById(R.id.titleview_iv_right_back);
        mTvLeft = (TextView) findViewById(R.id.titleview_tv_left_back);
        mTvRight = (TextView) findViewById(R.id.titleview_tv_right_back);
        mTitle = (TextView) findViewById(R.id.titleview_tv_title);

        ViewGroup.LayoutParams layoutParams = mRlParent.getLayoutParams();
        layoutParams.height = AppUtils.returnHeight(130, mContext);

        this.setLeftAction(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showInput(false);
                ((Activity) mContext).finish();
                ((Activity) mContext).overridePendingTransition(R.anim.exit_enter, R.anim.exit_exit);
            }
        });


    }


    /**
     * 设置右边图片
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void setRightIvImg(int drawableInt) {
        mIvRight.setBackground(ContextCompat.getDrawable(mContext, drawableInt));
    }

    public void setRightIvAction(OnClickListener clk) {
        mIvRight.setOnClickListener(clk);
    }

    /**
     * 设置右边图片
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void setLeftIvImg(int drawableInt) {
        mIvLeft.setBackground(ContextCompat.getDrawable(mContext, drawableInt));
    }

    /**
     * 设置左边可见
     */
    public void setRightIvGone() {
        mIvRight.setVisibility(View.GONE);
    }

    /**
     * 设置左边可见
     */
    public void setLeftParentVisible() {
        mLeftLayout.setVisibility(View.VISIBLE);
    }

    /**
     * 设置右边可见
     */
    public void setRightParentVisible() {
        mRightLayout.setVisibility(View.VISIBLE);
    }

    /**
     * 设置左边ImageView可见
     */
    public void setLeftIvInVisible() {
        mIvLeft.setVisibility(View.GONE);
    }

    /**
     * 设置右边ImageView可见
     */
    public void setRightIvVisible() {
        mIvRight.setVisibility(View.VISIBLE);
    }

    /**
     * 设置左边TextView可见
     */
    public void setLeftTvVisible() {
        mTvLeft.setVisibility(View.VISIBLE);
    }

    /**
     * 设置右边TextView可见
     */
    public void setRightTvVisible() {
        mTvRight.setVisibility(View.VISIBLE);
    }

    /**
     * 设置Title可见
     */
    public void setTitleVisible() {
        mTitle.setVisibility(View.VISIBLE);
    }


    /**
     * 设置Title可见
     */
    public void setTitleGone() {
        mTitle.setVisibility(View.GONE);
    }


    /**
     * 设置标题颜色
     */
    public void setBgColor(int bgColor) {
        mParentView.setBackgroundColor(mContext.getResources().getColor(bgColor));
    }


    /**
     * 设置标题
     */
    public void setTitle(String title) {
        mTitle.setText(title);
    }

    /**
     * 设置标题
     */
    public void setTitle(int resid) {
        mTitle.setText(resid);
    }


    /**
     * 设置标题
     */
    public void setRightTvTitle(String title) {
        mTvRight.setText(title);
    }

    /**
     * 设置标题
     */
    public void setLeftTvTitle(int resid) {
        mTvLeft.setText(resid);
    }

    /**
     * 设置标题
     */
    public void setLeftTvTitle(String title) {
        mTvLeft.setText(title);
    }

    /**
     * 设置标题
     */
    public void setRightTvTitle(int resid) {
        mTvRight.setText(resid);
    }

    /**
     * 设置左边点击效果，以及图片和文字
     */
    public void setLeftAction(OnClickListener clk) {
        mLeftLayout.setOnClickListener(clk);
    }

    /**
     * 设置左边点击效果，不显示文字
     */
    public void setLeftActionNoText(int imgResId, OnClickListener clk) {
        mTvLeft.setVisibility(View.GONE);
        mIvLeft.setImageResource(imgResId);
        mLeftLayout.setOnClickListener(clk);
    }

    /**
     * 设置左边点击效果，无图片
     */
    public void setLeftActionNoImage(int resId, OnClickListener clk) {
        mIvLeft.setVisibility(View.GONE);
        mTvLeft.setText(resId);
        mLeftLayout.setOnClickListener(clk);
    }


    /**
     * 设置右边点击效果，以及图片和文字
     */
    public void setRightAction(OnClickListener clk) {
        mRightLayout.setOnClickListener(clk);
    }


    /**
     * 设置右控件文本
     */
    public void setRightText(CharSequence text) {
        mTvRight.setText(text);
    }

    /**
     * 设置右控件文本,背景
     */
    public void setRightTextAndBg(CharSequence text, int bgId, OnClickListener clk) {
        mTvRight.setText(text);
        mTvRight.setTextColor(getResources().getColor(R.color.white));
        mTvRight.setBackgroundResource(bgId);
        mTvRight.setOnClickListener(clk);
        mTvRight.setPadding(10,4,10,4);
    }
    public void setRightTextAndWhite(CharSequence text, OnClickListener clk) {
        mTvRight.setText(text);
        mTvRight.setTextColor(getResources().getColor(R.color.white));
        mTvRight.setOnClickListener(clk);
    }
    /**
     * 设置右控件文本
     */
    public void setRightText(int resId) {
        mTvRight.setText(resId);
    }

    public void setRightTextColor(int resId) {
        mTvRight.setTextColor(resId);
    }

    /**
     * 设置右控件文本和事件
     */
    public void setRightAction(CharSequence text, OnClickListener clk) {
        mIvRight.setVisibility(View.GONE);
        mTvRight.setText(text);
        mRightLayout.setOnClickListener(clk);
    }


    /**
     * 设置右边点击效果，无文字
     */
    public void setRightActionNoText(int resId, OnClickListener clk) {
        mIvRight.setImageResource(resId);
        mTvRight.setVisibility(View.GONE);
        mRightLayout.setOnClickListener(clk);
    }


    /**
     * 设置右边点击效果，无图片
     */
    public void setRightActionNoImage(int resId, OnClickListener clk) {
        mIvRight.setVisibility(View.GONE);
        mTvRight.setText(resId);
        mRightLayout.setOnClickListener(clk);
    }

    /**
     * 设置右标题不可见
     */
    public void setRightActionGone() {
        mIvRight.setVisibility(View.GONE);
        mTvRight.setVisibility(View.GONE);
    }

    /**
     * 设置软件盘是否可见
     */
    public void showInput(boolean show) {
        try {
            if (show) {
                InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInputFromInputMethod(((Activity) mContext).getCurrentFocus().getApplicationWindowToken(), 0);
            } else {
                InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(((Activity) mContext).getCurrentFocus().getApplicationWindowToken(), 0);
            }
        } catch (NullPointerException e1) {

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
