package y.f;

import y.f.U;
import y.f.X;
import y.f.aG;

public class S implements U {
   private y.d.n c;
   private aG d;

   public S(y.d.n var1) {
      this(var1, (byte)0);
   }

   public S(y.d.n var1, byte var2) {
      this(var1, aG.g(var2));
   }

   public S(y.d.n var1, aG var2) {
      this.a(var1);
      this.a(var2);
   }

   public void a(y.d.n var1) {
      this.c = var1;
   }

   public y.d.n a() {
      return this.c;
   }

   public double b() {
      return this.c.h().a();
   }

   public double c() {
      return this.c.h().b();
   }

   public void a(double var1, double var3) {
      y.d.t var5 = this.c.h().e();
      this.c.d(var1 - var5.a, var3 - var5.b);
   }

   public double d() {
      return this.c.h().c();
   }

   public double e() {
      return this.c.h().d();
   }

   public void a(aG var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("null");
      } else {
         this.d = var1;
      }
   }

   public aG f() {
      return this.d;
   }

   public String toString() {
      return this.a().toString() + " " + this.g();
   }

   private String g() {
      boolean var7 = X.j;
      byte var1 = this.d.a();
      if(var1 == 0) {
         return a(var1);
      } else {
         String var2 = "";
         StringBuffer var3 = new StringBuffer();
         byte[] var4 = new byte[]{(byte)1, (byte)2, (byte)4};
         int var5 = 0;
         int var6 = var4.length;

         while(var5 < var6) {
            if((var1 & var4[var5]) == var4[var5]) {
               var3.append(var2).append(a(var4[var5]));
               var2 = "|";
            }

            ++var5;
            if(var7) {
               break;
            }
         }

         return var3.toString();
      }
   }

   private static String a(byte var0) {
      switch(var0) {
      case 0:
         return "PLACE_ANYWHERE";
      case 1:
         return "PLACE_AT_SOURCE";
      case 2:
         return "PLACE_AT_TARGET";
      case 3:
      default:
         return "ILLEGAL_PLACEMENT: " + var0;
      case 4:
         return "PLACE_AT_CENTER";
      }
   }
}
