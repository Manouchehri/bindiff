package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.gui.dialogs.AddDiffDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.NewWorkspaceDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.ProgressDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DirectoryDiffDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.InitialCallGraphSettingsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.InitialFlowGraphSettingsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.MainSettingsDialog;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.FunctionDiffViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.implementations.DirectoryDiffImplementation;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.implementations.NewDiffImplementation;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AllFunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.FunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.io.matches.FunctionDiffSocketXmlData;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.IWorkspaceListener;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.WorkspaceLoader;
import com.google.security.zynamics.bindiff.project.diff.CallGraphViewLoader;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffLoader;
import com.google.security.zynamics.bindiff.project.diff.FlowGraphViewLoader;
import com.google.security.zynamics.bindiff.project.diff.FunctionDiffViewLoader;
import com.google.security.zynamics.bindiff.project.diff.IDiffListener;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionDiffMetaData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.userview.CallGraphViewData;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.bindiff.utils.SystemUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.Triple;
import com.google.security.zynamics.zylib.gui.CFileChooser;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

public final class WorkspaceTabPanelFunctions extends TabPanelFunctions {
   private MainSettingsDialog mainSettingsDialog = null;
   private InitialCallGraphSettingsDialog callgraphSettingsDialog = null;
   private InitialFlowGraphSettingsDialog flowgraphSettingsDialog = null;
   private WorkspaceTree workspaceTree;

   public WorkspaceTabPanelFunctions(MainWindow var1, Workspace var2) {
      super(var1, var2);
   }

   private boolean closeViews(List var1, List var2) {
      Iterator var3 = var1.iterator();

      ViewTabPanel var4;
      while(var3.hasNext()) {
         var4 = (ViewTabPanel)var3.next();
         var4.getController().getTabPanelManager().getTabbedPane().setSelectedComponent(var4);
         Diff var5 = var4.getDiff();
         int var6 = CMessageBox.showYesNoCancelQuestion(this.getMainWindow(), String.format("Save %s \'%s\'?", new Object[]{var5.isFunctionDiff()?"Function Diff View":"Diff View", var4.getView().getViewName()}));
         switch(var6) {
         case 0:
            if(!var4.getController().closeView(true)) {
               return false;
            }
            break;
         case 1:
            var2.add(var4);
            break;
         default:
            return false;
         }
      }

      var3 = var2.iterator();

      while(var3.hasNext()) {
         var4 = (ViewTabPanel)var3.next();
         var4.getController().closeView(false);
      }

      return true;
   }

   private File copyFileIntoNewDiffDir(File var1, File var2) {
      String var3 = String.format("%s%s%s", new Object[]{var1, File.separator, var2.getName()});
      File var4 = new File(var3);
      ByteStreams.copy((InputStream)(new FileInputStream(var2)), (OutputStream)(new FileOutputStream(var4)));
      return var4;
   }

   private boolean deleteDiff(Diff var1, boolean var2) {
      this.removeDiffFromWorkspace(var1);
      if(var2) {
         try {
            if(!var1.isFunctionDiff()) {
               CFileUtils.deleteDirectory(new File(var1.getDiffFolder()));
            } else if(!this.deleteFunctionDiff(var1)) {
               CMessageBox.showError(this.getMainWindow(), String.format("Couldn\'t delete \'%s\'.", new Object[]{var1.getMatchesDatabase().toString()}));
            }
         } catch (IOException var4) {
            Logger.logException(var4, "Delete diff failed. Couldn\'t delete diff folder.");
            CMessageBox.showError(this.getMainWindow(), "Delete diff failed. Couldn\'t delete diff folder.");
            return false;
         }
      }

      return true;
   }

