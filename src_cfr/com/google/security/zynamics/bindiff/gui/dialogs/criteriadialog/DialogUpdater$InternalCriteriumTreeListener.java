/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.DialogUpdater;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.DialogUpdater$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.ICriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeValidator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ICriteriumTreeListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTreeModel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.AbstractOperatorPanel;
import java.awt.Color;
import java.util.Enumeration;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.tree.TreePath;

class DialogUpdater$InternalCriteriumTreeListener
implements ICriteriumTreeListener {
    final /* synthetic */ DialogUpdater this$0;

    private DialogUpdater$InternalCriteriumTreeListener(DialogUpdater dialogUpdater) {
        this.this$0 = dialogUpdater;
    }

    private void update() {
        this.updateInfoField();
        DialogUpdater.access$300(this.this$0).setEnabled(ExpressionTreeValidator.isValid(DialogUpdater.access$200(this.this$0)));
    }

    private void updateCurrentCriteriumPath() {
        if (DialogUpdater.access$200(this.this$0).getSelectionPath() != null) {
            DialogUpdater.access$200(this.this$0).setCurrentCriteriumPath(DialogUpdater.access$200(this.this$0).getSelectionPath());
        } else {
            DialogUpdater.access$200(this.this$0).setCurrentCriteriumPath(DialogUpdater.access$200(this.this$0).getPathForRow(0));
        }
        DialogUpdater.access$400(this.this$0, (AbstractCriteriumTreeNode)DialogUpdater.access$200(this.this$0).getCurrentCriteriumPath().getLastPathComponent());
    }

    private void updateInfoField() {
        Enumeration enumeration = ((AbstractCriteriumTreeNode)DialogUpdater.access$200(this.this$0).getModel().getRoot()).breadthFirstEnumeration();
        while (enumeration.hasMoreElements()) {
            AbstractCriteriumTreeNode abstractCriteriumTreeNode = (AbstractCriteriumTreeNode)enumeration.nextElement();
            JPanel jPanel = abstractCriteriumTreeNode.getCriterium().getCriteriumPanel();
            if (jPanel instanceof AbstractOperatorPanel) {
                int n2 = abstractCriteriumTreeNode.getChildCount();
                CriteriumType criteriumType = abstractCriteriumTreeNode.getCriterium().getType();
                JTextArea jTextArea = ((AbstractOperatorPanel)jPanel).getInfoField();
                if (n2 == 1 && (criteriumType == CriteriumType.NOT || abstractCriteriumTreeNode.getLevel() == 0) || n2 > 1 && criteriumType != CriteriumType.NOT) {
                    jTextArea.setForeground(DialogUpdater.access$500());
                    jTextArea.setText(((AbstractOperatorPanel)jPanel).getValidInfoString());
                } else {
                    jTextArea.setForeground(DialogUpdater.access$600());
                    jTextArea.setText(((AbstractOperatorPanel)jPanel).getInvalidInfoString());
                }
            }
            jPanel.updateUI();
        }
    }

    @Override
    public void nodeAppended(CriteriumTree criteriumTree, ICriteriumTreeNode iCriteriumTreeNode, ICriteriumTreeNode iCriteriumTreeNode2) {
        this.update();
    }

    @Override
    public void nodeInserted(CriteriumTree criteriumTree, ICriteriumTreeNode iCriteriumTreeNode, ICriteriumTreeNode iCriteriumTreeNode2) {
        this.update();
    }

    @Override
    public void nodeRemoved(CriteriumTree criteriumTree, ICriteriumTreeNode iCriteriumTreeNode) {
        this.updateCurrentCriteriumPath();
        this.update();
    }

    @Override
    public void removedAll(CriteriumTree criteriumTree) {
        this.updateCurrentCriteriumPath();
        this.update();
    }

    /* synthetic */ DialogUpdater$InternalCriteriumTreeListener(DialogUpdater dialogUpdater, DialogUpdater$1 dialogUpdater$1) {
        this(dialogUpdater);
    }
}

