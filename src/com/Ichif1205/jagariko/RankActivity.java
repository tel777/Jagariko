package com.Ichif1205.jagariko;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class RankActivity extends Activity {
	private final String TAG = RankActivity.class.getSimpleName();
	private Cursor mCursor;
	private RadioGroup mTabGroup;

	class RankCursorAdapter extends SimpleCursorAdapter {
		public RankCursorAdapter(Context context, int layout, Cursor c,
				String[] from, int[] to, int flg) {
			super(context, layout, c, from, to, flg);
			setTitle("Ranking");
			setViewBinder(new RankListViewBinder());
		}

		class RankListViewBinder implements SimpleCursorAdapter.ViewBinder {
			@Override
			public boolean setViewValue(View view, Cursor cursor,
					int columnIndex) {
				// 順位をセット
				if (columnIndex == cursor
						.getColumnIndex(DatabaseOpenHelper.COLUMN_ID)) {
					int rank = cursor.getPosition() + 1;
					((TextView) view).setText(String.valueOf(rank));
					return true;
				}

				// countをセット
				if (columnIndex == cursor
						.getColumnIndex(DatabaseOpenHelper.COLUMN_COUNT)) {
					double count = cursor.getDouble(columnIndex);
					((TextView) view).setText(String.valueOf(count));
					return true;
				}
				// comboをセット
				if (columnIndex == cursor
						.getColumnIndex(DatabaseOpenHelper.COLUMN_COMBO)) {
					double combo = cursor.getDouble(columnIndex);
					((TextView) view).setText(String.valueOf(combo));
					return true;
				}
				// timeをセット
				if (columnIndex == cursor
						.getColumnIndex(DatabaseOpenHelper.COLUMN_TIME)) {
					double time = cursor.getDouble(columnIndex);
					((TextView) view).setText(String.valueOf(time));
					return true;
				}

				// 日付をセット
				if (columnIndex == cursor
						.getColumnIndex(DatabaseOpenHelper.COLUMN_DATE)) {
					long unixtime = cursor.getLong(columnIndex);
					Date date = new Date(unixtime);
					SimpleDateFormat format = new SimpleDateFormat(
							"yy/MM/dd HH:mm");
					((TextView) view).setText(format.format(date));
					return true;
				}

				return false;
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rank);
		setEventListener();

		mCursor = Ranks.getRanksNormalCursor(getContentResolver());

		showListView();
	}

	/**
	 * イベントリスナーをセット
	 */
	private void setEventListener() {
		mTabGroup = (RadioGroup) findViewById(R.id.tab_group);
		mTabGroup.setOnCheckedChangeListener(onTabChangeListener);
	}

	private OnCheckedChangeListener onTabChangeListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			if (mTabGroup.getCheckedRadioButtonId() == R.id.normal_ranks) {
				mCursor = Ranks.getRanksNormalCursor(getContentResolver());
			} else if (mTabGroup.getCheckedRadioButtonId() == R.id.hard_ranks) {
				mCursor = Ranks.getRanksHardCursor(getContentResolver());
			} else {
				mCursor = Ranks.getRanksTimeCursor(getContentResolver());
			}
			showListView();
		}
	};

	private void showListView() {

		// new String[] {...} と　new int[] {...}
		// の中身がそれぞれ対応している
		// 例えば、DBのscoreカラムはR.id.score_textに表示される
		ListAdapter adapter = new RankCursorAdapter(this,
				R.layout.time_rank_item, mCursor, new String[] {
						DatabaseOpenHelper.COLUMN_ID,
						DatabaseOpenHelper.COLUMN_COUNT,
						DatabaseOpenHelper.COLUMN_COMBO,
						DatabaseOpenHelper.COLUMN_TIME,
						DatabaseOpenHelper.COLUMN_DATE }, new int[] {
						R.id.rank, R.id.count_text,
						R.id.combo_text, R.id.time_text, R.id.date_text }, 0);

		ListView lv = (ListView) findViewById(R.id.rank_list);
		lv.setHeaderDividersEnabled(true);

		lv.setAdapter(adapter);
	}
}
