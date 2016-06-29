/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import org.sqlite.SQLiteConfig$PragmaValue;

public enum SQLiteConfig$JournalMode implements SQLiteConfig$PragmaValue
{
    DELETE,
    TRUNCATE,
    PERSIST,
    MEMORY,
    OFF;
    

    private SQLiteConfig$JournalMode() {
    }

    @Override
    public String getValue() {
        return this.name();
    }
}

