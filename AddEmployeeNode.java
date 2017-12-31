package com.tutorialspoint;

import org.neo4j.driver.v1.*;
import static org.neo4j.driver.v1.Values.parameters;

public class AddEmployeeNode {

	// Driver objects are thread-safe and are typically made available application-wide.
    static Driver driver;
    
	// 3
	// Create a Employee Node in the Sandbox DB.
	public static String createNode(String empName, int empId,String server, String user,String password)
	 {
			
			//System.out.println("Inside Create Node for "+empName);
			System.out.println("Create connection for "+empName+" empId:"+empId+" server:"+server+", user"+user+", password"+ password);
			Driver arunSandConnect = Neo4jSessionManagement.createSession(server,user, password);
			System.out.println("Connection Created "); 
			 
			 
			 
	        // Sessions are lightweight and disposable connection wrappers.
	        try (Session session = arunSandConnect.session())
	        {
	            // Wrapping Cypher in an explicit transaction provides atomicity
	            // and makes handling errors much easier.
	            try (Transaction tx = session.beginTransaction())
	            {
	            	tx.run(
	            			"CREATE (a:Employee {name: {parEmpName}, emp_id: {parEmpId}})", parameters("parEmpName", empName, "parEmpId", empId)
	            			);
	            	// Write Transaction successful.
	            	tx.success();  
	            }
	        }
	        System.out.println("After Node Created");
			 
			 Neo4jSessionManagement.closeSession(arunSandConnect);
			 return "Node Created for " + empName + " with emp id:" + empId;
	    }
	//	public static void main(String[] args) {
	//		AddEmployeeNode.createNode("Gopal",2);
	//	}
		
}