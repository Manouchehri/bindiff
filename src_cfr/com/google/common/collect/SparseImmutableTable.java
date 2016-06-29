/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.concurrent.Immutable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.Table$Cell;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
@Immutable
final class SparseImmutableTable
extends RegularImmutableTable {
    private final ImmutableMap rowMap;
    private final ImmutableMap columnMap;
    private final int[] iterationOrderRow;
    private final int[] iterationOrderColumn;

    SparseImmutableTable(ImmutableList immutableList, ImmutableSet immutableSet, ImmutableSet immutableSet2) {
        int[] arrn22;
        Object object222;
        Map.Entry entry;
        Object object;
        ImmutableMap immutableMap = Maps.indexMap(immutableSet);
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        for (int[] arrn22 : immutableSet) {
            linkedHashMap.put(arrn22, new LinkedHashMap());
        }
        LinkedHashMap linkedHashMap2 = Maps.newLinkedHashMap();
        for (Object object222 : immutableSet2) {
            linkedHashMap2.put(object222, new LinkedHashMap());
        }
        arrn22 = new int[immutableList.size()];
        object222 = new int[immutableList.size()];
        for (int i2 = 0; i2 < immutableList.size(); ++i2) {
            object = (Table$Cell)immutableList.get(i2);
            Object iterator2 = object.getRowKey();
            entry = object.getColumnKey();
            Object object2 = object.getValue();
            arrn22[i2] = (Integer)immutableMap.get(iterator2);
            Map map = (Map)linkedHashMap.get(iterator2);
            object222[i2] = map.size();
            Object object3 = map.put(entry, object2);
            if (object3 != null) {
                String string = String.valueOf(iterator2);
                String string2 = String.valueOf(entry);
                String string3 = String.valueOf(object2);
                String string4 = String.valueOf(object3);
                throw new IllegalArgumentException(new StringBuilder(37 + String.valueOf(string).length() + String.valueOf(string2).length() + String.valueOf(string3).length() + String.valueOf(string4).length()).append("Duplicate value for row=").append(string).append(", column=").append(string2).append(": ").append(string3).append(", ").append(string4).toString());
            }
            ((Map)linkedHashMap2.get(entry)).put(iterator2, object2);
        }
        this.iterationOrderRow = arrn22;
        this.iterationOrderColumn = object222;
        ImmutableMap$Builder immutableMap$Builder = new ImmutableMap$Builder(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            immutableMap$Builder.put(entry2.getKey(), ImmutableMap.copyOf((Map)entry2.getValue()));
        }
        this.rowMap = immutableMap$Builder.build();
        object = new ImmutableMap$Builder(linkedHashMap2.size());
        Iterator iterator = linkedHashMap2.entrySet().iterator();
        do {
            if (!iterator.hasNext()) {
                this.columnMap = object.build();
                return;
            }
            entry = iterator.next();
            object.put(entry.getKey(), ImmutableMap.copyOf((Map)entry.getValue()));
        } while (true);
    }

    @Override
    public ImmutableMap columnMap() {
        return this.columnMap;
    }

    @Override
    public ImmutableMap rowMap() {
        return this.rowMap;
    }

    @Override
    public int size() {
        return this.iterationOrderRow.length;
    }

    @Override
    Table$Cell getCell(int n2) {
        int n3 = this.iterationOrderRow[n2];
        Map.Entry entry = (Map.Entry)this.rowMap.entrySet().asList().get(n3);
        ImmutableMap immutableMap = (ImmutableMap)entry.getValue();
        int n4 = this.iterationOrderColumn[n2];
        Map.Entry entry2 = (Map.Entry)immutableMap.entrySet().asList().get(n4);
        return SparseImmutableTable.cellOf(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    @Override
    Object getValue(int n2) {
        int n3 = this.iterationOrderRow[n2];
        ImmutableMap immutableMap = (ImmutableMap)this.rowMap.values().asList().get(n3);
        int n4 = this.iterationOrderColumn[n2];
        return immutableMap.values().asList().get(n4);
    }
}

