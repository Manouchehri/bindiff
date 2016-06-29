package y.f;

import y.f.X;

public class aG {
   private byte a;
   private byte b;
   private byte c;
   private double d;
   private byte e;
   private byte f;
   private byte g;
   private double h;
   private boolean i;
   private static final aG[] j = new aG[256];

   public aG() {
      this.a = 4;
      this.b = 8;
      this.c = 1;
      this.d = 0.0D;
      this.e = 1;
      this.f = 1;
      this.g = 1;
      this.h = -1.0D;
   }

   public aG(aG var1) {
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      this.e = var1.e;
      this.f = var1.f;
      this.g = var1.g;
      this.h = var1.h;
   }

   public byte a() {
      return this.a;
   }

   public void a(byte var1) {
      this.B();
      this.a = (byte)(var1 & 7);
   }

   public byte b() {
      return this.b;
   }

   public void b(byte var1) {
      this.B();
      this.b = (byte)(var1 & 56);
   }

   public byte c() {
      return this.c;
   }

   public void c(byte var1) {
      this.B();
      int var2 = var1 & 7;
      if(var2 == 0) {
         throw new IllegalArgumentException(Byte.toString(var1));
      } else {
         this.c = (byte)var2;
      }
   }

   public double d() {
      return this.d;
   }

   public void a(double var1) {
      this.B();
      this.d = b(var1);
   }

   private static double b(double var0) {
      return var0 - 6.283185307179586D * Math.floor(var0 / 6.283185307179586D);
   }

   public byte e() {
      return this.e;
   }

   public void d(byte var1) {
      this.B();
      int var2 = var1 & 3;
      if(var2 == 0) {
         throw new IllegalArgumentException(Byte.toString(var1));
      } else {
         this.e = (byte)var2;
      }
   }

   public byte f() {
      return this.f;
   }

   public void e(byte var1) {
      this.B();
      int var2 = var1 & 3;
      if(var2 == 0) {
         throw new IllegalArgumentException(Byte.toString(var1));
      } else {
         this.f = (byte)var2;
      }
   }

   public byte g() {
      return this.g;
   }

   public void f(byte var1) {
      this.B();
      int var2 = var1 & 3;
      if(var2 == 0) {
         throw new IllegalArgumentException(Byte.toString(var1));
      } else {
         this.g = (byte)var2;
      }
   }

   public double h() {
      return this.h;
   }

   private byte z() {
      byte var1 = this.a();
      return var1 == 0?7:var1;
   }

   public boolean i() {
      return (this.z() & 1) != 0;
   }

   public boolean j() {
      return (this.z() & 4) != 0;
   }

   public boolean k() {
      return (this.z() & 2) != 0;
   }

   private byte A() {
      byte var1 = this.b();
      return var1 == 0?56:var1;
   }

   public boolean l() {
      return (this.A() & 16) != 0;
   }

   public boolean m() {
      return (this.A() & 8) != 0;
   }

   public boolean n() {
      return (this.A() & 32) != 0;
   }

   public boolean o() {
      return (this.e() & 1) != 0;
   }

   public boolean p() {
      return (this.e() & 2) != 0;
   }

   public boolean q() {
      return (this.f() & 1) != 0;
   }

   public boolean r() {
      return (this.f() & 2) != 0;
   }

   public boolean s() {
      return (this.g() & 1) != 0;
   }

   public boolean t() {
      return (this.g() & 2) != 0;
   }

   public boolean u() {
      return (this.c() & 1) != 0;
   }

   public boolean v() {
      return (this.c() & 2) != 0;
   }

