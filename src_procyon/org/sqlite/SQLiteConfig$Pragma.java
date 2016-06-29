package org.sqlite;

import java.util.*;
import java.sql.*;

enum SQLiteConfig$Pragma
{
    OPEN_MODE("OPEN_MODE", 0, "open_mode", "Database open-mode flag", (String[])null), 
    SHARED_CACHE("SHARED_CACHE", 1, "shared_cache", "Enablse SQLite Shared-Cache mode, native driver only", SQLiteConfig.OnOff), 
    LOAD_EXTENSION("LOAD_EXTENSION", 2, "enable_load_extension", "Enable SQLite load_extention() function, native driver only", SQLiteConfig.OnOff), 
    CACHE_SIZE("CACHE_SIZE", 3, "cache_size"), 
    CASE_SENSITIVE_LIKE("CASE_SENSITIVE_LIKE", 4, "case_sensitive_like", SQLiteConfig.OnOff), 
    COUNT_CHANGES("COUNT_CHANGES", 5, "count_changes", SQLiteConfig.OnOff), 
    DEFAULT_CACHE_SIZE("DEFAULT_CACHE_SIZE", 6, "default_cache_size"), 
    EMPTY_RESULT_CALLBACKS("EMPTY_RESULT_CALLBACKS", 7, "empty_result_callback", SQLiteConfig.OnOff), 
    ENCODING("ENCODING", 8, "encoding", toStringArray(SQLiteConfig$Encoding.values())), 
    FOREIGN_KEYS("FOREIGN_KEYS", 9, "foreign_keys", SQLiteConfig.OnOff), 
    FULL_COLUMN_NAMES("FULL_COLUMN_NAMES", 10, "full_column_names", SQLiteConfig.OnOff), 
    FULL_SYNC("FULL_SYNC", 11, "fullsync", SQLiteConfig.OnOff), 
    INCREMENTAL_VACUUM("INCREMENTAL_VACUUM", 12, "incremental_vacuum"), 
    JOURNAL_MODE("JOURNAL_MODE", 13, "journal_mode", toStringArray(SQLiteConfig$JournalMode.values())), 
    JOURNAL_SIZE_LIMIT("JOURNAL_SIZE_LIMIT", 14, "journal_size_limit"), 
    LEGACY_FILE_FORMAT("LEGACY_FILE_FORMAT", 15, "legacy_file_format", SQLiteConfig.OnOff), 
    LOCKING_MODE("LOCKING_MODE", 16, "locking_mode", toStringArray(SQLiteConfig$LockingMode.values())), 
    PAGE_SIZE("PAGE_SIZE", 17, "page_size"), 
    MAX_PAGE_COUNT("MAX_PAGE_COUNT", 18, "max_page_count"), 
    READ_UNCOMMITED("READ_UNCOMMITED", 19, "read_uncommited", SQLiteConfig.OnOff), 
    RECURSIVE_TRIGGERS("RECURSIVE_TRIGGERS", 20, "recursive_triggers", SQLiteConfig.OnOff), 
    REVERSE_UNORDERED_SELECTS("REVERSE_UNORDERED_SELECTS", 21, "reverse_unordered_selects", SQLiteConfig.OnOff), 
    SHORT_COLUMN_NAMES("SHORT_COLUMN_NAMES", 22, "short_column_names", SQLiteConfig.OnOff), 
    SYNCHRONOUS("SYNCHRONOUS", 23, "synchronous", toStringArray(SQLiteConfig$SynchronousMode.values())), 
    TEMP_STORE("TEMP_STORE", 24, "temp_store", toStringArray(SQLiteConfig$TempStore.values())), 
    TEMP_STORE_DIRECTORY("TEMP_STORE_DIRECTORY", 25, "temp_store_directory"), 
    USER_VERSION("USER_VERSION", 26, "user_version");
    
    public final String pragmaName;
    public final String[] choices;
    public final String description;
    
    private SQLiteConfig$Pragma(final String s, final int n, final String s2) {
        this(s, n, s2, null);
    }
    
    private SQLiteConfig$Pragma(final String s, final int n, final String s2, final String[] array) {
        this(s, n, s2, null, null);
    }
    
    private SQLiteConfig$Pragma(final String s, final int n, final String pragmaName, final String description, final String[] choices) {
        this.pragmaName = pragmaName;
        this.description = description;
        this.choices = choices;
    }
}
