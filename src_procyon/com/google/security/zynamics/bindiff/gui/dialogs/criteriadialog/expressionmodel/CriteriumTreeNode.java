package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import java.util.*;

public class CriteriumTreeNode implements ICriteriumTreeNode
{
    private final List children;
    private ICriteriumTreeNode parent;
    private final ICriterium criterium;
    
    public CriteriumTreeNode(final ICriterium criterium) {
        this.children = new ArrayList();
        this.criterium = criterium;
    }
    
    public static void append(final ICriteriumTreeNode parent, final ICriteriumTreeNode criteriumTreeNode) {
        parent.getChildren().add(criteriumTreeNode);
        criteriumTreeNode.setParent(parent);
    }
    
    public static void insert(final ICriteriumTreeNode parent, final ICriteriumTreeNode parent2) {
        for (final ICriteriumTreeNode criteriumTreeNode : parent.getChildren()) {
            parent2.getChildren().add(criteriumTreeNode);
            criteriumTreeNode.setParent(parent2);
        }
        parent.getChildren().clear();
        parent.getChildren().add(parent2);
        parent2.setParent(parent);
    }
    
    public static void remove(final ICriteriumTreeNode criteriumTreeNode) {
        final Iterator<ICriteriumTreeNode> iterator = criteriumTreeNode.getChildren().iterator();
        while (iterator.hasNext()) {
            remove(iterator.next());
        }
        criteriumTreeNode.getChildren().clear();
    }
    
    @Override
    public List getChildren() {
        return this.children;
    }
    
    @Override
    public ICriterium getCriterium() {
        return this.criterium;
    }
    
    @Override
    public ICriteriumTreeNode getParent() {
        return this.parent;
    }
    
    @Override
    public void setParent(final ICriteriumTreeNode parent) {
        this.parent = parent;
    }
}
