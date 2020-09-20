package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void InitCommandMapTest() {
		
		assertNotNull(Main.commandMap);
		
		Main.initCommandMap();
		
		assertNotNull(Main.commandMap.keySet());
		assertTrue(Main.commandMap.size() > 0);
		
		Set<String> keySet = Main.commandMap.keySet();
		
		assertTrue(keySet.contains("cd"));
		assertTrue(keySet.contains("compare"));
		assertTrue(keySet.contains("copy"));
		assertTrue(keySet.contains("create"));
		assertTrue(keySet.contains("delete"));
		assertTrue(keySet.contains("help"));
		assertTrue(keySet.contains("dir"));
		assertTrue(keySet.contains("move"));
		assertTrue(keySet.contains("rename"));
	}

}
