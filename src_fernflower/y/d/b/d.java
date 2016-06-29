package y.d.b;

import java.util.Comparator;
import y.d.b.a;
import y.d.b.b;
import y.d.b.c;
import y.d.b.e;
import y.d.b.f;
import y.d.b.g;
import y.d.b.h;
import y.d.b.i;
import y.d.b.j;
import y.d.b.k;
import y.d.b.m;
import y.d.b.t;
import y.d.b.y;
import y.d.b.z;

public class d extends c {
   private static d i = new d();
   public static int b = 0;
   public static int c = 0;
   public static int d = 0;
   public static int e = 0;
   protected boolean f = true;
   protected boolean g = true;
   protected static final double h = Math.pow(0.5D, 52.0D);
   private Comparator j = new h(this);
   private Comparator k = new g(this);
   private Comparator l = new e(this);
   private Comparator m = new j(this);
   private Comparator n = new f(this);
   private Comparator o = new k(this);
   private Comparator p = new i(this);

   public static d a() {
      return i;
   }

   public Object c(Object var1, Object var2) {
      return new m((b)var1, (b)var2, this);
   }

   public boolean d(Object var1, Object var2) {
      a var3 = (a)var1;
      return var3.b(var2) > 0;
   }

   public boolean b(Object var1, Object var2) {
      m var3 = (m)var1;
      b var4 = (b)var2;
      return var3.b(var4);
   }

   public boolean e(Object var1, Object var2) {
      m var3 = (m)var1;
      b var4 = (b)var2;
      return var3.a(var4);
   }

   public Object f(Object var1, Object var2) {
      m var3 = (m)var1;
      m var4 = (m)var2;
      return var3.b(var4);
   }

   public Object g(Object var1, Object var2) {
      m var3 = (m)var1;
      m var4 = (m)var2;
      return var3.a(var4);
   }

   public Object c(Object var1) {
      return ((m)var1).a();
   }

   public Object d(Object var1) {
      return ((m)var1).b();
   }

   public z e(Object var1) {
      return ((b)var1).a();
   }

   public z f(Object var1) {
      return ((b)var1).b();
   }

   public z g(Object var1) {
      return ((b)var1).c();
   }

   public double h(Object var1) {
      return ((b)var1).d();
   }

   public double i(Object var1) {
      return ((b)var1).e();
   }

   public double j(Object var1) {
      return ((b)var1).f();
   }

   public z k(Object var1) {
      return new y(this.h(var1) / this.j(var1));
   }

   public z l(Object var1) {
      return new y(this.i(var1) / this.j(var1));
   }

   public Comparator b() {
      return this.p;
   }

   public double h(Object var1, Object var2) {
      t var3 = (t)var1;
      t var4 = (t)var2;
      return var3.a(var4);
   }

   public Object i(Object var1, Object var2) {
      b var3 = (b)var1;
      b var4 = (b)var2;
      return var4.a(var3);
   }

   public Comparator c() {
      return this.f?this.j:this.k;
   }

   public Comparator d() {
      return this.f?this.l:this.m;
   }

   public Comparator e() {
      return this.f?this.n:this.o;
   }

   public int c(Object var1, Object var2, Object var3) {
      if(this.g) {
         ++e;
         double var4 = this.h(var1);
         double var6 = this.i(var1);
         double var8 = this.j(var1);
         double var10 = this.h(var2);
         double var12 = this.i(var2);
         double var14 = this.j(var2);
         double var16 = this.h(var3);
         double var18 = this.i(var3);
         double var20 = this.j(var3);
         double var22 = var6 * var14;
         double var24 = var12 * var8;
         double var26 = var4 * var20;
         double var28 = var16 * var8;
         double var30 = var4 * var14;
         double var32 = var10 * var8;
         double var34 = var6 * var20;
         double var36 = var18 * var8;
         double var38 = (var30 - var32) * (var34 - var36) - (var22 - var24) * (var26 - var28);
         var22 = Math.abs(var22);
         var24 = Math.abs(var24);
         var26 = Math.abs(var26);
         var28 = Math.abs(var28);
         var30 = Math.abs(var30);
         var32 = Math.abs(var32);
         var34 = Math.abs(var34);
         var36 = Math.abs(var36);
         double var40 = 40.0D * ((var22 + var24) * (var26 + var28) + (var30 + var32) * (var34 + var36)) * h;
         if(var38 > var40) {
            return 1;
         }

         if(var38 < -var40) {
            return -1;
         }

         if(var40 < 1.0D) {
            return 0;
         }

         --e;
      }

      return this.d(var1, var2, var3);
   }

   protected int j(Object var1, Object var2) {
      m var3 = (m)var1;
      m var4 = (m)var2;
      z var5 = var3.c();
      z var6 = var4.c();
      z var7 = var3.d();
      z var8 = var4.d();
      z var9 = var5.a();
      boolean var10 = var3.equals(var9);
      boolean var11 = var4.equals(var9);
      if(!var11 && !var10) {
         z var12 = var7.c(var6).b(var8.c(var5));
         int var13 = var12.c();
         return var5.c() * var6.c() < 0?-var13:var13;
      } else {
         return var11 && var10?0:(var11?-1:1);
      }
   }

   protected int d(Object var1, Object var2, Object var3) {
      ++d;
      z var4 = this.e(var1);
      z var5 = this.f(var1);
      z var6 = this.g(var1);
      z var7 = this.e(var2);
      z var8 = this.f(var2);
      z var9 = this.g(var2);
      z var10 = this.e(var3);
      z var11 = this.f(var3);
      z var12 = this.g(var3);
      z var13 = b(a(var7, var6), a(var4, var9));
      z var14 = b(a(var8, var6), a(var5, var9));
      z var15 = b(a(var14, b(a(var4, var12), a(var10, var6))), a(var13, b(a(var5, var12), a(var11, var6))));
      return var15.c();
   }

   protected int k(Object var1, Object var2) {
      ++b;
      z var3 = a(this.e(var1), this.g(var2));
      z var4 = a(this.e(var2), this.g(var1));
      return var3.f(var4) < 0?-1:(var3.f(var4) > 0?1:0);
   }

   protected int l(Object var1, Object var2) {
      ++b;
      z var3 = a(this.f(var1), this.g(var2));
      z var4 = a(this.f(var2), this.g(var1));
      return var3.f(var4) < 0?-1:(var3.f(var4) > 0?1:0);
   }

   protected int m(Object var1, Object var2) {
      ++b;
      z var3 = a(this.e(var1), this.g(var2));
      z var4 = a(this.e(var2), this.g(var1));
      if(var3.f(var4) < 0) {
         return -1;
      } else if(var3.f(var4) > 0) {
         return 1;
      } else {
         z var5 = a(this.f(var1), this.g(var2));
         z var6 = a(this.f(var2), this.g(var1));
         return var5.f(var6) < 0?-1:(var5.f(var6) > 0?1:0);
      }
   }

   private static z a(z var0, z var1) {
      return var0.c(var1);
   }

   private static z b(z var0, z var1) {
      return var0.b(var1);
   }
}
