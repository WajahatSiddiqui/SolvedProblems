package com.designpatterns.webserverapp.template;

public class HttpServlet implements Servlet {
    public void doGet() {

    }

    public void doPost() {

    }

    public void service(String httpRequestType) {
        if ( httpRequestType.equalsIgnoreCase("GET")) {
            doGet();
        } else if ( httpRequestType.equalsIgnoreCase("POST")) {
            doPost();
        }
    }
}
