package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import java.util.ArrayList;
import java.util.List;

class ProtobufArrayList extends AbstractProtobufList {
   private static final ProtobufArrayList EMPTY_LIST = new ProtobufArrayList();
   private final List list;

   public static ProtobufArrayList emptyList() {
      return EMPTY_LIST;
   }

   ProtobufArrayList() {
      this.list = new ArrayList();
   }

   ProtobufArrayList(List var1) {
      this.list = new ArrayList(var1);
   }

   public void add(int var1, Object var2) {
      this.ensureIsMutable();
      this.list.add(var1, var2);
      ++this.modCount;
   }

   public Object get(int var1) {
      return this.list.get(var1);
   }

   public Object remove(int var1) {
      this.ensureIsMutable();
      Object var2 = this.list.remove(var1);
      ++this.modCount;
      return var2;
   }

   public Object set(int var1, Object var2) {
      this.ensureIsMutable();
      Object var3 = this.list.set(var1, var2);
      ++this.modCount;
      return var3;
   }

   public int size() {
      return this.list.size();
   }

   static {
      EMPTY_LIST.makeImmutable();
   }
}
