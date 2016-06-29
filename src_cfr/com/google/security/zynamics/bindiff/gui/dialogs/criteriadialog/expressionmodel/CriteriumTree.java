/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.root.RootCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.ICriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ICriteriumTreeListener;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import java.util.Iterator;
import java.util.List;

public class CriteriumTree {
    private final ListenerProvider listeners = new ListenerProvider();
    private final CriteriumTreeNode rootNode = new CriteriumTreeNode(new RootCriterium());

    public void addListener(ICriteriumTreeListener iCriteriumTreeListener) {
        this.listeners.addListener(iCriteriumTreeListener);
    }

    public void appendNode(ICriteriumTreeNode iCriteriumTreeNode) {
        this.appendNode(this.rootNode, iCriteriumTreeNode);
    }

    public void appendNode(ICriteriumTreeNode iCriteriumTreeNode, ICriteriumTreeNode iCriteriumTreeNode2) {
        CriteriumTreeNode.append(iCriteriumTreeNode, iCriteriumTreeNode2);
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ICriteriumTreeListener iCriteriumTreeListener = (ICriteriumTreeListener)iterator.next();
            try {
                iCriteriumTreeListener.nodeAppended(this, iCriteriumTreeNode, iCriteriumTreeNode2);
            }
            catch (Exception var5_5) {
                Logger.logException(var5_5, "Append Tree Node.");
                continue;
            }
        }
    }

    public ICriteriumTreeNode getRoot() {
        return this.rootNode;
    }

    public ICriterium getRootCriterium() {
        return this.rootNode.getCriterium();
    }

    public void insertNode(ICriteriumTreeNode iCriteriumTreeNode) {
        this.insertNode(this.rootNode, iCriteriumTreeNode);
    }

    public void insertNode(ICriteriumTreeNode iCriteriumTreeNode, ICriteriumTreeNode iCriteriumTreeNode2) {
        CriteriumTreeNode.insert(iCriteriumTreeNode, iCriteriumTreeNode2);
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ICriteriumTreeListener iCriteriumTreeListener = (ICriteriumTreeListener)iterator.next();
            try {
                iCriteriumTreeListener.nodeInserted(this, iCriteriumTreeNode, iCriteriumTreeNode2);
            }
            catch (Exception var5_5) {
                Logger.logException(var5_5, "Insert Tree Node.");
                continue;
            }
        }
    }

    public void removeAll() {
        if (this.rootNode.getChildren().size() == 1) {
            this.removeNode((ICriteriumTreeNode)this.rootNode.getChildren().get(0));
        }
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ICriteriumTreeListener iCriteriumTreeListener = (ICriteriumTreeListener)iterator.next();
            try {
                iCriteriumTreeListener.removedAll(this);
            }
            catch (Exception var3_3) {
                Logger.logException(var3_3, "Remove all Tree Nodes");
                continue;
            }
        }
    }

    public void removeListener(ICriteriumTreeListener iCriteriumTreeListener) {
        this.listeners.removeListener(iCriteriumTreeListener);
    }

    public void removeNode(ICriteriumTreeNode iCriteriumTreeNode) {
        CriteriumTreeNode.remove(iCriteriumTreeNode);
        ICriteriumTreeNode iCriteriumTreeNode2 = iCriteriumTreeNode.getParent();
        iCriteriumTreeNode2.getChildren().remove(iCriteriumTreeNode);
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ICriteriumTreeListener iCriteriumTreeListener = (ICriteriumTreeListener)iterator.next();
            try {
                iCriteriumTreeListener.nodeRemoved(this, iCriteriumTreeNode);
            }
            catch (Exception var5_5) {
                Logger.logException(var5_5, "Remove Tree Node");
                continue;
            }
        }
    }
}

