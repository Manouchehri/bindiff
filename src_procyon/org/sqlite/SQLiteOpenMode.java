package org.sqlite;

public enum SQLiteOpenMode
{
    READONLY("READONLY", 0, 1), 
    READWRITE("READWRITE", 1, 2), 
    CREATE("CREATE", 2, 4), 
    DELETEONCLOSE("DELETEONCLOSE", 3, 8), 
    EXCLUSIVE("EXCLUSIVE", 4, 16), 
    MAIN_DB("MAIN_DB", 5, 256), 
    TEMP_DB("TEMP_DB", 6, 512), 
    TRANSIENT_DB("TRANSIENT_DB", 7, 1024), 
    MAIN_JOURNAL("MAIN_JOURNAL", 8, 2048), 
    TEMP_JOURNAL("TEMP_JOURNAL", 9, 4096), 
    SUBJOURNAL("SUBJOURNAL", 10, 8192), 
    MASTER_JOURNAL("MASTER_JOURNAL", 11, 16384), 
    NOMUTEX("NOMUTEX", 12, 32768), 
    FULLMUTEX("FULLMUTEX", 13, 65536), 
    SHAREDCACHE("SHAREDCACHE", 14, 131072), 
    PRIVATECACHE("PRIVATECACHE", 15, 262144);
    
    public final int flag;
    
    private SQLiteOpenMode(final String s, final int n, final int flag) {
        this.flag = flag;
    }
}
