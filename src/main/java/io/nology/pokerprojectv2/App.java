package io.nology.pokerprojectv2;

import java.io.File;
import java.io.FileNotFoundException;
/**
 * Hello world!
 *
 */
import java.util.*;


public class App {
	
    public static void main( String[] args ) throws FileNotFoundException {
    	
    	File file = new File("/Users/frede/eclipse-workspace/pokerprojectv2/poker-hands.txt");
    	
    	Scanner sc = new Scanner(file);
    	
    	HashMap<String, Integer> winsNLosses = new HashMap<>();
    	
    	winsNLosses.put("Player1", 0);
    	winsNLosses.put("Player2", 0);
    	
    	while(sc.hasNextLine()) {
    		String[] total = sc.nextLine().split(" ",0);
//        	System.out.println(Arrays.toString(total));    	
//    		String[] total = {"2H", "AS", "TD", "2D", "6C", "2C", "2S", "TC", "9H", "5D"};
        	
        	String test = Player.findError(total, Card.cardValues());
        	
        	if(test == "GO") {
        		
        		String[] p1 = Player.splitTotal(0, 0, total);
        		String[] p2 = Player.splitTotal(5, 5, total);
        		
        		ArrayList<Object[]> p1ReadyDataSet = Player.setUp(p1, Card.cardValues());
        		ArrayList<Object[]> p2ReadyDataSet = Player.setUp(p2, Card.cardValues());
        		
        		String winner = determineWinner(p1ReadyDataSet, p2ReadyDataSet, Card.cardValues(), Hand.pokerRank(), winsNLosses, p1, p2);
        		
        		System.out.println(winner);
        		System.out.println(Arrays.toString(p1) + " P1 " + winsNLosses.get("Player1"));
        		System.out.println(Arrays.toString(p2) + " P2 " + winsNLosses.get("Player2"));
        		
        	} else System.out.println(test);
        }
    	
    }

    
    
    public static String determineWinner 
    (ArrayList<Object[]> p1ReadyDataSet, ArrayList<Object[]> p2ReadyDataSet, HashMap<Character, Integer> cardValues,
    HashMap<Integer, String> pokerRank, HashMap<String, Integer> winsNLosses, String[] p1Hand, String[] p2Hand) {
    	
    	
    	ArrayList<ArrayList<Object[]>> p1AllHands = Hand.findCombo(p1ReadyDataSet, cardValues);
    	ArrayList<ArrayList<Object[]>> p2AllHands = Hand.findCombo(p2ReadyDataSet, cardValues);
    	
    	ArrayList<ArrayList<Object[]>> p1OnlyHands = Hand.findOnlyHands(p1AllHands);
    	ArrayList<ArrayList<Object[]>> p2OnlyHands = Hand.findOnlyHands(p2AllHands);

		Integer p1Rank = Hand.findRankIndex(p1AllHands);
		Integer p2Rank = Hand.findRankIndex(p2AllHands);

		Integer p1currentScore = winsNLosses.get("Player1");
		Integer p2currentScore = winsNLosses.get("Player2");
		
		if (p1Rank < p2Rank) {
			winsNLosses.put("Player1", p1currentScore + 1);
			return announcement("Player 1", p1Rank, p1Hand, pokerRank, winsNLosses);
		}
		if (p1Rank > p2Rank) {
			winsNLosses.put("Player2", p2currentScore + 1);
			return announcement("Player 2", p2Rank, p2Hand, pokerRank, winsNLosses);
		}

		if (p1Rank == p2Rank) {
			
			for (int x = 0; x < p1OnlyHands.size(); x++) {
				ArrayList<Object[]> p1TopHand = p1OnlyHands.get(x);
		    	ArrayList<Object[]> p2TopHand = p2OnlyHands.get(x);
				
				for (int i = 0; i < p1TopHand.size(); i++) {
					
					Character p1TopFirstChar = (Character) p1TopHand.get(i)[0];
					Character p2TopFirstChar = (Character) p2TopHand.get(i)[0];
					
					if (cardValues.get(p1TopFirstChar) > cardValues.get(p2TopFirstChar)) {
						winsNLosses.put("Player1", p1currentScore + 1);
						return announcement("Player 1", p1Rank, p1Hand, pokerRank, winsNLosses);
					}
					
					if (cardValues.get(p1TopFirstChar) < cardValues.get(p2TopFirstChar)) {
						winsNLosses.put("Player2", p2currentScore + 1);
						return announcement("Player 2", p2Rank, p2Hand, pokerRank, winsNLosses);
					}
				}
			}
			
		}
    	return "\n" + "Tie" + "\n";
    }
    

	public static String announcement 
    (String winningPlayerName, Integer playerRank, String[] hand, HashMap<Integer, String> pokerRank, HashMap<String, Integer> winsNLosses ) {
    	return winningPlayerName + " wins with " + pokerRank.get(playerRank) + ". Their hand is " + Arrays.toString(hand) ;
    }
}

