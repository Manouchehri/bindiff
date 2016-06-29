package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.GuiHelper$ComponentFilter;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class GuiHelper implements WindowStateListener {
   public static final int DEFAULT_FONTSIZE = 12;
   public static final Font MONOSPACED_FONT = new Font("Monospaced", 0, 12);
   public static final Font DEFAULT_FONT = new Font("SansSerif", 0, 12);
   private static final GuiHelper instance = new GuiHelper();
   private Field metacityWindowManager = null;
   private Field awtWindowManager = null;
   private boolean needsWindowFix = false;

   private GuiHelper() {
      List var1 = Arrays.asList(new String[]{"gnome", "gnome-shell", "mate", "cinnamon"});
      String var2 = System.getenv("DESKTOP_SESSION");
      if(var2 != null && var1.contains(var2.toLowerCase())) {
         try {
            Class var3 = Class.forName("sun.awt.X11.XWM");
            this.awtWindowManager = var3.getDeclaredField("awt_wmgr");
            this.awtWindowManager.setAccessible(true);
            Field var4 = var3.getDeclaredField("OTHER_WM");
            var4.setAccessible(true);
            if(this.awtWindowManager.get((Object)null).equals(var4.get((Object)null))) {
               this.metacityWindowManager = var3.getDeclaredField("METACITY_WM");
               this.metacityWindowManager.setAccessible(true);
               this.needsWindowFix = true;
            }
         } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException | ClassNotFoundException var5) {
            ;
         }
      }

   }

   public void windowStateChanged(WindowEvent var1) {
      try {
         this.awtWindowManager.set((Object)null, this.metacityWindowManager.get((Object)null));
      } catch (IllegalAccessException | IllegalArgumentException var3) {
         ;
      }

   }

   public static final void applyWindowFix(Window var0) {
      if(instance.needsWindowFix) {
         var0.removeWindowStateListener(instance);
         var0.addWindowStateListener(instance);
         instance.windowStateChanged((WindowEvent)null);
      }
   }

   public static final void centerChildToParent(Component var0, Component var1, boolean var2) {
      int var3 = var0.getX() + var0.getWidth() / 2 - var1.getWidth() / 2;
      int var4 = var0.getY() + var0.getHeight() / 2 - var1.getHeight() / 2;
      if(var2) {
         Toolkit var5 = Toolkit.getDefaultToolkit();
         Dimension var6 = new Dimension(var5.getScreenSize());
         if((double)(var3 + var1.getWidth()) > var6.getWidth()) {
            var3 = (int)(var6.getWidth() - (double)var1.getWidth());
         }

         if((double)(var4 + var1.getHeight()) > var6.getHeight()) {
            var4 = (int)(var6.getHeight() - (double)var1.getHeight());
         }

         if(var3 < 0) {
            var3 = 0;
         }

         if(var4 < 0) {
            var4 = 0;
         }
      }

      var1.setLocation(var3, var4);
   }

   public static final void centerOnScreen(Window var0) {
      var0.setLocationRelativeTo((Component)null);
   }

   public static Component findComponentAt(Container var0, Point var1) {
      Point var2 = new Point(var1.x, var1.y);
      SwingUtilities.convertPointFromScreen(var2, var0);
      if(!var0.contains(var2.x, var2.y)) {
         return var0;
      } else {
         int var3 = var0.getComponentCount();
         Component[] var4 = var0.getComponents();

         for(int var5 = 0; var5 < var3; ++var5) {
            Component var6 = var4[var5];
            Point var7 = var6.getLocation();
            if(var6.contains(var2.x - var7.x, var2.y - var7.y) && var6.isVisible()) {
               if(!(var6 instanceof Container)) {
                  return var6;
               }

               Container var8 = (Container)var6;
               Component var9 = findComponentAt(var8, var1);
               if(var9 != null) {
                  return var9;
               }
            }
         }

         return var0;
      }
   }

   public static JComponent findComponentByPredicate(JComponent var0, GuiHelper$ComponentFilter var1) {
      Component[] var2 = var0.getComponents();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Component var5 = var2[var4];
         if(var5 instanceof JComponent) {
            if(var1.accept((JComponent)var5)) {
               return (JComponent)var5;
            }

            JComponent var6 = findComponentByPredicate((JComponent)var5, var1);
            if(var6 != null) {
               return var6;
            }
         }
      }

      return null;
   }

   public static String getDefaultFont() {
      return DEFAULT_FONT.getName();
   }

   public static String getMonospaceFont() {
      return MONOSPACED_FONT.getName();
   }
}
