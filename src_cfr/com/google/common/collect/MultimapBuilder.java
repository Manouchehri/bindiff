/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder$1;
import com.google.common.collect.MultimapBuilder$2;
import com.google.common.collect.MultimapBuilder$3;
import com.google.common.collect.MultimapBuilder$4;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.Ordering;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@Beta
@GwtCompatible
public abstract class MultimapBuilder {
    private static final int DEFAULT_EXPECTED_KEYS = 8;

    private MultimapBuilder() {
    }

    public static MultimapBuilder$MultimapBuilderWithKeys hashKeys() {
        return MultimapBuilder.hashKeys(8);
    }

    public static MultimapBuilder$MultimapBuilderWithKeys hashKeys(int n2) {
        CollectPreconditions.checkNonnegative(n2, "expectedKeys");
        return new MultimapBuilder$1(n2);
    }

    public static MultimapBuilder$MultimapBuilderWithKeys linkedHashKeys() {
        return MultimapBuilder.linkedHashKeys(8);
    }

    public static MultimapBuilder$MultimapBuilderWithKeys linkedHashKeys(int n2) {
        CollectPreconditions.checkNonnegative(n2, "expectedKeys");
        return new MultimapBuilder$2(n2);
    }

    public static MultimapBuilder$MultimapBuilderWithKeys treeKeys() {
        return MultimapBuilder.treeKeys(Ordering.natural());
    }

    public static MultimapBuilder$MultimapBuilderWithKeys treeKeys(Comparator comparator) {
        Preconditions.checkNotNull(comparator);
        return new MultimapBuilder$3(comparator);
    }

    public static MultimapBuilder$MultimapBuilderWithKeys enumKeys(Class class_) {
        Preconditions.checkNotNull(class_);
        return new MultimapBuilder$4(class_);
    }

    public abstract Multimap build();

    public Multimap build(Multimap multimap) {
        Multimap multimap2 = this.build();
        multimap2.putAll(multimap);
        return multimap2;
    }

    /* synthetic */ MultimapBuilder(MultimapBuilder$1 multimapBuilder$1) {
        this();
    }
}

