/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.zylib.gui.jtree.IconNode;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JPopupMenu;

public abstract class AbstractCriteriumTreeNode
extends IconNode {
    private final ICriterium criterium;

    public AbstractCriteriumTreeNode(ICriterium iCriterium) {
        this.criterium = iCriterium;
    }

    private boolean allowAppendAndOrOperator() {
        CriteriumType criteriumType = this.getCriterium().getType();
        if (criteriumType != CriteriumType.NOT) {
            return true;
        }
        if (this.getChildCount() != 0) return false;
        return true;
    }

    private boolean allowAppendCondition() {
        int n2 = this.getChildCount();
        CriteriumType criteriumType = this.getCriterium().getType();
        if (criteriumType == CriteriumType.CONDITION && this.isRoot() && n2 == 0) {
            return true;
        }
        if (criteriumType != CriteriumType.NOT) {
            return true;
        }
        if (this.getChildCount() != 0) return false;
        return true;
    }

    private boolean allowAppendNotOperator() {
        CriteriumType criteriumType = this.getCriterium().getType();
        if (criteriumType == CriteriumType.NOT) return false;
        return true;
    }

    private boolean allowInsertAndOrOperator() {
        if (this.getChildCount() <= 0) return false;
        return true;
    }

    private boolean allowInsertCondition() {
        return false;
    }

    private boolean allowInsertNotOperator() {
        CriteriumType criteriumType = this.getCriterium().getType();
        int n2 = this.getChildCount();
        if (criteriumType == CriteriumType.NOT) return false;
        if (n2 != 1) return false;
        if (((AbstractCriteriumTreeNode)this.children.get(0)).getCriterium().getType() == CriteriumType.NOT) return false;
        return true;
    }

    public boolean allowAppend(CriteriumType criteriumType) {
        if (this.isRoot() && this.getChildCount() > 0) {
            return false;
        }
        if (this.getCriterium().getType() == CriteriumType.CONDITION && !this.isRoot()) {
            return false;
        }
        if (criteriumType == CriteriumType.CONDITION) {
            return this.allowAppendCondition();
        }
        if (criteriumType == CriteriumType.AND) return this.allowAppendAndOrOperator();
        if (criteriumType == CriteriumType.OR) {
            return this.allowAppendAndOrOperator();
        }
        if (criteriumType != CriteriumType.NOT) return false;
        return this.allowAppendNotOperator();
    }

    public boolean allowInsert(CriteriumType criteriumType) {
        if (this.getCriterium().getType() == CriteriumType.CONDITION && !this.isRoot()) {
            return false;
        }
        if (criteriumType == CriteriumType.CONDITION) {
            return this.allowInsertCondition();
        }
        if (criteriumType == CriteriumType.AND) return this.allowInsertAndOrOperator();
        if (criteriumType == CriteriumType.OR) {
            return this.allowInsertAndOrOperator();
        }
        if (criteriumType != CriteriumType.NOT) return true;
        return this.allowInsertNotOperator();
    }

    public void deleteChildren() {
        Enumeration enumeration = this.children();
        do {
            if (!enumeration.hasMoreElements()) {
                this.removeAllChildren();
                return;
            }
            ((AbstractCriteriumTreeNode)enumeration.nextElement()).deleteChildren();
        } while (true);
    }

    public ICriterium getCriterium() {
        return this.criterium;
    }

    public abstract JPopupMenu getPopupMenu();
}

