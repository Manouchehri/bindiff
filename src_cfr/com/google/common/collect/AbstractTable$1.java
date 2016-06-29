/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractTable;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;

class AbstractTable$1
extends TransformedIterator {
    final /* synthetic */ AbstractTable this$0;

    AbstractTable$1(AbstractTable abstractTable, Iterator iterator) {
        this.this$0 = abstractTable;
        super(iterator);
    }

    Object transform(Table$Cell table$Cell) {
        return table$Cell.getValue();
    }
}

