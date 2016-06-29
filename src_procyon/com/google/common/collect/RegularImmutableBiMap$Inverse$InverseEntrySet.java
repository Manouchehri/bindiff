package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;
import com.google.errorprone.annotations.concurrent.*;
import com.google.common.base.*;
import javax.annotation.*;

final class RegularImmutableBiMap$Inverse$InverseEntrySet extends ImmutableMapEntrySet
{
    final /* synthetic */ RegularImmutableBiMap$Inverse this$1;
    
    RegularImmutableBiMap$Inverse$InverseEntrySet(final RegularImmutableBiMap$Inverse this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    ImmutableMap map() {
        return this.this$1;
    }
    
    @Override
    boolean isHashCodeFast() {
        return true;
    }
    
    @Override
    public int hashCode() {
        return this.this$1.this$0.hashCode;
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return this.asList().iterator();
    }
    
    @Override
    ImmutableList createAsList() {
        return new RegularImmutableBiMap$Inverse$InverseEntrySet$1(this);
    }
}
