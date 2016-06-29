package com.google.security.zynamics.zylib.general;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import java.lang.ref.WeakReference;

public class ListenerProvider$ComparableReference extends WeakReference {
   // $FF: synthetic field
   final ListenerProvider this$0;

   public ListenerProvider$ComparableReference(ListenerProvider var1, Object var2) {
      super(var2);
      this.this$0 = var1;
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else {
         ListenerProvider$ComparableReference var2 = (ListenerProvider$ComparableReference)var1;
         Object var3 = this.get();
         Object var4 = var2.get();
         return var3 == null && var4 == null?true:(var3 != null && var4 != null?var3.equals(var4):false);
      }
   }

   public int hashCode() {
      Object var1 = this.get();
      return var1 == null?0:var1.hashCode();
   }
}
