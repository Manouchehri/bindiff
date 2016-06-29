package org.sqlite;

import java.sql.*;
import java.util.*;

public class SQLiteConfig
{
    private final Properties pragmaTable;
    private int openModeFlag;
    private static final String[] OnOff;
    
    public SQLiteConfig() {
        this(new Properties());
    }
    
    public SQLiteConfig(final Properties pragmaTable) {
        this.openModeFlag = 0;
        this.pragmaTable = pragmaTable;
        final String property = this.pragmaTable.getProperty(SQLiteConfig$Pragma.OPEN_MODE.pragmaName);
        if (property != null) {
            this.openModeFlag = Integer.parseInt(property);
        }
        else {
            this.setOpenMode(SQLiteOpenMode.READWRITE);
            this.setOpenMode(SQLiteOpenMode.CREATE);
        }
    }
    
    public Connection createConnection(final String s) {
        return JDBC.createConnection(s, this.toProperties());
    }
    
    public void apply(final Connection connection) {
        final HashSet<String> set = new HashSet<String>();
        final SQLiteConfig$Pragma[] values = SQLiteConfig$Pragma.values();
        for (int length = values.length, i = 0; i < length; ++i) {
            set.add(values[i].pragmaName);
        }
        set.remove(SQLiteConfig$Pragma.OPEN_MODE.pragmaName);
        set.remove(SQLiteConfig$Pragma.SHARED_CACHE.pragmaName);
        set.remove(SQLiteConfig$Pragma.LOAD_EXTENSION.pragmaName);
        final Statement statement = connection.createStatement();
        try {
            int n = 0;
            final Iterator<Object> iterator = ((Hashtable<Object, V>)this.pragmaTable).keySet().iterator();
            while (iterator.hasNext()) {
                final String string = iterator.next().toString();
                if (!set.contains(string)) {
                    continue;
                }
                final String property = this.pragmaTable.getProperty(string);
                if (property == null) {
                    continue;
                }
                statement.addBatch(String.format("pragma %s=%s", string, property));
                ++n;
            }
            if (n > 0) {
                statement.executeBatch();
            }
        }
        finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
    
    private void set(final SQLiteConfig$Pragma sqLiteConfig$Pragma, final boolean b) {
        this.setPragma(sqLiteConfig$Pragma, Boolean.toString(b));
    }
    
    private void set(final SQLiteConfig$Pragma sqLiteConfig$Pragma, final int n) {
        this.setPragma(sqLiteConfig$Pragma, Integer.toString(n));
    }
    
    private boolean getBoolean(final SQLiteConfig$Pragma sqLiteConfig$Pragma, final String s) {
        return Boolean.parseBoolean(this.pragmaTable.getProperty(sqLiteConfig$Pragma.pragmaName, s));
    }
    
    public boolean isEnabledSharedCache() {
        return this.getBoolean(SQLiteConfig$Pragma.SHARED_CACHE, "false");
    }
    
    public boolean isEnabledLoadExtension() {
        return this.getBoolean(SQLiteConfig$Pragma.LOAD_EXTENSION, "false");
    }
    
    public int getOpenModeFlags() {
        return this.openModeFlag;
    }
    
    public void setPragma(final SQLiteConfig$Pragma sqLiteConfig$Pragma, final String s) {
        ((Hashtable<String, String>)this.pragmaTable).put(sqLiteConfig$Pragma.pragmaName, s);
    }
    
    public Properties toProperties() {
        this.pragmaTable.setProperty(SQLiteConfig$Pragma.OPEN_MODE.pragmaName, Integer.toString(this.openModeFlag));
        return this.pragmaTable;
    }
    
    static DriverPropertyInfo[] getDriverPropertyInfo() {
        final DriverPropertyInfo[] array = new DriverPropertyInfo[SQLiteConfig$Pragma.values().length];
        int n = 0;
        for (final SQLiteConfig$Pragma sqLiteConfig$Pragma : SQLiteConfig$Pragma.values()) {
            final DriverPropertyInfo driverPropertyInfo = new DriverPropertyInfo(sqLiteConfig$Pragma.pragmaName, null);
            driverPropertyInfo.choices = sqLiteConfig$Pragma.choices;
            driverPropertyInfo.description = sqLiteConfig$Pragma.description;
            driverPropertyInfo.required = false;
            array[n++] = driverPropertyInfo;
        }
        return array;
    }
    
    public void setOpenMode(final SQLiteOpenMode sqLiteOpenMode) {
        this.openModeFlag |= sqLiteOpenMode.flag;
    }
    
    public void resetOpenMode(final SQLiteOpenMode sqLiteOpenMode) {
        this.openModeFlag &= ~sqLiteOpenMode.flag;
    }
    
    public void setSharedCache(final boolean b) {
        this.set(SQLiteConfig$Pragma.SHARED_CACHE, b);
    }
    
    public void enableLoadExtension(final boolean b) {
        this.set(SQLiteConfig$Pragma.LOAD_EXTENSION, b);
    }
    
    public void setReadOnly(final boolean b) {
        if (b) {
            this.setOpenMode(SQLiteOpenMode.READONLY);
            this.resetOpenMode(SQLiteOpenMode.READWRITE);
        }
        else {
            this.setOpenMode(SQLiteOpenMode.READWRITE);
            this.resetOpenMode(SQLiteOpenMode.READONLY);
        }
    }
    
    public void setCacheSize(final int n) {
        this.set(SQLiteConfig$Pragma.CACHE_SIZE, n);
    }
    
    public void enableCaseSensitiveLike(final boolean b) {
        this.set(SQLiteConfig$Pragma.CASE_SENSITIVE_LIKE, b);
    }
    
    public void enableCountChanges(final boolean b) {
        this.set(SQLiteConfig$Pragma.COUNT_CHANGES, b);
    }
    
    public void setDefaultCacheSize(final int n) {
        this.set(SQLiteConfig$Pragma.DEFAULT_CACHE_SIZE, n);
    }
    
    public void enableEmptyResultCallBacks(final boolean b) {
        this.set(SQLiteConfig$Pragma.EMPTY_RESULT_CALLBACKS, b);
    }
    
    private static String[] toStringArray(final SQLiteConfig$PragmaValue[] array) {
        final String[] array2 = new String[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i].getValue();
        }
        return array2;
    }
    
