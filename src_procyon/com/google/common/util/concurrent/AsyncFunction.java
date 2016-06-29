package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import javax.annotation.*;

@GwtCompatible
public interface AsyncFunction
{
    ListenableFuture apply(@Nullable final Object p0);
}
