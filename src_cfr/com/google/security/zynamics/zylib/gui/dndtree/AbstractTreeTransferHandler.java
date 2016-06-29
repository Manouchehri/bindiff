/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.dndtree;

import com.google.security.zynamics.zylib.gui.dndtree.DNDTree;
import com.google.security.zynamics.zylib.gui.dndtree.TransferableNode;
import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceContext;
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
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public abstract class AbstractTreeTransferHandler
implements DragGestureListener,
DragSourceListener,
DropTargetListener {
    private static DefaultMutableTreeNode draggedNode;
    private static BufferedImage image;
    private final DNDTree tree;
    private final DragSource dragSource;
    private final DropTarget dropTarget;
    private DefaultMutableTreeNode draggedNodeParent;
    private final Rectangle rect2D = new Rectangle();
    private final boolean drawImage;

    protected AbstractTreeTransferHandler(DNDTree dNDTree, int n2, boolean bl2) {
        this.tree = dNDTree;
        this.drawImage = bl2;
        this.dragSource = new DragSource();
        this.dragSource.createDefaultDragGestureRecognizer(dNDTree, n2, this);
        this.dropTarget = new DropTarget(dNDTree, n2, this);
    }

    private final void clearImage() {
        this.tree.paintImmediately(this.rect2D.getBounds());
    }

    private final void paintImage(Point point) {
        if (image == null) return;
        this.tree.paintImmediately(this.rect2D.getBounds());
        this.rect2D.setRect((int)point.getX(), (int)point.getY(), image.getWidth(), image.getHeight());
        this.tree.getGraphics().drawImage(image, (int)point.getX(), (int)point.getY(), this.tree);
    }

    protected abstract boolean canPerformAction(DNDTree var1, DataFlavor var2, Transferable var3, int var4, Point var5);

    protected abstract boolean executeDrop(DNDTree var1, Transferable var2, DefaultMutableTreeNode var3, int var4);

    public abstract boolean canPerformAction(DNDTree var1, DefaultMutableTreeNode var2, int var3, Point var4);

    @Override
    public void dragDropEnd(DragSourceDropEvent dragSourceDropEvent) {
        if (!dragSourceDropEvent.getDropSuccess()) return;
        if (dragSourceDropEvent.getDropAction() != 2) return;
        if (this.draggedNodeParent == null) return;
        ((DefaultTreeModel)this.tree.getModel()).nodeStructureChanged(this.draggedNodeParent);
    }

    @Override
    public final void dragEnter(DragSourceDragEvent dragSourceDragEvent) {
        int n2 = dragSourceDragEvent.getDropAction();
        if (n2 == 1) {
            dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultCopyDrop);
            return;
        }
        if (n2 == 2) {
            dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultMoveDrop);
            return;
        }
        dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
    }

    @Override
    public final void dragEnter(DropTargetDragEvent dropTargetDragEvent) {
        Transferable transferable;
        Point point = dropTargetDragEvent.getLocation();
        int n2 = dropTargetDragEvent.getDropAction();
        if (this.drawImage) {
            this.paintImage(point);
        }
        if (!(transferable = dropTargetDragEvent.getTransferable()).isDataFlavorSupported(TransferableNode.NODE_FLAVOR)) {
            if (this.canPerformAction(this.tree, dropTargetDragEvent.getCurrentDataFlavorsAsList().get(0), dropTargetDragEvent.getTransferable(), n2, point)) {
                dropTargetDragEvent.acceptDrag(n2);
                return;
            }
            dropTargetDragEvent.rejectDrag();
            return;
        }
        if (this.canPerformAction(this.tree, draggedNode, n2, point)) {
            dropTargetDragEvent.acceptDrag(n2);
            return;
        }
        dropTargetDragEvent.rejectDrag();
    }

    @Override
    public final void dragExit(DragSourceEvent dragSourceEvent) {
        dragSourceEvent.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
    }

    @Override
    public final void dragExit(DropTargetEvent dropTargetEvent) {
        if (!this.drawImage) return;
        this.clearImage();
    }

    @Override
    public final void dragGestureRecognized(DragGestureEvent dragGestureEvent) {
        TreePath treePath = this.tree.getPathForLocation(dragGestureEvent.getDragOrigin().x, dragGestureEvent.getDragOrigin().y);
        if (treePath == null) return;
        draggedNode = (DefaultMutableTreeNode)treePath.getLastPathComponent();
        this.draggedNodeParent = (DefaultMutableTreeNode)draggedNode.getParent();
        if (this.drawImage) {
            Rectangle rectangle = this.tree.getPathBounds(treePath);
            JComponent jComponent = (JComponent)this.tree.getCellRenderer().getTreeCellRendererComponent(this.tree, draggedNode, false, this.tree.isExpanded(treePath), ((DefaultTreeModel)this.tree.getModel()).isLeaf(treePath.getLastPathComponent()), 0, false);
            jComponent.setBounds(rectangle);
            image = new BufferedImage(jComponent.getWidth(), jComponent.getHeight(), 3);
            Graphics2D graphics2D = image.createGraphics();
            graphics2D.setComposite(AlphaComposite.getInstance(3, 0.5f));
            jComponent.setOpaque(false);
            jComponent.paint(graphics2D);
            graphics2D.dispose();
        }
        this.dragSource.startDrag(dragGestureEvent, DragSource.DefaultMoveNoDrop, image, new Point(0, 0), new TransferableNode(draggedNode), this);
    }

    @Override
    public final void dragOver(DragSourceDragEvent dragSourceDragEvent) {
        int n2 = dragSourceDragEvent.getDropAction();
        if (n2 == 1) {
            dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultCopyDrop);
            return;
        }
        if (n2 == 2) {
            dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultMoveDrop);
            return;
        }
        dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
    }

    @Override
    public final void dragOver(DropTargetDragEvent dropTargetDragEvent) {
        Transferable transferable;
        Point point = dropTargetDragEvent.getLocation();
        int n2 = dropTargetDragEvent.getDropAction();
        this.tree.autoscroll(point);
        if (this.drawImage) {
            this.paintImage(point);
        }
        if (!(transferable = dropTargetDragEvent.getTransferable()).isDataFlavorSupported(TransferableNode.NODE_FLAVOR)) {
            if (this.canPerformAction(this.tree, dropTargetDragEvent.getCurrentDataFlavorsAsList().get(0), dropTargetDragEvent.getTransferable(), n2, point)) {
                dropTargetDragEvent.acceptDrag(n2);
                return;
            }
            dropTargetDragEvent.rejectDrag();
            return;
        }
        if (this.canPerformAction(this.tree, draggedNode, n2, point)) {
            dropTargetDragEvent.acceptDrag(n2);
            return;
        }
        dropTargetDragEvent.rejectDrag();
    }

    @Override
    public final void drop(DropTargetDropEvent dropTargetDropEvent) {
        if (this.drawImage) {
            this.clearImage();
        }
        int n2 = dropTargetDropEvent.getDropAction();
        Transferable transferable = dropTargetDropEvent.getTransferable();
        Point point = dropTargetDropEvent.getLocation();
        if (transferable.isDataFlavorSupported(TransferableNode.NODE_FLAVOR) && this.canPerformAction(this.tree, draggedNode, n2, point)) {
            TreePath treePath;
            DefaultMutableTreeNode defaultMutableTreeNode;
            boolean bl2 = false;
            DefaultMutableTreeNode defaultMutableTreeNode2 = null;
            try {
                defaultMutableTreeNode2 = (DefaultMutableTreeNode)transferable.getTransferData(TransferableNode.NODE_FLAVOR);
                bl2 = true;
            }
            catch (IOException var7_9) {
                System.out.println(var7_9);
            }
            catch (UnsupportedFlavorException var7_10) {
                System.out.println(var7_10);
            }
            if (bl2 && this.executeDrop(this.tree, defaultMutableTreeNode2, defaultMutableTreeNode = (DefaultMutableTreeNode)(treePath = this.tree.getPathForLocation(point.x, point.y)).getLastPathComponent(), n2)) {
                dropTargetDropEvent.acceptDrop(n2);
                dropTargetDropEvent.dropComplete(true);
                return;
            }
        } else if (this.canPerformAction(this.tree, dropTargetDropEvent.getCurrentDataFlavors()[0], dropTargetDropEvent.getTransferable(), n2, point)) {
            TreePath treePath = this.tree.getPathForLocation(point.x, point.y);
            DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)treePath.getLastPathComponent();
            if (this.executeDrop(this.tree, dropTargetDropEvent.getTransferable(), defaultMutableTreeNode, n2)) {
                dropTargetDropEvent.acceptDrop(n2);
                dropTargetDropEvent.dropComplete(true);
                return;
            }
        }
        dropTargetDropEvent.rejectDrop();
        dropTargetDropEvent.dropComplete(false);
    }

    @Override
    public final void dropActionChanged(DragSourceDragEvent dragSourceDragEvent) {
        int n2 = dragSourceDragEvent.getDropAction();
        if (n2 == 1) {
            dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultCopyDrop);
            return;
        }
        if (n2 == 2) {
            dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultMoveDrop);
            return;
        }
        dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
    }

    @Override
    public final void dropActionChanged(DropTargetDragEvent dropTargetDragEvent) {
        Point point = dropTargetDragEvent.getLocation();
        int n2 = dropTargetDragEvent.getDropAction();
        if (this.drawImage) {
            this.paintImage(point);
        }
        if (draggedNode == null) {
            if (this.canPerformAction(this.tree, dropTargetDragEvent.getCurrentDataFlavorsAsList().get(0), dropTargetDragEvent.getTransferable(), n2, point)) {
                dropTargetDragEvent.acceptDrag(n2);
                return;
            }
            dropTargetDragEvent.rejectDrag();
            return;
        }
        if (this.canPerformAction(this.tree, draggedNode, n2, point)) {
            dropTargetDragEvent.acceptDrag(n2);
            return;
        }
        dropTargetDragEvent.rejectDrag();
    }

    public abstract boolean executeDrop(DNDTree var1, DefaultMutableTreeNode var2, DefaultMutableTreeNode var3, int var4);

    public DropTarget getDropTarget() {
        return this.dropTarget;
    }

    static {
        image = null;
    }
}

