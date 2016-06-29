package y.f;

public final class y {
   public static final y a = new y(0);
   public static final y b = new y(1);
   public static final y c = new y(2);
   public static final y d = new y(3);
   private final int e;

   private y(int var1) {
      this.e = var1;
   }

   public y a() {
      switch(this.e) {
      case 0:
         return b;
      case 1:
         return c;
      case 2:
         return d;
      case 3:
         return a;
      default:
         throw new IllegalArgumentException("Invalid direction: " + this.e);
      }
   }

   public y b() {
      switch(this.e) {
      case 0:
         return d;
      case 1:
         return a;
      case 2:
         return b;
      case 3:
         return c;
      default:
         throw new IllegalArgumentException("Invalid direction: " + this.e);
      }
   }

   public y c() {
      switch(this.e) {
      case 0:
         return c;
      case 1:
         return d;
      case 2:
         return a;
      case 3:
         return b;
      default:
         throw new IllegalArgumentException("Invalid direction: " + this.e);
      }
   }

   public boolean d() {
      return this.e == 1 || this.e == 3;
   }

   public boolean e() {
      return this.e == 0 || this.e == 2;
   }

   public int f() {
      return this.e;
   }

   public String toString() {
      switch(this.e) {
      case 0:
         return "^";
      case 1:
         return ">";
      case 2:
         return "v";
      case 3:
         return "<";
      default:
         throw new IllegalArgumentException("Invalid direction: " + this.e);
      }
   }
}
