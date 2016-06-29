package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.*;
import javax.swing.*;
import javax.swing.event.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.*;
import javax.swing.border.*;
import java.awt.*;

public class DialogUpdater
{
    private static final Color INVALID_OPERATOR_COLOR;
    private static final Color VALID_OPERATOR_COLOR;
    private final JCriteriumTree jtree;
    private final DialogUpdater$InternalTreeSelectionListener treeSelectionListener;
    private final DialogUpdater$InternalCriteriumTreeListener treeCriteriumlListener;
    private final CriteriumTree ctree;
    private final JPanel defineConditionPanel;
    private final JButton addConditionButton;
    private final JButton okButton;
    
    public DialogUpdater(final JCriteriumTree jtree, final CriteriumTree ctree, final JPanel defineConditionPanel, final JButton addConditionButton, final JButton okButton) {
        this.treeSelectionListener = new DialogUpdater$InternalTreeSelectionListener(this, null);
        this.treeCriteriumlListener = new DialogUpdater$InternalCriteriumTreeListener(this, null);
        this.jtree = jtree;
        this.ctree = ctree;
        this.defineConditionPanel = defineConditionPanel;
        this.addConditionButton = addConditionButton;
        this.okButton = okButton;
        this.jtree.addTreeSelectionListener(this.treeSelectionListener);
        this.ctree.addListener(this.treeCriteriumlListener);
    }
    
    private void updateDefineConditionPanel(final AbstractCriteriumTreeNode abstractCriteriumTreeNode) {
        Component criteriumPanel = null;
        if (abstractCriteriumTreeNode instanceof CriteriumTreeNode) {
            criteriumPanel = abstractCriteriumTreeNode.getCriterium().getCriteriumPanel();
        }
        this.defineConditionPanel.removeAll();
        this.defineConditionPanel.setBorder(null);
        if (criteriumPanel != null) {
            this.defineConditionPanel.add(criteriumPanel);
        }
        else {
            final JPanel panel = new JPanel(new BorderLayout());
            panel.setBorder(new TitledBorder("Define Condition"));
            this.defineConditionPanel.add(panel, "Center");
        }
        this.defineConditionPanel.updateUI();
    }
    
    public void delete() {
        this.jtree.removeTreeSelectionListener(this.treeSelectionListener);
        this.ctree.removeListener(this.treeCriteriumlListener);
    }
    
    static {
        INVALID_OPERATOR_COLOR = new Color(160, 0, 0);
        VALID_OPERATOR_COLOR = new Color(0, 0, 0);
    }
}
