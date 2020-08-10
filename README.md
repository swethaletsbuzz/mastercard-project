
# mastercard-project

Demo a Restful api application using Springboot  
The api would determine if 2 cities are connected.  

<b>Setup</b>  

 1. Clone this project: git clone https://github.com/swethaletsbuzz/mastercard-project.git  
 2. Build the project using maven: mvn clean install  
 3. Go to target folder where demo-0.0.1-SNAPSHOT.jar is present  
 4. Launch the default app:  
		 ```java -jar demo-0.0.1-SNAPSHOT.jar```  
     This will run the WebApp by loading city connections from city.txt file in resources directory of the project  
 5. To launch the app using external connections file:  
		i. Create a external property file.  
		ii. In the property file, specify the property ```cities.file=location of connection file```   
    iii. Launch the app using: ```java -jar demo-0.0.1-SNAPSHOT.jar --spring.config.location=<property file location>```    
    
 <b>URL</b>
 
 http://localhost:8080//connected?origin=originCity&destination=destinationCity   
    
 If originCity and destinationCity are connected via a path, the output would be ```yes```   
 If either of the parameter is not present or the cities are not connected, the output would be ```no```   
   
 <b> Algorithm used for connections </b>   
 This is a typical problem of finding a path in a connected graph. The algorithm used here is <I>Breadth First Search.</I>
 We construct the graph using the cities files provided during application startup. The code is present in <I>Graph.java</I> and then use BFS to check if the two given cities are connected.  
   
 <b>Future enhancements</b>  
 
 1. Add more properties related to connection file. Used a property file to pass the connection file location so that we can add more properties like format, city seperator, etc  
 2. Cache the results. Currently, connection between two cities is always evaluated. Once evaluated, the result can be stored in a HashMap. We can use the cache to return the result if same two citites are to be evaluated again
 3. Add logging.
