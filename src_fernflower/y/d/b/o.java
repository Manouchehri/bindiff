package y.d.b;

import java.util.Comparator;
import y.d.b.c;
import y.d.b.l;
import y.d.b.p;
import y.d.b.q;
import y.d.b.r;
import y.d.b.s;
import y.d.b.y;
import y.d.b.z;

public class o extends c implements l {
   private static final o b = new o();
   private Comparator c = new p();
   private Comparator d = new r();
   private Comparator e = new s();

   public Object a(double var1, double var3) {
      return new y.d.t(var1, var3);
   }

   public Object a(z var1, z var2) {
      return new y.d.t(var1.e(), var2.e());
   }

   public z k(Object var1) {
      return new y(((y.d.t)var1).a());
   }

   public z l(Object var1) {
      return new y(((y.d.t)var1).b());
   }

   public Object c(Object var1, Object var2) {
      return new y.d.m((y.d.t)var1, (y.d.t)var2);
   }

   public boolean e(Object var1, Object var2) {
      y.d.m var3 = (y.d.m)var1;
      y.d.t var4 = (y.d.t)var2;
      return var3.a(var4);
   }

   public Object c(Object var1) {
      y.d.m var2 = (y.d.m)var1;
      return var2.c();
   }

   public Object d(Object var1) {
      y.d.m var2 = (y.d.m)var1;
      return var2.d();
   }

   public Object f(Object var1, Object var2) {
      y.d.m var3 = (y.d.m)var1;
      y.d.m var4 = (y.d.m)var2;
      y.d.a var5 = new y.d.a(var3.c(), var3.d());
      y.d.a var6 = new y.d.a(var4.c(), var4.d());
      return y.d.a.a(var5, var6);
   }

   public Object g(Object var1, Object var2) {
      y.d.m var3 = (y.d.m)var1;
      y.d.m var4 = (y.d.m)var2;
      return y.d.m.a(var3, var4);
   }

   public Comparator b() {
      return new q();
   }

   public Object i(Object var1, Object var2) {
      y.d.t var3 = (y.d.t)var1;
      y.d.t var4 = (y.d.t)var2;
      return new y.d.z(var4, var3);
   }

   public double h(Object var1, Object var2) {
      y.d.z var3 = (y.d.z)var1;
      y.d.z var4 = (y.d.z)var2;
      return y.d.z.d(var3, var4);
   }

   public Comparator c() {
      return this.c;
   }

   public Comparator d() {
      return this.d;
   }

   public Comparator e() {
      return this.e;
   }

   public int c(Object var1, Object var2, Object var3) {
      y.d.t var4 = (y.d.t)var1;
      y.d.t var5 = (y.d.t)var2;
      y.d.t var6 = (y.d.t)var3;
      return this.a(var4.a(), var4.b(), var5.a(), var5.b(), var6.a(), var6.b());
   }

   public int a(double var1, double var3, double var5, double var7, double var9, double var11) {
      var5 -= var1;
      var7 -= var3;
      var9 -= var1;
      var11 -= var3;
      double var13 = var9 * var7 - var11 * var5;
      return var13 < 0.0D?1:(var13 > 0.0D?-1:0);
   }
}
