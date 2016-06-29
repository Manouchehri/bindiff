package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.ConditionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionState;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class RecursionCriterium extends ConditionCriterium {
   private static final ImageIcon RECURSION_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/recursion-condition.png");
   private final RecursionCriteriumPanel panel = new RecursionCriteriumPanel(this);

   public String getCriteriumDescription() {
      return String.format("Nodes with %s Recursion", new Object[]{this.panel.getRecursionState() == RecursionState.IS_RECURSION?"":"no"});
   }

   public JPanel getCriteriumPanel() {
      return this.panel;
   }

   public Icon getIcon() {
      return RECURSION_CONDITION_ICON;
   }

   public boolean matches(ZyGraphNode var1) {
      return this.panel.getRecursionState() == RecursionState.IS_RECURSION?var1.getChildren().contains(var1):var1.getChildren().contains(var1);
   }

   public void update() {
      this.notifyListeners();
   }
}
