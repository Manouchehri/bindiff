/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.sql.Connection;
import java.sql.DriverPropertyInfo;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import org.sqlite.JDBC;
import org.sqlite.SQLiteConfig$Encoding;
import org.sqlite.SQLiteConfig$JournalMode;
import org.sqlite.SQLiteConfig$LockingMode;
import org.sqlite.SQLiteConfig$Pragma;
import org.sqlite.SQLiteConfig$PragmaValue;
import org.sqlite.SQLiteConfig$SynchronousMode;
import org.sqlite.SQLiteConfig$TempStore;
import org.sqlite.SQLiteOpenMode;

public class SQLiteConfig {
    private final Properties pragmaTable;
    private int openModeFlag = 0;
    private static final String[] OnOff = new String[]{"true", "false"};

    public SQLiteConfig() {
        this(new Properties());
    }

    public SQLiteConfig(Properties properties) {
        this.pragmaTable = properties;
        String string = this.pragmaTable.getProperty(SQLiteConfig$Pragma.OPEN_MODE.pragmaName);
        if (string != null) {
            this.openModeFlag = Integer.parseInt(string);
            return;
        }
        this.setOpenMode(SQLiteOpenMode.READWRITE);
        this.setOpenMode(SQLiteOpenMode.CREATE);
    }

