package y.h;

public class gv {
   private final double a;
   private final double b;
   private final double c;
   private final int d;
   private final byte e;
   private final boolean f;
   private y.d.m g;

   gv(double var1, double var3) {
      this(0, 0.0D, var1, false, (byte)0, var3);
   }

   public gv(int var1, double var2, double var4, boolean var6, byte var7, double var8) {
      this.d = var1;
      this.a = var2;
      this.b = Math.abs(var4);
      this.f = var6;
      this.e = var7;
      this.c = var8;
   }

   public int a() {
      return this.d;
   }

   public double b() {
      return this.a;
   }

   public double c() {
      return this.b;
   }

   public boolean d() {
      return this.f;
   }

   public byte e() {
      return this.e;
   }

   public double f() {
      return this.c;
   }

   void a(double var1, double var3, double var5, double var7) {
      this.g = new y.d.m(new y.d.t(var1, var3), new y.d.t(var5, var7));
   }

   y.d.m g() {
      return this.g;
   }
}
