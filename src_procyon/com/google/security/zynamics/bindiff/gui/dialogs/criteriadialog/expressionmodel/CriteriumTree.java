package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.root.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.*;
import com.google.security.zynamics.bindiff.log.*;
import java.util.*;

public class CriteriumTree
{
    private final ListenerProvider listeners;
    private final CriteriumTreeNode rootNode;
    
    public CriteriumTree() {
        this.listeners = new ListenerProvider();
        this.rootNode = new CriteriumTreeNode(new RootCriterium());
    }
    
    public void addListener(final ICriteriumTreeListener criteriumTreeListener) {
        this.listeners.addListener(criteriumTreeListener);
    }
    
    public void appendNode(final ICriteriumTreeNode criteriumTreeNode) {
        this.appendNode(this.rootNode, criteriumTreeNode);
    }
    
    public void appendNode(final ICriteriumTreeNode criteriumTreeNode, final ICriteriumTreeNode criteriumTreeNode2) {
        CriteriumTreeNode.append(criteriumTreeNode, criteriumTreeNode2);
        for (final ICriteriumTreeListener criteriumTreeListener : this.listeners) {
            try {
                criteriumTreeListener.nodeAppended(this, criteriumTreeNode, criteriumTreeNode2);
            }
            catch (Exception ex) {
                Logger.logException(ex, "Append Tree Node.");
            }
        }
    }
    
    public ICriteriumTreeNode getRoot() {
        return this.rootNode;
    }
    
    public ICriterium getRootCriterium() {
        return this.rootNode.getCriterium();
    }
    
    public void insertNode(final ICriteriumTreeNode criteriumTreeNode) {
        this.insertNode(this.rootNode, criteriumTreeNode);
    }
    
    public void insertNode(final ICriteriumTreeNode criteriumTreeNode, final ICriteriumTreeNode criteriumTreeNode2) {
        CriteriumTreeNode.insert(criteriumTreeNode, criteriumTreeNode2);
        for (final ICriteriumTreeListener criteriumTreeListener : this.listeners) {
            try {
                criteriumTreeListener.nodeInserted(this, criteriumTreeNode, criteriumTreeNode2);
            }
            catch (Exception ex) {
                Logger.logException(ex, "Insert Tree Node.");
            }
        }
    }
    
    public void removeAll() {
        if (this.rootNode.getChildren().size() == 1) {
            this.removeNode(this.rootNode.getChildren().get(0));
        }
        for (final ICriteriumTreeListener criteriumTreeListener : this.listeners) {
            try {
                criteriumTreeListener.removedAll(this);
            }
            catch (Exception ex) {
                Logger.logException(ex, "Remove all Tree Nodes");
            }
        }
    }
    
    public void removeListener(final ICriteriumTreeListener criteriumTreeListener) {
        this.listeners.removeListener(criteriumTreeListener);
    }
    
    public void removeNode(final ICriteriumTreeNode criteriumTreeNode) {
        CriteriumTreeNode.remove(criteriumTreeNode);
        criteriumTreeNode.getParent().getChildren().remove(criteriumTreeNode);
        for (final ICriteriumTreeListener criteriumTreeListener : this.listeners) {
            try {
                criteriumTreeListener.nodeRemoved(this, criteriumTreeNode);
            }
            catch (Exception ex) {
                Logger.logException(ex, "Remove Tree Node");
            }
        }
    }
}
