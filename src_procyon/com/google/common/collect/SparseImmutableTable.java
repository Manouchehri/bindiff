package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.concurrent.*;
import java.util.*;

@GwtCompatible
@Immutable
final class SparseImmutableTable extends RegularImmutableTable
{
    private final ImmutableMap rowMap;
    private final ImmutableMap columnMap;
    private final int[] iterationOrderRow;
    private final int[] iterationOrderColumn;
    
    SparseImmutableTable(final ImmutableList list, final ImmutableSet set, final ImmutableSet set2) {
        final ImmutableMap indexMap = Maps.indexMap(set);
        final LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        final UnmodifiableIterator iterator = set.iterator();
        while (iterator.hasNext()) {
            linkedHashMap.put(iterator.next(), new LinkedHashMap<Object, Object>());
        }
        final LinkedHashMap linkedHashMap2 = Maps.newLinkedHashMap();
        final UnmodifiableIterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            linkedHashMap2.put(iterator2.next(), new LinkedHashMap<Object, Object>());
        }
        final int[] iterationOrderRow = new int[list.size()];
        final int[] iterationOrderColumn = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            final Table$Cell table$Cell = list.get(i);
            final Object rowKey = table$Cell.getRowKey();
            final Object columnKey = table$Cell.getColumnKey();
            final Object value = table$Cell.getValue();
            iterationOrderRow[i] = indexMap.get(rowKey);
            final Map<Object, Object> map = linkedHashMap.get(rowKey);
            iterationOrderColumn[i] = map.size();
            final Object put = map.put(columnKey, value);
            if (put != null) {
                final String value2 = String.valueOf(rowKey);
                final String value3 = String.valueOf(columnKey);
                final String value4 = String.valueOf(value);
                final String value5 = String.valueOf(put);
                throw new IllegalArgumentException(new StringBuilder(37 + String.valueOf(value2).length() + String.valueOf(value3).length() + String.valueOf(value4).length() + String.valueOf(value5).length()).append("Duplicate value for row=").append(value2).append(", column=").append(value3).append(": ").append(value4).append(", ").append(value5).toString());
            }
            linkedHashMap2.get(columnKey).put(rowKey, value);
        }
        this.iterationOrderRow = iterationOrderRow;
        this.iterationOrderColumn = iterationOrderColumn;
        final ImmutableMap$Builder immutableMap$Builder = new ImmutableMap$Builder(linkedHashMap.size());
        for (final Map.Entry<Object, Map<Object, Object>> entry : linkedHashMap.entrySet()) {
            immutableMap$Builder.put(entry.getKey(), ImmutableMap.copyOf(entry.getValue()));
        }
        this.rowMap = immutableMap$Builder.build();
        final ImmutableMap$Builder immutableMap$Builder2 = new ImmutableMap$Builder(linkedHashMap2.size());
        for (final Map.Entry<Object, Map<Object, Object>> entry2 : linkedHashMap2.entrySet()) {
            immutableMap$Builder2.put(entry2.getKey(), ImmutableMap.copyOf(entry2.getValue()));
        }
        this.columnMap = immutableMap$Builder2.build();
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
    Table$Cell getCell(final int n) {
        final Map.Entry<K, ImmutableMap> entry = this.rowMap.entrySet().asList().get(this.iterationOrderRow[n]);
        final Map.Entry<Object, V> entry2 = entry.getValue().entrySet().asList().get(this.iterationOrderColumn[n]);
        return ImmutableTable.cellOf(entry.getKey(), entry2.getKey(), entry2.getValue());
    }
    
    @Override
    Object getValue(final int n) {
        return this.rowMap.values().asList().get(this.iterationOrderRow[n]).values().asList().get(this.iterationOrderColumn[n]);
    }
}
