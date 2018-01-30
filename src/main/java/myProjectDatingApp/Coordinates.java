package myProjectDatingApp;

import java.util.ArrayList;
import java.util.List;

public class Coordinates {
	
	private int x_coordinate;
	private int y_coordinate;
	
	public Coordinates(int x, int y) {
		this.x_coordinate = x;
		this.y_coordinate = y;
	}
	
	public int getX_coordinate() {
		return x_coordinate;
	}

	public int getY_coordinate() {
		return y_coordinate;
	}
	
	public String getBaseCoordinates(){
		int baseXCoordinate = (x_coordinate/10) *10;
		int baseYCoordinate = (y_coordinate/10) *10;
		return buildStringCoordinates(baseXCoordinate, baseYCoordinate);
	}

	public List<String> getNearCoordinates() {
		List<String> nearCoordinates = new ArrayList<String>();
		int baseXCoordinate = (x_coordinate/10) *10;
		int baseYCoordinate = (y_coordinate/10) *10;
		int xcoordinateMinus1 = baseXCoordinate > 0 ? baseXCoordinate - 10 : -1;
		int ycoordinateMinus1 = baseYCoordinate > 0 ? baseYCoordinate - 10 : -1;
		int xcoordinatePlus1 = baseXCoordinate + 10;
		int ycoordinatePlus1 = baseYCoordinate + 10;
		int xArray[] = {xcoordinateMinus1,baseXCoordinate,xcoordinatePlus1};
		int yArray[] = {ycoordinateMinus1,baseYCoordinate,ycoordinatePlus1};
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(buildStringCoordinates(xArray[i],yArray[j]) != "") {
					nearCoordinates.add(buildStringCoordinates(xArray[i],yArray[j]));
				}
			}
		}
		return nearCoordinates;
	}
	
	public List<String> getFurtherCoordinates() {
		List<String> furtherCoordinates = new ArrayList<String>();
		int baseXCoordinate = (x_coordinate/10) *10;
		int baseYCoordinate = (y_coordinate/10) *10;
		int xcoordinateMinus1 = baseXCoordinate > 0 ? baseXCoordinate - 10 : -1;
		int ycoordinateMinus1 = baseYCoordinate > 0 ? baseYCoordinate - 10 : -1;
		int xcoordinateMinus2 = xcoordinateMinus1 > 0 ? xcoordinateMinus1 - 10 : -1;
		int ycoordinateMinus2 = ycoordinateMinus1 > 0 ? ycoordinateMinus1 - 10 : -1;
		int xcoordinatePlus1 = baseXCoordinate + 10;
		int ycoordinatePlus1 = baseYCoordinate + 10;
		int xcoordinatePlus2 = xcoordinatePlus1 + 10;
		int ycoordinatePlus2 = ycoordinatePlus1 + 10;
		int xArray[] = {xcoordinateMinus2,xcoordinateMinus1,baseXCoordinate,xcoordinatePlus1,xcoordinatePlus2};
		int yArray[] = {ycoordinateMinus2,ycoordinateMinus1,baseYCoordinate,ycoordinatePlus1,ycoordinatePlus2};
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(buildStringCoordinates(xArray[i],yArray[j]) != "") {
					furtherCoordinates.add(buildStringCoordinates(xArray[i],yArray[j]));
				}
			}
		}
		//furtherCoordinates.remove(getBaseCoordinates());
		return furtherCoordinates;
	}
	
	public String buildStringCoordinates(int x, int y) {
		if(x != -1 && y != -1) {
			return x + "_" + y;
		} else {
			return "";
		}
	}

}
