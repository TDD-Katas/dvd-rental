/*
 * Copyright � 2006-2010. BSkyB Ltd All Rights reserved
 */
package com.sky.dvdstore;

import com.sky.dvdstore.exceptions.InvalidReferenceSyntaxException;
import com.sky.dvdstore.exceptions.DvdNotFoundException;
import com.sky.dvdstore.data.Dvd;

public interface DvdService {

	Dvd retrieveDvd(String dvdReference) throws InvalidReferenceSyntaxException,DvdNotFoundException;

	String getDvdSummary(String dvdReference) throws InvalidReferenceSyntaxException,DvdNotFoundException;
    
}
