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
	
	@Test
	public void testRollSpare() {
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.roll(5);
		bowlingGame.roll(5);
	    int expectedScore = 10; // The expected score for rolling a spare
	    int actualScore = bowlingGame.score();
	    assertEquals(expectedScore, actualScore);
	}

}
