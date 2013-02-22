package com.example.metro;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.InputFilter.LengthFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

	public final static String ESTACION1 = "metro.e1";
	public final static String ESTACION2 = "metro.e2";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void findRoute(View v){
		Intent intent = new Intent(this, Rutas.class);
		EditText salida = (EditText)findViewById(R.id.salida);
		EditText llegada = (EditText)findViewById(R.id.llegada);
		
		String e1 = salida.getText().toString();
		String e2 = llegada.getText().toString();
		
		//Mensaje de error si no se eligen ambas estaciones
		if(e1.equals("") || e2.equals("")){
			Toast t = Toast.makeText(getApplicationContext(), R.string.empty, Toast.LENGTH_LONG);
			t.show();
			return;
		}
		
		//Se crea el objeto Ruta con las estaciones de inicio y fin
		Route route = new Route(e1, e2);
		route.choose_algorithm(route);
		
		//Se agregan las variables para mostrar en la actividad de muestra
		for (int i=0; i<route.steps.length;i++){
			intent.putExtra("ESTACION" + i, route.steps[i]);
		}
		intent.putExtra("SIZE", route.steps.length);
		startActivity(intent);
	}

}
