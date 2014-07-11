package com.Ichif1205.jagariko;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);

		// Radio
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.mode_group);
		// 指定した ID のラジオボタンをチェックします
		radioGroup.check(R.id.radiobutton_normal);
		// チェックされているラジオボタンの ID を取得します
		RadioButton radioButton = (RadioButton) findViewById(radioGroup
				.getCheckedRadioButtonId());
		// ラジオグループのチェック状態が変更された時に呼び出されるコールバックリスナーを登録します
		radioGroup
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
					// ラジオグループのチェック状態が変更された時に呼び出されます
					// チェック状態が変更されたラジオボタンのIDが渡されます
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						RadioButton radioButton = (RadioButton) findViewById(checkedId);
						Toast.makeText(SettingActivity.this,
								"onCheckedChanged():" + radioButton.getText(),
								Toast.LENGTH_SHORT).show();
					}
				});

		// Spinner
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// アイテムを追加します
		adapter.add("white");
		adapter.add("black");
		adapter.add("gray");
		adapter.add("blue");
		adapter.add("red");
		adapter.add("yellow");
		adapter.add("green");
		adapter.add("purple");
		adapter.add("pink");
		adapter.add("orange");
		adapter.add("brown");
		Spinner spinnerBack = (Spinner) findViewById(R.id.back_spinner);
		Spinner spinnerDefo = (Spinner) findViewById(R.id.defo_spinner);
		Spinner spinnerChange = (Spinner) findViewById(R.id.change_spinner);
		// アダプターを設定します
		spinnerBack.setAdapter(adapter);
		spinnerDefo.setAdapter(adapter);
		spinnerChange.setAdapter(adapter);
		// スピナーのアイテムが選択された時に呼び出されるコールバックリスナーを登録します
		spinnerBack
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						Spinner spinner = (Spinner) parent;
						int colorId = 0;
						// 選択されたアイテムを取得します
						String item = (String) spinner.getSelectedItem();
						colorId = makeColorId(item);
						TextView changeText = (TextView) findViewById(R.id.backView);
						changeText.setBackgroundColor(colorId);
						// Toast.makeText(SettingActivity.this, item, Toast.
						// LENGTH_LONG).show();
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
					}
				});
		// スピナーのアイテムが選択された時に呼び出されるコールバックリスナーを登録します
		spinnerDefo
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						Spinner spinner = (Spinner) parent;
						int colorId = 0;
						// 選択されたアイテムを取得します
						String item = (String) spinner.getSelectedItem();
						colorId = makeColorId(item);
						TextView changeText = (TextView) findViewById(R.id.defoView);
						changeText.setBackgroundColor(colorId);
						// Toast.makeText(SettingActivity.this, item, Toast.
						// LENGTH_LONG).show();
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
					}
				});
		// スピナーのアイテムが選択された時に呼び出されるコールバックリスナーを登録します
		spinnerChange
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						Spinner spinner = (Spinner) parent;
						int colorId = 0;
						// 選択されたアイテムを取得します
						String item = (String) spinner.getSelectedItem();
						colorId = makeColorId(item);

						TextView changeText = (TextView) findViewById(R.id.changeView);
						changeText.setBackgroundColor(colorId);
						// Toast.makeText(SettingActivity.this, item, Toast.
						// LENGTH_LONG).show();
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
					}
				});
	}

	public int makeColorId(String item) {
		int colorId = 0;
		if (item == "white") {
			colorId = getResources().getColor(R.color.white);
		} else if (item == "black") {
			colorId = getResources().getColor(R.color.black);
		} else if (item == "gray") {
			colorId = getResources().getColor(R.color.gray);
		} else if (item == "blue") {
			colorId = getResources().getColor(R.color.blue);
		} else if (item == "red") {
			colorId = getResources().getColor(R.color.red);
		} else if (item == "yellow") {
			colorId = getResources().getColor(R.color.yellow);
		} else if (item == "green") {
			colorId = getResources().getColor(R.color.green);
		} else if (item == "purple") {
			colorId = getResources().getColor(R.color.purple);
		} else if (item == "pink") {
			colorId = getResources().getColor(R.color.pink);
		} else if (item == "orange") {
			colorId = getResources().getColor(R.color.orange);
		} else if (item == "brown") {
			colorId = getResources().getColor(R.color.brown);
		}
		return colorId;
	}
}
