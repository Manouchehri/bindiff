package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButtonComponent;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class TabLabel extends JLabel {
   private final JTabbedPane pane;
   private final TabButtonComponent buttonComponent;

   public TabLabel(JTabbedPane var1, TabButtonComponent var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      this.pane = var1;
      this.buttonComponent = var2;
   }

   public String getText() {
      if(this.buttonComponent != null) {
         int var1 = this.pane.indexOfTabComponent(this.buttonComponent);
         if(var1 != -1) {
            return this.pane.getTitleAt(var1);
         }
      }

      return null;
   }

   public void setText(String var1) {
      if(this.buttonComponent != null) {
         int var2 = this.pane.indexOfTabComponent(this.buttonComponent);
         if(var2 != -1) {
            this.pane.setTitleAt(var2, var1);
         }
      }

   }
}
