package y.h;

import java.util.EventObject;
import y.h.dB;
import y.h.gZ;

public class dD extends EventObject {
   private final dB a;
   private final gZ b;
   private final int c;
   private final double d;
   private final double e;
   private final boolean f;

   public dD(dB var1, gZ var2, int var3, double var4, double var6, boolean var8) {
      super(var1);
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var6;
      this.f = var8;
   }

   public dB a() {
      return this.a;
   }

   public gZ b() {
      return this.b;
   }

   public double c() {
      return this.d;
   }

   public double d() {
      return this.e;
   }

   public boolean e() {
      return this.f;
   }
}
