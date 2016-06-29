package y.f.i;

abstract class R implements Comparable, y.g.g {
   private byte a;
   private double b;

   protected R(byte var1, double var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(double var1) {
      this.b = var1;
   }

   public void a(byte var1) {
      this.a = var1;
   }

   public int compareTo(Object var1) {
      R var2 = (R)var1;
      int var3 = y.g.e.a(this.b, var2.j());
      if(var3 != 0) {
         return var3;
      } else {
         switch(this.k()) {
         case 0:
            switch(var2.k()) {
            case 0:
               return 0;
            case 1:
               return 1;
            case 2:
               return -1;
            default:
               return 0;
            }
         case 1:
            switch(var2.k()) {
            case 0:
               return -1;
            case 1:
               return 0;
            case 2:
               return 1;
            default:
               return 0;
            }
         case 2:
            switch(var2.k()) {
            case 0:
               return 1;
            case 1:
               return -1;
            case 2:
               return 0;
            default:
               return 0;
            }
         default:
            return 0;
         }
      }
   }

   public double j() {
      return this.b;
   }

   public byte k() {
      return this.a;
   }
}
