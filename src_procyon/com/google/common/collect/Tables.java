package com.google.common.collect;

import javax.annotation.*;
import java.util.*;
import com.google.common.base.*;
import com.google.common.annotations.*;

@GwtCompatible
public final class Tables
{
    private static final Function UNMODIFIABLE_WRAPPER;
    
    public static Table$Cell immutableCell(@Nullable final Object o, @Nullable final Object o2, @Nullable final Object o3) {
        return new Tables$ImmutableCell(o, o2, o3);
    }
    
    public static Table transpose(final Table table) {
        return (table instanceof Tables$TransposeTable) ? ((Tables$TransposeTable)table).original : new Tables$TransposeTable(table);
    }
    
    @Beta
    public static Table newCustomTable(final Map map, final Supplier supplier) {
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkNotNull(supplier);
        return new StandardTable(map, supplier);
    }
    
    @Beta
    public static Table transformValues(final Table table, final Function function) {
        return new Tables$TransformedTable(table, function);
    }
    
    public static Table unmodifiableTable(final Table table) {
        return new Tables$UnmodifiableTable(table);
    }
    
    @Beta
    public static RowSortedTable unmodifiableRowSortedTable(final RowSortedTable rowSortedTable) {
        return new Tables$UnmodifiableRowSortedMap(rowSortedTable);
    }
    
    private static Function unmodifiableWrapper() {
        return Tables.UNMODIFIABLE_WRAPPER;
    }
    
    static boolean equalsImpl(final Table table, @Nullable final Object o) {
        return o == table || (o instanceof Table && table.cellSet().equals(((Table)o).cellSet()));
    }
    
    static {
        UNMODIFIABLE_WRAPPER = new Tables$1();
    }
}
