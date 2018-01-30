package myProjectDatingApp;

import java.util.Comparator;

public class MatchedDatingInfo {
	
	private User user;
	private double matchingScore;
	
	public MatchedDatingInfo(User user,double matchingScore){
		this.user = user;
		this.matchingScore = matchingScore;
	}

	public double getMatchingScore() {
		return matchingScore;
	}

	public void setMatchingScore(float matchingScore) {
		this.matchingScore = matchingScore;
	}

	public User getUser() {
		return user;
	}

}
