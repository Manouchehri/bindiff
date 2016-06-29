package y.f.f.d;

import y.g.al;

class O {
   private String c;
   private al d = new al();
   int a;
   int b;

   public void a() {
      this.a = 0;
      this.b = 0;
      this.c = "0";
      this.d.a();
      this.d.e();
   }

   public void b() {
      this.c = this.d.toString();
   }

   public String toString() {
      return "\nMinCostFlow-Statistics:\n   Time: " + this.c + "\n   Augmentations : " + this.a + "\n   ExtractMins: " + this.b;
   }
}
