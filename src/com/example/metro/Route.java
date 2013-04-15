package com.example.metro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.metro.TimeFuncs;

public class Route {
	public String e1;
	public String e2;
	public Integer[] ls1;
	public Integer[] ls2;
	public Integer[] time;
	public String[] steps;
	public int line;
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
		
		System.out.println("SEGUNDO");
		
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
					r.line = r.ls1[i]; //Color passed
					r.steps = new String[]{r.e1, direction(r.e1, r.e2, l), r.e2};
					r.time = new TimeFuncs().calcTime(r.e1, r.e2, l);
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean one_transb(Route r){
		for(int i=0; i<r.ls2.length; i++){
			ArrayList<Station> l2 = return_line(r.ls2[i]);
			for(int j=0; j<ls1.length; i++){
				ArrayList<Station> l1 = return_line(r.ls1[i]);
				for(int k=0; k<l2.size();k++){
					if(l1.get(k).lines != null && l1.get(k).exists(r.ls2[i])){
						r.time = new Integer[]{1};
					}
				}
			}
		}
		return true;
	}

	public void two_transb(Route r){
	
	}
	
	//Obtiene la direccion a la que tomar el metro
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
	
	//Regresa el arreglo total de la linea
	public ArrayList<Station> return_line(Integer line){
		ArrayList<Station> lineList = new ArrayList<Station>();
		if (line == 1){
			lineList.add(new Station("Observatorio", 0, null));
			lineList.add(new Station("Tacubaya", 108, new int[]{7,9}));
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
			lineList.add(new Station("Candelaria", 65, new int[]{4}));
			lineList.add(new Station("San Lazaro", 78, new int[]{11}));
			lineList.add(new Station("Moctezuma", 48, null));
			lineList.add(new Station("Balbuena", 65, null));
			lineList.add(new Station("Boulevard Puerto Aereo", 57, null));
			lineList.add(new Station("Gomez Farias", 58, null));
			lineList.add(new Station("Zaragoza", 70, null));
			lineList.add(new Station("Pantitlan", 113, new int[]{5,9,10}));
		}
		
		if (line == 2){
			lineList.add(new Station("Cuatro Caminos", 0, null));
			lineList.add(new Station("Panteones", 108, null));
			lineList.add(new Station("Tacuba", 100, new int[]{7}));
			lineList.add(new Station("Cuitlahuac", 86, null));
			lineList.add(new Station("Popotla", 50, null));
			lineList.add(new Station("Colegio Militar", 61, null));
			lineList.add(new Station("Normal", 72, null));
			lineList.add(new Station("San Cosme", 43, null));
			lineList.add(new Station("Revolucion", 47, null));
			lineList.add(new Station("Hidalgo", 46, new int[]{3}));
			lineList.add(new Station("Bellas Artes", 41, new int[]{8}));
			lineList.add(new Station("Allende", 69, null));
			lineList.add(new Station("Zocalo", 65, null));
			lineList.add(new Station("Pino Suarez", 78, new int[]{1}));
			lineList.add(new Station("San Antonio Abad", 48, null));
			lineList.add(new Station("Chabacano", 65, new int[]{8,9}));
			lineList.add(new Station("Viaducto", 57, null));
			lineList.add(new Station("Xola", 58, null));
			lineList.add(new Station("Villa de Cortes", 70, null));
			lineList.add(new Station("Nativitas", 113, null));
			lineList.add(new Station("Portales", 113, null));
			lineList.add(new Station("Ermita", 113, new int[]{12}));
			lineList.add(new Station("General Anaya", 113, null));
			lineList.add(new Station("Tasqueña", 113, null));
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
			stations.put("Salto del Agua", new Integer[]{1, 8});
			stations.put("Isabel la Catolica", new Integer[]{1});
			stations.put("Pino Suarez", new Integer[]{1, 2});
			stations.put("Merced", new Integer[]{1});
			stations.put("Candelaria", new Integer[]{1, 4});
			stations.put("San Lazaro", new Integer[]{1, 11});
			stations.put("Moctezuma", new Integer[]{1});
			stations.put("Balbuena", new Integer[]{1});
			stations.put("Boulevard Puerto Aereo", new Integer[]{1});
			stations.put("Gomez Farias", new Integer[]{1});
			stations.put("Zaragoza", new Integer[]{1});
			stations.put("Pantitlan", new Integer[]{1, 5, 9, 10});
			
			//INCOMPLETO
			
			return stations.get(s);
		}
}
