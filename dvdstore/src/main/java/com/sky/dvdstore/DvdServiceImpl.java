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

class DvdServiceImpl implements DvdService {
    public static final String REFERENCE_TAG = "DVD";
    private DvdRepository dvdRepository;

    public DvdServiceImpl(DvdRepository dvdRepository) {
        this.dvdRepository = dvdRepository;
    }
    
    public Dvd retrieveDvd(String dvdReference) throws 
            InvalidReferenceSyntaxException, DvdNotFoundException {
        return dvdRepository.retrieveDvd(dvdReference);
    }

    public String getDvdSummary(String dvdReference) throws 
            InvalidReferenceSyntaxException, DvdNotFoundException {
        Dvd dvd = dvdRepository.retrieveDvd(dvdReference);
        return "["+dvd.getReference()+"] "+dvd.getTitle()+" - "+dvd.getDescription();
    }
}
