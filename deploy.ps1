Get-ChildItem D:\tools\apache-tomcat-8.5.54\webapps -Recurse | Remove-Item
Copy-Item "target\guitarshop-api-0.0.2-SNAPSHOT.war" -Destination "D:\tools\apache-tomcat-8.5.54\webapps\guitar.war"