/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch$1;
import com.google.common.base.Ticker;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckReturnValue;

@GwtCompatible(emulated=1)
public final class Stopwatch {
    private final Ticker ticker;
    private boolean isRunning;
    private long elapsedNanos;
    private long startTick;

    @CheckReturnValue
    public static Stopwatch createUnstarted() {
        return new Stopwatch();
    }

    @CheckReturnValue
    public static Stopwatch createUnstarted(Ticker ticker) {
        return new Stopwatch(ticker);
    }

    @CheckReturnValue
    public static Stopwatch createStarted() {
        return new Stopwatch().start();
    }

    @CheckReturnValue
    public static Stopwatch createStarted(Ticker ticker) {
        return new Stopwatch(ticker).start();
    }

    Stopwatch() {
        this.ticker = Ticker.systemTicker();
    }

    Stopwatch(Ticker ticker) {
        this.ticker = (Ticker)Preconditions.checkNotNull(ticker, "ticker");
    }

    @CheckReturnValue
    public boolean isRunning() {
        return this.isRunning;
    }

    public Stopwatch start() {
        Preconditions.checkState(!this.isRunning, "This stopwatch is already running.");
        this.isRunning = true;
        this.startTick = this.ticker.read();
        return this;
    }

    public Stopwatch stop() {
        long l2 = this.ticker.read();
        Preconditions.checkState(this.isRunning, "This stopwatch is already stopped.");
        this.isRunning = false;
        this.elapsedNanos += l2 - this.startTick;
        return this;
    }

    public Stopwatch reset() {
        this.elapsedNanos = 0;
        this.isRunning = false;
        return this;
    }

    private long elapsedNanos() {
        long l2;
        if (this.isRunning) {
            l2 = this.ticker.read() - this.startTick + this.elapsedNanos;
            return l2;
        }
        l2 = this.elapsedNanos;
        return l2;
    }

    @CheckReturnValue
    public long elapsed(TimeUnit timeUnit) {
        return timeUnit.convert(this.elapsedNanos(), TimeUnit.NANOSECONDS);
    }

    @GwtIncompatible(value="String.format()")
    public String toString() {
        long l2 = this.elapsedNanos();
        TimeUnit timeUnit = Stopwatch.chooseUnit(l2);
        double d2 = (double)l2 / (double)TimeUnit.NANOSECONDS.convert(1, timeUnit);
        return String.format(Locale.ROOT, "%.4g %s", d2, Stopwatch.abbreviate(timeUnit));
    }

    private static TimeUnit chooseUnit(long l2) {
        if (TimeUnit.DAYS.convert(l2, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.DAYS;
        }
        if (TimeUnit.HOURS.convert(l2, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.HOURS;
        }
        if (TimeUnit.MINUTES.convert(l2, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MINUTES;
        }
        if (TimeUnit.SECONDS.convert(l2, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.SECONDS;
        }
        if (TimeUnit.MILLISECONDS.convert(l2, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MILLISECONDS;
        }
        if (TimeUnit.MICROSECONDS.convert(l2, TimeUnit.NANOSECONDS) <= 0) return TimeUnit.NANOSECONDS;
        return TimeUnit.MICROSECONDS;
    }

    private static String abbreviate(TimeUnit timeUnit) {
        switch (Stopwatch$1.$SwitchMap$java$util$concurrent$TimeUnit[timeUnit.ordinal()]) {
            case 1: {
                return "ns";
            }
            case 2: {
                return "\u03bcs";
            }
            case 3: {
                return "ms";
            }
            case 4: {
                return "s";
            }
            case 5: {
                return "min";
            }
            case 6: {
                return "h";
            }
            case 7: {
                return "d";
            }
        }
        throw new AssertionError();
    }
}

