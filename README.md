# SpringMVCWithMongodbCURD
 Spring MVC CURD operation with MongoDB
 
 Gradle project with Spring Boot CURD operation with MongoDB.


steps to use this project & operations...

1.Download and import the given gradle project.

2.Right click on project & run as gradle project.

3.Server will start with 8084 port no.

4.For create Users,Hit 6th times on browser "http://localhost:8084/userCreateTest" 
it will create 6 users in UserTest Collection(Table) In MongoDB.
i.e You can see by command 
> db.UserTest.find()
 execute on ubuntu terminal you will see...
> db.UserTest.find()
{ "_id" : ObjectId("593655ed5c185220426baea7"), "_class" : "com.krypc.wb.dao.entity.UserTest", "participantName" : "Test@gmail.com1", "partyName" : "abhishek@prty.com", "partyID" : "PRTY001", "partyAdminID" : "abhishek@prty.com", "programe" : "Test", "userEmailId" : "sanju.r@mongo.com1", "idNUmber" : "idNumber", "idType" : "idType" }
{ "_id" : ObjectId("593655ee5c185220426baea8"), "_class" : "com.krypc.wb.dao.entity.UserTest", "participantName" : "Test@gmail.com2", "partyName" : "abhishek@prty.com", "partyID" : "PRTY001", "partyAdminID" : "abhishek@prty.com", "programe" : "Test", "userEmailId" : "sanju.r@mongo.com2", "idNUmber" : "idNumber", "idType" : "idType" }
.....
.....
.....
5. for update Hit on url:"http://localhost:8084/updateUserTest"
it will update user "participantName" : "Test@gmail.com1" to different which is given below..
> db.UserTest.find()
{ "_id" : ObjectId("593655ed5c185220426baea7"), "_class" : "com.krypc.wb.dao.entity.UserTest", "participantName" : "Test@.com1", "partyName" : "TestUpdate@.com", "partyID" : "TestUpdate", "partyAdminID" : "TestUpdate@.com", "programe" : "Test", "userEmailId" : "sanju.r@mongo.com1", "idNUmber" : "TestUpdate@.com", "idType" : "TestUpdate" }

6.for remove user "userEmailId" : "sanju.r@mongo.com1" hit the url which is given below:-
"http://localhost:8084/removeUserTest"

7.If u want to see all use then u can see by the given url which is mention below-
http://localhost:8084/findAllUserTest

{ "_id" : ObjectId("593672ab5c18522ad025b542"), "_class" : "com.krypc.wb.dao.entity.UserTest", "participantName" : "Test@gmail.com1", "partyName" : "abhishek@prty.com", "partyID" : "PRTY001", "partyAdminID" : "abhishek@prty.com", "programe" : "Test", "userEmailId" : "sanju.r@mongo.com1", "idNUmber" : "idNumber", "idType" : "idType" }
{ "_id" : ObjectId("593672ae5c18522ad025b543"), "_class" : "com.krypc.wb.dao.entity.UserTest", "participantName" : "Test@gmail.com2", "partyName" : "abhishek@prty.com", "partyID" : "PRTY001", "partyAdminID" : "abhishek@prty.com", "programe" : "Test", "userEmailId" : "sanju.r@mongo.com2", "idNUmber" : "idNumber", "idType" : "idType" }
.........
.........
Note:For all Url open new browser page because every controller method maintain cookies.
