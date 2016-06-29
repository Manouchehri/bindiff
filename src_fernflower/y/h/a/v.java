package y.h.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.WeakHashMap;
import y.h.bu;
import y.h.a.A;
import y.h.a.B;
import y.h.a.C;
import y.h.a.D;
import y.h.a.E;
import y.h.a.F;
import y.h.a.H;
import y.h.a.I;
import y.h.a.J;
import y.h.a.K;
import y.h.a.c;
import y.h.a.d;
import y.h.a.t;
import y.h.a.u;
import y.h.a.w;
import y.h.a.x;
import y.h.a.y;
import y.h.a.z;

public class v {
   private static final Collection b = new ArrayList();
   private Map c;
   private Map d;
   private Map e;
   private z f;
   private y.c.o g;
   private y.c.m h;
   private Vector i;
   private K j;
   private y.c.i k;
   private Map l;
   private Map m;
   private y.c.A n;
   private y.c.A o;
   private y.c.q p;
   private int q;
   private y.c.c r;
   private y.c.c s;
   private y.c.c t;
   public static int a;

   public v(y.c.i var1) {
      this(var1, new c());
   }

   public v(y.c.i var1, y.c.m var2) {
      int var7;
      label39: {
         var7 = a;
         super();
         this.r = new I();
         this.s = new C(this);
         this.t = new H(this);
         this.d = new WeakHashMap();
         this.e = new WeakHashMap();
         this.c = new WeakHashMap();
         this.f = new z(this, var1, (y.c.q)null);
         this.c.put(var1, this.f);
         this.g = new B(this);
         this.i = new Vector();
         this.h = var2;
         this.j = new d();
         if(var1 instanceof bu) {
            ((bu)var1).a(this);
            if(var7 == 0) {
               break label39;
            }

            y.c.i.g = !y.c.i.g;
         }

         Collection var3 = b;
         synchronized(b) {
            b.add(this);
         }
      }

      this.k = new y.c.i();
      this.l = new WeakHashMap();
      this.m = new WeakHashMap();
      this.n = this.k.t();
      this.o = this.k.t();
      this.p = this.k.d();
      this.l.put(var1, this.p);
      this.m.put((Object)null, this.p);
      this.q = 0;
      this.k.a((y.c.o)(new w(this)));
      var1.a(this.g);
      y.c.x var9 = var1.o();

      while(var9.f()) {
         y.c.q var4 = var9.e();
         y.c.q var5 = (y.c.q)this.l.get(var1);
         y.c.q var6 = this.k.d();
         this.m.put(var4, var6);
         this.n.a(var6, var4);
         this.k.a(var6, var5);
         var9.g();
         if(var7 != 0) {
            break;
         }
      }

   }

   public static v a(y.c.i var0) {
      if(var0 instanceof bu) {
         return ((bu)var0).C();
      } else {
         Collection var1 = b;
         synchronized(b) {
            Iterator var2 = b.iterator();

            v var3;
            do {
               if(!var2.hasNext()) {
                  return null;
               }

               var3 = (v)var2.next();
            } while(!var3.d(var0));

            return var3;
         }
      }
   }

   public y.c.q a(y.c.q var1) {
      int var7 = a;
      y.c.i var2 = null;
      if(var1 == null) {
         var2 = this.g();
      } else if(this.j(var1)) {
         var2 = this.m(var1);
      } else {
         var2 = var1.e();
      }

      y.c.i var3 = this.h(var2);
      if(var3 instanceof bu) {
         ((bu)var3).a(this);
      }

      y.c.q var4 = this.h.a(var2, var3);
      this.a(new t(this, (byte)6, var2, var4));
      z var5 = new z(this, var3, var4);
      this.c.put(var3, var5);
      this.e.put(var4, var5);
      y.c.q var6 = (y.c.q)this.m.get(var4);
      this.l.put(var3, var6);
      this.a(new t(this, (byte)4, var2, var4));
      if(this.k(var1)) {
         this.c(new y.c.y(var4), var1);
      }

      this.k.a(var6.f(), (y.c.d)null, var6.f().d().g(), 0, 1);
      if(y.c.i.g) {
         ++var7;
         a = var7;
      }

      return var4;
   }

   public y.c.q b(y.c.i var1) {
      return this.a(this.e(var1));
   }

   public y.c.q b(y.c.q var1) {
      y.c.i var2 = null;
      if(var1 == null) {
         var2 = this.g();
      } else if(this.j(var1)) {
         var2 = this.m(var1);
      } else {
         var2 = var1.e();
      }

      y.c.q var3 = this.h.a(var2, var1);
      this.c(var3);
      if(this.k(var1)) {
         this.c(new y.c.y(var3), var1);
      }

      return var3;
   }

