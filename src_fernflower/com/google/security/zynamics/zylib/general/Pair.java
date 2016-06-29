package com.google.security.zynamics.zylib.general;

public class Pair {
   private final Object first;
   private final Object second;

   public Pair(Object var1, Object var2) {
      this.first = var1;
      this.second = var2;
   }

   public static Pair make(Object var0, Object var1) {
      return new Pair(var0, var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof Pair)) {
         return false;
      } else {
         Pair var2 = (Pair)var1;
         return (var2.first != null && var2.first.equals(this.first) || var2.first == null && this.first == null) && (var2.second != null && var2.second.equals(this.second) || var2.second == null && this.second == null);
      }
   }

   public Object first() {
      return this.first;
   }

   public int hashCode() {
      return (this.first == null?1:this.first.hashCode()) * (this.second == null?1:this.second.hashCode());
   }

   public Object second() {
      return this.second;
   }

   public String toString() {
      String var1 = String.valueOf(this.first);
      String var2 = String.valueOf(this.second);
      return (new StringBuilder(5 + String.valueOf(var1).length() + String.valueOf(var2).length())).append("< ").append(var1).append(", ").append(var2).append(">").toString();
   }
}
