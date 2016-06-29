package com.google.common.collect;

import java.util.*;

abstract class ImmutableMap$IteratorBasedImmutableMap extends ImmutableMap
{
    abstract UnmodifiableIterator entryIterator();
    
    @Override
    ImmutableSet createEntrySet() {
        return new ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl(this);
    }
}
