package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.AbstractCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.OrCriteriumPanel;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class OrCriterium extends AbstractCriterium {
   private static final ImageIcon OR_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/or.png");
   private final OrCriteriumPanel panel = new OrCriteriumPanel();

   public String getCriteriumDescription() {
      return "OR";
   }

   public JPanel getCriteriumPanel() {
      return this.panel;
   }

   public Icon getIcon() {
      return OR_ICON;
   }

   public CriteriumType getType() {
      return CriteriumType.OR;
   }

   public boolean matches(ZyGraphNode var1) {
      return true;
   }
}
