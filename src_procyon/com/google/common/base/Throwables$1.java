package com.google.common.base;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;

final class Throwables$1 extends AbstractList
{
    final /* synthetic */ Throwable val$t;
    
    Throwables$1(final Throwable val$t) {
        this.val$t = val$t;
    }
    
    @Override
    public StackTraceElement get(final int n) {
        return (StackTraceElement)invokeAccessibleNonThrowingMethod(Throwables.getStackTraceElementMethod, Throwables.jla, new Object[] { this.val$t, n });
    }
    
    @Override
    public int size() {
        return (int)invokeAccessibleNonThrowingMethod(Throwables.getStackTraceDepthMethod, Throwables.jla, new Object[] { this.val$t });
    }
}
