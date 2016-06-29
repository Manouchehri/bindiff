/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Tables$AbstractCell;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Tables$ImmutableCell
extends Tables$AbstractCell
implements Serializable {
    private final Object rowKey;
    private final Object columnKey;
    private final Object value;
    private static final long serialVersionUID = 0;

    Tables$ImmutableCell(@Nullable Object object, @Nullable Object object2, @Nullable Object object3) {
        this.rowKey = object;
        this.columnKey = object2;
        this.value = object3;
    }

    @Override
    public Object getRowKey() {
        return this.rowKey;
    }

    @Override
    public Object getColumnKey() {
        return this.columnKey;
    }

    @Override
    public Object getValue() {
        return this.value;
    }
}

