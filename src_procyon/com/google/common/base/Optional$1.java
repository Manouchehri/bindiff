package com.google.common.base;

import java.util.*;

final class Optional$1 implements Iterable
{
    final /* synthetic */ Iterable val$optionals;
    
    Optional$1(final Iterable val$optionals) {
        this.val$optionals = val$optionals;
    }
    
    @Override
    public Iterator iterator() {
        return new Optional$1$1(this);
    }
}
