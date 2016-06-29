package org.sqlite;

import java.net.*;
import java.io.*;
import java.util.*;
import java.sql.*;

class Conn implements Connection
{
    private final String url;
    private String fileName;
    private DB db;
    private MetaData meta;
    private boolean autoCommit;
    private int transactionIsolation;
    private int timeout;
    private static final String RESOURCE_NAME_PREFIX = ":resource:";
    
    public Conn(final String s, final String s2) {
        this(s, s2, new Properties());
    }
    
    public Conn(final String url, final String fileName, final Properties properties) {
        this.db = null;
        this.meta = null;
        this.autoCommit = true;
        this.transactionIsolation = 8;
        this.timeout = 0;
        this.url = url;
        this.fileName = fileName;
        final SQLiteConfig sqLiteConfig = new SQLiteConfig(properties);
        this.open(sqLiteConfig.getOpenModeFlags());
        final boolean enabledSharedCache = sqLiteConfig.isEnabledSharedCache();
        final boolean enabledLoadExtension = sqLiteConfig.isEnabledLoadExtension();
        this.db.shared_cache(enabledSharedCache);
        this.db.enable_load_extension(enabledLoadExtension);
        sqLiteConfig.apply(this);
    }
    
    private void open(final int n) {
        if (!":memory:".equals(this.fileName)) {
            if (this.fileName.startsWith(":resource:")) {
                final String substring = this.fileName.substring(":resource:".length());
                URL resource = Thread.currentThread().getContextClassLoader().getResource(substring);
                if (resource == null) {
                    try {
                        resource = new URL(substring);
                    }
                    catch (MalformedURLException ex) {
                        throw new SQLException(String.format("resource %s not found: %s", substring, ex));
                    }
                }
                try {
                    this.fileName = this.extractResource(resource).getAbsolutePath();
                }
                catch (IOException ex2) {
                    throw new SQLException(String.format("failed to load %s: %s", substring, ex2));
                }
            }
            else {
                final File absoluteFile = new File(this.fileName).getAbsoluteFile();
                File parentFile = absoluteFile.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    for (File parentFile2 = parentFile; parentFile2 != null && !parentFile2.exists(); parentFile2 = parentFile2.getParentFile()) {
                        parentFile = parentFile2;
                    }
                    throw new SQLException("path to '" + this.fileName + "': '" + parentFile + "' does not exist");
                }
                try {
                    if (!absoluteFile.exists() && absoluteFile.createNewFile()) {
                        absoluteFile.delete();
                    }
                }
                catch (Exception ex3) {
                    throw new SQLException("opening db: '" + this.fileName + "': " + ex3.getMessage());
                }
                this.fileName = absoluteFile.getAbsolutePath();
            }
        }
        try {
            final Class<?> forName = Class.forName("org.sqlite.NativeDB");
            if (forName.getDeclaredMethod("load", (Class<?>[])null).invoke(null, (Object[])null)) {
                this.db = (DB)forName.newInstance();
            }
        }
        catch (Exception ex4) {}
        if (this.db == null) {
            try {
                this.db = (DB)Class.forName("org.sqlite.NestedDB").newInstance();
            }
            catch (Exception ex5) {
                throw new SQLException("no SQLite library found");
            }
        }
        this.db.open(this, this.fileName, n);
        this.setTimeout(3000);
    }
    
    private File extractResource(final URL url) {
        if (url.getProtocol().equals("file")) {
            try {
                return new File(url.toURI());
            }
            catch (URISyntaxException ex) {
                throw new IOException(ex.getMessage());
            }
        }
        final File file = new File(new File(System.getProperty("java.io.tmpdir")).getAbsolutePath(), String.format("sqlite-jdbc-tmp-%d.db", url.hashCode()));
        if (file.exists()) {
            if (url.openConnection().getLastModified() < file.lastModified()) {
                return file;
            }
            if (!file.delete()) {
                throw new IOException("failed to remove existing DB file: " + file.getAbsolutePath());
            }
        }
        final byte[] array = new byte[8192];
        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        final InputStream openStream = url.openStream();
        try {
            int read;
            while ((read = openStream.read(array)) != -1) {
                fileOutputStream.write(array, 0, read);
            }
            return file;
        }
        finally {
            fileOutputStream.close();
            openStream.close();
        }
    }
    
    int getTimeout() {
        return this.timeout;
    }
    
    void setTimeout(final int timeout) {
        this.timeout = timeout;
        this.db.busy_timeout(timeout);
    }
    
    String url() {
        return this.url;
    }
    
    String libversion() {
        return this.db.libversion();
    }
    
    DB db() {
        return this.db;
    }
    
    private void checkOpen() {
        if (this.db == null) {
            throw new SQLException("database connection closed");
        }
    }
    
    private void checkCursor(final int n, final int n2, final int n3) {
        if (n != 1003) {
            throw new SQLException("SQLite only supports TYPE_FORWARD_ONLY cursors");
        }
        if (n2 != 1007) {
            throw new SQLException("SQLite only supports CONCUR_READ_ONLY cursors");
        }
        if (n3 != 2) {
            throw new SQLException("SQLite only supports closing cursors at commit");
        }
    }
    
    public void finalize() {
        this.close();
    }
    
    public void close() {
        if (this.db == null) {
            return;
        }
        if (this.meta != null) {
            this.meta.close();
        }
        this.db.close();
        this.db = null;
    }
    
    public boolean isClosed() {
        return this.db == null;
    }
    
    public String getCatalog() {
        this.checkOpen();
        return null;
    }
    
    public void setCatalog(final String s) {
        this.checkOpen();
    }
    
    public int getHoldability() {
        this.checkOpen();
        return 2;
    }
    
    public void setHoldability(final int n) {
        this.checkOpen();
        if (n != 2) {
            throw new SQLException("SQLite only supports CLOSE_CURSORS_AT_COMMIT");
        }
    }
    
    public int getTransactionIsolation() {
        return this.transactionIsolation;
    }
    
    public void setTransactionIsolation(final int transactionIsolation) {
        switch (transactionIsolation) {
            case 8: {
                this.db.exec("PRAGMA read_uncommitted = false;");
                break;
            }
            case 1: {
                this.db.exec("PRAGMA read_uncommitted = true;");
                break;
            }
            default: {
                throw new SQLException("SQLite supports only TRANSACTION_SERIALIZABLE and TRANSACTION_READ_UNCOMMITTED.");
            }
        }
        this.transactionIsolation = transactionIsolation;
    }
    
    public Map getTypeMap() {
        throw new SQLException("not yet implemented");
    }
    
    public void setTypeMap(final Map map) {
        throw new SQLException("not yet implemented");
    }
    
    public boolean isReadOnly() {
        return false;
    }
    
    public void setReadOnly(final boolean b) {
    }
    
    public DatabaseMetaData getMetaData() {
        if (this.meta == null) {
            this.meta = new MetaData(this);
        }
        return this.meta;
    }
    
    public String nativeSQL(final String s) {
        return s;
    }
    
    public void clearWarnings() {
    }
    
    public SQLWarning getWarnings() {
        return null;
    }
    
    public boolean getAutoCommit() {
        this.checkOpen();
        return this.autoCommit;
    }
    
    public void setAutoCommit(final boolean autoCommit) {
        this.checkOpen();
        if (this.autoCommit == autoCommit) {
            return;
        }
        this.autoCommit = autoCommit;
        this.db.exec(this.autoCommit ? "commit;" : "begin;");
    }
    
    public void commit() {
        this.checkOpen();
        if (this.autoCommit) {
            throw new SQLException("database in auto-commit mode");
        }
        this.db.exec("commit;");
        this.db.exec("begin;");
    }
    
    public void rollback() {
        this.checkOpen();
        if (this.autoCommit) {
            throw new SQLException("database in auto-commit mode");
        }
        this.db.exec("rollback;");
        this.db.exec("begin;");
    }
    
    public Statement createStatement() {
        return this.createStatement(1003, 1007, 2);
    }
    
    public Statement createStatement(final int n, final int n2) {
        return this.createStatement(n, n2, 2);
    }
    
    public Statement createStatement(final int n, final int n2, final int n3) {
        this.checkCursor(n, n2, n3);
        return new Stmt(this);
    }
    
    public CallableStatement prepareCall(final String s) {
        return this.prepareCall(s, 1003, 1007, 2);
    }
    
    public CallableStatement prepareCall(final String s, final int n, final int n2) {
        return this.prepareCall(s, n, n2, 2);
    }
    
    public CallableStatement prepareCall(final String s, final int n, final int n2, final int n3) {
        throw new SQLException("SQLite does not support Stored Procedures");
    }
    
    public PreparedStatement prepareStatement(final String s) {
        return this.prepareStatement(s, 1003, 1007);
    }
    
    public PreparedStatement prepareStatement(final String s, final int n) {
        return this.prepareStatement(s);
    }
    
    public PreparedStatement prepareStatement(final String s, final int[] array) {
        return this.prepareStatement(s);
    }
    
    public PreparedStatement prepareStatement(final String s, final String[] array) {
        return this.prepareStatement(s);
    }
    
    public PreparedStatement prepareStatement(final String s, final int n, final int n2) {
        return this.prepareStatement(s, n, n2, 2);
    }
    
    public PreparedStatement prepareStatement(final String s, final int n, final int n2, final int n3) {
        this.checkCursor(n, n2, n3);
        return new PrepStmt(this, s);
    }
    
    String getDriverVersion() {
        if (this.db != null) {
            final String name = this.db.getClass().getName();
            if (name.indexOf("NestedDB") >= 0) {
                return "pure";
            }
            if (name.indexOf("NativeDB") >= 0) {
                return "native";
            }
        }
        return "unloaded";
    }
    
    public Savepoint setSavepoint() {
        throw new SQLException("unsupported by SQLite: savepoints");
    }
    
    public Savepoint setSavepoint(final String s) {
        throw new SQLException("unsupported by SQLite: savepoints");
    }
    
    public void releaseSavepoint(final Savepoint savepoint) {
        throw new SQLException("unsupported by SQLite: savepoints");
    }
    
    public void rollback(final Savepoint savepoint) {
        throw new SQLException("unsupported by SQLite: savepoints");
    }
    
    public Struct createStruct(final String s, final Object[] array) {
        throw new SQLException("unsupported by SQLite");
    }
}
