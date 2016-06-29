package org.jfree.util;

import java.io.PrintStream;
import java.io.Serializable;
import org.jfree.util.LogTarget;

public class PrintStreamLogTarget implements Serializable, LogTarget {
   private static final long serialVersionUID = 6510564403264504688L;
   private PrintStream printStream;

   public PrintStreamLogTarget() {
      this(System.out);
   }

   public PrintStreamLogTarget(PrintStream var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.printStream = var1;
      }
   }

   public void log(int var1, Object var2) {
      if(var1 > 3) {
         var1 = 3;
      }

      this.printStream.print(LogTarget.LEVELS[var1]);
      this.printStream.println(var2);
      if(var1 < 3) {
         System.out.flush();
      }

   }

   public void log(int var1, Object var2, Exception var3) {
      if(var1 > 3) {
         var1 = 3;
      }

      this.printStream.print(LogTarget.LEVELS[var1]);
      this.printStream.println(var2);
      var3.printStackTrace(this.printStream);
      if(var1 < 3) {
         System.out.flush();
      }

   }
}
