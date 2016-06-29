/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Throwables;
import java.util.AbstractList;

final class Throwables$1
extends AbstractList {
    final /* synthetic */ Throwable val$t;

    Throwables$1(Throwable throwable) {
        this.val$t = throwable;
    }

    @Override
    public StackTraceElement get(int n2) {
        return (StackTraceElement)Throwables.access$200(Throwables.access$000(), Throwables.access$100(), new Object[]{this.val$t, n2});
    }

    @Override
    public int size() {
        return (Integer)Throwables.access$200(Throwables.access$300(), Throwables.access$100(), new Object[]{this.val$t});
    }
}

