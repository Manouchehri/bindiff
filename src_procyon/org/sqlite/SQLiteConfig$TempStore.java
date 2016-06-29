package org.sqlite;

public enum SQLiteConfig$TempStore implements SQLiteConfig$PragmaValue
{
    DEFAULT("DEFAULT", 0), 
    FILE("FILE", 1), 
    MEMORY("MEMORY", 2);
    
    private SQLiteConfig$TempStore(final String s, final int n) {
    }
    
    public String getValue() {
        return this.name();
    }
}
