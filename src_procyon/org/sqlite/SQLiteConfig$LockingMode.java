package org.sqlite;

public enum SQLiteConfig$LockingMode implements SQLiteConfig$PragmaValue
{
    NORMAL("NORMAL", 0), 
    EXCLUSIVE("EXCLUSIVE", 1);
    
    private SQLiteConfig$LockingMode(final String s, final int n) {
    }
    
    public String getValue() {
        return this.name();
    }
}
