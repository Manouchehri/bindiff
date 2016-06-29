/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.dndtree;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.util.Arrays;
import javax.swing.tree.DefaultMutableTreeNode;

public class TransferableNode
implements Transferable {
    public static final DataFlavor NODE_FLAVOR = new DataFlavor("application/x-java-jvm-local-objectref", "Node");
    private final DefaultMutableTreeNode node;
    private final DataFlavor[] flavors = new DataFlavor[]{NODE_FLAVOR};

    public TransferableNode(DefaultMutableTreeNode defaultMutableTreeNode) {
        this.node = defaultMutableTreeNode;
    }

    @Override
    public synchronized Object getTransferData(DataFlavor dataFlavor) {
        if (dataFlavor != NODE_FLAVOR) throw new UnsupportedFlavorException(dataFlavor);
        return this.node;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return this.flavors;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        return Arrays.asList(this.flavors).contains(dataFlavor);
    }
}

