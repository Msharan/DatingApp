package myProjectDatingApp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DatingServiceTest {
	
	public static void main(String args[]) {
		DatingService datingServiceObj = new DatingService();
		datingServiceObj.addUser(new User("PersonA",new Coordinates(25,35),new HashSet<String>(Arrays.asList("a","b","c","d"))));
		datingServiceObj.addUser(new User("PersonB",new Coordinates(32,27),new HashSet<String>(Arrays.asList("e","f","g"))));
		datingServiceObj.addUser(new User("PersonC",new Coordinates(9,35),new HashSet<String>(Arrays.asList("a","c"))));
		datingServiceObj.addUser(new User("PersonD",new Coordinates(22,37),new HashSet<String>(Arrays.asList("e","h"))));
		datingServiceObj.addUser(new User("PersonE",new Coordinates(17,42),new HashSet<String>(Arrays.asList("a","d","c"))));
		datingServiceObj.addUser(new User("PersonF",new Coordinates(24,32),new HashSet<String>(Arrays.asList("a","c","h"))));
		UserPreferences preferences= new UserPreferences(Vicinity.FURTHER_AWAY);
		List<MatchedDatingInfo> matchedUsers = datingServiceObj.findMatches("PersonA", preferences);
		for(MatchedDatingInfo user : matchedUsers) {
			System.out.println(user.getUser().getUserName()+"  score : "+user.getMatchingScore());
		}
	}

}
