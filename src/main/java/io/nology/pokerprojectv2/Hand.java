package io.nology.pokerprojectv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Hand {
	
	public static HashMap<Integer, String> pokerRank() {
		HashMap<Integer, String> pokerRank = new HashMap<>();
		
		pokerRank.put(0, "Royal Flush");
		pokerRank.put(1, "Straight Flush");
		pokerRank.put(2, "Four of a Kind");
		pokerRank.put(3, "Full House");
		pokerRank.put(4, "Flush");
		pokerRank.put(5, "Straight");
		pokerRank.put(6, "Three of a Kind");
		pokerRank.put(7, "Two Pair");
		pokerRank.put(8, "Pair");
		pokerRank.put(9, "High Card");
		
		return pokerRank;
	}
	

public static ArrayList<ArrayList<Object[]>> findCombo (ArrayList<Object[]> lineUp, HashMap<Character, Integer> cardValues) {
    	

    	ArrayList<Object[]> dupeList =  findDupes(lineUp, cardValues);
    	
    	ArrayList<Object[]> singleList = findKinds(dupeList, 1);
    	ArrayList<Object[]> pairList = findKinds(dupeList, 2);
    	ArrayList<Object[]> tripList = findKinds(dupeList, 3);
    	ArrayList<Object[]> quadList = findKinds(dupeList, 4);
    	
    	ArrayList<Object[]> highCard = findTopDupe(singleList);
    	ArrayList<Object[]> pair = findTopDupe(pairList);
    	ArrayList<Object[]> trip = findTopDupe(tripList);
    	ArrayList<Object[]> quad = findTopDupe(quadList);
    	
    	ArrayList<Object[]> twoPair = findTwoPair(pairList);
    	ArrayList<Object[]> straight = findStraight(lineUp);
    	ArrayList<Object[]> flush = findFlush(lineUp);
    	ArrayList<Object[]> fullHouse = findFullHouse(trip, pair);
    	ArrayList<Object[]> straightFlush = findStraight(flush);
    	ArrayList<Object[]> royalFlush = findRoyalFlush(straightFlush);
    	
    	ArrayList<ArrayList<Object[]>> allHands = new ArrayList<>();
    	
    	allHands.add(royalFlush);
    	allHands.add(straightFlush);
    	allHands.add(quad);
    	allHands.add(fullHouse);
    	allHands.add(flush);
    	allHands.add(straight);
    	allHands.add(trip);
    	allHands.add(twoPair);
    	allHands.add(pair);
    	allHands.add(highCard);
    	
    	return allHands;
    }
	
	public static ArrayList<Object[]> findDupes(ArrayList<Object[]> lineUp, HashMap<Character, Integer> cardValues) {
		
		HashMap<Object, Integer> dupeCounter = new HashMap<>();
		ArrayList<Object[]> dupeArr = new ArrayList<>();
		
		Integer count;
		
		for (Object[] card : lineUp) {
			if(dupeCounter.get(card[0]) == null) {
				dupeCounter.put(card[0], 0);
			}
			if(dupeCounter.get(card[0]) != null) {
				count = dupeCounter.get(card[0]) + 1;
				dupeCounter.put(card[0],count);
			}
		}
		
		for (int i = 0; i < dupeCounter.size(); i++) {
			Character value = (Character) dupeCounter.keySet().toArray()[i];
			Integer dupeCount = (Integer) dupeCounter.values().toArray()[i];
			Integer realValue = cardValues.get(value);
			
			Object[] dupeDataSet = {value, dupeCount, realValue};
			dupeArr.add(dupeDataSet);
		}
		
		Collections.sort(dupeArr, new Comparator<Object[]>() {
	
			public int compare(Object[] a, Object[] b) {
				return ((Integer) b[2]).compareTo((Integer) a[2]);
			}
		});
		
		return dupeArr;
	}

	public static ArrayList<Object[]> findKinds(ArrayList<Object[]> dupeList, Integer numberOfKind) {
		
		ArrayList<Object[]> kindList = new ArrayList<Object[]>();
		
		for (Object[] card : dupeList) {
			if(card[1] == numberOfKind) {
				kindList.add(card);
			}
		}
		return kindList;
	}
	
	public static ArrayList<Object[]> findTopDupe (ArrayList<Object[]> dupeList) {
		ArrayList<Object[]> topDupe = new ArrayList<>();
		
		if (dupeList.size() == 0) return null;
		
	
		if ((Integer)dupeList.get(0)[1] == 1) return dupeList;
		
		topDupe.add(dupeList.get(0));
		
		return topDupe;
	};
	
	public static ArrayList<Object[]> findTwoPair (ArrayList<Object[]> pairList) {
		ArrayList<Object[]> twoPair = new ArrayList<>();
		
		if (pairList.size() < 2) return null;
				
		twoPair.add(pairList.get(0));
		twoPair.add(pairList.get(1));
		
		return twoPair;
	}
	
	public static ArrayList<Object[]> findStraight (ArrayList<Object[]> lineUp) {
		
		if(lineUp == null) return null;
		
		Integer count = 1;
		
		for (int i = 0; i < lineUp.size() - 1; i++) {
			
			Integer current = (Integer) lineUp.get(i)[2];
			Integer nextPlusOne = (Integer) lineUp.get(i + 1)[2] + 1;
			
			if(current == nextPlusOne) {
				count += 1;
			}
			
		}
		
		if (count != 5) return null; 
		
		return lineUp;
	}
	
	public static ArrayList<Object[]> findFlush(ArrayList<Object[]> lineUp) {
		
		Integer count = 1;
		
		for (int i = 0; i < lineUp.size() - 1; i++) {
			
			
			if(lineUp.get(i)[1] == lineUp.get(i+1)[1]) {
				count += 1;
			}
			
		}
		
		if (count != 5) return null; 
		
		return lineUp;
	}
	
	public static ArrayList<Object[]> findFullHouse(ArrayList<Object[]> topTrip, ArrayList<Object[]> topPair) {
		ArrayList<Object[]> fullHouse = new ArrayList<>();
		if (topTrip == null || topPair == null) return null;
		
		fullHouse.add(topTrip.get(0));
		fullHouse.add(topPair.get(0));
		
		return fullHouse;
	}
	
	public static ArrayList<Object[]> findRoyalFlush(ArrayList<Object[]> straightFlush) {
		
		if(straightFlush == null) return null;
		
		if ((Integer) straightFlush.get(0)[2] == 14) return straightFlush;
		
		return null;
	}
	
	public static Integer findRankIndex (ArrayList<ArrayList<Object[]>> allHands){
		
		Integer rankIndex = 0;
		
		for (ArrayList<Object[]> hand : allHands) {
			if(hand != null) {
				rankIndex = allHands.indexOf(hand);
				break;
			}
		}
		
		return rankIndex;
	}
	
	public static ArrayList<ArrayList<Object[]>> findOnlyHands (ArrayList<ArrayList<Object[]>> allHands) {
		ArrayList<ArrayList<Object[]>> onlyHands = new ArrayList<>();
		
		for (int i = 0; i < allHands.size(); i++) {
			
			if(allHands.get(i) != null) onlyHands.add(allHands.get(i));
		}
		return onlyHands;
	}

}
