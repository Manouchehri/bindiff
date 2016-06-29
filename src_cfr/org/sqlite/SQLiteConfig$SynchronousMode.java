/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import org.sqlite.SQLiteConfig$PragmaValue;

public enum SQLiteConfig$SynchronousMode implements SQLiteConfig$PragmaValue
{
    OFF,
    NORMAL,
    FULL;
    

    private SQLiteConfig$SynchronousMode() {
    }

    @Override
    public String getValue() {
        return this.name();
    }
}

