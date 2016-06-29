package com.google.common.collect;

import java.util.*;

class ImmutableSetMultimap$BuilderMultimap extends AbstractMapBasedMultimap
{
    private static final long serialVersionUID = 0L;
    
    ImmutableSetMultimap$BuilderMultimap() {
        super(new LinkedHashMap());
    }
    
    @Override
    Collection createCollection() {
        return Sets.newLinkedHashSet();
    }
}
