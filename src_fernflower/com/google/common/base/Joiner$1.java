package com.google.common.base;

import com.google.common.base.Joiner;
import javax.annotation.Nullable;

class Joiner$1 extends Joiner {
   // $FF: synthetic field
   final String val$nullText;
   // $FF: synthetic field
   final Joiner this$0;

   Joiner$1(Joiner var1, Joiner var2, String var3) {
      super(var2, (Joiner$1)null);
      this.this$0 = var1;
      this.val$nullText = var3;
   }

   CharSequence toString(@Nullable Object var1) {
      return (CharSequence)(var1 == null?this.val$nullText:this.this$0.toString(var1));
   }

   public Joiner useForNull(String var1) {
      throw new UnsupportedOperationException("already specified useForNull");
   }

   public Joiner skipNulls() {
      throw new UnsupportedOperationException("already specified useForNull");
   }
}
