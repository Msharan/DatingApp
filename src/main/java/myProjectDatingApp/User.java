package myProjectDatingApp;

import java.util.Set;

public class User {
	
	private String userName;
	private Coordinates userCoordinates;
	private Set<String> interestList;
	
	public User(String userName,Coordinates userCoordinates, Set<String> interests) {
		this.userName = userName;
		this.userCoordinates = userCoordinates;
		this.interestList = interests;
	}

	public String getUserName() {
		return userName;
	}

	public Set<String> getInterestList() {
		return interestList;
	}

	public Coordinates getUserCoordinates() {
		return userCoordinates;
	}	
}
