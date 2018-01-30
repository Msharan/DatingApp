package myProjectDatingApp;

import java.util.List;

public class UserPreferences {
	
	private Vicinity selectedVicinity;
	
	public UserPreferences(Vicinity selectedVicinity) {
		this.selectedVicinity = selectedVicinity;
	}
	public Vicinity getSelectedVicinity() {
		return selectedVicinity;
	}
}
