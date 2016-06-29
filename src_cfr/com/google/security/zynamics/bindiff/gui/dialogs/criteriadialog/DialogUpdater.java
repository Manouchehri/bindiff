/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.DialogUpdater$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.DialogUpdater$InternalCriteriumTreeListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.DialogUpdater$InternalTreeSelectionListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ICriteriumTreeListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.CriteriumTreeNode;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionListener;

public class DialogUpdater {
    private static final Color INVALID_OPERATOR_COLOR = new Color(160, 0, 0);
    private static final Color VALID_OPERATOR_COLOR = new Color(0, 0, 0);
    private final JCriteriumTree jtree;
    private final DialogUpdater$InternalTreeSelectionListener treeSelectionListener;
    private final DialogUpdater$InternalCriteriumTreeListener treeCriteriumlListener;
    private final CriteriumTree ctree;
    private final JPanel defineConditionPanel;
    private final JButton addConditionButton;
    private final JButton okButton;

    public DialogUpdater(JCriteriumTree jCriteriumTree, CriteriumTree criteriumTree, JPanel jPanel, JButton jButton, JButton jButton2) {
        this.treeSelectionListener = new DialogUpdater$InternalTreeSelectionListener(this, null);
        this.treeCriteriumlListener = new DialogUpdater$InternalCriteriumTreeListener(this, null);
        this.jtree = jCriteriumTree;
        this.ctree = criteriumTree;
        this.defineConditionPanel = jPanel;
        this.addConditionButton = jButton;
        this.okButton = jButton2;
        this.jtree.addTreeSelectionListener(this.treeSelectionListener);
        this.ctree.addListener(this.treeCriteriumlListener);
    }

    private void updateDefineConditionPanel(AbstractCriteriumTreeNode abstractCriteriumTreeNode) {
        JPanel jPanel = null;
        if (abstractCriteriumTreeNode instanceof CriteriumTreeNode) {
            jPanel = abstractCriteriumTreeNode.getCriterium().getCriteriumPanel();
        }
        this.defineConditionPanel.removeAll();
        this.defineConditionPanel.setBorder(null);
        if (jPanel != null) {
            this.defineConditionPanel.add(jPanel);
        } else {
            JPanel jPanel2 = new JPanel(new BorderLayout());
            jPanel2.setBorder(new TitledBorder("Define Condition"));
            this.defineConditionPanel.add((Component)jPanel2, "Center");
        }
        this.defineConditionPanel.updateUI();
    }

    public void delete() {
        this.jtree.removeTreeSelectionListener(this.treeSelectionListener);
        this.ctree.removeListener(this.treeCriteriumlListener);
    }

    static /* synthetic */ JCriteriumTree access$200(DialogUpdater dialogUpdater) {
        return dialogUpdater.jtree;
    }

    static /* synthetic */ JButton access$300(DialogUpdater dialogUpdater) {
        return dialogUpdater.okButton;
    }

    static /* synthetic */ void access$400(DialogUpdater dialogUpdater, AbstractCriteriumTreeNode abstractCriteriumTreeNode) {
        dialogUpdater.updateDefineConditionPanel(abstractCriteriumTreeNode);
    }

    static /* synthetic */ Color access$500() {
        return VALID_OPERATOR_COLOR;
    }

    static /* synthetic */ Color access$600() {
        return INVALID_OPERATOR_COLOR;
    }

    static /* synthetic */ JButton access$700(DialogUpdater dialogUpdater) {
        return dialogUpdater.addConditionButton;
    }
}

