package y.f;

import y.f.X;
import y.f.aE;

public class ax {
   private static final ax[] c = new ax[256];
   private static final ax[] d = new ax[256];
   private double e;
   private double f;
   private boolean g;
   private int h;
   private double i;
   public static final Object a = "y.layout.PortCandidate.SOURCE_PCLIST_DPKEY";
   public static final Object b = "y.layout.PortCandidate.TARGET_PCLIST_DPKEY";
   private static final byte[] j = new byte[]{(byte)0, (byte)2, (byte)1, (byte)3, (byte)4, (byte)6, (byte)5, (byte)7, (byte)8, (byte)10, (byte)9, (byte)11, (byte)12, (byte)14, (byte)13, (byte)15};
   private static final byte[] k = new byte[]{(byte)0, (byte)4, (byte)8, (byte)12, (byte)2, (byte)6, (byte)10, (byte)14, (byte)1, (byte)5, (byte)9, (byte)13, (byte)3, (byte)7, (byte)11, (byte)15};
   private static final byte[] l = new byte[]{(byte)0, (byte)8, (byte)4, (byte)12, (byte)1, (byte)9, (byte)5, (byte)13, (byte)2, (byte)10, (byte)6, (byte)14, (byte)3, (byte)11, (byte)7, (byte)15};

   protected ax(double var1, double var3, boolean var5, int var6, double var7) {
      this.e = var1;
      this.f = var3;
      this.g = var5;
      this.h = var6 & 255;
      this.i = var7;
   }

   protected ax(int var1) {
      this(0.0D, 0.0D, false, var1, 0.0D);
   }

   protected ax(int var1, double var2) {
      this(0.0D, 0.0D, false, var1, var2);
   }

   public boolean a(int var1) {
      return (this.h & var1) != 0;
   }

   public int a() {
      return this.h;
   }

   public boolean b() {
      return this.g;
   }

   public double c() {
      return this.e;
   }

   public double d() {
      return this.f;
   }

   public static ax b(int var0) {
      return a(var0, 0.0D);
   }

   public static ax a(int var0, double var1) {
      int var3 = var0 & 255;
      ax var4;
      if(var1 == 0.0D) {
         var4 = c[var3];
         if(var4 == null) {
            var4 = new ax(var0);
            c[var3] = var4;
         }

         return var4;
      } else if(var1 == 1.0D) {
         var4 = d[var3];
         if(var4 == null) {
            var4 = new ax(var0);
            var4.i = 1.0D;
            d[var3] = var4;
         }

         return var4;
      } else {
         return new ax(var0, var1);
      }
   }

   public static ax a(double var0, double var2, int var4) {
      return a(var0, var2, var4, 0.0D);
   }

   public static ax a(double var0, double var2, int var4, double var5) {
      return new ax(var0, var2, true, var4, var5);
   }

   public static ax a(aE var0) {
      return var0.g()?b((int)15):b((int)var0.b());
   }

   public int hashCode() {
      return (this.g?4096:0) + this.h + (int)(Double.doubleToLongBits(this.i) + Double.doubleToLongBits(this.e) + Double.doubleToLongBits(this.f));
   }

   public aE e() {
      boolean var2 = X.j;
      byte var1;
      switch(this.h) {
      case 1:
      case 2:
      case 4:
      case 8:
         var1 = (byte)this.h;
         if(!var2) {
            break;
         }
      case 16:
         var1 = 2;
         if(!var2) {
            break;
         }
      case 32:
         var1 = 1;
         if(!var2) {
            break;
         }
      case 64:
         var1 = 4;
         if(!var2) {
            break;
         }
      case 128:
         var1 = 8;
         if(!var2) {
            break;
         }
      default:
         var1 = 0;
      }

      return aE.a(var1, this.b());
   }

   public aE a(byte var1) {
      boolean var3 = X.j;
      byte var2;
      switch(this.b(var1)) {
      case 1:
      case 2:
      case 4:
      case 8:
         var2 = (byte)this.h;
         if(!var3) {
            break;
         }
      case 16:
         var2 = 2;
         if(!var3) {
            break;
         }
      case 32:
         var2 = 1;
         if(!var3) {
            break;
         }
      case 64:
         var2 = 4;
         if(!var3) {
            break;
         }
      case 128:
         var2 = 8;
         if(!var3) {
            break;
         }
      default:
         var2 = 0;
      }

      return aE.a(var2, this.b());
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof ax)) {
         return false;
      } else if(var1.getClass() != this.getClass()) {
         return false;
      } else {
         ax var2 = (ax)var1;
         return var2.g == this.g && var2.e == this.e && var2.i == this.i && var2.f == this.f && var2.h == this.h;
      }
   }

   public double f() {
      return this.i;
   }

   public int b(byte var1) {
      boolean var5 = X.j;
      byte[] var2;
      switch(var1) {
      case 0:
      default:
         return this.a();
      case 2:
         var2 = j;
         if(!var5) {
            break;
         }
      case 1:
         var2 = k;
         if(!var5) {
            break;
         }
      case 3:
         var2 = l;
      }

      int var3 = this.a();
      int var4 = var3 & 15;
      var3 &= -16;
      return var3 | var2[var4];
   }

   public double a(byte var1, int var2) {
      switch(var1) {
      case 0:
      default:
         if((var2 & 1) != 0) {
            return -this.c();
         }

         return this.c();
      case 1:
         if((var2 & 8) != 0) {
            return this.d();
         }

         return -this.d();
      case 2:
         if((var2 & 4) != 0) {
            return this.c();
         }

         return -this.c();
      case 3:
         return (var2 & 2) != 0?-this.d():this.d();
      }
   }

   public double b(byte var1, int var2) {
      switch(var1) {
      case 0:
      default:
         return this.d();
      case 1:
         return this.c();
      case 2:
         return -this.d();
      case 3:
         return -this.c();
      }
   }

   public double c(byte var1) {
      switch(var1) {
      case 0:
      default:
         return this.c();
      case 1:
         return -this.d();
      case 2:
         return this.c();
      case 3:
         return this.d();
      }
   }

   public double d(byte var1) {
      switch(var1) {
      case 0:
      default:
         return this.d();
      case 1:
         return this.c();
      case 2:
         return -this.d();
      case 3:
         return -this.c();
      }
   }

   public String toString() {
      StringBuffer var1;
      label43: {
         var1 = new StringBuffer(50);
         var1.append("PortCandidate(");
         var1.append('(').append(this.e).append(':').append(this.f).append(')');
         if(this.g) {
            var1.append("[fixed]");
            if(!X.j) {
               break label43;
            }
         }

         var1.append("[free]");
      }

      if(this.a((int)1)) {
         var1.append(" NORTH");
      }

      if(this.a((int)4)) {
         var1.append(" EAST");
      }

      if(this.a((int)2)) {
         var1.append(" SOUTH");
      }

      if(this.a((int)8)) {
         var1.append(" WEST");
      }

      if(this.a((int)32)) {
         var1.append(" AGAINST_THE_FLOW");
      }

      if(this.a((int)16)) {
         var1.append(" WITH_THE_FLOW");
      }

      if(this.a((int)64)) {
         var1.append(" LEFT_IN_FLOW");
      }

      if(this.a((int)128)) {
         var1.append(" RIGHT_IN_FLOW");
      }

      var1.append(", cost=");
      var1.append(this.i);
      var1.append(')');
      return var1.toString();
   }
}
