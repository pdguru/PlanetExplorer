package org.unioulu.tol.sqat2015.planetExplorer;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID: 143
// Finish time:
public class PlanetExplorer {
	String currentLocation;
	int currX, currY, maxX,maxY;
	String currOrient;
	String blocked, obstacles;
	
	char instrForThisMove;
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use:
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		this.obstacles = obstacles;
		maxX = x; maxY = y;
		
		
		currX = currY= 0;
		currOrient = "N";
		blocked = null;
		
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
			instrForThisMove = command.charAt(i);
			move(instrForThisMove);
			checkForObstacles(instrForThisMove);
		}
		
		if(blocked!=null) return getLocation()+blocked;
		return getLocation();
	}

	private void checkForObstacles(char dir) {
		if(obstacles.contains("("+currentLocation+")")){
			if(!blocked.contains("("+currentLocation+")")){
				blocked.concat("("+currentLocation+")");
			}
			cantMove(dir);
		}
	}

	private void cantMove(char dir) {
		switch (instrForThisMove) {
		case 'f': move('b'); break;
		case 'b': move('f'); break;
		case 'r': move('l'); break;
		case 'l': move('r'); break;
		}
	}

	public String getLocation() {
		currentLocation = currX+","+currY;
		return "("+currentLocation+","+currOrient+")";

	}
	
	public void setLocation(int x,int y,String orient){
		currX = x; currY = y;
		currOrient = orient;
	}
	
	public void move(char c){
		switch(c){
		case 'f': 
			switch(currOrient){
			case "N": setLocation(currX, currY+1, currOrient); break;
			case "S": setLocation(currX, currY-1, currOrient); break;
			case "E": setLocation(currX+1, currY, currOrient); break;
			case "W": setLocation(currX-1, currY, currOrient); break;
			} break;
		case 'b': 
			switch(currOrient){
			case "N": setLocation(currX, currY-1, currOrient); break;
			case "S": setLocation(currX, currY+1, currOrient); break;
			case "E": setLocation(currX-1, currY, currOrient); break;
			case "W": setLocation(currX+1, currY, currOrient); break;
			} break;
		case 'l': 
			switch(currOrient){
			case "N": setLocation(currX, currY, "W"); break;
			case "S": setLocation(currX, currY, "E"); break;
			case "E": setLocation(currX, currY, "N"); break;
			case "W": setLocation(currX, currY, "S"); break;
			} break;
		case 'r': 
			switch(currOrient){
			case "N": setLocation(currX, currY, "E"); break;
			case "S": setLocation(currX, currY, "W"); break;
			case "E": setLocation(currX, currY, "S"); break;
			case "W": setLocation(currX, currY, "N"); break;
			} break;
		}
		if(currX>maxX) setLocation(0, currY, currOrient);
		else if(currY>maxY) setLocation(currX, 0, currOrient);
	}
}
