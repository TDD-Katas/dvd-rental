/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.dvdstore;

import com.sky.dvdstore.data.Dvd;
import com.sky.dvdstore.exceptions.DvdNotFoundException;
import com.sky.dvdstore.exceptions.InvalidReferenceSyntaxException;
import com.sky.dvdstore.repository.DvdRepository;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class DvdServiceImplTest {
    public static final String INVALID_REFERENCE_SYNTAX = "INVALID-REFERENCE";
    public static final String NON_EXISTING_DVD = "DVD-EMPTY";
    
    @Test(expected = InvalidReferenceSyntaxException.class)
    public void retrieval_should_throw_invalid_reference_syntax_exception_if_name_does_not_start_with_dvd() 
            throws Exception  {
        DvdService dvdService = new DvdServiceImpl();
        
        dvdService.retrieveDvd(INVALID_REFERENCE_SYNTAX);
    }
    
    @Test(expected = DvdNotFoundException.class)
    public void retrieval_should_throw_dvd_not_found_exception_if_dvd_repository_does_not_contain_reference() 
            throws Exception  {
        DvdService dvdService = createServiceWithEmptyRepository();
        
        dvdService.retrieveDvd(NON_EXISTING_DVD);
    }
    
    @Test
    public void retrieval_should_obtain_dvd_from_repository() 
            throws Exception {
        Dvd existingDvd = createSomeDvd();
        DvdService dvdService = createServiceWithExistingDvd(existingDvd);
        
        Dvd retrievedDvd = dvdService.retrieveDvd(existingDvd.getReference());
        
        assertThat(retrievedDvd, equalTo(existingDvd));
    }
    
    @Test(expected = InvalidReferenceSyntaxException.class)
    public void getting_summary_should_throw_invalid_reference_syntax_exception_if_name_does_not_start_with_dvd() 
            throws Exception  {
        DvdService dvdService = new DvdServiceImpl();
        
        dvdService.getDvdSummary(INVALID_REFERENCE_SYNTAX);
    }
    
    //~~~~ Test helpers

    protected DvdService createServiceWithEmptyRepository() {
        DvdRepository emptyRepository = mock(DvdRepository.class);
        when(emptyRepository.contains(any(String.class))).thenReturn(false);
        DvdService dvdService = new DvdServiceImpl(emptyRepository);
        return dvdService;
    }

    protected Dvd createSomeDvd() {
        return new Dvd("DVD-Ref", "test", "test");
    }

    protected DvdService createServiceWithExistingDvd(Dvd existingDvd) 
            throws InvalidReferenceSyntaxException, DvdNotFoundException {
        DvdRepository repository = mock(DvdRepository.class);
        when(repository.contains(existingDvd.getReference())).thenReturn(true);
        when(repository.retrieveDvd(existingDvd.getReference())).thenReturn(existingDvd);
        DvdService dvdService = new DvdServiceImpl(repository);
        return dvdService;
    }
}