package org.unioulu.tol.sqat2015.planetExplorer;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID: 143
// Finish time:
public class PlanetExplorer {
	String orientation;
	String currentLocation;
	int currX, currY;
	String currOrient;
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use:
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		
		currX = currY= 0;
		currOrient = "N";
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		for(int i=0; i<command.length();i++){
			move(command.charAt(i));
		}
		
		return currentLocation;
	}

	public String getLocation() {
		currentLocation = currX+","+currY+","+currOrient;
		currentLocation = "("+currentLocation+")";
		return currentLocation;
	}
	
	public void setLocation(int x,int y,String orient){
		currX = x; currY = y;
		currOrient = orient;
	}
	
	public void move(char c){
		switch(c){
		case 'f': 
			switch(orientation){
			case "N": setLocation(currX, currY+1, currOrient);
			case "S": setLocation(currX, currY-1, currOrient);
			case "E": setLocation(currX+1, currY, currOrient);
			case "W": setLocation(currX-1, currY, currOrient);
			}
		case 'b': 
			switch(orientation){
			case "N": setLocation(currX, currY-1, currOrient);
			case "S": setLocation(currX, currY+1, currOrient);
			case "E": setLocation(currX-1, currY, currOrient);
			case "W": setLocation(currX+1, currY, currOrient);
			}
		case 'l': 
			switch(orientation){
			case "N": setLocation(currX, currY, "W");
			case "S": setLocation(currX, currY, "E");
			case "E": setLocation(currX, currY, "N");
			case "W": setLocation(currX, currY, "S");
			}
		case 'r': 
			switch(orientation){
			case "N": setLocation(currX, currY, "E");
			case "S": setLocation(currX, currY, "W");
			case "E": setLocation(currX, currY, "S");
			case "W": setLocation(currX, currY, "N");
			}
		
		}
	}
}
