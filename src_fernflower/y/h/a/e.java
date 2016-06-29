package y.h.a;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import y.h.aZ;
import y.h.bc;
import y.h.fj;
import y.h.gt;
import y.h.a.a;
import y.h.a.g;
import y.h.a.h;
import y.h.a.v;

public class e extends aZ implements h {
   private boolean w = true;
   private boolean A;
   private boolean B;
   private double C = 100.0D;
   private double D = 80.0D;
   private double E;
   private double F;
   private double G;
   private double H;
   private double I = 15.0D;
   private double J = 15.0D;
   private double K = 15.0D;
   private double L = 15.0D;
   private boolean M;
   private g N;

   public e() {
      this.a(true);
   }

   public e(fj var1) {
      super(var1);
      if(var1 instanceof e) {
         this.a((aZ)((e)var1));
      }

   }

   protected void a(aZ var1) {
      this.a(false);
      super.a(var1);
      if(var1 instanceof e) {
         e var2 = (e)var1;
         this.b(var2.getBorderInsets());
         this.a(var2.getMinimalInsets());
         this.a(var2.i());
         this.b(var2.j());
         this.setGroupClosed(var2.isGroupClosed());
         this.a(var2.g());
      }

   }

   public void calcUnionRect(Rectangle2D var1) {
      if(!this.M) {
         if(this.a.m != null) {
            this.b(true);

            try {
               this.M = true;
               this.a.m.c(this);
            } finally {
               this.M = false;
            }
         }

         super.calcUnionRect(var1);
      }
   }

   public boolean g() {
      return this.w;
   }

   public void a(boolean var1) {
      this.w = var1;
   }

   public boolean isGroupClosed() {
      return this.A;
   }

   public boolean h() {
      return this.B;
   }

   public void b(boolean var1) {
      this.B = var1;
   }

   public double i() {
      return this.C;
   }

   public void a(double var1) {
      this.C = var1;
   }

   public double j() {
      return this.D;
   }

   public void b(double var1) {
      this.D = var1;
   }

   public fj createCopy(fj var1) {
      return new e(var1);
   }

   public void setGroupClosed(boolean var1) {
      if(this.A != var1) {
         label23: {
            this.A = var1;
            if(var1) {
               gt var2 = this.getSizeConstraintProvider();
               if(var2 != null) {
                  double var3 = var2.getMinimumSize().a();
                  double var5 = var2.getMinimumSize().b();
                  if(this.C < var3) {
                     this.C = var3;
                  }

                  if(this.D < var5) {
                     this.D = var5;
                  }
               }

               super.setFrame(this.x, this.y, this.C, this.D);
               if(v.a == 0) {
                  break label23;
               }
            }

            this.C = this.width;
            this.D = this.height;
         }

         this.b(true);
         this.boundsChanged();
      }

   }

   public Double getBoundingBox() {
      if(this.h() && this.a.m != null) {
         this.a.m.c(this);
         this.boundsChanged();
      }

      return super.getBoundingBox();
   }

   public y.d.r getBorderInsets() {
      return new y.d.r(this.E, this.G, this.F, this.H);
   }

   public y.d.r getMinimalInsets() {
      return new y.d.r(this.I, this.K, this.J, this.L);
   }

   public a getAutoBoundsFeature() {
      if(this.a.m != null) {
         if(this.N == null) {
            this.N = new g(this);
         }

         return this.N;
      } else {
         this.N = null;
         return super.getAutoBoundsFeature();
      }
   }

   public void a(y.d.r var1) {
      this.J = var1.c;
      this.I = var1.a;
      this.K = var1.b;
      this.L = var1.d;
      if(this.a.m != null) {
         this.a.m.c(this);
      }

   }

   public void b(y.d.r var1) {
      this.E = var1.a;
      this.F = var1.c;
      this.H = var1.d;
      this.G = var1.b;
      if(this.a.m != null) {
         this.a.m.c(this);
      }

   }

   public void read(ObjectInputStream var1) {
      switch(var1.readByte()) {
      case 0:
         super.read(var1);
         this.w = var1.readBoolean();
         this.D = var1.readDouble();
         this.C = var1.readDouble();
         this.F = var1.readDouble();
         this.G = var1.readDouble();
         this.E = var1.readDouble();
         this.H = var1.readDouble();
         this.J = var1.readDouble();
         this.K = var1.readDouble();
         this.I = var1.readDouble();
         this.L = var1.readDouble();
         this.A = var1.readBoolean();
         if(v.a == 0) {
            return;
         }
      default:
         throw new y.e.a();
      }
   }

   public void write(ObjectOutputStream var1) {
      var1.writeByte(0);
      super.write(var1);
      var1.writeBoolean(this.w);
      var1.writeDouble(this.D);
      var1.writeDouble(this.C);
      var1.writeDouble(this.F);
      var1.writeDouble(this.G);
      var1.writeDouble(this.E);
      var1.writeDouble(this.H);
      var1.writeDouble(this.J);
      var1.writeDouble(this.K);
      var1.writeDouble(this.I);
      var1.writeDouble(this.L);
      var1.writeBoolean(this.A);
   }

   static boolean a(e var0) {
      return var0.w;
   }

   static bc b(e var0) {
      return var0.a;
   }

   static double a(e var0, double var1) {
      return var0.H = var1;
   }

   static double c(e var0) {
      return var0.x;
   }

   static double d(e var0) {
      return var0.width;
   }

   static double e(e var0) {
      return var0.x;
   }

   static double f(e var0) {
      return var0.width;
   }

   static double b(e var0, double var1) {
      return var0.E = var1;
   }

   static double g(e var0) {
      return var0.y;
   }

   static double h(e var0) {
      return var0.y;
   }

   static double c(e var0, double var1) {
      return var0.F = var1;
   }

   static double i(e var0) {
      return var0.y;
   }

   static double j(e var0) {
      return var0.height;
   }

   static double k(e var0) {
      return var0.y;
   }

   static double l(e var0) {
      return var0.height;
   }

   static double d(e var0, double var1) {
      return var0.G = var1;
   }

   static double m(e var0) {
      return var0.x;
   }

   static double n(e var0) {
      return var0.x;
   }

   static boolean a(e var0, boolean var1) {
      return var0.w = var1;
   }

   static bc o(e var0) {
      return var0.a;
   }

   static bc p(e var0) {
      return var0.a;
   }
}