    public void setEncoding(final SQLiteConfig$Encoding sqLiteConfig$Encoding) {
        this.setPragma(SQLiteConfig$Pragma.ENCODING, sqLiteConfig$Encoding.typeName);
    }
    
    public void enforceForeignKeys(final boolean b) {
        this.set(SQLiteConfig$Pragma.FOREIGN_KEYS, b);
    }
    
    public void enableFullColumnNames(final boolean b) {
        this.set(SQLiteConfig$Pragma.FULL_COLUMN_NAMES, b);
    }
    
    public void enableFullSync(final boolean b) {
        this.set(SQLiteConfig$Pragma.FULL_SYNC, b);
    }
    
    public void incrementalVacuum(final int n) {
        this.set(SQLiteConfig$Pragma.INCREMENTAL_VACUUM, n);
    }
    
    public void setJournalMode(final SQLiteConfig$JournalMode sqLiteConfig$JournalMode) {
        this.setPragma(SQLiteConfig$Pragma.JOURNAL_MODE, sqLiteConfig$JournalMode.name());
    }
    
    public void setJounalSizeLimit(final int n) {
        this.set(SQLiteConfig$Pragma.JOURNAL_SIZE_LIMIT, n);
    }
    
    public void useLegacyFileFormat(final boolean b) {
        this.set(SQLiteConfig$Pragma.LEGACY_FILE_FORMAT, b);
    }
    
    public void setLockingMode(final SQLiteConfig$LockingMode sqLiteConfig$LockingMode) {
        this.setPragma(SQLiteConfig$Pragma.LOCKING_MODE, sqLiteConfig$LockingMode.name());
    }
    
    public void setPageSize(final int n) {
        this.set(SQLiteConfig$Pragma.PAGE_SIZE, n);
    }
    
    public void setMaxPageCount(final int n) {
        this.set(SQLiteConfig$Pragma.MAX_PAGE_COUNT, n);
    }
    
    public void setReadUncommited(final boolean b) {
        this.set(SQLiteConfig$Pragma.READ_UNCOMMITED, b);
    }
    
    public void enableRecursiveTriggers(final boolean b) {
        this.set(SQLiteConfig$Pragma.RECURSIVE_TRIGGERS, b);
    }
    
    public void enableReverseUnorderedSelects(final boolean b) {
        this.set(SQLiteConfig$Pragma.REVERSE_UNORDERED_SELECTS, b);
    }
    
    public void enableShortColumnNames(final boolean b) {
        this.set(SQLiteConfig$Pragma.SHORT_COLUMN_NAMES, b);
    }
    
    public void setSynchronous(final SQLiteConfig$SynchronousMode sqLiteConfig$SynchronousMode) {
        this.setPragma(SQLiteConfig$Pragma.SYNCHRONOUS, sqLiteConfig$SynchronousMode.name());
    }
    
    public void setTempStore(final SQLiteConfig$TempStore sqLiteConfig$TempStore) {
        this.setPragma(SQLiteConfig$Pragma.TEMP_STORE, sqLiteConfig$TempStore.name());
    }
    
    public void setTempStoreDirectory(final String s) {
        this.setPragma(SQLiteConfig$Pragma.TEMP_STORE_DIRECTORY, String.format("'%s'", s));
    }
    
    public void setUserVersion(final int n) {
        this.set(SQLiteConfig$Pragma.USER_VERSION, n);
    }
    
    static {
        OnOff = new String[] { "true", "false" };
    }
}
