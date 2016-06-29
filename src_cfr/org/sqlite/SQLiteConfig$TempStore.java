/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import org.sqlite.SQLiteConfig$PragmaValue;

public enum SQLiteConfig$TempStore implements SQLiteConfig$PragmaValue
{
    DEFAULT,
    FILE,
    MEMORY;
    

    private SQLiteConfig$TempStore() {
    }

    @Override
    public String getValue() {
        return this.name();
    }
}

