/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import org.sqlite.SQLiteConfig$PragmaValue;

public enum SQLiteConfig$LockingMode implements SQLiteConfig$PragmaValue
{
    NORMAL,
    EXCLUSIVE;
    

    private SQLiteConfig$LockingMode() {
    }

    @Override
    public String getValue() {
        return this.name();
    }
}

