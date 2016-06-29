/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Tables$UnmodifiableTable
extends ForwardingTable
implements Serializable {
    final Table delegate;
    private static final long serialVersionUID = 0;

    Tables$UnmodifiableTable(Table table) {
        this.delegate = (Table)Preconditions.checkNotNull(table);
    }

    @Override
    protected Table delegate() {
        return this.delegate;
    }

    @Override
    public Set cellSet() {
        return Collections.unmodifiableSet(super.cellSet());
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map column(@Nullable Object object) {
        return Collections.unmodifiableMap(super.column(object));
    }

    @Override
    public Set columnKeySet() {
        return Collections.unmodifiableSet(super.columnKeySet());
    }

    @Override
    public Map columnMap() {
        Function function = Tables.access$000();
        return Collections.unmodifiableMap(Maps.transformValues(super.columnMap(), function));
    }

    @Override
    public Object put(@Nullable Object object, @Nullable Object object2, @Nullable Object object3) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Table table) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object remove(@Nullable Object object, @Nullable Object object2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map row(@Nullable Object object) {
        return Collections.unmodifiableMap(super.row(object));
    }

    @Override
    public Set rowKeySet() {
        return Collections.unmodifiableSet(super.rowKeySet());
    }

    @Override
    public Map rowMap() {
        Function function = Tables.access$000();
        return Collections.unmodifiableMap(Maps.transformValues(super.rowMap(), function));
    }

    @Override
    public Collection values() {
        return Collections.unmodifiableCollection(super.values());
    }
}

