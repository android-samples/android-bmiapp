package com.example.bmiapp;

import com.example.bmiapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		// インテントからＢＭＩ値を取得
		float bmi = getIntent().getFloatExtra("BMIvalue", 0.0f);
		String result = getIntent().getStringExtra("BMIresult");
		
		// ウィジェットにセット
		TextView textBmi = (TextView)findViewById(R.id.textBmi);
		textBmi.setText(String.format("BMI：%.2f", bmi));
		
		TextView textResult = (TextView)findViewById(R.id.textResult);
		textResult.setText("分析結果：" + result);


		/*
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    float  bmi_value = extras.getFloat("BMIvalue");
		    String bmi_judge = extras.getString("BMIjudge");
		    float  std_value = extras.getFloat("STDvalue");
		    float std_gap = extras.getFloat("STDgap");
		    // ウィジェットにセット
		    txt_value.setText(String.valueOf(bmi_value));
		    txt_judge.setText(bmi_judge);
		    txt_std.setText(String.valueOf(std_value) + "kg");
		    txt_gap.setText(String.valueOf(std_gap) + "kg");
		}
		*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}
	
	public void buttonMethod(View button){
		// このアクティビティを終了
		finish();
//             Intent result_act = new Intent(Result.this, AppBMI.class);
//             startActivity(result_act);
	}
	
	public void buttonNewMethod(View button){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
