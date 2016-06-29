package y.h;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import y.h.aA;
import y.h.aB;
import y.h.bu;
import y.h.d;
import y.h.eR;
import y.h.eU;
import y.h.fj;
import y.h.gU;
import y.h.gZ;
import y.h.gg;
import y.h.x;
import y.h.y;

public class gf extends d {
   public static final int TYPE_NODE = 1;
   public static final int TYPE_EDGE = 2;
   public static final int TYPE_BEND = 8;
   public static final int TYPE_NODE_LABEL = 16;
   public static final int TYPE_EDGE_LABEL = 32;
   public static final int TYPE_NODE_PORT = 64;
   private static final int sm = 9;
   private static final int rm = 48;
   private boolean tm;
   private boolean qm;

   public gf(gU var1) {
      super(var1);
   }

   public gf() {
   }

   public boolean isExtendedTypeSelectionEnabled() {
      return this.tm;
   }

   public void setExtendedTypeSelectionEnabled(boolean var1) {
      this.tm = var1;
   }

   public boolean isMixedSelectionEnabled() {
      return this.qm;
   }

   public void setMixedSelectionEnabled(boolean var1) {
      this.qm = var1;
   }

   protected void selectionBoxAction(Rectangle var1, boolean var2) {
      bu var3 = this.getGraph2D();
      var3.r();

      try {
         this.b(var3, var1, var2);
      } finally {
         var3.s();
      }

      var3.T();
   }

   private void b(bu var1, Rectangle var2, boolean var3) {
      boolean var4 = fj.z;
      if(this.isExtendedTypeSelectionEnabled()) {
         this.selectTypes(var1, this.adjustTypes(this.getSelectedTypes(var1)), var2, var3);
         if(!var4) {
            return;
         }
      }

      if(!var3) {
         this.unselectAll(var1);
         this.c(var2);
         if(!var4) {
            return;
         }
      }

      if(var1.K().f()) {
         this.b(var2);
         if(!var4) {
            return;
         }
      }

      this.c(var2);
   }

   void c(Rectangle2D var1) {
      boolean var5 = fj.z;
      bu var2 = this.getGraph2D();
      y.c.x var3 = var2.o();

      while(var3.f()) {
         y.c.q var4 = var3.e();
         if(this.belongsToSelection(var4, var1)) {
            this.setSelected(var2, var4, true);
         }

         var3.g();
         if(var5) {
            break;
         }
      }

      y var6 = var2.D();

      while(var6.f()) {
         x var7 = var6.a();
         if(this.belongsToSelection(var7, var1)) {
            this.setSelected(var2, var7, true);
         }

         var6.g();
         if(var5) {
            break;
         }
      }

   }

