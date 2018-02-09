## Quaduron Launcher

It is an executable service that launches all Quaduron services using ServiceLaunchConfig.conf
and periodically manages the same

Follow the below steps:

1. Build the application under microservices/support/ServiceSupervision
 $ gradle clean build -x test

2. Go to the following directory,
 $ cd microservices/support/ServiceSupervision/build/libs/

3. Start the service
 $ java -jar ServiceSupervision.jar

4. Once the service is started the log data will be generated in
  Logs:        C:\Users\id\Documents\Samsung\b.IoT\Logs\<ServiceName>

5. b.IoT and config paths
  BIoT Center: C:\Program Files\Samsung\b.IoT
  Config:      C:\Program Files\Samsung\b.IoT\config

6. All jars needs to be copied into b.IoT folder. And it should have executable permissions

7. ServiceLaunchConfig.conf will be in **Config** path

## Release Notes:
------------------
1. ServiceSupervision will run as executable
2. Launcher functionality to launch services listed in ServiceLaunchConfig.conf file
3. Launcher will report any errors and logs appropriately
4. Notification Popup in case of error
5. Check the service has been launched if not retry 3 times and report to BIoT center
6. Make launcher as finite state machine (FSM)

ToDo
1. Add periodic monitoring every 10 mins for all services
