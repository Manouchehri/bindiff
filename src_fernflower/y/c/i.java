package y.c;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.I;
import y.c.K;
import y.c.L;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.h;
import y.c.j;
import y.c.l;
import y.c.n;
import y.c.o;
import y.c.q;
import y.c.x;
import y.c.y;

public class i implements n {
   L c;
   L d;
   boolean e;
   boolean f;
   private K a;
   private K b;
   private HashMap h;
   private y.g.C i;
   private static final y.g.C j = new j();
   private ArrayList k;
   public static boolean g;

   public y.g.C a_() {
      if(this.i == null) {
         this.i = this.b();
      }

      return this.i;
   }

   protected y.g.C b() {
      return j;
   }

   protected final boolean c() {
      return this.k != null && !this.k.isEmpty();
   }

   public i() {
      this.c = new L();
      this.d = new L();
      this.a = new K(3, 5);
      this.b = new K(3, 5);
      this.e = false;
      this.f = false;
      this.h = new HashMap(11);
   }

   public i(i var1, C var2) {
      boolean var9 = D.e;
      this();
      this.a = var1.a.c();
      this.b = var1.b.c();
      A var3 = var1.t();

      i var10000;
      while(true) {
         if(var2.f()) {
            q var4 = (q)var2.d();
            q var5 = var4.a(this);
            var3.a(var4, var5);
            var10000 = this;
            if(var9) {
               break;
            }

            this.a.a(var4, var5);
            var2.g();
            if(!var9) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      e var10 = var10000.p();

      while(true) {
         if(var10.f()) {
            d var11 = var10.a();
            q var7 = (q)var3.b(var11.c());
            q var8 = (q)var3.b(var11.d());
            if(var9) {
               break;
            }

            if(var7 != null && var8 != null) {
               d var6 = var11.a(this, var7, var8);
               this.b.a(var11, var6);
            }

            var10.g();
            if(!var9) {
               continue;
            }
         }

         if(var1.k != null) {
            this.k = (ArrayList)var1.k.clone();
         }

         var1.h = (HashMap)var1.h.clone();
         var1.a(var3);
         break;
      }

   }

   public q d() {
      q var1 = new q(this);
      if(this.k != null) {
         this.a(l.a(this, var1));
      }

      return var1;
   }

   public d a(q var1, q var2) {
      return this.a(var1, (d)null, var2, (d)null, 0, 0);
   }

   public d a(q var1, d var2, q var3, d var4, int var5, int var6) {
      d var7 = new d(this, var1, var2, var3, var4, var5, var6);
      if(this.k != null) {
         this.a(l.a(this, var7));
      }

      return var7;
   }

   public void a(q var1) {
      this.h(var1);
   }

   private void h(q var1) {
      boolean var3 = D.e;
      if(var1.e() != this) {
         throw new IllegalArgumentException("Node not in this graph.");
      } else {
         if(this.k != null) {
            this.r();
            this.a(l.b(this, var1));
         }

         label37:
         while(true) {
            d var2 = var1.c;
            if(var1.c != null) {
               this.a(var2);
               if(var3) {
                  break;
               }

               if(!var3) {
                  continue;
               }
            }

            do {
               var2 = var1.b;
               if(var1.b == null) {
                  break;
               }

               this.a(var2);
               if(var3) {
                  break label37;
               }
            } while(!var3);

            this.c.c((I)var1);
            var1.a = null;
            this.e = true;
            break;
         }

         if(this.k != null) {
            this.a(l.c(this, var1));
            this.s();
         }

      }
   }

   public void a(d var1) {
      this.g(var1);
   }

   private void g(d var1) {
      if(var1.a() != this) {
         throw new IllegalArgumentException("edge is not in graph");
      } else {
         if(this.k != null) {
            this.a(l.b(this, var1));
         }

         q var2 = var1.c();
         q var3 = var1.d();
         this.b(var1, var2, var3);
         this.d.c((I)var1);
         var1.a((i)null);
         this.f = true;
         if(this.k != null) {
            this.a(l.c(this, var1));
         }

      }
   }

   public void b(q var1) {
      if(var1.e() != null) {
         throw new IllegalArgumentException("Node " + var1 + " already in a graph!!!");
      } else {
         var1.h = this.c.a();
         var1.b(this);
         var1.p();
         if(var1.k.length < this.a.a) {
            this.a.a((I)var1, var1.k.length, this.a.a);
         }

         this.c.b((I)var1);
         this.e = true;
         if(this.k != null) {
            this.a(l.d(this, var1));
         }

      }
   }

   public void b(d var1) {
      boolean var2 = D.e;
      if(var1.a() != null) {
         throw new IllegalArgumentException("Edge " + var1 + " already in a graph!!!");
      } else if(var1.c().e() != this) {
         throw new IllegalArgumentException("Source of edge " + var1 + " not in graph");
      } else if(var1.d().e() != this) {
         throw new IllegalArgumentException("Target of edge " + var1 + " not in graph");
      } else {
         if(var1.k.length < this.b.a) {
            this.b.a((I)var1, var1.k.length, this.b.a);
         }

         label52: {
            if(var1.q() == null || ((d)var1.q()).a() != this) {
               this.d.b((I)var1);
               if(!var2) {
                  break label52;
               }

               g = !g;
            }

            this.d.a(var1, var1.q(), 1);
         }

         var1.a(this);
         var1.f();
         this.b(var1, var1.c(), (d)null, var1.d(), (d)null, 0, 0);
         this.f = true;
         if(this.k != null) {
            this.a(l.d(this, var1));
         }

      }
   }

   public void a(d var1, d var2, d var3, int var4, int var5) {
      this.a(var1, var1.c(), var2, var4, var1.d(), var3, var5);
   }

   public void a(d var1, q var2, d var3, int var4, q var5, d var6, int var7) {
      boolean var10 = D.e;
      if(this.k != null) {
         this.a(new l(this, (byte)8, var1));
      }

      q var8 = var1.c();
      q var9 = var1.d();
      if(var1 == var3) {
         var3 = var4 == 0?var3.i():var3.g();
      }

      if(var1 == var6) {
         var6 = var7 == 0?var6.j():var6.h();
      }

      label41: {
         this.b(var1, var8, var9);
         if(var3 == null) {
            var1.e = var2;
            if(!var10) {
               break label41;
            }
         }

         var1.e = var3.c();
      }

      label36: {
         if(var6 == null) {
            var1.f = var5;
            if(!var10) {
               break label36;
            }
         }

         var1.f = var6.d();
      }

      this.b(var1, var1.e, var3, var1.f, var6, var4, var7);
      if(this.k != null) {
         this.a(new l(this, (byte)9, var1));
      }

   }

   public void a(d var1, q var2, q var3) {
      if(this.k != null) {
         this.a(new l(this, (byte)8, var1));
      }

      label28: {
         q var4 = var1.c();
         q var5 = var1.d();
         if(var1.a() == null) {
            var1.e = var2;
            var1.f = var3;
            if(!D.e) {
               break label28;
            }
         }

         if(var4 != var2) {
            var4.f(var1);
            var1.e = var2;
            var2.b(var1);
         }

         if(var5 != var3) {
            var5.g(var1);
            var1.f = var3;
            var3.d(var1);
         }
      }

      if(this.k != null) {
         this.a(new l(this, (byte)9, var1));
      }

   }

   public void c(d var1) {
      this.a(var1, var1.d(), var1.c());
   }

   public void d(d var1) {
      ArrayList var2 = this.k;
      this.k = null;
      this.g(var1);
      this.k = var2;
   }

   public void e(d var1) {
      ArrayList var2 = this.k;
      this.k = null;
      this.b(var1);
      this.k = var2;
   }

   public void c(q var1) {
      ArrayList var2 = this.k;
      this.k = null;
      this.a(var1);
      this.k = var2;
   }

   public void d(q var1) {
      ArrayList var2 = this.k;
      this.k = null;
      this.b(var1);
      this.k = var2;
   }

   public void e(q var1) {
      if(var1.e() != this) {
         throw new IllegalArgumentException("Node not in this graph.");
      } else {
         this.c.c((I)var1);
         this.c.a(var1, this.c.d(), 1);
         this.e = true;
      }
   }

   public int e() {
      return this.c.a();
   }

   public int f() {
      return this.c.a();
   }

   public int g() {
      return this.d.a();
   }

   public int h() {
      return this.d.a();
   }

   public boolean i() {
      return this.c.b();
   }

   public void j() {
      boolean var1 = D.e;
      this.r();

      while(true) {
         if(!this.c.b()) {
            this.a((q)this.c.c());
            if(var1) {
               break;
            }

            if(!var1) {
               continue;
            }
         }

         this.s();
         break;
      }

   }

   public boolean f(q var1) {
      return var1.e() == this;
   }

   public boolean f(d var1) {
      return var1.a() == this;
   }

   public boolean b(q var1, q var2) {
      if(var1.e() != this) {
         throw new IllegalArgumentException("source not in this graph.");
      } else {
         return var1.a(var2) != null;
      }
   }

   public q k() {
      return (q)this.c.c();
   }

   public d l() {
      return (d)this.d.c();
   }

   public q[] m() {
      boolean var3 = D.e;
      q[] var1 = new q[this.f()];
      q var2 = (q)this.c.c();

      q[] var10000;
      while(true) {
         if(var2 != null) {
            var10000 = var1;
            if(var3) {
               break;
            }

            var1[var2.d()] = var2;
            var2 = (q)var2.i;
            if(!var3) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   public d[] n() {
      boolean var3 = D.e;
      d[] var1 = new d[this.h()];
      d var2 = (d)this.d.c();

      d[] var10000;
      while(true) {
         if(var2 != null) {
            var10000 = var1;
            if(var3) {
               break;
            }

            var1[var2.b()] = var2;
            var2 = (d)var2.i;
            if(!var3) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   public x o() {
      return this.c.f();
   }

   public e p() {
      return this.d.f();
   }

   public f a(y var1, i var2) {
      boolean var9 = D.e;
      x var3 = var1.a();
      f var4 = new f();
      byte[] var5 = new byte[this.e()];

      q var6;
      while(true) {
         if(var3.f()) {
            var6 = var3.e();
            var5[var6.d()] = 1;
            var3.g();
            if(var9) {
               break;
            }

            if(!var9) {
               continue;
            }
         }

         var3.i();
         break;
      }

      e var7;
      label80:
      do {
         byte var10000 = var3.f();

         label77:
         while(true) {
            if(var10000 == 0) {
               break label80;
            }

            var6 = var3.e();
            var7 = var6.j();

            while(true) {
               if(!var7.f()) {
                  break label77;
               }

               var10000 = var5[var7.a().a(var6).d()];
               if(var9) {
                  break;
               }

               if(var10000 == 0) {
                  var4.a(var7.a());
                  this.a(var7.a());
               }

               var7.g();
               if(var9) {
                  break label77;
               }
            }
         }

         var3.g();
      } while(!var9);

      Object var10 = null;
      var3.i();

      while(true) {
         if(var3.f()) {
            var6 = var3.e();
            if(var9) {
               break;
            }

            var7 = var6.l();

            int var11;
            int var10001;
            label56: {
               while(var7.f()) {
                  d var8 = var7.a();
                  this.d.c((I)var8);
                  var8.a(var2);
                  var11 = var8.k.length;
                  var10001 = var2.b.a;
                  if(var9) {
                     break label56;
                  }

                  if(var11 < var10001) {
                     var2.b.a((I)var8, var8.k.length, var2.b.a);
                  }

                  var2.d.b((I)var7.a());
                  var7.g();
                  if(var9) {
                     break;
                  }
               }

               this.c.c((I)var6);
               var6.b(var2);
               var11 = var6.k.length;
               var10001 = var2.a.a;
            }

            if(var11 < var10001) {
               var2.a.a((I)var6, var6.k.length, var2.a.a);
            }

            var2.c.b((I)var6);
            var3.g();
            if(!var9) {
               continue;
            }
         }

         if(this.k != null) {
            this.a(new l(this, (byte)11, var1));
         }
         break;
      }

      if(var2.k != null) {
         var2.a(new l(var2, (byte)10, var1));
      }

      this.f = true;
      this.e = true;
      var2.e = true;
      var2.f = true;
      return var4;
   }

   public void a(Comparator var1) {
      boolean var5 = D.e;
      if(var1 != null && !this.d.b()) {
         d[] var2 = this.n();
         y.g.e.a((Object[])var2, var1);
         this.d.e();
         int var3 = 0;

         while(var3 < var2.length) {
            d var4 = var2[var3];
            this.d.b((I)var4);
            var4.g = var3++;
            if(var5) {
               return;
            }

            if(var5) {
               break;
            }
         }

         this.f = false;
      }

   }

   public void b(Comparator var1) {
      boolean var5 = D.e;
      if(var1 != null && !this.c.b()) {
         q[] var2 = this.m();
         y.g.e.a((Object[])var2, var1);
         this.c.e();
         int var3 = 0;

         while(var3 < var2.length) {
            q var4 = var2[var3];
            this.c.b((I)var4);
            var4.h = var3++;
            if(var5) {
               return;
            }

            if(var5) {
               break;
            }
         }

         this.e = false;
      }

   }

   public void a(Comparator var1, Comparator var2) {
      boolean var5 = D.e;
      if(var1 != null || var2 != null) {
         d[] var3 = new d[this.g()];
         q var4;
         if(var1 != null && var2 != null) {
            var4 = (q)this.c.c();

            do {
               if(var4 == null) {
                  return;
               }

               var4.b(var1, var3);
               var4.a(var2, var3);
               var4 = (q)var4.i;
            } while(!var5);
         }

         if(var2 == null && var1 != null) {
            var4 = (q)this.c.c();

            do {
               if(var4 == null) {
                  return;
               }

               var4.b(var1, var3);
               var4 = (q)var4.i;
            } while(!var5);
         }

         if(var2 != null && var1 == null) {
            var4 = (q)this.c.c();

            while(var4 != null) {
               var4.a(var2, var3);
               var4 = (q)var4.i;
               if(var5) {
                  break;
               }
            }
         }

      }
   }

   public synchronized void a(o var1) {
      if(this.k == null) {
         this.k = new ArrayList();
      }

      this.k.add(var1);
   }

   public synchronized void b(o var1) {
      if(this.k != null) {
         this.k.remove(var1);
         if(this.k.size() == 0) {
            this.k = null;
         }
      }

   }

   public Iterator q() {
      return this.k == null?(new ArrayList(1)).iterator():(new ArrayList(this.k)).iterator();
   }

   public void r() {
      if(this.k != null) {
         this.a(l.a(this));
      }

   }

   public void s() {
      if(this.k != null) {
         this.a(l.b(this));
      }

   }

   protected void a(l var1) {
      boolean var4 = D.e;
      if(this.k != null) {
         o[] var2 = new o[this.k.size()];
         this.k.toArray(var2);
         int var3 = 0;

         while(var3 < var2.length) {
            var2[var3].onGraphEvent(var1);
            ++var3;
            if(var4) {
               break;
            }
         }
      }

   }

   public A t() {
      return this.a.a(this.c, "ANONYMOUS");
   }

   public h u() {
      return this.b.b(this.d, "ANONYMOUS");
   }

   public void a(A var1) {
      this.a.a(var1, this.c);
   }

   public void a(h var1) {
      this.b.a(var1, this.d);
   }

   public A[] v() {
      return this.a.a();
   }

   public h[] w() {
      return this.b.b();
   }

   public Object b_(Object var1) {
      return ((d)var1).c();
   }

   public Object c_(Object var1) {
      return ((d)var1).d();
   }

   public Iterator x() {
      return y.g.l.a(this.o());
   }

   public Iterator y() {
      return y.g.l.a(this.p());
   }

   public c c(Object var1) {
      return (c)this.h.get(var1);
   }

   public void a(Object var1, c var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("DataProvider must be non-null!");
      } else {
         this.h.put(var1, var2);
      }
   }

   public void d_(Object var1) {
      this.h.remove(var1);
   }

   public Object[] z() {
      return this.h.keySet().toArray();
   }

   private void b(d var1, q var2, d var3, q var4, d var5, int var6, int var7) {
      var2.a(var1, var3, var6);
      var4.b(var1, var5, var7);
   }

   private void b(d var1, q var2, q var3) {
      var2.f(var1);
      var3.g(var1);
   }

   void A() {
      boolean var3 = D.e;
      int var1 = 0;
      q var2 = (q)this.c.c();

      while(true) {
         if(var2 != null) {
            var2.h = var1++;
            var2 = (q)var2.i;
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         this.e = false;
         break;
      }

   }

   void B() {
      boolean var3 = D.e;
      int var1 = 0;
      d var2 = (d)this.d.c();

      while(true) {
         if(var2 != null) {
            var2.g = var1++;
            var2 = (d)var2.i;
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         this.f = false;
         break;
      }

   }

   void g(q var1) {
      var1.a(this, this.a.a);
      var1.h = this.c.a();
      this.c.b((I)var1);
   }

   void a(d var1, q var2, d var3, q var4, d var5, int var6, int var7) {
      if(var2.e() == this && var4.e() == this) {
         if(var3 != null && var3.c() != var2) {
            throw new IllegalArgumentException("v must be source of e1.");
         } else if(var5 != null && var5.d() != var4) {
            throw new IllegalArgumentException("w must be target of e2.");
         } else {
            var1.a(this, var2, var4, this.b.a);
            var1.g = this.d.a();
            this.d.b((I)var1);
            this.b(var1, var1.c(), var3, var1.d(), var5, var6, var7);
         }
      } else {
         throw new IllegalArgumentException("Both endpoints must reside in this graph.");
      }
   }

   public String toString() {
      boolean var3 = D.e;
      StringBuffer var1 = new StringBuffer(128 + 4 * this.e() + 4 * this.g());
      var1.append("nodes #").append(this.f()).append(" [");
      x var2 = this.o();

      while(true) {
         if(var2.f()) {
            var1.append(var2.e().toString());
            var2.g();
            if(!var2.f()) {
               continue;
            }

            var1.append(',');
            var1.append(' ');
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         var1.append("]\nedges #").append(this.h()).append(" [");
         break;
      }

      e var4 = this.p();

      while(true) {
         if(var4.f()) {
            var1.append(var4.a().toString());
            var4.g();
            if(!var4.f()) {
               continue;
            }

            var1.append(',');
            var1.append(' ');
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         var1.append(']');
         break;
      }

      String var10000 = var1.toString();
      if(g) {
         D.e = !var3;
      }

      return var10000;
   }

   static {
      new y.g.o();
   }
}
