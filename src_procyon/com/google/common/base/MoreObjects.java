package com.google.common.base;

import com.google.common.annotations.*;
import javax.annotation.*;

@GwtCompatible
public final class MoreObjects
{
    @CheckReturnValue
    public static Object firstNonNull(@Nullable final Object o, @Nullable final Object o2) {
        return (o != null) ? o : Preconditions.checkNotNull(o2);
    }
    
    @CheckReturnValue
    public static MoreObjects$ToStringHelper toStringHelper(final Object o) {
        return new MoreObjects$ToStringHelper(o.getClass().getSimpleName(), null);
    }
    
    @CheckReturnValue
    public static MoreObjects$ToStringHelper toStringHelper(final Class clazz) {
        return new MoreObjects$ToStringHelper(clazz.getSimpleName(), null);
    }
    
    @CheckReturnValue
    public static MoreObjects$ToStringHelper toStringHelper(final String s) {
        return new MoreObjects$ToStringHelper(s, null);
    }
}
