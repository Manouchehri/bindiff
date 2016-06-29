package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import com.google.security.zynamics.bindiff.utils.*;

public class TextCriterium extends ConditionCriterium
{
    private static final ImageIcon TEXT_CONDITION_ICON;
    private final TextCriteriumPanel panel;
    
    public TextCriterium() {
        this.panel = new TextCriteriumPanel(this);
    }
    
    @Override
    public String getCriteriumDescription() {
        return String.format("Nodes with Text '%s'", this.panel.getText());
    }
    
    @Override
    public JPanel getCriteriumPanel() {
        return this.panel;
    }
    
    @Override
    public Icon getIcon() {
        return TextCriterium.TEXT_CONDITION_ICON;
    }
    
    @Override
    public boolean matches(final ZyGraphNode zyGraphNode) {
        return NodeSearcher.search(zyGraphNode, this.panel.getText(), this.panel.isRegularExpression(), this.panel.isCaseSensitive()).size() != 0;
    }
    
    public void update() {
        this.notifyListeners();
    }
    
    static {
        TEXT_CONDITION_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/text-condition.png");
    }
}
