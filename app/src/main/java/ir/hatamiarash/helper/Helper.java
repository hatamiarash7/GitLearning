/*
 * Copyright (c) 2017 - All Rights Reserved - Arash Hatami
 */

package ir.hatamiarash.helper;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatDelegate;
import android.widget.Toast;

import ir.hatamiarash.MyToast.CustomToast;
import ir.hatamiarash.gitlearning.R;
import ir.hatamiarash.utils.TAGs;

public class Helper {
	static {
		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
	}
	
	public static void MakeToast(Context context, String Message, String TAG) {
		if (TAG.equals(TAGs.WARNING))
			CustomToast.custom(context, Message, R.drawable.ic_alert, ContextCompat.getColor(context, R.color.md_white_1000), ContextCompat.getColor(context, R.color.md_deep_orange_400), Toast.LENGTH_SHORT, true, true).show();
		if (TAG.equals(TAGs.SUCCESS))
			CustomToast.custom(context, Message, R.drawable.ic_success, ContextCompat.getColor(context, R.color.md_white_1000), ContextCompat.getColor(context, R.color.md_green_500), Toast.LENGTH_SHORT, true, true).show();
		if (TAG.equals(TAGs.ERROR))
			CustomToast.custom(context, Message, R.drawable.ic_error, ContextCompat.getColor(context, R.color.md_white_1000), ContextCompat.getColor(context, R.color.md_red_500), Toast.LENGTH_SHORT, true, true).show();
	}
	
	public static void MakeToast(Context context, String Message, String TAG, int DURATION) {
		if (TAG.equals(TAGs.WARNING))
			CustomToast.custom(context, Message, R.drawable.ic_alert, ContextCompat.getColor(context, R.color.md_white_1000), ContextCompat.getColor(context, R.color.md_deep_orange_400), DURATION, true, true).show();
		if (TAG.equals(TAGs.SUCCESS))
			CustomToast.custom(context, Message, R.drawable.ic_success, ContextCompat.getColor(context, R.color.md_white_1000), ContextCompat.getColor(context, R.color.md_green_500), DURATION, true, true).show();
		if (TAG.equals(TAGs.ERROR))
			CustomToast.custom(context, Message, R.drawable.ic_error, ContextCompat.getColor(context, R.color.md_white_1000), ContextCompat.getColor(context, R.color.md_red_500), DURATION, true, true).show();
	}
}