   private boolean deleteFunctionDiff(Diff var1) {
      if(var1.getMatchesDatabase().delete()) {
         File var2 = var1.getMatchesDatabase().getParentFile();
         File var3 = var1.getExportFile(ESide.PRIMARY);
         File var4 = var1.getExportFile(ESide.SECONDARY);
         boolean var5 = true;
         boolean var6 = true;
         Iterator var7 = this.getWorkspace().getDiffList(true).iterator();

         while(var7.hasNext()) {
            Diff var8 = (Diff)var7.next();
            if(var2.equals(var8.getMatchesDatabase().getParentFile())) {
               if(var8.getExportFile(ESide.PRIMARY).equals(var3)) {
                  var5 = false;
               }

               if(var8.getExportFile(ESide.SECONDARY).equals(var4)) {
                  var6 = false;
               }
            }
         }

         if(var5 && !var3.delete()) {
            return false;
         } else if(var6 && !var4.delete()) {
            return false;
         } else if(var2.listFiles().length == 0) {
            AllFunctionDiffViewsNode var11 = (AllFunctionDiffViewsNode)this.workspaceTree.getModel().getRoot().getChildAt(0);
            int var12 = -1;

            for(int var9 = 0; var9 < var11.getChildCount(); ++var9) {
               FunctionDiffViewsNode var10 = (FunctionDiffViewsNode)var11.getChildAt(var9);
               if(var10.getViewDirectory().equals(var2)) {
                  var12 = var9;
                  var10.delete();
                  var11.remove(var9);
                  this.workspaceTree.updateTree();
               }
            }

            if(var12 == var11.getChildCount()) {
               --var12;
            }

            if(var12 > -1) {
               FunctionDiffViewsNode var13 = (FunctionDiffViewsNode)var11.getChildAt(var12);
               TreePath var14 = new TreePath(var13.getPath());
               this.workspaceTree.expandPath(var14);
               this.workspaceTree.setSelectionPath(var14);
            }

            return var2.delete();
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   private MainWindow getParentWindow() {
      return (MainWindow)SwingUtilities.getWindowAncestor(this.workspaceTree);
   }

   private WorkspaceTabPanel getWorkspaceTabPanel() {
      return this.getMainWindow().getController().getTabPanelManager().getWorkspaceTabPanel();
   }

   private boolean isImportThunkView(Diff var1, IAddress var2, IAddress var3, boolean var4) {
      RawFunction var5 = var1.getCallgraph(ESide.PRIMARY).getFunction(var2);
      RawFunction var6 = var1.getCallgraph(ESide.SECONDARY).getFunction(var3);
      if((var5 == null || var6 != null || var5.getFunctionType() != EFunctionType.IMPORTED) && (var6 == null || var5 != null || var6.getFunctionType() != EFunctionType.IMPORTED)) {
         if(var5 != null && var5.getFunctionType() == EFunctionType.IMPORTED && var6 != null && var6.getFunctionType() == EFunctionType.IMPORTED) {
            if(var4) {
               CMessageBox.showInformation(this.getMainWindow(), "Cannot open matched import thunk view since it doesn\'t contain any code.");
            }

            return true;
         } else {
            return false;
         }
      } else {
         if(var4) {
            CMessageBox.showInformation(this.getMainWindow(), "Cannot open unmatched import thunk view since it doesn\'t contain any code.");
         }

         return true;
      }
   }

   private void loadWorkspace(File var1, boolean var2) {
      try {
         if(this.getWorkspace().isLoaded()) {
            this.getWorkspace().closeWorkspace();
         }

         Workspace var3 = this.getWorkspace();
         WorkspaceLoader var4 = new WorkspaceLoader(var1, var3);
         if(var2) {
            ProgressDialog.show(this.getMainWindow(), String.format("Loading Workspace \'%s\'", new Object[]{var1.getName()}), (CEndlessHelperThread)var4);
         } else {
            var4.loadMetaData();
         }

         String var5 = var4.getErrorMessage();
         if(!"".equals(var5)) {
            Logger.logSevere(var5, new Object[0]);
            CMessageBox.showError(this.getMainWindow(), var5);
         } else {
            this.getWorkspace().saveWorkspace();
         }
      } catch (Exception var6) {
         Logger.logException(var6, String.format("Load workspace failed. %s", new Object[]{var6.getMessage()}));
         CMessageBox.showError(this.getMainWindow(), String.format("Load workspace failed. %s", new Object[]{var6.getMessage()}));
      }

   }

   private void removeDiffFromWorkspace(Diff var1) {
      // $FF: Couldn't be decompiled
   }

   public void addDiff() {
      // $FF: Couldn't be decompiled
   }

   public void closeDialogs() {
      if(this.mainSettingsDialog != null) {
         this.mainSettingsDialog.dispose();
      }

      if(this.flowgraphSettingsDialog != null) {
         this.flowgraphSettingsDialog.dispose();
      }

      if(this.callgraphSettingsDialog != null) {
         this.callgraphSettingsDialog.dispose();
      }

   }

   public boolean closeDiffs(Set var1) {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      Iterator var4 = this.getOpenViews(var1).iterator();

      while(var4.hasNext()) {
         ViewTabPanel var5 = (ViewTabPanel)var4.next();
         if(var5.getController().hasChanged()) {
            if(var5.getDiff().isFunctionDiff()) {
               var2.add(0, var5);
            } else {
               var2.add(var5);
            }
         } else {
            var3.add(var5);
         }
      }

      if(!this.closeViews(var2, var3)) {
         return false;
      } else {
         var4 = var1.iterator();

         while(var4.hasNext()) {
            Diff var6 = (Diff)var4.next();
            var6.closeDiff();
         }

         return true;
      }
   }

   public void closeViews(Set var1) {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         ViewTabPanel var5 = (ViewTabPanel)var4.next();
         if(var5.getController().hasChanged()) {
            if(var5.getDiff().isFunctionDiff()) {
               var2.add(0, var5);
            } else {
               var2.add(var5);
            }
         } else {
            var3.add(var5);
         }
      }

      this.closeViews(var2, var3);
   }

   public boolean closeWorkspace() {
      HashSet var1 = new HashSet();
      var1.addAll(this.getWorkspace().getDiffList());
      if(!this.closeDiffs(var1)) {
         return false;
      } else {
         this.getWorkspace().closeWorkspace();
         return true;
      }
   }

   public boolean deleteDiff(Diff var1) {
      Diff var2 = var1 == null?this.getSelectedDiff():var1;
      Pair var3 = CMessageBox.showYesNoQuestionWithCheckbox(this.getParentWindow(), String.format("Are you sure you want to remove \'%s\'?\n\n", new Object[]{var2.getDiffName()}), "Also delete diff contents on disk?");
      return ((Integer)var3.first()).intValue() != 0?false:this.deleteDiff(var2, ((Boolean)var3.second()).booleanValue());
   }

   public boolean deleteFunctionDiffs(List var1) {
      if(var1.isEmpty()) {
         return false;
      } else {
         StringBuilder var2 = new StringBuilder();
         var2.append("Are you sure you want to delete this function diff views from disk?\n\n");
         int var3 = 0;
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            Diff var5 = (Diff)var4.next();
            if(var3 != 0) {
               var2.append("\n");
            }

            var2.append(String.format("\'%s\'", new Object[]{var5.getDiffName()}));
            if(var3++ == 4 && var1.size() > 5) {
               var2.append("\n...");
               break;
            }
         }

         int var9 = CMessageBox.showYesNoQuestion(this.getParentWindow(), var2.toString());
         if(var9 == 0) {
            boolean var10 = true;
            Iterator var6 = var1.iterator();

            while(var6.hasNext()) {
               Diff var7 = (Diff)var6.next();
               boolean var8 = this.deleteDiff(var7, true);
               if(var10) {
                  var10 = var8;
               }
            }

            return var10;
         } else {
            return false;
         }
      }
   }

   public void directoryDiff() {
      MainWindow var1 = this.getMainWindow();
      Workspace var2 = this.getWorkspace();
      String var3 = var2.getWorkspaceDir().getPath();
      DirectoryDiffDialog var4 = new DirectoryDiffDialog(var1, new File(var3));
      if(var4.getDiffButtonPressed()) {
         String var5 = var4.getSourceBasePath(ESide.PRIMARY);
         String var6 = var4.getSourceBasePath(ESide.SECONDARY);
         List var7 = var4.getSelectedIdbPairs();
         DirectoryDiffImplementation var8 = new DirectoryDiffImplementation(var1, var2, var5, var6, var7);

         try {
            ProgressDialog.show(var1, "Directory Diffing...", (CEndlessHelperThread)var8);
         } catch (Exception var13) {
            Logger.logException(var13, "Directory diffing was canceled because an unexpected exception!");
            CMessageBox.showError(var1, "Directory diffing was canceled because of an unexpected exception!");
         }

         int var9;
         StringBuilder var10;
         Iterator var11;
         String var12;
         if(var8.getDiffingErrorMessages().size() != 0) {
            var9 = 0;
            var10 = new StringBuilder();
            var11 = var8.getDiffingErrorMessages().iterator();

            while(var11.hasNext()) {
               var12 = (String)var11.next();
               ++var9;
               if(var9 == 10) {
                  var10.append("...");
                  break;
               }

               var10.append(String.valueOf(var12).concat("\n"));
            }

            CMessageBox.showError(var1, var10.toString());
         }

         if(var8.getOpeningDiffErrorMessages().size() != 0) {
            var9 = 0;
            var10 = new StringBuilder();
            var11 = var8.getOpeningDiffErrorMessages().iterator();

            while(var11.hasNext()) {
               var12 = (String)var11.next();
               ++var9;
               if(var9 == 10) {
                  var10.append("...");
                  break;
               }

               var10.append(String.valueOf(var12).concat("\n"));
            }

            CMessageBox.showError(var1, var10.toString());
         }
      }

   }

   public LinkedHashSet getOpenViews(Set var1) {
      LinkedHashSet var2 = new LinkedHashSet();
      MainWindow var3 = this.getMainWindow();
      ArrayList var4 = new ArrayList(var3.getController().getTabPanelManager().getViewTabPanels());
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         ViewTabPanel var6 = (ViewTabPanel)var5.next();
         Diff var7 = var6.getDiff();
         if(var1.contains(var7)) {
            var2.add(var6);
         }
      }

      return var2;
   }

