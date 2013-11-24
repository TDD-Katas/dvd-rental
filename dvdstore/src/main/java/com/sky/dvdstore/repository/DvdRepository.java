/*
 * Copyright � 2006-2010. BSkyB Ltd All Rights reserved
 */

package com.sky.dvdstore.repository;

import com.sky.dvdstore.data.Dvd;
import com.sky.dvdstore.exceptions.DvdNotFoundException;
import com.sky.dvdstore.exceptions.InvalidReferenceSyntaxException;

public interface DvdRepository {

    boolean contains(String reference);
    
    Dvd retrieveDvd(String reference) throws 
            InvalidReferenceSyntaxException, DvdNotFoundException ;
    
}
