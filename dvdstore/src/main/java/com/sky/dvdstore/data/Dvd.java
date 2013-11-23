/*
 * Copyright � 2006-2010. BSkyB Ltd All Rights reserved
 */
package com.sky.dvdstore.data;

public class Dvd {
    private String reference;
    private String title;
    private String descriprion;

    public Dvd(String reference, String title, String description) {
        this.reference = reference;
        this.title = title;
        this.descriprion = description;
    }

    public String getReference() {
        return reference;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return descriprion;
    }
}