   public y.c.q c(y.c.i var1) {
      return this.b(this.e(var1));
   }

   public void c(y.c.q var1) {
      y.c.i var2 = var1.e();
      y.c.y var3 = null;
      boolean var4 = this.j(var1);
      if(var4) {
         var3 = new y.c.y(this.m(var1).o());
         this.a(this.m(var1), var3);
         this.g(var1);
      }

      this.a(new t(this, (byte)6, var1.e(), var1));
      y.c.q var5 = (y.c.q)this.m.get(var1);
      if(!this.o.d(var5)) {
         this.o.a(var5, true);
      }

      this.a(new t(this, (byte)4, var2, var1));
      if(var4) {
         this.c(var3, var1);
      }

      this.k.a(var5.f(), (y.c.d)null, var5.f().d().g(), 0, 1);
   }

   public y.c.d a(y.c.q var1, y.c.q var2) {
      y.c.i var3 = var1.e();
      y.c.i var4 = var2.e();
      if(var3 != null && var4 != null) {
         if(var3 == var4) {
            return var3.a(var1, var2);
         } else {
            y.c.i var5 = this.a(var3, var4);
            if(var5 == null) {
               throw new IllegalArgumentException("No common ancestor found.");
            } else {
               y.c.q var6 = this.a(var1, var5);
               y.c.q var7 = this.a(var2, var5);
               y.c.d var8 = var5.a(var6, var7);
               this.b(var8, var1, var2);
               return var8;
            }
         }
      } else {
         throw new IllegalArgumentException("Not all endpoints lie in a graph.");
      }
   }

   public void a(y.c.d var1, y.c.q var2, y.c.q var3) {
      int var11 = a;
      y.c.i var4 = var1.a();
      if(var4 != null && !this.d(var4)) {
         throw new IllegalArgumentException("Edge not in graph hierarchy.");
      } else {
         y.c.i var5 = var2.e();
         y.c.i var6 = var3.e();
         if(var5 != null && var6 != null) {
            y.c.i var7;
            y.c.q var9;
            if(this.e(var1)) {
               if(var5 == var6) {
                  this.b(var5, var4);
                  this.a(var1);
                  this.a(var4, var5, var1, var2, var3);
                  this.c(var4, var5);
                  if(var11 == 0) {
                     return;
                  }
               }

               var7 = this.a(var5, var6);
               if(var7 == null) {
                  throw new IllegalArgumentException("No common ancestor found.");
               }

               this.b(var7, var4);
               E var8 = this.f(var1);
               var9 = this.a(var2, var7);
               y.c.q var10 = this.a(var3, var7);
               this.a(var1);
               this.a(var4, var7, var1, var9, var10);
               var8.a = var2;
               var8.b = var3;
               this.a(var1, (byte)7);
               this.d.put(var1, var8);
               this.a(var1, (byte)5);
               this.c(var4, var7);
               if(var11 == 0) {
                  return;
               }
            }

            if(var5 == var6) {
               this.b(var5, var4);
               this.a(var4, var5, var1, var2, var3);
               this.c(var4, var5);
               if(var11 == 0) {
                  return;
               }
            }

            var7 = this.a(var5, var6);
            if(var7 == null) {
               throw new IllegalArgumentException("No common ancestor found.");
            } else {
               this.b(var7, var4);
               y.c.q var12 = this.a(var2, var7);
               var9 = this.a(var3, var7);
               this.a(var4, var7, var1, var12, var9);
               this.b(var1, var2, var3);
               this.c(var4, var7);
            }
         } else {
            throw new IllegalArgumentException("Not all endpoints lie in a graph.");
         }
      }
   }

   private void a(y.c.i var1, y.c.i var2, y.c.d var3, y.c.q var4, y.c.q var5) {
      if(var1 != var2 && var1 != null) {
         var1.a(var3);
      }

      var2.a(var3, var4, var5);
      if(var1 != var2 && var1 != null) {
         var2.b(var3);
      }

   }

   private void b(y.c.i var1, y.c.i var2) {
      if(var1 != null) {
         var1.r();
      }

      if(var2 != null) {
         var2.r();
      }

   }

   private void c(y.c.i var1, y.c.i var2) {
      if(var1 != null) {
         var1.s();
      }

      if(var2 != null) {
         var2.s();
      }

   }

   private void a(y.c.d var1, byte var2) {
      this.a(new t(this, var2, var1.a(), var1));
   }

