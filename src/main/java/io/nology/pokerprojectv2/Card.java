package io.nology.pokerprojectv2;

import java.util.HashMap;

public class Card {
	public Character value;
	public Suit suit;
	public Integer dupeCount;
	public Integer realValue;
	
	public static HashMap<Character, Integer> cardValues () {
		HashMap<Character, Integer> cardValues = new HashMap<>();
		
		cardValues.put('2',2);
		cardValues.put('3',3);
		cardValues.put('4',4);
		cardValues.put('5',5);
		cardValues.put('6',6);
		cardValues.put('7',7);
		cardValues.put('8',8);
		cardValues.put('9',9);
		cardValues.put('T',10);
		cardValues.put('J',11);
		cardValues.put('Q',12);
		cardValues.put('K',13);
		cardValues.put('A',14);
		
		return cardValues;
	}
}
