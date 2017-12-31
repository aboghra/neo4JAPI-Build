# neo4JAPI-Build

Download "LetsGoNeo4Arun.war" file from git and copy to tomcate directory  \apache-tomcat-8.5.24\webapps

Start the tomcate server

Run Postman
  GET API methonds to query database
    http://localhost:8080/LetsGoNeo4Arun/rest/GoNeo4j/NodeOperation
    paramters
      1. String emp_name =<name of employee>
      2. String neo4jServer=<neo4jServer url>
      3. String neo4jUsr=<neo4j user>
      4. String neo4jPwd=<neo4j user password>
    
      Example:
      http://localhost:8080/LetsGoNeo4Arun/rest/GoNeo4j/NodeOperation?emp_name=Gopal1&neo4jServer=bolt://52.91.116.230:32809&neo4jUsr=neo4j&neo4jPwd=progress-injectors-scenes
    
  POST API methonds to create new node
    http://localhost:8080/LetsGoNeo4Arun/rest/GoNeo4j/NodeOperation
    paramters
      1. String emp_name=<name of employee>
      2. int  emp_id=<id of the employee>
      3. String neo4jServer=<neo4jServer url>
      4. String neo4jUsr=<neo4j user>
      5. String neo4jPwd=<neo4j user password>
  
      Example:
      http://localhost:8080/LetsGoNeo4Arun/rest/GoNeo4j/NodeOperation?emp_name=LarryP&emp_id=211&neo4jServer=bolt://52.91.116.230:32809&neo4jUsr=neo4j&neo4jPwd=progress-injectors-scenes
  
Cheeck the documentation for service detail and calling methods.
