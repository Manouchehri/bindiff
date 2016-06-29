package com.google.protobuf;

import com.google.protobuf.UnmodifiableLazyStringList;
import java.util.Iterator;

class UnmodifiableLazyStringList$2 implements Iterator {
   Iterator iter;
   // $FF: synthetic field
   final UnmodifiableLazyStringList this$0;

   UnmodifiableLazyStringList$2(UnmodifiableLazyStringList var1) {
      this.this$0 = var1;
      this.iter = UnmodifiableLazyStringList.access$000(this.this$0).iterator();
   }

   public boolean hasNext() {
      return this.iter.hasNext();
   }

   public String next() {
      return (String)this.iter.next();
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
