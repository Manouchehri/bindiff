/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.HashBasedTable$Factory;
import com.google.common.collect.Maps;
import com.google.common.collect.StandardTable;
import com.google.common.collect.Table;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1)
public class HashBasedTable
extends StandardTable {
    private static final long serialVersionUID = 0;

    public static HashBasedTable create() {
        return new HashBasedTable(new HashMap(), new HashBasedTable$Factory(0));
    }

    public static HashBasedTable create(int n2, int n3) {
        CollectPreconditions.checkNonnegative(n3, "expectedCellsPerRow");
        HashMap hashMap = Maps.newHashMapWithExpectedSize(n2);
        return new HashBasedTable(hashMap, new HashBasedTable$Factory(n3));
    }

    public static HashBasedTable create(Table table) {
        HashBasedTable hashBasedTable = HashBasedTable.create();
        hashBasedTable.putAll(table);
        return hashBasedTable;
    }

    HashBasedTable(Map map, HashBasedTable$Factory hashBasedTable$Factory) {
        super(map, hashBasedTable$Factory);
    }

    @Override
    public boolean contains(@Nullable Object object, @Nullable Object object2) {
        return super.contains(object, object2);
    }

    @Override
    public boolean containsColumn(@Nullable Object object) {
        return super.containsColumn(object);
    }

    @Override
    public boolean containsRow(@Nullable Object object) {
        return super.containsRow(object);
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return super.containsValue(object);
    }

    @Override
    public Object get(@Nullable Object object, @Nullable Object object2) {
        return super.get(object, object2);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return super.equals(object);
    }

    @Override
    public Object remove(@Nullable Object object, @Nullable Object object2) {
        return super.remove(object, object2);
    }
}

