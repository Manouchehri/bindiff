/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
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
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTreeModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AllFunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.FunctionDiffViewsNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.RootNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.window.CWindowFunctions;
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
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.userview.CallGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewManager;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.bindiff.utils.SystemUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.Triple;
import com.google.security.zynamics.zylib.gui.CFileChooser;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IProgressDescription;
import com.google.security.zynamics.zylib.io.FileUtils;
import com.google.security.zynamics.zylib.types.common.ICommand;
import java.awt.Component;
import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public final class WorkspaceTabPanelFunctions
extends TabPanelFunctions {
    private MainSettingsDialog mainSettingsDialog = null;
    private InitialCallGraphSettingsDialog callgraphSettingsDialog = null;
    private InitialFlowGraphSettingsDialog flowgraphSettingsDialog = null;
    private WorkspaceTree workspaceTree;

    public WorkspaceTabPanelFunctions(MainWindow mainWindow, Workspace workspace) {
        super(mainWindow, workspace);
    }

    /*
     * Unable to fully structure code
     */
    private boolean closeViews(List var1_1, List var2_2) {
        for (ViewTabPanel var4_4 : var1_1) {
            var4_4.getController().getTabPanelManager().getTabbedPane().setSelectedComponent(var4_4);
            var5_5 = var4_4.getDiff();
            v0 = new Object[2];
            v0[0] = var5_5.isFunctionDiff() != false ? "Function Diff View" : "Diff View";
            v0[1] = var4_4.getView().getViewName();
            var6_6 = CMessageBox.showYesNoCancelQuestion(this.getMainWindow(), String.format("Save %s '%s'?", v0));
            switch (var6_6) {
                case 0: {
                    if (var4_4.getController().closeView(true) == false) return false;
                    ** break;
                }
                case 1: {
                    var2_2.add(var4_4);
                    ** break;
                }
            }
            return false;
lbl16: // 2 sources:
        }
        var3_3 = var2_2.iterator();
        while (var3_3.hasNext() != false) {
            var4_4 = (ViewTabPanel)var3_3.next();
            var4_4.getController().closeView(false);
        }
        return true;
    }

    private File copyFileIntoNewDiffDir(File file, File file2) {
        String string = String.format("%s%s%s", file, File.separator, file2.getName());
        File file3 = new File(string);
        ByteStreams.copy(new FileInputStream(file2), new FileOutputStream(file3));
        return file3;
    }

    private boolean deleteDiff(Diff diff, boolean bl2) {
        this.removeDiffFromWorkspace(diff);
        if (!bl2) return true;
        try {
            if (!diff.isFunctionDiff()) {
                CFileUtils.deleteDirectory(new File(diff.getDiffFolder()));
                return true;
            }
            if (this.deleteFunctionDiff(diff)) return true;
            CMessageBox.showError(this.getMainWindow(), String.format("Couldn't delete '%s'.", diff.getMatchesDatabase().toString()));
            return true;
        }
        catch (IOException var3_3) {
            Logger.logException(var3_3, "Delete diff failed. Couldn't delete diff folder.");
            CMessageBox.showError(this.getMainWindow(), "Delete diff failed. Couldn't delete diff folder.");
            return false;
        }
    }

    private boolean deleteFunctionDiff(Diff diff) {
        if (!diff.getMatchesDatabase().delete()) return false;
        File file = diff.getMatchesDatabase().getParentFile();
        File file2 = diff.getExportFile(ESide.PRIMARY);
        File file3 = diff.getExportFile(ESide.SECONDARY);
        boolean bl2 = true;
        boolean bl3 = true;
        for (Diff diff2 : this.getWorkspace().getDiffList(true)) {
            if (!file.equals(diff2.getMatchesDatabase().getParentFile())) continue;
            if (diff2.getExportFile(ESide.PRIMARY).equals(file2)) {
                bl2 = false;
            }
            if (!diff2.getExportFile(ESide.SECONDARY).equals(file3)) continue;
            bl3 = false;
        }
        if (bl2 && !file2.delete()) {
            return false;
        }
        if (bl3 && !file3.delete()) {
            return false;
        }
        if (file.listFiles().length != 0) return true;
        AllFunctionDiffViewsNode allFunctionDiffViewsNode = (AllFunctionDiffViewsNode)this.workspaceTree.getModel().getRoot().getChildAt(0);
        int n2 = -1;
        for (int i2 = 0; i2 < allFunctionDiffViewsNode.getChildCount(); ++i2) {
            FunctionDiffViewsNode functionDiffViewsNode = (FunctionDiffViewsNode)allFunctionDiffViewsNode.getChildAt(i2);
            if (!functionDiffViewsNode.getViewDirectory().equals(file)) continue;
            n2 = i2;
            functionDiffViewsNode.delete();
            allFunctionDiffViewsNode.remove(i2);
            this.workspaceTree.updateTree();
        }
        if (n2 == allFunctionDiffViewsNode.getChildCount()) {
            --n2;
        }
        if (n2 <= -1) return file.delete();
        FunctionDiffViewsNode functionDiffViewsNode2 = (FunctionDiffViewsNode)allFunctionDiffViewsNode.getChildAt(n2);
        TreePath treePath = new TreePath(functionDiffViewsNode2.getPath());
        this.workspaceTree.expandPath(treePath);
        this.workspaceTree.setSelectionPath(treePath);
        return file.delete();
    }

    private MainWindow getParentWindow() {
        return (MainWindow)SwingUtilities.getWindowAncestor(this.workspaceTree);
    }

    private WorkspaceTabPanel getWorkspaceTabPanel() {
        return this.getMainWindow().getController().getTabPanelManager().getWorkspaceTabPanel();
    }

    private boolean isImportThunkView(Diff diff, IAddress iAddress, IAddress iAddress2, boolean bl2) {
        RawFunction rawFunction = diff.getCallgraph(ESide.PRIMARY).getFunction(iAddress);
        RawFunction rawFunction2 = diff.getCallgraph(ESide.SECONDARY).getFunction(iAddress2);
        if (rawFunction != null && rawFunction2 == null && rawFunction.getFunctionType() == EFunctionType.IMPORTED || rawFunction2 != null && rawFunction == null && rawFunction2.getFunctionType() == EFunctionType.IMPORTED) {
            if (!bl2) return true;
            CMessageBox.showInformation(this.getMainWindow(), "Cannot open unmatched import thunk view since it doesn't contain any code.");
            return true;
        }
        if (rawFunction == null) return false;
        if (rawFunction.getFunctionType() != EFunctionType.IMPORTED) return false;
        if (rawFunction2 == null) return false;
        if (rawFunction2.getFunctionType() != EFunctionType.IMPORTED) return false;
        if (!bl2) return true;
        CMessageBox.showInformation(this.getMainWindow(), "Cannot open matched import thunk view since it doesn't contain any code.");
        return true;
    }

    private void loadWorkspace(File file, boolean bl2) {
        try {
            if (this.getWorkspace().isLoaded()) {
                this.getWorkspace().closeWorkspace();
            }
            Workspace workspace = this.getWorkspace();
            WorkspaceLoader workspaceLoader = new WorkspaceLoader(file, workspace);
            if (bl2) {
                ProgressDialog.show((Window)this.getMainWindow(), String.format("Loading Workspace '%s'", file.getName()), workspaceLoader);
            } else {
                workspaceLoader.loadMetaData();
            }
            String string = workspaceLoader.getErrorMessage();
            if (!"".equals(string)) {
                Logger.logSevere(string, new Object[0]);
                CMessageBox.showError(this.getMainWindow(), string);
                return;
            }
            this.getWorkspace().saveWorkspace();
            return;
        }
        catch (Exception var3_4) {
            Logger.logException(var3_4, String.format("Load workspace failed. %s", var3_4.getMessage()));
            CMessageBox.showError(this.getMainWindow(), String.format("Load workspace failed. %s", var3_4.getMessage()));
        }
    }

    private void removeDiffFromWorkspace(Diff diff) {
        assert (diff != null);
        HashSet<Diff> hashSet = new HashSet<Diff>();
        hashSet.add(diff);
        this.getWorkspace().getDiffList().remove(diff);
        this.closeDiffs(hashSet);
        diff.removeDiff();
        for (IWorkspaceListener iWorkspaceListener : this.getWorkspace().getListeners()) {
            iWorkspaceListener.removedDiff(diff);
        }
        try {
            this.getWorkspace().saveWorkspace();
            return;
        }
        catch (SQLException var3_4) {
            Logger.logException(var3_4, "Couldn't delete temporary files.");
            String string = String.valueOf(var3_4.getMessage());
            CMessageBox.showError(this.getMainWindow(), string.length() != 0 ? "Couldn't delete temporary files: ".concat(string) : new String("Couldn't delete temporary files: "));
        }
    }

    public void addDiff() {
        try {
            AddDiffDialog addDiffDialog = new AddDiffDialog(this.getParentWindow(), this.getWorkspace());
            if (!addDiffDialog.getAddButtonPressed()) return;
            File file = addDiffDialog.getMatchesBinary();
            File file2 = addDiffDialog.getBinExportBinary(ESide.PRIMARY);
            File file3 = addDiffDialog.getBinExportBinary(ESide.SECONDARY);
            File file4 = addDiffDialog.getDestinationDirectory();
            File file5 = file;
            if (!file4.equals(file.getParentFile())) {
                file4.mkdir();
                file5 = this.copyFileIntoNewDiffDir(file4, file);
                this.copyFileIntoNewDiffDir(file4, file2);
                this.copyFileIntoNewDiffDir(file4, file3);
            }
            DiffMetaData diffMetaData = DiffLoader.preloadDiffMatches(file5);
            this.getWorkspace().addDiff(file5, diffMetaData, false);
            return;
        }
        catch (IOException | SQLException var1_2) {
            Logger.logException(var1_2, "Add diff failed. Couldn't add diff to workspace.");
            String string = String.valueOf(var1_2.getMessage());
            CMessageBox.showError(this.getMainWindow(), string.length() != 0 ? "Add diff failed. Couldn't add diff to workspace: ".concat(string) : new String("Add diff failed. Couldn't add diff to workspace: "));
        }
    }

    public void closeDialogs() {
        if (this.mainSettingsDialog != null) {
            this.mainSettingsDialog.dispose();
        }
        if (this.flowgraphSettingsDialog != null) {
            this.flowgraphSettingsDialog.dispose();
        }
        if (this.callgraphSettingsDialog == null) return;
        this.callgraphSettingsDialog.dispose();
    }

    public boolean closeDiffs(Set set) {
        ArrayList<ViewTabPanel> arrayList = new ArrayList<ViewTabPanel>();
        ArrayList<ViewTabPanel> arrayList2 = new ArrayList<ViewTabPanel>();
        for (Object object2 : this.getOpenViews(set)) {
            if (object2.getController().hasChanged()) {
                if (object2.getDiff().isFunctionDiff()) {
                    arrayList.add(0, (ViewTabPanel)object2);
                    continue;
                }
                arrayList.add((ViewTabPanel)object2);
                continue;
            }
            arrayList2.add((ViewTabPanel)object2);
        }
        if (!this.closeViews(arrayList, arrayList2)) return false;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object object2;
            object2 = (Diff)iterator.next();
            object2.closeDiff();
        }
        return true;
    }

    public void closeViews(Set set) {
        ArrayList<ViewTabPanel> arrayList = new ArrayList<ViewTabPanel>();
        ArrayList<ViewTabPanel> arrayList2 = new ArrayList<ViewTabPanel>();
        Iterator iterator = set.iterator();
        do {
            if (!iterator.hasNext()) {
                this.closeViews(arrayList, arrayList2);
                return;
            }
            ViewTabPanel viewTabPanel = (ViewTabPanel)iterator.next();
            if (viewTabPanel.getController().hasChanged()) {
                if (viewTabPanel.getDiff().isFunctionDiff()) {
                    arrayList.add(0, viewTabPanel);
                    continue;
                }
                arrayList.add(viewTabPanel);
                continue;
            }
            arrayList2.add(viewTabPanel);
        } while (true);
    }

    public boolean closeWorkspace() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.getWorkspace().getDiffList());
        if (!this.closeDiffs(hashSet)) {
            return false;
        }
        this.getWorkspace().closeWorkspace();
        return true;
    }

    public boolean deleteDiff(Diff diff) {
        Diff diff2 = diff == null ? this.getSelectedDiff() : diff;
        Pair pair = CMessageBox.showYesNoQuestionWithCheckbox(this.getParentWindow(), String.format("Are you sure you want to remove '%s'?\n\n", diff2.getDiffName()), "Also delete diff contents on disk?");
        if ((Integer)pair.first() == 0) return this.deleteDiff(diff2, (Boolean)pair.second());
        return false;
    }

    public boolean deleteFunctionDiffs(List list) {
        int n2;
        if (list.isEmpty()) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Are you sure you want to delete this function diff views from disk?\n\n");
        int n3 = 0;
        for (Diff diff : list) {
            if (n3 != 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(String.format("'%s'", diff.getDiffName()));
            if (n3++ != 4 || list.size() <= 5) continue;
            stringBuilder.append("\n...");
            break;
        }
        if ((n2 = CMessageBox.showYesNoQuestion(this.getParentWindow(), stringBuilder.toString())) != 0) return false;
        boolean bl2 = true;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Diff diff2 = (Diff)iterator.next();
            boolean bl3 = this.deleteDiff(diff2, true);
            if (!bl2) continue;
            bl2 = bl3;
        }
        return bl2;
    }

    public void directoryDiff() {
        String string;
        StringBuilder stringBuilder;
        Workspace workspace;
        MainWindow mainWindow = this.getMainWindow();
        DirectoryDiffDialog directoryDiffDialog = new DirectoryDiffDialog(mainWindow, new File(string = (workspace = this.getWorkspace()).getWorkspaceDir().getPath()));
        if (!directoryDiffDialog.getDiffButtonPressed()) return;
        String string2 = directoryDiffDialog.getSourceBasePath(ESide.PRIMARY);
        String string3 = directoryDiffDialog.getSourceBasePath(ESide.SECONDARY);
        List list = directoryDiffDialog.getSelectedIdbPairs();
        DirectoryDiffImplementation directoryDiffImplementation = new DirectoryDiffImplementation(mainWindow, workspace, string2, string3, list);
        try {
            ProgressDialog.show((Window)mainWindow, "Directory Diffing...", directoryDiffImplementation);
        }
        catch (Exception var9_9) {
            Logger.logException(var9_9, "Directory diffing was canceled because an unexpected exception!");
            CMessageBox.showError(mainWindow, "Directory diffing was canceled because of an unexpected exception!");
        }
        if (directoryDiffImplementation.getDiffingErrorMessages().size() != 0) {
            int n2 = 0;
            stringBuilder = new StringBuilder();
            for (String string4 : directoryDiffImplementation.getDiffingErrorMessages()) {
                if (++n2 == 10) {
                    stringBuilder.append("...");
                    break;
                }
                stringBuilder.append(String.valueOf(string4).concat("\n"));
            }
            CMessageBox.showError(mainWindow, stringBuilder.toString());
        }
        if (directoryDiffImplementation.getOpeningDiffErrorMessages().size() == 0) return;
        int n3 = 0;
        stringBuilder = new StringBuilder();
        for (String string4 : directoryDiffImplementation.getOpeningDiffErrorMessages()) {
            if (++n3 == 10) {
                stringBuilder.append("...");
                break;
            }
            stringBuilder.append(String.valueOf(string4).concat("\n"));
        }
        CMessageBox.showError(mainWindow, stringBuilder.toString());
    }

    public LinkedHashSet getOpenViews(Set set) {
        LinkedHashSet<ViewTabPanel> linkedHashSet = new LinkedHashSet<ViewTabPanel>();
        MainWindow mainWindow = this.getMainWindow();
        ArrayList arrayList = new ArrayList(mainWindow.getController().getTabPanelManager().getViewTabPanels());
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ViewTabPanel viewTabPanel = (ViewTabPanel)iterator.next();
            Diff diff = viewTabPanel.getDiff();
            if (!set.contains(diff)) continue;
            linkedHashSet.add(viewTabPanel);
        }
        return linkedHashSet;
    }

    public Diff getSelectedDiff() {
        TreePath treePath = this.getWorkspaceTree().getSelectionModel().getSelectionPath();
        AbstractTreeNode abstractTreeNode = (AbstractTreeNode)treePath.getLastPathComponent();
        return abstractTreeNode.getDiff();
    }

    public WorkspaceTree getWorkspaceTree() {
        return this.workspaceTree;
    }

    public void loadDefaultWorkspace() {
        String string = BinDiffConfigFile.getInstance().getMainSettings().getDefaultWorkspace();
        if (string == null) return;
        if ("".equals(string)) {
            return;
        }
        File file = new File(string);
        if (!file.exists()) return;
        if (!file.canWrite()) return;
        this.loadWorkspace(file, false);
    }

    public void loadDiff(Diff diff) {
        if (diff == null) {
            diff = this.getSelectedDiff();
        }
        if (diff.isLoaded()) {
            return;
        }
        LinkedHashSet<Diff> linkedHashSet = new LinkedHashSet<Diff>();
        linkedHashSet.add(diff);
        DiffLoader diffLoader = new DiffLoader(linkedHashSet);
        CUnlimitedProgressDialog cUnlimitedProgressDialog = new CUnlimitedProgressDialog((Window)this.getParentWindow(), "BinDiff", String.format("Loading '%s'", diff.getDiffName()), diffLoader);
        diffLoader.setProgressDescriptionTarget(cUnlimitedProgressDialog);
        cUnlimitedProgressDialog.setVisible(true);
        Exception exception = cUnlimitedProgressDialog.getException();
        if (exception == null) return;
        Logger.logException(exception, exception.getMessage());
        CMessageBox.showError(this.getMainWindow(), exception.getMessage());
    }

    public void loadFunctionDiffs() {
        LinkedHashSet<Diff> linkedHashSet = new LinkedHashSet<Diff>();
        Iterator iterator = this.getWorkspace().getDiffList(true).iterator();
        do {
            if (!iterator.hasNext()) {
                this.loadFunctionDiffs(linkedHashSet);
                return;
            }
            Diff diff = (Diff)iterator.next();
            if (diff.isLoaded()) continue;
            linkedHashSet.add(diff);
        } while (true);
    }

    public void loadFunctionDiffs(LinkedHashSet linkedHashSet) {
        DiffLoader diffLoader = new DiffLoader(linkedHashSet);
        CUnlimitedProgressDialog cUnlimitedProgressDialog = new CUnlimitedProgressDialog((Window)this.getParentWindow(), "BinDiff", "Loading Function Diffs", diffLoader);
        diffLoader.setProgressDescriptionTarget(cUnlimitedProgressDialog);
        cUnlimitedProgressDialog.setVisible(true);
        Exception exception = cUnlimitedProgressDialog.getException();
        if (exception == null) return;
        Logger.logException(exception, exception.getMessage());
        CMessageBox.showError(this.getMainWindow(), exception.getMessage());
    }

    public void loadWorkspace() {
        String string = BinDiffConfigFile.getInstance().getMainSettings().getWorkspaceDirectory();
        if ("".equals(string)) {
            BinDiffConfigFile.getInstance().getMainSettings().setWorkspaceDirectory(SystemUtils.getCurrentUserPersonalFolder());
        }
        File file = new File(BinDiffConfigFile.getInstance().getMainSettings().getWorkspaceDirectory());
        CFileChooser cFileChooser = new CFileChooser("BinDiffWorkspace", "BinDiff Workspace");
        cFileChooser.setDialogTitle("Open Workspace");
        cFileChooser.setApproveButtonText("Open");
        cFileChooser.setCheckBox("Use as default workspace");
        if (file.exists()) {
            cFileChooser.setCurrentDirectory(file);
        }
        if (0 != cFileChooser.showOpenDialog(this.getMainWindow())) return;
        File file2 = cFileChooser.getSelectedFile();
        this.loadWorkspace(file2, true);
        if (!cFileChooser.isSelectedCheckBox()) return;
        BinDiffConfigFile.getInstance().getMainSettings().setDefaultWorkspace(file2.getAbsolutePath());
    }

    public void loadWorkspace(String string) {
        File file = new File(string);
        if (!file.exists()) {
            Logger.logSevere("Load workspace failed. Workspace folder does not exist.", new Object[0]);
            CMessageBox.showError(this.getMainWindow(), "Load workspace failed. Workspace folder does not exist.");
            return;
        }
        this.loadWorkspace(file, true);
    }

    public void newDiff() {
        String string;
        Workspace workspace;
        MainWindow mainWindow = this.getMainWindow();
        NewDiffDialog newDiffDialog = new NewDiffDialog(mainWindow, new File(string = (workspace = this.getWorkspace()).getWorkspaceDir().getPath()));
        if (!newDiffDialog.getDiffButtonPressed()) return;
        File file = newDiffDialog.getIdb(ESide.PRIMARY);
        File file2 = newDiffDialog.getIdb(ESide.SECONDARY);
        File file3 = newDiffDialog.getBinExportBinary(ESide.PRIMARY);
        File file4 = newDiffDialog.getBinExportBinary(ESide.SECONDARY);
        File file5 = newDiffDialog.getDestinationDirectory();
        NewDiffImplementation newDiffImplementation = new NewDiffImplementation(mainWindow, workspace, file, file2, file3, file4, file5);
        try {
            ProgressDialog.show((Window)this.getMainWindow(), String.format("New single Diff '%s'", file5.getName()), newDiffImplementation);
            return;
        }
        catch (Exception var11_11) {
            Logger.logException(var11_11, var11_11.getMessage());
            CMessageBox.showError(this.getMainWindow(), "Unkown error while diffing.");
        }
    }

    public void newWorkspace() {
        NewWorkspaceDialog newWorkspaceDialog = new NewWorkspaceDialog(this.getParentWindow(), "New Workspace");
        newWorkspaceDialog.setVisible(true);
        if (!newWorkspaceDialog.isOkPressed()) {
            return;
        }
        if (this.getWorkspace().isLoaded() && !this.closeWorkspace()) {
            return;
        }
        String string = FileUtils.ensureTrailingSlash(newWorkspaceDialog.getWorkspacePath());
        File file = new File(string);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(String.format("%s%s.%s", string, newWorkspaceDialog.getWorkspaceName(), "BinDiffWorkspace"));
        try {
            this.getWorkspace().newWorkspace(file2);
            if (!newWorkspaceDialog.isDefaultWorkspace()) return;
            BinDiffConfigFile.getInstance().getMainSettings().setDefaultWorkspace(file2.getAbsolutePath());
            return;
        }
        catch (IOException | SQLException var5_5) {
            Logger.logException(var5_5);
            CMessageBox.showError(this.getMainWindow(), var5_5.getMessage());
        }
    }

    public void openCallgraphView(MainWindow mainWindow, Diff diff) {
        try {
            TabPanelManager tabPanelManager = mainWindow.getController().getTabPanelManager();
            if (diff.getViewManager().containsView(null, null)) {
                tabPanelManager.selectTabPanel(null, null, diff);
                return;
            }
            CallGraphViewLoader callGraphViewLoader = new CallGraphViewLoader(diff, this.getMainWindow(), tabPanelManager, this.getWorkspace());
            ProgressDialog.show((Window)this.getMainWindow(), String.format("Loading call graph '%s'", diff.getDiffName()), callGraphViewLoader);
            callGraphViewLoader = null;
            Iterator iterator = diff.getListener().iterator();
            while (iterator.hasNext()) {
                IDiffListener iDiffListener = (IDiffListener)iterator.next();
                iDiffListener.loadedView(diff);
            }
            return;
        }
        catch (Exception var3_4) {
            Logger.logException(var3_4, "Open call graph view failed. Couldn't create graph.");
            CMessageBox.showError(this.getMainWindow(), "Open call graph view failed. Couldn't create graph.");
        }
    }

    public void openFlowgraphView(MainWindow mainWindow, Diff diff, IAddress iAddress, IAddress iAddress2) {
        if (this.isImportThunkView(diff, iAddress, iAddress2, true)) {
            return;
        }
        TabPanelManager tabPanelManager = mainWindow.getController().getTabPanelManager();
        if (diff.getViewManager().containsView(iAddress, iAddress2)) {
            tabPanelManager.selectTabPanel(iAddress, iAddress2, diff);
            return;
        }
        try {
            LinkedHashSet<Triple> linkedHashSet = new LinkedHashSet<Triple>();
            linkedHashSet.add(Triple.make(diff, iAddress, iAddress2));
            FlowGraphViewLoader flowGraphViewLoader = new FlowGraphViewLoader(this.getMainWindow(), tabPanelManager, this.getWorkspace(), linkedHashSet);
            ProgressDialog.show((Window)this.getMainWindow(), String.format("Loading flow graph '%s'", diff.getDiffName()), flowGraphViewLoader);
            Iterator iterator = diff.getListener().iterator();
            while (iterator.hasNext()) {
                IDiffListener iDiffListener = (IDiffListener)iterator.next();
                iDiffListener.loadedView(diff);
            }
            return;
        }
        catch (Exception var6_7) {
            Logger.logException(var6_7, "Open flow graph view failed. Couldn't create flowgraph.");
            CMessageBox.showError(this.getMainWindow(), "Open flow graph view failed. Couldn't create flowgraph.");
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public void openFlowgraphViews(MainWindow var1_1, LinkedHashSet var2_2) {
        var3_3 = var1_1.getController().getTabPanelManager();
        var4_4 = new LinkedHashSet<Object>();
        var5_5 = 0;
        for (Object var7_8 : var2_2) {
            var8_9 = (Diff)var7_8.first();
            var9_10 = (IAddress)var7_8.second();
            var10_11 = (IAddress)var7_8.third();
            if (var8_9.getViewManager().containsView((IAddress)var9_10, (IAddress)var10_11)) continue;
            if (this.isImportThunkView((Diff)var8_9, (IAddress)var9_10, (IAddress)var10_11, false)) {
                ++var5_5;
                continue;
            }
            var4_4.add(var7_8);
        }
        if (var5_5 > 0) {
            CMessageBox.showInformation(this.getParentWindow(), String.format("%d import thunk views have not been opened since they do not contain any code.", new Object[]{var5_5}));
            if (var4_4.size() == 0) {
                return;
            }
        }
        try {
            var6_6 = new FlowGraphViewLoader(this.getMainWindow(), var3_3, this.getWorkspace(), var4_4);
            ProgressDialog.show((Window)this.getMainWindow(), "Loading flow graph views.", var6_6);
            var7_8 = new HashSet<E>();
            var8_9 = var2_2.iterator();
            block3 : do lbl-1000: // 3 sources:
            {
                if (var8_9.hasNext() == false) return;
                var9_10 = (Triple)var8_9.next();
                var10_11 = (Diff)var9_10.first();
                if (var7_8.contains(var10_11)) ** GOTO lbl-1000
                var7_8.add(var10_11);
                var11_12 = var10_11.getListener().iterator();
                do {
                    if (!var11_12.hasNext()) continue block3;
                    var12_13 = (IDiffListener)var11_12.next();
                    var12_13.loadedView((Diff)var10_11);
                } while (true);
                break;
            } while (true);
        }
        catch (Exception var6_7) {
            Logger.logException(var6_7, "Open flow graph view failed. Couldn't create flow graph.");
            CMessageBox.showError(this.getMainWindow(), "Open flow graph view failed. Couldn't create flow graph.");
        }
    }

    public void openFunctionDiffView(FunctionDiffSocketXmlData functionDiffSocketXmlData) {
        try {
            MainWindow mainWindow = this.getMainWindow();
            TabPanelManager tabPanelManager = mainWindow.getController().getTabPanelManager();
            FunctionDiffViewLoader functionDiffViewLoader = new FunctionDiffViewLoader(functionDiffSocketXmlData, mainWindow, tabPanelManager, this.getWorkspace());
            ProgressDialog.show((Window)this.getMainWindow(), "Loading function diff from IDA", functionDiffViewLoader);
            if (functionDiffSocketXmlData.getDiff() == null) return;
            Iterator iterator = functionDiffSocketXmlData.getDiff().getListener().iterator();
            while (iterator.hasNext()) {
                IDiffListener iDiffListener = (IDiffListener)iterator.next();
                iDiffListener.loadedView(functionDiffSocketXmlData.getDiff());
            }
            return;
        }
        catch (Exception var2_3) {
            Logger.logException(var2_3, "Open function diff view failed. Couldn't create graph.");
            CMessageBox.showError(this.getMainWindow(), "Open function diff view failed. Couldn't create graph.");
        }
    }

    public void openFunctionDiffView(MainWindow mainWindow, Diff diff) {
        FunctionDiffViewTabPanel functionDiffViewTabPanel;
        Diff diff2;
        Object object;
        Preconditions.checkArgument(diff.isFunctionDiff());
        IAddress iAddress = ((RawFunction)diff.getCallgraph(ESide.PRIMARY).getNodes().get(0)).getAddress();
        IAddress iAddress2 = ((RawFunction)diff.getCallgraph(ESide.SECONDARY).getNodes().get(0)).getAddress();
        if (this.isImportThunkView(diff, iAddress, iAddress2, true)) {
            return;
        }
        TabPanelManager tabPanelManager = mainWindow.getController().getTabPanelManager();
        Object object2 = tabPanelManager.iterator();
        do {
            if (object2.hasNext()) continue;
            object2 = (FunctionDiffMetaData)diff.getMetaData();
            object = new FunctionDiffSocketXmlData(diff);
            object.setFlowgraphOffset(object2.getFlowgraphOffset(ESide.PRIMARY), ESide.PRIMARY);
            object.setFlowgraphOffset(object2.getFlowgraphOffset(ESide.SECONDARY), ESide.SECONDARY);
            object.setFlowgraphsPath(diff.getExportFile(ESide.PRIMARY).getPath(), ESide.PRIMARY);
            object.setFlowgraphsPath(diff.getExportFile(ESide.SECONDARY).getPath(), ESide.SECONDARY);
            object.setMatchesDBPath(diff.getMatchesDatabase().getPath());
            this.openFunctionDiffView((FunctionDiffSocketXmlData)object);
            return;
        } while (!((object = (TabPanel)object2.next()) instanceof FunctionDiffViewTabPanel) || (diff2 = (functionDiffViewTabPanel = (FunctionDiffViewTabPanel)object).getView().getGraphs().getDiff()) != diff);
        tabPanelManager.getTabbedPane().setSelectedComponent((Component)object);
    }

    public boolean saveDescription(Diff diff, String string) {
        try {
            MatchesDatabase matchesDatabase = new MatchesDatabase(diff.getMatchesDatabase());
            Throwable throwable = null;
            try {
                matchesDatabase.saveDiffDescription(string);
                boolean bl2 = true;
                return bl2;
            }
            catch (Throwable var5_7) {
                throwable = var5_7;
                throw var5_7;
            }
            finally {
                if (matchesDatabase != null) {
                    if (throwable != null) {
                        try {
                            matchesDatabase.close();
                        }
                        catch (Throwable var6_8) {
                            throwable.addSuppressed(var6_8);
                        }
                    } else {
                        matchesDatabase.close();
                    }
                }
            }
        }
        catch (SQLException var3_4) {
            Logger.logException(var3_4, "Database error. Couldn't save diff description.");
            String string2 = String.valueOf(var3_4.getMessage());
            CMessageBox.showError(this.getMainWindow(), string2.length() != 0 ? "Database error. Couldn't save diff description: ".concat(string2) : new String("Database error. Couldn't save diff description: "));
            return false;
        }
    }

    public void setTreeNodeContextComponent(Component component) {
        if (component == null) {
            return;
        }
        JPanel jPanel = this.getWorkspaceTabPanel().getTreeNodeContextContainer();
        jPanel.removeAll();
        jPanel.add(component, "Center");
        jPanel.updateUI();
    }

    public void setWorkspaceTree(WorkspaceTree workspaceTree) {
        this.workspaceTree = workspaceTree;
    }

    public void showInCallgraph(Diff diff, Set set) {
        if (!diff.getViewManager().containsView(null, null)) {
            this.openCallgraphView(this.getMainWindow(), diff);
        } else {
            TabPanelManager tabPanelManager = this.getMainWindow().getController().getTabPanelManager();
            tabPanelManager.selectTabPanel(null, null, diff);
        }
        ArrayList<CombinedDiffNode> arrayList = new ArrayList<CombinedDiffNode>();
        ArrayList<CombinedDiffNode> arrayList2 = new ArrayList<CombinedDiffNode>();
        CallGraphViewData callGraphViewData = diff.getViewManager().getCallgraphViewData(diff);
        if (callGraphViewData == null) return;
        CombinedGraph combinedGraph = callGraphViewData.getGraphs().getCombinedGraph();
        Iterator iterator = combinedGraph.getNodes().iterator();
        do {
            IAddress iAddress;
            if (!iterator.hasNext()) {
                combinedGraph.selectNodes(arrayList, arrayList2);
                return;
            }
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)iterator.next();
            RawCombinedFunction rawCombinedFunction = (RawCombinedFunction)combinedDiffNode.getRawNode();
            IAddress iAddress2 = rawCombinedFunction.getAddress(ESide.PRIMARY);
            if (set.contains(Pair.make(iAddress2, iAddress = rawCombinedFunction.getAddress(ESide.SECONDARY)))) {
                arrayList.add(combinedDiffNode);
                continue;
            }
            arrayList2.add(combinedDiffNode);
        } while (true);
    }

    public void showInitialCallgraphSettingsDialog() {
        if (this.callgraphSettingsDialog == null) {
            this.callgraphSettingsDialog = new InitialCallGraphSettingsDialog(this.getMainWindow());
        }
        this.callgraphSettingsDialog.setVisible(true);
    }

    public void showInitialFlowgraphSettingsDialog() {
        if (this.flowgraphSettingsDialog == null) {
            this.flowgraphSettingsDialog = new InitialFlowGraphSettingsDialog(this.getMainWindow());
        }
        this.flowgraphSettingsDialog.setVisible(true);
    }

    public void showMainSettingsDialog() {
        if (this.mainSettingsDialog == null) {
            this.mainSettingsDialog = new MainSettingsDialog(this.getMainWindow());
        }
        this.mainSettingsDialog.setVisible(true);
    }
}

