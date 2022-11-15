package io.nology.pokerprojectv2;

import java.util.ArrayList;
import java.util.Arrays;
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
    	Character suitC;
    	Suit suit = Suit.NOTDETERMINED;
    	Integer realValue; 	
    	
    	for(int i = 0; i < lineUp.length; i++) {
    		value = lineUp[i].charAt(0);
    		suitC = lineUp[i].charAt(1);
    		if (suitC == 'D') suit = Suit.DIAMONDS;
    		if (suitC == 'C') suit = Suit.CLUBS;
    		if (suitC == 'S') suit = Suit.SPADES;
    		if (suitC == 'H') suit = Suit.HEARTS;
    		realValue = cardValues.get(value);
    		Object[] card = {value, suit, realValue};
    		lineUpList.add(i,card);
    	}	
    	
    	Collections.sort(lineUpList, new Comparator<Object[]>() {

			public int compare(Object[] a, Object[] b) {
				return ((Integer) b[2]).compareTo((Integer) a[2]);
			}
    		
    	});
    	
    	System.out.println(Arrays.toString(lineUpList.get(0)));
    	return lineUpList;
    }
	
public static String findError(String[] total, HashMap<Character, Integer> cardValues) {
    	
    	if (total.length != 10) return "There must be 10 entries when there are currently " + total.length + " entries";
    	
    	int i = 0;
    	for (String card : total) {
    		if (cardValues.get(card.charAt(0)) == null) {
    			return card.charAt(0) + " is an invalid value";
    		}
    		
    		if (card.charAt(1) != 'S' &&
    				card.charAt(1) != 'H' &&
    				card.charAt(1) != 'C' &&
    				card.charAt(1) != 'D' ) {
    			return card.charAt(1) + " is an invalid suit";
    		}
    		
    		for (int x = i + 1 ; x < total.length; x++) {
    			
    			if (card == total[x]) {
    				return card + " is a duplicate card";
    			}
    		}
    		i++;
    	}
    	return "GO";
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
