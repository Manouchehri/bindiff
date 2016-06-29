package com.google.common.collect;

import java.io.*;
import javax.annotation.*;

final class Tables$ImmutableCell extends Tables$AbstractCell implements Serializable
{
    private final Object rowKey;
    private final Object columnKey;
    private final Object value;
    private static final long serialVersionUID = 0L;
    
    Tables$ImmutableCell(@Nullable final Object rowKey, @Nullable final Object columnKey, @Nullable final Object value) {
        this.rowKey = rowKey;
        this.columnKey = columnKey;
        this.value = value;
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
