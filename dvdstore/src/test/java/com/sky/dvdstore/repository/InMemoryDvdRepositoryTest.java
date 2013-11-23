/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.dvdstore.repository;

import com.sky.dvdstore.data.Dvd;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class InMemoryDvdRepositoryTest {
    
    /**
     * Test of contains method, of class InMemoryDvdRepository.
     */
    @Test
    public void dvd_repository_should_contain_existing_dvd() {
        String dvdReference = "DVD-OLE"; 
        InMemoryDvdRepository dvdRepository = 
                createRepositoryWithGivenReference(dvdReference);
        
        assertThat(dvdRepository.contains(dvdReference), is(true));
    }

    /**
     * Test of retrieveDvd method, of class InMemoryDvdRepository.
     */
    @Test
    public void testRetrieveDvd() {
        Dvd existingDvd = createSomeDvd();
        InMemoryDvdRepository dvdRepository = createRepositoryWithExistingDvd(existingDvd);
        
        Dvd retrievedDvd = dvdRepository.retrieveDvd(existingDvd.getReference());
        
        assertThat(retrievedDvd, equalTo(existingDvd));
    }
    
    
    //~~~~~~~~~~~~ Test helpers

    protected Dvd createSomeDvd() {
        return createDvdWithReference("DVD-someref");
    }
    
    protected Dvd createDvdWithReference(String reference) {
        return new Dvd(reference, "test", "test");
    }
    
    protected InMemoryDvdRepository createRepositoryWithGivenReference(String dvdReference) {
        Dvd dvd = createDvdWithReference(dvdReference);
        InMemoryDvdRepository dvdRepository = createRepositoryWithExistingDvd(dvd);
        return dvdRepository;
    }

    protected InMemoryDvdRepository createRepositoryWithExistingDvd(Dvd existingDvd) {
        InMemoryDvdRepository dvdRepository = new InMemoryDvdRepository();
        dvdRepository.add(existingDvd);
        return dvdRepository;
    }
}