# Proyecto tutorial

## Consideraciones configuración JPA y mysql

 Error: Unable to load authentication plugin 'caching_sha2_password.  
  
  Try using MySQL 8.0.3 As can be seen on the docs, the query_cache_size was removed on MySQL8. JetBrains guys have suffered the same issue, is seems to be that it is fixed by updating the driver to the version MySQL JDBC driver v 5.1.44.
  
  
You can run the below command to resolve the issue.
     
sample username / password --> student / pass123
     
    ALTER USER 'student'@'localhost' IDENTIFIED WITH mysql_native_password BY 'pass123';
 Error: java.sql.SQLException: Unknown system variable 'query_cache_size'  
   Starting with MySQL 8.0.4, they have changed the default authentication plugin for MySQL server from mysql_native_password to caching_sha2_password.
     