package y.f.f.d;

import y.f.f.d.p;

public class b {
   private p a;
   private p b;
   private int c;
   private y.f.f.b.o d;
   private int e;
   private boolean f = false;
   private boolean g = false;

   public b(p var1, p var2, int var3, y.f.f.b.o var4, int var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public int a() {
      return this.e;
   }

   public int b() {
      return this.c;
   }

   public y.f.f.b.o c() {
      return this.d;
   }

   public p d() {
      return this.a;
   }

   public p e() {
      return this.b;
   }

   public boolean f() {
      return this.f;
   }

   public void a(boolean var1) {
      this.f = var1;
   }

   public boolean g() {
      return this.g;
   }

   public void b(boolean var1) {
      this.g = var1;
   }

   public String toString() {
      String var1 = this.c == 1?"KONKAVE":"KONVEX";
      return "type=" + var1 + " dir=" + this.d;
   }
}
