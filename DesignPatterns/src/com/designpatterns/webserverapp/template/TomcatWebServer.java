package com.designpatterns.webserverapp.template;

public class TomcatWebServer {

    public TomcatWebServer() {
        // Create a TCP Socket and Register httpRequestHandler() to receive HTTP requests
    }

    public void httpRequestHandler(String httpDataClassName, String httpRequestType) {
        // Uses reflection to discover classes and create their objects 
        try {
            Servlet s = (Servlet) Class.forName("com.designpatterns.webserverapp.template."+httpDataClassName).newInstance() ; 
            s.service(httpRequestType) ;
        } catch ( Exception ex) {
            System.out.println ( ex.getMessage() ) ;
        }
    }
}
