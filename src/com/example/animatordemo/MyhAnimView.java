package com.example.animatordemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

public class MyhAnimView extends View {

	public static final float RADIUS = 50f;
	private Point currentPoint;
	private Paint mPaint;
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
		mPaint.setColor(Color.parseColor(color));
		invalidate();
	}

	public MyhAnimView(Context context, AttributeSet attrs) {
		super(context, attrs);

		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setColor(Color.BLUE);
	}

	private void drawDircle(Canvas canvas) {

		float x = currentPoint.getX();
		float y = currentPoint.getY();
		canvas.drawCircle(x, y, RADIUS, mPaint);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if (currentPoint == null) {
			currentPoint = new Point(RADIUS, RADIUS);
			drawDircle(canvas);
			startAnimation();
		} else {

			drawDircle(canvas);
		}

	}

	@SuppressLint("NewApi")
	public void startAnimation() {
		Point startPoint = new Point(getWidth()/2, RADIUS);
		Point endPoint = new Point(getWidth()/2,
				(RADIUS - getHeight())/2);
		ValueAnimator animvalue = ValueAnimator.ofObject(new PointEvaluator(),
				startPoint, endPoint);
		animvalue.addUpdateListener(new AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator arg0) {
				// TODO Auto-generated method stub
				currentPoint = (Point) arg0.getAnimatedValue();
				invalidate();
			}
		});
		//自定义的插值器决定了faction，也就是运动方式
		animvalue.setInterpolator(new DecelerateAccelerateInterpolator());
		ObjectAnimator animobj = ObjectAnimator.ofObject(this, "color",
				new ColorEvaluator(), "#0000FF", "#FF0000");
		AnimatorSet animset = new AnimatorSet();
		animset.play(animvalue).with(animobj);
		animset.setDuration(5000);
		animset.start();

	}

}
