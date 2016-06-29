package y.f.i.a;

class bD {
   private int a;
   private final y.c.d b;
   private final y.c.d c;
   private Object d;

   bD(y.c.d var1, y.c.d var2, Object var3, int var4) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.a = var4;
   }

   public y.c.d a() {
      return this.c;
   }

   public y.c.d b() {
      return this.b;
   }

   public int c() {
      return this.a;
   }

   public void a(int var1) {
      this.a = var1;
   }

   public boolean a(bD var1) {
      return !this.d.equals(var1.d);
   }

   static Object b(bD var0) {
      return var0.d;
   }

   static y.c.d c(bD var0) {
      return var0.b;
   }

   static y.c.d d(bD var0) {
      return var0.c;
   }
}
