package com.carebears;

import java.util.ArrayList;
import java.util.List;

public class Session {

    private String data = null;
    private List<String> logData = new ArrayList<>();
    private boolean authorized = false;
    private List<String> sortList =  new ArrayList<>();

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public String getLogData() {
        StringBuffer sb = new StringBuffer();

        for (String str : logData) {
            sb.append(str);
            sb.append("\n");
        }
        return(sb.toString());
    }

    public void addLogData(String dataString) {
        logData.add(dataString);
    }

    public boolean hasLogData(String dataString) {
        return(logData.contains(dataString));
    }

    public void setAuthorized() {
        authorized = true;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setSortedList(String key) {
        sortList.add(key);
    }

    public List<String> getSortList() {
        return sortList;
    }
}
