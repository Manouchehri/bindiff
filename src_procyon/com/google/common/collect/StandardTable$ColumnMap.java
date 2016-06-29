package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

class StandardTable$ColumnMap extends Maps$ViewCachingAbstractMap
{
    final /* synthetic */ StandardTable this$0;
    
    private StandardTable$ColumnMap(final StandardTable this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public Map get(final Object o) {
        return this.this$0.containsColumn(o) ? this.this$0.column(o) : null;
    }
    
    @Override
    public boolean containsKey(final Object o) {
        return this.this$0.containsColumn(o);
    }
    
    @Override
    public Map remove(final Object o) {
        return this.this$0.containsColumn(o) ? this.this$0.removeColumn(o) : null;
    }
    
    public Set createEntrySet() {
        return new StandardTable$ColumnMap$ColumnMapEntrySet(this);
    }
    
    @Override
    public Set keySet() {
        return this.this$0.columnKeySet();
    }
    
    @Override
    Collection createValues() {
        return new StandardTable$ColumnMap$ColumnMapValues(this);
    }
}
