package com.google.common.base;

import javax.annotation.*;
import java.util.concurrent.*;
import java.util.*;
import com.google.common.annotations.*;

@GwtCompatible(emulated = true)
public final class Stopwatch
{
    private final Ticker ticker;
    private boolean isRunning;
    private long elapsedNanos;
    private long startTick;
    
    @CheckReturnValue
    public static Stopwatch createUnstarted() {
        return new Stopwatch();
    }
    
    @CheckReturnValue
    public static Stopwatch createUnstarted(final Ticker ticker) {
        return new Stopwatch(ticker);
    }
    
    @CheckReturnValue
    public static Stopwatch createStarted() {
        return new Stopwatch().start();
    }
    
    @CheckReturnValue
    public static Stopwatch createStarted(final Ticker ticker) {
        return new Stopwatch(ticker).start();
    }
    
    Stopwatch() {
        this.ticker = Ticker.systemTicker();
    }
    
    Stopwatch(final Ticker ticker) {
        this.ticker = (Ticker)Preconditions.checkNotNull(ticker, (Object)"ticker");
    }
    
    @CheckReturnValue
    public boolean isRunning() {
        return this.isRunning;
    }
    
    public Stopwatch start() {
        Preconditions.checkState(!this.isRunning, (Object)"This stopwatch is already running.");
        this.isRunning = true;
        this.startTick = this.ticker.read();
        return this;
    }
    
    public Stopwatch stop() {
        final long read = this.ticker.read();
        Preconditions.checkState(this.isRunning, (Object)"This stopwatch is already stopped.");
        this.isRunning = false;
        this.elapsedNanos += read - this.startTick;
        return this;
    }
    
    public Stopwatch reset() {
        this.elapsedNanos = 0L;
        this.isRunning = false;
        return this;
    }
    
    private long elapsedNanos() {
        return this.isRunning ? (this.ticker.read() - this.startTick + this.elapsedNanos) : this.elapsedNanos;
    }
    
    @CheckReturnValue
    public long elapsed(final TimeUnit timeUnit) {
        return timeUnit.convert(this.elapsedNanos(), TimeUnit.NANOSECONDS);
    }
    
    @GwtIncompatible("String.format()")
    @Override
    public String toString() {
        final long elapsedNanos = this.elapsedNanos();
        final TimeUnit chooseUnit = chooseUnit(elapsedNanos);
        return String.format(Locale.ROOT, "%.4g %s", elapsedNanos / TimeUnit.NANOSECONDS.convert(1L, chooseUnit), abbreviate(chooseUnit));
    }
    
    private static TimeUnit chooseUnit(final long n) {
        if (TimeUnit.DAYS.convert(n, TimeUnit.NANOSECONDS) > 0L) {
            return TimeUnit.DAYS;
        }
        if (TimeUnit.HOURS.convert(n, TimeUnit.NANOSECONDS) > 0L) {
            return TimeUnit.HOURS;
        }
        if (TimeUnit.MINUTES.convert(n, TimeUnit.NANOSECONDS) > 0L) {
            return TimeUnit.MINUTES;
        }
        if (TimeUnit.SECONDS.convert(n, TimeUnit.NANOSECONDS) > 0L) {
            return TimeUnit.SECONDS;
        }
        if (TimeUnit.MILLISECONDS.convert(n, TimeUnit.NANOSECONDS) > 0L) {
            return TimeUnit.MILLISECONDS;
        }
        if (TimeUnit.MICROSECONDS.convert(n, TimeUnit.NANOSECONDS) > 0L) {
            return TimeUnit.MICROSECONDS;
        }
        return TimeUnit.NANOSECONDS;
    }
    
    private static String abbreviate(final TimeUnit timeUnit) {
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
            default: {
                throw new AssertionError();
            }
        }
    }
}
