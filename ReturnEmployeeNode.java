package com.tutorialspoint;

import org.neo4j.driver.v1.*;
import static org.neo4j.driver.v1.Values.parameters;

@SuppressWarnings("unchecked")
public class ReturnEmployeeNode {
	
	// Driver objects are thread-safe and are typically made available application-wide.
    static Driver driver;
     public static String returnEmployeeList ="";
    
    public static String queryResult(String empName, String server, String user, String password)
	{	returnEmployeeList ="";			
		System.out.println("Inside Create Node for "+ empName);
		//System.out.println("server:"+server+", user"+user+", password"+ password);
		Driver arunSandConnect = Neo4jSessionManagement.createSession(server, user, password);
		System.out.println("Connection Created "); 
		int empCount=0;
		
		try (Session session = arunSandConnect.session())
		{
			// Execute the Statement for Session
			StatementResult result = session.run(
							"MATCH (a:Employee) WHERE a.name = {parEmpName} RETURN a.name AS retEmpName, a.emp_id AS retEmpId", parameters("parEmpName", empName));
		    // Each Cypher execution returns a stream of records.
			
		    while (result.hasNext())
		    {
		    	System.out.println("Inside Query Result");
		    	Record record = result.next();
		    	++empCount;
		        // Values can be extracted from a record by index or name.
		    	returnEmployeeList = returnEmployeeList + " ("+ empCount+")=> Emp id:"+ (record.get("retEmpId").asInt())+ "  and  Emp Name:"+ (record.get("retEmpName").asString()+" ; ");
		        //System.out.println(record.get("name").asString());
		    }
		}
	      System.out.println("After Node return");
	      Neo4jSessionManagement.closeSession(arunSandConnect);
	      return empCount+" record found for "+empName+" : " + returnEmployeeList;
	      
	}
	
	//public static void main(String[] args) {
	//	returnEmployeeList= queryResult("Gopal","bolt://52.91.116.230:32809","neo4j","progress-injectors-scenes");
	//	 System.out.println(returnEmployeeList);
    //}
	
}