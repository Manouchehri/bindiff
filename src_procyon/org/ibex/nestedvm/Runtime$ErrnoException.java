package org.ibex.nestedvm;

public class Runtime$ErrnoException extends Exception
{
    public int errno;
    
    public Runtime$ErrnoException(final int errno) {
        super("Errno: " + errno);
        this.errno = errno;
    }
}
