package com.example.bmiapp;

import com.example.bmiapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	// それ以外のボタン
	public void buttonExitMethod(View button){
		finish();
	}
	// ボタン押したとき
	public void buttonMethod(View button){
		try{
			// 身長
			EditText editHeight = (EditText)findViewById(R.id.editHeight);
			float height = Float.parseFloat(editHeight.getText().toString());
			height /= 100; // メートルに直す
			
			// 体重
			EditText editWeight = (EditText)findViewById(R.id.editWeight);
			float weight = Float.parseFloat(editWeight.getText().toString());
			
			// BMI計算
			float bmi = weight / (height * height);

			// 分析結果
			String result = "";
			if(bmi < 18.5){
				result = "低体重（痩せ型）";
			}
			else if(bmi < 25){
				result = "普通体重";
			}
			else if(bmi < 30){
				result = "肥満（1度）";
			}
			else if(bmi < 35){
				result = "肥満（2度）";
			}
			else if(bmi < 40){
				result = "肥満（3度）";
			}
			else{
				result = "肥満（4度）";
			}

			// 画面遷移
            // Result アクティビティを起動
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("BMIvalue", bmi);
            intent.putExtra("BMIresult", result);
            startActivity(intent);
		}
		catch(NumberFormatException e){
			Toast.makeText(this, "入力値が不正です", Toast.LENGTH_SHORT).show();
		}
	}

}
