package com.google.security.zynamics.bindiff.utils;

import com.google.security.zynamics.bindiff.log.Logger;

public class Timer {
   private long startTime = 0L;
   private long endTime = 0L;
   private long lastStartTime = 0L;

   public void end() {
      this.endTime = System.currentTimeMillis();
   }

   public void printTime() {
      this.end();
      long var1 = this.endTime - this.startTime;
      Logger.logVerbose((new StringBuilder(40)).append("Elapsed time in ms: ").append(var1).toString(), new Object[0]);
   }

   public void printTime(String var1) {
      this.end();
      long var2 = this.endTime - this.startTime;
      long var4 = this.endTime - this.lastStartTime;
      Logger.logVerbose((new StringBuilder(68 + String.valueOf(var1).length())).append("Elapsed time in ms: ").append(var2).append("[").append(var4).append("]").append("  --  ").append(var1).toString(), new Object[0]);
      this.lastStartTime = System.currentTimeMillis();
   }

   public void start() {
      this.startTime = System.currentTimeMillis();
      this.lastStartTime = System.currentTimeMillis();
   }

   public void start(String var1) {
      Logger.logVerbose(var1, new Object[0]);
      this.start();
   }
}
