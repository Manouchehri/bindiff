package y.f.i.a;

import java.util.HashMap;
import y.f.i.a.P;
import y.f.i.a.Q;
import y.f.i.a.S;
import y.f.i.a.bc;

public class R {
   private static int a = 0;
   private final int b;
   private final Q c;
   private final HashMap d;
   private final y.d.y e;
   private bc f;
   private HashMap g;

   public R(y.d.y var1, Q var2) {
      this.e = var1;
      this.b = a++;
      this.c = var2;
      this.d = new HashMap();
   }

   public R(double var1, double var3, double var5, double var7, Q var9) {
      this(new y.d.y(var1, var3, var5, var7), var9);
   }

   public Object a(Object var1, Object var2) {
      return this.d.put(var1, var2);
   }

   public Object a(Object var1) {
      return this.d.get(var1);
   }

   public void a() {
      this.d.clear();
   }

   bc b() {
      return this.f;
   }

   void a(bc var1) {
      this.f = var1;
   }

   HashMap c() {
      return this.g;
   }

   void a(HashMap var1) {
      this.g = var1;
   }

   public Q d() {
      return this.c;
   }

   public int e() {
      return this.b;
   }

   static void f() {
      a = 0;
   }

   public y.d.y g() {
      return this.e;
   }

   public double h() {
      return this.e.c();
   }

   public double i() {
      return this.e.d();
   }

   public double j() {
      return this.e.c() + this.e.a();
   }

   public double k() {
      return this.e.d() + this.e.b();
   }

   public double l() {
      return this.e.a();
   }

   public double m() {
      return this.e.b();
   }

   public P a(S var1) {
      return var1 == S.a?new P(this.h(), this.j(), this.i(), false):(var1 == S.b?new P(this.h(), this.j(), this.k(), false):(var1 == S.d?new P(this.i(), this.k(), this.h(), true):(var1 == S.c?new P(this.i(), this.k(), this.j(), true):null)));
   }
}
