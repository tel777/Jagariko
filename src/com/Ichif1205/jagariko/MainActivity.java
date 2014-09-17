package com.Ichif1205.jagariko;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private TextView mComboView = null;
	private int mCombo = 0;
	private TextView mCountView = null;
	private int mCount = 0;
	private TextView mTimeView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 初期描写
		setView();
	}

	public boolean onTouchEvent(MotionEvent event) {
		int x = (int) event.getX();
		int y = (int) event.getY();
		return true;
	}

	@Override
	public void onClick(View v) {
		v.setBackgroundColor(Color.RED);
		Log.d("bug", "aiueo");
	}

	private void setView() {
		View oval1 = findViewById(R.id.oval1);
		View oval2 = findViewById(R.id.oval2);
		View oval3 = findViewById(R.id.oval3);
		View oval4 = findViewById(R.id.oval4);
		View oval5 = findViewById(R.id.oval5);
		View oval6 = findViewById(R.id.oval6);
		View oval7 = findViewById(R.id.oval7);
		View oval8 = findViewById(R.id.oval8);
		View oval9 = findViewById(R.id.oval9);
		View oval10 = findViewById(R.id.oval10);
		View oval11 = findViewById(R.id.oval11);
		View oval12 = findViewById(R.id.oval12);
		View oval13 = findViewById(R.id.oval13);
		View oval14 = findViewById(R.id.oval14);
		View oval15 = findViewById(R.id.oval15);
		View oval16 = findViewById(R.id.oval16);
		GradientDrawable ovalDrawable = (GradientDrawable) getResources()
				.getDrawable(R.drawable.circle);

		// changeColor
		ovalDrawable.setColor(Color.GREEN);

		// Viewに適応
		oval1.setBackground(ovalDrawable);
		oval2.setBackground(ovalDrawable);
		oval3.setBackground(ovalDrawable);
		oval4.setBackground(ovalDrawable);
		oval5.setBackground(ovalDrawable);
		oval6.setBackground(ovalDrawable);
		oval7.setBackground(ovalDrawable);
		oval8.setBackground(ovalDrawable);
		oval9.setBackground(ovalDrawable);
		oval10.setBackground(ovalDrawable);
		oval11.setBackground(ovalDrawable);
		oval12.setBackground(ovalDrawable);
		oval13.setBackground(ovalDrawable);
		oval14.setBackground(ovalDrawable);
		oval15.setBackground(ovalDrawable);
		oval16.setBackground(ovalDrawable);

	}

}
