/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.database;

import com.google.common.base.Preconditions;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QueryBuilder {
    protected static final int SQLITE_MAX_QUERY_SIZE = 1000000;
    private final List queries = new ArrayList();
    private final String baseQuery;
    private StringBuffer currentBuffer;

    public QueryBuilder(String string) {
        Preconditions.checkArgument(string != null && !string.isEmpty());
        Preconditions.checkArgument(!string.toLowerCase().startsWith("insert"), "Multi row inserts are not supported by sqlite");
        Preconditions.checkArgument(!string.toLowerCase().startsWith("update"), "Multi row updates with more than one value set are not supported by SQLite");
        this.currentBuffer = new StringBuffer();
        String string2 = String.valueOf(string);
        String string3 = String.valueOf(string.endsWith(" ") ? "" : " ");
        this.baseQuery = string3.length() != 0 ? string2.concat(string3) : new String(string2);
    }

    private void addCurrentQuery() {
        if (this.currentBuffer.charAt(this.currentBuffer.length() - 1) != ')') {
            this.currentBuffer.append(")");
        }
        this.currentBuffer.append(";");
        this.queries.add(this.currentBuffer);
        this.currentBuffer = new StringBuffer();
    }

    public void appendInSet(String string) {
        Preconditions.checkArgument(string != null && !string.isEmpty(), "Row insert string cannot be null or empty");
        Preconditions.checkArgument(!string.startsWith("(") && !string.endsWith(")"), "In set values can not start with a \"(\" and end with a \")\")");
        if (this.currentBuffer.length() + string.length() >= 999997) {
            this.currentBuffer.append(")");
            this.addCurrentQuery();
        }
        if (this.currentBuffer.length() == 0) {
            this.currentBuffer.append(this.baseQuery);
            this.currentBuffer.append("(");
        } else {
            this.currentBuffer.append(",");
        }
        this.currentBuffer.append(string);
    }

    public void execute(Connection connection) {
        Preconditions.checkNotNull(connection);
        if (this.currentBuffer.length() != 0) {
            this.addCurrentQuery();
        }
        Iterator iterator = this.queries.iterator();
        while (iterator.hasNext()) {
            StringBuffer stringBuffer = (StringBuffer)iterator.next();
            Statement statement = connection.createStatement();
            Throwable throwable = null;
            try {
                statement.executeUpdate(stringBuffer.toString());
                continue;
            }
            catch (Throwable var6_7) {
                throwable = var6_7;
                throw var6_7;
            }
            finally {
                if (statement == null) continue;
                if (throwable != null) {
                    try {
                        statement.close();
                    }
                    catch (Throwable var6_6) {
                        throwable.addSuppressed(var6_6);
                    }
                    continue;
                }
                statement.close();
                continue;
            }
        }
    }
}

