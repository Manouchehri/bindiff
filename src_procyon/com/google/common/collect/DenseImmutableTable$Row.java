package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.concurrent.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

final class DenseImmutableTable$Row extends DenseImmutableTable$ImmutableArrayMap
{
    private final int rowIndex;
    final /* synthetic */ DenseImmutableTable this$0;
    
    DenseImmutableTable$Row(final DenseImmutableTable this$0, final int rowIndex) {
        this.this$0 = this$0;
        super(this$0.rowCounts[rowIndex]);
        this.rowIndex = rowIndex;
    }
    
    @Override
    ImmutableMap keyToIndex() {
        return this.this$0.columnKeyToIndex;
    }
    
    @Override
    Object getValue(final int n) {
        return this.this$0.values[this.rowIndex][n];
    }
    
    @Override
    boolean isPartialView() {
        return true;
    }
}
