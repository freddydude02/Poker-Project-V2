package io.nology.pokerprojectv2.handtest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import io.nology.pokerprojectv2.Card;
import io.nology.pokerprojectv2.Hand;
import io.nology.pokerprojectv2.Suit;

public class testFindDupes {

	@Test
	public void testFindDupes() {
//		given
		HashMap<Character, Integer> cardValues = Card.cardValues();
		ArrayList<Object[]> sortedLineUp = new ArrayList<>();
		Object[] first = { 'T', Suit.CLUBS, 10 };
		Object[] second = { '9', Suit.HEARTS, 9 };
		Object[] third = { '5', Suit.DIAMONDS, 5 };
		Object[] fourth = { '2', Suit.CLUBS, 2 };
		Object[] fifth = { '2', Suit.SPADES, 2 };
		sortedLineUp.add(first);
		sortedLineUp.add(second);
		sortedLineUp.add(third);
		sortedLineUp.add(fourth);
		sortedLineUp.add(fifth);
//		when
		ArrayList<Object[]> result = Hand.findDupes(sortedLineUp, cardValues);
//		then
		assertThat(result).contains(fourth, fifth);

	}

}
