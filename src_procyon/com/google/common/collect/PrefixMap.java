package com.google.common.collect;

import com.google.common.annotations.*;

@GoogleInternal
public interface PrefixMap
{
    Object put(final CharSequence p0, final Object p1);
    
    Object get(final CharSequence p0);
    
    Object remove(final CharSequence p0);
}
