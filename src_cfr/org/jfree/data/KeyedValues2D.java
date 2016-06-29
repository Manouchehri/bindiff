/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

import java.util.List;
import org.jfree.data.Values2D;

public interface KeyedValues2D
extends Values2D {
    public Comparable getRowKey(int var1);

    public int getRowIndex(Comparable var1);

    public List getRowKeys();

    public Comparable getColumnKey(int var1);

    public int getColumnIndex(Comparable var1);

    public List getColumnKeys();

    public Number getValue(Comparable var1, Comparable var2);
}

