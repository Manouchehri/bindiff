package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.ConditionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityCriteriumPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity.VisibilityState;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VisibilityCriterium extends ConditionCriterium {
   private static final ImageIcon VISIBILITY_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/visibility-condition.png");
   private final VisibilityCriteriumPanel panel = new VisibilityCriteriumPanel(this);

   public String getCriteriumDescription() {
      return String.format("%s Nodes", new Object[]{this.panel.getVisibilityState() == VisibilityState.VISIBLE?"Visible":"Invisible"});
   }

   public JPanel getCriteriumPanel() {
      return this.panel;
   }

   public Icon getIcon() {
      return VISIBILITY_CONDITION_ICON;
   }

   public boolean matches(ZyGraphNode var1) {
      return var1.isVisible() == (this.panel.getVisibilityState() == VisibilityState.VISIBLE);
   }

   public void update() {
      this.notifyListeners();
   }
}
