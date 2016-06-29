package com.google.security.zynamics.zylib.general;

public class Quad {
   private final Object m_first;
   private final Object m_second;
   private final Object m_third;
   private final Object m_fourth;

   public Quad(Object var1, Object var2, Object var3, Object var4) {
      this.m_first = var1;
      this.m_second = var2;
      this.m_third = var3;
      this.m_fourth = var4;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof Quad)) {
         return false;
      } else {
         Quad var2 = (Quad)var1;
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

         if(var2.fourth() != null || this.m_fourth != null) {
            if(var2.fourth() == null || this.m_fourth == null) {
               return false;
            }

            if(!var2.m_fourth.equals(this.m_fourth)) {
               return false;
            }
         }

         return true;
      }
   }

   public Object first() {
      return this.m_first;
   }

   public Object fourth() {
      return this.m_fourth;
   }

   public int hashCode() {
      return (this.m_first == null?1:this.m_first.hashCode()) * (this.m_second == null?1:this.m_second.hashCode()) * (this.m_third == null?1:this.m_third.hashCode()) * (this.m_fourth == null?1:this.m_fourth.hashCode());
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
      String var4 = String.valueOf(this.m_fourth);
      return (new StringBuilder(9 + String.valueOf(var1).length() + String.valueOf(var2).length() + String.valueOf(var3).length() + String.valueOf(var4).length())).append("< ").append(var1).append(", ").append(var2).append(", ").append(var3).append(", ").append(var4).append(">").toString();
   }
}
