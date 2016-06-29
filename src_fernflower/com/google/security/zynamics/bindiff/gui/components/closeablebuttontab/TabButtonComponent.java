package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.ICloseTabButtonListener;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButton;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButtonComponent$1;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButtonComponent$InternalMouseListener;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabLabel;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabButtonComponent extends JPanel {
   private final TabButtonComponent$InternalMouseListener mouseListener = new TabButtonComponent$InternalMouseListener(this, (TabButtonComponent$1)null);
   private final JTabbedPane pane;
   private final TabPanel tabPanel;
   private final TabButton closeButton;
   private final TabLabel label;

   public TabButtonComponent(JTabbedPane var1, TabPanel var2, Icon var3, boolean var4) {
      super(new FlowLayout(0, 0, 0));
      this.pane = (JTabbedPane)Preconditions.checkNotNull(var1);
      this.tabPanel = (TabPanel)Preconditions.checkNotNull(var2);
      this.closeButton = new TabButton(var1, this, var4);
      this.label = new TabLabel(var1, this);
      if(var3 != null) {
         this.label.setIcon(var3);
      }

      this.label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 3));
      this.add(this.label);
      if(var4) {
         this.add(this.closeButton);
      }

      this.setOpaque(false);
      this.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
      this.addMouseListener(this.mouseListener);
   }

   public void addListener(ICloseTabButtonListener var1) {
      this.closeButton.addListener(var1);
   }

   public TabPanel getTabPanel() {
      return this.tabPanel;
   }

   public void removeListener(ICloseTabButtonListener var1) {
      this.closeButton.removeListener(var1);
   }

   public void setIcon(Icon var1) {
      this.label.setIcon(var1);
      this.label.updateUI();
   }

   public void setTitle(String var1) {
      this.label.setText(var1);
      this.label.updateUI();
   }

   // $FF: synthetic method
   static TabPanel access$100(TabButtonComponent var0) {
      return var0.tabPanel;
   }

   // $FF: synthetic method
   static JTabbedPane access$200(TabButtonComponent var0) {
      return var0.pane;
   }
}
