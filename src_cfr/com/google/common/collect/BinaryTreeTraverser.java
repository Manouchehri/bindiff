/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.BinaryTreeTraverser$1;
import com.google.common.collect.BinaryTreeTraverser$2;
import com.google.common.collect.BinaryTreeTraverser$PostOrderIterator;
import com.google.common.collect.BinaryTreeTraverser$PreOrderIterator;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.TreeTraverser;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Deque;

@Beta
@GwtCompatible(emulated=1)
public abstract class BinaryTreeTraverser
extends TreeTraverser {
    public abstract Optional leftChild(Object var1);

    public abstract Optional rightChild(Object var1);

    @Override
    public final Iterable children(Object object) {
        Preconditions.checkNotNull(object);
        return new BinaryTreeTraverser$1(this, object);
    }

    @Override
    UnmodifiableIterator preOrderIterator(Object object) {
        return new BinaryTreeTraverser$PreOrderIterator(this, object);
    }

    @Override
    UnmodifiableIterator postOrderIterator(Object object) {
        return new BinaryTreeTraverser$PostOrderIterator(this, object);
    }

    public final FluentIterable inOrderTraversal(Object object) {
        Preconditions.checkNotNull(object);
        return new BinaryTreeTraverser$2(this, object);
    }

    private static void pushIfPresent(Deque deque, Optional optional) {
        if (!optional.isPresent()) return;
        deque.addLast(optional.get());
    }

    static /* synthetic */ void access$000(Deque deque, Optional optional) {
        BinaryTreeTraverser.pushIfPresent(deque, optional);
    }
}