   void b(Rectangle2D var1) {
      boolean var5 = fj.z;
      bu var2 = this.getGraph2D();
      y.c.e var3 = var2.p();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         if(this.belongsToSelection(var4, var1)) {
            this.setSelected(var2, var4, true);
         }

         var3.g();
         if(var5) {
            break;
         }
      }

   }

   protected boolean belongsToSelection(y.c.q var1, Rectangle2D var2) {
      bu var3 = this.getGraph2D();
      fj var4 = this.getGraph2D().t(var1);
      y.h.a.v var5 = y.h.a.v.a((y.c.i)var3);
      return var5 != null && var5.k(var1)?var2.contains(var4.getX(), var4.getY(), var4.getWidth(), var4.getHeight()):var4.isInBox(var2.getX(), var2.getY(), var2.getWidth(), var2.getHeight());
   }

   protected boolean belongsToSelection(y.c.d var1, Rectangle2D var2) {
      aB var3 = this.getGraph2D().i(var1);
      return var3.pathIntersects(var2, false);
   }

   protected boolean belongsToSelection(x var1, Rectangle2D var2) {
      return var1.a(var2.getX(), var2.getY(), var2.getWidth(), var2.getHeight());
   }

   protected boolean belongsToSelection(gZ var1, Rectangle2D var2) {
      return this.b(var1.getBox(), var2);
   }

   protected boolean belongsToSelection(eU var1, Rectangle2D var2) {
      return this.b(var1.k(), var2);
   }

   private boolean b(y.d.y var1, Rectangle2D var2) {
      double var3 = var1.c() + var1.a() * 0.5D;
      double var5 = var1.d() + var1.b() * 0.5D;
      return var2.getX() <= var3 && var3 <= var2.getX() + var2.getWidth() && var2.getY() <= var5 && var5 <= var2.getY() + var2.getHeight();
   }

   protected int adjustTypes(int var1) {
      boolean var3 = fj.z;
      int var2;
      if(this.isMixedSelectionEnabled()) {
         var2 = var1;
         if(var1 == 0) {
            var2 = 9;
            if(!var3) {
               return var2;
            }
         }

         if((var2 & 9) == var2) {
            var2 = 9;
         }

         return var2;
      } else {
         var2 = var1;
         if(var1 == 0) {
            var2 = 9;
         }

         label42: {
            if((var2 & 2) == 2) {
               var2 = 2;
               if(!var3) {
                  break label42;
               }
            }

            if((var2 & 9) != 0) {
               var2 = 9;
               if(!var3) {
                  break label42;
               }
            }

            var2 = b(var2);
         }

         if((var2 & 48) != 0) {
            var2 = 48;
         }

         return var2;
      }
   }

   private static int b(int var0) {
      return var0 & -var0;
   }

   protected int getSelectedTypes(bu var1) {
      boolean var4 = fj.z;
      int var2 = 0;
      y.c.x var3 = var1.o();

      while(var3.f()) {
         var2 |= this.getSelectedNodeTypes(var1, var3.e());
         var3.g();
         if(var4) {
            break;
         }
      }

      y.c.e var5 = var1.p();

      int var10000;
      while(true) {
         if(var5.f()) {
            var10000 = var2 | this.getSelectedEdgeTypes(var1, var5.a());
            if(var4) {
               break;
            }

            var2 = var10000;
            var5.g();
            if(!var4) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   protected int getSelectedEdgeTypes(bu var1, y.c.d var2) {
      boolean var7 = fj.z;
      int var3 = 0;
      if(this.isSelected(var1, var2)) {
         var3 |= 2;
      }

      int var10000;
      aB var4;
      label56: {
         var4 = var1.i(var2);
         if((var3 & 32) != 32 && var4.labelCount() > 0) {
            int var5 = 0;
            int var6 = var4.labelCount();

            while(var5 < var6) {
               var10000 = this.isSelected(var1, (gZ)var4.getLabel(var5));
               if(var7) {
                  break label56;
               }

               if(var10000 != 0) {
                  var3 |= 32;
                  if(!var7) {
                     break;
                  }
               }

               ++var5;
               if(var7) {
                  break;
               }
            }
         }

         var10000 = var3 & 8;
      }

      if(var10000 != 8 && var4.bendCount() > 0) {
         y var8 = var4.bends();

         while(var8.f()) {
            var10000 = this.isSelected(var1, var8.a());
            if(var7) {
               return var10000;
            }

            if(var10000 != 0) {
               var3 |= 8;
               if(!var7) {
                  break;
               }
            }

            var8.g();
            if(var7) {
               break;
            }
         }
      }

      var10000 = var3;
      return var10000;
   }

   protected int getSelectedNodeTypes(bu var1, y.c.q var2) {
      boolean var7 = fj.z;
      int var3 = 0;
      if(this.isSelected(var1, var2)) {
         var3 |= 1;
      }

      int var10000;
      fj var4;
      label52: {
         var4 = var1.t(var2);
         if((var3 & 16) != 16 && var4.labelCount() > 0) {
            int var5 = 0;
            int var6 = var4.labelCount();

            while(var5 < var6) {
               var10000 = this.isSelected(var1, (gZ)var4.getLabel(var5));
               if(var7) {
                  break label52;
               }

               if(var10000 != 0) {
                  var3 |= 16;
                  if(!var7) {
                     break;
                  }
               }

               ++var5;
               if(var7) {
                  break;
               }
            }
         }

         var10000 = var3 & 64;
      }

      if(var10000 != 64 && var4.portCount() > 0) {
         Iterator var8 = var4.ports();

         while(var8.hasNext()) {
            if(this.isSelected(var1, (eU)var8.next())) {
               var10000 = var3 | 64;
               if(var7) {
                  return var10000;
               }

               var3 = var10000;
               break;
            }
         }
      }

      var10000 = var3;
      return var10000;
   }

   protected void selectTypes(bu var1, int var2, Rectangle var3, boolean var4) {
      boolean var6 = fj.z;
      y.c.x var5 = var1.o();

      while(var5.f()) {
         this.selectNodeTypes(var1, var5.e(), var2, var3, var4);
         var5.g();
         if(var6) {
            break;
         }
      }

      y.c.e var7 = var1.p();

      while(var7.f()) {
         this.selectEdgeTypes(var1, var7.a(), var2, var3, var4);
         var7.g();
         if(var6) {
            break;
         }
      }

   }

   protected void selectEdgeTypes(bu var1, y.c.d var2, int var3, Rectangle var4, boolean var5) {
      boolean var14 = fj.z;
      boolean var6 = !var5;
      boolean var7 = (var3 & 2) == 2;
      boolean var8 = (var3 & 32) == 32;
      boolean var9 = (var3 & 8) == 8;
      if(var7) {
         label87: {
            if(this.belongsToSelection((y.c.d)var2, var4)) {
               this.setSelected(var1, var2, true);
               if(!var14) {
                  break label87;
               }
            }

            if(var6) {
               this.setSelected(var1, var2, false);
            }
         }
      }

      aB var10;
      boolean var10000;
      label82: {
         var10 = var1.i(var2);
         if(var8 && var10.labelCount() > 0) {
            int var11 = 0;
            int var12 = var10.labelCount();

            while(var11 < var12) {
               aA var13 = var10.getLabel(var11);
               var10000 = this.belongsToSelection((gZ)var13, var4);
               if(var14) {
                  break label82;
               }

               label75: {
                  if(var10000) {
                     this.setSelected(var1, (gZ)var13, true);
                     if(!var14) {
                        break label75;
                     }
                  }

                  if(var6) {
                     this.setSelected(var1, (gZ)var13, false);
                  }
               }

               ++var11;
               if(var14) {
                  break;
               }
            }
         }

         var10000 = var9;
      }

      if(var10000 && var10.bendCount() > 0) {
         y var15 = var10.bends();

         while(var15.f()) {
            label58: {
               x var16 = var15.a();
               if(this.belongsToSelection((x)var16, var4)) {
                  this.setSelected(var1, var16, true);
                  if(!var14) {
                     break label58;
                  }
               }

               if(var6) {
                  this.setSelected(var1, var16, false);
               }
            }

            var15.g();
            if(var14) {
               break;
            }
         }
      }

   }

   protected void selectNodeTypes(bu var1, y.c.q var2, int var3, Rectangle var4, boolean var5) {
      boolean var14 = fj.z;
      boolean var6 = !var5;
      boolean var7 = (var3 & 1) == 1;
      boolean var8 = (var3 & 16) == 16;
      boolean var9 = (var3 & 64) == 64;
      if(var7) {
         label87: {
            if(this.belongsToSelection((y.c.q)var2, var4)) {
               this.setSelected(var1, var2, true);
               if(!var14) {
                  break label87;
               }
            }

            if(var6) {
               this.setSelected(var1, var2, false);
            }
         }
      }

      fj var10;
      boolean var10000;
      label82: {
         var10 = var1.t(var2);
         if(var8 && var10.labelCount() > 0) {
            int var11 = 0;
            int var12 = var10.labelCount();

            while(var11 < var12) {
               eR var13 = var10.getLabel(var11);
               var10000 = this.belongsToSelection((gZ)var13, var4);
               if(var14) {
                  break label82;
               }

               label75: {
                  if(var10000) {
                     this.setSelected(var1, (gZ)var13, true);
                     if(!var14) {
                        break label75;
                     }
                  }

                  if(var6) {
                     this.setSelected(var1, (gZ)var13, false);
                  }
               }

               ++var11;
               if(var14) {
                  break;
               }
            }
         }

         var10000 = var9;
      }

      if(var10000 && var10.portCount() > 0) {
         Iterator var15 = var10.ports();

         while(true) {
            eU var16;
            do {
               if(!var15.hasNext()) {
                  return;
               }

               var16 = (eU)var15.next();
               if(!this.belongsToSelection((eU)var16, var4)) {
                  break;
               }

               this.setSelected(var1, var16, true);
            } while(!var14);

            if(var6) {
               this.setSelected(var1, var16, false);
               if(var14) {
                  break;
               }
            }
         }
      }

   }

   protected void unselectAll(bu var1) {
      var1.N();
   }

   protected void setSelected(bu var1, y.c.q var2, boolean var3) {
      if(var3) {
         gg.a(var1, var2);
         if(!fj.z) {
            return;
         }
      }

      gg.b(var1, var2);
   }

   protected void setSelected(bu var1, x var2, boolean var3) {
      var1.a(var2, var3);
   }

   protected void setSelected(bu var1, y.c.d var2, boolean var3) {
      var1.a(var2, var3);
   }

   protected void setSelected(bu var1, gZ var2, boolean var3) {
      var1.a(var2, var3);
   }

   protected void setSelected(bu var1, eU var2, boolean var3) {
      var1.a(var2, var3);
   }

   protected boolean isSelected(bu var1, x var2) {
      return var1.a(var2);
   }

   protected boolean isSelected(bu var1, gZ var2) {
      return var1.a(var2);
   }

   protected boolean isSelected(bu var1, y.c.d var2) {
      return var1.r(var2);
   }

   protected boolean isSelected(bu var1, y.c.q var2) {
      return var1.v(var2);
   }

   protected boolean isSelected(bu var1, eU var2) {
      return var1.a(var2);
   }
}
