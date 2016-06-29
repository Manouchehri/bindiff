/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

import java.util.List;
import org.jfree.data.Values;

public interface KeyedValues
extends Values {
    public Comparable getKey(int var1);

    public int getIndex(Comparable var1);

    public List getKeys();

    public Number getValue(Comparable var1);
}

