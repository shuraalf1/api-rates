package com.model;

import java.io.Serializable;
import java.util.Date;

public class Provider implements Serializable {

    private double value;
    private Date last_updated;

    public Provider() {

    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Date last_updated) {
        this.last_updated = last_updated;
    }

    public Provider(double value, Date last_updated) {
        this.value = value;
        this.last_updated = last_updated;
    }

    private static final long serialVersionUID = 1L;
}