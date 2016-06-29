package y.d.a;

import java.util.Collection;
import java.util.Iterator;
import y.c.A;
import y.c.D;
import y.c.q;
import y.c.x;
import y.d.a.b;
import y.d.a.k;
import y.d.a.l;
import y.d.b.o;
import y.f.h.N;

public class a {
   private l a;
   private y.d.b.l b;

   public a() {
      this.a = null;
      this.b = new o();
   }

   public a(y.d.b.l var1) {
      this.a(var1);
   }

   public void a(y.d.b.l var1) {
      this.a = null;
      this.b = var1;
   }

   protected Object a(Object var1) {
      return this.a == null?var1:this.a.a(var1);
   }

   protected Object b(Object var1) {
      return this.a == null?var1:this.a.c(var1);
   }

   protected Collection a(Collection var1) {
      int var4 = b.b;
      if(this.a == null) {
         return var1;
      } else {
         D var2 = new D();
         Iterator var3 = var1.iterator();

         D var10000;
         while(true) {
            if(var3.hasNext()) {
               var10000 = var2;
               if(var4 != 0) {
                  break;
               }

               var2.add(this.a.b(var3.next()));
               if(var4 == 0) {
                  continue;
               }
            }

            var10000 = var2;
            break;
         }

         return var10000;
      }
   }

   public void a(Collection var1, N var2, A var3, y.c.h var4) {
      this.a(var1, var2, var3, var4, (k)null, false);
   }

   public void a(Collection var1, Object var2, A var3, y.c.h var4, k var5, boolean var6) {
      y.c.i var9;
      int var13;
      label46: {
         var13 = b.b;
         Collection var7 = this.a(var1);
         b var8 = new b();
         var8.a(var5);
         if(var2 instanceof y.c.i) {
            var9 = (y.c.i)var2;
            var8.a(this.b, var7, var9, var3, var4);
            if(!var6) {
               break label46;
            }

            var8.a(this.b, var7, var9, var3, var4, false);
            if(var13 == 0) {
               break label46;
            }
         }

         if(!(var2 instanceof N)) {
            throw new RuntimeException("wrong parameter: " + var2);
         }

         N var10 = (N)var2;
         var9 = var10.g();
         var8.a(this.b, var7, var10, var3, var4);
         if(var6) {
            var8.a(this.b, var7, var9, var3, var4, true);
            if(var13 != 0) {
               throw new RuntimeException("wrong parameter: " + var2);
            }
         }
      }

      x var14 = var9.o();

      Object var12;
      while(var14.f()) {
         q var11 = var14.e();
         var12 = var3.b(var11);
         var3.a(var11, this.a(var12));
         var14.g();
         if(var13 != 0) {
            break;
         }
      }

      y.c.e var15 = var9.p();

      while(var15.f()) {
         y.c.d var16 = var15.a();
         var12 = var4.b(var16);
         var4.a(var16, this.b(var12));
         var15.g();
         if(var13 != 0) {
            break;
         }
      }

   }
}
