package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.ConditionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriteriumPanel;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class IndegreeCriterium extends ConditionCriterium {
   private static final ImageIcon INDEGREE_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/indegree-condition.png");
   private final IndegreeCriteriumPanel panel = new IndegreeCriteriumPanel(this);

   public String getCriteriumDescription() {
      return String.format("Nodes with Indegree %s %d", new Object[]{this.getOperator(), Integer.valueOf(this.getIndegree())});
   }

   public JPanel getCriteriumPanel() {
      return this.panel;
   }

   public Icon getIcon() {
      return INDEGREE_CONDITION_ICON;
   }

   public int getIndegree() {
      return this.panel.getIndegree();
   }

   public String getOperator() {
      return this.panel.getOperator();
   }

   public boolean matches(ZyGraphNode var1) {
      String var2 = this.panel.getOperator();
      IViewNode var3 = var1.getRawNode();
      return var2.equals("<")?var3.getIncomingEdges().size() < this.getIndegree():(var2.equals("=")?var3.getIncomingEdges().size() == this.getIndegree():(var2.equals(">")?var3.getIncomingEdges().size() > this.getIndegree():false));
   }

   public void update() {
      this.notifyListeners();
   }
}
