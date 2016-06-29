package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class TreeBasedTable$1 implements Function
{
    final /* synthetic */ TreeBasedTable this$0;
    
    TreeBasedTable$1(final TreeBasedTable this$0) {
        this.this$0 = this$0;
    }
    
    public Iterator apply(final Map map) {
        return map.keySet().iterator();
    }
}
