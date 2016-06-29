package com.google.protobuf;

import com.google.protobuf.SmallSortedMap;
import java.util.Map.Entry;

class SmallSortedMap$Entry implements Comparable, Entry {
   private final Comparable key;
   private Object value;
   // $FF: synthetic field
   final SmallSortedMap this$0;

   SmallSortedMap$Entry(SmallSortedMap var1, Entry var2) {
      this(var1, (Comparable)var2.getKey(), var2.getValue());
   }

   SmallSortedMap$Entry(SmallSortedMap var1, Comparable var2, Object var3) {
      this.this$0 = var1;
      this.key = var2;
      this.value = var3;
   }

   public Comparable getKey() {
      return this.key;
   }

   public Object getValue() {
      return this.value;
   }

   public int compareTo(SmallSortedMap$Entry var1) {
      return this.getKey().compareTo(var1.getKey());
   }

   public Object setValue(Object var1) {
      SmallSortedMap.access$200(this.this$0);
      Object var2 = this.value;
      this.value = var1;
      return var2;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         return this.equals(this.key, var2.getKey()) && this.equals(this.value, var2.getValue());
      }
   }

   public int hashCode() {
      return (this.key == null?0:this.key.hashCode()) ^ (this.value == null?0:this.value.hashCode());
   }

   public String toString() {
      String var1 = String.valueOf(String.valueOf(this.key));
      String var2 = String.valueOf(String.valueOf(this.value));
      return (new StringBuilder(1 + var1.length() + var2.length())).append(var1).append("=").append(var2).toString();
   }

   private boolean equals(Object var1, Object var2) {
      return var1 == null?var2 == null:var1.equals(var2);
   }
}
