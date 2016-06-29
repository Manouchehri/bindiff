package com.google.security.zynamics.zylib.gui.dndtree;

import java.awt.image.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.dnd.*;
import java.io.*;
import java.awt.datatransfer.*;

public abstract class AbstractTreeTransferHandler implements DragGestureListener, DragSourceListener, DropTargetListener
{
    private static DefaultMutableTreeNode draggedNode;
    private static BufferedImage image;
    private final DNDTree tree;
    private final DragSource dragSource;
    private final DropTarget dropTarget;
    private DefaultMutableTreeNode draggedNodeParent;
    private final Rectangle rect2D;
    private final boolean drawImage;
    
    protected AbstractTreeTransferHandler(final DNDTree tree, final int n, final boolean drawImage) {
        this.rect2D = new Rectangle();
        this.tree = tree;
        this.drawImage = drawImage;
        (this.dragSource = new DragSource()).createDefaultDragGestureRecognizer(tree, n, this);
        this.dropTarget = new DropTarget(tree, n, this);
    }
    
    private final void clearImage() {
        this.tree.paintImmediately(this.rect2D.getBounds());
    }
    
    private final void paintImage(final Point point) {
        if (AbstractTreeTransferHandler.image != null) {
            this.tree.paintImmediately(this.rect2D.getBounds());
            this.rect2D.setRect((int)point.getX(), (int)point.getY(), AbstractTreeTransferHandler.image.getWidth(), AbstractTreeTransferHandler.image.getHeight());
            this.tree.getGraphics().drawImage(AbstractTreeTransferHandler.image, (int)point.getX(), (int)point.getY(), this.tree);
        }
    }
    
    protected abstract boolean canPerformAction(final DNDTree p0, final DataFlavor p1, final Transferable p2, final int p3, final Point p4);
    
    protected abstract boolean executeDrop(final DNDTree p0, final Transferable p1, final DefaultMutableTreeNode p2, final int p3);
    
    public abstract boolean canPerformAction(final DNDTree p0, final DefaultMutableTreeNode p1, final int p2, final Point p3);
    
    @Override
    public void dragDropEnd(final DragSourceDropEvent dragSourceDropEvent) {
        if (dragSourceDropEvent.getDropSuccess() && dragSourceDropEvent.getDropAction() == 2 && this.draggedNodeParent != null) {
            ((DefaultTreeModel)this.tree.getModel()).nodeStructureChanged(this.draggedNodeParent);
        }
    }
    
