package com.example.metro;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class Rutas extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rutas);
		Intent intent = getIntent();
		String[] steps = new String[9];
		
		//Gets 
		Bundle extras = intent.getExtras();
		int stepSize = extras.getInt("SIZE");
		
		for(int i=0; i<stepSize; i++){
			steps[i] = intent.getStringExtra("ESTACION" + i);
		}
		
		TextView textE1 = (TextView)findViewById(R.id.textE1);
		TextView textE2 = (TextView)findViewById(R.id.textE2);
		TextView textE3 = (TextView)findViewById(R.id.textE3);
		textE1.setText(steps[0]);
		textE2.setText(steps[1]);
		textE3.setText(steps[2]);
	}
}
