/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.dvdstore;

//Production code
import com.sky.dvdstore.data.Dvd;
import com.sky.dvdstore.exceptions.DvdNotFoundException;
import com.sky.dvdstore.exceptions.InvalidReferenceSyntaxException;
import com.sky.dvdstore.repository.DvdRepository;
import com.sky.dvdstore.repository.InMemoryDvdRepository;

class DvdServiceImpl implements DvdService {
    public static final String REFERENCE_TAG = "DVD";
    private DvdRepository dvdRepository;

    public DvdServiceImpl() {
        this(new InMemoryDvdRepository());
    }

    public DvdServiceImpl(DvdRepository dvdRepository) {
        this.dvdRepository = dvdRepository;
    }
    
    public Dvd retrieveDvd(String dvdReference) throws 
            InvalidReferenceSyntaxException, DvdNotFoundException {
        if (!dvdReference.startsWith(REFERENCE_TAG)) {
            throw new InvalidReferenceSyntaxException();
        } else {
            if (!dvdRepository.contains(dvdReference)) {
                throw new DvdNotFoundException();
            } else {
                return null;
            }
        }
    }

    public String getDvdSummary(String dvdReference) throws 
            InvalidReferenceSyntaxException, DvdNotFoundException {
        return "";
    }
}