   public Diff getSelectedDiff() {
      TreePath var1 = this.getWorkspaceTree().getSelectionModel().getSelectionPath();
      AbstractTreeNode var2 = (AbstractTreeNode)var1.getLastPathComponent();
      return var2.getDiff();
   }

   public WorkspaceTree getWorkspaceTree() {
      return this.workspaceTree;
   }

   public void loadDefaultWorkspace() {
      String var1 = BinDiffConfigFile.getInstance().getMainSettings().getDefaultWorkspace();
      if(var1 != null && !"".equals(var1)) {
         File var2 = new File(var1);
         if(var2.exists() && var2.canWrite()) {
            this.loadWorkspace(var2, false);
         }

      }
   }

   public void loadDiff(Diff var1) {
      if(var1 == null) {
         var1 = this.getSelectedDiff();
      }

      if(!var1.isLoaded()) {
         LinkedHashSet var2 = new LinkedHashSet();
         var2.add(var1);
         DiffLoader var3 = new DiffLoader(var2);
         CUnlimitedProgressDialog var4 = new CUnlimitedProgressDialog(this.getParentWindow(), "BinDiff", String.format("Loading \'%s\'", new Object[]{var1.getDiffName()}), var3);
         var3.setProgressDescriptionTarget(var4);
         var4.setVisible(true);
         Exception var5 = var4.getException();
         if(var5 != null) {
            Logger.logException(var5, var5.getMessage());
            CMessageBox.showError(this.getMainWindow(), var5.getMessage());
         }

      }
   }

