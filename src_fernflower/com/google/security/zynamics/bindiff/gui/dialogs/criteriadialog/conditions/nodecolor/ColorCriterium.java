package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.AbstractGraphsContainer;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.ConditionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.ColorCriteriumPanel;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.CViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ColorCriterium extends ConditionCriterium {
   private static final ImageIcon COLOR_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/color-condition.png");
   private final ColorCriteriumPanel panel;
   private final AbstractGraphsContainer graphs;

   public ColorCriterium(AbstractGraphsContainer var1) {
      Preconditions.checkNotNull(var1);
      this.panel = new ColorCriteriumPanel(this);
      this.graphs = var1;
   }

   private JPanel getCriteriumPanel(AbstractGraphsContainer var1) {
      this.panel.updateColors(var1);
      return this.panel;
   }

   public Color getColor() {
      return this.panel.getColor();
   }

   public String getCriteriumDescription() {
      return String.format("Nodes with Color %06X", new Object[]{Integer.valueOf(this.getColor().getRGB() & 16777215)});
   }

   public JPanel getCriteriumPanel() {
      return this.getCriteriumPanel(this.graphs);
   }

   public Icon getIcon() {
      return COLOR_CONDITION_ICON;
   }

   public boolean matches(ZyGraphNode var1) {
      return ((CViewNode)var1.getRawNode()).getColor().equals(this.getColor());
   }

   public void update() {
      this.notifyListeners();
   }
}
