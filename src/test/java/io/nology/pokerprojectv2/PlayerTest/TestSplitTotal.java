package io.nology.pokerprojectv2.PlayerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

import io.nology.pokerprojectv2.Player;

public class TestSplitTotal {

	@Test
	public void SplitTotalFirstHalf() {
//		given
		String[] total = {"2H", "AS", "TD", "2D", "6C", "2C", "2S", "TC", "9H", "5D"};
		Integer startIndex = 0;
		Integer setDecrement = 0;
//		when
		String[] result = Player.splitTotal(startIndex, setDecrement, total);
//		then
		String[] expected = {"2H", "AS", "TD", "2D", "6C"};
		
		assertThat(result).isEqualTo(expected);
	}
	
	@Test
	public void SplitTotalSecondHalf() {
//		given
		String[] total = {"2H", "AS", "TD", "2D", "6C", "2C", "2S", "TC", "9H", "5D"};
		Integer startIndex = 5;
		Integer setDecrement = 5;
//		when
		String[] result = Player.splitTotal(startIndex, setDecrement, total);
//		then
		String[] expected = {"2C", "2S", "TC", "9H", "5D"};
		
		assertThat(result).isEqualTo(expected);
	}


}
