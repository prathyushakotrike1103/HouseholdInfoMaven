Must Contain following

Java 1.8: Ensure you have Java 1.8 installed on your machine. 
Make sure maven is install in you local system

Steps to install maven for windows 

--- Download maven from (https://maven.apache.org/download.cgi?Preferred=ftp%3A%2F%2Fmirror.reverse.net%2Fpub%2Fapache%2F) and download apache-maven-version-bin.zip 


--- Make sure envirnoment variables are set.
    Create new system variable 
    name : MAVEN_HOME
    path : Your maven folder (C:\Users\prath\Downloads\apache-maven-3.9.6-bin (1)\apache-maven-3.9.6)
    Add Path in system variable
    %MAVEN_HOME%\bin
--- To check reload/restart cmd and type mvn --version(make sure path is set to your project folder)
    example : C:\Users\prath\eclipse-workspace\HouseholdProject>mvn --version
    

Build Command

mvn install clean

Run Command

--- To run source file : mvn exec:java -Dexec.mainClass="com.example.MainClass"
    C:\Users\prath\eclipse-workspace\HouseholdProject>mvn exec:java -Dexec.mainClass="householdInfo.HouseholdDetails"

--- To run test cases : mvn test
