package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.menus.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.utils.*;

public class CriteriumTreeNode extends AbstractCriteriumTreeNode
{
    private static final ImageIcon DEFAULT_ICON;
    private final NodeMenuBuilder menuBuilder;
    
    public CriteriumTreeNode(final ICriterium criterium, final List list, final ExpressionTreeActionProvider expressionTreeActionProvider) {
        super(criterium);
        this.menuBuilder = new NodeMenuBuilder(this, list, expressionTreeActionProvider);
    }
    
    @Override
    public Icon getIcon() {
        final Icon icon = this.getCriterium().getIcon();
        if (icon == null) {
            return CriteriumTreeNode.DEFAULT_ICON;
        }
        return icon;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        return this.menuBuilder.getPopup();
    }
    
    @Override
    public String toString() {
        return this.getCriterium().getCriteriumDescription();
    }
    
    static {
        DEFAULT_ICON = ImageUtils.getImageIcon("data/selectbycriteriaicons/default-condition.png");
    }
}
