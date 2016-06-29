package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

final class Maps$FilteredEntryBiMap$1 implements Predicate
{
    final /* synthetic */ Predicate val$forwardPredicate;
    
    Maps$FilteredEntryBiMap$1(final Predicate val$forwardPredicate) {
        this.val$forwardPredicate = val$forwardPredicate;
    }
    
    public boolean apply(final Map.Entry entry) {
        return this.val$forwardPredicate.apply(Maps.immutableEntry(entry.getValue(), entry.getKey()));
    }
}