   public void loadFunctionDiffs() {
      LinkedHashSet var1 = new LinkedHashSet();
      Iterator var2 = this.getWorkspace().getDiffList(true).iterator();

      while(var2.hasNext()) {
         Diff var3 = (Diff)var2.next();
         if(!var3.isLoaded()) {
            var1.add(var3);
         }
      }

      this.loadFunctionDiffs(var1);
   }

   public void loadFunctionDiffs(LinkedHashSet var1) {
      DiffLoader var2 = new DiffLoader(var1);
      CUnlimitedProgressDialog var3 = new CUnlimitedProgressDialog(this.getParentWindow(), "BinDiff", "Loading Function Diffs", var2);
      var2.setProgressDescriptionTarget(var3);
      var3.setVisible(true);
      Exception var4 = var3.getException();
      if(var4 != null) {
         Logger.logException(var4, var4.getMessage());
         CMessageBox.showError(this.getMainWindow(), var4.getMessage());
      }

   }

   public void loadWorkspace() {
      String var1 = BinDiffConfigFile.getInstance().getMainSettings().getWorkspaceDirectory();
      if("".equals(var1)) {
         BinDiffConfigFile.getInstance().getMainSettings().setWorkspaceDirectory(SystemUtils.getCurrentUserPersonalFolder());
      }

      File var2 = new File(BinDiffConfigFile.getInstance().getMainSettings().getWorkspaceDirectory());
      CFileChooser var3 = new CFileChooser("BinDiffWorkspace", "BinDiff Workspace");
      var3.setDialogTitle("Open Workspace");
      var3.setApproveButtonText("Open");
      var3.setCheckBox("Use as default workspace");
      if(var2.exists()) {
         var3.setCurrentDirectory(var2);
      }

      if(0 == var3.showOpenDialog(this.getMainWindow())) {
         File var4 = var3.getSelectedFile();
         this.loadWorkspace(var4, true);
         if(var3.isSelectedCheckBox()) {
            BinDiffConfigFile.getInstance().getMainSettings().setDefaultWorkspace(var4.getAbsolutePath());
         }
      }

   }

