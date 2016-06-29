package y.f.i.a;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import y.f.i.a.Q;
import y.f.i.a.R;
import y.f.i.a.V;
import y.f.i.a.Z;
import y.f.i.a.ab;
import y.f.i.a.ac;
import y.f.i.a.x;

public class aa {
   private final V a;
   private final Z b;
   private final double c;
   private final ac d;
   private y.c.f e;
   private y.c.d f;
   private Set g;
   private Set h;
   private List i;
   private List j;
   private R k;
   private R l;
   private x m;
   private long n;
   private long o;

   protected aa(V var1, Z var2) {
      this.a = var1;
      this.b = var2;
      y.d.y var3 = var2.c().r().b();
      this.c = var3.a() + var3.b();
      this.d = new ac(var2);
   }

   public V a() {
      return this.a;
   }

   public y.c.e b() {
      return this.e.a();
   }

   protected void a(y.c.f var1) {
      this.e = var1;
   }

   public y.c.d c() {
      return this.f;
   }

   protected void a(y.c.d var1) {
      this.f = var1;
      this.i = this.b.c().r().a(var1.c());
      this.g = new HashSet(this.i);
      this.k = null;
      this.j = this.b.c().r().a(var1.d());
      this.h = new HashSet(this.j);
      this.l = null;
      this.m = this.b.c().a(var1);
   }

   public x d() {
      return this.m;
   }

   public int e() {
      return this.i.size();
   }

   public void a(R var1) {
      if(this.g.add(var1)) {
         this.i.add(var1);
         this.k = null;
      }

   }

   public R a(int var1) {
      return (R)this.i.get(var1);
   }

   public boolean b(R var1) {
      return this.g.contains(var1);
   }

   public R f() {
      if(this.k == null) {
         this.k = this.a(this.i);
      }

      return this.k;
   }

   public void c(R var1) {
      if(this.h.add(var1)) {
         this.j.add(var1);
         this.l = null;
      }

   }

   public R b(int var1) {
      return (R)this.j.get(var1);
   }

   public boolean d(R var1) {
      return this.h.contains(var1);
   }

   public R g() {
      if(this.l == null) {
         this.l = this.a(this.j);
      }

      return this.l;
   }

   private R a(List var1) {
      int var12 = ab.a;
      double var2 = Double.MAX_VALUE;
      double var4 = Double.MAX_VALUE;
      double var6 = -1.7976931348623157E308D;
      double var8 = -1.7976931348623157E308D;
      Iterator var10 = var1.iterator();

      R var10000;
      while(true) {
         if(var10.hasNext()) {
            var10000 = (R)var10.next();
            if(var12 != 0) {
               break;
            }

            R var11 = var10000;
            var2 = Math.min(var2, var11.h());
            var6 = Math.max(var6, var11.j());
            var4 = Math.min(var4, var11.i());
            var8 = Math.max(var8, var11.k());
            if(var12 == 0) {
               continue;
            }
         }

         var10000 = new R(var2, var4, var6 - var2, var8 - var4, (Q)null);
         break;
      }

      return var10000;
   }

   double h() {
      return this.c;
   }

   public ac i() {
      return this.d;
   }

   void a(long var1) {
      this.n = var1;
   }

   long j() {
      return this.n;
   }

   void b(long var1) {
      this.o = var1;
   }

   long k() {
      return this.o;
   }
}
