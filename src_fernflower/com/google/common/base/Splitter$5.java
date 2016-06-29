package com.google.common.base;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import java.util.Iterator;

class Splitter$5 implements Iterable {
   // $FF: synthetic field
   final CharSequence val$sequence;
   // $FF: synthetic field
   final Splitter this$0;

   Splitter$5(Splitter var1, CharSequence var2) {
      this.this$0 = var1;
      this.val$sequence = var2;
   }

   public Iterator iterator() {
      return Splitter.access$000(this.this$0, this.val$sequence);
   }

   public String toString() {
      return Joiner.on(", ").appendTo((StringBuilder)(new StringBuilder()).append('['), (Iterable)this).append(']').toString();
   }
}
