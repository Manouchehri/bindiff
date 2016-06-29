package com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EMatchType;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.FunctionDiffViewTabPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.MatchesGetter;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FunctionDiffViewTabPanel extends ViewTabPanel {
   private static final ImageIcon FUNCTIONDIFF_IDENTICAL_MATCHED_ICON = ImageUtils.getImageIcon("data/tabicons/functiondiff-flowgraphs-identical-matched-tab.png");
   private static final ImageIcon FUNCTIONDIFF_INSTRUCTION_CHANGED_ONLY_ICON = ImageUtils.getImageIcon("data/tabicons/functiondiff-flowgraphs-changed-instructions-only-tab.png");
   private static final ImageIcon FUNCTIONDIFF_STRUTURAL_CHANGED_ICON = ImageUtils.getImageIcon("data/tabicons/functiondiff-flowgraphs_structural-changed-tab.png");
   private static final ImageIcon SAVED_FUNCTIONDIFF_IDENTICAL_MATCHED_ICON = ImageUtils.getImageIcon("data/tabicons/savedfunctiondiff-flowgraphs-identical-matched-tab.png");
   private static final ImageIcon SAVED_FUNCTIONDIFF_INSTRUCTION_CHANGED_ONLY_ICON = ImageUtils.getImageIcon("data/tabicons/savedfunctiondiffflowgraphs-changed-instructions-only-tab.png");
   private static final ImageIcon SAVED_FUNCTIONDIFF_STRUTURAL_CHANGED_ICON = ImageUtils.getImageIcon("data/tabicons/savedfunctiondiffflowgraphs_structural-changed-tab.png");
   private final FunctionMatchData functionMatch;
   private final Workspace workspace;

   public FunctionDiffViewTabPanel(MainWindow var1, TabPanelManager var2, Workspace var3, Diff var4, FunctionMatchData var5, ViewData var6) {
      super(var1, var2, var3, var4, var6);
      this.functionMatch = (FunctionMatchData)Preconditions.checkNotNull(var5);
      this.workspace = (Workspace)Preconditions.checkNotNull(var3);
   }

   private boolean isSavedView() {
      if(this.workspace.isLoaded()) {
         String var1 = this.getDiff().getMatchesDatabase().getParentFile().getParentFile().getParent();
         String var2 = this.workspace.getWorkspaceDirPath();
         return var1.equals(var2);
      } else {
         return false;
      }
   }

   public Icon getIcon() {
      CombinedGraph var1 = this.getView().getGraphs().getCombinedGraph();
      if(this.getView().isFlowgraphView()) {
         EMatchType var2 = MatchesGetter.getFlowgraphsMatchType(var1, this.functionMatch);
         switch(FunctionDiffViewTabPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchType[var2.ordinal()]) {
         case 1:
            return this.isSavedView()?SAVED_FUNCTIONDIFF_IDENTICAL_MATCHED_ICON:FUNCTIONDIFF_IDENTICAL_MATCHED_ICON;
         case 2:
            return this.isSavedView()?SAVED_FUNCTIONDIFF_INSTRUCTION_CHANGED_ONLY_ICON:FUNCTIONDIFF_INSTRUCTION_CHANGED_ONLY_ICON;
         case 3:
            return this.isSavedView()?SAVED_FUNCTIONDIFF_STRUTURAL_CHANGED_ICON:FUNCTIONDIFF_STRUTURAL_CHANGED_ICON;
         default:
            return null;
         }
      } else {
         return null;
      }
   }
}
