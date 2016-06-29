package com.google.security.zynamics.bindiff.database;

import com.google.common.base.*;
import java.util.*;
import java.sql.*;

public class QueryBuilder
{
    protected static final int SQLITE_MAX_QUERY_SIZE = 1000000;
    private final List queries;
    private final String baseQuery;
    private StringBuffer currentBuffer;
    
    public QueryBuilder(final String s) {
        this.queries = new ArrayList();
        Preconditions.checkArgument(s != null && !s.isEmpty());
        Preconditions.checkArgument(!s.toLowerCase().startsWith("insert"), (Object)"Multi row inserts are not supported by sqlite");
        Preconditions.checkArgument(!s.toLowerCase().startsWith("update"), (Object)"Multi row updates with more than one value set are not supported by SQLite");
        this.currentBuffer = new StringBuffer();
        final String value = String.valueOf(s);
        final String value2 = String.valueOf(s.endsWith(" ") ? "" : " ");
        this.baseQuery = ((value2.length() != 0) ? value.concat(value2) : new String(value));
    }
    
    private void addCurrentQuery() {
        if (this.currentBuffer.charAt(this.currentBuffer.length() - 1) != ')') {
            this.currentBuffer.append(")");
        }
        this.currentBuffer.append(";");
        this.queries.add(this.currentBuffer);
        this.currentBuffer = new StringBuffer();
    }
    
    public void appendInSet(final String s) {
        Preconditions.checkArgument(s != null && !s.isEmpty(), (Object)"Row insert string cannot be null or empty");
        Preconditions.checkArgument(!s.startsWith("(") && !s.endsWith(")"), (Object)"In set values can not start with a \"(\" and end with a \")\")");
        if (this.currentBuffer.length() + s.length() >= 999997) {
            this.currentBuffer.append(")");
            this.addCurrentQuery();
        }
        if (this.currentBuffer.length() == 0) {
            this.currentBuffer.append(this.baseQuery);
            this.currentBuffer.append("(");
        }
        else {
            this.currentBuffer.append(",");
        }
        this.currentBuffer.append(s);
    }
    
    public void execute(final Connection connection) {
        Preconditions.checkNotNull(connection);
        if (this.currentBuffer.length() != 0) {
            this.addCurrentQuery();
        }
        for (final StringBuffer sb : this.queries) {
            try (final Statement statement = connection.createStatement()) {
                statement.executeUpdate(sb.toString());
            }
        }
    }
}
