package y.h;

import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import y.h.aB;
import y.h.fL;
import y.h.fj;
import y.h.hC;
import y.h.ij;
import y.h.x;

public class g extends aB {
   private float b;
   private float c;
   private float d;
   private float e;
   private float f;
   private float g;
   private float h;
   private float i;
   private float j;
   private float k;
   private float l;
   private float m;
   private float n;
   private float o;
   private byte p;
   x a;

   public g() {
      this((byte)1);
   }

   public g(byte var1) {
      this.d();
      this.p = var1;
   }

   public void clearBends() {
   }

   public g(aB var1) {
      boolean var3 = fj.z;
      super(var1);
      if(var1 instanceof g) {
         label16: {
            g var2 = (g)var1;
            this.p = var2.a();
            this.f = var2.b();
            this.g = var2.c();
            if(var2.bendCount() != 1) {
               this.a = new x(this, 0.0D, 0.0D);
               if(!var3) {
                  break label16;
               }
            }

            this.a = new x(this, var2.a.b(), var2.a.c());
            this.b = var2.b;
            this.d = var2.d;
            this.c = var2.c;
            this.e = var2.e;
            this.h = var2.h;
            this.i = var2.i;
            this.j = var2.j;
            this.k = var2.k;
            this.m = var2.m;
            this.l = var2.l;
            this.n = var2.n;
            this.o = var2.o;
         }

         this.bends.clear();
         this.bends.b(this.a);
         if(!var3) {
            return;
         }
      }

      this.d();
   }

   public aB createCopy(aB var1) {
      return new g(var1);
   }

   private void d() {
      this.f = 1.0F;
      this.g = 30.0F;
      this.a = new x(this, 0.0D, 0.0D);
      this.bends.clear();
      this.bends.b(this.a);
      this.p = 1;
   }

   public void a(byte var1) {
      if(this.p != var1) {
         this.p = var1;
         this.e();
         this.setDirty();
      }

   }

   public byte a() {
      return this.p;
   }

   public float b() {
      return this.f;
   }

   public float c() {
      return this.g;
   }

   public x createBend(double var1, double var3, x var5, int var6) {
      return null;
   }

   public void reInsertBend(x var1, x var2, int var3) {
   }

   public x insertBend(double var1, double var3) {
      return null;
   }

   public x removeBend(x var1) {
      return null;
   }

   public int getMinBendCount() {
      return 1;
   }

   public void bendChanged(x var1, double var2, double var4) {
      boolean var11 = fj.z;
      if(var1.d()) {
         if(!this.getTargetRealizer().isSelected() && !this.getSourceRealizer().isSelected()) {
            double var6 = Line2D.ptLineDist((double)this.b, (double)this.c, (double)this.d, (double)this.e, this.a.b(), this.a.c());
            if(Double.isNaN(var6)) {
               var6 = (double)((float)Math.sqrt(((double)this.b - this.a.b()) * ((double)this.b - this.a.b()) + ((double)this.c - this.a.c()) * ((double)this.c - this.a.c())));
            }

            int var8 = Line2D.relativeCCW((double)this.b, (double)this.c, (double)this.d, (double)this.e, this.a.b(), this.a.c());
            double var9 = (double)((float)Math.sqrt((double)(this.j * this.j + this.k * this.k)));
            switch(this.p) {
            case 0:
               if(var8 != 0) {
                  this.g = (float)var8 * (float)var6;
                  if(!var11) {
                     break;
                  }
               }

               this.g = (float)var6;
               if(!var11) {
                  break;
               }
            case 1:
               if(var9 > 0.0D) {
                  this.f = (float)var8 * (float)(4.0D * var6 / var9);
               }
            }

            this.e();
         }
      }
   }

   private void e() {
      boolean var7 = fj.z;
      if(this.getEdge() != null && this.getEdge().a() != null) {
         fj var1 = this.getSourceRealizer();
         fj var2 = this.getTargetRealizer();
         fL var3 = this.getSourcePort();
         fL var4 = this.getTargetPort();
         this.b = (float)var3.a(var1);
         this.c = (float)var3.b(var1);
         this.d = (float)var4.a(var2);
         this.e = (float)var4.b(var2);
         this.j = this.d - this.b;
         this.k = this.e - this.c;
         this.h = this.b + this.j / 2.0F;
         this.i = this.c + this.k / 2.0F;
         switch(this.p) {
         case 1:
            this.m = this.k * this.f / 4.0F;
            this.l = -this.j * this.f / 4.0F;
            this.g = (float)Math.sqrt((double)(this.m * this.m + this.l * this.l));
            if(this.f >= 0.0F) {
               break;
            }

            this.g = -this.g;
            if(!var7) {
               break;
            }
         case 0:
            label17: {
               double var5 = Math.sqrt((double)(this.j * this.j + this.k * this.k));
               if(var5 > 0.0D) {
                  this.f = (float)((double)this.g / var5);
                  this.m = this.k * this.f;
                  this.l = -this.j * this.f;
                  this.f *= 4.0F;
                  if(!var7) {
                     break label17;
                  }
               }

               this.m = 0.0F;
               this.l = 0.0F;
            }
         }

         this.a.a = (double)(this.h + this.m);
         this.a.b = (double)(this.i + this.l);
         this.n = (float)(this.a.b() + (double)this.m);
         this.o = (float)(this.a.c() + (double)this.l);
      }
   }

   protected byte calculatePath(Point2D var1, Point2D var2) {
      boolean var6 = fj.z;
      this.e();
      GeneralPath var3 = new GeneralPath(1, 5);
      var3.moveTo(this.b, this.c);
      var3.quadTo(this.n, this.o, this.d, this.e);
      PathIterator var4 = var3.getPathIterator((AffineTransform)null, 1.0D);
      float[] var5 = hC.a().c;
      var4.currentSegment(var5);
      var4.next();
      this.path.reset();
      this.path.moveTo(var5[0], var5[1]);

      g var10000;
      while(true) {
         if(!var4.isDone()) {
            var4.currentSegment(var5);
            var4.next();
            var10000 = this;
            if(var6) {
               break;
            }

            this.path.lineTo(var5[0], var5[1]);
            if(!var6) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      return ij.a(var10000, this.path, this.path = new GeneralPath(1, this.bendCount() + 4), var1, var2);
   }

   public void write(ObjectOutputStream var1) {
      var1.writeByte(1);
      super.write(var1);
      var1.writeByte(this.p);
      var1.writeFloat(this.f);
      var1.writeFloat(this.g);
   }

   public void read(ObjectInputStream var1) {
      boolean var3 = fj.z;
      byte var2;
      switch(var1.readByte()) {
      case 0:
         var1.readByte();
         super.read(var1);
         var2 = var1.readByte();
         this.f = var1.readFloat();
         this.g = var1.readFloat();
         this.a(var2);
         if(!var3) {
            break;
         }
      case 1:
         super.read(var1);
         var2 = var1.readByte();
         this.f = var1.readFloat();
         this.g = var1.readFloat();
         this.a(var2);
         if(var3) {
            throw new y.e.a();
         }
         break;
      default:
         throw new y.e.a();
      }

      this.e();
      this.setDirty();
   }
}
