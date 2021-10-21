package com.api.normalPojoClasses;


//POJO class
public class Marks {
	int maxScore, currentScore;

	public Marks()
	{
		super();
	}
	public Marks(int maxScore, int currentScore) {
		super();
		this.maxScore = maxScore;
		this.currentScore = currentScore;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
	
	
}
