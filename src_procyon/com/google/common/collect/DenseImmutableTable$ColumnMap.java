package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.concurrent.*;
import java.util.*;
import com.google.common.base.*;
import javax.annotation.*;

final class DenseImmutableTable$ColumnMap extends DenseImmutableTable$ImmutableArrayMap
{
    final /* synthetic */ DenseImmutableTable this$0;
    
    private DenseImmutableTable$ColumnMap(final DenseImmutableTable this$0) {
        this.this$0 = this$0;
        super(this$0.columnCounts.length);
    }
    
    @Override
    ImmutableMap keyToIndex() {
        return this.this$0.columnKeyToIndex;
    }
    
    @Override
    Map getValue(final int n) {
        return new DenseImmutableTable$Column(this.this$0, n);
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
}
