package com.example.metro;

import java.util.ArrayList;

public class TimeFuncs {
	int loss_time = 15;
	int time = 0;
	boolean first_station = false;
	
	public Integer[] calcTime(String e1, String e2, ArrayList<Station> l){
		for(int i=0; i<l.size(); i++){
			if(first_station == false){
				if(l.get(i).name.equals(e1) || l.get(i).name.equals(e2)){
					
				}
			}
		}
		
		return null;
	}
}