    public Connection createConnection(String string) {
        return JDBC.createConnection(string, this.toProperties());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void apply(Connection connection) {
        HashSet<String> hashSet = new HashSet<String>();
        for (SQLiteConfig$Pragma sQLiteConfig$Pragma2 : SQLiteConfig$Pragma.values()) {
            hashSet.add(sQLiteConfig$Pragma2.pragmaName);
        }
        hashSet.remove(SQLiteConfig$Pragma.OPEN_MODE.pragmaName);
        hashSet.remove(SQLiteConfig$Pragma.SHARED_CACHE.pragmaName);
        hashSet.remove(SQLiteConfig$Pragma.LOAD_EXTENSION.pragmaName);
        Statement statement = connection.createStatement();
        try {
            int n2 = 0;
            for (Object k2 : this.pragmaTable.keySet()) {
                String string;
                String string2 = k2.toString();
                if (!hashSet.contains(string2) || (string = this.pragmaTable.getProperty(string2)) == null) continue;
                String string3 = String.format("pragma %s=%s", string2, string);
                statement.addBatch(string3);
                ++n2;
            }
            if (n2 <= 0) return;
            statement.executeBatch();
            return;
        }
        finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    private void set(SQLiteConfig$Pragma sQLiteConfig$Pragma, boolean bl2) {
        this.setPragma(sQLiteConfig$Pragma, Boolean.toString(bl2));
    }

    private void set(SQLiteConfig$Pragma sQLiteConfig$Pragma, int n2) {
        this.setPragma(sQLiteConfig$Pragma, Integer.toString(n2));
    }

    private boolean getBoolean(SQLiteConfig$Pragma sQLiteConfig$Pragma, String string) {
        return Boolean.parseBoolean(this.pragmaTable.getProperty(sQLiteConfig$Pragma.pragmaName, string));
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

    public void setPragma(SQLiteConfig$Pragma sQLiteConfig$Pragma, String string) {
        this.pragmaTable.put(sQLiteConfig$Pragma.pragmaName, string);
    }

    public Properties toProperties() {
        this.pragmaTable.setProperty(SQLiteConfig$Pragma.OPEN_MODE.pragmaName, Integer.toString(this.openModeFlag));
        return this.pragmaTable;
    }

    static DriverPropertyInfo[] getDriverPropertyInfo() {
        SQLiteConfig$Pragma[] arrsQLiteConfig$Pragma = SQLiteConfig$Pragma.values();
        DriverPropertyInfo[] arrdriverPropertyInfo = new DriverPropertyInfo[arrsQLiteConfig$Pragma.length];
        int n2 = 0;
        SQLiteConfig$Pragma[] arrsQLiteConfig$Pragma2 = SQLiteConfig$Pragma.values();
        int n3 = arrsQLiteConfig$Pragma2.length;
        int n4 = 0;
        while (n4 < n3) {
            SQLiteConfig$Pragma sQLiteConfig$Pragma = arrsQLiteConfig$Pragma2[n4];
            DriverPropertyInfo driverPropertyInfo = new DriverPropertyInfo(sQLiteConfig$Pragma.pragmaName, null);
            driverPropertyInfo.choices = sQLiteConfig$Pragma.choices;
            driverPropertyInfo.description = sQLiteConfig$Pragma.description;
            driverPropertyInfo.required = false;
            arrdriverPropertyInfo[n2++] = driverPropertyInfo;
            ++n4;
        }
        return arrdriverPropertyInfo;
    }

    public void setOpenMode(SQLiteOpenMode sQLiteOpenMode) {
        this.openModeFlag |= sQLiteOpenMode.flag;
    }

    public void resetOpenMode(SQLiteOpenMode sQLiteOpenMode) {
        this.openModeFlag &= ~ sQLiteOpenMode.flag;
    }

    public void setSharedCache(boolean bl2) {
        this.set(SQLiteConfig$Pragma.SHARED_CACHE, bl2);
    }

    public void enableLoadExtension(boolean bl2) {
        this.set(SQLiteConfig$Pragma.LOAD_EXTENSION, bl2);
    }

    public void setReadOnly(boolean bl2) {
        if (bl2) {
            this.setOpenMode(SQLiteOpenMode.READONLY);
            this.resetOpenMode(SQLiteOpenMode.READWRITE);
            return;
        }
        this.setOpenMode(SQLiteOpenMode.READWRITE);
        this.resetOpenMode(SQLiteOpenMode.READONLY);
    }

    public void setCacheSize(int n2) {
        this.set(SQLiteConfig$Pragma.CACHE_SIZE, n2);
    }

    public void enableCaseSensitiveLike(boolean bl2) {
        this.set(SQLiteConfig$Pragma.CASE_SENSITIVE_LIKE, bl2);
    }

    public void enableCountChanges(boolean bl2) {
        this.set(SQLiteConfig$Pragma.COUNT_CHANGES, bl2);
    }

    public void setDefaultCacheSize(int n2) {
        this.set(SQLiteConfig$Pragma.DEFAULT_CACHE_SIZE, n2);
    }

    public void enableEmptyResultCallBacks(boolean bl2) {
        this.set(SQLiteConfig$Pragma.EMPTY_RESULT_CALLBACKS, bl2);
    }

    private static String[] toStringArray(SQLiteConfig$PragmaValue[] arrsQLiteConfig$PragmaValue) {
        String[] arrstring = new String[arrsQLiteConfig$PragmaValue.length];
        int n2 = 0;
        while (n2 < arrsQLiteConfig$PragmaValue.length) {
            arrstring[n2] = arrsQLiteConfig$PragmaValue[n2].getValue();
            ++n2;
        }
        return arrstring;
    }

    public void setEncoding(SQLiteConfig$Encoding sQLiteConfig$Encoding) {
        this.setPragma(SQLiteConfig$Pragma.ENCODING, sQLiteConfig$Encoding.typeName);
    }

    public void enforceForeignKeys(boolean bl2) {
        this.set(SQLiteConfig$Pragma.FOREIGN_KEYS, bl2);
    }

    public void enableFullColumnNames(boolean bl2) {
        this.set(SQLiteConfig$Pragma.FULL_COLUMN_NAMES, bl2);
    }

    public void enableFullSync(boolean bl2) {
        this.set(SQLiteConfig$Pragma.FULL_SYNC, bl2);
    }

    public void incrementalVacuum(int n2) {
        this.set(SQLiteConfig$Pragma.INCREMENTAL_VACUUM, n2);
    }

    public void setJournalMode(SQLiteConfig$JournalMode sQLiteConfig$JournalMode) {
        this.setPragma(SQLiteConfig$Pragma.JOURNAL_MODE, sQLiteConfig$JournalMode.name());
    }

    public void setJounalSizeLimit(int n2) {
        this.set(SQLiteConfig$Pragma.JOURNAL_SIZE_LIMIT, n2);
    }

    public void useLegacyFileFormat(boolean bl2) {
        this.set(SQLiteConfig$Pragma.LEGACY_FILE_FORMAT, bl2);
    }

    public void setLockingMode(SQLiteConfig$LockingMode sQLiteConfig$LockingMode) {
        this.setPragma(SQLiteConfig$Pragma.LOCKING_MODE, sQLiteConfig$LockingMode.name());
    }

    public void setPageSize(int n2) {
        this.set(SQLiteConfig$Pragma.PAGE_SIZE, n2);
    }

    public void setMaxPageCount(int n2) {
        this.set(SQLiteConfig$Pragma.MAX_PAGE_COUNT, n2);
    }

    public void setReadUncommited(boolean bl2) {
        this.set(SQLiteConfig$Pragma.READ_UNCOMMITED, bl2);
    }

    public void enableRecursiveTriggers(boolean bl2) {
        this.set(SQLiteConfig$Pragma.RECURSIVE_TRIGGERS, bl2);
    }

    public void enableReverseUnorderedSelects(boolean bl2) {
        this.set(SQLiteConfig$Pragma.REVERSE_UNORDERED_SELECTS, bl2);
    }

    public void enableShortColumnNames(boolean bl2) {
        this.set(SQLiteConfig$Pragma.SHORT_COLUMN_NAMES, bl2);
    }

    public void setSynchronous(SQLiteConfig$SynchronousMode sQLiteConfig$SynchronousMode) {
        this.setPragma(SQLiteConfig$Pragma.SYNCHRONOUS, sQLiteConfig$SynchronousMode.name());
    }

    public void setTempStore(SQLiteConfig$TempStore sQLiteConfig$TempStore) {
        this.setPragma(SQLiteConfig$Pragma.TEMP_STORE, sQLiteConfig$TempStore.name());
    }

    public void setTempStoreDirectory(String string) {
        this.setPragma(SQLiteConfig$Pragma.TEMP_STORE_DIRECTORY, String.format("'%s'", string));
    }

    public void setUserVersion(int n2) {
        this.set(SQLiteConfig$Pragma.USER_VERSION, n2);
    }

    static /* synthetic */ String[] access$000() {
        return OnOff;
    }

    static /* synthetic */ String[] access$100(SQLiteConfig$PragmaValue[] arrsQLiteConfig$PragmaValue) {
        return SQLiteConfig.toStringArray(arrsQLiteConfig$PragmaValue);
    }
}

