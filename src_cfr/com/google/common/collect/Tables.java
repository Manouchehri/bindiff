/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.RowSortedTable;
import com.google.common.collect.StandardTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables$1;
import com.google.common.collect.Tables$ImmutableCell;
import com.google.common.collect.Tables$TransformedTable;
import com.google.common.collect.Tables$TransposeTable;
import com.google.common.collect.Tables$UnmodifiableRowSortedMap;
import com.google.common.collect.Tables$UnmodifiableTable;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public final class Tables {
    private static final Function UNMODIFIABLE_WRAPPER = new Tables$1();

    private Tables() {
    }

    public static Table$Cell immutableCell(@Nullable Object object, @Nullable Object object2, @Nullable Object object3) {
        return new Tables$ImmutableCell(object, object2, object3);
    }

    public static Table transpose(Table table) {
        Tables$TransposeTable tables$TransposeTable /* !! */ ;
        if (table instanceof Tables$TransposeTable) {
            tables$TransposeTable /* !! */  = ((Tables$TransposeTable)table).original;
            return tables$TransposeTable /* !! */ ;
        }
        tables$TransposeTable /* !! */  = new Tables$TransposeTable(table);
        return tables$TransposeTable /* !! */ ;
    }

    @Beta
    public static Table newCustomTable(Map map, Supplier supplier) {
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkNotNull(supplier);
        return new StandardTable(map, supplier);
    }

    @Beta
    public static Table transformValues(Table table, Function function) {
        return new Tables$TransformedTable(table, function);
    }

    public static Table unmodifiableTable(Table table) {
        return new Tables$UnmodifiableTable(table);
    }

    @Beta
    public static RowSortedTable unmodifiableRowSortedTable(RowSortedTable rowSortedTable) {
        return new Tables$UnmodifiableRowSortedMap(rowSortedTable);
    }

    private static Function unmodifiableWrapper() {
        return UNMODIFIABLE_WRAPPER;
    }

    static boolean equalsImpl(Table table, @Nullable Object object) {
        if (object == table) {
            return true;
        }
        if (!(object instanceof Table)) return false;
        Table table2 = (Table)object;
        return table.cellSet().equals(table2.cellSet());
    }

    static /* synthetic */ Function access$000() {
        return Tables.unmodifiableWrapper();
    }
}

