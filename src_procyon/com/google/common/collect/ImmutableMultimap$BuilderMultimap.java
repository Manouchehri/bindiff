package com.google.common.collect;

import java.util.*;

class ImmutableMultimap$BuilderMultimap extends AbstractMapBasedMultimap
{
    private static final long serialVersionUID = 0L;
    
    ImmutableMultimap$BuilderMultimap() {
        super(new LinkedHashMap());
    }
    
    @Override
    Collection createCollection() {
        return Lists.newArrayList();
    }
}
