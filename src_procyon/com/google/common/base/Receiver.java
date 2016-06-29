package com.google.common.base;

import com.google.common.annotations.*;
import javax.annotation.*;

@GoogleInternal
@GwtCompatible
public interface Receiver
{
    void accept(@Nullable final Object p0);
}
