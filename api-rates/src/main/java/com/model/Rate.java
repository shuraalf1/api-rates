package com.model;
import java.io.Serializable;

public class Rate implements Serializable {
    private Provider dof ;
    private Provider fixer;
    private Provider banxico;

    public Rate(Provider dof, Provider fixer, Provider banxico) {
        this.dof = dof;
        this.fixer = fixer;
        this.banxico = banxico;
    }

    public Rate() {

    }

    public Provider getDof() {
        return dof;
    }

    public void setDof(Provider dof) {
        this.dof = dof;
    }

    public Provider getFixer() {
        return fixer;
    }

    public void setFixer(Provider fixer) {
        this.fixer = fixer;
    }

    public Provider getBanxico() {
        return banxico;
    }

    public void setBanxico(Provider banxico) {
        this.banxico = banxico;
    }



    private static final long serialVersionUID = 1L;
}