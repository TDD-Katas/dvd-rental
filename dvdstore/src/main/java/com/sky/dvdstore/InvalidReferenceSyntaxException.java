/*
 * Copyright � 2006-2010. BSkyB Ltd All Rights reserved
 */

package com.sky.dvdstore;

public class InvalidReferenceSyntaxException extends Exception {

    public InvalidReferenceSyntaxException() {
        super("Invalid reference syntax, it should begin with DVD");
    }
}
