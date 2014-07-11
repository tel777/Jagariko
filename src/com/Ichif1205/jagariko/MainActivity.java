package com.Ichif1205.jagariko;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.Ichif1205.jagariko.FieldSurfaceView.GameEventLiestener;

public class MainActivity extends Activity implements GameEventLiestener {
	private FieldSurfaceView mFieldSurfaceView;
	private TextView mComboView = null;
	private int mCombo = 0;
	private TextView mCountView = null;
	private int mCount = 0;
	private TextView mTimeView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("check","check1");
		setContentView(R.layout.activity_main);

		Log.d("check","check2");
		setView();
		mFieldSurfaceView = (FieldSurfaceView) findViewById(R.id.FieldSurfaceView_id);
		Log.d("check","check"+this);
		mFieldSurfaceView.setEventListener(this);
	}

	private void setView() {
		// TODO カウンター
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void endGame(int score, int clearflg) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void addScore(int score) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
