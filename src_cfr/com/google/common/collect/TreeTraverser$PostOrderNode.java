/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;

final class TreeTraverser$PostOrderNode {
    final Object root;
    final Iterator childIterator;

    TreeTraverser$PostOrderNode(Object object, Iterator iterator) {
        this.root = Preconditions.checkNotNull(object);
        this.childIterator = (Iterator)Preconditions.checkNotNull(iterator);
    }
}

