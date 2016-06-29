package org.jfree.data.general;

import java.io.*;

public class SeriesException extends RuntimeException implements Serializable
{
    private static final long serialVersionUID = -3667048387550852940L;
    
    public SeriesException(final String s) {
        super(s);
    }
}
