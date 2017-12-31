package com.tutorialspoint;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;

public class Neo4jSessionManagement {
	
	// Driver objects are thread-safe and are typically made available application-wide.
    static Driver driver;
   
     // Create a Session in the Sandbox DB.
    // createSession method create new Session in Sandbox DB. It take 3 parameters and Returns the sessionDriver
    //1. String	neo4jServer:	<Neo4j Server url>
    //2. String	neo4jUsr:	<Neo4j User Name>
    //3. String	neo4jPwd:	<Neo4j password>
    //Driver SessionDriver: <Neo4j Session>
	public static Driver createSession(String uri, String user, String password)
	{
		// Create Session driver.
		driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
		System.out.println("Creating Connection");
		return driver;
	}
	
    // closeSession method create new Session in Sandbox DB. It take 1 parameters
    //1. Driver	connectionSession:	<Neo4j Session>
	public static void closeSession(Driver connectionSession)
	{
		// Closing a driver.
		connectionSession.close();
		System.out.println("Closing Connection");
	}
	
}
