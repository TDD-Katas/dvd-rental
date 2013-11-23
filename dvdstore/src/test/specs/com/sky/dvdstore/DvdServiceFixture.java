package com.sky.dvdstore;

import com.sky.dvdstore.data.Dvd;
import com.sky.dvdstore.exceptions.DvdNotFoundException;
import com.sky.dvdstore.exceptions.InvalidReferenceSyntaxException;
import com.sky.dvdstore.repository.InMemoryDvdRepository;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class DvdServiceFixture {
    InMemoryDvdRepository dvdRepository;
    DvdService instance;

    public DvdServiceFixture() {
        this.dvdRepository = new InMemoryDvdRepository();
    }
    
    @Before
    public void setUp() {
        instance = new DvdServiceImpl(dvdRepository);
    }
    
    
    public void addDvdToRepository(String reference, String name, String description) {
        Dvd dvd = new Dvd(reference, name, description);
        dvdRepository.add(dvd);
    }
    
    public String retrieveDvdTitle(String reference) {
        String dvdTitle = "nodvd";
        try {
            Dvd dvd = instance.retrieveDvd(reference);
            if (dvd != null) {
                dvdTitle = dvd.getTitle();
            }
        } catch (InvalidReferenceSyntaxException ex) {
            dvdTitle = asExceptionMessage(ex);
        } catch (DvdNotFoundException ex) {
            dvdTitle = asExceptionMessage(ex);
        }
        
        return dvdTitle;
    }
    
    public String getDvdSummary(String reference) {
        return "ole";
    }
    
    //~~~~~~~~~~ Test helpers

    protected String asExceptionMessage(Exception ex) {
        return "Exception: "+ex.getMessage();
    }
}
