package com.malabanan.localeventuring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchAlg {

	public static String getQueryString(String[] filters){
		String queryString = "FROM Venue ";
		ArrayList<String> filtered = new ArrayList<String>();
		
		Map<String, String> map = createMap();
				
		for(String filter: filters){
			if(filter.equals("")){
				continue;
			}else{
				String fil = map.get(filter);
				filtered.add(fil);
			}
		}
		
		if(filtered.size() == 0){
			return queryString;
		}
		
		if(filters.length > 0){
			queryString += " Where ";
		}

		
		for(int i=0; i<filtered.size(); i++){
			if(i==0){
				queryString += filtered.get(0);
			}else{
				queryString = queryString + " and " + filtered.get(i);
			}	
		}	
		return queryString;
	}
	
	
	private static Map<String,String> createMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", " (price < 50) ");
		map.put("2", " (price < 100 and price >= 50) ");
		map.put("3", " (price < 150 and price >= 100 ) ");
		map.put("4", " (price < 200 and price >= 150 ) ");
		map.put("5", " (price > 199.99 ) ");
		map.put("6", " (capacity <= 15 ) ");
		map.put("7", " (capacity <= 30 and capacity > 15 ) ");
		map.put("8", " (capacity <= 45 and capacity > 30 ) ");
		map.put("9", " (capacity <= 60 and capacity > 45 ) ");
		map.put("10", " (capacity >= 60 ) ");
		map.put("11", "");
		map.put("12", "");
		map.put("13", "");
		map.put("14", "");
		map.put("15", "");
		return map;
	}
}
