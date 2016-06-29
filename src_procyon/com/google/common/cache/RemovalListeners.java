package com.google.common.cache;

import java.util.concurrent.*;
import com.google.common.base.*;

public final class RemovalListeners
{
    public static RemovalListener asynchronous(final RemovalListener removalListener, final Executor executor) {
        Preconditions.checkNotNull(removalListener);
        Preconditions.checkNotNull(executor);
        return new RemovalListeners$1(executor, removalListener);
    }
}
