package com.sky.dvdstore;

import com.sky.dvdstore.data.Dvd;
import com.sky.dvdstore.exceptions.DvdNotFoundException;
import com.sky.dvdstore.exceptions.InvalidReferenceSyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class DvdServiceFixture {
    DvdService instance;
    
    @Before
    public void setUp() {
        instance = new DvdServiceImpl();
    }
    
    
    public void addDvdToRepository(String reference, String name, String description) {
        Logger.getLogger(DvdServiceFixture.class.getName())
                .log(Level.INFO, "{0},{1},{2}", new Object[]{reference, name, description});
        
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
