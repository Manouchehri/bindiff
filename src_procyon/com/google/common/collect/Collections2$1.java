package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

final class Collections2$1 implements Function
{
    final /* synthetic */ Collection val$collection;
    
    Collections2$1(final Collection val$collection) {
        this.val$collection = val$collection;
    }
    
    @Override
    public Object apply(final Object o) {
        return (o == this.val$collection) ? "(this Collection)" : o;
    }
}
