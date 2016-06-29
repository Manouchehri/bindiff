package y.f.e.a;

import y.f.e.a.I;
import y.f.e.a.J;
import y.f.e.a.ac;
import y.f.e.a.ad;
import y.f.e.a.ae;
import y.f.e.a.af;
import y.f.e.a.ar;
import y.f.e.a.ax;
import y.f.e.a.ay;
import y.f.e.a.d;

public class h extends d {
   J a;
   J b;
   J c;
   J d;
   J e;

   public h() {
      boolean var1 = af.b;
      super();
      this.a = new J(this.b(), J.a, 0.0D, 50.0D);
      this.a.a(J.c);
      this.a.c(1.0D);
      this.b = new J(this.c(), J.a, 0.0D, 50.0D);
      this.b.a(J.c);
      this.b.c(1.0D);
      this.c = new J(this.a(), J.a, 0.0D, 200.0D);
      this.c.a(J.f);
      this.c.c(0.3D);
      this.e = new J(this.d(), J.a, 0.0D, 10000.0D);
      this.e.a(J.c);
      this.e.c(0.0D);
      this.d = new J(new ad(), J.a, 0.0D, 1.0D);
      this.d.a(J.m);
      this.d.c(0.01D);
      if(var1) {
         y.c.i.g = !y.c.i.g;
      }

   }

   I a() {
      return new I();
   }

   ax b() {
      return new ae();
   }

   ax c() {
      return new ar();
   }

   ax d() {
      return new ac();
   }

   public void a(ay var1) {
      super.a(var1);
      var1.a((ax)this.a);
      var1.a((ax)this.b);
      var1.a((ax)this.d);
      var1.a((ax)this.c);
      var1.a((ax)this.e);
   }

   public double e() {
      return this.b.a();
   }

   public void a(double var1) {
      this.b.c(var1);
   }

   public double f() {
      return this.c.a();
   }

   public void b(double var1) {
      this.e.c(var1);
   }

   public void c(double var1) {
      this.c.c(var1);
   }

   public void a(int var1) {
      ((ar)this.b.b()).a(var1);
   }

   public void b(int var1) {
      ((ae)this.a.b()).a(var1);
   }

   public void d(double var1) {
      boolean var3 = af.b;
      if(var1 == 0.0D) {
         this.b(0.0D);
         this.b(1);
         this.a(1);
         if(!var3) {
            return;
         }
      }

      if(var1 < 0.2D) {
         this.b(0.0D);
         this.b(2);
         this.a(1);
         if(!var3) {
            return;
         }
      }

      if(var1 < 0.4D) {
         this.b(0.0D);
         this.b(2);
         this.a(2);
         if(!var3) {
            return;
         }
      }

      if(var1 < 0.5D) {
         this.b(0.0D);
         this.b(2);
         this.a(2);
         if(!var3) {
            return;
         }
      }

      if(var1 < 0.6D) {
         this.b(0.0D);
         this.b(3);
         this.a(2);
         if(!var3) {
            return;
         }
      }

      if(var1 < 0.7D) {
         this.b(0.0D);
         this.b(3);
         this.a(3);
         if(!var3) {
            return;
         }
      }

      if(var1 < 0.8D) {
         this.b(0.1D);
         this.b(3);
         this.a(3);
         if(!var3) {
            return;
         }
      }

      if(var1 < 0.9D) {
         this.b(0.3D);
         this.b(3);
         this.a(3);
         if(!var3) {
            return;
         }
      }

      if(var1 < 1.0D) {
         this.b(0.6D);
         this.b(3);
         this.a(3);
         if(!var3) {
            return;
         }
      }

      this.b(2.0D);
      this.b(3);
      this.a(3);
   }
}
