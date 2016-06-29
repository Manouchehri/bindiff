package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.ICloseTabButtonListener;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButton$1;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButton$InternalButtonListener;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButton$InternalMouseListener;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButtonComponent;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicButtonUI;

public class TabButton extends JButton {
   private static final Color ROLL_OVER_COLOR = new Color(160, 0, 0);
   private final ListenerProvider closeTabButtonListeners = new ListenerProvider();
   private final TabButton$InternalButtonListener buttonListener = new TabButton$InternalButtonListener(this, (TabButton$1)null);
   private final TabButton$InternalMouseListener mouseListener = new TabButton$InternalMouseListener(this, (TabButton$1)null);
   private final JTabbedPane pane;
   private final TabButtonComponent tabButtonComponent;
   private final boolean enableClose;

   public TabButton(JTabbedPane var1, TabButtonComponent var2, boolean var3) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      this.pane = var1;
      this.tabButtonComponent = var2;
      this.enableClose = var3;
      boolean var4 = true;
      this.setPreferredSize(new Dimension(17, 17));
      this.setToolTipText("Close View");
      this.setUI(new BasicButtonUI());
      this.setContentAreaFilled(false);
      this.setFocusable(false);
      this.setBorderPainted(false);
      this.addMouseListener(this.mouseListener);
      this.setRolloverEnabled(true);
      this.addActionListener(this.buttonListener);
   }

   protected void paintComponent(Graphics var1) {
      if(!this.enableClose) {
         super.paintComponent(var1);
      } else {
         Graphics2D var2 = (Graphics2D)var1.create();
         if(this.getModel().isPressed()) {
            var2.translate(1, 1);
         }

         var2.setColor(!this.getModel().isRollover()?Color.BLACK:ROLL_OVER_COLOR);
         var2.setStroke(new BasicStroke(3.0F));
         int var3 = this.getWidth();
         int var4 = this.getHeight();
         boolean var5 = true;
         var2.drawLine(6, 6, var3 - 6, var4 - 6);
         var2.drawLine(var3 - 6, 6, 6, var4 - 6);
         var2.dispose();
      }
   }

   public void addListener(ICloseTabButtonListener var1) {
      this.closeTabButtonListeners.addListener(var1);
   }

   public void removeListener(ICloseTabButtonListener var1) {
      this.closeTabButtonListeners.removeListener(var1);
   }

   // $FF: synthetic method
   static TabButtonComponent access$200(TabButton var0) {
      return var0.tabButtonComponent;
   }

   // $FF: synthetic method
   static JTabbedPane access$300(TabButton var0) {
      return var0.pane;
   }

   // $FF: synthetic method
   static ListenerProvider access$400(TabButton var0) {
      return var0.closeTabButtonListeners;
   }
}
