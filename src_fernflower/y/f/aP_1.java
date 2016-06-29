package y.f;

public class aP {
   private int a;
   private double b;
   private double c;
   private y.d.z d;
   private byte e;

   public aP(int var1, double var2, y.d.z var4, byte var5, double var6) {
      this.a = var1;
      this.b = var2;
      this.d = new y.d.z(var4);
      this.e = var5;
      this.c = var6;
   }

   public int a() {
      return this.a;
   }

   public double b() {
      return this.b;
   }

   public y.d.z c() {
      return this.d;
   }

   public byte d() {
      return this.e;
   }

   public double e() {
      return this.c;
   }
}
