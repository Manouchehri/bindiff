package com.google.security.zynamics.bindiff.gui.tabpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.IDiffListener;
import java.awt.Color;

final class TabPanelManager$ColorSlot {
   protected final Color color;
   protected Diff diff;
   protected IDiffListener diffListener;

   private TabPanelManager$ColorSlot(Color var1) {
      this.color = (Color)Preconditions.checkNotNull(var1);
      this.diff = null;
      this.diffListener = null;
   }

   protected static TabPanelManager$ColorSlot make(Color var0) {
      return new TabPanelManager$ColorSlot(var0);
   }
}
