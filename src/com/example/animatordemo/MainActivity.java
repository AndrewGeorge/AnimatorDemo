package com.example.animatordemo;

import com.example.animatordemo.R.animator;

import android.os.Build;
import android.os.Bundle;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initview();

	}

	@SuppressLint("NewApi")
	private void initview() {

		// ValueAnimator anim=ValueAnimator.ofFloat(0f,5f,3f,10f);
		// anim.setDuration(500);
		// anim.addUpdateListener(new AnimatorUpdateListener() {
		//
		// @Override
		// public void onAnimationUpdate(ValueAnimator animation) {
		// // TODO Auto-generated method stub
		// float currentValue = (Float) animation.getAnimatedValue();
		// Log.d("TAG", "cuurent value is " + currentValue);
		// }
		// });
		//
		// anim.start();

		final TextView texitview = (TextView) findViewById(R.id.id_texitview);

		findViewById(R.id.id_butstrat).setOnClickListener(
				new OnClickListener() {

					@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
					@SuppressLint("NewApi")
					@Override
					public void onClick(View arg0) {
//
//						// �ؼ���ȡ��ǰλ��
//						float curTranslationX = texitview.getTranslationX();
//						// �����ƶ�
//						// //ObjectAnimator
//						// anim=ObjectAnimator.ofFloat(texitview,
//						// "translationX",curTranslationX,-500,curTranslationX);
//						// ��ֱ��������ţ�ObjectAnimator�ڲ��Ĺ������Ʋ�����ֱ�Ӷ����Ǵ�������������в����ģ����ǻ�ȥѰ�������������Ӧ��get��set����
//						// View �ṩ�˸÷������ֱ������ɵ��뵭������ת��ˮƽ�ƶ�����ֱ��������ʵ��
//						// ObjectAnimator anim =
//						// ObjectAnimator.ofFloat(texitview, "scaleY", 1f, 3f,
//						// 1f);
//						// anim.setDuration(500);
//						// anim.addUpdateListener(new AnimatorUpdateListener() {
//						//
//						// @Override
//						// public void onAnimationUpdate(ValueAnimator
//						// animation) {
//						// // TODO Auto-generated method stub
//						// float currentValue = (Float)
//						// animation.getAnimatedValue();
//						// Log.d("TAG", "cuurent value is " + currentValue);
//						// }
//						// });
//						//
//						// anim.start();
//
//						ObjectAnimator moveIn = ObjectAnimator.ofFloat(
//								texitview, "translationX", -500f, 0f);
//						//������������
////						moveIn.addListener(new AnimatorListenerAdapter() {
////						
////						@Override
////						public void onAnimationEnd(Animator animation) {
////							// TODO Auto-generated method stub
////							super.onAnimationEnd(animation);
////						}
////						});
//						ObjectAnimator rotate = ObjectAnimator.ofFloat(
//								texitview, "rotation", 0f, 360f);
//						ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(
//								texitview, "alpha", 1f, 0f, 1f);
//						AnimatorSet animSet = new AnimatorSet();
//						animSet.play(rotate).with(fadeInOut).after(moveIn);
//						animSet.setDuration(5000);
//						animSet.start();

						//ʹ��XML���嶯�����ݲ�����
//						Animator ain=AnimatorInflater.loadAnimator(MainActivity.this, R.animator.animatoerset);
//						ain.setTarget(texitview);
//						ain.start();
						texitview.animate().x(500).y(500).setDuration(5000).setInterpolator(new BounceInterpolator());
						
					}
				});


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
