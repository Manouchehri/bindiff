package y.h.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import y.h.b.a;
import y.h.b.c;
import y.h.b.f;
import y.h.b.i;
import y.h.b.r;
import y.h.b.s;
import y.h.b.t;

final class j implements i {
   private final List a;
   private final List b;
   private final List c;
   private final List d;
   private y.d.r e;
   private final a f;

   j(a var1, double var2, double var4, double var6, double var8, y.d.r var10, y.d.r var11) {
      this.f = var1;
      this.a = new ArrayList();
      this.b = Collections.unmodifiableList(this.a);
      this.a.add(new r(var1, this, var4, var8, var11));
      this.c = new ArrayList();
      this.c.add(new t(var1, this, var2, var6, var10));
      this.d = Collections.unmodifiableList(this.c);
      this.e = a.x();
   }

   j(a var1, j var2) {
      int var5 = a.H;
      super();
      this.f = var1;
      this.a = new ArrayList(var2.a.size());
      this.b = Collections.unmodifiableList(this.a);
      Iterator var3 = var2.a.iterator();

      while(true) {
         if(var3.hasNext()) {
            r var4 = new r(var1, (r)var3.next());
            this.a.add(var4);
            r.a(var4, this);
            if(var5 != 0) {
               break;
            }

            if(var5 == 0) {
               continue;
            }
         }

         this.c = new ArrayList(var2.c.size());
         this.d = Collections.unmodifiableList(this.c);
         break;
      }

      var3 = var2.c.iterator();

      while(true) {
         if(var3.hasNext()) {
            t var6 = new t(var1, (t)var3.next());
            this.c.add(var6);
            t.a(var6, this);
            if(var5 != 0) {
               break;
            }

            if(var5 == 0) {
               continue;
            }
         }

         this.e = var2.e;
         break;
      }

   }

   public a a() {
      return this.f;
   }

   public int n() {
      return this.a.size();
   }

   public f c(int var1) {
      return (f)this.a.get(var1);
   }

   public f a(double var1, double var3) {
      return a.a(this.f, var1, var3);
   }

   public Collection b() {
      ArrayList var1 = new ArrayList();
      this.a(this.a, var1);
      return var1;
   }

   private void a(List var1, List var2) {
      int var5 = a.H;
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         f var4 = (f)var3.next();
         if(var4.e()) {
            var2.add(var4);
         }

         if(!var4.o().isEmpty()) {
            this.a(var4.o(), var2);
            if(var5 != 0) {
               break;
            }
         }
      }

   }

   public int k() {
      return this.c.size();
   }

   public c b(int var1) {
      return (c)this.c.get(var1);
   }

   public c b(double var1, double var3) {
      return a.b(this.f, var1, var3);
   }

   public Collection c() {
      ArrayList var1 = new ArrayList();
      this.b(this.c, var1);
      return var1;
   }

   private void b(List var1, List var2) {
      int var5 = a.H;
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         c var4 = (c)var3.next();
         if(var4.e()) {
            var2.add(var4);
         }

         if(!var4.l().isEmpty()) {
            this.b(var4.l(), var2);
            if(var5 != 0) {
               break;
            }
         }
      }

   }

   public void a(y.d.r var1) {
      int var8;
      label37: {
         var8 = a.H;
         if(var1 == null) {
            this.e = a.x();
            if(var8 == 0) {
               break label37;
            }
         }

         this.e = var1;
      }

      s var2 = new s();
      a.a(this.f, var2);
      a.b(this.f, var2);
      double var3 = var2.b + var2.d;
      double var5 = var2.a + var2.c;
      Iterator var7 = this.l().iterator();

      while(true) {
         if(var7.hasNext()) {
            var3 += ((c)var7.next()).g();
            if(var8 != 0) {
               break;
            }

            if(var8 == 0) {
               continue;
            }
         }

         var7 = this.o().iterator();
         break;
      }

      while(true) {
         if(var7.hasNext()) {
            var5 += ((f)var7.next()).g();
            if(var8 != 0) {
               break;
            }

            if(var8 == 0) {
               continue;
            }
         }

         a.c(this.f, var3, var5);
         break;
      }

   }

   public y.d.r d() {
      return this.e;
   }

   public f m() {
      return this.a(this.a.size());
   }

   public f a(int var1) {
      boolean var2 = a.c(this.f);
      if(var2) {
         a.a(this.f, false);
      }

      r var8;
      try {
         s var3 = new s();
         a.a(this.f, var3);
         double var4 = a.b(this.f);
         r var6 = new r(this.f, this.f.p(), this.f.q(), this.f.r());
         this.a.add(var1, var6);
         r.a(var6, this);
         s var7 = new s();
         a.a(this.f, var7);
         a.c(this.f, this.a().getWidth() + var7.b - var3.b + var7.d - var3.d, var4 + var6.g());
         var8 = var6;
      } finally {
         if(var2) {
            a.a(this.f, var2);
         }

      }

      return var8;
   }

   public List o() {
      return this.b;
   }

   public c j() {
      return this.d(this.c.size());
   }

   public c d(int var1) {
      boolean var2 = a.c(this.f);
      if(var2) {
         a.a(this.f, false);
      }

      t var8;
      try {
         s var3 = new s();
         a.b(this.f, var3);
         double var4 = a.a(this.f);
         t var6 = new t(this.f, this.f.m(), this.f.n(), this.f.o());
         this.c.add(var1, var6);
         t.a(var6, this);
         s var7 = new s();
         a.b(this.f, var7);
         a.c(this.f, var4 + var6.g(), this.a().getHeight() + var7.a - var3.a + var7.c - var3.c);
         var8 = var6;
      } finally {
         if(var2) {
            a.a(this.f, var2);
         }

      }

      return var8;
   }

   public List l() {
      return this.d;
   }

   static List a(j var0) {
      return var0.a;
   }

   static List b(j var0) {
      return var0.c;
   }
}
