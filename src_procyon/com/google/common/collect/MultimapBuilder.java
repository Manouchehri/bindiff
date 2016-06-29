package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;
import com.google.common.base.*;

@CheckReturnValue
@Beta
@GwtCompatible
public abstract class MultimapBuilder
{
    private static final int DEFAULT_EXPECTED_KEYS = 8;
    
    public static MultimapBuilder$MultimapBuilderWithKeys hashKeys() {
        return hashKeys(8);
    }
    
    public static MultimapBuilder$MultimapBuilderWithKeys hashKeys(final int n) {
        CollectPreconditions.checkNonnegative(n, "expectedKeys");
        return new MultimapBuilder$1(n);
    }
    
    public static MultimapBuilder$MultimapBuilderWithKeys linkedHashKeys() {
        return linkedHashKeys(8);
    }
    
    public static MultimapBuilder$MultimapBuilderWithKeys linkedHashKeys(final int n) {
        CollectPreconditions.checkNonnegative(n, "expectedKeys");
        return new MultimapBuilder$2(n);
    }
    
    public static MultimapBuilder$MultimapBuilderWithKeys treeKeys() {
        return treeKeys(Ordering.natural());
    }
    
    public static MultimapBuilder$MultimapBuilderWithKeys treeKeys(final Comparator comparator) {
        Preconditions.checkNotNull(comparator);
        return new MultimapBuilder$3(comparator);
    }
    
    public static MultimapBuilder$MultimapBuilderWithKeys enumKeys(final Class clazz) {
        Preconditions.checkNotNull(clazz);
        return new MultimapBuilder$4(clazz);
    }
    
    public abstract Multimap build();
    
    public Multimap build(final Multimap multimap) {
        final Multimap build = this.build();
        build.putAll(multimap);
        return build;
    }
}
