package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

@Beta
@GwtCompatible(emulated = true)
public abstract class BinaryTreeTraverser extends TreeTraverser
{
    public abstract Optional leftChild(final Object p0);
    
    public abstract Optional rightChild(final Object p0);
    
    @Override
    public final Iterable children(final Object o) {
        Preconditions.checkNotNull(o);
        return new BinaryTreeTraverser$1(this, o);
    }
    
    @Override
    UnmodifiableIterator preOrderIterator(final Object o) {
        return new BinaryTreeTraverser$PreOrderIterator(this, o);
    }
    
    @Override
    UnmodifiableIterator postOrderIterator(final Object o) {
        return new BinaryTreeTraverser$PostOrderIterator(this, o);
    }
    
    public final FluentIterable inOrderTraversal(final Object o) {
        Preconditions.checkNotNull(o);
        return new BinaryTreeTraverser$2(this, o);
    }
    
    private static void pushIfPresent(final Deque deque, final Optional optional) {
        if (optional.isPresent()) {
            deque.addLast(optional.get());
        }
    }
}
