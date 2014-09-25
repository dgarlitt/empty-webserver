package com.carebears.servlets;

import com.carebears.CareBearServlet;
import com.carebears.Request;
import com.carebears.Response;

public class RootServlet extends CareBearServlet {
    private String path;

    public RootServlet() {
        path = "/";
    }

    @Override
    public void doGet(Request req, Response res) {
        res.setStatusCode(200);
        res.send();
    }

    @Override
    public String getPath() {
        return path;
    }

}
