/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.dvdstore.repository;

import com.sky.dvdstore.data.Dvd;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class InMemoryDvdRepository implements DvdRepository {
    private Dvd dvd;
    
    public void add(Dvd dvd) {
        this.dvd = dvd;
    }

    public boolean contains(String reference) {
        return true;
    }

    public Dvd retrieveDvd(String reference) {
        return dvd;
    }
    
}
