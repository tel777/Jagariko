package com.Ichif1205.jagariko;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class FieldSurfaceView extends SurfaceView implements
		SurfaceHolder.Callback, Runnable {
	private GameEventLiestener mGameListener = null;
	private SurfaceHolder mHolder;
	private final Context mContext;

	public FieldSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		mHolder = getHolder();
		mHolder.addCallback(this);
		mHolder.setFixedSize(getWidth(), getHeight());
		Log.d("checkContext", "Constract");
	}

	@Override
	public void run() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ

	}

	/**
	 * リスナーをセット
	 * 
	 * @param listener
	 */
	public void setEventListener(GameEventLiestener listener) {
		Log.d("checkList", "a" + listener);
		mGameListener = listener;
	}

	/**
	 * ゲームの各イベントリスナー
	 */
	public interface GameEventLiestener {
		/**
		 * ゲーム終了イベント
		 * 
		 * @param mScore
		 */
		public void endGame(int score, int clearflg);

		/**
		 * スコア増加イベント
		 * 
		 * @param mScore
		 */
		public void addScore(int score);

	}
}
