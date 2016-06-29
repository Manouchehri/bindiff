package com.google.security.zynamics.zylib.gui.dndtree;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.util.Arrays;
import javax.swing.tree.DefaultMutableTreeNode;

public class TransferableNode implements Transferable {
   public static final DataFlavor NODE_FLAVOR = new DataFlavor("application/x-java-jvm-local-objectref", "Node");
   private final DefaultMutableTreeNode node;
   private final DataFlavor[] flavors;

   public TransferableNode(DefaultMutableTreeNode var1) {
      this.flavors = new DataFlavor[]{NODE_FLAVOR};
      this.node = var1;
   }

   public synchronized Object getTransferData(DataFlavor var1) {
      if(var1 == NODE_FLAVOR) {
         return this.node;
      } else {
         throw new UnsupportedFlavorException(var1);
      }
   }

   public DataFlavor[] getTransferDataFlavors() {
      return this.flavors;
   }

   public boolean isDataFlavorSupported(DataFlavor var1) {
      return Arrays.asList(this.flavors).contains(var1);
   }
}
