package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;

@Beta
public final class Interners
{
    public static Interner newStrongInterner() {
        return new Interners$1(new MapMaker().makeMap());
    }
    
    @GwtIncompatible("java.lang.ref.WeakReference")
    public static Interner newWeakInterner() {
        return new Interners$WeakInterner(null);
    }
    
    public static Function asFunction(final Interner interner) {
        return new Interners$InternerFunction((Interner)Preconditions.checkNotNull(interner));
    }
}
