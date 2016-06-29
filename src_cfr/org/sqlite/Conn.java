/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import org.sqlite.DB;
import org.sqlite.MetaData;
import org.sqlite.PrepStmt;
import org.sqlite.SQLiteConfig;
import org.sqlite.Stmt;

class Conn
implements Connection {
    private final String url;
    private String fileName;
    private DB db = null;
    private MetaData meta = null;
    private boolean autoCommit = true;
    private int transactionIsolation = 8;
    private int timeout = 0;
    private static final String RESOURCE_NAME_PREFIX = ":resource:";

    public Conn(String string, String string2) {
        this(string, string2, new Properties());
    }

    public Conn(String string, String string2, Properties properties) {
        this.url = string;
        this.fileName = string2;
        SQLiteConfig sQLiteConfig = new SQLiteConfig(properties);
        this.open(sQLiteConfig.getOpenModeFlags());
        boolean bl2 = sQLiteConfig.isEnabledSharedCache();
        boolean bl3 = sQLiteConfig.isEnabledLoadExtension();
        this.db.shared_cache(bl2);
        this.db.enable_load_extension(bl3);
        sQLiteConfig.apply(this);
    }

    private void open(int n2) {
        Object object;
        if (!":memory:".equals(this.fileName)) {
            if (this.fileName.startsWith(":resource:")) {
                object = this.fileName.substring(":resource:".length());
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                URL uRL = classLoader.getResource((String)object);
                if (uRL == null) {
                    try {
                        uRL = new URL((String)object);
                    }
                    catch (MalformedURLException var5_10) {
                        throw new SQLException(String.format("resource %s not found: %s", object, var5_10));
                    }
                }
                try {
                    this.fileName = this.extractResource(uRL).getAbsolutePath();
                }
                catch (IOException var5_11) {
                    throw new SQLException(String.format("failed to load %s: %s", object, var5_11));
                }
            }
            object = new File(this.fileName).getAbsoluteFile();
            File file = object.getParentFile();
            if (file != null && !file.exists()) {
                File file2 = file;
                while (file2 != null) {
                    if (file2.exists()) throw new SQLException("path to '" + this.fileName + "': '" + file + "' does not exist");
                    file = file2;
                    file2 = file2.getParentFile();
                }
                throw new SQLException("path to '" + this.fileName + "': '" + file + "' does not exist");
            }
            try {
                if (!object.exists() && object.createNewFile()) {
                    object.delete();
                }
            }
            catch (Exception var4_9) {
                throw new SQLException("opening db: '" + this.fileName + "': " + var4_9.getMessage());
            }
            this.fileName = object.getAbsolutePath();
        }
        try {
            object = Class.forName("org.sqlite.NativeDB");
            if (((Boolean)object.getDeclaredMethod("load", null).invoke(null, null)).booleanValue()) {
                this.db = (DB)object.newInstance();
            }
        }
        catch (Exception var2_3) {
            // empty catch block
        }
        if (this.db == null) {
            try {
                this.db = (DB)Class.forName("org.sqlite.NestedDB").newInstance();
            }
            catch (Exception var2_4) {
                throw new SQLException("no SQLite library found");
            }
        }
        this.db.open(this, this.fileName, n2);
        this.setTimeout(3000);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private File extractResource(URL uRL) {
        String string;
        if (uRL.getProtocol().equals("file")) {
            try {
                return new File(uRL.toURI());
            }
            catch (URISyntaxException var2_2) {
                throw new IOException(var2_2.getMessage());
            }
        }
        String string2 = new File(System.getProperty("java.io.tmpdir")).getAbsolutePath();
        File file = new File(string2, string = String.format("sqlite-jdbc-tmp-%d.db", uRL.hashCode()));
        if (file.exists()) {
            long l2;
            long l3 = uRL.openConnection().getLastModified();
            if (l3 < (l2 = file.lastModified())) {
                return file;
            }
            boolean bl2 = file.delete();
            if (!bl2) {
                throw new IOException("failed to remove existing DB file: " + file.getAbsolutePath());
            }
        }
        byte[] arrby = new byte[8192];
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        InputStream inputStream = uRL.openStream();
        try {
            int n2 = 0;
            while ((n2 = inputStream.read(arrby)) != -1) {
                fileOutputStream.write(arrby, 0, n2);
            }
            File file2 = file;
            return file2;
        }
        finally {
            fileOutputStream.close();
            inputStream.close();
        }
    }

    int getTimeout() {
        return this.timeout;
    }

    void setTimeout(int n2) {
        this.timeout = n2;
        this.db.busy_timeout(n2);
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
        if (this.db != null) return;
        throw new SQLException("database connection closed");
    }

    private void checkCursor(int n2, int n3, int n4) {
        if (n2 != 1003) {
            throw new SQLException("SQLite only supports TYPE_FORWARD_ONLY cursors");
        }
        if (n3 != 1007) {
            throw new SQLException("SQLite only supports CONCUR_READ_ONLY cursors");
        }
        if (n4 == 2) return;
        throw new SQLException("SQLite only supports closing cursors at commit");
    }

    public void finalize() {
        this.close();
    }

    @Override
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

    @Override
    public boolean isClosed() {
        if (this.db != null) return false;
        return true;
    }

    @Override
    public String getCatalog() {
        this.checkOpen();
        return null;
    }

    @Override
    public void setCatalog(String string) {
        this.checkOpen();
    }

    @Override
    public int getHoldability() {
        this.checkOpen();
        return 2;
    }

    @Override
    public void setHoldability(int n2) {
        this.checkOpen();
        if (n2 == 2) return;
        throw new SQLException("SQLite only supports CLOSE_CURSORS_AT_COMMIT");
    }

    @Override
    public int getTransactionIsolation() {
        return this.transactionIsolation;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void setTransactionIsolation(int var1_1) {
        switch (var1_1) {
            case 8: {
                this.db.exec("PRAGMA read_uncommitted = false;");
                ** break;
            }
            case 1: {
                this.db.exec("PRAGMA read_uncommitted = true;");
                ** break;
            }
        }
        throw new SQLException("SQLite supports only TRANSACTION_SERIALIZABLE and TRANSACTION_READ_UNCOMMITTED.");
lbl9: // 2 sources:
        this.transactionIsolation = var1_1;
    }

    public Map getTypeMap() {
        throw new SQLException("not yet implemented");
    }

    public void setTypeMap(Map map) {
        throw new SQLException("not yet implemented");
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public void setReadOnly(boolean bl2) {
    }

    @Override
    public DatabaseMetaData getMetaData() {
        if (this.meta != null) return this.meta;
        this.meta = new MetaData(this);
        return this.meta;
    }

    @Override
    public String nativeSQL(String string) {
        return string;
    }

    @Override
    public void clearWarnings() {
    }

    @Override
    public SQLWarning getWarnings() {
        return null;
    }

    @Override
    public boolean getAutoCommit() {
        this.checkOpen();
        return this.autoCommit;
    }

    @Override
    public void setAutoCommit(boolean bl2) {
        this.checkOpen();
        if (this.autoCommit == bl2) {
            return;
        }
        this.autoCommit = bl2;
        this.db.exec(this.autoCommit ? "commit;" : "begin;");
    }

    @Override
    public void commit() {
        this.checkOpen();
        if (this.autoCommit) {
            throw new SQLException("database in auto-commit mode");
        }
        this.db.exec("commit;");
        this.db.exec("begin;");
    }

    @Override
    public void rollback() {
        this.checkOpen();
        if (this.autoCommit) {
            throw new SQLException("database in auto-commit mode");
        }
        this.db.exec("rollback;");
        this.db.exec("begin;");
    }

    @Override
    public Statement createStatement() {
        return this.createStatement(1003, 1007, 2);
    }

    @Override
    public Statement createStatement(int n2, int n3) {
        return this.createStatement(n2, n3, 2);
    }

    @Override
    public Statement createStatement(int n2, int n3, int n4) {
        this.checkCursor(n2, n3, n4);
        return new Stmt(this);
    }

    @Override
    public CallableStatement prepareCall(String string) {
        return this.prepareCall(string, 1003, 1007, 2);
    }

    @Override
    public CallableStatement prepareCall(String string, int n2, int n3) {
        return this.prepareCall(string, n2, n3, 2);
    }

    @Override
    public CallableStatement prepareCall(String string, int n2, int n3, int n4) {
        throw new SQLException("SQLite does not support Stored Procedures");
    }

    @Override
    public PreparedStatement prepareStatement(String string) {
        return this.prepareStatement(string, 1003, 1007);
    }

    @Override
    public PreparedStatement prepareStatement(String string, int n2) {
        return this.prepareStatement(string);
    }

    @Override
    public PreparedStatement prepareStatement(String string, int[] arrn) {
        return this.prepareStatement(string);
    }

    @Override
    public PreparedStatement prepareStatement(String string, String[] arrstring) {
        return this.prepareStatement(string);
    }

    @Override
    public PreparedStatement prepareStatement(String string, int n2, int n3) {
        return this.prepareStatement(string, n2, n3, 2);
    }

    @Override
    public PreparedStatement prepareStatement(String string, int n2, int n3, int n4) {
        this.checkCursor(n2, n3, n4);
        return new PrepStmt(this, string);
    }

    String getDriverVersion() {
        if (this.db == null) return "unloaded";
        String string = this.db.getClass().getName();
        if (string.indexOf("NestedDB") >= 0) {
            return "pure";
        }
        if (string.indexOf("NativeDB") < 0) return "unloaded";
        return "native";
    }

    @Override
    public Savepoint setSavepoint() {
        throw new SQLException("unsupported by SQLite: savepoints");
    }

    @Override
    public Savepoint setSavepoint(String string) {
        throw new SQLException("unsupported by SQLite: savepoints");
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) {
        throw new SQLException("unsupported by SQLite: savepoints");
    }

    @Override
    public void rollback(Savepoint savepoint) {
        throw new SQLException("unsupported by SQLite: savepoints");
    }

    @Override
    public Struct createStruct(String string, Object[] arrobject) {
        throw new SQLException("unsupported by SQLite");
    }
}

