# aditya-03042020

Instructions steps to launch the application:
1) Paste the CVS files in the project root directory

2) Start the project with command line arguments.
    Example: (windows) gradlew.bat bootRun -Pargs=SaaS=./SaaSBig.csv,SW=./SWBig.csv
    Example: (Linux) gradlew bootRun -Pargs=SaaS=./SaaSBig.csv,SW=./SWBig.csv
    
    The parameters "SaaS=" and "SW=" will tell the app whether you are uploading SaaS group parts or SW group parts
    Note: 1) Use only CSV file types
          2) Provide atleast one CSV file

3) Once the application is launched you can view the loaded data in browser by lunching the following url:
    http://localhost:9090/Reference/partNumber/
    
    KEEP IN MIND THAT YOU CAN INPUT REGULAR EXPRESSION TO SEARCH FOR PART NUMBER BUT THE RESULTING PART NUMBERS LIST IS ALWAYS CAPPED TO A MAXIMUM OF 10
    
    Example Search input
        SW
        SA
        SWPT000001

NOTES:    
1) Duplicate data entry rules (Part Number field is unique):
We are assuming that irrespective of start date, end date, add date, modified date or active flag 
the data that is entered most recent is the correct data 
This most recent data will override any data that is a duplicate Part Number record in the NoSQL DB

This keeps our approach simple to understand for this proof of concept

2) We are using In Memory MongoDB to satisfy NoSQL DB requirements -- because of this, the loaded data will remain in memory as long as the app is running.
Upon restart -- the date is loaded from scratch

3) We are using Spring Boot along with Gradle framework to satisfy web application requirement