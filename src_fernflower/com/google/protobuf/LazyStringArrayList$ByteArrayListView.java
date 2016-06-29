package com.google.protobuf;

import com.google.protobuf.LazyStringArrayList;
import java.util.AbstractList;
import java.util.RandomAccess;

class LazyStringArrayList$ByteArrayListView extends AbstractList implements RandomAccess {
   private final LazyStringArrayList list;

   LazyStringArrayList$ByteArrayListView(LazyStringArrayList var1) {
      this.list = var1;
   }

   public byte[] get(int var1) {
      return this.list.getByteArray(var1);
   }

   public int size() {
      return this.list.size();
   }

   public byte[] set(int var1, byte[] var2) {
      Object var3 = LazyStringArrayList.access$000(this.list, var1, var2);
      ++this.modCount;
      return LazyStringArrayList.access$100(var3);
   }

   public void add(int var1, byte[] var2) {
      LazyStringArrayList.access$200(this.list, var1, var2);
      ++this.modCount;
   }

   public byte[] remove(int var1) {
      String var2 = this.list.remove(var1);
      ++this.modCount;
      return LazyStringArrayList.access$100(var2);
   }
}
