package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.menus.NodeMenuBuilder;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

public class CriteriumTreeNode extends AbstractCriteriumTreeNode {
   private static final ImageIcon DEFAULT_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/default-condition.png");
   private final NodeMenuBuilder menuBuilder;

   public CriteriumTreeNode(ICriterium var1, List var2, ExpressionTreeActionProvider var3) {
      super(var1);
      this.menuBuilder = new NodeMenuBuilder(this, var2, var3);
   }

   public Icon getIcon() {
      Icon var1 = this.getCriterium().getIcon();
      return (Icon)(var1 == null?DEFAULT_ICON:var1);
   }

   public JPopupMenu getPopupMenu() {
      return this.menuBuilder.getPopup();
   }

   public String toString() {
      return this.getCriterium().getCriteriumDescription();
   }
}
