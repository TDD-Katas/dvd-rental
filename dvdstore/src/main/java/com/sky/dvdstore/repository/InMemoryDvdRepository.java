/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.dvdstore.repository;

import com.sky.dvdstore.data.Dvd;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class InMemoryDvdRepository implements DvdRepository {
    private Map<String, Dvd> hash;

    public InMemoryDvdRepository() {
        hash = new HashMap<String, Dvd>();
    }
    
    public void add(Dvd dvd) {
        hash.put(getDvdKey(dvd), dvd);
    }

    public boolean contains(String reference) {
        return hash.containsKey(reference);
    }

    public Dvd retrieveDvd(String reference) {
        return hash.get(reference);
    }
    
    //~~~ Private helpers

    protected String getDvdKey(Dvd dvd) {
        return dvd.getReference();
    }
}
