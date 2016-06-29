package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.*;
import javax.swing.*;
import javax.swing.event.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.*;
import javax.swing.border.*;
import java.awt.*;

class DialogUpdater$InternalCriteriumTreeListener implements ICriteriumTreeListener
{
    final /* synthetic */ DialogUpdater this$0;
    
    private DialogUpdater$InternalCriteriumTreeListener(final DialogUpdater this$0) {
        this.this$0 = this$0;
    }
    
    private void update() {
        this.updateInfoField();
        this.this$0.okButton.setEnabled(ExpressionTreeValidator.isValid(this.this$0.jtree));
    }
    
    private void updateCurrentCriteriumPath() {
        if (this.this$0.jtree.getSelectionPath() != null) {
            this.this$0.jtree.setCurrentCriteriumPath(this.this$0.jtree.getSelectionPath());
        }
        else {
            this.this$0.jtree.setCurrentCriteriumPath(this.this$0.jtree.getPathForRow(0));
        }
        this.this$0.updateDefineConditionPanel((AbstractCriteriumTreeNode)this.this$0.jtree.getCurrentCriteriumPath().getLastPathComponent());
    }
    
    private void updateInfoField() {
        final Enumeration breadthFirstEnumeration = ((AbstractCriteriumTreeNode)this.this$0.jtree.getModel().getRoot()).breadthFirstEnumeration();
        while (breadthFirstEnumeration.hasMoreElements()) {
            final AbstractCriteriumTreeNode abstractCriteriumTreeNode = breadthFirstEnumeration.nextElement();
            final JPanel criteriumPanel = abstractCriteriumTreeNode.getCriterium().getCriteriumPanel();
            if (criteriumPanel instanceof AbstractOperatorPanel) {
                final int childCount = abstractCriteriumTreeNode.getChildCount();
                final CriteriumType type = abstractCriteriumTreeNode.getCriterium().getType();
                final JTextArea infoField = ((AbstractOperatorPanel)criteriumPanel).getInfoField();
                if ((childCount == 1 && (type == CriteriumType.NOT || abstractCriteriumTreeNode.getLevel() == 0)) || (childCount > 1 && type != CriteriumType.NOT)) {
                    infoField.setForeground(DialogUpdater.VALID_OPERATOR_COLOR);
                    infoField.setText(((AbstractOperatorPanel)criteriumPanel).getValidInfoString());
                }
                else {
                    infoField.setForeground(DialogUpdater.INVALID_OPERATOR_COLOR);
                    infoField.setText(((AbstractOperatorPanel)criteriumPanel).getInvalidInfoString());
                }
            }
            criteriumPanel.updateUI();
        }
    }
    
    @Override
    public void nodeAppended(final CriteriumTree criteriumTree, final ICriteriumTreeNode criteriumTreeNode, final ICriteriumTreeNode criteriumTreeNode2) {
        this.update();
    }
    
    @Override
    public void nodeInserted(final CriteriumTree criteriumTree, final ICriteriumTreeNode criteriumTreeNode, final ICriteriumTreeNode criteriumTreeNode2) {
        this.update();
    }
    
    @Override
    public void nodeRemoved(final CriteriumTree criteriumTree, final ICriteriumTreeNode criteriumTreeNode) {
        this.updateCurrentCriteriumPath();
        this.update();
    }
    
    @Override
    public void removedAll(final CriteriumTree criteriumTree) {
        this.updateCurrentCriteriumPath();
        this.update();
    }
}
