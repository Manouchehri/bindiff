package y.f.e.a;

import java.util.ArrayList;
import java.util.List;
import y.f.e.a.Z;
import y.f.e.a.a;
import y.f.e.a.ag;
import y.f.e.a.ah;
import y.f.e.a.ao;
import y.f.e.a.ap;
import y.f.e.a.aq;
import y.f.e.a.c;
import y.f.e.a.k;
import y.f.e.a.m;
import y.f.e.a.w;

public class af implements w {
   protected int a;
   private int c;
   private int d;
   private a e = new Z();
   private a f = new Z();
   private a g = new Z();
   private double h;
   private double i;
   private double j;
   private y.f.X k;
   private y.c.A l;
   private y.c.h m;
   private List n = new ArrayList();
   public static boolean b;

   public af(y.f.X var1) {
      this.k = var1;
      this.l = var1.t();
      this.m = var1.u();
      this.m();
   }

   void a(m var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      boolean var17 = b;
      if(!this.n.isEmpty()) {
         ap var14 = new ap(this, var1, var2, var4, var6, var8, var10, var12);
         ao[] var15 = new ao[this.n.size()];
         this.n.toArray(var15);
         int var16 = 0;

         while(var16 < var15.length) {
            var15[var16].a(var14);
            ++var16;
            if(var17) {
               break;
            }
         }

      }
   }

   private void b(y.f.X var1) {
      boolean var4 = b;
      y.c.x var2 = var1.o();

      while(true) {
         if(var2.f()) {
            y.c.q var3 = var2.e();
            this.l.a(var3, this.b(var3));
            var2.g();
            if(var4) {
               break;
            }

            if(!var4) {
               continue;
            }
         }

         this.h = (double)this.c * 0.9D;
         this.i = 0.81D * (double)this.c;
         this.l();
         break;
      }

   }

   private void c(y.f.X var1) {
      boolean var4 = b;
      y.c.e var2 = var1.p();

      while(var2.f()) {
         y.c.d var3 = var2.a();
         this.m.a(var3, this.c(var3));
         var2.g();
         if(var4) {
            break;
         }
      }

   }

   private ah c(y.c.d var1) {
      return new ah(this, var1);
   }

   protected ag b(y.c.q var1) {
      return new ag(this, var1);
   }

   public int g() {
      return this.a;
   }

   public double d() {
      return c.a(this.k.e(), this.h, this.i);
   }

   public double a() {
      return c.a(this.k.e(), this.f.d(), this.g.d());
   }

   public double b() {
      return c.a(this.k.e(), this.f.e(), this.g.e());
   }

   private void l() {
      this.j = this.c > 0?this.h / (double)this.c:0.0D;
   }

   public k e() {
      this.e.a(this.h());
      this.e.b(this.i());
      this.e.c(this.j());
      return this.e;
   }

   public double h() {
      return this.c > 0?this.f.d() / (double)this.c:0.0D;
   }

   public double i() {
      return this.c > 0?this.f.e() / (double)this.c:0.0D;
   }

   public double j() {
      return this.c > 0?this.f.f() / (double)this.c:0.0D;
   }

   public m a(y.c.q var1) {
      return (m)this.l.b(var1);
   }

   public ag c(y.c.q var1) {
      return (ag)this.l.b(var1);
   }

   private void m() {
      this.d = this.k.h();
      this.c = this.k.f();
      this.b(this.k);
      this.c(this.k);
   }

   public void k() {
      boolean var5 = b;
      y.c.x var1 = this.k.o();

      while(var1.f()) {
         y.c.q var2 = var1.e();
         ag var3 = this.c(var2);
         y.f.am var4 = this.k.h(var2);
         var4.setLocation(var3.b() - var4.getWidth() / 2.0D, var3.c() - var4.getHeight() / 2.0D);
         var1.g();
         if(var5) {
            break;
         }
      }

   }

   public y.f.X f() {
      return this.k;
   }

   public double c() {
      return this.j;
   }

   public aq a(y.c.d var1) {
      return (aq)this.m.b(var1);
   }

   public ah b(y.c.d var1) {
      return (ah)this.m.b(var1);
   }

   public void a(y.f.X var1) {
      if(var1 != this.k) {
         throw new IllegalStateException();
      } else {
         var1.a((y.c.A)this.l);
         this.l = null;
         var1.a((y.c.h)this.m);
         this.m = null;
         this.k = null;
      }
   }

   static y.f.X a(af var0) {
      return var0.k;
   }

   static a b(af var0) {
      return var0.f;
   }

   static a c(af var0) {
      return var0.g;
   }

   static double a(af var0, double var1) {
      return var0.h += var1;
   }

   static double b(af var0, double var1) {
      return var0.i += var1;
   }

   static void d(af var0) {
      var0.l();
   }
}
