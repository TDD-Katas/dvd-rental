package com.sky.dvdstore;

import com.sky.dvdstore.data.Dvd;
import com.sky.dvdstore.repository.DvdRepository;
import com.sky.dvdstore.repository.ErrorCheckingDvdRepository;
import com.sky.dvdstore.repository.InMemoryDvdRepository;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class DvdServiceFixture {
    DvdRepositoryStub dvdRepository;
    DvdService instance;

    public DvdServiceFixture() {
        this.dvdRepository = new DvdRepositoryStub();
    }
    
    @Before
    public void setUp() {
        DvdRepository errorCheckingRepository = new ErrorCheckingDvdRepository(dvdRepository);
        instance = new DvdServiceImpl(errorCheckingRepository);
    }
    
    //~~~~~~~~~~ Mappings

    public Dvd retrieveDvdFromRepository(String reference) {
        return dvdRepository.retrieveDvd(reference);
    }
    
    
    public String retrieveDvdTitle(String reference) {
        String dvdTitle;
        try {
            Dvd dvd = instance.retrieveDvd(reference);
            dvdTitle = dvd.getTitle();
        } catch (Exception ex) {
            dvdTitle = asExceptionMessage(ex);
        }
        
        return dvdTitle;
    }
    
    public String getDvdSummary(String reference) {
        String dvdSummary;
        try {
            dvdSummary = instance.getDvdSummary(reference);
        } catch (Exception ex) {
            dvdSummary = asExceptionMessage(ex);
        }
        
        return dvdSummary;
    }
    
    //~~~~~~~~~~ Test helpers

    protected String asExceptionMessage(Exception ex) {
        return "Exception: "+ex.getMessage();
    }
}
