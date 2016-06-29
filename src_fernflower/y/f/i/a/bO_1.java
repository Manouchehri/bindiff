package y.f.i.a;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import y.f.i.a.M;
import y.f.i.a.ab;
import y.f.i.a.ai;
import y.f.i.a.bN;
import y.f.i.a.w;

class bO {
   y.c.D a;
   Set b;
   M c;
   double d;
   private final bN e;

   bO(bN var1, w var2) {
      this.e = var1;
      this.a = new y.c.D();
      this.b = new HashSet();
      this.a.add(var2);
      this.b.add(var2);
      this.c = var2.a(var1.b).c();
      var1.c.add(this.c);
   }

   bO(bN var1, bO var2, bO var3, M var4) {
      this.e = var1;
      this.a = new y.c.D(var2.a);
      this.b = new HashSet(var2.b);
      this.a(var3.a);
      this.c = var4;
      var1.c.add(this.c);
   }

   public void a(w var1) {
      if(this.b.add(var1)) {
         this.a.add(var1);
      }

   }

   public void a(y.c.D var1) {
      int var4 = ab.a;
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         w var3 = (w)var2.next();
         this.a(var3);
         if(var4 != 0) {
            break;
         }
      }

   }

   public void a(bO var1) {
      this.a.a(var1.a);
      this.b.addAll(var1.b);
   }

   public double a() {
      return this.d;
   }

   private void b() {
      int var14 = ab.a;
      double var1 = (double)this.a.size();
      double var3 = ((double)this.e.a.size() / var1 - 1.0D) * 5.0D;
      double var5 = bN.a(this.e).a().c().k() != null && !bN.a(this.e).a().c().k().a(this.c, this.e.d)?1.0D:0.0D;
      double var7 = 0.0D;
      Iterator var9 = this.a.iterator();

      while(true) {
         if(var9.hasNext()) {
            w var10 = (w)var9.next();
            ai var11 = var10.a(this.e.b);
            M var12 = var11.c();
            if(var12.d() == 0.0D) {
               continue;
            }

            byte var13 = var11.d();
            if(var14 != 0) {
               break;
            }

            if(var13 == -1) {
               var7 += this.c.b(var12.a()) / var12.d();
               if(var14 == 0) {
                  continue;
               }
            }

            if(var13 != 1) {
               continue;
            }

            var7 += this.c.b(var12.b()) / var12.d();
            if(var14 == 0) {
               continue;
            }
         }

         var7 /= (double)this.a.size();
         this.d = var3 + var5 + var7;
         break;
      }

   }

   public boolean b(y.c.D var1) {
      this.a.removeAll(var1);
      if(this.a.size() == 0) {
         return true;
      } else {
         this.b.removeAll(var1);
         this.b();
         return false;
      }
   }

   static void b(bO var0) {
      var0.b();
   }
}
