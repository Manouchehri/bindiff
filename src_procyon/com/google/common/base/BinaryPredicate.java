package com.google.common.base;

import com.google.common.annotations.*;
import javax.annotation.*;

@GoogleInternal
@GwtCompatible
public interface BinaryPredicate
{
    boolean apply(@Nullable final Object p0, @Nullable final Object p1);
}
