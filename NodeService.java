package com.tutorialspoint;  


import java.util.List; 
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path; 
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  
@Path("/GoNeo4j") 

public class NodeService {  
   
	public static String returnEmployeeList ="";
	// public static String neo4jServer = "bolt://52.91.116.230:32809";
	// public static String neo4jUser = "neo4j";
    //public static String neo4jUserPswd = "progress-injectors-scenes";
	//String emp_name = "Arun";
	//int emp_id = 199;
	AddEmployeeNode addNode = new AddEmployeeNode();
	ReturnEmployeeNode returnNode = new ReturnEmployeeNode();
   
	//resource to create employee
	//http://localhost:8080/LetsGoNeo4Arun/rest/GoNeo4j/NodeOperation
   @POST 
   @Path("/NodeOperation") 
   @Produces(MediaType.APPLICATION_XML)
                  
   public String CreateNode(  @QueryParam("emp_name") String emp_name, @QueryParam("emp_id") int emp_id, @QueryParam("neo4jServer") String neo4jServer
		   , @QueryParam("neo4jUsr") String neo4jUsr  , @QueryParam("neo4jPwd") String neo4jPwd
		   					) 
   {
	 System.out.println("Before CreateNode Call emp_name:"+emp_name+" emp_id:"+emp_id+" server:"+neo4jServer+", user"+neo4jUsr+", password"+ neo4jPwd);
       return addNode.createNode(emp_name, emp_id,neo4jServer,neo4jUsr,neo4jPwd);
	}

   // resource to get employee detail
   //http://localhost:8080/LetsGoNeo4Arun/rest/GoNeo4j/NodeOperation
   @GET
   @Path("/NodeOperation") 
   @Produces(MediaType.APPLICATION_XML)
                   
     
    public String QueryResult	(@QueryParam("emp_name") String emp_name, @QueryParam("neo4jServer") String neo4jServer, @QueryParam("neo4jUsr") String neo4jUsr
    		  , @QueryParam("neo4jPwd") String neo4jPwd)
   {
	   	//System.out.println("Before Query Call emp_name:"+emp_name+" server:"+neo4jServer+", user"+neo4jUsr+", password"+ neo4jPwd);
	     return returnNode.queryResult(emp_name,neo4jServer,neo4jUsr,neo4jPwd);
   	}

   
   

}