package com.google.common.base;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible
public final class Objects
{
    @CheckReturnValue
    public static boolean equal(@Nullable final Object o, @Nullable final Object o2) {
        return o == o2 || (o != null && o.equals(o2));
    }
    
    @CheckReturnValue
    public static int hashCode(@Nullable final Object... array) {
        return Arrays.hashCode(array);
    }
    
    @CheckReturnValue
    @Deprecated
    public static Objects$ToStringHelper toStringHelper(final Object o) {
        return new Objects$ToStringHelper(o.getClass().getSimpleName(), null);
    }
    
    @CheckReturnValue
    @Deprecated
    public static Objects$ToStringHelper toStringHelper(final Class clazz) {
        return new Objects$ToStringHelper(clazz.getSimpleName(), null);
    }
    
    @CheckReturnValue
    @Deprecated
    public static Objects$ToStringHelper toStringHelper(final String s) {
        return new Objects$ToStringHelper(s, null);
    }
    
    @CheckReturnValue
    @Deprecated
    public static Object firstNonNull(@Nullable final Object o, @Nullable final Object o2) {
        return MoreObjects.firstNonNull(o, o2);
    }
}
