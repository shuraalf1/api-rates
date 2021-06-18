package com.model;

import java.io.Serializable;

public class DataFixer implements Serializable {
    private boolean success;
    private int timestamp;
    private String base;
    private String date;
    private RateFixer rates;

    public DataFixer() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RateFixer getRates() {
        return rates;
    }

    public void setRates(RateFixer rates) {
        this.rates = rates;
    }

    private static final long serialVersionUID = 1L;
}