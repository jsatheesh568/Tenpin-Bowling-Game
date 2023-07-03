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
		int expectedPins = strike();
		int rollResult = bowlingGame.roll(expectedPins); // Store the return value in a variable
		assertEquals(expectedPins, rollResult);
	}

	private int spare() {
		int firstRoll = bowlingGame.roll(5);
		int secondRoll = bowlingGame.roll(5);
		return firstRoll + secondRoll;
	}

	private int strike() {
		return bowlingGame.roll(10);
	}

	@Test
	public void testRollSpare() {
		int expectedScore = spare(); // The expected score for rolling a spare
		int actualScore = bowlingGame.score();
		assertEquals(expectedScore, actualScore);
	}

	@Test
	public void testGutterGame() {
		rollMany(20, 0);
		assertEquals(0, bowlingGame.score());
	}

	@Test
	public void testOneSpare() {
		spare();
		bowlingGame.roll(3);
		rollMany(17, 0);
		assertEquals(16, bowlingGame.score());
	}

	@Test
	public void testOneStrike() {
		strike();
		bowlingGame.roll(3);
		bowlingGame.roll(4);
		rollMany(16, 0);
		assertEquals(24, bowlingGame.score());
	}

	@Test
	public void testPerfectGame() {
		rollMany(12, 10);
		assertEquals(300, bowlingGame.score());
	}

	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++) {
			bowlingGame.roll(pins);
		}

	}

}
