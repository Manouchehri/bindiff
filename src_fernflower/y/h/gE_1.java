package y.h;

final class gE {
   float a;
   float b;
   float c;
   float d;

   public gE(float var1, float var2, float var3, float var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public float a(float var1) {
      return ((this.d * var1 + this.c) * var1 + this.b) * var1 + this.a;
   }
}
