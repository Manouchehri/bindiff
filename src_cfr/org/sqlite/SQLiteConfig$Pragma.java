/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteConfig$Encoding;
import org.sqlite.SQLiteConfig$JournalMode;
import org.sqlite.SQLiteConfig$LockingMode;
import org.sqlite.SQLiteConfig$SynchronousMode;
import org.sqlite.SQLiteConfig$TempStore;

enum SQLiteConfig$Pragma {
    OPEN_MODE("open_mode", "Database open-mode flag", null),
    SHARED_CACHE("shared_cache", "Enablse SQLite Shared-Cache mode, native driver only", SQLiteConfig.access$000()),
    LOAD_EXTENSION("enable_load_extension", "Enable SQLite load_extention() function, native driver only", SQLiteConfig.access$000()),
    CACHE_SIZE("cache_size"),
    CASE_SENSITIVE_LIKE("case_sensitive_like", SQLiteConfig.access$000()),
    COUNT_CHANGES("count_changes", SQLiteConfig.access$000()),
    DEFAULT_CACHE_SIZE("default_cache_size"),
    EMPTY_RESULT_CALLBACKS("empty_result_callback", SQLiteConfig.access$000()),
    ENCODING("encoding", SQLiteConfig.access$100(SQLiteConfig$Encoding.values())),
    FOREIGN_KEYS("foreign_keys", SQLiteConfig.access$000()),
    FULL_COLUMN_NAMES("full_column_names", SQLiteConfig.access$000()),
    FULL_SYNC("fullsync", SQLiteConfig.access$000()),
    INCREMENTAL_VACUUM("incremental_vacuum"),
    JOURNAL_MODE("journal_mode", SQLiteConfig.access$100(SQLiteConfig$JournalMode.values())),
    JOURNAL_SIZE_LIMIT("journal_size_limit"),
    LEGACY_FILE_FORMAT("legacy_file_format", SQLiteConfig.access$000()),
    LOCKING_MODE("locking_mode", SQLiteConfig.access$100(SQLiteConfig$LockingMode.values())),
    PAGE_SIZE("page_size"),
    MAX_PAGE_COUNT("max_page_count"),
    READ_UNCOMMITED("read_uncommited", SQLiteConfig.access$000()),
    RECURSIVE_TRIGGERS("recursive_triggers", SQLiteConfig.access$000()),
    REVERSE_UNORDERED_SELECTS("reverse_unordered_selects", SQLiteConfig.access$000()),
    SHORT_COLUMN_NAMES("short_column_names", SQLiteConfig.access$000()),
    SYNCHRONOUS("synchronous", SQLiteConfig.access$100(SQLiteConfig$SynchronousMode.values())),
    TEMP_STORE("temp_store", SQLiteConfig.access$100(SQLiteConfig$TempStore.values())),
    TEMP_STORE_DIRECTORY("temp_store_directory"),
    USER_VERSION("user_version");
    
    public final String pragmaName;
    public final String[] choices;
    public final String description;

    private SQLiteConfig$Pragma(String string2) {
        this(string2, null);
    }

    private SQLiteConfig$Pragma(String string2, String[] arrstring) {
        this(string2, null, null);
    }

    private SQLiteConfig$Pragma(String string2, String string3, String[] arrstring) {
        this.pragmaName = string2;
        this.description = string3;
        this.choices = arrstring;
    }
}