   public y.c.q a(y.c.q var1, y.c.i var2) {
      int var4 = a;
      if(var1.e() == var2) {
         return var1;
      } else {
         try {
            y.c.q var3 = this.e(var1.e());

            y.c.q var10000;
            while(true) {
               if(var3 != null) {
                  var10000 = var3;
                  if(var4 != 0) {
                     break;
                  }

                  if(var3.e() != var2) {
                     var3 = this.e(var3.e());
                     if(var4 == 0) {
                        continue;
                     }
                  }
               }

               var10000 = var3;
               break;
            }

            return var10000;
         } catch (RuntimeException var5) {
            throw new IllegalArgumentException("No representative of v in inGraph.");
         }
      }
   }

   public void d(y.c.q var1) {
      this.b(var1, this.h(var1.e()));
   }

   public void b(y.c.q var1, y.c.i var2) {
      y.c.i var3 = var1.e();
      var3.r();
      boolean var4 = this.k(var1);
      this.a(new t(this, (byte)6, var3, var1));
      if(var2 instanceof bu) {
         ((bu)var2).a(this);
      }

      z var5 = new z(this, var2, var1);
      this.c.put(var2, var5);
      this.e.put(var1, var5);
      y.c.q var6 = (y.c.q)this.m.get(var1);
      this.l.put(var2, var6);
      if(var4) {
         this.o.a(var6, false);
      }

      this.a(new t(this, (byte)4, var3, var1));
      this.k.a(var6.f(), (y.c.d)null, var6.f().d().g(), 0, 1);
      var3.s();
   }

   public void e(y.c.q var1) {
      y.c.i var2 = var1.e();
      var2.r();
      y.c.y var3 = new y.c.y(this.p(var1));
      this.b(var3);
      this.d(var1);
      this.a(var3, var1);
      var2.s();
   }

   public void f(y.c.q var1) {
      y.c.i var2 = var1.e();
      var2.r();
      y.c.y var3 = new y.c.y(this.m(var1).o());
      this.a(this.m(var1), var3);
      this.c(var1);
      this.c(var3, var1);
      var2.s();
   }

   public void g(y.c.q var1) {
      y.c.i var2;
      label24: {
         int var4 = a;
         var2 = var1.e();
         this.a(new t(this, (byte)6, var2, var1));
         if(this.j(var1)) {
            this.c.remove(this.q(var1).c());
            y.c.i var3 = this.q(var1).c();
            if(var3 instanceof bu) {
               ((bu)var3).a((v)null);
            }

            this.e.remove(var1);
            if(var4 == 0) {
               break label24;
            }
         }

         if(!this.k(var1)) {
            throw new IllegalArgumentException("convertToNode. Node is already normal");
         }

         Object var5 = this.m.get(var1);
         this.o.a(var5, false);
         if(var4 != 0) {
            throw new IllegalArgumentException("convertToNode. Node is already normal");
         }
      }

      y.c.q var6 = this.s(var1);
      this.k.a(var6.f(), (y.c.d)null, var6.f().d().i(), 0, 0);
      this.a(new t(this, (byte)4, var2, var1));
   }

   public void b(y.c.d var1, y.c.q var2, y.c.q var3) {
      this.a(var1, (byte)7);
      this.d.put(var1, new E(var2, var3));
      this.a(var1, (byte)5);
   }

   public void a(y.c.d var1) {
      this.a(var1, (byte)7);
      this.d.remove(var1);
      this.a(var1, (byte)5);
   }

   public K a() {
      return this.j;
   }

   public void a(y.c.q var1, y var2) {
      this.b(this.s(var1), var2);
   }

   private void b(y.c.q var1, y var2) {
      int var6 = a;
      y.c.d var3 = var1.g();

      while(var3 != null) {
         y.c.q var4 = var3.c();
         y.c.q var5 = (y.c.q)this.n.b(var4);
         var2.a(var5);
         if(var4.b() > 0 && !this.j(var5)) {
            this.b(var4, var2);
         }

         var3 = var3.h();
         if(var6 != 0) {
            break;
         }
      }

   }

   public Iterator h(y.c.q var1) {
      return new J(this, this.s(var1));
   }

   public Iterator b() {
      return new D(this, this.p);
   }

   public Iterator i(y.c.q var1) {
      return new D(this, this.s(var1));
   }

   public y.c.c c() {
      return this.r;
   }

   public y.c.c d() {
      return this.s;
   }

   public y.c.c e() {
      return this.t;
   }

   public y.c.q b(y.c.d var1) {
      return this.f(var1).a();
   }

   public y.c.q c(y.c.d var1) {
      return this.f(var1).b();
   }

   public boolean d(y.c.i var1) {
      return this.i(var1) != null;
   }

   public x d(y.c.d var1) {
      E var2 = this.f(var1);
      return var2 == null?null:new F(var2);
   }

   public boolean e(y.c.d var1) {
      return this.d.get(var1) != null;
   }

   public boolean j(y.c.q var1) {
      return this.e.get(var1) != null;
   }

