package com.Ichif1205.jagariko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TopActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top);
		ImageView image = (ImageView) findViewById(R.id.title_icon_id);
		TextView title = (TextView) findViewById(R.id.title);

		// Normal Activity
		Button normal_start = (Button) findViewById(R.id.normal_id);
		normal_start.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(TopActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		// Hard Activity
		Button hard_start = (Button) findViewById(R.id.hard_id);
		hard_start.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(TopActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		// time Activity
		Button time_start = (Button) findViewById(R.id.time_id);
		time_start.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(TopActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});

		// Rank Activity
		Button button_rank = (Button) findViewById(R.id.rank_id);
		button_rank.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent intent = new Intent(TopActivity.this, RankActivity.class);
				startActivity(intent);
			}
		});
	}
}
