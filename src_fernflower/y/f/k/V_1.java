package y.f.k;

import java.util.ArrayList;
import java.util.List;
import y.f.k.P;
import y.f.k.Y;

abstract class V {
   protected List a = new ArrayList();
   protected P b;

   protected V(P var1) {
      this.b = var1;
   }

   void a(Y var1) {
      if(!var1.a()) {
         throw new IllegalArgumentException("RoutingBound is not complete " + var1);
      } else {
         this.a.add(var1);
      }
   }

   Y a(int var1) {
      return (Y)this.a.get(var1);
   }

   private Y e(int var1, boolean var2) {
      Y var3 = this.a(var1);
      if(var2) {
         var3 = var3.a(20.0D);
      }

      return var3;
   }

   void b(int var1) {
      this.b(this.e(var1, false));
   }

   void a(int var1, boolean var2) {
      this.b(this.e(var1, var2));
   }

   void b(Y var1) {
      this.b(var1.c());
   }

   void c(int var1) {
      this.c(this.e(var1, false));
   }

   void b(int var1, boolean var2) {
      this.c(this.e(var1, var2));
   }

   void c(Y var1) {
      this.b(var1.d());
   }

   void d(int var1) {
      this.d(this.e(var1, false));
   }

   void c(int var1, boolean var2) {
      this.d(this.e(var1, var2));
   }

   void d(Y var1) {
      this.a(var1.g());
   }

   void e(int var1) {
      this.e(this.e(var1, false));
   }

   void d(int var1, boolean var2) {
      this.e(this.e(var1, var2));
   }

   void e(Y var1) {
      this.a(var1.f());
   }

   private void a(double var1) {
      this.b.a(this.a(), var1);
   }

   private void b(double var1) {
      this.b.a(var1, this.b());
   }

   protected double a() {
      return this.b.b();
   }

   protected double b() {
      return this.b.c();
   }
}
