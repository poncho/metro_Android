package com.example.metro;

import android.os.Bundle;
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
		
		TextView textE1 = (TextView)findViewById(R.id.textE1);
		TextView textE2 = (TextView)findViewById(R.id.textE2);
		TextView textE3 = (TextView)findViewById(R.id.textE3);
		TextView color1 = (TextView)findViewById(R.id.color1);
		
		//Gets 
		Bundle extras = intent.getExtras();
		int stepSize = extras.getInt("SIZE");
		int line = extras.getInt("LINE");
		//Creates array of variables
		//Steps
		for(int i=0; i<stepSize; i++){
			steps[i] = extras.getString("ESTACION" + i);
		}
		
		/*//Color
		for(int i=0; i<3; i++){
			try {
				line[i] = extras.getInt("LINE" + i);
			}
			catch (Exception e){
				break;
			}
		}*/
		
		setColor(color1, line);
		textE1.setText(steps[0]);
		textE2.setText(steps[1]);
		textE3.setText(steps[2]);
	}
	
	//Pasa el color de la línea
	void setColor(TextView color, int line){
		switch (line) {
		case 1:
			color.setBackgroundColor(Color.rgb(238,98,158));
			break;
		case 2:
			color.setBackgroundColor(Color.BLUE);
			break;
		case 3:
			color.setBackgroundColor(Color.rgb(67,202,5));
			break;
		case 4:
			color.setBackgroundColor(Color.CYAN);
			break;
		case 5:
			color.setBackgroundColor(Color.YELLOW);
			break;
		case 6:
			color.setBackgroundColor(Color.RED);
			break;
		case 7:
			color.setBackgroundColor(Color.rgb(215,79,21));
			break;
		case 8:
			color.setBackgroundColor(Color.rgb(43,126,79));
			break;
		case 9:
			color.setBackgroundColor(Color.rgb(54,26,21));
			break;
		case 10:
			color.setBackgroundColor(Color.rgb(163,41,122));
			break;
		case 11:
			color.setBackgroundColor(Color.GRAY);
			break;
		case 12:
			color.setBackgroundColor(Color.rgb(174,148,1));
			break;
			
		default:
			color.setBackgroundColor(Color.BLACK);
			break;
		}
	}
}
