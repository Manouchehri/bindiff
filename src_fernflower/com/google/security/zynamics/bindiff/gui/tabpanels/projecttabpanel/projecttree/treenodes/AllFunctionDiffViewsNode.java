package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.FunctionDiffContainerNodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.FunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsContainerNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

public class AllFunctionDiffViewsNode extends AbstractTreeNode {
   private static final ImageIcon ICON = ImageUtils.getImageIcon("data/treeicons/function-diffs-container.png");
   private final FunctionDiffViewsContainerNodeContextPanel component = new FunctionDiffViewsContainerNodeContextPanel(this.getController());

   public AllFunctionDiffViewsNode(WorkspaceTabPanelFunctions var1) {
      super(var1, (Diff)null);
   }

   private Map fillImageDiffViewsListMap() {
      Workspace var1 = this.getController().getWorkspace();
      HashMap var2 = new HashMap();
      Iterator var3 = var1.getDiffList(true).iterator();

      while(var3.hasNext()) {
         Diff var4 = (Diff)var3.next();
         File var5 = var4.getMatchesDatabase().getParentFile();
         Object var6 = (List)var2.get(var5);
         if(var6 == null) {
            var6 = new ArrayList();
         }

         ((List)var6).add(var4);
         var2.put(var5, var6);
      }

      return var2;
   }

   protected void createChildren() {
      Map var1 = this.fillImageDiffViewsListMap();
      HashMap var2 = new HashMap();

      for(int var3 = 0; var3 < this.getChildCount(); ++var3) {
         FunctionDiffViewsNode var4 = (FunctionDiffViewsNode)this.getChildAt(var3);
         var2.put(var4.getViewDirectory(), var4);
      }

      Iterator var7 = var1.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         FunctionDiffViewsNode var5 = (FunctionDiffViewsNode)var2.get(var8.getKey());
         if(var5 != null) {
            FunctionDiffViewsNodeContextPanel var6 = var5.getComponent();
            var6.getFunctionViewsTableModel().setFunctionDiffList((List)var8.getValue());
            var6.updateUI();
         } else {
            this.add(new FunctionDiffViewsNode(this.getController(), (File)var8.getKey(), (List)var8.getValue()));
         }
      }

   }

   protected void delete() {
      this.component.dispose();
   }

   public void addDiff(Diff var1) {
      if(var1.isFunctionDiff() && !WorkspaceTree.hasFunctionDiffRelatives(this.getTree(), var1) && !this.isLeaf()) {
         File var2 = new File(var1.getMatchesDatabase().getParent());
         this.add(new FunctionDiffViewsNode(this.getController(), var2, new ArrayList()));
      }

   }

   public void doubleClicked() {
      if(this.getController().getWorkspace().getDiffList(true).size() > 0) {
         this.getController().loadFunctionDiffs();
         this.createChildren();
      }

   }

   public FunctionDiffViewsContainerNodeContextPanel getComponent() {
      return this.component;
   }

   public Icon getIcon() {
      return ICON;
   }

   public JPopupMenu getPopupMenu() {
      return new FunctionDiffContainerNodePopupMenu(this.getController());
   }

   public String toString() {
      return String.format("Single Function Diff Views (%d)", new Object[]{Integer.valueOf(this.getController().getWorkspace().getDiffList(true).size())});
   }
}
