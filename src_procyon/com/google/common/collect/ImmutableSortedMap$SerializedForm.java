package com.google.common.collect;

import java.util.*;

class ImmutableSortedMap$SerializedForm extends ImmutableMap$SerializedForm
{
    private final Comparator comparator;
    private static final long serialVersionUID = 0L;
    
    ImmutableSortedMap$SerializedForm(final ImmutableSortedMap immutableSortedMap) {
        super(immutableSortedMap);
        this.comparator = immutableSortedMap.comparator();
    }
    
    @Override
    Object readResolve() {
        return this.createMap(new ImmutableSortedMap$Builder(this.comparator));
    }
}
