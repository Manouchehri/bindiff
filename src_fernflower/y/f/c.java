package y.f;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y.f.O;
import y.f.X;
import y.f.aN;
import y.f.aQ;
import y.f.ad;
import y.f.ah;
import y.f.am;
import y.f.an;
import y.f.as;
import y.f.d;
import y.f.e;

public abstract class c implements ah {
   private ad n = new aN();
   private ad o = new as();
   private ad p = new e();
   private ad q = new aQ();
   private ad r = new an();
   private ad s = new y.f.d.f();
   private ad t = new y.f.b.b();
   boolean a_ = true;
   boolean b_ = true;
   boolean c_ = true;
   boolean d_ = false;
   boolean e = true;
   boolean f = false;
   boolean g = true;
   List h = new ArrayList(5);
   List i = new ArrayList(5);

   protected abstract void a(X var1);

   protected abstract boolean b(X var1);

   private void d(X var1) {
      this.a((y.c.n)var1, (O)var1);
   }

   private void a(y.c.n var1, O var2) {
      boolean var6 = X.j;
      y.c.c var3 = var1.c(y.f.b.f.d);
      if(var3 == null) {
         var3 = y.g.q.a((Object)Boolean.FALSE);
      }

      Iterator var4 = var1.x();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         if(!var3.d(var5)) {
            this.a(var2, var5);
            if(!var6) {
               continue;
            }
         }

         this.b(var2, var5);
         if(var6) {
            break;
         }
      }

   }

   protected void a(O var1, Object var2) {
      am var3 = var1.a(var2);
      if(var3.getWidth() == 0.0D || var3.getHeight() == 0.0D) {
         throw new IllegalArgumentException("Graph contains nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
      }
   }

   protected void b(O var1, Object var2) {
      am var3 = var1.a(var2);
      if(var3.getWidth() == 0.0D || var3.getHeight() == 0.0D) {
         throw new IllegalArgumentException("Graph contains group nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
      }
   }

   public void a(ad var1) {
      this.h.add(var1);
   }

   public void b(ad var1) {
      this.i.add(var1);
   }

   public ad b() {
      return this.s;
   }

   public void c(ad var1) {
      this.s = var1;
   }

   public ad c() {
      return this.n;
   }

   public ad d() {
      return this.o;
   }

   public ad e() {
      return this.p;
   }

   public void d(ad var1) {
      this.p = var1;
   }

   public ad f() {
      return this.t;
   }

   public ad g() {
      return this.r;
   }

   public void e(ad var1) {
      this.r = var1;
   }

   public void a(boolean var1) {
      this.e = var1;
   }

   public void a(byte var1) {
      if(this.r instanceof an) {
         ((an)this.r).a(var1);
      }

   }

   public byte h() {
      return this.r instanceof an?((an)this.r).b():0;
   }

   public boolean i() {
      return this.e;
   }

   public void b(boolean var1) {
      this.b_ = var1;
   }

   public boolean j() {
      return this.b_;
   }

   public void c(boolean var1) {
      this.f = var1;
   }

   public void d(boolean var1) {
      this.g = var1;
   }

   public void e(boolean var1) {
      this.c_ = var1;
   }

   public boolean k() {
      return this.c_;
   }

   public void f(boolean var1) {
      this.a_ = var1;
   }

   public boolean l() {
      return this.a_;
   }

   public void m() {
      this.d_ = false;
      this.a_ = false;
      this.f = false;
      this.b_ = false;
      this.c_ = false;
      this.e = false;
      this.g = false;
   }

   private ah a() {
      boolean var4 = X.j;
      Object var1 = new d(this);
      int var2 = this.i.size() - 1;

      ad var3;
      while(true) {
         if(var2 >= 0) {
            var3 = (ad)this.i.get(var2);
            var3.a((ah)var1);
            var1 = var3;
            --var2;
            if(var4) {
               break;
            }

            if(!var4) {
               continue;
            }
         }

         if(this.a_) {
            this.o.a((ah)var1);
            var1 = this.o;
         }
         break;
      }

      if(this.b_) {
         this.n.a((ah)var1);
         var1 = this.n;
      }

      if(this.e) {
         this.r.a((ah)var1);
         var1 = this.r;
      }

      if(this.f) {
         this.s.a((ah)var1);
         var1 = this.s;
      }

      if(this.c_) {
         this.p.a((ah)var1);
         var1 = this.p;
      }

      if(this.d_) {
         this.q.a((ah)var1);
         var1 = this.q;
      }

      if(this.g) {
         this.t.a((ah)var1);
         var1 = this.t;
      }

      var2 = 0;

      Object var10000;
      while(true) {
         if(var2 < this.h.size()) {
            var3 = (ad)this.h.get(var2);
            var3.a((ah)var1);
            var10000 = var3;
            if(var4) {
               break;
            }

            var1 = var3;
            ++var2;
            if(!var4) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return (ah)var10000;
   }

   public void c(X var1) {
      boolean var2 = false;
      if(var1.c("y.layout.CANONIC_MULTI_STAGE_LAYOUTER_NODE_SIZE_CHECKED_DPKEY") == null) {
         this.d(var1);
         var1.a((Object)"y.layout.CANONIC_MULTI_STAGE_LAYOUTER_NODE_SIZE_CHECKED_DPKEY", (y.c.c)y.g.q.a((Object)Boolean.TRUE));
         var2 = true;
      }

      ah var3 = this.a();
      var3.c(var1);
      if(var2) {
         var1.d_("y.layout.CANONIC_MULTI_STAGE_LAYOUTER_NODE_SIZE_CHECKED_DPKEY");
      }

   }

   static void a(c var0, X var1) {
      var0.d(var1);
   }
}
