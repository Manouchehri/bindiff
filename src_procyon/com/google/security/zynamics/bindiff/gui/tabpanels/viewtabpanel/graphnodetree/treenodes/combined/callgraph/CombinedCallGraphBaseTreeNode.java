package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph;

import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.utils.*;

public class CombinedCallGraphBaseTreeNode extends AbstractBaseTreeNode
{
    private static final Icon CALLGRAPH_ICON;
    private List functionNodes;
    private CombinedDiffNode lastSelectedTreeNode;
    
    public CombinedCallGraphBaseTreeNode(final CombinedCallGraphRootTreeNode combinedCallGraphRootTreeNode) {
        super(combinedCallGraphRootTreeNode);
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
        final ArrayList<CombinedCallGraphFunctionTreeNode> list = new ArrayList<CombinedCallGraphFunctionTreeNode>();
        if (searcher.getUseTemporaryResults() && !"".equals(searcher.getSearchString())) {
            for (int i = 1; i < this.getChildCount(); ++i) {
                list.add((CombinedCallGraphFunctionTreeNode)this.getChildAt(i));
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
                    list.add((CombinedCallGraphFunctionTreeNode)iterator.next());
                }
            }
            else {
                searcher.search((List)null);
            }
        }
        final ArrayList<Object> list3 = new ArrayList<Object>();
        for (final CombinedCallGraphFunctionTreeNode combinedCallGraphFunctionTreeNode : list) {
            if (filter.filterRawCombinedFunction(combinedCallGraphFunctionTreeNode.getCombinedFunction())) {
                if (!b && !"".equals(searcher.getSearchString())) {
                    if (!searcher.isSearchHit(combinedCallGraphFunctionTreeNode.getCombinedDiffNode())) {
                        continue;
                    }
                    list3.add(combinedCallGraphFunctionTreeNode);
                }
                else {
                    list3.add(combinedCallGraphFunctionTreeNode);
                }
            }
        }
        final Iterator<Comparator<? super Object>> iterator3 = (Iterator<Comparator<? super Object>>)this.getRootNode().getSorter().getCombinedFunctionTreeNodeComparatorList().iterator();
        while (iterator3.hasNext()) {
            Collections.sort(list3, iterator3.next());
        }
        final Iterator<CombinedCallGraphFunctionTreeNode> iterator4 = list3.iterator();
        while (iterator4.hasNext()) {
            this.add(iterator4.next());
        }
        this.getTree().getModel().nodeStructureChanged(this);
        this.getTree().updateUI();
    }
    
    @Override
    public void createChildren() {
        this.functionNodes.clear();
        final Iterator<CombinedDiffNode> iterator = this.getRootNode().getGraph().getNodes().iterator();
        while (iterator.hasNext()) {
            this.functionNodes.add(new CombinedCallGraphFunctionTreeNode(this.getRootNode(), iterator.next()));
        }
        this.updateTreeNodes(false);
    }
    
    @Override
    public Icon getIcon() {
        return CombinedCallGraphBaseTreeNode.CALLGRAPH_ICON;
    }
    
    public CombinedDiffNode getLastSelectedGraphNode() {
        return this.lastSelectedTreeNode;
    }
    
    @Override
    public JPopupMenu getPopupMenu() {
        final JPopupMenu popupMenu = new JPopupMenu();
        final JMenuItem menuItem = new JMenuItem(new CombinedCallGraphBaseTreeNode$1(this, "Copy Primary Image Name"));
        final JMenuItem menuItem2 = new JMenuItem(new CombinedCallGraphBaseTreeNode$2(this, "Copy Secondary Image Name"));
        final JMenuItem menuItem3 = new JMenuItem(new CombinedCallGraphBaseTreeNode$3(this, "Copy Primary Image Hash"));
        final JMenuItem menuItem4 = new JMenuItem(new CombinedCallGraphBaseTreeNode$4(this, "Copy Secondary Image Hash"));
        final JMenuItem menuItem5 = new JMenuItem(new CombinedCallGraphBaseTreeNode$5(this, "Copy Primary IDB Name"));
        final JMenuItem menuItem6 = new JMenuItem(new CombinedCallGraphBaseTreeNode$6(this, "Copy Secondary IDB Name"));
        popupMenu.add(menuItem);
        popupMenu.add(menuItem3);
        popupMenu.add(menuItem5);
        popupMenu.add(new JSeparator());
        popupMenu.add(menuItem2);
        popupMenu.add(menuItem4);
        popupMenu.add(menuItem6);
        return popupMenu;
    }
    
    @Override
    public CombinedCallGraphRootTreeNode getRootNode() {
        return (CombinedCallGraphRootTreeNode)this.getAbstractRootNode();
    }
    
    public void setLastSelectedGraphNode(final CombinedDiffNode lastSelectedTreeNode) {
        this.lastSelectedTreeNode = lastSelectedTreeNode;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%d / %d)", "Combined Call Graph", this.getChildCount(), this.functionNodes.size());
    }
    
    static {
        CALLGRAPH_ICON = ImageUtils.getImageIcon("data/treeicons/callgraph.png");
    }
}
