package com.kata.bowlinggame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
	
	private BowlingGame bowlingGame;
	@Before
	public void setUp() {
		  bowlingGame = new BowlingGame();
	}
	
	@Test
	public void testRollStrike() {	   
	    int pins = 10;
	    int rollResult = bowlingGame.roll(pins); // Store the return value in a variable
	    assertEquals(pins, rollResult);
	}
	
	@Test
	public void testRollSpare() {
		bowlingGame.roll(5);
		bowlingGame.roll(5);
	    int expectedScore = 10; // The expected score for rolling a spare
	    int actualScore = bowlingGame.score();
	    assertEquals(expectedScore, actualScore);
	}

}
