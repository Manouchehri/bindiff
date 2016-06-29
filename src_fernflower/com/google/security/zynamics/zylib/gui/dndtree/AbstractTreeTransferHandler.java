package com.google.security.zynamics.zylib.gui.dndtree;

import com.google.security.zynamics.zylib.gui.dndtree.DNDTree;
import com.google.security.zynamics.zylib.gui.dndtree.TransferableNode;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public abstract class AbstractTreeTransferHandler implements DragGestureListener, DragSourceListener, DropTargetListener {
   private static DefaultMutableTreeNode draggedNode;
   private static BufferedImage image = null;
   private final DNDTree tree;
   private final DragSource dragSource;
   private final DropTarget dropTarget;
   private DefaultMutableTreeNode draggedNodeParent;
   private final Rectangle rect2D = new Rectangle();
   private final boolean drawImage;

   protected AbstractTreeTransferHandler(DNDTree var1, int var2, boolean var3) {
      this.tree = var1;
      this.drawImage = var3;
      this.dragSource = new DragSource();
      this.dragSource.createDefaultDragGestureRecognizer(var1, var2, this);
      this.dropTarget = new DropTarget(var1, var2, this);
   }

   private final void clearImage() {
      this.tree.paintImmediately(this.rect2D.getBounds());
   }

   private final void paintImage(Point var1) {
      if(image != null) {
         this.tree.paintImmediately(this.rect2D.getBounds());
         this.rect2D.setRect((double)((int)var1.getX()), (double)((int)var1.getY()), (double)image.getWidth(), (double)image.getHeight());
         this.tree.getGraphics().drawImage(image, (int)var1.getX(), (int)var1.getY(), this.tree);
      }

   }

   protected abstract boolean canPerformAction(DNDTree var1, DataFlavor var2, Transferable var3, int var4, Point var5);

   protected abstract boolean executeDrop(DNDTree var1, Transferable var2, DefaultMutableTreeNode var3, int var4);

   public abstract boolean canPerformAction(DNDTree var1, DefaultMutableTreeNode var2, int var3, Point var4);

   public void dragDropEnd(DragSourceDropEvent var1) {
      if(var1.getDropSuccess() && var1.getDropAction() == 2 && this.draggedNodeParent != null) {
         ((DefaultTreeModel)this.tree.getModel()).nodeStructureChanged(this.draggedNodeParent);
      }

   }

   public final void dragEnter(DragSourceDragEvent var1) {
      int var2 = var1.getDropAction();
      if(var2 == 1) {
         var1.getDragSourceContext().setCursor(DragSource.DefaultCopyDrop);
      } else if(var2 == 2) {
         var1.getDragSourceContext().setCursor(DragSource.DefaultMoveDrop);
      } else {
         var1.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
      }

   }

   public final void dragEnter(DropTargetDragEvent var1) {
      Point var2 = var1.getLocation();
      int var3 = var1.getDropAction();
      if(this.drawImage) {
         this.paintImage(var2);
      }

      Transferable var4 = var1.getTransferable();
      if(!var4.isDataFlavorSupported(TransferableNode.NODE_FLAVOR)) {
         if(this.canPerformAction(this.tree, (DataFlavor)var1.getCurrentDataFlavorsAsList().get(0), var1.getTransferable(), var3, var2)) {
            var1.acceptDrag(var3);
         } else {
            var1.rejectDrag();
         }
      } else if(this.canPerformAction(this.tree, draggedNode, var3, var2)) {
         var1.acceptDrag(var3);
      } else {
         var1.rejectDrag();
      }

   }

   public final void dragExit(DragSourceEvent var1) {
      var1.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
   }

   public final void dragExit(DropTargetEvent var1) {
      if(this.drawImage) {
         this.clearImage();
      }

   }

   public final void dragGestureRecognized(DragGestureEvent var1) {
      TreePath var2 = this.tree.getPathForLocation(var1.getDragOrigin().x, var1.getDragOrigin().y);
      if(var2 != null) {
         draggedNode = (DefaultMutableTreeNode)var2.getLastPathComponent();
         this.draggedNodeParent = (DefaultMutableTreeNode)draggedNode.getParent();
         if(this.drawImage) {
            Rectangle var3 = this.tree.getPathBounds(var2);
            JComponent var4 = (JComponent)this.tree.getCellRenderer().getTreeCellRendererComponent(this.tree, draggedNode, false, this.tree.isExpanded(var2), ((DefaultTreeModel)this.tree.getModel()).isLeaf(var2.getLastPathComponent()), 0, false);
            var4.setBounds(var3);
            image = new BufferedImage(var4.getWidth(), var4.getHeight(), 3);
            Graphics2D var5 = image.createGraphics();
            var5.setComposite(AlphaComposite.getInstance(3, 0.5F));
            var4.setOpaque(false);
            var4.paint(var5);
            var5.dispose();
         }

         this.dragSource.startDrag(var1, DragSource.DefaultMoveNoDrop, image, new Point(0, 0), new TransferableNode(draggedNode), this);
      }

   }

   public final void dragOver(DragSourceDragEvent var1) {
      int var2 = var1.getDropAction();
      if(var2 == 1) {
         var1.getDragSourceContext().setCursor(DragSource.DefaultCopyDrop);
      } else if(var2 == 2) {
         var1.getDragSourceContext().setCursor(DragSource.DefaultMoveDrop);
      } else {
         var1.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
      }

   }

   public final void dragOver(DropTargetDragEvent var1) {
      Point var2 = var1.getLocation();
      int var3 = var1.getDropAction();
      this.tree.autoscroll(var2);
      if(this.drawImage) {
         this.paintImage(var2);
      }

      Transferable var4 = var1.getTransferable();
      if(!var4.isDataFlavorSupported(TransferableNode.NODE_FLAVOR)) {
         if(this.canPerformAction(this.tree, (DataFlavor)var1.getCurrentDataFlavorsAsList().get(0), var1.getTransferable(), var3, var2)) {
            var1.acceptDrag(var3);
         } else {
            var1.rejectDrag();
         }
      } else if(this.canPerformAction(this.tree, draggedNode, var3, var2)) {
         var1.acceptDrag(var3);
      } else {
         var1.rejectDrag();
      }

   }

   public final void drop(DropTargetDropEvent var1) {
      if(this.drawImage) {
         this.clearImage();
      }

      int var2 = var1.getDropAction();
      Transferable var3 = var1.getTransferable();
      Point var4 = var1.getLocation();
      DefaultMutableTreeNode var6;
      if(var3.isDataFlavorSupported(TransferableNode.NODE_FLAVOR) && this.canPerformAction(this.tree, draggedNode, var2, var4)) {
         boolean var11 = false;
         var6 = null;

         try {
            var6 = (DefaultMutableTreeNode)var3.getTransferData(TransferableNode.NODE_FLAVOR);
            var11 = true;
         } catch (IOException var9) {
            System.out.println(var9);
         } catch (UnsupportedFlavorException var10) {
            System.out.println(var10);
         }

         if(var11) {
            TreePath var7 = this.tree.getPathForLocation(var4.x, var4.y);
            DefaultMutableTreeNode var8 = (DefaultMutableTreeNode)var7.getLastPathComponent();
            if(this.executeDrop(this.tree, var6, var8, var2)) {
               var1.acceptDrop(var2);
               var1.dropComplete(true);
               return;
            }
         }
      } else if(this.canPerformAction(this.tree, var1.getCurrentDataFlavors()[0], var1.getTransferable(), var2, var4)) {
         TreePath var5 = this.tree.getPathForLocation(var4.x, var4.y);
         var6 = (DefaultMutableTreeNode)var5.getLastPathComponent();
         if(this.executeDrop(this.tree, var1.getTransferable(), var6, var2)) {
            var1.acceptDrop(var2);
            var1.dropComplete(true);
            return;
         }
      }

      var1.rejectDrop();
      var1.dropComplete(false);
   }

   public final void dropActionChanged(DragSourceDragEvent var1) {
      int var2 = var1.getDropAction();
      if(var2 == 1) {
         var1.getDragSourceContext().setCursor(DragSource.DefaultCopyDrop);
      } else if(var2 == 2) {
         var1.getDragSourceContext().setCursor(DragSource.DefaultMoveDrop);
      } else {
         var1.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
      }

   }

   public final void dropActionChanged(DropTargetDragEvent var1) {
      Point var2 = var1.getLocation();
      int var3 = var1.getDropAction();
      if(this.drawImage) {
         this.paintImage(var2);
      }

      if(draggedNode == null) {
         if(this.canPerformAction(this.tree, (DataFlavor)var1.getCurrentDataFlavorsAsList().get(0), var1.getTransferable(), var3, var2)) {
            var1.acceptDrag(var3);
         } else {
            var1.rejectDrag();
         }
      } else if(this.canPerformAction(this.tree, draggedNode, var3, var2)) {
         var1.acceptDrag(var3);
      } else {
         var1.rejectDrag();
      }

   }

   public abstract boolean executeDrop(DNDTree var1, DefaultMutableTreeNode var2, DefaultMutableTreeNode var3, int var4);

   public DropTarget getDropTarget() {
      return this.dropTarget;
   }
}
