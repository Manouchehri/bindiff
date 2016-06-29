package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible(serializable = true)
public class HashBasedTable extends StandardTable
{
    private static final long serialVersionUID = 0L;
    
    public static HashBasedTable create() {
        return new HashBasedTable(new HashMap(), new HashBasedTable$Factory(0));
    }
    
    public static HashBasedTable create(final int n, final int n2) {
        CollectPreconditions.checkNonnegative(n2, "expectedCellsPerRow");
        return new HashBasedTable(Maps.newHashMapWithExpectedSize(n), new HashBasedTable$Factory(n2));
    }
    
    public static HashBasedTable create(final Table table) {
        final HashBasedTable create = create();
        create.putAll(table);
        return create;
    }
    
    HashBasedTable(final Map map, final HashBasedTable$Factory hashBasedTable$Factory) {
        super(map, hashBasedTable$Factory);
    }
    
    @Override
    public boolean contains(@Nullable final Object o, @Nullable final Object o2) {
        return super.contains(o, o2);
    }
    
    @Override
    public boolean containsColumn(@Nullable final Object o) {
        return super.containsColumn(o);
    }
    
    @Override
    public boolean containsRow(@Nullable final Object o) {
        return super.containsRow(o);
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        return super.containsValue(o);
    }
    
    @Override
    public Object get(@Nullable final Object o, @Nullable final Object o2) {
        return super.get(o, o2);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return super.equals(o);
    }
    
    @Override
    public Object remove(@Nullable final Object o, @Nullable final Object o2) {
        return super.remove(o, o2);
    }
}
