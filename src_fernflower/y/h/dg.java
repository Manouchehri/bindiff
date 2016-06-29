package y.h;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.Icon;
import y.h.fL;
import y.h.fj;

public class dg extends fL {
   Icon a = null;
   float b;
   float c;

   public dg() {
   }

   public dg(fL var1) {
      super(var1);
      if(var1 instanceof dg) {
         dg var2 = (dg)var1;
         this.a = var2.a;
      }

   }

   public fL a() {
      return new dg(this);
   }

   public void a(Rectangle2D var1, fj var2) {
      double var3 = this.b();
      double var5 = this.c();
      double var7 = this.a((fj)var2) - var3 / 2.0D;
      double var9 = this.b(var2) - var5 / 2.0D;
      var1.add(var7, var9);
      var1.add(var7 + var3, var9 + var5);
      var1.add(var7, var9 + var5);
      var1.add(var7 + var3, var9);
   }

   public boolean a(fj var1, double var2, double var4, double var6, double var8, Point2D var10) {
      if(var1.findIntersection(var2, var4, var6, var8, var10)) {
         double var11 = Math.max(this.b(), this.c());
         double var13 = var6 - var10.getX();
         double var15 = var8 - var10.getY();
         double var17 = var13 * var13 + var15 * var15;
         if(var17 > 0.0D) {
            var17 = Math.sqrt(var17);
            var13 = var13 * var11 / var17;
            var15 = var15 * var11 / var17;
            var10.setLocation(var10.getX() + var13, var10.getY() + var15);
            this.b = (float)(var13 / 2.0D);
            this.c = (float)(var15 / 2.0D);
         }

         return true;
      } else {
         return false;
      }
   }

   public void a(Graphics2D var1, fj var2) {
      boolean var4 = fj.z;
      if(this.a != null) {
         Point2D var3;
         label19: {
            if(this.f.getSourcePort() == this) {
               var3 = this.f.getSourceIntersection();
               if(!var4) {
                  break label19;
               }
            }

            var3 = this.f.getTargetIntersection();
         }

         this.a.paintIcon((Component)null, var1, (int)(var3.getX() - this.b() / 2.0D - (double)this.b), (int)(var3.getY() - this.c() / 2.0D - (double)this.c));
         if(!this.f.isSelected()) {
            return;
         }

         super.a(var1, var2);
         if(!var4) {
            return;
         }
      }

      super.a(var1, var2);
   }

   double b() {
      return this.a != null?(double)this.a.getIconWidth():1.0D;
   }

   double c() {
      return this.a != null?(double)this.a.getIconHeight():1.0D;
   }

   public boolean a(double var1, double var3) {
      Point2D var5;
      boolean var11;
      label46: {
         var11 = fj.z;
         if(this.f.getSourcePort() == this) {
            var5 = this.f.getSourceIntersection();
            if(!var11) {
               break label46;
            }
         }

         var5 = this.f.getTargetIntersection();
      }

      double var6 = var5.getX() - (double)this.b;
      double var8 = var5.getY() - (double)this.c;
      if(var6 - this.b() / 2.0D <= var1 && var6 + this.b() / 2.0D >= var1 && var8 - this.c() / 2.0D <= var3 && var8 + this.c() / 2.0D >= var3) {
         return true;
      } else if(!this.f.isSelected()) {
         return false;
      } else {
         fj var10;
         label38: {
            if(this.f.getSourcePort() == this) {
               var10 = this.f.getSourceRealizer();
               if(!var11) {
                  break label38;
               }
            }

            var10 = this.f.getTargetRealizer();
         }

         var6 = this.a((fj)var10);
         var8 = this.b(var10);
         return var6 - this.b() / 2.0D <= var1 && var6 + this.b() / 2.0D >= var1 && var8 - this.c() / 2.0D <= var3 && var8 + this.c() / 2.0D >= var3;
      }
   }

   public void a(ObjectOutputStream var1) {
      var1.writeByte(0);
      super.a(var1);
      if(this.a != null && this.a instanceof Serializable) {
         var1.writeBoolean(true);
         var1.writeObject(this.a);
         if(!fj.z) {
            return;
         }
      }

      var1.writeBoolean(false);
   }

   public void a(ObjectInputStream var1) {
      switch(var1.readByte()) {
      case 0:
         super.a(var1);
         if(var1.readBoolean()) {
            this.a = (Icon)var1.readObject();
            if(fj.z) {
               throw new y.e.a();
            }
         }

         return;
      default:
         throw new y.e.a();
      }
   }

   public String toString() {
      return "InterfacePort: (" + this.g() + ',' + this.h() + ')';
   }
}
