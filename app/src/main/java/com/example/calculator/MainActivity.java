package com.example.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	/**
	 * 演算子がどれなのかの定義をしておく今回はあまり気にしなくてOK
	 */
	private enum Operation {
		PLUS("+"),
		SUBTRACTION("-"),
		MULTIPLICATION("×"),
		DIVISION("÷"),
		NONE("");
		private final String symbol;

		Operation(String symbol) {
			this.symbol = symbol;
		}

		public String getSymbol() {
			return symbol;
		}
	}

	/**
	 * 入力した値を表示するためのView
	 */
	private TextView displayInput;
	private TextView displayResult;
	private String firstNumber;
	private String secondNumber;
	private Operation inputOperation = Operation.NONE;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 準備を色々する
		firstNumber = "";
		secondNumber = "";
		inputOperation = Operation.NONE;
		displayInput = (TextView) findViewById(R.id.display_input);
		displayResult = (TextView) findViewById(R.id.display_result);

		// 数字をおした時の動作を関連付ける
		findViewById(R.id.digit_0).setOnClickListener(new OnClickListenerForNumber(0));
		findViewById(R.id.digit_1).setOnClickListener(new OnClickListenerForNumber(1));
		findViewById(R.id.digit_2).setOnClickListener(new OnClickListenerForNumber(2));
		findViewById(R.id.digit_3).setOnClickListener(new OnClickListenerForNumber(3));
		findViewById(R.id.digit_4).setOnClickListener(new OnClickListenerForNumber(4));
		findViewById(R.id.digit_5).setOnClickListener(new OnClickListenerForNumber(5));
		findViewById(R.id.digit_6).setOnClickListener(new OnClickListenerForNumber(6));
		findViewById(R.id.digit_7).setOnClickListener(new OnClickListenerForNumber(7));
		findViewById(R.id.digit_8).setOnClickListener(new OnClickListenerForNumber(8));
		findViewById(R.id.digit_9).setOnClickListener(new OnClickListenerForNumber(9));
		// 小数点をおした時の動作
		findViewById(R.id.dot).setOnClickListener(new OnClickListenerForDot());

		// TODO: 演算子の関連付けをする

		// TODO: クリアボタンの関連付けをする

		// TODO: =の関連付けをする
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	/**
	 * 数字のボタンが押された時の動きを設定するためのクラス
	 */
	private class OnClickListenerForNumber implements View.OnClickListener {
		private final int number;

		public OnClickListenerForNumber(int number) {
			this.number = number;
		}

		/**
		 * 数字を文字列として取得するためのメソッド
		 *
		 * @return numberをString型に変換したもの
		 */
		protected String getStringNumber() {
			return Integer.toString(number);
		}

		/*
		 * このメソッドに数字のボタンが押された時の動きを書く
		 */
		@Override
		public void onClick(View v) {
			// TODO: 数字が押された時の動きをここに書く
		}
	}

	/**
	 * このクラスはちょっとややこしい話になるので今回は何もしない
	 */
	private class OnClickListenerForDot extends OnClickListenerForNumber {

		public OnClickListenerForDot() {
			super(-1);
		}

		protected String getStringNumber() {
			return ".";
		}
	}

	/**
	 * 演算子用のOnClickListener
	 */
	private class OnClickListenerForOperation implements View.OnClickListener {
		/**
		 * どの演算子なのかを判別するためのもの
		 */
		private final Operation operation;

		public OnClickListenerForOperation(Operation operation) {
			this.operation = operation;
		}

		@Override
		public void onClick(View v) {
			// TODO: 演算子が押された時の動作を書く
		}
	}

	private class OnClickListenerForClear implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO: クリアボタンが押された時の動作を書く
		}
	}

	private class OnClickListenerForEqual implements View.OnClickListener {

		/**
		 * 文字列を数字に変換する
		 *
		 * @param stringNumber
		 * @return
		 */
		private double convertNumber(String stringNumber) {
			return Double.valueOf(stringNumber);
		}

		@Override
		public void onClick(View v) {
			// TODO: 計算結果を表示するようにする
			Double result = null;
			switch (inputOperation) {
				case PLUS:
					break;
				case SUBTRACTION:
					break;
				case MULTIPLICATION:
					break;
				case DIVISION:
					break;
				default:
					break;
			}
			if (result != null) {
				displayResult.setText("=" + String.valueOf(result));
			}
		}
	}

}
