package org.sqlite;

public enum SQLiteConfig$JournalMode implements SQLiteConfig$PragmaValue
{
    DELETE("DELETE", 0), 
    TRUNCATE("TRUNCATE", 1), 
    PERSIST("PERSIST", 2), 
    MEMORY("MEMORY", 3), 
    OFF("OFF", 4);
    
    private SQLiteConfig$JournalMode(final String s, final int n) {
    }
    
    public String getValue() {
        return this.name();
    }
}
