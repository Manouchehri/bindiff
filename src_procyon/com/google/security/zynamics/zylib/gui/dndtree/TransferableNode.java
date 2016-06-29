package com.google.security.zynamics.zylib.gui.dndtree;

import javax.swing.tree.*;
import java.awt.datatransfer.*;
import java.util.*;

public class TransferableNode implements Transferable
{
    public static final DataFlavor NODE_FLAVOR;
    private final DefaultMutableTreeNode node;
    private final DataFlavor[] flavors;
    
    public TransferableNode(final DefaultMutableTreeNode node) {
        this.flavors = new DataFlavor[] { TransferableNode.NODE_FLAVOR };
        this.node = node;
    }
    
    @Override
    public synchronized Object getTransferData(final DataFlavor dataFlavor) {
        if (dataFlavor == TransferableNode.NODE_FLAVOR) {
            return this.node;
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }
    
    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return this.flavors;
    }
    
    @Override
    public boolean isDataFlavorSupported(final DataFlavor dataFlavor) {
        return Arrays.asList(this.flavors).contains(dataFlavor);
    }
    
    static {
        NODE_FLAVOR = new DataFlavor("application/x-java-jvm-local-objectref", "Node");
    }
}
