package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyGraphListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import y.h.aA;

public class InternalEditModeListener implements IZyEditModeListener {
   private final ListenerProvider m_graphListeners;

   public InternalEditModeListener(ListenerProvider var1) {
      this.m_graphListeners = var1;
   }

   public void edgeClicked(Object var1, MouseEvent var2, double var3, double var5) {
      Iterator var7 = this.m_graphListeners.iterator();

      while(var7.hasNext()) {
         IZyGraphListener var8 = (IZyGraphListener)var7.next();

         try {
            var8.edgeClicked(var1, var2, var3, var5);
         } catch (Exception var10) {
            var10.printStackTrace();
         }
      }

   }

   public void edgeLabelEntered(aA var1, MouseEvent var2) {
      Iterator var3 = this.m_graphListeners.iterator();

      while(var3.hasNext()) {
         IZyGraphListener var4 = (IZyGraphListener)var3.next();

         try {
            var4.edgeLabelEntered(var1, var2);
         } catch (Exception var6) {
            var6.printStackTrace();
         }
      }

   }

   public void edgeLabelLeft(aA var1) {
      Iterator var2 = this.m_graphListeners.iterator();

      while(var2.hasNext()) {
         IZyGraphListener var3 = (IZyGraphListener)var2.next();

         try {
            var3.edgeLabelExited(var1);
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      }

   }

   public void nodeClicked(Object var1, MouseEvent var2, double var3, double var5) {
      Iterator var7 = this.m_graphListeners.iterator();

      while(var7.hasNext()) {
         IZyGraphListener var8 = (IZyGraphListener)var7.next();

         try {
            var8.nodeClicked(var1, var2, var3, var5);
         } catch (Exception var10) {
            var10.printStackTrace();
         }
      }

   }

   public void nodeEntered(Object var1, MouseEvent var2) {
      Iterator var3 = this.m_graphListeners.iterator();

      while(var3.hasNext()) {
         IZyGraphListener var4 = (IZyGraphListener)var3.next();

         try {
            var4.nodeEntered(var1, var2);
         } catch (Exception var6) {
            var6.printStackTrace();
         }
      }

   }

   public void nodeHovered(Object var1, double var2, double var4) {
      Iterator var6 = this.m_graphListeners.iterator();

      while(var6.hasNext()) {
         IZyGraphListener var7 = (IZyGraphListener)var6.next();

         try {
            var7.nodeHovered(var1, var2, var4);
         } catch (Exception var9) {
            var9.printStackTrace();
         }
      }

   }

   public void nodeLeft(Object var1) {
      Iterator var2 = this.m_graphListeners.iterator();

      while(var2.hasNext()) {
         IZyGraphListener var3 = (IZyGraphListener)var2.next();

         try {
            var3.nodeLeft(var1);
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      }

   }

   public void proximityBrowserNodeClicked(ZyProximityNode var1, MouseEvent var2, double var3, double var5) {
      Iterator var7 = this.m_graphListeners.iterator();

      while(var7.hasNext()) {
         IZyGraphListener var8 = (IZyGraphListener)var7.next();

         try {
            var8.proximityBrowserNodeClicked(var1, var2, var3, var5);
         } catch (Exception var10) {
            var10.printStackTrace();
         }
      }

   }
}
