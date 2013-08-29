package com.example.metro;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;

public class mostrarRutas extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mostrar_rutas);
		Intent intent = getIntent();
		String[] steps = new String[9];
		//Integer[] line = new Integer[3];
		TextView linea1 = (TextView)findViewById(R.id.color1);
		TextView textE1 = (TextView)findViewById(R.id.textE1);
		TextView textE2 = (TextView)findViewById(R.id.textE2);
		TextView textE3 = (TextView)findViewById(R.id.textE3);
		
		TextView linea2 = (TextView)findViewById(R.id.color2);
		
		
		//Gets 
		Bundle extras = intent.getExtras();
		int stepSize = extras.getInt("SIZE");
		int line = extras.getInt("LINE");
		
		//Creates array of variables
		//Steps
		for(int i=0; i<stepSize; i++){
			steps[i] = extras.getString("ESTACION" + i);
		}
		
		if(steps.length >= 3){
			setColorAndName(linea1, line);
			textE1.setText(steps[0]);
			textE2.setText(steps[1]);
			textE3.setText(steps[2]);
			linea2.setVisibility(View.GONE);
		}
		if(steps.length > 3 && steps.length < 6){
			linea2.setVisibility(View.VISIBLE);
			setColorAndName(linea2, line);
			textE1.setText(steps[3]);
			textE2.setText(steps[4]);
			textE3.setText(steps[5]);
		}
		
	}
	
	//Pasa el color y el nombre de la línea
	void setColorAndName(TextView linea, int line){
		switch (line) {
		case 1:
			linea.setBackgroundColor(Color.rgb(238,98,158));
			linea.setText("Linea 1");
			break;
		case 2:
			linea.setBackgroundColor(Color.BLUE);
			linea.setText("Linea 2");
			break;
		case 3:
			linea.setBackgroundColor(Color.rgb(67,202,5));
			linea.setText("Linea 3");
			break;
		case 4:
			linea.setBackgroundColor(Color.CYAN);
			linea.setText("Linea 4");
			break;
		case 5:
			linea.setBackgroundColor(Color.YELLOW);
			linea.setText("Linea 5");
			break;
		case 6:
			linea.setBackgroundColor(Color.RED);
			linea.setText("Linea 6");
			break;
		case 7:
			linea.setBackgroundColor(Color.rgb(215,79,21));
			linea.setText("Linea 7");
			break;
		case 8:
			linea.setBackgroundColor(Color.rgb(43,126,79));
			linea.setText("Linea 8");
			break;
		case 9:
			linea.setBackgroundColor(Color.rgb(54,26,21));
			linea.setText("Linea 9");
			break;
		case 10:
			linea.setBackgroundColor(Color.rgb(163,41,122));
			linea.setText("Linea A");
			break;
		case 11:
			linea.setBackgroundColor(Color.GRAY);
			linea.setText("Linea B");
			break;
		case 12:
			linea.setBackgroundColor(Color.rgb(174,148,1));
			linea.setText("Linea 12");
			break;
			
		default:
			linea.setBackgroundColor(Color.BLACK);
			break;
		}
	}
}
