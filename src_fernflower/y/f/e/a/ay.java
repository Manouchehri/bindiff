package y.f.e.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y.f.e.a.G;
import y.f.e.a.af;
import y.f.e.a.ak;
import y.f.e.a.am;
import y.f.e.a.au;
import y.f.e.a.aw;
import y.f.e.a.ax;
import y.f.e.a.b;
import y.f.e.a.e;
import y.f.e.a.g;
import y.f.e.a.h;
import y.f.e.a.l;
import y.f.e.a.o;
import y.f.e.a.p;
import y.f.e.a.r;
import y.f.e.a.s;

public class ay extends y.f.c {
   public static final Object n;
   private List p;
   private List q;
   private s r;
   private G s;
   private aw t;
   private r u;
   private List v;
   private List w;
   private List x;
   private boolean y;
   protected l o;
   private af z;
   private double A;
   private double B;
   private boolean C;
   private List D;
   private boolean E;

   public ay() {
      this(true);
   }

   public void g(boolean var1) {
      this.E = var1;
   }

   public ay(boolean var1) {
      boolean var2 = af.b;
      super();
      this.p = new ArrayList();
      this.q = new ArrayList();
      this.r = new ak();
      this.s = new b();
      this.t = new o();
      this.u = new g(false);
      this.v = new ArrayList();
      this.w = new ArrayList();
      this.x = new ArrayList();
      this.y = true;
      this.A = 50.0D;
      this.B = 50.0D;
      this.D = new ArrayList();
      this.E = true;
      this.e(false);
      this.d(true);
      if(var1) {
         this.a();
      }

      this.e((am)(new au(this)));
      this.n();
      if(y.c.i.g) {
         af.b = !var2;
      }

   }

   protected void a() {
      this.a((p)(new h()));
   }

   protected void n() {
      this.a((p)(new e()));
   }

   public void a(p var1) {
      var1.a(this);
      this.D.add(var1);
   }

   public List o() {
      return Collections.unmodifiableList(this.D);
   }

   public boolean b(y.f.X var1) {
      return var1.e() != 0;
   }

   public void a(y.f.X var1) {
      this.d(var1);

      try {
         this.a(0);
      } finally {
         this.e(var1);
      }

   }

   protected void d(y.f.X var1) {
      this.g(var1);
      this.z = this.h(var1);
      this.o = this.v();
      this.u();
      this.r();
      this.C();
   }

   protected int a(int var1) {
      boolean var2 = af.b;
      this.C = true;

      while(!this.q()) {
         y.a.a.a();
         this.b(var1);
         this.u.a(this.o);
         this.A();
         this.p();
         ++var1;
         if(var2) {
            break;
         }
      }

      return var1;
   }

   protected void e(y.f.X var1) {
      this.B();
      this.t();
      this.f(var1);
      this.C = false;
   }

   protected void f(y.f.X var1) {
      this.z.a(var1);
      this.z = null;
   }

   protected void b(int var1) {
      this.o.a(var1);
      this.o.a(this.t.a(this.o));
   }

   protected void p() {
   }

   private void A() {
      boolean var3 = af.b;
      int var1 = 0;

      while(var1 < this.x.size()) {
         am var2 = (am)this.x.get(var1);
         var2.a(this.o, this.z);
         ++var1;
         if(var3) {
            break;
         }
      }

   }

   private void B() {
      boolean var3 = af.b;
      int var1 = 0;

      while(var1 < this.w.size()) {
         am var2 = (am)this.w.get(var1);
         var2.a(this.o, this.z);
         ++var1;
         if(var3) {
            break;
         }
      }

   }

   private void C() {
      boolean var3 = af.b;
      int var1 = 0;

      while(var1 < this.v.size()) {
         am var2 = (am)this.v.get(var1);
         var2.a(this.o, this.z);
         ++var1;
         if(var3) {
            break;
         }
      }

   }

   protected boolean q() {
      return this.t.b(this.o);
   }

   protected void r() {
      this.u.a(this.q);
      this.u.a(this.r);
      this.u.a(this.s);
      this.u.a();
   }

   protected void g(y.f.X var1) {
      if(this.E) {
         y.f.ae.a(var1);
      }

   }

   public l s() {
      return this.o;
   }

   protected void t() {
      this.z.k();
   }

   public af h(y.f.X var1) {
      return new af(var1);
   }

   protected void u() {
      boolean var3 = af.b;
      int var1 = 0;

      while(var1 < this.p.size()) {
         am var2 = (am)this.p.get(var1);
         var2.a(this.o, this.z);
         ++var1;
         if(var3) {
            break;
         }
      }

   }

   protected l v() {
      return new l(this.z, this, this.y);
   }

   public double w() {
      return this.A;
   }

   public void a(double var1) {
      this.A = var1;
   }

   public double x() {
      return this.B;
   }

   public void b(double var1) {
      this.B = var1;
   }

   public void h(boolean var1) {
      this.y = var1;
   }

   public void a(ax var1) {
      this.q.add(var1);
   }

   public List y() {
      return Collections.unmodifiableList(this.q);
   }

   public void b(ax var1) {
      int var2 = this.q.indexOf(var1);
      if(var2 >= 0) {
         this.q.remove(var2);
      }
   }

   public void a(am var1) {
      this.v.add(var1);
   }

   public void b(am var1) {
      this.w.add(var1);
   }

   public void c(am var1) {
      this.x.add(var1);
   }

   public void d(am var1) {
      int var2 = this.x.indexOf(var1);
      if(var2 >= 0) {
         this.x.remove(var2);
      }
   }

   public aw z() {
      return this.t;
   }

   public void a(aw var1) {
      this.t = var1;
   }

   public void e(am var1) {
      this.p.add(var1);
   }

   static {
      n = y.f.e.d.p;
   }
}
