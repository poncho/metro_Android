package com.example.metro;

public class Station {
	String name;
	int time;
	int[] lines;
	
	public Station(String n, int t, int[] l){
		name = n;
		time = t;
		lines = l;
	}
	
	//Checa si una linea existe dentro del arreglo de lineas de esa estacion
	public boolean exists(int line){
		for(int i=0; i<lines.length;i++){
			if(lines[i] == line){
				return true;
			}
		}
		return false;
	}
}
