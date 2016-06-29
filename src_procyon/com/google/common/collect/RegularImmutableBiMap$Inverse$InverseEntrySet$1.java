package com.google.common.collect;

import java.util.*;
import com.google.common.annotations.*;
import com.google.errorprone.annotations.concurrent.*;
import com.google.common.base.*;
import javax.annotation.*;

class RegularImmutableBiMap$Inverse$InverseEntrySet$1 extends ImmutableAsList
{
    final /* synthetic */ RegularImmutableBiMap$Inverse$InverseEntrySet this$2;
    
    RegularImmutableBiMap$Inverse$InverseEntrySet$1(final RegularImmutableBiMap$Inverse$InverseEntrySet this$2) {
        this.this$2 = this$2;
    }
    
    @Override
    public Map.Entry get(final int n) {
        final Map.Entry entry = this.this$2.this$1.this$0.entries[n];
        return Maps.immutableEntry(entry.getValue(), entry.getKey());
    }
    
    @Override
    ImmutableCollection delegateCollection() {
        return this.this$2;
    }
}
