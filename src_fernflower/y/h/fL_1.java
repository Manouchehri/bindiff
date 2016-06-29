package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import y.h.aB;
import y.h.fj;
import y.h.hC;

public class fL {
   protected double d;
   protected double e;
   protected aB f;

   public fL() {
      this(0.0D, 0.0D);
   }

   public fL(double var1, double var3) {
      this.d = var1;
      this.e = var3;
   }

   public fL(fL var1) {
      this(var1.d, var1.e);
   }

   public fL a() {
      return new fL(this.d, this.e);
   }

   void a(aB var1) {
      this.f = var1;
   }

   public aB d() {
      return this.f;
   }

   public boolean a(fj var1, double var2, double var4, double var6, double var8, Point2D var10) {
      return var1.findIntersection(var2, var4, var6, var8, var10);
   }

   public void a(Graphics2D var1, fj var2) {
      if(aB.b(this.f, var1)) {
         Double var3 = hC.a().k;
         var3.width = var3.height = 6.0D;
         var3.x = this.a(var2) - 3.0D;
         var3.y = this.b(var2) - 3.0D;
         var1.setColor(Color.black);
         var1.fill(var3);
      }

   }

   protected void e() {
      if(this.f != null) {
         this.f.setDirty();
      }

   }

   public boolean a(double var1, double var3) {
      if(!this.f.isSelected()) {
         return false;
      } else {
         fj var5;
         label27: {
            if(this.f.getSourcePort() == this) {
               var5 = this.f.getSourceRealizer();
               if(!fj.z) {
                  break label27;
               }
            }

            var5 = this.f.getTargetRealizer();
         }

         double var6 = this.a(var5);
         double var8 = this.b(var5);
         return var6 - 3.0D <= var1 && var6 + 3.0D >= var1 && var8 - 3.0D <= var3 && var8 + 3.0D >= var3;
      }
   }

   y.d.t f() {
      fj var1;
      if(this.f.getSourcePort() == this) {
         var1 = this.f.getSourceRealizer();
         if(!fj.z) {
            return new y.d.t(this.a(var1), this.b(var1));
         }
      }

      var1 = this.f.getTargetRealizer();
      return new y.d.t(this.a(var1), this.b(var1));
   }

   public void a(Rectangle2D var1, fj var2) {
      var1.add(this.a(var2), this.b(var2));
   }

   public double g() {
      return this.d;
   }

   public double h() {
      return this.e;
   }

   public double a(fj var1) {
      return var1.getCenterX() + this.d;
   }

   public double b(fj var1) {
      return var1.getCenterY() + this.e;
   }

   public void b(double var1, double var3) {
      this.e();
      this.d = var1;
      this.e = var3;
   }

   public void a(ObjectOutputStream var1) {
      var1.writeByte(1);
      var1.writeFloat((float)this.d);
      var1.writeFloat((float)this.e);
   }

   public void a(ObjectInputStream var1) {
      boolean var2 = fj.z;
      switch(var1.readByte()) {
      case 0:
         var1.readByte();
         this.d = (double)var1.readFloat();
         this.e = (double)var1.readFloat();
         if(!var2) {
            break;
         }
      case 1:
         this.d = (double)var1.readFloat();
         this.e = (double)var1.readFloat();
         if(var2) {
            throw new y.e.a();
         }
         break;
      default:
         throw new y.e.a();
      }

   }

   public String toString() {
      return "Port: (" + this.g() + ',' + this.h() + ')';
   }
}
