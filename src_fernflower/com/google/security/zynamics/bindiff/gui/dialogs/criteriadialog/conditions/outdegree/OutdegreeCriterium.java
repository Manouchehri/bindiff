package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.ConditionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree.OutdegreeCriteriumPanel;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class OutdegreeCriterium extends ConditionCriterium {
   private static final ImageIcon OUTDEGREE_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/outdegree-condition.png");
   private final OutdegreeCriteriumPanel panel = new OutdegreeCriteriumPanel(this);

   public String getCriteriumDescription() {
      return String.format("Nodes with Outdegree %s %d", new Object[]{this.getOperator(), Integer.valueOf(this.getOutdegree())});
   }

   public JPanel getCriteriumPanel() {
      return this.panel;
   }

   public Icon getIcon() {
      return OUTDEGREE_CONDITION_ICON;
   }

   public String getOperator() {
      return this.panel.getOperator();
   }

   public int getOutdegree() {
      return this.panel.getOutdegree();
   }

   public boolean matches(ZyGraphNode var1) {
      String var2 = this.panel.getOperator();
      IViewNode var3 = var1.getRawNode();
      return var2.equals("<")?var3.getOutgoingEdges().size() < this.getOutdegree():(var2.equals("=")?var3.getOutgoingEdges().size() == this.getOutdegree():(var2.equals(">")?var3.getOutgoingEdges().size() > this.getOutdegree():false));
   }

   public void update() {
      this.notifyListeners();
   }
}
