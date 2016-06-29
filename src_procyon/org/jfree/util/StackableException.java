package org.jfree.util;

import java.io.*;

public abstract class StackableException extends Exception
{
    private Exception parent;
    
    public StackableException() {
    }
    
    public StackableException(final String s, final Exception parent) {
        super(s);
        this.parent = parent;
    }
    
    public StackableException(final String s) {
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
    
    public void printStackTrace() {
        synchronized (System.err) {
            this.printStackTrace(System.err);
        }
    }
}
