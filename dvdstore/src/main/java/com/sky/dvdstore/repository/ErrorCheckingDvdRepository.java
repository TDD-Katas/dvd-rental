/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.dvdstore.repository;

import com.sky.dvdstore.data.Dvd;
import com.sky.dvdstore.exceptions.DvdNotFoundException;
import com.sky.dvdstore.exceptions.InvalidReferenceSyntaxException;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class ErrorCheckingDvdRepository implements DvdRepository {
    public static final String REFERENCE_TAG = "DVD";
    private DvdRepository decoratedRepository;

    public ErrorCheckingDvdRepository(DvdRepository decoratedRepository) {
        this.decoratedRepository = decoratedRepository;
    }
    
    public boolean contains(String reference) {
        return decoratedRepository.contains(reference);
    }

    public Dvd retrieveDvd(String reference) throws 
            InvalidReferenceSyntaxException, DvdNotFoundException {
        if (!reference.startsWith(REFERENCE_TAG)) {
            throw new InvalidReferenceSyntaxException();
        } else {
            if (decoratedRepository.contains(reference)) {
                return decoratedRepository.retrieveDvd(reference);
            } else {
                throw new DvdNotFoundException();
            }
        }
    }
    
}
