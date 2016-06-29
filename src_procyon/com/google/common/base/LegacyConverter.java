package com.google.common.base;

import com.google.common.annotations.*;
import javax.annotation.*;

@Deprecated
@GoogleInternal
@GwtCompatible
public abstract class LegacyConverter extends Converter
{
    protected LegacyConverter() {
        super(false);
    }
    
    @Nullable
    @Override
    protected abstract Object doForward(@Nullable final Object p0);
    
    @Nullable
    @Override
    protected abstract Object doBackward(@Nullable final Object p0);
}
