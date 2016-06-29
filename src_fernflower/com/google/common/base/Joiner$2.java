package com.google.common.base;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner$1;
import com.google.common.base.Joiner$MapJoiner;
import com.google.common.base.Preconditions;
import java.util.Iterator;

class Joiner$2 extends Joiner {
   // $FF: synthetic field
   final Joiner this$0;

   Joiner$2(Joiner var1, Joiner var2) {
      super(var2, (Joiner$1)null);
      this.this$0 = var1;
   }

   public Appendable appendTo(Appendable var1, Iterator var2) {
      Preconditions.checkNotNull(var1, "appendable");
      Preconditions.checkNotNull(var2, "parts");

      Object var3;
      while(var2.hasNext()) {
         var3 = var2.next();
         if(var3 != null) {
            var1.append(this.this$0.toString(var3));
            break;
         }
      }

      while(var2.hasNext()) {
         var3 = var2.next();
         if(var3 != null) {
            var1.append(Joiner.access$100(this.this$0));
            var1.append(this.this$0.toString(var3));
         }
      }

      return var1;
   }

   public Joiner useForNull(String var1) {
      throw new UnsupportedOperationException("already specified skipNulls");
   }

   public Joiner$MapJoiner withKeyValueSeparator(String var1) {
      throw new UnsupportedOperationException("can\'t use .skipNulls() with maps");
   }
}
