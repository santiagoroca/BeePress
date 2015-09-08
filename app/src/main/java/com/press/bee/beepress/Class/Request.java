package com.press.bee.beepress.Class;


import com.google.gson.GsonBuilder;

public class Request {

    private String status;
    private String message;
    private String data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String success) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public <T> T getParsed (Class<T> t) {
        return new GsonBuilder().create().fromJson(this.getData(), t);
    }

}
