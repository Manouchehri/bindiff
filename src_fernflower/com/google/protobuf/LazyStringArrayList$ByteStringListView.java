package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.LazyStringArrayList;
import java.util.AbstractList;
import java.util.RandomAccess;

class LazyStringArrayList$ByteStringListView extends AbstractList implements RandomAccess {
   private final LazyStringArrayList list;

   LazyStringArrayList$ByteStringListView(LazyStringArrayList var1) {
      this.list = var1;
   }

   public ByteString get(int var1) {
      return this.list.getByteString(var1);
   }

   public int size() {
      return this.list.size();
   }

   public ByteString set(int var1, ByteString var2) {
      Object var3 = LazyStringArrayList.access$300(this.list, var1, var2);
      ++this.modCount;
      return LazyStringArrayList.access$400(var3);
   }

   public void add(int var1, ByteString var2) {
      LazyStringArrayList.access$500(this.list, var1, var2);
      ++this.modCount;
   }

   public ByteString remove(int var1) {
      String var2 = this.list.remove(var1);
      ++this.modCount;
      return LazyStringArrayList.access$400(var2);
   }
}
