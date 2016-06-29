package com.google.common.cache;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.util.concurrent.*;
import com.google.common.collect.*;
import javax.annotation.*;

final class ShimAsyncCache$1 implements Function
{
    public ListenableFuture apply(final ListenableFuture listenableFuture) {
        return nullHostileFuture(listenableFuture);
    }
}
