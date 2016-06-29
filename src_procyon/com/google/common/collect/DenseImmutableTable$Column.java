package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.concurrent.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

final class DenseImmutableTable$Column extends DenseImmutableTable$ImmutableArrayMap
{
    private final int columnIndex;
    final /* synthetic */ DenseImmutableTable this$0;
    
    DenseImmutableTable$Column(final DenseImmutableTable this$0, final int columnIndex) {
        this.this$0 = this$0;
        super(this$0.columnCounts[columnIndex]);
        this.columnIndex = columnIndex;
    }
    
    @Override
    ImmutableMap keyToIndex() {
        return this.this$0.rowKeyToIndex;
    }
    
    @Override
    Object getValue(final int n) {
        return this.this$0.values[n][this.columnIndex];
    }
    
    @Override
    boolean isPartialView() {
        return true;
    }
}
