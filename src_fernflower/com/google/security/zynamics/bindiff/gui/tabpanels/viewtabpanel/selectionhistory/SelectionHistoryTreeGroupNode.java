package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.AbstractSelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.ISnapshotListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$2;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$3;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$4;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$5;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$6;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$7;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$8;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$9;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$InternalSnapshotListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeNodeWrapper;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class SelectionHistoryTreeGroupNode extends AbstractSelectionHistoryTreeNode {
   private static final Icon ICON_ALL_UNSELECTED_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-all-unselected.png");
   private static final Icon ICON_ALL_SELECTED_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-open.png");
   private static final Icon ICON_ALL_UNVISIBLE_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-all-unselected-gray.png");
   private static final Icon ICON_ALL_UNSELECTED_SOME_VISIBLE_SOME_INVISIBLE_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-all-unselected-halfgray.png");
   private static final Icon ICON_ALL_VISIBLE_SOME_SELECTED_SOME_UNSELECTED_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-some-unselected.png");
   private static final Icon ICON_SOME_SELECTED_SOME_VISIBLE_SOME_INVISIBLE_GRAPHNODES = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-some-unselected-halfgray.png");
   private static final Icon ICON_EMPTY_FOLDER = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-empty.png");
   private static final Icon ICON_DUMMY = ImageUtils.getImageIcon("data/selectionicons/graph-selection-folder-closed.png");
   private final ISnapshotListener snapshotListener = new SelectionHistoryTreeGroupNode$InternalSnapshotListener(this, (SelectionHistoryTreeGroupNode$1)null);
   private final SelectionSnapshot snapshot;
   private final int snapshotCount;

   public SelectionHistoryTreeGroupNode(SelectionSnapshot var1, int var2) {
      super((new SelectionHistoryTreeNodeWrapper(var1, var2)).toString());
      this.snapshot = var1;
      var1.addListener(this.snapshotListener);
      this.snapshotCount = var2;
   }

   public void dispose() {
      this.snapshot.removeListener(this.snapshotListener);
   }

   public Icon getIcon() {
      int var1 = 0;
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      Collection var5 = this.snapshot.getSelection();

      for(Iterator var6 = var5.iterator(); var6.hasNext(); ++var1) {
         ZyGraphNode var7 = (ZyGraphNode)var6.next();
         if(var7.isSelected()) {
            ++var2;
         } else {
            ++var3;
         }

         if(!var7.isVisible()) {
            ++var4;
         }
      }

      if(var1 == 0) {
         return ICON_EMPTY_FOLDER;
      } else if(var4 == var1) {
         return ICON_ALL_UNVISIBLE_GRAPHNODES;
      } else if(var2 == var1) {
         return ICON_ALL_SELECTED_GRAPHNODES;
      } else if(var3 == var1 && var4 == 0) {
         return ICON_ALL_UNSELECTED_GRAPHNODES;
      } else if(var2 == 0) {
         return ICON_ALL_UNSELECTED_SOME_VISIBLE_SOME_INVISIBLE_GRAPHNODES;
      } else if(var4 == 0) {
         return ICON_ALL_VISIBLE_SOME_SELECTED_SOME_UNSELECTED_GRAPHNODES;
      } else if(var4 != 0 && var2 != 0) {
         return ICON_SOME_SELECTED_SOME_VISIBLE_SOME_INVISIBLE_GRAPHNODES;
      } else {
         return ICON_DUMMY;
      }
   }

   public JPopupMenu getPopupMenu() {
      JPopupMenu var1 = new JPopupMenu();
      BinDiffGraph var2 = this.getRootNode().getGraph();
      JMenuItem var3;
      JMenuItem var4;
      if(var2 instanceof SingleGraph) {
         if(var2.getGraphType() == EGraphType.CALLGRAPH) {
            var3 = new JMenuItem(new SelectionHistoryTreeGroupNode$1(this, "Copy Function Addresses"));
            var4 = new JMenuItem(new SelectionHistoryTreeGroupNode$2(this, "Copy Function Names"));
            var1.add(var3);
            var1.add(var4);
         } else if(var2.getGraphType() == EGraphType.FLOWGRAPH) {
            var3 = new JMenuItem(new SelectionHistoryTreeGroupNode$3(this, "Copy Basic Block Addresses"));
            var1.add(var3);
         }
      } else if(this.getRootNode().getGraph() instanceof CombinedGraph) {
         if(var2.getGraphType() == EGraphType.CALLGRAPH) {
            var3 = new JMenuItem(new SelectionHistoryTreeGroupNode$4(this, "Copy Primary Function Addresses"));
            var4 = new JMenuItem(new SelectionHistoryTreeGroupNode$5(this, "Copy Secondary Function Addresses"));
            JMenuItem var5 = new JMenuItem(new SelectionHistoryTreeGroupNode$6(this, "Copy Primary Function Names"));
            JMenuItem var6 = new JMenuItem(new SelectionHistoryTreeGroupNode$7(this, "Copy Secondary Function Names"));
            var1.add(var3);
            var1.add(var5);
            var1.add(var4);
            var1.add(var6);
         } else if(var2.getGraphType() == EGraphType.FLOWGRAPH) {
            var3 = new JMenuItem(new SelectionHistoryTreeGroupNode$8(this, "Copy Primary Basic Block Addresses"));
            var4 = new JMenuItem(new SelectionHistoryTreeGroupNode$9(this, "Copy Secondary Basic Block Addresses"));
            var1.add(var3);
            var1.add(var4);
         }
      }

      return var1;
   }

   public SelectionSnapshot getSnapshot() {
      return this.snapshot;
   }

   // $FF: synthetic method
   static SelectionSnapshot access$100(SelectionHistoryTreeGroupNode var0) {
      return var0.snapshot;
   }

   // $FF: synthetic method
   static int access$200(SelectionHistoryTreeGroupNode var0) {
      return var0.snapshotCount;
   }
}
