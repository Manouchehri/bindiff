package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;

@Beta
@GwtCompatible(emulated = true)
public abstract class TreeTraverser
{
    public abstract Iterable children(final Object p0);
    
    public final FluentIterable preOrderTraversal(final Object o) {
        Preconditions.checkNotNull(o);
        return new TreeTraverser$1(this, o);
    }
    
    UnmodifiableIterator preOrderIterator(final Object o) {
        return new TreeTraverser$PreOrderIterator(this, o);
    }
    
    public final FluentIterable postOrderTraversal(final Object o) {
        Preconditions.checkNotNull(o);
        return new TreeTraverser$2(this, o);
    }
    
    UnmodifiableIterator postOrderIterator(final Object o) {
        return new TreeTraverser$PostOrderIterator(this, o);
    }
    
    public final FluentIterable breadthFirstTraversal(final Object o) {
        Preconditions.checkNotNull(o);
        return new TreeTraverser$3(this, o);
    }
}
