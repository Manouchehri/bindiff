package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.*;
import javax.swing.tree.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;

public final class CriteriaDialog extends BaseDialog
{
    private final CriteriumTree ctree;
    private boolean selectNodes;
    private final DialogUpdater updater;
    private final JCriteriumTree jtree;
    
    public CriteriaDialog(final Window window, final CriteriaFactory criteriaFactory) {
        super(window, "Select by Criteria");
        this.setModal(true);
        if (criteriaFactory == null) {
            throw new IllegalArgumentException("Condition factory argument can not be null");
        }
        final List conditions = criteriaFactory.getConditions();
        this.ctree = new CriteriumTree();
        this.jtree = new JCriteriumTree(this.ctree, conditions);
        final ExpressionTreeActionProvider expressionTreeActionProvider = new ExpressionTreeActionProvider(this.jtree, this.ctree);
        this.jtree.getModel().setRoot(new CriteriumTreeNode(this.ctree.getRootCriterium(), conditions, expressionTreeActionProvider));
        final ConditionBox conditionBox = new ConditionBox(conditions);
        final JButton button = new JButton(new AddConditionButtonListener(this.jtree, conditionBox, expressionTreeActionProvider));
        final CPanelTwoButtons cPanelTwoButtons = new CPanelTwoButtons(new CriteriaDialog$InternalOkCancelButttonListener(this, null), "Execute", "Cancel");
        final JPanel panel = new JPanel(new BorderLayout());
        this.initDialog(window, this.jtree, conditionBox, panel, cPanelTwoButtons, button);
        this.updater = new DialogUpdater(this.jtree, this.ctree, panel, button, cPanelTwoButtons.getFirstButton());
    }
    
    private void initDialog(final Window window, final JCriteriumTree criteriumTree, final ConditionBox conditionBox, final JPanel panel, final CPanelTwoButtons cPanelTwoButtons, final JButton button) {
        final JPanel panel2 = new JPanel(new BorderLayout());
        final JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBorder(new EmptyBorder(2, 2, 2, 2));
        final JPanel panel4 = new JPanel(new GridLayout(1, 2));
        final JPanel panel5 = new JPanel(new BorderLayout());
        panel5.setBorder(new TitledBorder("Expression Tree"));
        final JPanel panel6 = new JPanel(new BorderLayout());
        final JPanel panel7 = new JPanel(new BorderLayout());
        panel7.setBorder(new TitledBorder("Create Condition"));
        final JPanel panel8 = new JPanel(new BorderLayout());
        panel8.setBorder(new EmptyBorder(1, 5, 5, 5));
        final JPanel panel9 = new JPanel(new BorderLayout());
        panel9.setBorder(new EmptyBorder(1, 0, 5, 5));
        panel2.add(panel3, "Center");
        panel2.add(cPanelTwoButtons, "South");
        cPanelTwoButtons.getFirstButton().setEnabled(criteriumTree.getSelectionPath() != null);
        panel3.add(panel4, "Center");
        panel4.add(panel5);
        panel4.add(panel6);
        final JScrollPane scrollPane = new JScrollPane(criteriumTree);
        scrollPane.setVerticalScrollBarPolicy(20);
        scrollPane.setHorizontalScrollBarPolicy(30);
        panel5.add(scrollPane, "Center");
        panel.setBorder(new TitledBorder("Define Condition"));
        panel6.add(panel7, "North");
        panel6.add(panel, "Center");
        panel7.add(panel8, "Center");
        panel7.add(panel9, "East");
        panel8.add(conditionBox, "Center");
        button.setText("Add");
        button.setEnabled(false);
        panel9.add(button, "Center");
        this.add(panel2);
        this.setIconImage(null);
        this.pack();
        GuiHelper.centerChildToParent(window, this, true);
    }
    
    public void delete() {
        this.updater.delete();
    }
    
    public boolean doSelectNodes() {
        return this.selectNodes;
    }
    
    public CriteriumTree getCriteriumTree() {
        return this.ctree;
    }
}
