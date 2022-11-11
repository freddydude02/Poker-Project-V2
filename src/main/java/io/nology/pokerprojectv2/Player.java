package io.nology.pokerprojectv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Player {
	
	public static String[] splitTotal (Integer startIndex, Integer setDecrement, String[] total) {
		String[] splitTotal = new String[5];
		for(int i = startIndex; i < startIndex + 5; i++) {
			splitTotal[i - setDecrement] = total[i];
		}
		
		return splitTotal;
	}
	
	public static ArrayList<Object[]> setUp(String[] lineUp, HashMap<Character, Integer> cardValues) {
    	

    	ArrayList<Object[]> lineUpList = new ArrayList<>();
   
    	Character value;
    	Character suit;
    	Integer realValue; 	
    	
    	for(int i = 0; i < lineUp.length; i++) {
    		value = lineUp[i].charAt(0);
    		suit = lineUp[i].charAt(1);
    		realValue = cardValues.get(value);
    		Object[] card = {value, suit, realValue};
    		lineUpList.add(i,card);
    	}	
    	
    	Collections.sort(lineUpList, new Comparator<Object[]>() {

			public int compare(Object[] a, Object[] b) {
				return ((Integer) b[2]).compareTo((Integer) a[2]);
			}
    		
    	});

    	return lineUpList;
    }
	
//	public static HashMap<String, Integer> winsNLosses() {
//		
//		HashMap<String, Integer> winsNLosses = new HashMap<>();
//		
//		winsNLosses.put("Player1", 0);
//		winsNLosses.put("Player2", 0);
//		
//		return winsNLosses;
//	}
	
}