   public boolean w() {
      return (this.c() & 4) != 0;
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer();
      var1.append("placement=");
      this.a(var1, this.a());
      var1.append(", side=");
      this.b(var1, this.b());
      var1.append(", sideReference=");
      this.c(var1, this.c());
      var1.append(", angle=");
      var1.append(this.d());
      var1.append(", angleReference=");
      this.d(var1, this.e());
      var1.append(", angleRotation=");
      this.e(var1, this.f());
      var1.append(", angleOffset=");
      this.f(var1, this.g());
      var1.append(", distance=");
      var1.append(this.h());
      return var1.toString();
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         aG var2 = (aG)var1;
         return a(var2.d, this.d) != 0?false:(this.g != var2.g?false:(this.e != var2.e?false:(this.f != var2.f?false:(a(var2.h, this.h) != 0?false:(this.a != var2.a?false:(this.b != var2.b?false:this.c == var2.c))))));
      } else {
         return false;
      }
   }

   public int hashCode() {
      byte var1 = this.a;
      int var4 = 31 * var1 + this.b;
      var4 = 31 * var4 + this.c;
      long var2 = this.d != 0.0D?Double.doubleToLongBits(this.d):0L;
      var4 = 31 * var4 + (int)(var2 ^ var2 >>> 32);
      var4 = 31 * var4 + this.e;
      var4 = 31 * var4 + this.f;
      var4 = 31 * var4 + this.g;
      var2 = this.h != 0.0D?Double.doubleToLongBits(this.h):0L;
      var4 = 31 * var4 + (int)(var2 ^ var2 >>> 32);
      return var4;
   }

   private void a(StringBuffer var1, byte var2) {
      if(var2 == 0) {
         var1.append("anywhere");
         if(!X.j) {
            return;
         }
      }

      if((var2 & 1) != 0) {
         this.a(var1, "source");
      }

      if((var2 & 4) != 0) {
         this.a(var1, "center");
      }

      if((var2 & 2) != 0) {
         this.a(var1, "target");
      }

   }

   private void b(StringBuffer var1, byte var2) {
      if(var2 == 0) {
         var1.append("anywhere");
         if(!X.j) {
            return;
         }
      }

      if((var2 & 16) != 0) {
         this.a(var1, "left");
      }

      if((var2 & 8) != 0) {
         this.a(var1, "onEdge");
      }

      if((var2 & 32) != 0) {
         this.a(var1, "right");
      }

   }

   private void c(StringBuffer var1, byte var2) {
      if((var2 & 2) != 0) {
         this.a(var1, "absolute_left_in_north");
      }

   }

   private void d(StringBuffer var1, byte var2) {
      if((var2 & 1) != 0) {
         this.a(var1, "absolute");
      }

      if((var2 & 2) != 0) {
         this.a(var1, "relative_to_edge_flow");
      }

   }

   private void e(StringBuffer var1, byte var2) {
      if((var2 & 1) != 0) {
         this.a(var1, "co");
      }

      if((var2 & 2) != 0) {
         this.a(var1, "counter");
      }

   }

   private void f(StringBuffer var1, byte var2) {
      if((var2 & 1) != 0) {
         this.a(var1, "0");
      }

      if((var2 & 2) != 0) {
         this.a(var1, "180");
      }

   }

   private void a(StringBuffer var1, String var2) {
      if(var1.length() != 0 && var1.charAt(var1.length() - 1) != 61) {
         var1.append('|');
      }

      var1.append(var2);
   }

   public boolean x() {
      return this.i;
   }

   public void y() {
      this.i = true;
   }

   private void B() {
      if(this.x()) {
         throw new IllegalStateException("Immutable instance!");
      }
   }

   static int a(double var0, double var2) {
      if(var0 > var2) {
         return 1;
      } else if(var0 < var2) {
         return -1;
      } else {
         long var4 = Double.doubleToLongBits(var0);
         long var6 = Double.doubleToLongBits(var2);
         return var4 == var6?0:(var4 > var6?1:-1);
      }
   }

   public static aG g(byte var0) {
      aG[] var1 = j;
      synchronized(j) {
         int var2 = var0 & 255;
         aG var3 = j[var2];
         if(var3 == null) {
            var3 = h(var0);
            j[var2] = var3;
         }

         return var3;
      }
   }

   private static aG h(byte var0) {
      aG var1 = new aG();
      var1.a((byte)(var0 & 7));
      var1.b((byte)(var0 & 56));
      var1.y();
      return var1;
   }
}
