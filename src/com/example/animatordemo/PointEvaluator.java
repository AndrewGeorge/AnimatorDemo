package com.example.animatordemo;

import java.lang.reflect.Type;

import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.os.Build;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@SuppressWarnings("rawtypes")
public class PointEvaluator implements TypeEvaluator {

	@Override
	public Object evaluate(float arg0, Object arg1, Object arg2) {
		Point startPoint=(Point) arg1;
		Point endPoint=(Point) arg2;
		float x=startPoint.getX()+arg0*(startPoint.getX()-endPoint.getX());
		float y=startPoint.getY()+arg0*(startPoint.getY()-endPoint.getY());
		Point point=new Point(x,y);
		return point;
	}

}
