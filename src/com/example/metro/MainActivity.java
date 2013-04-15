package com.example.metro;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

	String[] listaEstaciones;
	
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listaEstaciones = getResources().getStringArray(R.array.estaciones);
		
		ArrayAdapter<String> adapter = 
				new ArrayAdapter<String>
		(this, R.layout.lista_estacion, listaEstaciones);
		
		AutoCompleteTextView lista1 = 
				(AutoCompleteTextView)findViewById(R.id.salida);
				lista1.setThreshold(1);
				lista1.setAdapter(adapter);
		AutoCompleteTextView lista2 = 
				(AutoCompleteTextView)findViewById(R.id.llegada);
				lista2.setThreshold(1);
				lista2.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void findRoute(View v){
		Intent intent = new Intent(this, mostrarRutas.class);
		EditText salida = (EditText)findViewById(R.id.salida);
		EditText llegada = (EditText)findViewById(R.id.llegada);
		
		String e1 = salida.getText().toString();
		String e2 = llegada.getText().toString();
		
		//Mensaje de error si no se eligen ambas estaciones
		if(e1.equals("") || e2.equals("")){
			Toast t = Toast.makeText(getApplicationContext(), R.string.empty, Toast.LENGTH_LONG);
			t.show();
			return;
		} else if(e1.equals(e2)){
			Toast t = Toast.makeText(getApplicationContext(), R.string.sameSt, Toast.LENGTH_LONG);
			t.show();
			return;
		}
		
		//Se crea el objeto Ruta con las estaciones de inicio y fin
		Route route = new Route(e1, e2);
		
		//Se busca la solución
		route.choose_algorithm(route);
		
		//Se agregan las variables para mostrar en la actividad de muestra
		for (int i=0; i<route.steps.length;i++){
			intent.putExtra("ESTACION" + i, route.steps[i]);
		}
		intent.putExtra("LINE", route.line);
		intent.putExtra("SIZE", route.steps.length);
		startActivity(intent);
	}

}
