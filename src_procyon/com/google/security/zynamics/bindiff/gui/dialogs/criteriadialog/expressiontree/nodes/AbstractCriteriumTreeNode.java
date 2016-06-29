package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes;

import com.google.security.zynamics.zylib.gui.jtree.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import java.util.*;
import javax.swing.*;

public abstract class AbstractCriteriumTreeNode extends IconNode
{
    private final ICriterium criterium;
    
    public AbstractCriteriumTreeNode(final ICriterium criterium) {
        this.criterium = criterium;
    }
    
    private boolean allowAppendAndOrOperator() {
        return this.getCriterium().getType() != CriteriumType.NOT || this.getChildCount() == 0;
    }
    
    private boolean allowAppendCondition() {
        final int childCount = this.getChildCount();
        final CriteriumType type = this.getCriterium().getType();
        return (type == CriteriumType.CONDITION && this.isRoot() && childCount == 0) || type != CriteriumType.NOT || this.getChildCount() == 0;
    }
    
    private boolean allowAppendNotOperator() {
        return this.getCriterium().getType() != CriteriumType.NOT;
    }
    
    private boolean allowInsertAndOrOperator() {
        return this.getChildCount() > 0;
    }
    
    private boolean allowInsertCondition() {
        return false;
    }
    
    private boolean allowInsertNotOperator() {
        final CriteriumType type = this.getCriterium().getType();
        final int childCount = this.getChildCount();
        return type != CriteriumType.NOT && childCount == 1 && this.children.get(0).getCriterium().getType() != CriteriumType.NOT;
    }
    
    public boolean allowAppend(final CriteriumType criteriumType) {
        if (this.isRoot() && this.getChildCount() > 0) {
            return false;
        }
        if (this.getCriterium().getType() == CriteriumType.CONDITION && !this.isRoot()) {
            return false;
        }
        if (criteriumType == CriteriumType.CONDITION) {
            return this.allowAppendCondition();
        }
        if (criteriumType == CriteriumType.AND || criteriumType == CriteriumType.OR) {
            return this.allowAppendAndOrOperator();
        }
        return criteriumType == CriteriumType.NOT && this.allowAppendNotOperator();
    }
    
    public boolean allowInsert(final CriteriumType criteriumType) {
        if (this.getCriterium().getType() == CriteriumType.CONDITION && !this.isRoot()) {
            return false;
        }
        if (criteriumType == CriteriumType.CONDITION) {
            return this.allowInsertCondition();
        }
        if (criteriumType == CriteriumType.AND || criteriumType == CriteriumType.OR) {
            return this.allowInsertAndOrOperator();
        }
        return criteriumType != CriteriumType.NOT || this.allowInsertNotOperator();
    }
    
    public void deleteChildren() {
        final Enumeration children = this.children();
        while (children.hasMoreElements()) {
            children.nextElement().deleteChildren();
        }
        this.removeAllChildren();
    }
    
    public ICriterium getCriterium() {
        return this.criterium;
    }
    
    public abstract JPopupMenu getPopupMenu();
}
