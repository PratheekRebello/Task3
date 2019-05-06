package com.example.myapplication;

public class Date {
    public int date;
    private ChangeListener listener;

    public Date()
    {
        date = 1;
    }
    public ChangeListener getListener() {
        return listener;
    }

    public void setListener(ChangeListener listener) {
        this.listener = listener;
    }

    public interface ChangeListener {
        void onChange();
    }
}