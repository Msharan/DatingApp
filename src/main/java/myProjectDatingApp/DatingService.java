package myProjectDatingApp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DatingService {
	
	private Map<String,List<User>> coordinatesToUserMap = new HashMap<String,List<User>>();
	private Map<String,User> userMap = new HashMap<String,User>();
	
	public void addUser(User newUser) {
		String baseCoordinates = newUser.getUserCoordinates().getBaseCoordinates();
		List<User> usersList;
		if(coordinatesToUserMap.containsKey(baseCoordinates)) {
			usersList = coordinatesToUserMap.get(baseCoordinates);
		} else {
			usersList = new ArrayList<User>();
		}
		usersList.add(newUser);
		coordinatesToUserMap.put(baseCoordinates, usersList);
		userMap.put(newUser.getUserName(), newUser);
	}
	
	public List<MatchedDatingInfo> findMatches(String personName, UserPreferences preferences) {
		if(userMap.containsKey(personName)) {
			User givenUser = userMap.get(personName);
			Set<User> matchedUserSet = getUsersBasedOnLocation(givenUser,preferences.getSelectedVicinity());
			List<MatchedDatingInfo> matchedDatingSet = sortBasedOnSimilarityScore(matchedUserSet,personName);
			return matchedDatingSet;
		} else {
			System.out.println("Given User is not in our system");
			return null;
		}
		
	}
	
	private Set<User> getUsersBasedOnLocation(User person,Vicinity selectedVicinity) {
		Set<User> userSetBasedOnLocation = new HashSet<User>();
		String baseCoordinates = person.getUserCoordinates().getBaseCoordinates();
		List<User> filteredUsers = new ArrayList<User>();
		switch(selectedVicinity) {
		case VERY_NEAR:
			filteredUsers = coordinatesToUserMap.get(baseCoordinates);
			break;
		case NEAR:
			List<String> nearCoordinates = person.getUserCoordinates().getNearCoordinates();
			for(String nearcoordinate : nearCoordinates) {
				if(coordinatesToUserMap.containsKey(nearcoordinate)) {
					filteredUsers.addAll(coordinatesToUserMap.get(nearcoordinate));
				}
			}
			break;
		case FURTHER_AWAY:
			List<String> furtherCoordinates = person.getUserCoordinates().getFurtherCoordinates();
			for(String furthercoordinate : furtherCoordinates) {
				if(coordinatesToUserMap.containsKey(furthercoordinate)) {
					filteredUsers.addAll(coordinatesToUserMap.get(furthercoordinate));
				}
			}
			break;
		}
		filteredUsers.remove(person);
		userSetBasedOnLocation.addAll(filteredUsers);
		return userSetBasedOnLocation;
	}
	
	private List<MatchedDatingInfo> sortBasedOnSimilarityScore(Set<User> matchedUserSet,String personName) {
		List<MatchedDatingInfo> potentialMatches = new ArrayList<MatchedDatingInfo>();
		User givenUser = userMap.get(personName);
		for(User user: matchedUserSet) {
			potentialMatches.add(new MatchedDatingInfo(user,calculateSimilarityScore(user,givenUser)));
		}
		potentialMatches.sort(new Comparator<MatchedDatingInfo>() {
			
			public int compare(MatchedDatingInfo o1, MatchedDatingInfo o2) {
				// TODO Auto-generated method stub
				double flag = o1.getMatchingScore() - o2.getMatchingScore();
		        if(flag < 0) return 1;
		        else if (flag > 0) return -1;
				return 0;
			}
			
		});
		return potentialMatches;
	}

	private double calculateSimilarityScore(User user,User givenUser) {
		Set<String> givenUserInterest = givenUser.getInterestList();
		Set<String> userInterest = user.getInterestList();
		Set<String> commonInterest = new HashSet<String>(givenUserInterest);
		commonInterest.retainAll(userInterest);
		return (commonInterest.size()*1.0)/givenUserInterest.size();
	}
}
