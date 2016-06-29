package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text;

import com.google.security.zynamics.bindiff.graph.searchers.NodeSearcher;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.ConditionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text.TextCriteriumPanel;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TextCriterium extends ConditionCriterium {
   private static final ImageIcon TEXT_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/text-condition.png");
   private final TextCriteriumPanel panel = new TextCriteriumPanel(this);

   public String getCriteriumDescription() {
      return String.format("Nodes with Text \'%s\'", new Object[]{this.panel.getText()});
   }

   public JPanel getCriteriumPanel() {
      return this.panel;
   }

   public Icon getIcon() {
      return TEXT_CONDITION_ICON;
   }

   public boolean matches(ZyGraphNode var1) {
      return NodeSearcher.search(var1, this.panel.getText(), this.panel.isRegularExpression(), this.panel.isCaseSensitive()).size() != 0;
   }

   public void update() {
      this.notifyListeners();
   }
}