   public boolean k(y.c.q var1) {
      return this.o.d(this.m.get(var1));
   }

   public boolean l(y.c.q var1) {
      return !this.o.d(this.m.get(var1)) && this.e.get(var1) == null;
   }

   public boolean f() {
      int var2 = a;
      y.c.x var1 = this.k.o();

      boolean var10000;
      while(true) {
         if(var1.f()) {
            var10000 = this.o.d(var1.e());
            if(var2 != 0) {
               break;
            }

            if(var10000) {
               return true;
            }

            var1.g();
            if(var2 == 0) {
               continue;
            }
         }

         var10000 = false;
         break;
      }

      return var10000;
   }

   public y.c.i m(y.c.q var1) {
      z var2 = this.q(var1);
      return var2 != null?var2.c():this.f.c();
   }

   public y.c.q e(y.c.i var1) {
      return (y.c.q)this.n.b(this.l.get(var1));
   }

   public y.c.q n(y.c.q var1) {
      y.c.q var2 = (y.c.q)this.m.get(var1);
      y.c.q var3 = var2.f().d();
      return (y.c.q)this.n.b(var3);
   }

   public boolean b(y.c.q var1, y.c.q var2) {
      int var5 = a;
      if(var1 == null) {
         return true;
      } else {
         Object var3 = this.m.get(var1);
         y.c.q var4 = (y.c.q)this.m.get(var2);

         while(var4 != this.p) {
            if(var3 == var4) {
               return true;
            }

            var4 = var4.f().d();
            if(var5 != 0) {
               break;
            }
         }

         return false;
      }
   }

   public y.c.i f(y.c.i var1) {
      return this.i(var1).a();
   }

   public y.c.i g() {
      return this.f.a;
   }

   public boolean g(y.c.i var1) {
      return this.f.a == var1;
   }

   public Object[] a(Object var1) {
      y.c.D var2;
      int var4;
      label27: {
         var4 = a;
         var2 = new y.c.D();
         if(var1 instanceof y.c.q) {
            var1 = ((y.c.q)var1).e();
            if(var4 == 0) {
               break label27;
            }
         }

         if(!(var1 instanceof y.c.i)) {
            throw new IllegalArgumentException("argument neither instance of Graph nor of Node.");
         }
      }

      y.c.q var3 = (y.c.q)this.l.get(var1);

      while(true) {
         if(var3 != this.p) {
            var2.c(this.n.b(var3));
            var3 = var3.f().d();
            if(var4 != 0) {
               break;
            }

            if(var4 == 0) {
               continue;
            }
         }

         var2.c((Object)this.g());
         break;
      }

      return var2.toArray();
   }

   public Object[] a(Object var1, boolean var2) {
      y.c.D var3;
      y.c.q var4;
      int var5;
      label26: {
         var5 = a;
         var3 = new y.c.D();
         if(var1 instanceof y.c.i) {
            var4 = (y.c.q)this.l.get(var1);
            if(var5 == 0) {
               break label26;
            }
         }

         var4 = (y.c.q)this.m.get(var1);
         if(!var2 && var4 != null) {
            var4 = var4.f().d();
         }
      }

      while(var4 != this.p && var4 != null) {
         var3.c(this.n.b(var4));
         var4 = var4.f().d();
         if(var5 != 0) {
            break;
         }
      }

      var3.c((Object)this.g());
      return var3.toArray();
   }

   public y.c.q a(y.c.y var1) {
      int var4 = a;
      y.c.y var2 = new y.c.y();
      y.c.x var3 = var1.a();

      Object var10000;
      while(true) {
         if(var3.f()) {
            var2.add(this.m.get(var3.e()));
            var10000 = var3;
            if(var4 != 0) {
               break;
            }

            var3.g();
            if(var4 == 0) {
               continue;
            }
         }

         var10000 = this.n.b(y.a.A.a(this.k, this.p, false, var2));
         break;
      }

      return (y.c.q)var10000;
   }

