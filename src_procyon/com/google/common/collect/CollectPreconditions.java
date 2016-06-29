package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;

@GwtCompatible
final class CollectPreconditions
{
    static void checkEntryNotNull(final Object o, final Object o2) {
        if (o == null) {
            final String value = String.valueOf(o2);
            throw new NullPointerException(new StringBuilder(24 + String.valueOf(value).length()).append("null key in entry: null=").append(value).toString());
        }
        if (o2 == null) {
            final String value2 = String.valueOf(o);
            throw new NullPointerException(new StringBuilder(26 + String.valueOf(value2).length()).append("null value in entry: ").append(value2).append("=null").toString());
        }
    }
    
    static int checkNonnegative(final int n, final String s) {
        if (n < 0) {
            throw new IllegalArgumentException(new StringBuilder(40 + String.valueOf(s).length()).append(s).append(" cannot be negative but was: ").append(n).toString());
        }
        return n;
    }
    
    static void checkRemove(final boolean b) {
        Preconditions.checkState(b, (Object)"no calls to next() since the last call to remove()");
    }
}
