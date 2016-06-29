package com.google.security.zynamics.zylib.general;

public class Triple {
   private final Object m_first;
   private final Object m_second;
   private final Object m_third;

   public Triple(Object var1, Object var2, Object var3) {
      this.m_first = var1;
      this.m_second = var2;
      this.m_third = var3;
   }

   public static Triple make(Object var0, Object var1, Object var2) {
      return new Triple(var0, var1, var2);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof Triple)) {
         return false;
      } else {
         Triple var2 = (Triple)var1;
         if(var2.first() != null || this.m_first != null) {
            if(var2.first() == null || this.m_first == null) {
               return false;
            }

            if(!var2.m_first.equals(this.m_first)) {
               return false;
            }
         }

         if(var2.second() != null || this.m_second != null) {
            if(var2.second() == null || this.m_second == null) {
               return false;
            }

            if(!var2.m_second.equals(this.m_second)) {
               return false;
            }
         }

         if(var2.third() != null || this.m_third != null) {
            if(var2.third() == null || this.m_third == null) {
               return false;
            }

            if(!var2.m_third.equals(this.m_third)) {
               return false;
            }
         }

         return true;
      }
   }

   public Object first() {
      return this.m_first;
   }

   public int hashCode() {
      return (this.m_first == null?1:this.m_first.hashCode()) * (this.m_second == null?1:this.m_second.hashCode()) * (this.m_third == null?1:this.m_third.hashCode());
   }

   public Object second() {
      return this.m_second;
   }

   public Object third() {
      return this.m_third;
   }

   public String toString() {
      String var1 = String.valueOf(this.m_first);
      String var2 = String.valueOf(this.m_second);
      String var3 = String.valueOf(this.m_third);
      return (new StringBuilder(7 + String.valueOf(var1).length() + String.valueOf(var2).length() + String.valueOf(var3).length())).append("< ").append(var1).append(", ").append(var2).append(", ").append(var3).append(">").toString();
   }
}
