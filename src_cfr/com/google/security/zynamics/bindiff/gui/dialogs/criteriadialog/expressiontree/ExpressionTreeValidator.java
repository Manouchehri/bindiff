/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTreeModel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.CriteriumTreeNode;
import java.util.Enumeration;

public class ExpressionTreeValidator {
    public static boolean isValid(JCriteriumTree jCriteriumTree) {
        int n2;
        CriteriumType criteriumType;
        CriteriumTreeNode criteriumTreeNode = (CriteriumTreeNode)jCriteriumTree.getModel().getRoot();
        if (criteriumTreeNode.getChildCount() != 1) {
            return false;
        }
        Enumeration enumeration = criteriumTreeNode.breadthFirstEnumeration();
        do {
            if (!enumeration.hasMoreElements()) return true;
            CriteriumTreeNode criteriumTreeNode2 = (CriteriumTreeNode)enumeration.nextElement();
            criteriumType = criteriumTreeNode2.getCriterium().getType();
            n2 = criteriumTreeNode2.getChildCount();
            if (criteriumType != CriteriumType.AND && criteriumType != CriteriumType.OR || n2 >= 2) continue;
            return false;
        } while (criteriumType != CriteriumType.NOT || n2 == 1);
        return false;
    }
}

