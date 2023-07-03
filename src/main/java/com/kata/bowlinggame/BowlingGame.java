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
			if (isStrike(frameIndex)) {
				totalScore += 10 + strikeBonus(frameIndex);
				frameIndex++;
			} else if (isSpare(frameIndex)) {
				totalScore += 10 + spareBonus(frameIndex);
				frameIndex += 2;
			} else {
				totalScore += sumOfPinsInFrame(frameIndex);
				frameIndex += 2;
			}
		}

		return totalScore;
	}

	private boolean isStrike(int frameIndex) {
		return rolls[frameIndex] == 10;
	}

	private boolean isSpare(int frameIndex) {
		return sumOfPinsInFrame(frameIndex) == 10;
	}

	private int sumOfPinsInFrame(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex + 1];
	}

	private int spareBonus(int frameIndex) {
		return rolls[frameIndex + 2];
	}

	private int strikeBonus(int frameIndex) {
		return rolls[frameIndex + 1] + rolls[frameIndex + 2];
	}

}
