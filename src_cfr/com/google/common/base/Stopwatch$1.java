/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import java.util.concurrent.TimeUnit;

class Stopwatch$1 {
    static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit;

    static {
        $SwitchMap$java$util$concurrent$TimeUnit = new int[TimeUnit.values().length];
        try {
            Stopwatch$1.$SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.NANOSECONDS.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            Stopwatch$1.$SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MICROSECONDS.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            Stopwatch$1.$SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MILLISECONDS.ordinal()] = 3;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
        try {
            Stopwatch$1.$SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.SECONDS.ordinal()] = 4;
        }
        catch (NoSuchFieldError var0_3) {
            // empty catch block
        }
        try {
            Stopwatch$1.$SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MINUTES.ordinal()] = 5;
        }
        catch (NoSuchFieldError var0_4) {
            // empty catch block
        }
        try {
            Stopwatch$1.$SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.HOURS.ordinal()] = 6;
        }
        catch (NoSuchFieldError var0_5) {
            // empty catch block
        }
        try {
            Stopwatch$1.$SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.DAYS.ordinal()] = 7;
            return;
        }
        catch (NoSuchFieldError var0_6) {
            // empty catch block
        }
    }
}

