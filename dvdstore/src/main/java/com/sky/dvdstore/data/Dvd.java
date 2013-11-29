/*
 * Copyright � 2006-2010. BSkyB Ltd All Rights reserved
 */
package com.sky.dvdstore.data;

public class Dvd {
    private String reference;
    private String title;
    private String description;

    public Dvd(String reference, String title, String description) {
        this.reference = reference;
        this.title = title;
        this.description = description;
    }

    public String getReference() {
        return reference;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }

    //~~~~~~~ Dvd comparisons
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.reference != null ? this.reference.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dvd other = (Dvd) obj;
        if ((this.reference == null) ? (other.reference != null) : !this.reference.equals(other.reference)) {
            return false;
        }
        return true;
    }
}
