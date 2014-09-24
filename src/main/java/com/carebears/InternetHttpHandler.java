package com.carebears;

import java.io.PrintWriter;
import java.util.ArrayList;

public class InternetHttpHandler extends CareBearHttpHandler {
    private String documentRoot;
    private ArrayList<CareBearServlet> servlets = new ArrayList<CareBearServlet>();

    public void handle(String request, PrintWriter writer) {
        Request reqObj = new Request(request);
        Response resObj = new Response(writer);

        CareBearServlet servlet = getServletByPath(reqObj.getPath());

        if (servlet != null) {
            switch(reqObj.getMethod()) {
                case "GET":
                    servlet.doGet(reqObj, resObj);
                    break;
                case "POST":
                    servlet.doPost(reqObj, resObj);
                    break;
                case "PUT":
                    servlet.doPut(reqObj, resObj);
                    break;
                case "DELETE":
                    servlet.doDelete(reqObj, resObj);
                    break;
            }
        }
//        String[] rParams = request.split(" ");
//        String method = rParams[0];
//        String path = rParams[1];
//        String version = rParams[2];


//        if (request.equals("GET / HTTP/1.0")) {
//            return("HTTP/1.0 200");
//        }
//        else if (request.equals("GET /foobar HTTP/1.0")) {
//            return("HTTP/1.0 404");
//        }
//        else if (request.equals("POST / HTTP/1.0")) {
//            return("HTTP/1.0 404");
//        }

//        return null;
    }

    public void registerServlet(CareBearServlet servlet) {
        servlets.add(servlet);
    }

    public CareBearServlet getServletByPath(String path) {
        for(CareBearServlet serve: servlets) {
            if(serve.getPath().equals(path)) {
                return serve;
            }
        }

        return null;
    }

    public void setDocumentRoot(String documentRoot) {
        this.documentRoot = documentRoot;
    }

    public String getDocumentRoot() {
        return documentRoot;
    }

}
