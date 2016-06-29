package org.ibex.nestedvm;

public class Runtime$ExecutionException extends Exception
{
    private String message;
    private String location;
    
    public Runtime$ExecutionException() {
        this.message = "(null)";
        this.location = "(unknown)";
    }
    
    public Runtime$ExecutionException(final String message) {
        this.message = "(null)";
        this.location = "(unknown)";
        if (message != null) {
            this.message = message;
        }
    }
    
    void setLocation(final String s) {
        this.location = ((s == null) ? "(unknown)" : s);
    }
    
    public final String getMessage() {
        return this.message + " at " + this.location;
    }
}
