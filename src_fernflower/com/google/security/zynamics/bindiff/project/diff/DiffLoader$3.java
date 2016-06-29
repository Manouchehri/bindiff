package com.google.security.zynamics.bindiff.project.diff;

import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffLoader;
import com.google.security.zynamics.bindiff.project.diff.IDiffListener;
import java.util.Iterator;

class DiffLoader$3 implements Runnable {
   // $FF: synthetic field
   final Diff val$diff;
   // $FF: synthetic field
   final DiffLoader this$0;

   DiffLoader$3(DiffLoader var1, Diff var2) {
      this.this$0 = var1;
      this.val$diff = var2;
   }

   public void run() {
      Iterator var1 = this.val$diff.getListener().iterator();

      while(var1.hasNext()) {
         IDiffListener var2 = (IDiffListener)var1.next();
         var2.loadedDiff(this.val$diff);
      }

   }
}
