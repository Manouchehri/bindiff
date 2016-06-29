package com.google.security.zynamics.zylib.gui.scripting.console;

import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane;
import com.google.security.zynamics.zylib.gui.scripting.console.ConsolePane$1;

class ConsolePane$TabCompletionManager {
   private int m_completionIndex;
   // $FF: synthetic field
   final ConsolePane this$0;

   private ConsolePane$TabCompletionManager(ConsolePane var1) {
      this.this$0 = var1;
      this.m_completionIndex = 0;
   }

   private String getCompletionCandidate(String[] var1, String var2, int var3) {
      boolean var4 = false;
      String[] var5 = var1;
      int var6 = var1.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         String var8 = var5[var7];
         if(var8.startsWith(var2)) {
            var4 = true;
            if(var3 == 0) {
               ++this.m_completionIndex;
               return var8;
            }

            --var3;
         }
      }

      if(var4) {
         return this.getCompletionCandidate(var1, var2, var3);
      } else {
         return null;
      }
   }

   public String getCompletion(String var1) {
      return this.getCompletionCandidate((String[])ConsolePane.access$3400(this.this$0).toArray(new String[0]), var1, this.m_completionIndex);
   }

   public void reset() {
      this.m_completionIndex = 0;
   }

   // $FF: synthetic method
   ConsolePane$TabCompletionManager(ConsolePane var1, ConsolePane$1 var2) {
      this(var1);
   }
}
