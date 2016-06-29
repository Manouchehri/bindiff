package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import javax.annotation.*;

@GwtCompatible(emulated = true)
final class Platform
{
    static boolean isInstanceOfThrowableClass(@Nullable final Throwable t, final Class clazz) {
        return clazz.isInstance(t);
    }
}
