/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Properties;
import javax.sql.DataSource;
import org.sqlite.JDBC;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteConfig$Encoding;
import org.sqlite.SQLiteConfig$JournalMode;
import org.sqlite.SQLiteConfig$LockingMode;
import org.sqlite.SQLiteConfig$SynchronousMode;
import org.sqlite.SQLiteConfig$TempStore;

public class SQLiteDataSource
implements DataSource {
    private SQLiteConfig config;
    private transient PrintWriter logger;
    private int loginTimeout = 1;
    private String url = "jdbc:sqlite:";

    public SQLiteDataSource() {
        this.config = new SQLiteConfig();
    }

    public SQLiteDataSource(SQLiteConfig sQLiteConfig) {
        this.config = sQLiteConfig;
    }

    public void setConfig(SQLiteConfig sQLiteConfig) {
        this.config = sQLiteConfig;
    }

    public SQLiteConfig getConfig() {
        return this.config;
    }

    public void setUrl(String string) {
        this.url = string;
    }

    public String getUrl() {
        return this.url;
    }

    public void setSharedCache(boolean bl2) {
        this.config.setSharedCache(bl2);
    }

    public void setLoadExtension(boolean bl2) {
        this.config.enableLoadExtension(bl2);
    }

    public void setReadOnly(boolean bl2) {
        this.config.setReadOnly(bl2);
    }

    public void setCacheSize(int n2) {
        this.config.setCacheSize(n2);
    }

    public void setCaseSensitiveLike(boolean bl2) {
        this.config.enableCaseSensitiveLike(bl2);
    }

    public void setCouncChanges(boolean bl2) {
        this.config.enableCountChanges(bl2);
    }

    public void setDefaultCacheSize(int n2) {
        this.config.setDefaultCacheSize(n2);
    }

    public void setEncoding(String string) {
        this.config.setEncoding(SQLiteConfig$Encoding.valueOf(string));
    }

    public void setEnforceForeinKeys(boolean bl2) {
        this.config.enforceForeignKeys(bl2);
    }

    public void setFullColumnNames(boolean bl2) {
        this.config.enableFullColumnNames(bl2);
    }

    public void setFullSync(boolean bl2) {
        this.config.enableFullSync(bl2);
    }

    public void setIncrementalVacuum(int n2) {
        this.config.incrementalVacuum(n2);
    }

    public void setJournalMode(String string) {
        this.config.setJournalMode(SQLiteConfig$JournalMode.valueOf(string));
    }

    public void setJournalSizeLimit(int n2) {
        this.config.setJounalSizeLimit(n2);
    }

    public void setLegacyFileFormat(boolean bl2) {
        this.config.useLegacyFileFormat(bl2);
    }

    public void setLockingMode(String string) {
        this.config.setLockingMode(SQLiteConfig$LockingMode.valueOf(string));
    }

    public void setPageSize(int n2) {
        this.config.setPageSize(n2);
    }

    public void setMaxPageCount(int n2) {
        this.config.setMaxPageCount(n2);
    }

    public void setReadUncommited(boolean bl2) {
        this.config.setReadUncommited(bl2);
    }

    public void setRecursiveTriggers(boolean bl2) {
        this.config.enableRecursiveTriggers(bl2);
    }

    public void setReverseUnorderedSelects(boolean bl2) {
        this.config.enableReverseUnorderedSelects(bl2);
    }

    public void setShortColumnNames(boolean bl2) {
        this.config.enableShortColumnNames(bl2);
    }

    public void setSynchronous(String string) {
        this.config.setSynchronous(SQLiteConfig$SynchronousMode.valueOf(string));
    }

    public void setTempStore(String string) {
        this.config.setTempStore(SQLiteConfig$TempStore.valueOf(string));
    }

    public void setTempStoreDirectory(String string) {
        this.config.setTempStoreDirectory(string);
    }

    public void setUserVersion(int n2) {
        this.config.setUserVersion(n2);
    }

    @Override
    public Connection getConnection() {
        return this.getConnection(null, null);
    }

    @Override
    public Connection getConnection(String string, String string2) {
        Properties properties = this.config.toProperties();
        if (string != null) {
            properties.put("user", string);
        }
        if (string2 == null) return JDBC.createConnection(this.url, properties);
        properties.put("pass", string2);
        return JDBC.createConnection(this.url, properties);
    }

    @Override
    public PrintWriter getLogWriter() {
        return this.logger;
    }

    @Override
    public int getLoginTimeout() {
        return this.loginTimeout;
    }

    @Override
    public void setLogWriter(PrintWriter printWriter) {
        this.logger = printWriter;
    }

    @Override
    public void setLoginTimeout(int n2) {
        this.loginTimeout = n2;
    }

    public boolean isWrapperFor(Class class_) {
        return class_.isInstance(this);
    }

    public Object unwrap(Class class_) {
        return this;
    }
}

