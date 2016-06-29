package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph;

import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import java.util.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.awt.event.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.utils.*;

public class SingleCallGraphBaseTreeNode extends AbstractBaseTreeNode
{
    private static final Icon CALLGRAPH_ICON;
    private List functionNodes;
    private SingleDiffNode lastSelectedTreeNode;
    
    public SingleCallGraphBaseTreeNode(final SingleCallGraphRootTreeNode singleCallGraphRootTreeNode) {
        super(singleCallGraphRootTreeNode);
        this.functionNodes = new ArrayList();
        this.createChildren();
    }
    
    @Override
    protected void delete() {
        super.delete();
        this.functionNodes.clear();
        this.functionNodes = null;
        this.lastSelectedTreeNode = null;
    }
    
    @Override
    protected void updateTreeNodes(final boolean b) {
        final TreeNodeSearcher searcher = this.getSearcher();
        final GraphNodeMultiFilter filter = this.getFilter();
        final ArrayList<SingleCallGraphFunctionTreeNode> list = new ArrayList<SingleCallGraphFunctionTreeNode>();
        if (searcher.getUseTemporaryResults() && !"".equals(searcher.getSearchString())) {
            for (int i = 1; i < this.getChildCount(); ++i) {
                list.add((SingleCallGraphFunctionTreeNode)this.getChildAt(i));
            }
        }
        else {
            list.addAll((Collection<?>)this.functionNodes);
        }
        this.removeAllChildren();
        final ArrayList list2 = new ArrayList();
        if (b) {
            if (!"".equals(searcher.getSearchString())) {
                final List search = searcher.search(list);
                list.clear();
                final Iterator<ISearchableTreeNode> iterator = search.iterator();
                while (iterator.hasNext()) {
                    list.add((SingleCallGraphFunctionTreeNode)iterator.next());
                }
            }
            else {
                searcher.search((List)null);
            }
        }
        final ArrayList<Object> list3 = new ArrayList<Object>();
        for (final SingleCallGraphFunctionTreeNode singleCallGraphFunctionTreeNode : list) {
            if (filter.filterRawFunction(singleCallGraphFunctionTreeNode.getFunction())) {
                if (!b && !"".equals(searcher.getSearchString())) {
                    if (!searcher.isSearchHit(singleCallGraphFunctionTreeNode.getSingleDiffNode())) {
                        continue;
                    }
                    list3.add(singleCallGraphFunctionTreeNode);
                }
                else {
                    list3.add(singleCallGraphFunctionTreeNode);
                }
            }
        }
        final Iterator<Comparator<? super Object>> iterator3 = (Iterator<Comparator<? super Object>>)this.getRootNode().getSorter().getSingleFunctionTreeNodeComparatorList().iterator();
        while (iterator3.hasNext()) {
            Collections.sort(list3, iterator3.next());
        }
        final Iterator<SingleCallGraphFunctionTreeNode> iterator4 = list3.iterator();
        while (iterator4.hasNext()) {
            this.add(iterator4.next());
        }
        this.getTree().getModel().nodeStructureChanged(this);
        this.getTree().updateUI();
    }
    
    @Override
    public void createChildren() {
        this.functionNodes.clear();
        final Iterator<SingleDiffNode> iterator = this.getRootNode().getGraph().getNodes().iterator();
        while (iterator.hasNext()) {
            this.functionNodes.add(new SingleCallGraphFunctionTreeNode(this.getRootNode(), iterator.next()));
        }
        this.updateTreeNodes(false);
    }
    
    @Override
    public Icon getIcon() {
        return SingleCallGraphBaseTreeNode.CALLGRAPH_ICON;
    }
    
    public SingleDiffNode getLastSelectedGraphNode() {
        return this.lastSelectedTreeNode;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        final JPopupMenu popupMenu = new JPopupMenu();
        final ESide side = this.getRootNode().getSide();
        final JMenuItem menuItem = new JMenuItem(new SingleCallGraphBaseTreeNode$1(this, "Copy Image Name", side));
        final JMenuItem menuItem2 = new JMenuItem(new SingleCallGraphBaseTreeNode$2(this, "Copy Image Hash", side));
        final JMenuItem menuItem3 = new JMenuItem(new SingleCallGraphBaseTreeNode$3(this, "Copy IDB Name", side));
        popupMenu.add(menuItem);
        popupMenu.add(menuItem2);
        popupMenu.add(menuItem3);
        return popupMenu;
    }
    
    @Override
    public SingleCallGraphRootTreeNode getRootNode() {
        return (SingleCallGraphRootTreeNode)this.getAbstractRootNode();
    }
    
    @Override
    public String getTooltipText() {
        return null;
    }
    
    @Override
    public void handleMouseEvent(final MouseEvent mouseEvent) {
        if (mouseEvent.isPopupTrigger()) {
            this.getPopupMenu().show(this.getTree(), mouseEvent.getX(), mouseEvent.getY());
        }
    }
    
    @Override
    public boolean isSelected() {
        return false;
    }
    
    @Override
    public boolean isVisible() {
        return true;
    }
    
    public void setLastSelectedGraphNode(final SingleDiffNode lastSelectedTreeNode) {
        this.lastSelectedTreeNode = lastSelectedTreeNode;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%d / %d)", "Call Graph", this.getChildCount(), this.functionNodes.size());
    }
    
    static {
        CALLGRAPH_ICON = ImageUtils.getImageIcon("data/treeicons/callgraph.png");
    }
}
