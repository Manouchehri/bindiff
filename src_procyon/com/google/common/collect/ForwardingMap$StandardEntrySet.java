package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

@Beta
public abstract class ForwardingMap$StandardEntrySet extends Maps$EntrySet
{
    final /* synthetic */ ForwardingMap this$0;
    
    public ForwardingMap$StandardEntrySet(final ForwardingMap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    Map map() {
        return this.this$0;
    }
}
