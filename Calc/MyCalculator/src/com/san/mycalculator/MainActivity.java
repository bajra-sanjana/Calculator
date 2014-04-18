package com.san.mycalculator;

import android.support.v4.app.Fragment;
import android.support.v7.appcompat.R.id;
import android.text.TextUtils;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity implements OnClickListener {
	
	EditText etNum1;
	EditText etNum2;
	
	Button btnAdd;
	Button btnSub;
	Button btnMult;
	Button btnDiv;
	
	TextView tvResult;
	
	String oper = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//find the elements
		etNum1 = (EditText) findViewById(R.id.etNum1);
		etNum2 = (EditText) findViewById(R.id.etNum2);
		//ghfj
		btnAdd = (Button) findViewById(R.id.btnAdd);
		btnSub = (Button) findViewById(R.id.btnSub);
		btnMult = (Button) findViewById(R.id.btnMult);
		btnDiv = (Button) findViewById(R.id.btnDiv);
		
		tvResult = (TextView) findViewById(R.id.tvResult);
		
		//set listeners
		btnAdd.setOnClickListener((OnClickListener) this);
		btnSub.setOnClickListener(this);
		btnMult.setOnClickListener(this);
		btnDiv.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	@Override
	public void onClick(View v) {
		float num1 = 0;
		float num2 = 0;
		float result = 0;
		
		if(TextUtils.isEmpty(etNum1.getText().toString()) || TextUtils.isEmpty(etNum2.getText().toString()))
			return;
		
		num1 = Float.parseFloat(etNum1.getText().toString());
		num2 = Float.parseFloat(etNum2.getText().toString());
		
		switch(v.getId()){
		case R.id.btnAdd:
			oper = "+";
			result = num1 + num2;
			break;
		case R.id.btnSub:
			oper = "-";
			result = num1 - num2;
			break;
		case R.id.btnMult:
			oper = "*";
			result = num1 * num2;
			break;
		case R.id.btnDiv:
			oper = "/";
			result = num1/num2;
			break;
		default:
			break;
		}
		
		tvResult.setText(num1 + " "+oper +" "+num2 + " = "+result);
	}

}
