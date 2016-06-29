package y.f.c.a;

import y.f.c.a.N;
import y.f.c.a.Z;
import y.f.c.a.aY;
import y.f.c.a.bK;
import y.f.c.a.dk;
import y.f.c.a.dm;

class dj extends dm implements dk {
   y.c.D a;
   y.d.c[] b;
   final Z c;

   dj(aY var1, bK var2, Z var3) {
      super(var1, var2);
      if(var3 == null) {
         var3 = Z.a;
      }

      this.c = var3;
   }

   public Z c() {
      return this.c;
   }

   public byte b() {
      return (byte)0;
   }

   public y.c.p d() {
      return this.a != null?this.a.k():null;
   }

   public int e() {
      return this.a != null?this.a.size():0;
   }

   public y.d.c a(int var1, y.f.am var2) {
      boolean var3 = N.x;
      if(this.b == null) {
         this.b = new y.d.c[4];
      }

      if(this.b[var1] == null) {
         switch(var1) {
         case 0:
            this.b[var1] = new y.d.c(0.0D, var2.getWidth(), 0.0D);
            if(!var3) {
               break;
            }
         case 1:
            this.b[var1] = new y.d.c(0.0D, var2.getHeight(), var2.getWidth());
            if(!var3) {
               break;
            }
         case 2:
            this.b[var1] = new y.d.c(0.0D, var2.getWidth(), var2.getHeight());
            if(!var3) {
               break;
            }
         case 3:
            this.b[var1] = new y.d.c(0.0D, var2.getHeight(), 0.0D);
         }
      }

      return this.b[var1];
   }

   public y.d.c a(int var1) {
      return this.b == null?null:this.b[var1];
   }
}
