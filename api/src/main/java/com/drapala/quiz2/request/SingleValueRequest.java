package com.drapala.quiz2.request;

public class SingleValueRequest<T> {

    private T value;

    public SingleValueRequest() {
    }

    public SingleValueRequest(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static <T> SingleValueRequest<T> of(T object) {
        return new SingleValueRequest<T>(object);
    }
}
