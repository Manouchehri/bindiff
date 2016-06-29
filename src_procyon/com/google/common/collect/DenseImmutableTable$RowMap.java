package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.concurrent.*;
import java.util.*;
import com.google.common.base.*;
import javax.annotation.*;

final class DenseImmutableTable$RowMap extends DenseImmutableTable$ImmutableArrayMap
{
    final /* synthetic */ DenseImmutableTable this$0;
    
    private DenseImmutableTable$RowMap(final DenseImmutableTable this$0) {
        this.this$0 = this$0;
        super(this$0.rowCounts.length);
    }
    
    @Override
    ImmutableMap keyToIndex() {
        return this.this$0.rowKeyToIndex;
    }
    
    @Override
    Map getValue(final int n) {
        return new DenseImmutableTable$Row(this.this$0, n);
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
}
