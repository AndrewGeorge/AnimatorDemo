package com.example.animatordemo;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;

@SuppressLint("NewApi")
public class DecelerateAccelerateInterpolator implements TimeInterpolator {
	float result;
	
	
	
	@Override
	public float getInterpolation(float input) {
		 if (input <= 0.5) {  
	            result = (float) (Math.sin(Math.PI * input)) / 2;  
	        } else {  
	            result = (float) (2 - Math.sin(Math.PI * input)) / 2;  
	        }  
	        return result;  

	}

}
