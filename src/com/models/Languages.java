/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;

/**
 *
 * @author Niyaz-laptop
 */
public class Languages implements Serializable{
    private static final long serialVersionUID=0L;
    private int id;
    private String lang;
    private String fullLanguage;

    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getFullLanguage() {
        return fullLanguage;
    }

    public void setFullLanguage(String fullLanguage) {
        this.fullLanguage = fullLanguage;
    }

    @Override
    public String toString() {
        return  fullLanguage ;
    }

    
    
    
    
    
}
