package io.nology.pokerprojectv2.PlayerTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.junit.Test;

import io.nology.pokerprojectv2.Card;
import io.nology.pokerprojectv2.Player;

public class TestFindError {

	@Test
	public void FindErrorReturnsOKifCorrect() {
//		given
		String[] total = {"2H", "AS", "TD", "2D", "6C", "2C", "2S", "TC", "9H", "5D"};
		HashMap<Character, Integer> cardValues = Card.cardValues();
//		when
		String result = Player.findError(total, cardValues);
//		then
		String expected = "GO";
		assertThat(result).isEqualTo(expected);
	}
	@Test
	public void FindErrorfindsInvalidValues() {
//		given
		String[] total = {"2H", "AS", "%D", "2D", "6C", "2C", "2S", "TC", "9H", "5D"};
		HashMap<Character, Integer> cardValues = Card.cardValues();
//		when
		String result = Player.findError(total, cardValues);
//		then
		String expected = "% is an invalid value";
		assertThat(result).isEqualTo(expected);
	}
	@Test
	public void FindErrorFindsInvalidSuits() {
//		given
		String[] total = {"2H", "AS", "TD", "2D", "6V", "2C", "2S", "TC", "9H", "5D"};
		HashMap<Character, Integer> cardValues = Card.cardValues();
//		when
		String result = Player.findError(total, cardValues);
//		then
		String expected = "V is an invalid suit";
		assertThat(result).isEqualTo(expected);
	}
	@Test
	public void FindErrorFindsDuplicateCards() {
//		given
		String[] total = {"2H", "AS", "TD", "2D", "6V", "2C", "2S", "2H", "9H", "5D"};
		HashMap<Character, Integer> cardValues = Card.cardValues();
//		when
		String result = Player.findError(total, cardValues);
//		then
		String expected = "2H is a duplicate card";
		assertThat(result).isEqualTo(expected);
	}

}
