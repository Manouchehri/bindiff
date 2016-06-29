package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.errorprone.annotations.concurrent.*;
import com.google.common.primitives.*;
import com.google.common.base.*;
import java.util.*;

final class RegularImmutableMultiset$ElementSet extends ImmutableSet$Indexed
{
    final /* synthetic */ RegularImmutableMultiset this$0;
    
    private RegularImmutableMultiset$ElementSet(final RegularImmutableMultiset this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    Object get(final int n) {
        return this.this$0.entries[n].getElement();
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return this.this$0.contains(o);
    }
    
    @Override
    boolean isPartialView() {
        return true;
    }
    
    @Override
    public int size() {
        return this.this$0.entries.length;
    }
}
