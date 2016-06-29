package com.google.common.collect;

import java.util.concurrent.*;
import com.google.common.base.*;

final class Interners$1 implements Interner
{
    final /* synthetic */ ConcurrentMap val$map;
    
    Interners$1(final ConcurrentMap val$map) {
        this.val$map = val$map;
    }
    
    @Override
    public Object intern(final Object o) {
        final Object putIfAbsent = this.val$map.putIfAbsent(Preconditions.checkNotNull(o), o);
        return (putIfAbsent == null) ? o : putIfAbsent;
    }
}
