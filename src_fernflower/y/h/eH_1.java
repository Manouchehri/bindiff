package y.h;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.FlatteningPathIterator;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import y.h.eI;
import y.h.eJ;
import y.h.eK;
import y.h.eL;
import y.h.eM;
import y.h.eN;
import y.h.eO;
import y.h.eP;
import y.h.fj;

public class eH implements Shape {
   private int a;
   private eM b;
   private eM c;
   private int d;
   private int e;
   private int f;
   private long g;
   private eM h;
   private eM i;
   private eM j;
   private AffineTransform k;
   private int l;

   public eI a() {
      return this.b;
   }

   public void a(PathIterator var1) {
      boolean var4 = fj.z;
      double[] var2 = new double[6];

      while(!var1.isDone()) {
         int var3 = var1.currentSegment(var2);
         switch(var3) {
         case 4:
            this.b();
            if(!var4) {
               break;
            }
         case 1:
            this.b(var2[0], var2[1]);
            if(!var4) {
               break;
            }
         case 0:
            this.a(var2[0], var2[1]);
            if(!var4) {
               break;
            }
         case 2:
            this.a(var2[0], var2[1], var2[2], var2[3]);
            if(!var4) {
               break;
            }
         case 3:
            this.a(var2[0], var2[1], var2[2], var2[3], var2[4], var2[5]);
         }

         var1.next();
         if(var4) {
            break;
         }
      }

   }

   public eI a(double var1, double var3, double var5, double var7, eI var9) {
      eK var10 = this.e();
      var10.a = var1;
      var10.b = var3;
      var10.c = var5;
      var10.d = var7;
      this.a(var10, (eM)var9);
      return var10;
   }

   public eI a(double var1, double var3, eI var5) {
      ++this.e;
      eN var6 = this.d();
      var6.a = 0;
      var6.b = var1;
      var6.c = var3;
      this.a(var6, (eM)var5);
      return var6;
   }

   public eI b(double var1, double var3, eI var5) {
      eN var6 = this.d();
      var6.a = 1;
      var6.b = var1;
      var6.c = var3;
      this.a(var6, (eM)var5);
      return var6;
   }

   public eI a(double var1, double var3) {
      ++this.e;
      eN var5 = this.d();
      var5.a = 0;
      var5.b = var1;
      var5.c = var3;
      this.a((eM)var5);
      return var5;
   }

   public eI b(double var1, double var3) {
      eN var5 = this.d();
      var5.a = 1;
      var5.b = var1;
      var5.c = var3;
      this.a((eM)var5);
      return var5;
   }

   public eI b() {
      ++this.f;
      eO var1 = new eO();
      this.a((eM)var1);
      return var1;
   }

   public eI a(double var1, double var3, double var5, double var7, double var9, double var11) {
      eL var13 = this.f();
      var13.a = var1;
      var13.b = var3;
      var13.c = var5;
      var13.d = var7;
      var13.e = var9;
      var13.f = var11;
      this.a((eM)var13);
      ++this.d;
      return var13;
   }

   public eI a(double var1, double var3, double var5, double var7) {
      eK var9 = this.e();
      var9.a = var1;
      var9.b = var3;
      var9.c = var5;
      var9.d = var7;
      this.a((eM)var9);
      ++this.d;
      return var9;
   }

   private eN d() {
      boolean var3 = fj.z;
      if(this.h != null) {
         while(true) {
            if(this.h != null && !(this.h instanceof eN)) {
               eM var2 = this.h;
               this.h = this.h.g;
               var2.g = null;
               var2.h = null;
               if(var2 instanceof eK) {
                  var2.g = this.i;
                  this.i = var2;
                  if(!var3) {
                     continue;
                  }
               }

               if(!(var2 instanceof eL)) {
                  continue;
               }

               var2.g = this.j;
               this.j = var2;
               if(var3) {
                  break;
               }

               if(!var3) {
                  continue;
               }
            }

            if(this.h != null) {
               eN var1 = (eN)this.h;
               this.h = var1.g;
               var1.g = null;
               var1.h = null;
               return var1;
            }
            break;
         }
      }

      return new eN();
   }

   private eK e() {
      eK var1;
      if(this.i != null) {
         var1 = (eK)this.i;
         this.i = var1.g;
         var1.g = null;
         var1.h = null;
         if(!fj.z) {
            return var1;
         }
      }

      var1 = new eK();
      return var1;
   }

   private eL f() {
      eL var1;
      if(this.j != null) {
         var1 = (eL)this.j;
         this.j = var1.g;
         var1.g = null;
         var1.h = null;
         if(!fj.z) {
            return var1;
         }
      }

      var1 = new eL();
      return var1;
   }

   public void c() {
      if(this.c != null) {
         if(this.a > this.d + this.f) {
            this.c.g = this.h;
            this.h = this.b;
         }

         ++this.g;
         this.b = this.c = null;
         this.a = 0;
         this.d = 0;
         this.f = 0;
         this.e = 0;
      }
   }

   private void a(eM var1, eM var2) {
      label19: {
         boolean var4 = fj.z;
         if(var2 == null) {
            this.a(var1);
            if(!var4) {
               break label19;
            }
         }

         ++this.g;
         eM var3 = var2.h;
         var2.h = var1;
         var1.g = var2;
         var1.h = var3;
         if(var3 != null) {
            var3.g = var1;
            if(!var4) {
               break label19;
            }
         }

         this.b = var1;
      }

      ++this.a;
   }

   private void a(eM var1) {
      label11: {
         ++this.g;
         var1.g = null;
         if(this.c == null) {
            this.b = var1;
            this.a = 1;
            if(!fj.z) {
               break label11;
            }
         }

         ++this.a;
         this.c.g = var1;
         var1.h = this.c;
      }

      this.c = var1;
   }

   public PathIterator getPathIterator(AffineTransform var1) {
      if(var1 == null) {
         return (PathIterator)(this.k != null?new eJ(this.b, var1, this.l):new eP(this.b, this.l));
      } else if(this.k != null) {
         AffineTransform var2 = (AffineTransform)this.k.clone();
         var2.preConcatenate(var1);
         return new eJ(this.b, var2, this.l);
      } else {
         return new eJ(this.b, var1, this.l);
      }
   }

   public PathIterator getPathIterator(AffineTransform var1, double var2) {
      return (PathIterator)(this.d > 0?new FlatteningPathIterator(this.getPathIterator(var1), var2):this.getPathIterator(var1));
   }

   public boolean contains(Rectangle2D var1) {
      return this.contains(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight());
   }

   public boolean contains(Point2D var1) {
      return this.contains(var1.getX(), var1.getY());
   }

   public boolean contains(double var1, double var3) {
      return this.f == 0?false:(new Area(this)).contains(var1, var3);
   }

   public boolean contains(double var1, double var3, double var5, double var7) {
      return (new Area(this)).contains(var1, var3, var5, var7);
   }

   public Rectangle getBounds() {
      return this.getBounds2D().getBounds();
   }

   public Rectangle2D getBounds2D() {
      return (new Area(this)).getBounds2D();
   }

   public boolean intersects(Rectangle2D var1) {
      return this.intersects(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight());
   }

   public boolean intersects(double var1, double var3, double var5, double var7) {
      return (new Area(this)).intersects(var1, var3, var5, var7);
   }
}
