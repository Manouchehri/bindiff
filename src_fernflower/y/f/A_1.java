package y.f;

import y.f.X;
import y.f.aW;
import y.f.ae;
import y.f.ai;
import y.f.aj;
import y.f.ak;
import y.f.al;
import y.f.am;

public class A implements al {
   static final Integer[] a = new Integer[]{new Integer(1), new Integer(2), new Integer(4), new Integer(8), new Integer(16), new Integer(32), new Integer(64), new Integer(128), new Integer(256), new Integer(512), new Integer(1024), new Integer(2048), new Integer(4096), new Integer(8192), new Integer(16384), new Integer('耀'), new Integer(65536)};
   private static final Object b = new Integer(256);
   private static final Object c = new Integer(4);
   private static final Object d = new Integer(1);
   private static final Object e = new Integer(8);
   private double f;
   private final int g;

   public A() {
      this(130816, 4.0D);
   }

   public A(int var1, double var2) {
      this.f = var2;
      this.g = var1;
   }

   public int a() {
      return this.g;
   }

   public double b() {
      return this.f;
   }

   public void a(double var1) {
      this.f = var1;
   }

   public Object c() {
      return (this.g & 256) != 0?b:((this.g & 4) != 0?c:((this.g & 1) != 0?d:((this.g & 8) != 0?e:b)));
   }

   public boolean a(Object var1) {
      if(var1 instanceof Integer) {
         int var2 = ((Integer)var1).intValue();
         return (this.g & var2) != 0;
      } else {
         return false;
      }
   }

   public y.d.n a(y.d.q var1, am var2, Object var3) {
      return this.a(var1, var2, ((Integer)var3).intValue());
   }

   public y.c.D a(aj var1, am var2) {
      boolean var9 = X.j;
      y.c.D var3 = new y.c.D();
      y.d.y var4 = var1.getBox();
      int var5 = 0;

      while(var5 < a.length) {
         int var6 = a[var5].intValue();
         if((this.g & var6) != 0) {
            boolean var7 = false;
            switch(var6) {
            case 256:
            case 512:
            case 1024:
            case 2048:
            case 4096:
            case 8192:
            case 16384:
            case 32768:
            case 65536:
               var7 = true;
            default:
               y.d.n var8 = this.a(var4, var2, var6);
               var3.add(new ai(var8, a[var5], var1, var7));
            }
         }

         ++var5;
         if(var9) {
            break;
         }
      }

      return var3;
   }

   protected y.d.n a(y.d.q var1, am var2, int var3) {
      boolean var8 = X.j;
      double var4 = Double.NaN;
      double var6 = Double.NaN;
      switch(var3) {
      case 256:
         var4 = var2.getX() + (var2.getWidth() - var1.a()) / 2.0D;
         var6 = var2.getY() + (var2.getHeight() - var1.b()) / 2.0D;
         if(!var8) {
            break;
         }
      case 512:
         var4 = var2.getX() + (var2.getWidth() - var1.a()) / 2.0D;
         var6 = var2.getY() + (var2.getHeight() - var1.b()) - this.b();
         if(!var8) {
            break;
         }
      case 1024:
         var4 = var2.getX() + (var2.getWidth() - var1.a()) / 2.0D;
         var6 = var2.getY() + this.b();
         if(!var8) {
            break;
         }
      case 2048:
         var4 = var2.getX() + this.b();
         var6 = var2.getY() + (var2.getHeight() - var1.b()) / 2.0D;
         if(!var8) {
            break;
         }
      case 4096:
         var4 = var2.getX() + (var2.getWidth() - var1.a()) - this.b();
         var6 = var2.getY() + (var2.getHeight() - var1.b()) / 2.0D;
         if(!var8) {
            break;
         }
      case 8192:
         var4 = var2.getX() + this.b();
         var6 = var2.getY() + this.b();
         if(!var8) {
            break;
         }
      case 16384:
         var4 = var2.getX() + (var2.getWidth() - var1.a()) - this.b();
         var6 = var2.getY() + this.b();
         if(!var8) {
            break;
         }
      case 32768:
         var4 = var2.getX() + this.b();
         var6 = var2.getY() + (var2.getHeight() - var1.b()) - this.b();
         if(!var8) {
            break;
         }
      case 65536:
         var4 = var2.getX() + (var2.getWidth() - var1.a()) - this.b();
         var6 = var2.getY() + (var2.getHeight() - var1.b()) - this.b();
         if(!var8) {
            break;
         }
      case 1:
         var4 = var2.getX() + (var2.getWidth() - var1.a()) / 2.0D;
         var6 = var2.getY() - var1.b() - this.b();
         if(!var8) {
            break;
         }
      case 2:
         var4 = var2.getX() - var1.a() - this.b();
         var6 = var2.getY() - var1.b();
         if(!var8) {
            break;
         }
      case 4:
         var4 = var2.getX() + var2.getWidth() + this.b();
         var6 = var2.getY() - var1.b();
         if(!var8) {
            break;
         }
      case 8:
         var4 = var2.getX() + var2.getWidth() + this.b();
         var6 = var2.getY() + (var2.getHeight() - var1.b()) / 2.0D;
         if(!var8) {
            break;
         }
      case 16:
         var4 = var2.getX() - var1.a() - this.b();
         var6 = var2.getY() + (var2.getHeight() - var1.b()) / 2.0D;
         if(!var8) {
            break;
         }
      case 32:
         var4 = var2.getX() + (var2.getWidth() - var1.a()) / 2.0D;
         var6 = var2.getY() + var2.getHeight() + this.b();
         if(!var8) {
            break;
         }
      case 64:
         var4 = var2.getX() - var1.a() - this.b();
         var6 = var2.getY() + var2.getHeight();
         if(!var8) {
            break;
         }
      case 128:
         var4 = var2.getX() + var2.getWidth() + this.b();
         var6 = var2.getY() + var2.getHeight();
      }

      return new y.d.n(new y.d.t(var4, var6 + var1.b()), var1);
   }

   public Object a(y.d.n var1, am var2) {
      if(ae.a(var1)) {
         throw new IllegalArgumentException("Invalid label bounds: " + var1);
      } else {
         ak var3 = new ak();
         var3.a(var1);
         y.c.D var4 = this.a((aj)var3, var2);
         if(var4.isEmpty()) {
            return this.c();
         } else {
            y.d.t var5 = var1.k();
            return aW.a(var4, var5).b();
         }
      }
   }
}
