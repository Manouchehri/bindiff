package y.h.a;

import java.awt.Color;
import java.util.Iterator;
import y.h.N;
import y.h.bU;
import y.h.bu;
import y.h.cf;
import y.h.fj;
import y.h.a.L;
import y.h.a.p;
import y.h.a.v;

public class c extends N {
   private fj a;
   private fj b;
   private boolean c;

   public c() {
      this.a();
   }

   public y.c.i a(Object var1) {
      bu var2 = (bu)super.a(var1);
      this.a(var2, var1);
      return var2;
   }

   protected void a(bu var1, Object var2) {
      int var5 = v.a;
      Iterator var4;
      if(var2 instanceof y.c.i) {
         y.c.i var3 = (y.c.i)var2;
         var4 = var3.q();

         while(var4.hasNext()) {
            var1.a((y.c.o)((y.c.o)var4.next()));
            if(var5 != 0) {
               return;
            }

            if(var5 != 0) {
               break;
            }
         }
      }

      if(var2 instanceof bu) {
         bu var6 = (bu)var2;
         var4 = var6.X();

         label29: {
            while(var4.hasNext()) {
               var1.a((bU)var4.next());
               if(var5 != 0) {
                  break label29;
               }

               if(var5 != 0) {
                  break;
               }
            }

            var4 = var6.W();
         }

         label39: {
            while(var4.hasNext()) {
               var1.a((cf)var4.next());
               if(var5 != 0) {
                  break label39;
               }

               if(var5 != 0) {
                  break;
               }
            }

            var1.b(var6.F());
         }

         var1.a(var6.G());
      }

   }

   public y.c.q a(y.c.i var1, Object var2) {
      fj var3 = this.b(var2);
      return ((bu)var1).a(var3);
   }

   public fj b(Object var1) {
      Object var2 = null;
      L var3 = new L();
      fj var4 = this.b().createCopy();
      var3.a(var4);
      fj var5 = this.c().createCopy();
      var3.a(var5);
      var3.b(var1 instanceof y.c.i?var5:var4);
      if(this.c) {
         var2 = var3;
      } else {
         var2 = var3.e();
      }

      return (fj)var2;
   }

   void a() {
      p var1 = new p();
      var1.setSize(100.0D, 60.0D);
      var1.setFillColor(new Color(248, 236, 201));
      var1.setShapeType((byte)6);
      var1.setGroupClosed(false);
      this.a = var1;
      p var2 = new p();
      var2.setSize(100.0D, 60.0D);
      var2.setFillColor(new Color(248, 236, 201));
      var2.setShapeType((byte)6);
      var2.setGroupClosed(true);
      this.b = var2;
   }

   public fj b() {
      return this.a;
   }

   public fj c() {
      return this.b;
   }
}
