package com.sky.dvdstore;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class WebServiceFixture {

    public void addDvdToRepository(String reference, String name, String description) {
        Logger.getLogger(WebServiceFixture.class.getName())
                .log(Level.INFO, "{0},{1},{2}", new Object[]{reference, name, description});
        
    }
    
    public String retrieveDvdName(String reference) {
        return "ole";
    }
    
    public String getDvdSummary(String reference) {
        return "ole";
    }
}