   public void loadWorkspace(String var1) {
      File var2 = new File(var1);
      if(!var2.exists()) {
         Logger.logSevere("Load workspace failed. Workspace folder does not exist.", new Object[0]);
         CMessageBox.showError(this.getMainWindow(), "Load workspace failed. Workspace folder does not exist.");
      } else {
         this.loadWorkspace(var2, true);
      }
   }

   public void newDiff() {
      MainWindow var1 = this.getMainWindow();
      Workspace var2 = this.getWorkspace();
      String var3 = var2.getWorkspaceDir().getPath();
      NewDiffDialog var4 = new NewDiffDialog(var1, new File(var3));
      if(var4.getDiffButtonPressed()) {
         File var5 = var4.getIdb(ESide.PRIMARY);
         File var6 = var4.getIdb(ESide.SECONDARY);
         File var7 = var4.getBinExportBinary(ESide.PRIMARY);
         File var8 = var4.getBinExportBinary(ESide.SECONDARY);
         File var9 = var4.getDestinationDirectory();
         NewDiffImplementation var10 = new NewDiffImplementation(var1, var2, var5, var6, var7, var8, var9);

         try {
            ProgressDialog.show(this.getMainWindow(), String.format("New single Diff \'%s\'", new Object[]{var9.getName()}), (CEndlessHelperThread)var10);
         } catch (Exception var12) {
            Logger.logException(var12, var12.getMessage());
            CMessageBox.showError(this.getMainWindow(), "Unkown error while diffing.");
         }
      }

   }

   public void newWorkspace() {
      NewWorkspaceDialog var1 = new NewWorkspaceDialog(this.getParentWindow(), "New Workspace");
      var1.setVisible(true);
      if(var1.isOkPressed()) {
         if(!this.getWorkspace().isLoaded() || this.closeWorkspace()) {
            String var2 = FileUtils.ensureTrailingSlash(var1.getWorkspacePath());
            File var3 = new File(var2);
            if(!var3.exists()) {
               var3.mkdir();
            }

            File var4 = new File(String.format("%s%s.%s", new Object[]{var2, var1.getWorkspaceName(), "BinDiffWorkspace"}));

            try {
               this.getWorkspace().newWorkspace(var4);
               if(var1.isDefaultWorkspace()) {
                  BinDiffConfigFile.getInstance().getMainSettings().setDefaultWorkspace(var4.getAbsolutePath());
               }
            } catch (SQLException | IOException var6) {
               Logger.logException(var6);
               CMessageBox.showError(this.getMainWindow(), var6.getMessage());
            }

         }
      }
   }

   public void openCallgraphView(MainWindow var1, Diff var2) {
      try {
         TabPanelManager var3 = var1.getController().getTabPanelManager();
         if(var2.getViewManager().containsView((IAddress)null, (IAddress)null)) {
            var3.selectTabPanel((IAddress)null, (IAddress)null, var2);
         } else {
            CallGraphViewLoader var4 = new CallGraphViewLoader(var2, this.getMainWindow(), var3, this.getWorkspace());
            ProgressDialog.show(this.getMainWindow(), String.format("Loading call graph \'%s\'", new Object[]{var2.getDiffName()}), (CEndlessHelperThread)var4);
            var4 = null;
            Iterator var5 = var2.getListener().iterator();

            while(var5.hasNext()) {
               IDiffListener var6 = (IDiffListener)var5.next();
               var6.loadedView(var2);
            }
         }
      } catch (Exception var7) {
         Logger.logException(var7, "Open call graph view failed. Couldn\'t create graph.");
         CMessageBox.showError(this.getMainWindow(), "Open call graph view failed. Couldn\'t create graph.");
      }

   }

