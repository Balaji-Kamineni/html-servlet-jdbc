# html-servlet-jdbc

inputs from html page are taken to servlet through web.xml and performed operation in database with help of jdbc
new things learned:
 1) welcome-file in web.xml
 2) you can place .java file in web-inf -> classes folder instead of src, no need of src also
 3) you have to do exception handling using try catch while establishing with jdbc , you cannot write throws Exception in service method , because if leads to 
 method overloading later servletcontainer cannot call this method.
  4) getParameter() return String datatype. so for Int values use Integer.parseInt()
  
