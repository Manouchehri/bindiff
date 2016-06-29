package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

class AbstractTable$CellSet extends AbstractSet
{
    final /* synthetic */ AbstractTable this$0;
    
    AbstractTable$CellSet(final AbstractTable this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public boolean contains(final Object o) {
        if (o instanceof Table$Cell) {
            final Table$Cell table$Cell = (Table$Cell)o;
            final Map map = (Map)Maps.safeGet(this.this$0.rowMap(), table$Cell.getRowKey());
            return map != null && Collections2.safeContains(map.entrySet(), Maps.immutableEntry(table$Cell.getColumnKey(), table$Cell.getValue()));
        }
        return false;
    }
    
    @Override
    public boolean remove(@Nullable final Object o) {
        if (o instanceof Table$Cell) {
            final Table$Cell table$Cell = (Table$Cell)o;
            final Map map = (Map)Maps.safeGet(this.this$0.rowMap(), table$Cell.getRowKey());
            return map != null && Collections2.safeRemove(map.entrySet(), Maps.immutableEntry(table$Cell.getColumnKey(), table$Cell.getValue()));
        }
        return false;
    }
    
    @Override
    public void clear() {
        this.this$0.clear();
    }
    
    @Override
    public Iterator iterator() {
        return this.this$0.cellIterator();
    }
    
    @Override
    public int size() {
        return this.this$0.size();
    }
}
