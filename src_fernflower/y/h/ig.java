package y.h;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;
import javax.swing.JComponent;
import y.h.fj;

class ig implements LayoutManager {
   static final Object a = "LayoutManager.CENTER_KEY";
   static final Object b = "LayoutManager.LOCATION_KEY";
   static final Object c = "LayoutManager.DIMENSION_KEY";

   public void addLayoutComponent(String var1, Component var2) {
   }

   public void removeLayoutComponent(Component var1) {
   }

   public Dimension preferredLayoutSize(Container var1) {
      return new Dimension(1, 1);
   }

   public Dimension minimumLayoutSize(Container var1) {
      return new Dimension(1, 1);
   }

   public void layoutContainer(Container var1) {
      boolean var13 = fj.z;
      Object var2;
      synchronized(var2 = var1.getTreeLock()) {
         int var3 = 0;

         Object var10000;
         while(true) {
            if(var3 < var1.getComponentCount()) {
               Component var4 = var1.getComponent(var3);
               var10000 = var4;
               if(var13) {
                  break;
               }

               if(var4 instanceof JComponent) {
                  JComponent var5 = (JComponent)var4;
                  Object var6 = var5.getClientProperty(b);
                  if(var6 instanceof Point) {
                     Point var7;
                     Dimension var9;
                     label41: {
                        var7 = (Point)var6;
                        Dimension var8 = (Dimension)var5.getClientProperty(c);
                        var9 = var4.getPreferredSize();
                        if(var8 != null) {
                           var9.width = var8.width = Math.max(var9.width, var8.width);
                           var9.height = var8.height = Math.max(var9.height, var8.height);
                           if(!var13) {
                              break label41;
                           }
                        }

                        var5.putClientProperty(c, var9);
                     }

                     if(var4.isVisible()) {
                        label59: {
                           if(Boolean.TRUE.equals(var5.getClientProperty(a))) {
                              int var10 = var7.x - var9.width / 2;
                              int var11 = var7.y - var9.height / 2;
                              var4.setBounds(var10, var11, var9.width, var9.height);
                              if(!var13) {
                                 break label59;
                              }
                           }

                           var4.setBounds(var7.x, var7.y, var9.width, var9.height);
                        }
                     }
                  }
               }

               ++var3;
               if(!var13) {
                  continue;
               }
            }

            var10000 = var2;
            break;
         }

      }
   }
}
