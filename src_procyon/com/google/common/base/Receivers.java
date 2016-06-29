package com.google.common.base;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

@CheckReturnValue
@GoogleInternal
@GwtCompatible
public final class Receivers
{
    private static final Receiver IGNORING_RECEIVER;
    
    public static Receiver ignore() {
        return Receivers.IGNORING_RECEIVER;
    }
    
    public static Receiver collect(final Collection collection) {
        return new Receivers$CollectingReceiver(collection);
    }
    
    public static Receiver compose(final Receiver... array) {
        return new Receivers$CompositeReceiver(Arrays.asList(array));
    }
    
    public static Receiver compose(final Iterable iterable) {
        return new Receivers$CompositeReceiver(iterable);
    }
    
    static {
        IGNORING_RECEIVER = new Receivers$1();
    }
}
