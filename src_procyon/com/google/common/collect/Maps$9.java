package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

final class Maps$9 implements Function
{
    final /* synthetic */ Maps$EntryTransformer val$transformer;
    
    Maps$9(final Maps$EntryTransformer val$transformer) {
        this.val$transformer = val$transformer;
    }
    
    public Object apply(final Map.Entry entry) {
        return this.val$transformer.transformEntry(entry.getKey(), entry.getValue());
    }
}
