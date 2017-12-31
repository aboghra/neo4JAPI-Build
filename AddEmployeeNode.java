package com.tutorialspoint;

import org.neo4j.driver.v1.*;
import static org.neo4j.driver.v1.Values.parameters;

public class AddEmployeeNode {

	// Driver objects are thread-safe and are typically made available application-wide.
    static Driver driver;
    
    // CreateNode method create new node to the Sandbox DB. It take 5 parameters
    //1. String	emp_name:	<Name of the Employee>
    //2. Int	emp_id:		<id of the Employee>
    //3. String	neo4jServer:	<Neo4j Server url>
    //4. String	neo4jUsr:	<Neo4j User Name>
    //5. String	neo4jPwd:	<Neo4j password>
	public static String createNode(String empName, int empId,String server, String user,String password)
	 {
			
			//Creating the Session
			//System.out.println("Create connection for "+empName+" empId:"+empId+" server:"+server+", user"+user+", password"+ password);
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
			 
	    	//Closing Session
			 Neo4jSessionManagement.closeSession(arunSandConnect);
			 return "Node Created for " + empName + " with emp id:" + empId;
	    }
	//	public static void main(String[] args) {
	//		AddEmployeeNode.createNode("Gopal",2);
	//	}
		
}