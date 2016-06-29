package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

final class TreeTraverser$PostOrderNode
{
    final Object root;
    final Iterator childIterator;
    
    TreeTraverser$PostOrderNode(final Object o, final Iterator iterator) {
        this.root = Preconditions.checkNotNull(o);
        this.childIterator = (Iterator)Preconditions.checkNotNull(iterator);
    }
}