   public y.c.i a(y.c.i var1, y.c.i var2) {
      int var10 = a;
      y.c.i var3 = this.g();
      if(var1 == var2) {
         return var1;
      } else if(var1 != var3 && var2 != var3) {
         y.c.D var4 = new y.c.D();
         z var5 = this.i(var1);
         if(var5 == null) {
            return var3;
         } else {
            var4.c((Object)var1);

            while(var5.b != null) {
               y.c.i var6 = var5.b.e();
               if(var6 == var2) {
                  return var2;
               }

               var4.c((Object)var6);
               var5 = var5.b();
               if(var10 != 0) {
                  break;
               }
            }

            y.c.D var11 = new y.c.D();
            var5 = this.i(var2);
            if(var5 == null) {
               return var3;
            } else {
               var11.c((Object)var2);

               while(var5.b != null) {
                  y.c.i var7 = var5.b.e();
                  if(var7 == var1) {
                     return var1;
                  }

                  var11.c((Object)var7);
                  var5 = var5.b();
                  if(var10 != 0) {
                     break;
                  }
               }

               Object[] var12 = var4.toArray();
               Object[] var8 = var11.toArray();
               int var9 = 0;

               int var10000;
               while(true) {
                  if(var9 < var12.length) {
                     var10000 = var9;
                     if(var10 != 0) {
                        break;
                     }

                     if(var9 < var8.length && var12[var9] == var8[var9]) {
                        ++var9;
                        if(var10 == 0) {
                           continue;
                        }
                     }
                  }

                  var10000 = var9;
                  break;
               }

               return var10000 == 0?var3:(y.c.i)var12[var9 - 1];
            }
         }
      } else {
         return var3;
      }
   }

