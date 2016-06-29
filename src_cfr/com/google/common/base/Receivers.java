/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Receiver;
import com.google.common.base.Receivers$1;
import com.google.common.base.Receivers$CollectingReceiver;
import com.google.common.base.Receivers$CompositeReceiver;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GoogleInternal
@GwtCompatible
public final class Receivers {
    private static final Receiver IGNORING_RECEIVER = new Receivers$1();

    private Receivers() {
    }

    public static Receiver ignore() {
        return IGNORING_RECEIVER;
    }

    public static Receiver collect(Collection collection) {
        return new Receivers$CollectingReceiver(collection);
    }

    public static /* varargs */ Receiver compose(Receiver ... arrreceiver) {
        return new Receivers$CompositeReceiver(Arrays.asList(arrreceiver));
    }

    public static Receiver compose(Iterable iterable) {
        return new Receivers$CompositeReceiver(iterable);
    }
}

