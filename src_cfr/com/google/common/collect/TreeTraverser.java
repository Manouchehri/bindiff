/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.TreeTraverser$1;
import com.google.common.collect.TreeTraverser$2;
import com.google.common.collect.TreeTraverser$3;
import com.google.common.collect.TreeTraverser$PostOrderIterator;
import com.google.common.collect.TreeTraverser$PreOrderIterator;
import com.google.common.collect.UnmodifiableIterator;

@Beta
@GwtCompatible(emulated=1)
public abstract class TreeTraverser {
    public abstract Iterable children(Object var1);

    public final FluentIterable preOrderTraversal(Object object) {
        Preconditions.checkNotNull(object);
        return new TreeTraverser$1(this, object);
    }

    UnmodifiableIterator preOrderIterator(Object object) {
        return new TreeTraverser$PreOrderIterator(this, object);
    }

    public final FluentIterable postOrderTraversal(Object object) {
        Preconditions.checkNotNull(object);
        return new TreeTraverser$2(this, object);
    }

    UnmodifiableIterator postOrderIterator(Object object) {
        return new TreeTraverser$PostOrderIterator(this, object);
    }

    public final FluentIterable breadthFirstTraversal(Object object) {
        Preconditions.checkNotNull(object);
        return new TreeTraverser$3(this, object);
    }
}