   public int o(y.c.q var1) {
      int var4 = a;
      y.c.q var2 = this.s(var1);
      int var3 = 0;
      var2 = this.t(var2);

      int var10000;
      while(true) {
         if(var2 != this.p) {
            var10000 = this.j(this.r(var2));
            if(var4 != 0) {
               break;
            }

            if(var10000 == 0) {
               ++var3;
               var2 = this.t(var2);
               if(var4 == 0) {
                  continue;
               }
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   public y.c.x p(y.c.q var1) {
      return new A(this, (y.c.q)this.m.get(var1));
   }

   public void a(u var1) {
      this.i.add(var1);
   }

   protected void a(t var1) {
      int var4 = a;
      if(!this.i.isEmpty()) {
         u[] var2 = new u[this.i.size()];
         this.i.toArray(var2);
         int var3 = 0;

         while(var3 < var2.length) {
            var2[var3].a(var1);
            ++var3;
            if(var4 != 0) {
               break;
            }
         }
      }

   }

   public void a(y.c.y var1, y.c.q var2) {
      int var13 = a;
      if(!var1.isEmpty()) {
         y.c.i var3 = var2.e();
         var3.r();
         z var4 = this.q(var2);
         y.c.i var5 = var4.c();
         this.e(var1, this.n(var2));
         var1 = this.c(var1);
         y.c.f var6 = var3.a(var1, var5);
         y.c.e var7 = var6.a();

         while(true) {
            if(var7.f()) {
               y.c.d var8 = var7.a();
               E var9 = this.f(var8);
               if(var13 != 0) {
                  break;
               }

               label101: {
                  y.c.q var10;
                  y.c.q var11;
                  if(var8.c() == var2 || var8.d() == var2) {
                     if(var9 == null || var9.a == var2 || var9.b == var2) {
                        var10 = var8.c();
                        var11 = var8.d();
                        if(var8.c() == var2) {
                           var3.a(var8, var8.c(), var2);
                           var3.b(var8);
                           this.g(var8);
                           if(var9 == null) {
                              this.b(var8, var10, var11);
                           }

                           this.a(var8, var9 != null, var10, var11);
                           if(var13 == 0) {
                              break label101;
                           }
                        }

                        var3.a(var8, var2, var8.d());
                        var3.b(var8);
                        this.g(var8);
                        if(var9 == null) {
                           this.b(var8, var10, var11);
                        }

                        this.a(var8, var9 != null, var10, var11);
                        if(var13 == 0) {
                           break label101;
                        }
                     }

                     var11 = var8.c();
                     y.c.q var12 = var8.d();
                     y.c.y var14;
                     if(var8.c() == var2) {
                        var14 = var4.a(var9.a());
                        var4.a.a(var8, var14.b(), var8.d());
                        var4.a.b(var8);
                        this.g(var8);
                        this.a(var8, true, var11, var12);
                        if(var13 == 0) {
                           break label101;
                        }
                     }

                     var14 = var4.a(var9.b());
                     var4.a.a(var8, var8.c(), var14.b());
                     var4.a.b(var8);
                     this.g(var8);
                     this.a(var8, true, var11, var12);
                     if(var13 == 0) {
                        break label101;
                     }
                  }

                  label67: {
                     var10 = var8.c();
                     var11 = var8.d();
                     if(var10.e() != var3) {
                        var3.a(var8, var2, var11);
                        var3.b(var8);
                        this.g(var8);
                        if(var13 == 0) {
                           break label67;
                        }
                     }

                     var3.a(var8, var10, var2);
                     var3.b(var8);
                     this.g(var8);
                  }

                  if(var9 == null) {
                     this.b(var8, var10, var11);
                     this.a(var8, false, var10, var11);
                     if(var13 == 0) {
                        break label101;
                     }
                  }

                  this.a(var8, true, var10, var11);
               }

               var7.g();
               if(var13 == 0) {
                  continue;
               }
            }

            var3.s();
            break;
         }

      }
   }

   public void a(y.c.i var1, y.c.y var2) {
      int var15 = a;
      if(!var2.isEmpty()) {
         z var3 = this.i(var1);
         z var4 = var3.b();
         y.c.i var5 = var4.c();
         var5.r();
         var2 = this.c(var2);
         y.c.q var6 = var3.d();
         y.c.f var7 = var1.a(var2, var5);
         y.c.e var8 = (new y.c.f(var6.j())).a();

         y.c.i var17;
         label69: {
            y.c.d var9;
            y.c.q var10;
            y.c.q var11;
            boolean var10000;
            while(true) {
               if(var8.f()) {
                  var9 = var8.a();
                  var10000 = this.e(var9);
                  if(var15 != 0) {
                     break;
                  }

                  if(var10000) {
                     var10 = var9.c();
                     var11 = var9.d();
                     E var12;
                     if(var10 == var6) {
                        var12 = this.f(var9);
                        y.c.y var13 = var4.a(var12.a());
                        y.c.q var14 = var13.b();
                        if(var14 != var6) {
                           var5.a(var9);
                           var5.a(var9, var14, var9.d());
                           var5.b(var9);
                           this.g(var9);
                           this.a(var9, true, var10, var11);
                        }
                     }

                     if(var11 == var6) {
                        var12 = this.f(var9);
                        if(var12 != null) {
                           y.c.q var16 = var4.a(var12.b()).b();
                           if(var16 != var6) {
                              var5.a(var9);
                              var5.a(var9, var9.c(), var16);
                              var5.b(var9);
                              this.g(var9);
                              this.a(var9, true, var10, var11);
                           }
                        }
                     }
                  }

                  var8.g();
                  if(var15 == 0) {
                     continue;
                  }
               }

               var8 = var7.a();
               var10000 = var8.f();
               break;
            }

            while(var10000) {
               var9 = var8.a();
               var10 = var9.c();
               var11 = var9.d();
               var17 = var9.c().e();
               if(var15 != 0) {
                  break label69;
               }

               label54: {
                  if(var17 == var1) {
                     var5.a(var9, var6, var9.d());
                     var5.b(var9);
                     this.a(var9, var10, var11, var6, var9.d());
                     this.a(var9, true, var10, var11);
                     if(var15 == 0) {
                        break label54;
                     }
                  }

                  if(var9.d().e() == var1) {
                     var5.a(var9, var9.c(), var6);
                     var5.b(var9);
                     this.a(var9, var10, var11, var9.c(), var6);
                     this.a(var9, true, var10, var11);
                  }
               }

               var8.g();
               if(var15 != 0) {
                  break;
               }

               var10000 = var8.f();
            }

            var17 = var5;
         }

         var17.s();
      }
   }

   public void b(y.c.y var1, y.c.q var2) {
      int var4 = a;
      y.c.x var3 = var1.a();

      while(var3.f()) {
         this.c(var3.e(), var2);
         var3.g();
         if(var4 != 0) {
            break;
         }
      }

   }

   public void c(y.c.q var1, y.c.q var2) {
      int var10 = a;
      if(var1 == var2) {
         throw new IllegalArgumentException("node may not be identical to parentNode");
      } else if(this.b(var1, var2)) {
         throw new IllegalArgumentException("node may not be an ancestor of parentNode");
      } else {
         y.c.i var3 = var2 == null?this.g():(this.j(var2)?this.m(var2):var2.e());
         y.c.i var4 = var1.e();
         y.c.i var5 = this.a(var3, var4);

         v var10000;
         while(true) {
            if(var4 != var5) {
               var10000 = this;
               if(var10 != 0) {
                  break;
               }

               this.a(var4, new y.c.y(var1));
               var4 = var1.e();
               if(var10 == 0) {
                  continue;
               }
            }

            var10000 = this;
            break;
         }

         Object[] var6 = var10000.a(var2, true);
         byte var7 = 0;
         int var11 = var7 + 1;
         y.c.i var8 = (y.c.i)var6[var7];

         label54:
         while(true) {
            y.c.q var9;
            if(var8 != var5) {
               var9 = (y.c.q)var6[var11++];
               if(!this.j(var9)) {
                  continue;
               }

               var8 = this.m(var9);
               if(var10 != 0) {
                  break;
               }

               if(var10 == 0) {
                  continue;
               }
            }

            while(true) {
               if(var8 == var3) {
                  break label54;
               }

               var9 = (y.c.q)var6[var11++];
               if(this.j(var9)) {
                  this.a(new y.c.y(var1), var9);
                  var8 = this.m(var9);
                  if(var10 != 0) {
                     return;
                  }

                  if(var10 != 0) {
                     break label54;
                  }
               }
            }
         }

         if(this.n(var1) != var2) {
            this.c(new y.c.y(var1), var2);
         }

      }
   }

   public void c(y.c.y var1, y.c.q var2) {
      if(!var1.isEmpty()) {
         this.f(this.d(var1), var2);
      }

   }

   public void b(y.c.y var1) {
      int var7 = a;
      if(!var1.isEmpty()) {
         var1 = this.d(var1);
         y.c.y var2 = new y.c.y();
         y.c.q var3 = this.n(var1.b());
         y.c.x var4 = var1.a();

         while(true) {
            if(var4.f()) {
               y.c.q var5 = var4.e();
               y.c.q var6 = this.n(var5);
               if(var7 != 0) {
                  break;
               }

               if(var6 != null && !this.j(var6)) {
                  if(var6 != var3) {
                     if(var3 != null) {
                        this.f(var2, this.n(var3));
                     }

                     var3 = var6;
                     var2 = new y.c.y();
                  }

                  var2.add(var5);
               }

               var4.g();
               if(var7 == 0) {
                  continue;
               }
            }

            if(var2.size() > 0) {
               this.c(var2, this.n(var3));
            }
            break;
         }

      }
   }

   private y.c.i h(y.c.i var1) {
      return this.h.a(var1);
   }

   private z i(y.c.i var1) {
      return (z)this.c.get(var1);
   }

   private z q(y.c.q var1) {
      return (z)this.e.get(var1);
   }

   private E f(y.c.d var1) {
      return (E)this.d.get(var1);
   }

   private y.c.q r(y.c.q var1) {
      return (y.c.q)this.n.b(var1);
   }

   private y.c.q s(y.c.q var1) {
      return (y.c.q)this.m.get(var1);
   }

   private y.c.q j(y.c.i var1) {
      return (y.c.q)this.l.get(var1);
   }

   private y.c.q t(y.c.q var1) {
      return var1.f().d();
   }

   private y.c.y c(y.c.y var1) {
      int var6 = a;
      if(var1.isEmpty()) {
         return var1;
      } else {
         y.c.y var2 = new y.c.y();
         y.c.i var3 = var1.b().e();
         boolean[] var4 = new boolean[var3.e()];
         y.c.x var5 = var1.a();

         while(true) {
            if(var5.f()) {
               var4[var5.e().d()] = true;
               var5.g();
               if(var6 != 0) {
                  break;
               }

               if(var6 == 0) {
                  continue;
               }
            }

            var5 = var1.a();
            break;
         }

         while(var5.f()) {
            if(this.k(var5.e()) && var4[var5.e().d()]) {
               this.a(var5.e(), var4, var2);
            }

            var5.g();
            if(var6 != 0) {
               break;
            }
         }

         var5 = null;
         y.c.y var7;
         if(var2.size() > 0) {
            var7 = new y.c.y(var1.a());
            var7.a(var2);
         } else {
            var7 = var1;
         }

         return var7;
      }
   }

   private void a(y.c.q var1, boolean[] var2, y.c.y var3) {
      int var6 = a;
      y.c.x var4 = this.p(var1);

      while(var4.f()) {
         y.c.q var5 = var4.e();
         if(!var2[var5.d()]) {
            var3.add(var5);
         }

         if(this.k(var5)) {
            this.a(var5, var2, var3);
         }

         var4.g();
         if(var6 != 0) {
            break;
         }
      }

   }

   private y.c.y d(y.c.y var1) {
      return this.d(var1, (y.c.q)null);
   }

   private y.c.y d(y.c.y var1, y.c.q var2) {
      int var8 = a;
      y.c.y var3 = new y.c.y();
      boolean[] var4 = new boolean[this.k.e()];
      y.c.x var5 = var1.a();

      while(true) {
         if(var5.f()) {
            var4[this.s(var5.e()).d()] = true;
            var5.g();
            if(var8 != 0) {
               break;
            }

            if(var8 == 0) {
               continue;
            }
         }

         var2 = this.s(var2);
         break;
      }

      var5 = var1.a();

      while(var5.f()) {
         y.c.q var6 = this.s(var5.e());
         y.c.q var7 = this.t(var6);

         boolean var10000;
         while(true) {
            if(var7 != var2) {
               var10000 = var4[var7.d()];
               if(var8 != 0) {
                  break;
               }

               if(!var10000) {
                  var7 = this.t(var7);
                  if(var8 == 0) {
                     continue;
                  }
               }
            }

            var10000 = var4[var7.d()];
            break;
         }

         if(!var10000) {
            var3.add(var5.e());
         }

         var5.g();
         if(var8 != 0) {
            break;
         }
      }

      return var3;
   }

   private void e(y.c.y var1, y.c.q var2) {
      int var12 = a;
      y.c.i var3 = null;
      if(var2 == null) {
         var3 = this.g();
      } else if(this.j(var2)) {
         var3 = this.m(var2);
      } else {
         var3 = var2.e();
      }

      y.c.q var4 = this.s(var2);
      y.c.q var5 = this.j(var3);
      boolean[] var6 = new boolean[var3.e()];
      y.c.x var7 = var1.a();

      while(true) {
         if(var7.f()) {
            var6[var7.e().d()] = true;
            var7.g();
            if(var12 != 0) {
               break;
            }

            if(var12 == 0) {
               continue;
            }
         }

         var7 = var1.a();
         break;
      }

      while(var7.f()) {
         y.c.q var8 = var7.e();
         y.c.q var9 = this.t(this.s(var8));
         boolean var10 = true;

         label43:
         do {
            y.c.q var10000 = var9;
            y.c.q var10001 = var4;

            do {
               if(var10000 == var10001) {
                  break label43;
               }

               var10000 = var9;
               var10001 = var5;
            } while(var12 != 0);

            if(var9 == var5) {
               break;
            }

            y.c.q var11 = this.r(var9);
            var10 = var6[var11.d()];
            var9 = this.t(var9);
         } while(var12 == 0);

         if(!var10) {
            this.c(new y.c.y(var8), var2);
         }

         var7.g();
         if(var12 != 0) {
            break;
         }
      }

   }

   private void f(y.c.y var1, y.c.q var2) {
      int var11 = a;
      if(!var1.isEmpty()) {
         y.c.q var3 = this.s(var2);
         y.c.q var4 = this.n(var1.b());
         y.c.y var5 = new y.c.y();
         y.c.x var6 = var1.a();

         boolean var10000;
         while(true) {
            if(var6.f()) {
               y.c.q var7 = var6.e();
               y.c.q var8 = this.s(var7);
               y.c.q var9 = this.n(var7);
               y.c.d var10 = var8.f();
               var10000 = this.j(var7);
               if(var11 != 0) {
                  break;
               }

               label46: {
                  if(var10000 || this.k(var7)) {
                     this.k.a(var10, var8, (y.c.d)null, 1, var3, var3.g(), 1);
                     if(var11 == 0) {
                        break label46;
                     }
                  }

                  this.k.a(var10, var8, (y.c.d)null, 1, var3, var3.i(), 0);
               }

               if(var4 != var9) {
                  this.a(new t(this, (byte)8, var4, var5));
                  var4 = var9;
                  var5 = new y.c.y();
               }

               var5.add(var7);
               var6.g();
               if(var11 == 0) {
                  continue;
               }
            }

            var10000 = var5.isEmpty();
            break;
         }

         if(!var10000) {
            this.a(new t(this, (byte)8, var4, var5));
         }

      }
   }

   private void g(y.c.d var1) {
      E var2 = this.f(var1);
      if(var2 != null) {
         if(var1.c() == var2.a() && var1.d() == var2.b()) {
            this.a(var1);
         }

      }
   }

   private void a(y.c.d var1, y.c.q var2, y.c.q var3, y.c.q var4, y.c.q var5) {
      E var6 = this.f(var1);
      if(var6 != null) {
         if(var1.c() == var6.a() && var1.d() == var6.b()) {
            this.a(var1);
         }

      } else {
         if(var2 != var4 || var3 != var5) {
            this.b(var1, var2, var3);
         }

      }
   }

   private void a(y.c.d var1, boolean var2, y.c.q var3, y.c.q var4) {
      K var5 = this.a();
      if(var5 != null) {
         var5.a(var1, var2, var3, var4);
      }

   }

   static int a(v var0) {
      return ++var0.q;
   }

   static z a(v var0, y.c.i var1) {
      return var0.i(var1);
   }

   static Map b(v var0) {
      return var0.m;
   }

   static y.c.i c(v var0) {
      return var0.k;
   }

   static Map d(v var0) {
      return var0.l;
   }

   static y.c.A e(v var0) {
      return var0.n;
   }

   static y.c.q a(v var0, y.c.q var1) {
      return var0.s(var1);
   }

   static y.c.y a(v var0, y.c.y var1) {
      return var0.d(var1);
   }

   static y.c.q b(v var0, y.c.q var1) {
      return var0.t(var1);
   }

   static y.c.q c(v var0, y.c.q var1) {
      return var0.r(var1);
   }

   static E a(v var0, y.c.d var1) {
      return var0.f(var1);
   }

   static int f(v var0) {
      return var0.q;
   }
}
