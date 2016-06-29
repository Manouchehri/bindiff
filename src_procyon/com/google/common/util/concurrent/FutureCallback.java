package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import javax.annotation.*;

@GwtCompatible
public interface FutureCallback
{
    void onSuccess(@Nullable final Object p0);
    
    void onFailure(final Throwable p0);
}
