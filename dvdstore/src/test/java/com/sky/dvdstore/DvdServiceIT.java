/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.dvdstore;

import com.sky.dvdstore.data.Dvd;
import com.sky.dvdstore.exceptions.DvdNotFoundException;
import com.sky.dvdstore.repository.DvdRepository;
import com.sky.dvdstore.repository.ErrorCheckingDvdRepository;
import com.sky.dvdstore.repository.InMemoryDvdRepository;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class DvdServiceIT {
    
    @Test
    public void dvd_is_retrieved_from_in_memory_storage() throws Exception {
        Dvd storedDvd = new Dvd("DVD-refs", "title", "description");
        InMemoryDvdRepository storageRepository = new InMemoryDvdRepository();
        storageRepository.add(storedDvd);
        DvdRepository errorCheckingRepository = new ErrorCheckingDvdRepository(storageRepository);
        DvdService service = new DvdServiceImpl(errorCheckingRepository);
        
        Dvd existingDvd = service.retrieveDvd(storedDvd.getReference());
        
        assertThat(existingDvd, is(storedDvd));
    }
}