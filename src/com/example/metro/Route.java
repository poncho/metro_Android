package com.example.metro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.util.Log;

import com.example.metro.TimeFuncs;

public class Route {
	public String e1;
	public String e2;
	public Integer[] ls1;
	public Integer[] ls2;
	public Integer[] time;
	public String[] steps;
	public Boolean w;

	
	public Route(String StartE1, String StartE2){
		e1 = StartE1;
		e2 = StartE2;
		ls1 = get_station(e1);
		ls2 = get_station(e2);
		w = false;
	}
	
	public void choose_algorithm(Route r){
		
		//AGREGAR LO DE LA LINEA 12 con la A
		
		r.w = same_line(r);
		
		if(r.w == false){
			r.w = one_transb(r);
		}
		/*if (r.w == false){
			two_transb(r);
		} else {
			Route temp = new Route(r.e1, r.e2);
			two_transb(temp);
			if(temp.steps != null){
				
			}
		}*/
	}
	
	public boolean same_line(Route r){
		for(int i=0; i<r.ls1.length; i++){
			for(int j=0; j<r.ls2.length; j++){
				if(r.ls1[i] == r.ls2[j]){
					ArrayList<Station> l = return_line(r.ls1[i]);
					r.steps = new String[]{r.e1, direction(r.e1, r.e2, l), r.e2};
					r.time = new TimeFuncs().calcTime(r.e1, r.e2, l);
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean one_transb(Route r){
		return true;
	}

	public void two_transb(Route r){
	
	}
	
	public String direction(String e1, String e2, ArrayList<Station> l){
		for(int i=0; i<l.size(); i++){
			if(l.get(i).name.equals(e1)){
				return l.get(l.size()-1).name.toString();
			} else if(l.get(i).name.equals(e2)) {
				return l.get(0).name.toString();
			}
		}
		return null;
	}
	
	public ArrayList<Station> return_line(Integer line){
		ArrayList<Station> lineList = new ArrayList<Station>();
		if (line == 1){
					lineList.add(new Station("Observatorio", 0, null));
					lineList.add(new Station("Tacubaya", 108, new int[]{1,7,9}));
					lineList.add(new Station("Juanacatlan", 100, null));
					lineList.add(new Station("Chapultepec", 86, null));
					lineList.add(new Station("Sevilla", 50, null));
					lineList.add(new Station("Insurgentes", 61, null));
					lineList.add(new Station("Cuauhtemoc", 72, null));
					lineList.add(new Station("Balderas", 43, new int[]{3}));
					lineList.add(new Station("Salto del Agua", 47, new int[]{8}));
					lineList.add(new Station("Isabel la Catolica", 46, null));
					lineList.add(new Station("Pino Suarez", 41, new int[]{2}));
					lineList.add(new Station("Merced", 69, null));
					lineList.add(new Station("Candelaria", 65, new int[]{1}));
					lineList.add(new Station("San Lazaro", 78, new int[]{11}));
					lineList.add(new Station("Moctezuma", 48, null));
					lineList.add(new Station("Balbuena", 65, null));
					lineList.add(new Station("Boulevard Puerto Aereo", 57, null));
					lineList.add(new Station("Gomez Farias", 58, null));
					lineList.add(new Station("Zaragoza", 70, null));
					lineList.add(new Station("Pantitlan", 113, new int[]{5,9,10}));
		}
		return lineList;
	}
	
	//Regresa el arreglo del numero de lineas donde está la estación
	public Integer[] get_station(String s){
		Map<String, Integer[]> stations = new HashMap<String, Integer[]>();
			stations.put("Observatorio", new Integer[]{1});
			stations.put("Tacubaya", new Integer[]{1, 7, 9});
			stations.put("Juanacatlan", new Integer[]{1});
			stations.put("Chapultepec", new Integer[]{1});
			stations.put("Sevilla", new Integer[]{1});
			stations.put("Insurgentes", new Integer[]{1});
			stations.put("Cuauhtemoc", new Integer[]{1});
			stations.put("Balderas", new Integer[]{1, 3});
			//INCOMPLETO
			
			return stations.get(s);
		}
}
