package org.sqlite;

public enum SQLiteConfig$SynchronousMode implements SQLiteConfig$PragmaValue
{
    OFF("OFF", 0), 
    NORMAL("NORMAL", 1), 
    FULL("FULL", 2);
    
    private SQLiteConfig$SynchronousMode(final String s, final int n) {
    }
    
    public String getValue() {
        return this.name();
    }
}
