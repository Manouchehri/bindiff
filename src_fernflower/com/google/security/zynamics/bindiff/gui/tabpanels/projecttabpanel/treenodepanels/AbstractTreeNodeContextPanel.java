package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;

public abstract class AbstractTreeNodeContextPanel extends JPanel {
   public AbstractTreeNodeContextPanel() {
      super(new BorderLayout());
   }

   public abstract List getTables();
}
