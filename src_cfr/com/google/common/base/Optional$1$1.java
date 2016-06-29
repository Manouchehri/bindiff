/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.AbstractIterator;
import com.google.common.base.Optional;
import com.google.common.base.Optional$1;
import com.google.common.base.Preconditions;
import java.util.Iterator;

class Optional$1$1
extends AbstractIterator {
    private final Iterator iterator;
    final /* synthetic */ Optional$1 this$0;

    Optional$1$1(Optional$1 optional$1) {
        this.this$0 = optional$1;
        this.iterator = (Iterator)Preconditions.checkNotNull(this.this$0.val$optionals.iterator());
    }

    @Override
    protected Object computeNext() {
        Optional optional;
        do {
            if (!this.iterator.hasNext()) return this.endOfData();
        } while (!(optional = (Optional)this.iterator.next()).isPresent());
        return optional.get();
    }
}

