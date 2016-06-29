package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch$1;
import com.google.common.base.Ticker;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckReturnValue;

@GwtCompatible(
   emulated = true
)
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
   public static Stopwatch createUnstarted(Ticker var0) {
      return new Stopwatch(var0);
   }

   @CheckReturnValue
   public static Stopwatch createStarted() {
      return (new Stopwatch()).start();
   }

   @CheckReturnValue
   public static Stopwatch createStarted(Ticker var0) {
      return (new Stopwatch(var0)).start();
   }

   Stopwatch() {
      this.ticker = Ticker.systemTicker();
   }

   Stopwatch(Ticker var1) {
      this.ticker = (Ticker)Preconditions.checkNotNull(var1, "ticker");
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
      long var1 = this.ticker.read();
      Preconditions.checkState(this.isRunning, "This stopwatch is already stopped.");
      this.isRunning = false;
      this.elapsedNanos += var1 - this.startTick;
      return this;
   }

   public Stopwatch reset() {
      this.elapsedNanos = 0L;
      this.isRunning = false;
      return this;
   }

   private long elapsedNanos() {
      return this.isRunning?this.ticker.read() - this.startTick + this.elapsedNanos:this.elapsedNanos;
   }

   @CheckReturnValue
   public long elapsed(TimeUnit var1) {
      return var1.convert(this.elapsedNanos(), TimeUnit.NANOSECONDS);
   }

   @GwtIncompatible("String.format()")
   public String toString() {
      long var1 = this.elapsedNanos();
      TimeUnit var3 = chooseUnit(var1);
      double var4 = (double)var1 / (double)TimeUnit.NANOSECONDS.convert(1L, var3);
      return String.format(Locale.ROOT, "%.4g %s", new Object[]{Double.valueOf(var4), abbreviate(var3)});
   }

   private static TimeUnit chooseUnit(long var0) {
      return TimeUnit.DAYS.convert(var0, TimeUnit.NANOSECONDS) > 0L?TimeUnit.DAYS:(TimeUnit.HOURS.convert(var0, TimeUnit.NANOSECONDS) > 0L?TimeUnit.HOURS:(TimeUnit.MINUTES.convert(var0, TimeUnit.NANOSECONDS) > 0L?TimeUnit.MINUTES:(TimeUnit.SECONDS.convert(var0, TimeUnit.NANOSECONDS) > 0L?TimeUnit.SECONDS:(TimeUnit.MILLISECONDS.convert(var0, TimeUnit.NANOSECONDS) > 0L?TimeUnit.MILLISECONDS:(TimeUnit.MICROSECONDS.convert(var0, TimeUnit.NANOSECONDS) > 0L?TimeUnit.MICROSECONDS:TimeUnit.NANOSECONDS)))));
   }

   private static String abbreviate(TimeUnit var0) {
      switch(Stopwatch$1.$SwitchMap$java$util$concurrent$TimeUnit[var0.ordinal()]) {
      case 1:
         return "ns";
      case 2:
         return "μs";
      case 3:
         return "ms";
      case 4:
         return "s";
      case 5:
         return "min";
      case 6:
         return "h";
      case 7:
         return "d";
      default:
         throw new AssertionError();
      }
   }
}
