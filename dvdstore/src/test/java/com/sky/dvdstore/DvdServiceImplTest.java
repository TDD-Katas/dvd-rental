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
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class DvdServiceImplTest {
    public static final String INVALID_REFERENCE_SYNTAX = "INVALID-REFERENCE";
    public static final String NON_EXISTING_DVD = "DVD-EMPTY";
    
    @Test
    public void retrieval_should_obtain_dvd_from_repository() 
            throws Exception {
        Dvd existingDvd = createSomeDvd();
        DvdService dvdService = createServiceWithExistingDvd(existingDvd);
        
        Dvd retrievedDvd = dvdService.retrieveDvd(existingDvd.getReference());
        
        assertThat(retrievedDvd, equalTo(existingDvd));
    }
    
    @Test
    public void summary_contains_dvd_reference() 
            throws Exception  {
        Dvd existingDvd = createSomeDvd();
        DvdService dvdService = createServiceWithExistingDvd(existingDvd);
        
        String summary = dvdService.getDvdSummary(existingDvd.getReference());
        
        assertThat(summary.contains(existingDvd.getReference()), is(true));
    }
    
    @Test
    public void summary_contains_dvd_title() 
            throws Exception  {
        Dvd existingDvd = createSomeDvd();
        DvdService dvdService = createServiceWithExistingDvd(existingDvd);
        
        String summary = dvdService.getDvdSummary(existingDvd.getReference());
        
        assertThat(summary.contains(existingDvd.getTitle()), is(true));
    }
    
    @Test
    public void summary_contains_dvd_description() 
            throws Exception  {
        Dvd existingDvd = createSomeDvd();
        DvdService dvdService = createServiceWithExistingDvd(existingDvd);
        
        String summary = dvdService.getDvdSummary(existingDvd.getReference());
        
        assertThat(summary.contains(existingDvd.getDescription()), is(true));
    }
    
    //~~~~ Test helpers

    private Dvd createSomeDvd() {
        return new Dvd("DVD-Ref", "title", "description");
    }

    private DvdService createServiceWithExistingDvd(Dvd existingDvd) 
            throws InvalidReferenceSyntaxException, DvdNotFoundException {
        DvdRepository repository = mock(DvdRepository.class);
        when(repository.contains(existingDvd.getReference())).thenReturn(true);
        when(repository.retrieveDvd(existingDvd.getReference())).thenReturn(existingDvd);
        DvdService dvdService = new DvdServiceImpl(repository);
        return dvdService;
    }
}