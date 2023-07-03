package com.kata.bowlinggame;

public class BowlingGame {

	private int[] rolls = new int[21]; // max number of rolls in a game
	private int currentRoll = 0;

	public int roll(int pins) {
		return rolls[currentRoll++] = pins;

	}

	public int score() {
		int totalScore = 0;
		int frameIndex = 0;

		for (int frame = 0; frame < 10; frame++) {
			if (rolls[frameIndex] == 10) { // Strike frame
				totalScore += 10 + rolls[frameIndex + 1] + rolls[frameIndex + 2];
				frameIndex++;
			} else if (rolls[frameIndex] + rolls[frameIndex + 1] == 10) { // Spare frame
				totalScore += 10 + rolls[frameIndex + 2];
				frameIndex += 2;
			} else {
				totalScore += rolls[frameIndex] + rolls[frameIndex + 1];
				frameIndex += 2;
			}
		}
		return totalScore;
	}

}
