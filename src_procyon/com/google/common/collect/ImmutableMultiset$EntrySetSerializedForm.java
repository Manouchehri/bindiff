package com.google.common.collect;

import java.io.*;

class ImmutableMultiset$EntrySetSerializedForm implements Serializable
{
    final ImmutableMultiset multiset;
    
    ImmutableMultiset$EntrySetSerializedForm(final ImmutableMultiset multiset) {
        this.multiset = multiset;
    }
    
    Object readResolve() {
        return this.multiset.entrySet();
    }
}
