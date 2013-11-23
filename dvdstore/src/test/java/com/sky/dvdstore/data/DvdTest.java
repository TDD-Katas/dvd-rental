/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.dvdstore.data;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class DvdTest {
    
    @Test
    public void dvds_are_equal_if_their_reference_is_equal() {
        String reference = "DVD-REF";
        Dvd firstDvd = createDvd(reference, "1");
        Dvd secondDvd = createDvd(reference, "2");
        
        boolean dvdsAreEqual = firstDvd.equals(secondDvd);
        
        assertThat(dvdsAreEqual, is(true));
    }

    protected Dvd createDvd(String dvdref, String uniqueSuffix) {
        return new Dvd(dvdref, "title"+uniqueSuffix, "desc"+uniqueSuffix);
    }
}