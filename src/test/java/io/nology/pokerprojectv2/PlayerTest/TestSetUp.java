package io.nology.pokerprojectv2.PlayerTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import io.nology.pokerprojectv2.Card;
import io.nology.pokerprojectv2.Player;
import io.nology.pokerprojectv2.Suit;

public class TestSetUp {

	@Test
	public void SetUpPlayer1() {
//		given
		String[] lineUp = { "2C", "2S", "TC", "9H", "5D" };
		HashMap<Character, Integer> cardValues = Card.cardValues();
//		when
		ArrayList<Object[]> result = Player.setUp(lineUp, cardValues);
//		then
		Object[] first = { 'T', Suit.CLUBS, 10 };
		Object[] second = { '9', Suit.HEARTS, 9 };
		Object[] third = { '5', Suit.DIAMONDS, 5 };
		Object[] fourth = { '2', Suit.CLUBS, 2 };
		Object[] fifth = { '2', Suit.SPADES, 2 };

		assertThat(result).contains(first,second,third,fourth,fifth);
	}

	@Test
	public void SetUpPlayer2() {
//		given
		String[] lineUp = { "2H", "AS", "TD", "2D", "6C" };
		HashMap<Character, Integer> cardValues = Card.cardValues();
//		when
		ArrayList<Object[]> result = Player.setUp(lineUp, cardValues);
//		then
		Object[] first = { 'A', Suit.SPADES, 14 };
		Object[] second = { 'T', Suit.DIAMONDS, 10 };
		Object[] third = { '6', Suit.CLUBS, 6 };
		Object[] fourth = { '2', Suit.HEARTS, 2 };
		Object[] fifth = { '2', Suit.DIAMONDS, 2 };
		
		assertThat(result).contains(first,second,third,fourth,fifth);
	}

}
