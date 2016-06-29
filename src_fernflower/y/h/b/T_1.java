package y.h.b;

import java.util.Iterator;
import java.util.WeakHashMap;
import y.h.bu;
import y.h.cW;
import y.h.ce;
import y.h.cf;
import y.h.dw;
import y.h.fj;
import y.h.gg;
import y.h.b.U;
import y.h.b.V;
import y.h.b.W;
import y.h.b.a;
import y.h.b.ae;
import y.h.b.c;
import y.h.b.f;
import y.h.b.i;

public class T extends ae implements cf {
   private f a;
   private c b;
   private byte c = 1;
   private boolean d = true;
   private boolean e;
   private boolean f = true;
   private final WeakHashMap g = new WeakHashMap();

   public boolean a(double var1, double var3) {
      this.a = null;
      this.b = null;
      if(this.h != null && this.i != null) {
         cW var5 = new cW(this.h, var1, var3, true);
         y.c.q var6 = this.a((cW)var5);
         if(var6 != null) {
            bu var7 = this.h.getGraph2D();
            if(var7 != null && a(var7, var6) == this.i) {
               f var8 = this.i.l().a(var1, var3);
               if(var8 != null && this.a(var8, var1, var3)) {
                  this.a = var8;
                  return true;
               }

               c var9 = this.i.l().b(var1, var3);
               if(var9 != null && this.a(var9, var1, var3)) {
                  this.b = var9;
                  return true;
               }

               if(var8 == null && var9 == null) {
                  if(a(this.i.l())) {
                     return !this.i.isSelected();
                  }

                  return this.h();
               }
            }
         }
      }

      this.i();
      return false;
   }

   private static boolean a(i var0) {
      return var0.c().isEmpty() && var0.b().isEmpty();
   }

   protected boolean a(c var1, double var2, double var4) {
      return this.a(this.i, var1, var2, var4, this.k());
   }

   protected boolean a(f var1, double var2, double var4) {
      return this.a(this.i, var1, var2, var4, this.k());
   }

   protected boolean d(dw var1) {
      return (var1.d() & 64) != 0;
   }

   public void onGraph2DSelectionEvent(ce var1) {
      Object var2 = var1.d();
      if(var1.a() && this.l()) {
         fj var3 = a(var1.e(), (y.c.q)var2);
         if(var3 instanceof a && !var3.isSelected()) {
            this.a((a)var3);
         }
      }

   }

   public byte g() {
      return this.c;
   }

   public boolean h() {
      return this.d;
   }

   public boolean j() {
      return this.e;
   }

   public boolean k() {
      return this.f;
   }

   private void a(a var1) {
      int var4 = a.H;
      Iterator var2 = var1.l().c().iterator();

      while(true) {
         if(var2.hasNext()) {
            c var3 = (c)var2.next();
            this.a(var3, false);
            if(var4 != 0) {
               break;
            }

            if(var4 == 0) {
               continue;
            }
         }

         var2 = var1.l().b().iterator();
         break;
      }

      while(var2.hasNext()) {
         f var5 = (f)var2.next();
         this.a(var5, false);
         if(var4 != 0) {
            break;
         }
      }

   }

   public boolean a(dw var1) {
      return this.i(var1);
   }

   private boolean i(dw var1) {
      return this.g(var1) && this.a(var1.a(), var1.b());
   }

   public void b(dw var1) {
      int var3 = a.H;
      if(this.i(var1) && this.h != null) {
         bu var2 = this.h.getGraph2D();
         if(this.i != null) {
            label34: {
               if(this.l() && !this.g.containsKey(var2)) {
                  var2.a((cf)this);
                  this.g.put(var2, (Object)null);
               }

               if(this.a != null) {
                  this.a(var2, this.a, this.d(var1));
                  if(var3 == 0) {
                     break label34;
                  }
               }

               if(this.b != null) {
                  this.a(var2, this.b, this.d(var1));
                  if(var3 == 0) {
                     break label34;
                  }
               }

               this.a(var2, this.i.l(), this.d(var1));
            }
         }

         var2.T();
      }

      this.e();
   }

   protected void a(bu var1, c var2, boolean var3) {
      this.a(var1, (W)(new V(this, var2)), var3);
   }

   protected void a(bu var1, f var2, boolean var3) {
      this.a(var1, (W)(new U(this, var2)), var3);
   }

   private void a(bu var1, W var2, boolean var3) {
      a var4;
      label27: {
         var4 = var2.b();
         if(var3) {
            if(!this.j() && !var2.a(var4.l())) {
               break label27;
            }

            var2.a(!var2.a());
            if(a.H == 0) {
               break label27;
            }
         }

         this.a(var4);
         var1.N();
         var2.a(true);
      }

      if(this.l() && !var4.isSelected()) {
         this.a(var4, true);
      }

   }

   private boolean l() {
      return 2 == this.g();
   }

   protected void a(bu var1, i var2, boolean var3) {
      int var4 = a.H;
      if(a(var2)) {
         if(var3) {
            if(!this.a(var1)) {
               return;
            }

            this.a(var2.a(), true);
            if(var4 == 0) {
               return;
            }
         }

         var1.N();
         this.a(var2.a(), true);
         if(var4 == 0) {
            return;
         }
      }

      if(this.h()) {
         this.a(var2.a());
      }

   }

   private boolean a(bu var1) {
      return var1.H() || var1.J().f() || var1.M().f();
   }

   protected void a(a var1, boolean var2) {
      int var4 = a.H;
      if(var2) {
         y.c.q var3 = var1.getNode();
         if(var3 == null) {
            var1.setSelected(true);
            if(var4 == 0) {
               return;
            }
         }

         gg.a((bu)var3.e(), var3);
         if(var4 == 0) {
            return;
         }
      }

      var1.setSelected(false);
   }

   protected void a(c var1, boolean var2) {
      var1.a(var2);
   }

   protected void a(f var1, boolean var2) {
      var1.a(var2);
   }

   void i() {
      super.i();
      this.a = null;
      this.b = null;
   }
}