    @Override
    public final void dragEnter(final DragSourceDragEvent dragSourceDragEvent) {
        final int dropAction = dragSourceDragEvent.getDropAction();
        if (dropAction == 1) {
            dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultCopyDrop);
        }
        else if (dropAction == 2) {
            dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultMoveDrop);
        }
        else {
            dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
        }
    }
    
    @Override
    public final void dragEnter(final DropTargetDragEvent dropTargetDragEvent) {
        final Point location = dropTargetDragEvent.getLocation();
        final int dropAction = dropTargetDragEvent.getDropAction();
        if (this.drawImage) {
            this.paintImage(location);
        }
        if (!dropTargetDragEvent.getTransferable().isDataFlavorSupported(TransferableNode.NODE_FLAVOR)) {
            if (this.canPerformAction(this.tree, dropTargetDragEvent.getCurrentDataFlavorsAsList().get(0), dropTargetDragEvent.getTransferable(), dropAction, location)) {
                dropTargetDragEvent.acceptDrag(dropAction);
            }
            else {
                dropTargetDragEvent.rejectDrag();
            }
        }
        else if (this.canPerformAction(this.tree, AbstractTreeTransferHandler.draggedNode, dropAction, location)) {
            dropTargetDragEvent.acceptDrag(dropAction);
        }
        else {
            dropTargetDragEvent.rejectDrag();
        }
    }
    
    @Override
    public final void dragExit(final DragSourceEvent dragSourceEvent) {
        dragSourceEvent.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
    }
    
    @Override
    public final void dragExit(final DropTargetEvent dropTargetEvent) {
        if (this.drawImage) {
            this.clearImage();
        }
    }
    
    @Override
    public final void dragGestureRecognized(final DragGestureEvent dragGestureEvent) {
        final TreePath pathForLocation = this.tree.getPathForLocation(dragGestureEvent.getDragOrigin().x, dragGestureEvent.getDragOrigin().y);
        if (pathForLocation != null) {
            AbstractTreeTransferHandler.draggedNode = (DefaultMutableTreeNode)pathForLocation.getLastPathComponent();
            this.draggedNodeParent = (DefaultMutableTreeNode)AbstractTreeTransferHandler.draggedNode.getParent();
            if (this.drawImage) {
                final Rectangle pathBounds = this.tree.getPathBounds(pathForLocation);
                final JComponent component = (JComponent)this.tree.getCellRenderer().getTreeCellRendererComponent(this.tree, AbstractTreeTransferHandler.draggedNode, false, this.tree.isExpanded(pathForLocation), ((DefaultTreeModel)this.tree.getModel()).isLeaf(pathForLocation.getLastPathComponent()), 0, false);
                component.setBounds(pathBounds);
                AbstractTreeTransferHandler.image = new BufferedImage(component.getWidth(), component.getHeight(), 3);
                final Graphics2D graphics = AbstractTreeTransferHandler.image.createGraphics();
                graphics.setComposite(AlphaComposite.getInstance(3, 0.5f));
                component.setOpaque(false);
                component.paint(graphics);
                graphics.dispose();
            }
            this.dragSource.startDrag(dragGestureEvent, DragSource.DefaultMoveNoDrop, AbstractTreeTransferHandler.image, new Point(0, 0), new TransferableNode(AbstractTreeTransferHandler.draggedNode), this);
        }
    }
    
    @Override
    public final void dragOver(final DragSourceDragEvent dragSourceDragEvent) {
        final int dropAction = dragSourceDragEvent.getDropAction();
        if (dropAction == 1) {
            dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultCopyDrop);
        }
        else if (dropAction == 2) {
            dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultMoveDrop);
        }
        else {
            dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
        }
    }
    
    @Override
    public final void dragOver(final DropTargetDragEvent dropTargetDragEvent) {
        final Point location = dropTargetDragEvent.getLocation();
        final int dropAction = dropTargetDragEvent.getDropAction();
        this.tree.autoscroll(location);
        if (this.drawImage) {
            this.paintImage(location);
        }
        if (!dropTargetDragEvent.getTransferable().isDataFlavorSupported(TransferableNode.NODE_FLAVOR)) {
            if (this.canPerformAction(this.tree, dropTargetDragEvent.getCurrentDataFlavorsAsList().get(0), dropTargetDragEvent.getTransferable(), dropAction, location)) {
                dropTargetDragEvent.acceptDrag(dropAction);
            }
            else {
                dropTargetDragEvent.rejectDrag();
            }
        }
        else if (this.canPerformAction(this.tree, AbstractTreeTransferHandler.draggedNode, dropAction, location)) {
            dropTargetDragEvent.acceptDrag(dropAction);
        }
        else {
            dropTargetDragEvent.rejectDrag();
        }
    }
    
    @Override
    public final void drop(final DropTargetDropEvent dropTargetDropEvent) {
        if (this.drawImage) {
            this.clearImage();
        }
        final int dropAction = dropTargetDropEvent.getDropAction();
        final Transferable transferable = dropTargetDropEvent.getTransferable();
        final Point location = dropTargetDropEvent.getLocation();
        if (transferable.isDataFlavorSupported(TransferableNode.NODE_FLAVOR) && this.canPerformAction(this.tree, AbstractTreeTransferHandler.draggedNode, dropAction, location)) {
            boolean b = false;
            DefaultMutableTreeNode defaultMutableTreeNode = null;
            try {
                defaultMutableTreeNode = (DefaultMutableTreeNode)transferable.getTransferData(TransferableNode.NODE_FLAVOR);
                b = true;
            }
            catch (IOException ex) {
                System.out.println(ex);
            }
            catch (UnsupportedFlavorException ex2) {
                System.out.println(ex2);
            }
            if (b && this.executeDrop(this.tree, defaultMutableTreeNode, (DefaultMutableTreeNode)this.tree.getPathForLocation(location.x, location.y).getLastPathComponent(), dropAction)) {
                dropTargetDropEvent.acceptDrop(dropAction);
                dropTargetDropEvent.dropComplete(true);
                return;
            }
        }
        else if (this.canPerformAction(this.tree, dropTargetDropEvent.getCurrentDataFlavors()[0], dropTargetDropEvent.getTransferable(), dropAction, location) && this.executeDrop(this.tree, dropTargetDropEvent.getTransferable(), (DefaultMutableTreeNode)this.tree.getPathForLocation(location.x, location.y).getLastPathComponent(), dropAction)) {
            dropTargetDropEvent.acceptDrop(dropAction);
            dropTargetDropEvent.dropComplete(true);
            return;
        }
        dropTargetDropEvent.rejectDrop();
        dropTargetDropEvent.dropComplete(false);
    }
    
    @Override
    public final void dropActionChanged(final DragSourceDragEvent dragSourceDragEvent) {
        final int dropAction = dragSourceDragEvent.getDropAction();
        if (dropAction == 1) {
            dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultCopyDrop);
        }
        else if (dropAction == 2) {
            dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultMoveDrop);
        }
        else {
            dragSourceDragEvent.getDragSourceContext().setCursor(DragSource.DefaultMoveNoDrop);
        }
    }
    
    @Override
    public final void dropActionChanged(final DropTargetDragEvent dropTargetDragEvent) {
        final Point location = dropTargetDragEvent.getLocation();
        final int dropAction = dropTargetDragEvent.getDropAction();
        if (this.drawImage) {
            this.paintImage(location);
        }
        if (AbstractTreeTransferHandler.draggedNode == null) {
            if (this.canPerformAction(this.tree, dropTargetDragEvent.getCurrentDataFlavorsAsList().get(0), dropTargetDragEvent.getTransferable(), dropAction, location)) {
                dropTargetDragEvent.acceptDrag(dropAction);
            }
            else {
                dropTargetDragEvent.rejectDrag();
            }
        }
        else if (this.canPerformAction(this.tree, AbstractTreeTransferHandler.draggedNode, dropAction, location)) {
            dropTargetDragEvent.acceptDrag(dropAction);
        }
        else {
            dropTargetDragEvent.rejectDrag();
        }
    }
    
    public abstract boolean executeDrop(final DNDTree p0, final DefaultMutableTreeNode p1, final DefaultMutableTreeNode p2, final int p3);
    
    public DropTarget getDropTarget() {
        return this.dropTarget;
    }
    
    static {
        AbstractTreeTransferHandler.image = null;
    }
}
