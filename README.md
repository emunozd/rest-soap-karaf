Camel Camel REST to CXF: Camel REST to SOAP proxy
=====================================================================

Author: Elkin Munoz

Technologies: Fuse, OSGi, Camel, File, Blueprint, Rest Endpoint, CXF, JAXB

Product: Fuse 6.3

Breakdown
---------
This code example demonstrates how to create a proxy route, REST to SOAP CXF, using the java classes generated from a wsdl contract.

For more information see:

* <https://access.redhat.com/site/documentation/JBoss_Fuse/> for more information about using JBoss Fuse

System Requirements
-------------------
Before building and running this project you need:

* Maven 3.2 or higher
* JDK 1.7 or 1.8
* JBoss Fuse 6.3

Build and Deploy
----------------

1) clone this project

git clone https://github.com/emunozd/camel-rest-soap.git

2) change to project directory

cd camel-rest-soap

3) build

mvn clean install

4) Start JBoss Fuse 6.3

./bin/fuse

Usage
-----

1) Create a mock service in SOAPUI using the src/main/resources/wsdl/Person.wsdl file, with the following configuration:

* host=localhost
* port=8082
* path=/example

2) Set a response message for the mock service operation "NewOperation", for example:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:per="http://example.com/Person/">
   <soapenv:Header/>
   <soapenv:Body>
      <per:NewOperationResponse>
         <out>Hello</out>
      </per:NewOperationResponse>
   </soapenv:Body>
</soapenv:Envelope>
```
3) Deploy the artifact in the JBoss Fuse 6.3 server

4) Open a rest client, like postman, and send a POST request to the URL: http://0.0.0.0:8282/rest/example/personRest with the following raw XML(application/xml) payload:
```xml
<ns2:NewOperation xmlns:ns2="http://example.com/Person/">
<person>
	<name>Example</name>
	<document>1234</document>
</person>
</ns2:NewOperation>
```
5) Response must be like following:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ns2:NewOperationResponse xmlns:ns2="http://example.com/Person/">
    <out>Hello</out>
</ns2:NewOperationResponse>
```
Done.
