1. Match Device: Endpoint 
URL : http://localhost:8080/devices/matchDevice
Method : Post
Input :  as part of body in postman
"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36"

2. Get a Device by ID: Endpoint
URL : http://localhost:8080/devices/Windows10.0Chrome87.0.4280.66
Method : Get

3. Delete a Device/s: Endpoint
URL : http://localhost:8080/devices/Windows10.0Chrome87.0.4280.66
Method : Delete

Note: USe PostMan for testing the above APIS.

Set UP :
1. Install Docker
2. Open Docker
3. Pull aerospike image from the docker from the cmd by the following command
   
         docker pull aerospike/aerospike-server-enterprise
   
5. Connect to Aerospike DB by docker commands , (point to the ip addess of our local machine)

C:\.....>for /f "tokens=*" %i in ('docker inspect -f "{{.NetworkSettings.IPAddress}}" aerospike') do set AEROSPIKE_IP=%i

C:\.....>set AEROSPIKE_IP=172.17.0.2

C:\......>docker run -it aerospike/aerospike-tools aql -h %AEROSPIKE_IP%
C:\......>docker run -it --network host aerospike/aerospike-tools aql -h localhost -p 3000

6. It open AQL in command prompt to run queries

7. In Springboot properties file provide the Aerospike coniguration details.

............................................................................................

As I have been trying  to use the AerospikeRepository as a JPA repository to make the code simplest,consumed time for the versions and configurations.
Finally I succeeded at resolving all set up issues to use AerospikeRepository.
Unfortunately, it is not working except for findbyID. Unable to resolve to write findbyColumnName.
So, Get all Devices for a given OS name: Endpoint , is not implemented.
If I am allowed to use use Mysql/SQL , then it could be done easily at earliest.
   
