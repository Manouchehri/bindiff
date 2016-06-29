package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.ConditionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.CSelectionCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.SelectionState;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.CViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CSelectionCriterium extends ConditionCriterium {
   private static final ImageIcon SELECTION_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/selection-condition.png");
   private final CSelectionCriteriumPanel panel = new CSelectionCriteriumPanel(this);

   public String getCriteriumDescription() {
      return String.format("%s Nodes", new Object[]{this.panel.getSelectionState() == SelectionState.SELECTED?"Selected":"Unselected"});
   }

   public JPanel getCriteriumPanel() {
      return this.panel;
   }

   public Icon getIcon() {
      return SELECTION_CONDITION_ICON;
   }

   public boolean matches(ZyGraphNode var1) {
      return ((CViewNode)var1.getRawNode()).isSelected() == (this.panel.getSelectionState() == SelectionState.SELECTED);
   }

   public void update() {
      this.notifyListeners();
   }
}
