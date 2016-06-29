package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import com.google.security.zynamics.zylib.gui.jtree.IconNodeRenderer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTree;

public class TreeNodeRenderer extends IconNodeRenderer {
   private static final Color VALID_NODE_FONT_COLOR = new Color(0, 0, 0);
   private static final Color INVALID_NODE_FONT_COLOR = new Color(160, 0, 0);

   public Component getTreeCellRendererComponent(JTree var1, Object var2, boolean var3, boolean var4, boolean var5, int var6, boolean var7) {
      super.getTreeCellRendererComponent(var1, var2, var3, var4, var5, var6, var7);
      if(var2 instanceof AbstractCriteriumTreeNode) {
         AbstractCriteriumTreeNode var8 = (AbstractCriteriumTreeNode)var2;
         int var9 = var8.getChildCount();
         CriteriumType var10 = var8.getCriterium().getType();
         if(var10 != CriteriumType.CONDITION) {
            if((var9 != 1 || var10 != CriteriumType.NOT && var8.getLevel() != 0) && (var9 <= 1 || var10 == CriteriumType.NOT)) {
               this.setForeground(INVALID_NODE_FONT_COLOR);
            } else {
               this.setForeground(VALID_NODE_FONT_COLOR);
            }
         }
      }

      return this;
   }
}
