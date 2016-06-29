package com.google.common.cache;

import com.google.common.annotations.*;

@GwtCompatible
public interface RemovalListener
{
    void onRemoval(final RemovalNotification p0);
}
