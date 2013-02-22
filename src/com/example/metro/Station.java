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
}
