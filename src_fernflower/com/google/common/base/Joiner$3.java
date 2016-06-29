package com.google.common.base;

import java.util.AbstractList;

final class Joiner$3 extends AbstractList {
   // $FF: synthetic field
   final Object[] val$rest;
   // $FF: synthetic field
   final Object val$first;
   // $FF: synthetic field
   final Object val$second;

   Joiner$3(Object[] var1, Object var2, Object var3) {
      this.val$rest = var1;
      this.val$first = var2;
      this.val$second = var3;
   }

   public int size() {
      return this.val$rest.length + 2;
   }

   public Object get(int var1) {
      switch(var1) {
      case 0:
         return this.val$first;
      case 1:
         return this.val$second;
      default:
         return this.val$rest[var1 - 2];
      }
   }
}
