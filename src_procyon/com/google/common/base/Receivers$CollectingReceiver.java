package com.google.common.base;

import java.util.*;
import javax.annotation.*;

final class Receivers$CollectingReceiver implements Receiver
{
    private final Collection collection;
    
    Receivers$CollectingReceiver(final Collection collection) {
        this.collection = (Collection)Preconditions.checkNotNull(collection);
    }
    
    @Override
    public void accept(@Nullable final Object o) {
        this.collection.add(o);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Receivers$CollectingReceiver && this.collection == ((Receivers$CollectingReceiver)o).collection;
    }
    
    @Override
    public int hashCode() {
        return System.identityHashCode(this.collection);
    }
}