   public void openFlowgraphView(MainWindow var1, Diff var2, IAddress var3, IAddress var4) {
      if(!this.isImportThunkView(var2, var3, var4, true)) {
         TabPanelManager var5 = var1.getController().getTabPanelManager();
         if(var2.getViewManager().containsView(var3, var4)) {
            var5.selectTabPanel(var3, var4, var2);
         } else {
            try {
               LinkedHashSet var6 = new LinkedHashSet();
               var6.add(Triple.make(var2, var3, var4));
               FlowGraphViewLoader var7 = new FlowGraphViewLoader(this.getMainWindow(), var5, this.getWorkspace(), var6);
               ProgressDialog.show(this.getMainWindow(), String.format("Loading flow graph \'%s\'", new Object[]{var2.getDiffName()}), (CEndlessHelperThread)var7);
               Iterator var8 = var2.getListener().iterator();

               while(var8.hasNext()) {
                  IDiffListener var9 = (IDiffListener)var8.next();
                  var9.loadedView(var2);
               }
            } catch (Exception var10) {
               Logger.logException(var10, "Open flow graph view failed. Couldn\'t create flowgraph.");
               CMessageBox.showError(this.getMainWindow(), "Open flow graph view failed. Couldn\'t create flowgraph.");
            }

         }
      }
   }

   public void openFlowgraphViews(MainWindow var1, LinkedHashSet var2) {
      TabPanelManager var3 = var1.getController().getTabPanelManager();
      LinkedHashSet var4 = new LinkedHashSet();
      int var5 = 0;
      Iterator var6 = var2.iterator();

      while(var6.hasNext()) {
         Triple var7 = (Triple)var6.next();
         Diff var8 = (Diff)var7.first();
         IAddress var9 = (IAddress)var7.second();
         IAddress var10 = (IAddress)var7.third();
         if(!var8.getViewManager().containsView(var9, var10)) {
            if(this.isImportThunkView(var8, var9, var10, false)) {
               ++var5;
            } else {
               var4.add(var7);
            }
         }
      }

      if(var5 > 0) {
         CMessageBox.showInformation(this.getParentWindow(), String.format("%d import thunk views have not been opened since they do not contain any code.", new Object[]{Integer.valueOf(var5)}));
         if(var4.size() == 0) {
            return;
         }
      }

      try {
         FlowGraphViewLoader var14 = new FlowGraphViewLoader(this.getMainWindow(), var3, this.getWorkspace(), var4);
         ProgressDialog.show(this.getMainWindow(), "Loading flow graph views.", (CEndlessHelperThread)var14);
         HashSet var15 = new HashSet();
         Iterator var16 = var2.iterator();

         while(true) {
            Diff var18;
            do {
               if(!var16.hasNext()) {
                  return;
               }

               Triple var17 = (Triple)var16.next();
               var18 = (Diff)var17.first();
            } while(var15.contains(var18));

            var15.add(var18);
            Iterator var11 = var18.getListener().iterator();

            while(var11.hasNext()) {
               IDiffListener var12 = (IDiffListener)var11.next();
               var12.loadedView(var18);
            }
         }
      } catch (Exception var13) {
         Logger.logException(var13, "Open flow graph view failed. Couldn\'t create flow graph.");
         CMessageBox.showError(this.getMainWindow(), "Open flow graph view failed. Couldn\'t create flow graph.");
      }
   }

   public void openFunctionDiffView(FunctionDiffSocketXmlData var1) {
      try {
         MainWindow var2 = this.getMainWindow();
         TabPanelManager var3 = var2.getController().getTabPanelManager();
         FunctionDiffViewLoader var4 = new FunctionDiffViewLoader(var1, var2, var3, this.getWorkspace());
         ProgressDialog.show(this.getMainWindow(), "Loading function diff from IDA", (CEndlessHelperThread)var4);
         if(var1.getDiff() != null) {
            Iterator var5 = var1.getDiff().getListener().iterator();

            while(var5.hasNext()) {
               IDiffListener var6 = (IDiffListener)var5.next();
               var6.loadedView(var1.getDiff());
            }
         }
      } catch (Exception var7) {
         Logger.logException(var7, "Open function diff view failed. Couldn\'t create graph.");
         CMessageBox.showError(this.getMainWindow(), "Open function diff view failed. Couldn\'t create graph.");
      }

   }

