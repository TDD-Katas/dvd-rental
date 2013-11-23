/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.dvdstore;

import com.sky.dvdstore.exceptions.DvdNotFoundException;
import com.sky.dvdstore.exceptions.InvalidReferenceSyntaxException;
import com.sky.dvdstore.repository.DvdRepository;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class DvdServiceTest {
    public static final String INVALID_REFERENCE_SYNTAX = "INVALID-REFERENCE";
    public static final String NON_EXISTING_DVD = "DVD-EMPTY";
    
    @Test(expected = InvalidReferenceSyntaxException.class)
    public void retrieval_should_throw_invalid_reference_syntax_exception_if_name_does_not_start_with_dvd() 
            throws DvdNotFoundException, InvalidReferenceSyntaxException {
        DvdService dvdService = new DvdServiceImpl();
        
        dvdService.retrieveDvd(INVALID_REFERENCE_SYNTAX);
    }
    
    @Test(expected = DvdNotFoundException.class)
    public void retrieval_should_throw_dvd_not_found_exception_if_dvd_repository_does_not_contain_reference() 
            throws DvdNotFoundException, InvalidReferenceSyntaxException {
        DvdRepository emptyRepository = mock(DvdRepository.class);
        when(emptyRepository.contains(any(String.class))).thenReturn(false);
        DvdService dvdService = new DvdServiceImpl(emptyRepository);
        
        dvdService.retrieveDvd(NON_EXISTING_DVD);
    }
}