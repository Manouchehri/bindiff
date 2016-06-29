package y.f;

import y.f.X;
import y.f.aF;

public class aE implements aF {
   private static final aE e = new aE((byte)0);
   private static final aE f = new aE((byte)1);
   private static final aE g = new aE((byte)2);
   private static final aE h = new aE((byte)4);
   private static final aE i = new aE((byte)8);
   private static final aE j = new aE((byte)0, true);
   private static final aE k = new aE((byte)4, true);
   private static final aE l = new aE((byte)8, true);
   private static final aE m = new aE((byte)1, true);
   private static final aE n = new aE((byte)2, true);
   private byte o;
   private boolean p;

   public aE() {
      this((byte)0);
   }

   public aE(byte var1) {
      this.o = var1;
   }

   public aE(byte var1, boolean var2) {
      this(var1);
      this.p = var2;
   }

   public boolean a() {
      return this.p;
   }

   public byte b() {
      return this.o;
   }

   public boolean c() {
      return this.o == 1;
   }

   public boolean d() {
      return this.o == 2;
   }

   public boolean e() {
      return this.o == 4;
   }

   public boolean f() {
      return this.o == 8;
   }

   public boolean g() {
      return this.o == 0;
   }

   public static boolean a(X var0, y.c.d var1) {
      return b(var0, var1) || c(var0, var1);
   }

   public static boolean b(X var0, y.c.d var1) {
      aE var2 = d(var0, var1);
      return var2 != null && (var2.o != 0 || var2.p);
   }

   public static boolean c(X var0, y.c.d var1) {
      aE var2 = e(var0, var1);
      return var2 != null && (var2.o != 0 || var2.p);
   }

   public static aE d(X var0, y.c.d var1) {
      y.c.c var2 = var0.c(aF.a);
      return var2 == null?null:(aE)var2.b(var1);
   }

   public static aE e(X var0, y.c.d var1) {
      y.c.c var2 = var0.c(aF.b);
      return var2 == null?null:(aE)var2.b(var1);
   }

   public static aE a(byte var0) {
      return a(var0, false);
   }

   public int hashCode() {
      return this.p?1024 + this.o:this.o;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof aE)) {
         return false;
      } else if(var1.getClass() != this.getClass()) {
         return false;
      } else {
         aE var2 = (aE)var1;
         return var2.p == this.p && var2.o == this.o;
      }
   }

   public static aE a(byte var0, boolean var1) {
      if(var1) {
         switch(var0) {
         case 0:
            return j;
         case 1:
            return m;
         case 2:
            return n;
         case 3:
         case 5:
         case 6:
         case 7:
         default:
            return null;
         case 4:
            return k;
         case 8:
            return l;
         }
      } else {
         switch(var0) {
         case 0:
            return e;
         case 1:
            return f;
         case 2:
            return g;
         case 3:
         case 5:
         case 6:
         case 7:
         default:
            return null;
         case 4:
            return h;
         case 8:
            return i;
         }
      }
   }

   public String toString() {
      if(this.o == 0) {
         return this.p?"ANY_SIDE [strong] [-]":"ANY_SIDE [-]";
      } else {
         String var1 = null;
         switch(this.o) {
         case 1:
            var1 = "NORTH";
            break;
         case 2:
            var1 = "SOUTH";
         case 3:
         case 5:
         case 6:
         case 7:
         default:
            break;
         case 4:
            var1 = "EAST";
            break;
         case 8:
            var1 = "WEST";
         }

         if(this.p) {
            var1 = var1 + " [strong] ";
         }

         return var1;
      }
   }
}
