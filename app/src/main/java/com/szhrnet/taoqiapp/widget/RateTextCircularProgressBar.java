package com.szhrnet.taoqiapp.widget;


import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : 中间带有进度百分比文字显示的环形进度条
 *     email:15695947865@139.com
 * </pre>
 */

public class RateTextCircularProgressBar extends FrameLayout implements CircularProgressBar.OnProgressChangeListener {

	private CircularProgressBar mCircularProgressBar;
	private TextView mRateText;
	
	public RateTextCircularProgressBar(Context context) {
		super(context);
		init();
	}
	
	public RateTextCircularProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {
		mCircularProgressBar = new CircularProgressBar(getContext());
		this.addView(mCircularProgressBar);
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		lp.gravity = Gravity.CENTER;
		mCircularProgressBar.setLayoutParams(lp);
		
		mRateText = new TextView(getContext());
		this.addView(mRateText);
		mRateText.setLayoutParams(lp);
		mRateText.setGravity(Gravity.CENTER);
		mRateText.setTextColor(Color.WHITE);
		mRateText.setTextSize(15);
		
		mCircularProgressBar.setOnProgressChangeListener(this);
	}
	
	/**
	 * 设置最大值
	 */
	public void setMax( int max ) {
		mCircularProgressBar.setMax(max);
	}
	
	/**
	 * 设置进度
	 * @param progress
	 */
	public void setProgress(int progress) {
		mCircularProgressBar.setProgress(progress);
	}
	
	/**
	 * 得到 CircularProgressBar 对象，用来设置其他的一些属性
	 * @return
	 */
	public CircularProgressBar getCircularProgressBar() {
		return mCircularProgressBar;
	}
	
	/**
	 * 设置中间进度百分比文字的尺寸
	 * @param size
	 */
	public void setTextSize(float size) {
		mRateText.setTextSize(size);
	}
	
	/**
	 * 设置中间进度百分比文字的颜色
	 * @param color
	 */
	public void setTextColor( int color) {
		mRateText.setTextColor(color);
	}

	@Override
	public void onChange(int duration, int progress, float rate) {
		mRateText.setText(String.valueOf( (int)(rate * 100 ) + "%"));
	}
	
}
