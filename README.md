
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
    
 If originCity and destinationCity are connected via a path, the output would be ```YES```   
 If either of the parameter is not present or the cities are not connected, the output would be ```NO```   
   
 <b> Algorith used for connections <b>
