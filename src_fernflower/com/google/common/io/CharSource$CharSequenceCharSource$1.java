package com.google.common.io;

import com.google.common.io.CharSource$CharSequenceCharSource;
import com.google.common.io.CharSource$CharSequenceCharSource$1$1;
import java.util.Iterator;

class CharSource$CharSequenceCharSource$1 implements Iterable {
   // $FF: synthetic field
   final CharSource$CharSequenceCharSource this$0;

   CharSource$CharSequenceCharSource$1(CharSource$CharSequenceCharSource var1) {
      this.this$0 = var1;
   }

   public Iterator iterator() {
      return new CharSource$CharSequenceCharSource$1$1(this);
   }
}
