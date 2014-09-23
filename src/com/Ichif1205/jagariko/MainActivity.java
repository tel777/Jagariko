package com.Ichif1205.jagariko;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.CycleInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private static int[] TARGET_RES_ID = { R.id.target1, R.id.target2,
			R.id.target3, R.id.target4, R.id.target5, R.id.target6,
			R.id.target7, R.id.target8, R.id.target9, R.id.target10,
			R.id.target11, R.id.target12, R.id.target13, R.id.target14,
			R.id.target15, R.id.target16 };
	private static final int MAX_TARGET = TARGET_RES_ID.length;
	private static int mCurrentId;
	private TextView mComboView = null;
	private int mCombo = 0;
	private ProgressBar mProgressBar = null;
	private TextView mCountView = null;
	private int mCount = 0;
	private TextView mTimeView = null;
	private float mTime = 15; // カウント
	private Timer mTimer; // タイマー用
	private MainTimerTask mTimerTask; // タイマタスククラス
	private Handler mHandler = new Handler(); // UI Threadへのpost用ハンドラ

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		for (int i = 0; i < MAX_TARGET; i++) {
			final int firstTargetRes = TARGET_RES_ID[i];
			final Button targetButton = (Button) findViewById(firstTargetRes);
			targetButton.setVisibility(View.VISIBLE);
			targetButton.setOnClickListener(this);
		}

		mComboView = (TextView) findViewById(R.id.comboView_id);
		mCountView = (TextView) findViewById(R.id.countView_id);
		mTimeView = (TextView) findViewById(R.id.timeView_id);
		mTimerTask = new MainTimerTask();
		mTime = 15.0f;
		mTimer = new Timer(true);
		mTimer.schedule(mTimerTask, 100, 100);
		mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
		mProgressBar.setMax(30);
		mProgressBar.setProgress(0);

		// １つだけ色変化
		Random r = new Random();
		int n = r.nextInt(16);
		mCurrentId = TARGET_RES_ID[n];
		switchTargetBackground(mCurrentId, 255, 0, 0);
	}

	@Override
	public void onClick(View v) {
		final int currentId = v.getId();
		if (mCurrentId != currentId) {
			// 失敗時
			mCombo = 0;
			mComboView.setText(String.valueOf(mCombo));
			mProgressBar.setProgress(mCombo);
			return;
		}
		// 成功時
		mCombo++;
		mComboView.setText(String.valueOf(mCombo));
		
		int addTimecoefficient = 5;
		// AlphaAnimation(float fromAlpha, float toAlpha)
		AlphaAnimation alpha = new AlphaAnimation(1, 0);
		int animationCount = 1;
		int animationTime = 1000;
		if (5 < mCombo && mCombo < 10) {
			addTimecoefficient=4;
			animationCount = 4;
		} else if (9 < mCombo && mCombo < 20) {
			addTimecoefficient=6;
			animationCount = 6;
		} else if (19 < mCombo && mCombo < 30) {
			addTimecoefficient=8;
			animationCount = 8;
		} else if (29 < mCombo) {
			addTimecoefficient=10;
			animationCount = 10;
		}
		// animationTime/msの間で
		alpha.setDuration(animationTime);
		// animationCount回繰り返す
		alpha.setInterpolator(new CycleInterpolator(animationCount));
		// アニメーションスタート
		mComboView.startAnimation(alpha);
		mProgressBar.startAnimation(alpha);

		mProgressBar.setProgress(mCombo);
		mCount++;
		mCountView.setText(String.valueOf(mCount));
		switchTargetBackground(currentId, 46, 204, 113);

		// 残り時間追加
		mTime += 0.3d*addTimecoefficient/10;
		// 計算にゆらぎがあるので小数点第1位で丸める
		BigDecimal bi = new BigDecimal(mTime);
		mTime = bi.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
		// 次の色かえる
		Random r = new Random();
		int n = 0;
		do {
			n = r.nextInt(16);
		} while (TARGET_RES_ID[n] == currentId);
		mCurrentId = TARGET_RES_ID[n];
		switchTargetBackground(mCurrentId, 255, 0, 0);
	}

	/**
	 * targetIdで指定されたViewの背景色を指定したrgbに変更する
	 * 
	 * @param targetId
	 * @param r
	 * @param g
	 * @param b
	 */
	private void switchTargetBackground(int targetId, int r, int g, int b) {
		findViewById(targetId).setBackgroundColor(Color.rgb(r, g, b));
	}

	/**
	 * タイマータスク派生クラス run()に定周期で処理したい内容を記述
	 * 
	 */
	public class MainTimerTask extends TimerTask {
		@Override
		public void run() {
			// ここに定周期で実行したい処理を記述します
			mHandler.post(new Runnable() {
				public void run() {
					mTime -= 0.1d;

					// 計算にゆらぎがあるので小数点第1位で丸める
					BigDecimal bi = new BigDecimal(mTime);
					mTime = bi.setScale(1, BigDecimal.ROUND_HALF_UP)
							.floatValue();

					if (mTime == 0) {
						mTimer.cancel();
						mTimer = null;
						Intent intent = new Intent(MainActivity.this,
								RankActivity.class);
						startActivity(intent);
					}
					// 画面にカウントを表示
					mTimeView.setText(String.valueOf(mTime));
				}
			});
		}
	}
}
