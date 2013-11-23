/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.dvdstore;

import org.junit.Test;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class DvdServiceTest {
    public static final String REFERENCE_WITHOUT_DVD = "INVALID-REFERENCE";
    
    @Test(expected = InvalidReferenceSyntaxException.class)
    public void retrieval_should_throw_invalid_reference_syntax_exception_if_name_does_not_start_with_dvd() 
            throws DvdNotFoundException, InvalidReferenceSyntaxException {
        DvdService dvdService = new MyDvdService();
        String reference = REFERENCE_WITHOUT_DVD;
        
        dvdService.retrieveDvd(reference);
    }
    
    
    
    //Production code
    
    class MyDvdService implements DvdService {

        public Dvd retrieveDvd(String dvdReference) throws 
                InvalidReferenceSyntaxException, 
                DvdNotFoundException {
            if (!dvdReference.startsWith("DVD")) {
                throw new InvalidReferenceSyntaxException();
            } else {
                return null;
            }
        }

        public String getDvdSummary(String dvdReference) throws 
                InvalidReferenceSyntaxException, 
                DvdNotFoundException {
            return "";
        }
    }
}