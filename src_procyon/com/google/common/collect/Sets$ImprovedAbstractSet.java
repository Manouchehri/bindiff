package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

abstract class Sets$ImprovedAbstractSet extends AbstractSet
{
    @Override
    public boolean removeAll(final Collection collection) {
        return Sets.removeAllImpl(this, collection);
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return super.retainAll((Collection<?>)Preconditions.checkNotNull(collection));
    }
}
