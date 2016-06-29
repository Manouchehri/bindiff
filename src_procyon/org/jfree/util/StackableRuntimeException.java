package org.jfree.util;

import java.io.*;

public class StackableRuntimeException extends RuntimeException
{
    private Exception parent;
    
    public StackableRuntimeException() {
    }
    
    public StackableRuntimeException(final String s, final Exception parent) {
        super(s);
        this.parent = parent;
    }
    
    public StackableRuntimeException(final String s) {
        super(s);
    }
    
    public Exception getParent() {
        return this.parent;
    }
    
    public void printStackTrace(final PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.getParent() != null) {
            printStream.println("ParentException: ");
            this.getParent().printStackTrace(printStream);
        }
    }
    
    public void printStackTrace(final PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.getParent() != null) {
            printWriter.println("ParentException: ");
            this.getParent().printStackTrace(printWriter);
        }
    }
}
