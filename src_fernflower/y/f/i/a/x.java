package y.f.i.a;

import y.f.i.a.ab;
import y.f.i.a.ad;

public class x {
   private double a = 5.0D;
   private double b = 10.0D;
   private double c = 3.0D;
   private double d = 3.0D;
   private byte e = 0;
   private ad f = new ad();

   public double a() {
      return this.a;
   }

   public double b() {
      return this.b;
   }

   public double c() {
      return this.c;
   }

   public void a(double var1) {
      this.c = var1 < 0.0D?3.0D:var1;
   }

   public double d() {
      return this.d;
   }

   public byte e() {
      return this.e;
   }

   public void a(byte var1) {
      switch(var1) {
      case 0:
      case 1:
      case 2:
      case 3:
         this.e = var1;
         if(ab.a == 0) {
            break;
         }
      default:
         this.e = 0;
      }

   }

   public ad f() {
      return this.f;
   }

   public void a(ad var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("penaltySettings must not be null");
      } else {
         this.f = var1;
      }
   }
}
