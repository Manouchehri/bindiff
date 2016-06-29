package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;
import com.google.errorprone.annotations.concurrent.*;
import com.google.common.base.*;

final class RegularImmutableBiMap$Inverse extends ImmutableBiMap
{
    final /* synthetic */ RegularImmutableBiMap this$0;
    
    private RegularImmutableBiMap$Inverse(final RegularImmutableBiMap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public int size() {
        return this.inverse().size();
    }
    
    @Override
    public ImmutableBiMap inverse() {
        return this.this$0;
    }
    
    @Override
    public Object get(@Nullable final Object o) {
        if (o == null || this.this$0.valueTable == null) {
            return null;
        }
        for (ImmutableMapEntry nextInValueBucket = this.this$0.valueTable[Hashing.smear(o.hashCode()) & this.this$0.mask]; nextInValueBucket != null; nextInValueBucket = nextInValueBucket.getNextInValueBucket()) {
            if (o.equals(nextInValueBucket.getValue())) {
                return nextInValueBucket.getKey();
            }
        }
        return null;
    }
    
    @Override
    ImmutableSet createEntrySet() {
        return new RegularImmutableBiMap$Inverse$InverseEntrySet(this);
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    Object writeReplace() {
        return new RegularImmutableBiMap$InverseSerializedForm(this.this$0);
    }
}
