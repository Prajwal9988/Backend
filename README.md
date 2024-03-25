Student Management Application:
===============================

Exposes the following endpoints
-> GET - /api/students
      Supports filter on - studentName, studentRollNumber, stuentClass & Sorting on all the fields.

Specifications:
===============
1. The Application uses AWS Relation Database Service for connecting to MySQL Database.
2. Have dockerised the application and published to AWS Elastic Container Registry
3. Have deployed the container to AWS Elastic Kubernetes Service.
   (Public URL : http://aed7fec33eb9c4af1976d1f416e39ab3-507690388.us-east-1.elb.amazonaws.com/api/students)
   
