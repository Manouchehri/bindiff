package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;

@GwtCompatible
@GoogleInternal
public final class BackDoorsForLabs
{
    public static Multimap synchronizedMultimap(final Multimap multimap, @Nullable final Object o) {
        return Synchronized.multimap(multimap, o);
    }
    
    public static SetMultimap synchronizedSetMultimap(final SetMultimap setMultimap, @Nullable final Object o) {
        return Synchronized.setMultimap(setMultimap, o);
    }
}
