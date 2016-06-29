package org.jfree.base.log;

public class MemoryUsageMessage {
   private final String message;

   public MemoryUsageMessage(String var1) {
      this.message = var1;
   }

   public String toString() {
      return this.message + "Free: " + Runtime.getRuntime().freeMemory() + "; " + "Total: " + Runtime.getRuntime().totalMemory();
   }
}
