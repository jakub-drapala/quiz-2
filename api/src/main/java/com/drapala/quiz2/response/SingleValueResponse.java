package com.drapala.quiz2.response;

public class SingleValueResponse {

    private Object result;

    public static SingleValueResponse of(Object result) {
        var response = new SingleValueResponse();
        response.setResult(result);
        return response;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
