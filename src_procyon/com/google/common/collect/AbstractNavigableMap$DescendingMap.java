package com.google.common.collect;

import java.util.*;

final class AbstractNavigableMap$DescendingMap extends Maps$DescendingMap
{
    final /* synthetic */ AbstractNavigableMap this$0;
    
    private AbstractNavigableMap$DescendingMap(final AbstractNavigableMap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    NavigableMap forward() {
        return this.this$0;
    }
    
    @Override
    Iterator entryIterator() {
        return this.this$0.descendingEntryIterator();
    }
}
