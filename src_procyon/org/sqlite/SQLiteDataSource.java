package org.sqlite;

import javax.sql.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class SQLiteDataSource implements DataSource
{
    private SQLiteConfig config;
    private transient PrintWriter logger;
    private int loginTimeout;
    private String url;
    
    public SQLiteDataSource() {
        this.loginTimeout = 1;
        this.url = "jdbc:sqlite:";
        this.config = new SQLiteConfig();
    }
    
    public SQLiteDataSource(final SQLiteConfig config) {
        this.loginTimeout = 1;
        this.url = "jdbc:sqlite:";
        this.config = config;
    }
    
    public void setConfig(final SQLiteConfig config) {
        this.config = config;
    }
    
    public SQLiteConfig getConfig() {
        return this.config;
    }
    
    public void setUrl(final String url) {
        this.url = url;
    }
    
    public String getUrl() {
        return this.url;
    }
    
    public void setSharedCache(final boolean sharedCache) {
        this.config.setSharedCache(sharedCache);
    }
    
    public void setLoadExtension(final boolean b) {
        this.config.enableLoadExtension(b);
    }
    
    public void setReadOnly(final boolean readOnly) {
        this.config.setReadOnly(readOnly);
    }
    
    public void setCacheSize(final int cacheSize) {
        this.config.setCacheSize(cacheSize);
    }
    
    public void setCaseSensitiveLike(final boolean b) {
        this.config.enableCaseSensitiveLike(b);
    }
    
    public void setCouncChanges(final boolean b) {
        this.config.enableCountChanges(b);
    }
    
    public void setDefaultCacheSize(final int defaultCacheSize) {
        this.config.setDefaultCacheSize(defaultCacheSize);
    }
    
    public void setEncoding(final String s) {
        this.config.setEncoding(SQLiteConfig$Encoding.valueOf(s));
    }
    
    public void setEnforceForeinKeys(final boolean b) {
        this.config.enforceForeignKeys(b);
    }
    
    public void setFullColumnNames(final boolean b) {
        this.config.enableFullColumnNames(b);
    }
    
    public void setFullSync(final boolean b) {
        this.config.enableFullSync(b);
    }
    
    public void setIncrementalVacuum(final int n) {
        this.config.incrementalVacuum(n);
    }
    
    public void setJournalMode(final String s) {
        this.config.setJournalMode(SQLiteConfig$JournalMode.valueOf(s));
    }
    
    public void setJournalSizeLimit(final int jounalSizeLimit) {
        this.config.setJounalSizeLimit(jounalSizeLimit);
    }
    
    public void setLegacyFileFormat(final boolean b) {
        this.config.useLegacyFileFormat(b);
    }
    
    public void setLockingMode(final String s) {
        this.config.setLockingMode(SQLiteConfig$LockingMode.valueOf(s));
    }
    
    public void setPageSize(final int pageSize) {
        this.config.setPageSize(pageSize);
    }
    
    public void setMaxPageCount(final int maxPageCount) {
        this.config.setMaxPageCount(maxPageCount);
    }
    
    public void setReadUncommited(final boolean readUncommited) {
        this.config.setReadUncommited(readUncommited);
    }
    
    public void setRecursiveTriggers(final boolean b) {
        this.config.enableRecursiveTriggers(b);
    }
    
    public void setReverseUnorderedSelects(final boolean b) {
        this.config.enableReverseUnorderedSelects(b);
    }
    
    public void setShortColumnNames(final boolean b) {
        this.config.enableShortColumnNames(b);
    }
    
    public void setSynchronous(final String s) {
        this.config.setSynchronous(SQLiteConfig$SynchronousMode.valueOf(s));
    }
    
    public void setTempStore(final String s) {
        this.config.setTempStore(SQLiteConfig$TempStore.valueOf(s));
    }
    
    public void setTempStoreDirectory(final String tempStoreDirectory) {
        this.config.setTempStoreDirectory(tempStoreDirectory);
    }
    
    public void setUserVersion(final int userVersion) {
        this.config.setUserVersion(userVersion);
    }
    
    public Connection getConnection() {
        return this.getConnection(null, null);
    }
    
    public Connection getConnection(final String s, final String s2) {
        final Properties properties = this.config.toProperties();
        if (s != null) {
            ((Hashtable<String, String>)properties).put("user", s);
        }
        if (s2 != null) {
            ((Hashtable<String, String>)properties).put("pass", s2);
        }
        return JDBC.createConnection(this.url, properties);
    }
    
    public PrintWriter getLogWriter() {
        return this.logger;
    }
    
    public int getLoginTimeout() {
        return this.loginTimeout;
    }
    
    public void setLogWriter(final PrintWriter logger) {
        this.logger = logger;
    }
    
    public void setLoginTimeout(final int loginTimeout) {
        this.loginTimeout = loginTimeout;
    }
    
    public boolean isWrapperFor(final Class clazz) {
        return clazz.isInstance(this);
    }
    
    public Object unwrap(final Class clazz) {
        return this;
    }
}
