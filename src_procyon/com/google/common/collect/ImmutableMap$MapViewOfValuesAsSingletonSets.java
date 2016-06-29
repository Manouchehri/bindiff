package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

final class ImmutableMap$MapViewOfValuesAsSingletonSets extends ImmutableMap$IteratorBasedImmutableMap
{
    final /* synthetic */ ImmutableMap this$0;
    
    private ImmutableMap$MapViewOfValuesAsSingletonSets(final ImmutableMap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public int size() {
        return this.this$0.size();
    }
    
    @Override
    public ImmutableSet keySet() {
        return this.this$0.keySet();
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.this$0.containsKey(o);
    }
    
    @Override
    public ImmutableSet get(@Nullable final Object o) {
        final Object value = this.this$0.get(o);
        return (value == null) ? null : ImmutableSet.of(value);
    }
    
    @Override
    boolean isPartialView() {
        return this.this$0.isPartialView();
    }
    
    @Override
    public int hashCode() {
        return this.this$0.hashCode();
    }
    
    @Override
    boolean isHashCodeFast() {
        return this.this$0.isHashCodeFast();
    }
    
    @Override
    UnmodifiableIterator entryIterator() {
        return new ImmutableMap$MapViewOfValuesAsSingletonSets$1(this, this.this$0.entrySet().iterator());
    }
}
