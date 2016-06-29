package y.f.a;

import y.f.a.C;
import y.f.a.z;

class B implements y.d.o {
   private Object a;
   private y.d.o b;
   private byte c;
   private int d;
   private y.d.y e;
   private boolean f;
   private C g;
   private final z h;

   public B(z var1, Object var2, int var3, y.d.o var4, y.d.y var5, byte var6) {
      this.h = var1;
      this.e = null;
      this.g = null;
      this.d = var3;
      this.a = var2;
      this.b = var4;
      this.c = var6;
      if(var6 != 1) {
         this.e = var5;
      }

   }

   public B(z var1, Object var2, int var3, y.d.o var4, byte var5) {
      this.h = var1;
      this.e = null;
      this.g = null;
      this.d = var3;
      this.a = var2;
      this.b = var4;
      this.c = var5;
   }

   public B(z var1, Object var2, int var3, y.d.o var4, byte var5, C var6) {
      this.h = var1;
      this.e = null;
      this.g = null;
      this.d = var3;
      this.a = var2;
      this.b = var4;
      this.c = var5;
      if(var5 == 1) {
         this.g = var6;
      }

   }

   public boolean a() {
      return this.g != null;
   }

   public C b() {
      return this.g;
   }

   public void a(boolean var1) {
      this.f = var1;
   }

   public boolean c() {
      return this.f;
   }

   public void a(y.d.y var1) {
      this.e = var1;
   }

   public void a(y.d.o var1) {
      this.b = var1;
   }

   public y.d.y d() {
      return this.e;
   }

   public boolean e() {
      return this.c == 0;
   }

   public boolean f() {
      return this.c == 1;
   }

   public boolean g() {
      return this.c == 2;
   }

   public Object i() {
      return this.a;
   }

   public y.d.o j() {
      return this.b;
   }

   public y.d.y h() {
      return this.b.h();
   }

   public boolean equals(Object var1) {
      if(var1 instanceof B) {
         B var2 = (B)var1;
         return var2.d == this.d;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.d;
   }

   static int a(B var0) {
      return var0.d;
   }
}
