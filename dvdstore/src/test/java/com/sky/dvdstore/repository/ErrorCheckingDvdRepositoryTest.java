/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sky.dvdstore.repository;

import com.sky.dvdstore.data.Dvd;
import com.sky.dvdstore.exceptions.DvdNotFoundException;
import com.sky.dvdstore.exceptions.InvalidReferenceSyntaxException;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.any;
import static org.hamcrest.CoreMatchers.equalTo;


/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class ErrorCheckingDvdRepositoryTest {
    public static final String INVALID_REFERENCE_SYNTAX = "INVALID-REFERENCE";
    public static final String NON_EXISTING_DVD = "DVD-EMPTY";
    public static final boolean SOME_BOOLEAN_VALUE = true;
    public static final String SOME_STRING_VALUE = "test";
    
    @Test
    public void contains_returns_the_value_from_decorated_repository() 
            throws Exception  {
        boolean decoratedContains = SOME_BOOLEAN_VALUE;
        DvdRepository instance = createRepositoryWithStubbedContains(decoratedContains);
        
        boolean result = instance.contains(SOME_STRING_VALUE);
        
        assertThat(result, equalTo(decoratedContains));
    }
    
    @Test(expected = InvalidReferenceSyntaxException.class)
    public void retrieval_should_throw_invalid_reference_syntax_exception_if_name_does_not_start_with_dvd() 
            throws Exception  {
        DvdRepository instance = createEmptyRepository();
        
        instance.retrieveDvd(INVALID_REFERENCE_SYNTAX);
    }
    
    @Test(expected = DvdNotFoundException.class)
    public void retrieval_should_throw_dvd_not_found_exception_if_dvd_repository_does_not_contain_reference() 
            throws Exception  {
        DvdRepository instance = createEmptyRepository();
        
        instance.retrieveDvd(NON_EXISTING_DVD);
    }
    
    @Test
    public void retrieval_should_obtain_dvd_from_decorated_repository() 
            throws Exception {
        Dvd existingDvd = createSomeDvd();
        DvdRepository instance = createRepositoryWithExistingDvd(existingDvd);

        Dvd retrievedDvd = instance.retrieveDvd(existingDvd.getReference());
        
        assertThat(retrievedDvd, equalTo(existingDvd));
    }
    
    //~~~~~~~~~~~~~~~ Test helpers

    protected DvdRepository createEmptyRepository() {
        DvdRepository decoratedRepository = mock(DvdRepository.class);
        DvdRepository instance = new ErrorCheckingDvdRepository(decoratedRepository);
        return instance;
    }

    protected DvdRepository createRepositoryWithExistingDvd(Dvd existingDvd) 
            throws InvalidReferenceSyntaxException, DvdNotFoundException {
        DvdRepository decoratedRepository = mock(DvdRepository.class);
        when(decoratedRepository.contains(any(String.class))).thenReturn(true);
        when(decoratedRepository.retrieveDvd(any(String.class))).thenReturn(existingDvd);
        DvdRepository instance = new ErrorCheckingDvdRepository(decoratedRepository);
        return instance;
    }

    protected Dvd createSomeDvd() {
        return new Dvd("DVD-test", "test", "test");
    }

    protected DvdRepository createRepositoryWithStubbedContains(boolean decoratedContains) {
        DvdRepository decoratedRepository = mock(DvdRepository.class);
        when(decoratedRepository.contains(any(String.class))).thenReturn(decoratedContains);
        DvdRepository instance = new ErrorCheckingDvdRepository(decoratedRepository);
        return instance;
    }
}