package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.BackgroundIcon;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;

public class MatchStateCellRenderer extends AbstractTableCellRenderer {
   private final Color textColor;
   private final Color matchedColor;
   private final Color primaryUnmatchedColor;
   private final Color secondaryUnmatchedColor;

   public MatchStateCellRenderer(Color var1, Color var2, Color var3, Color var4) {
      this.textColor = (Color)Preconditions.checkNotNull(var1);
      this.matchedColor = (Color)Preconditions.checkNotNull(var2);
      this.primaryUnmatchedColor = (Color)Preconditions.checkNotNull(var3);
      this.secondaryUnmatchedColor = (Color)Preconditions.checkNotNull(var4);
   }

   public Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      Preconditions.checkArgument(var2 instanceof EMatchState, "Value must be an EMatchState");
      this.buildAndSetToolTip(var1, var5);
      EMatchState var7 = (EMatchState)var2;
      Color var8;
      if(var7 == EMatchState.PRIMARY_UNMATCHED) {
         var8 = this.primaryUnmatchedColor;
      } else if(var7 == EMatchState.SECONDRAY_UNMATCHED) {
         var8 = this.secondaryUnmatchedColor;
      } else {
         var8 = this.matchedColor;
      }

      this.setIcon(new BackgroundIcon("", 2, this.textColor, var8, var1.getSelectionBackground(), var3, -1, 0, var1.getColumnModel().getColumn(var6).getWidth() - 1, var1.getRowHeight() - 1));
      return this;
   }
}
