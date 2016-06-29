package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import java.util.*;

public class ExpressionTreeValidator
{
    public static boolean isValid(final JCriteriumTree criteriumTree) {
        final CriteriumTreeNode criteriumTreeNode = (CriteriumTreeNode)criteriumTree.getModel().getRoot();
        if (criteriumTreeNode.getChildCount() != 1) {
            return false;
        }
        final Enumeration breadthFirstEnumeration = criteriumTreeNode.breadthFirstEnumeration();
        while (breadthFirstEnumeration.hasMoreElements()) {
            final CriteriumTreeNode criteriumTreeNode2 = breadthFirstEnumeration.nextElement();
            final CriteriumType type = criteriumTreeNode2.getCriterium().getType();
            final int childCount = criteriumTreeNode2.getChildCount();
            if ((type == CriteriumType.AND || type == CriteriumType.OR) && childCount < 2) {
                return false;
            }
            if (type == CriteriumType.NOT && childCount != 1) {
                return false;
            }
        }
        return true;
    }
}
