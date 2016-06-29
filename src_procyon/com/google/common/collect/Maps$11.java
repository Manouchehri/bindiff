package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

final class Maps$11 implements Function
{
    final /* synthetic */ Maps$EntryTransformer val$transformer;
    
    Maps$11(final Maps$EntryTransformer val$transformer) {
        this.val$transformer = val$transformer;
    }
    
    public Map.Entry apply(final Map.Entry entry) {
        return Maps.transformEntry(this.val$transformer, entry);
    }
}
