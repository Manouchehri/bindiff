/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.AddConditionButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.ConditionBox;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.CriteriaDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.CriteriaDialog$InternalOkCancelButttonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.CriteriaFactory;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.DialogUpdater;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTreeModel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.CriteriumTreeNode;
import com.google.security.zynamics.zylib.gui.CPanelTwoButtons;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public final class CriteriaDialog
extends BaseDialog {
    private final CriteriumTree ctree;
    private boolean selectNodes;
    private final DialogUpdater updater;
    private final JCriteriumTree jtree;

    public CriteriaDialog(Window window, CriteriaFactory criteriaFactory) {
        super(window, "Select by Criteria");
        this.setModal(true);
        if (criteriaFactory == null) {
            throw new IllegalArgumentException("Condition factory argument can not be null");
        }
        List list = criteriaFactory.getConditions();
        this.ctree = new CriteriumTree();
        this.jtree = new JCriteriumTree(this.ctree, list);
        ExpressionTreeActionProvider expressionTreeActionProvider = new ExpressionTreeActionProvider(this.jtree, this.ctree);
        CriteriumTreeNode criteriumTreeNode = new CriteriumTreeNode(this.ctree.getRootCriterium(), list, expressionTreeActionProvider);
        this.jtree.getModel().setRoot(criteriumTreeNode);
        ConditionBox conditionBox = new ConditionBox(list);
        AddConditionButtonListener addConditionButtonListener = new AddConditionButtonListener(this.jtree, conditionBox, expressionTreeActionProvider);
        JButton jButton = new JButton(addConditionButtonListener);
        CPanelTwoButtons cPanelTwoButtons = new CPanelTwoButtons(new CriteriaDialog$InternalOkCancelButttonListener(this, null), "Execute", "Cancel");
        JPanel jPanel = new JPanel(new BorderLayout());
        this.initDialog(window, this.jtree, conditionBox, jPanel, cPanelTwoButtons, jButton);
        this.updater = new DialogUpdater(this.jtree, this.ctree, jPanel, jButton, cPanelTwoButtons.getFirstButton());
    }

    private void initDialog(Window window, JCriteriumTree jCriteriumTree, ConditionBox conditionBox, JPanel jPanel, CPanelTwoButtons cPanelTwoButtons, JButton jButton) {
        JPanel jPanel2 = new JPanel(new BorderLayout());
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.setBorder(new EmptyBorder(2, 2, 2, 2));
        JPanel jPanel4 = new JPanel(new GridLayout(1, 2));
        JPanel jPanel5 = new JPanel(new BorderLayout());
        jPanel5.setBorder(new TitledBorder("Expression Tree"));
        JPanel jPanel6 = new JPanel(new BorderLayout());
        JPanel jPanel7 = new JPanel(new BorderLayout());
        jPanel7.setBorder(new TitledBorder("Create Condition"));
        JPanel jPanel8 = new JPanel(new BorderLayout());
        jPanel8.setBorder(new EmptyBorder(1, 5, 5, 5));
        JPanel jPanel9 = new JPanel(new BorderLayout());
        jPanel9.setBorder(new EmptyBorder(1, 0, 5, 5));
        jPanel2.add((Component)jPanel3, "Center");
        jPanel2.add((Component)cPanelTwoButtons, "South");
        cPanelTwoButtons.getFirstButton().setEnabled(jCriteriumTree.getSelectionPath() != null);
        jPanel3.add((Component)jPanel4, "Center");
        jPanel4.add(jPanel5);
        jPanel4.add(jPanel6);
        JScrollPane jScrollPane = new JScrollPane(jCriteriumTree);
        jScrollPane.setVerticalScrollBarPolicy(20);
        jScrollPane.setHorizontalScrollBarPolicy(30);
        jPanel5.add((Component)jScrollPane, "Center");
        jPanel.setBorder(new TitledBorder("Define Condition"));
        jPanel6.add((Component)jPanel7, "North");
        jPanel6.add((Component)jPanel, "Center");
        jPanel7.add((Component)jPanel8, "Center");
        jPanel7.add((Component)jPanel9, "East");
        jPanel8.add((Component)conditionBox, "Center");
        jButton.setText("Add");
        jButton.setEnabled(false);
        jPanel9.add((Component)jButton, "Center");
        this.add(jPanel2);
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

    static /* synthetic */ boolean access$102(CriteriaDialog criteriaDialog, boolean bl2) {
        criteriaDialog.selectNodes = bl2;
        return criteriaDialog.selectNodes;
    }
}

