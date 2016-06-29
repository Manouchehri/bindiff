package com.google.protobuf;

import com.google.protobuf.UnmodifiableLazyStringList;
import java.util.ListIterator;

class UnmodifiableLazyStringList$1 implements ListIterator {
   ListIterator iter;
   // $FF: synthetic field
   final int val$index;
   // $FF: synthetic field
   final UnmodifiableLazyStringList this$0;

   UnmodifiableLazyStringList$1(UnmodifiableLazyStringList var1, int var2) {
      this.this$0 = var1;
      this.val$index = var2;
      this.iter = UnmodifiableLazyStringList.access$000(this.this$0).listIterator(this.val$index);
   }

   public boolean hasNext() {
      return this.iter.hasNext();
   }

   public String next() {
      return (String)this.iter.next();
   }

   public boolean hasPrevious() {
      return this.iter.hasPrevious();
   }

   public String previous() {
      return (String)this.iter.previous();
   }

   public int nextIndex() {
      return this.iter.nextIndex();
   }

   public int previousIndex() {
      return this.iter.previousIndex();
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }

   public void set(String var1) {
      throw new UnsupportedOperationException();
   }

   public void add(String var1) {
      throw new UnsupportedOperationException();
   }
}
