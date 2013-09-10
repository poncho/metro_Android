package com.example.metro;

import java.util.ArrayList;
import java.util.Arrays;

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
		
		TextView linea1 = (TextView)findViewById(R.id.color1);
		TextView textI1 = (TextView)findViewById(R.id.textI1);
		TextView textD1 = (TextView)findViewById(R.id.textD1);
		TextView textF1 = (TextView)findViewById(R.id.textF1);
		
		TextView linea2 = (TextView)findViewById(R.id.color2);
		TextView textI2 = (TextView)findViewById(R.id.textI2);
		TextView textD2 = (TextView)findViewById(R.id.textD2);
		TextView textF2 = (TextView)findViewById(R.id.textF2);
		
		
		//Gets 
		Bundle extras = intent.getExtras();
		int stepSize = extras.getInt("SIZE");
		int[] line = extras.getIntArray("LINE");
		System.out.println("SIZE: "+stepSize);
		//Creates array of variables
		//Steps
		String[] steps = extras.getStringArray("STEPS");
		System.out.println("STEPS: "+Arrays.toString(steps));
		
		if(steps.length >= 3){
			setColorAndName(linea1, line[0]);
			textI1.setText("De "+steps[0]);
			textD1.setText("Con dirección "+steps[1]);
			textF1.setText("Hasta "+steps[2]);
			linea2.setVisibility(View.GONE);
		}
		if(steps.length > 3 && steps.length <= 5){
			linea2.setVisibility(View.VISIBLE);
			textI2.setVisibility(View.VISIBLE);
			textD2.setVisibility(View.VISIBLE);
			textF2.setVisibility(View.VISIBLE);
			setColorAndName(linea2, line[1]);
			textI2.setText("De "+steps[2]);
			textD2.setText("Con dirección "+steps[3]);
			textF2.setText("Hasta "+steps[4]);
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
