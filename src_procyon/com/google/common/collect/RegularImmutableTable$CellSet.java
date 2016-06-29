package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

final class RegularImmutableTable$CellSet extends ImmutableSet$Indexed
{
    final /* synthetic */ RegularImmutableTable this$0;
    
    private RegularImmutableTable$CellSet(final RegularImmutableTable this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public int size() {
        return this.this$0.size();
    }
    
    @Override
    Table$Cell get(final int n) {
        return this.this$0.getCell(n);
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        if (o instanceof Table$Cell) {
            final Table$Cell table$Cell = (Table$Cell)o;
            final Object value = this.this$0.get(table$Cell.getRowKey(), table$Cell.getColumnKey());
            return value != null && value.equals(table$Cell.getValue());
        }
        return false;
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
}