   public void openFunctionDiffView(MainWindow var1, Diff var2) {
      Preconditions.checkArgument(var2.isFunctionDiff());
      IAddress var3 = ((RawFunction)var2.getCallgraph(ESide.PRIMARY).getNodes().get(0)).getAddress();
      IAddress var4 = ((RawFunction)var2.getCallgraph(ESide.SECONDARY).getNodes().get(0)).getAddress();
      if(!this.isImportThunkView(var2, var3, var4, true)) {
         TabPanelManager var5 = var1.getController().getTabPanelManager();
         Iterator var6 = var5.iterator();

         while(var6.hasNext()) {
            TabPanel var7 = (TabPanel)var6.next();
            if(var7 instanceof FunctionDiffViewTabPanel) {
               FunctionDiffViewTabPanel var8 = (FunctionDiffViewTabPanel)var7;
               Diff var9 = var8.getView().getGraphs().getDiff();
               if(var9 == var2) {
                  var5.getTabbedPane().setSelectedComponent(var7);
                  return;
               }
            }
         }

         FunctionDiffMetaData var10 = (FunctionDiffMetaData)var2.getMetaData();
         FunctionDiffSocketXmlData var11 = new FunctionDiffSocketXmlData(var2);
         var11.setFlowgraphOffset(var10.getFlowgraphOffset(ESide.PRIMARY), ESide.PRIMARY);
         var11.setFlowgraphOffset(var10.getFlowgraphOffset(ESide.SECONDARY), ESide.SECONDARY);
         var11.setFlowgraphsPath(var2.getExportFile(ESide.PRIMARY).getPath(), ESide.PRIMARY);
         var11.setFlowgraphsPath(var2.getExportFile(ESide.SECONDARY).getPath(), ESide.SECONDARY);
         var11.setMatchesDBPath(var2.getMatchesDatabase().getPath());
         this.openFunctionDiffView(var11);
      }
   }

   public boolean saveDescription(Diff var1, String var2) {
      // $FF: Couldn't be decompiled
   }

   public void setTreeNodeContextComponent(Component var1) {
      if(var1 != null) {
         JPanel var2 = this.getWorkspaceTabPanel().getTreeNodeContextContainer();
         var2.removeAll();
         var2.add(var1, "Center");
         var2.updateUI();
      }
   }

   public void setWorkspaceTree(WorkspaceTree var1) {
      this.workspaceTree = var1;
   }

   public void showInCallgraph(Diff var1, Set var2) {
      if(!var1.getViewManager().containsView((IAddress)null, (IAddress)null)) {
         this.openCallgraphView(this.getMainWindow(), var1);
      } else {
         TabPanelManager var3 = this.getMainWindow().getController().getTabPanelManager();
         var3.selectTabPanel((IAddress)null, (IAddress)null, var1);
      }

      ArrayList var12 = new ArrayList();
      ArrayList var4 = new ArrayList();
      CallGraphViewData var5 = var1.getViewManager().getCallgraphViewData(var1);
      if(var5 != null) {
         CombinedGraph var6 = var5.getGraphs().getCombinedGraph();
         Iterator var7 = var6.getNodes().iterator();

         while(var7.hasNext()) {
            CombinedDiffNode var8 = (CombinedDiffNode)var7.next();
            RawCombinedFunction var9 = (RawCombinedFunction)var8.getRawNode();
            IAddress var10 = var9.getAddress(ESide.PRIMARY);
            IAddress var11 = var9.getAddress(ESide.SECONDARY);
            if(var2.contains(Pair.make(var10, var11))) {
               var12.add(var8);
            } else {
               var4.add(var8);
            }
         }

         var6.selectNodes(var12, var4);
      }

   }

   public void showInitialCallgraphSettingsDialog() {
      if(this.callgraphSettingsDialog == null) {
         this.callgraphSettingsDialog = new InitialCallGraphSettingsDialog(this.getMainWindow());
      }

      this.callgraphSettingsDialog.setVisible(true);
   }

   public void showInitialFlowgraphSettingsDialog() {
      if(this.flowgraphSettingsDialog == null) {
         this.flowgraphSettingsDialog = new InitialFlowGraphSettingsDialog(this.getMainWindow());
      }

      this.flowgraphSettingsDialog.setVisible(true);
   }

   public void showMainSettingsDialog() {
      if(this.mainSettingsDialog == null) {
         this.mainSettingsDialog = new MainSettingsDialog(this.getMainWindow());
      }

      this.mainSettingsDialog.setVisible(true);
   }
}
