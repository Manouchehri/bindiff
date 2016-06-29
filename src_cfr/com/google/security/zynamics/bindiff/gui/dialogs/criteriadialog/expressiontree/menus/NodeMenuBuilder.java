/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.menus;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.AddConditionAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.AppendAndOperatorAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.AppendNotOperatorAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.AppendOrOperatorAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.InsertAndOperatorAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.InsertNotOperatorAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.InsertOrOperatorAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.RemoveAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.RemoveAllAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.CriteriumTreeNode;
import java.awt.Component;
import java.util.Iterator;
import java.util.List;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class NodeMenuBuilder {
    private final JPopupMenu popup = new JPopupMenu();
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

    public NodeMenuBuilder(CriteriumTreeNode criteriumTreeNode, List list, ExpressionTreeActionProvider expressionTreeActionProvider) {
        this.criteriumNode = criteriumTreeNode;
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
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) {
                this.popup.add(this.conditionSubmenu);
                this.popup.add(new JSeparator());
                this.remove = new JMenuItem(new RemoveAction(criteriumTreeNode, expressionTreeActionProvider));
                this.popup.add(this.remove);
                this.popup.add(new JSeparator());
                this.removeAll = new JMenuItem(new RemoveAllAction(expressionTreeActionProvider));
                this.popup.add(this.removeAll);
                return;
            }
            ICriteriumCreator iCriteriumCreator = (ICriteriumCreator)iterator.next();
            this.conditionSubmenu.add(new JMenuItem(new AddConditionAction(iCriteriumCreator, expressionTreeActionProvider)));
        } while (true);
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

