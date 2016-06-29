package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.menus;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;

public class NodeMenuBuilder
{
    private final JPopupMenu popup;
    private final JMenuItem insertAnd;
    private final JMenuItem insertOr;
    private final JMenuItem insertNot;
    private final JMenuItem appendAnd;
    private final JMenuItem appendOr;
    private final JMenuItem appendNot;
    private final JMenu conditionSubmenu;
    private final JMenuItem remove;
    private final JMenuItem removeAll;
    private final CriteriumTreeNode criteriumNode;
    
    public NodeMenuBuilder(final CriteriumTreeNode criteriumNode, final List list, final ExpressionTreeActionProvider expressionTreeActionProvider) {
        this.popup = new JPopupMenu();
        this.criteriumNode = criteriumNode;
        this.appendAnd = new JMenuItem(new AppendAndOperatorAction(expressionTreeActionProvider));
        this.appendOr = new JMenuItem(new AppendOrOperatorAction(expressionTreeActionProvider));
        this.appendNot = new JMenuItem(new AppendNotOperatorAction(expressionTreeActionProvider));
        this.popup.add(this.appendAnd);
        this.popup.add(this.appendOr);
        this.popup.add(this.appendNot);
        this.popup.add(new JSeparator());
        this.insertAnd = new JMenuItem(new InsertAndOperatorAction(expressionTreeActionProvider));
        this.insertOr = new JMenuItem(new InsertOrOperatorAction(expressionTreeActionProvider));
        this.insertNot = new JMenuItem(new InsertNotOperatorAction(expressionTreeActionProvider));
        this.popup.add(this.insertAnd);
        this.popup.add(this.insertOr);
        this.popup.add(this.insertNot);
        this.popup.add(new JSeparator());
        this.conditionSubmenu = new JMenu("Create Condition");
        final Iterator<ICriteriumCreator> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.conditionSubmenu.add(new JMenuItem(new AddConditionAction(iterator.next(), expressionTreeActionProvider)));
        }
        this.popup.add(this.conditionSubmenu);
        this.popup.add(new JSeparator());
        this.remove = new JMenuItem(new RemoveAction(criteriumNode, expressionTreeActionProvider));
        this.popup.add(this.remove);
        this.popup.add(new JSeparator());
        this.removeAll = new JMenuItem(new RemoveAllAction(expressionTreeActionProvider));
        this.popup.add(this.removeAll);
    }
    
    private void updateMenuState() {
        this.appendAnd.setEnabled(this.criteriumNode.allowAppend(CriteriumType.AND));
        this.appendOr.setEnabled(this.criteriumNode.allowAppend(CriteriumType.OR));
        this.appendNot.setEnabled(this.criteriumNode.allowAppend(CriteriumType.NOT));
        this.insertAnd.setEnabled(this.criteriumNode.allowInsert(CriteriumType.AND));
        this.insertOr.setEnabled(this.criteriumNode.allowInsert(CriteriumType.OR));
        this.insertNot.setEnabled(this.criteriumNode.allowInsert(CriteriumType.NOT));
        this.conditionSubmenu.setEnabled(this.criteriumNode.allowAppend(CriteriumType.CONDITION));
        this.remove.setEnabled(!this.criteriumNode.isRoot());
        this.removeAll.setEnabled(this.criteriumNode.getChildCount() != 0);
    }
    
    public JPopupMenu getPopup() {
        this.updateMenuState();
        return this.popup;
    }
}
