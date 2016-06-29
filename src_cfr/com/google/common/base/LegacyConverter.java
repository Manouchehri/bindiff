/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Converter;
import javax.annotation.Nullable;

@Deprecated
@GoogleInternal
@GwtCompatible
public abstract class LegacyConverter
extends Converter {
    protected LegacyConverter() {
        super(false);
    }

    @Nullable
    @Override
    protected abstract Object doForward(@Nullable Object var1);

    @Nullable
    @Override
    protected abstract Object doBackward(@Nullable Object var1);
}

