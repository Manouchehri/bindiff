package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.AbstractCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.AndCriteriumPanel;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class AndCriterium extends AbstractCriterium {
   private static final ImageIcon ADD_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/add.png");
   private final AndCriteriumPanel panel = new AndCriteriumPanel();

   public String getCriteriumDescription() {
      return "AND";
   }

   public JPanel getCriteriumPanel() {
      return this.panel;
   }

   public Icon getIcon() {
      return ADD_ICON;
   }

   public CriteriumType getType() {
      return CriteriumType.AND;
   }

   public boolean matches(ZyGraphNode var1) {
      return true;
   }
}
