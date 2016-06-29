package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

@Beta
public class ForwardingNavigableMap$StandardDescendingMap extends Maps$DescendingMap
{
    final /* synthetic */ ForwardingNavigableMap this$0;
    
    public ForwardingNavigableMap$StandardDescendingMap(final ForwardingNavigableMap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    NavigableMap forward() {
        return this.this$0;
    }
    
    protected Iterator entryIterator() {
        return new ForwardingNavigableMap$StandardDescendingMap$1(this);
    }
}
