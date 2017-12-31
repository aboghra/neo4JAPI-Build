package com.tutorialspoint;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;

public class Neo4jSessionManagement {
	
	// Driver objects are thread-safe and are typically made available application-wide.
    static Driver driver;
   
    // 1
    // Create a Session in the Sandbox DB.
	public static Driver createSession(String uri, String user, String password)
	{
		// Create Session driver.
		driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
		System.out.println("Creating Connection");
		return driver;
	}
	
	// 2
	// Create a Session in the Sandbox DB.
	public static void closeSession(Driver Connectiondriver)
	{
		// Closing a driver.
		Connectiondriver.close();
		System.out.println("Closing Connection");
	}
	
}
