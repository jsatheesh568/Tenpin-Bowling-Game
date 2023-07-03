package com.kata.bowlinggame;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
	
	@Test
	public void testRollStrike() {
	    BowlingGame bowlingGame = new BowlingGame();
	    int pins = 10;
	    int rollResult = bowlingGame.roll(pins); // Store the return value in a variable
	    assertEquals(pins, rollResult);
	}

}
