package com.kata.bowlinggame;

public class BowlingGame {

	private int[] rolls = new int[21]; // Array to store the number of pins knocked down in each roll
	private int currentRoll = 0;  // Index to keep track of the current roll

	public int roll(int pins) {
		return rolls[currentRoll++] = pins;

	}

	public int score() {
		int totalScore = 0;  // Variable to store the total score
		int frameIndex = 0;  // Index to iterate through the frames

		for (int frame = 0; frame < 10; frame++) {
			if (isStrike(frameIndex)) {
				// Calculate the score for a strike frame (all pins knocked down in one roll)
				totalScore += 10 + strikeBonus(frameIndex);
				frameIndex++;
			} else if (isSpare(frameIndex)) {
				// Calculate the score for a spare frame (all pins knocked down in two rolls)
				totalScore += 10 + spareBonus(frameIndex);
				frameIndex += 2;
			} else {
			      // Calculate the score for a normal frame (pins knocked down in two rolls)
				totalScore += sumOfPinsInFrame(frameIndex);
				frameIndex += 2;
			}
		}

		return totalScore;
	}

	private boolean isStrike(int frameIndex) {
		 // Check if a frame is a strike (all pins knocked down in one roll)
		return rolls[frameIndex] == 10;
	}

	private boolean isSpare(int frameIndex) {
		// Check if a frame is a spare (all pins knocked down in two rolls)
		return sumOfPinsInFrame(frameIndex) == 10;
	}

	private int sumOfPinsInFrame(int frameIndex) {
		 // Calculate the sum of pins knocked down in a frame
		return rolls[frameIndex] + rolls[frameIndex + 1];
	}

	private int spareBonus(int frameIndex) {
		 // Calculate the bonus for a spare frame (number of pins knocked down in the next roll)
		return rolls[frameIndex + 2];
	}

	private int strikeBonus(int frameIndex) {
		// Calculate the bonus for a strike frame (sum of pins knocked down in the next two rolls)
		return rolls[frameIndex + 1] + rolls[frameIndex + 2];
	}

}
