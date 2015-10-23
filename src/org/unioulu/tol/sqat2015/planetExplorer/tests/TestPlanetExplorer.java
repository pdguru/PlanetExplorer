package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	PlanetExplorer explorer;
	@Before
	public void setup(){
		explorer = new PlanetExplorer(6,6,"(2,2)(0,5)(5,0)");
	}
	
	@Test
	public void testExplorerJustLanded() {
		assertEquals("(0,0,N)", explorer.getLocation());
	}
	
	//@Test
	public void testExplorerMoveFwd(){
		assertEquals("(0,1,N)", explorer.executeCommand("f"));
	}
	
	//@Test
	public void testIfEverythingWorks(){
		assertEquals("(2,2,E)", explorer.executeCommand("ffrff"));
	}
	
	@Test
	public void testObstacleReporting(){
		assertEquals("(0,0,N)(2,2)(0,5)(5,0)", explorer.executeCommand("ffrfffrbbblllfrfrbbl"));
	}
	
	//@Test
	public void testGridWrapping(){
		explorer.setLocation(6, 6, "E");
		assertEquals("(0,6,E)", explorer.executeCommand("f"));
	}
}
