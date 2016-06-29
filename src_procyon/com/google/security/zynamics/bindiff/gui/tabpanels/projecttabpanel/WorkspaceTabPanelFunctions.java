package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel;

import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.io.*;
import com.google.security.zynamics.bindiff.log.*;
import java.io.*;
import javax.swing.tree.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.*;
import java.sql.*;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.implementations.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.zylib.io.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.io.matches.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.database.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.graph.*;

public final class WorkspaceTabPanelFunctions extends TabPanelFunctions
{
    private MainSettingsDialog mainSettingsDialog;
    private InitialCallGraphSettingsDialog callgraphSettingsDialog;
    private InitialFlowGraphSettingsDialog flowgraphSettingsDialog;
    private WorkspaceTree workspaceTree;
    
    public WorkspaceTabPanelFunctions(final MainWindow mainWindow, final Workspace workspace) {
        super(mainWindow, workspace);
        this.mainSettingsDialog = null;
        this.callgraphSettingsDialog = null;
        this.flowgraphSettingsDialog = null;
    }
    
    private boolean closeViews(final List list, final List list2) {
        for (final ViewTabPanel selectedComponent : list) {
            selectedComponent.getController().getTabPanelManager().getTabbedPane().setSelectedComponent(selectedComponent);
            switch (CMessageBox.showYesNoCancelQuestion(this.getMainWindow(), String.format("Save %s '%s'?", selectedComponent.getDiff().isFunctionDiff() ? "Function Diff View" : "Diff View", selectedComponent.getView().getViewName()))) {
                case 0: {
                    if (selectedComponent.getController().closeView(true)) {
                        continue;
                    }
                    return false;
                }
                case 1: {
                    list2.add(selectedComponent);
                    continue;
                }
                default: {
                    return false;
                }
            }
        }
        final Iterator<ViewTabPanel> iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().getController().closeView(false);
        }
        return true;
    }
    
    private File copyFileIntoNewDiffDir(final File file, final File file2) {
        final File file3 = new File(String.format("%s%s%s", file, File.separator, file2.getName()));
        ByteStreams.copy(new FileInputStream(file2), new FileOutputStream(file3));
        return file3;
    }
    
    private boolean deleteDiff(final Diff diff, final boolean b) {
        this.removeDiffFromWorkspace(diff);
        if (b) {
            try {
                if (!diff.isFunctionDiff()) {
                    CFileUtils.deleteDirectory(new File(diff.getDiffFolder()));
                }
                else if (!this.deleteFunctionDiff(diff)) {
                    CMessageBox.showError(this.getMainWindow(), String.format("Couldn't delete '%s'.", diff.getMatchesDatabase().toString()));
                }
            }
            catch (IOException ex) {
                Logger.logException(ex, "Delete diff failed. Couldn't delete diff folder.");
                CMessageBox.showError(this.getMainWindow(), "Delete diff failed. Couldn't delete diff folder.");
                return false;
            }
        }
        return true;
    }
    
    private boolean deleteFunctionDiff(final Diff diff) {
        if (!diff.getMatchesDatabase().delete()) {
            return false;
        }
        final File parentFile = diff.getMatchesDatabase().getParentFile();
        final File exportFile = diff.getExportFile(ESide.PRIMARY);
        final File exportFile2 = diff.getExportFile(ESide.SECONDARY);
        boolean b = true;
        boolean b2 = true;
        for (final Diff diff2 : this.getWorkspace().getDiffList(true)) {
            if (parentFile.equals(diff2.getMatchesDatabase().getParentFile())) {
                if (diff2.getExportFile(ESide.PRIMARY).equals(exportFile)) {
                    b = false;
                }
                if (!diff2.getExportFile(ESide.SECONDARY).equals(exportFile2)) {
                    continue;
                }
                b2 = false;
            }
        }
        if (b && !exportFile.delete()) {
            return false;
        }
        if (b2 && !exportFile2.delete()) {
            return false;
        }
        if (parentFile.listFiles().length == 0) {
            final AllFunctionDiffViewsNode allFunctionDiffViewsNode = (AllFunctionDiffViewsNode)this.workspaceTree.getModel().getRoot().getChildAt(0);
            int n = -1;
            for (int i = 0; i < allFunctionDiffViewsNode.getChildCount(); ++i) {
                final FunctionDiffViewsNode functionDiffViewsNode = (FunctionDiffViewsNode)allFunctionDiffViewsNode.getChildAt(i);
                if (functionDiffViewsNode.getViewDirectory().equals(parentFile)) {
                    n = i;
                    functionDiffViewsNode.delete();
                    allFunctionDiffViewsNode.remove(i);
                    this.workspaceTree.updateTree();
                }
            }
            if (n == allFunctionDiffViewsNode.getChildCount()) {
                --n;
            }
            if (n > -1) {
                final TreePath selectionPath = new TreePath(((FunctionDiffViewsNode)allFunctionDiffViewsNode.getChildAt(n)).getPath());
                this.workspaceTree.expandPath(selectionPath);
                this.workspaceTree.setSelectionPath(selectionPath);
            }
            return parentFile.delete();
        }
        return true;
    }
    
    private MainWindow getParentWindow() {
        return (MainWindow)SwingUtilities.getWindowAncestor(this.workspaceTree);
    }
    
    private WorkspaceTabPanel getWorkspaceTabPanel() {
        return this.getMainWindow().getController().getTabPanelManager().getWorkspaceTabPanel();
    }
    
    private boolean isImportThunkView(final Diff diff, final IAddress address, final IAddress address2, final boolean b) {
        final RawFunction function = diff.getCallgraph(ESide.PRIMARY).getFunction(address);
        final RawFunction function2 = diff.getCallgraph(ESide.SECONDARY).getFunction(address2);
        if ((function != null && function2 == null && function.getFunctionType() == EFunctionType.IMPORTED) || (function2 != null && function == null && function2.getFunctionType() == EFunctionType.IMPORTED)) {
            if (b) {
                CMessageBox.showInformation(this.getMainWindow(), "Cannot open unmatched import thunk view since it doesn't contain any code.");
            }
            return true;
        }
        if (function != null && function.getFunctionType() == EFunctionType.IMPORTED && function2 != null && function2.getFunctionType() == EFunctionType.IMPORTED) {
            if (b) {
                CMessageBox.showInformation(this.getMainWindow(), "Cannot open matched import thunk view since it doesn't contain any code.");
            }
            return true;
        }
        return false;
    }
    
    private void loadWorkspace(final File file, final boolean b) {
        try {
            if (this.getWorkspace().isLoaded()) {
                this.getWorkspace().closeWorkspace();
            }
            final WorkspaceLoader workspaceLoader = new WorkspaceLoader(file, this.getWorkspace());
            if (b) {
                ProgressDialog.show(this.getMainWindow(), String.format("Loading Workspace '%s'", file.getName()), workspaceLoader);
            }
            else {
                workspaceLoader.loadMetaData();
            }
            final String errorMessage = workspaceLoader.getErrorMessage();
            if (!"".equals(errorMessage)) {
                Logger.logSevere(errorMessage, new Object[0]);
                CMessageBox.showError(this.getMainWindow(), errorMessage);
            }
            else {
                this.getWorkspace().saveWorkspace();
            }
        }
        catch (Exception ex) {
            Logger.logException(ex, String.format("Load workspace failed. %s", ex.getMessage()));
            CMessageBox.showError(this.getMainWindow(), String.format("Load workspace failed. %s", ex.getMessage()));
        }
    }
    
    private void removeDiffFromWorkspace(final Diff diff) {
        assert diff != null;
        final HashSet<Diff> set = new HashSet<Diff>();
        set.add(diff);
        this.getWorkspace().getDiffList().remove(diff);
        this.closeDiffs(set);
        diff.removeDiff();
        final Iterator iterator = this.getWorkspace().getListeners().iterator();
        while (iterator.hasNext()) {
            iterator.next().removedDiff(diff);
        }
        try {
            this.getWorkspace().saveWorkspace();
        }
        catch (SQLException ex) {
            Logger.logException(ex, "Couldn't delete temporary files.");
            final MainWindow mainWindow = this.getMainWindow();
            final String s = "Couldn't delete temporary files: ";
            final String value = String.valueOf(ex.getMessage());
            CMessageBox.showError(mainWindow, (value.length() != 0) ? s.concat(value) : new String(s));
        }
    }
    
    public void addDiff() {
        try {
            final AddDiffDialog addDiffDialog = new AddDiffDialog(this.getParentWindow(), this.getWorkspace());
            if (addDiffDialog.getAddButtonPressed()) {
                final File matchesBinary = addDiffDialog.getMatchesBinary();
                final File binExportBinary = addDiffDialog.getBinExportBinary(ESide.PRIMARY);
                final File binExportBinary2 = addDiffDialog.getBinExportBinary(ESide.SECONDARY);
                final File destinationDirectory = addDiffDialog.getDestinationDirectory();
                File copyFileIntoNewDiffDir = matchesBinary;
                if (!destinationDirectory.equals(matchesBinary.getParentFile())) {
                    destinationDirectory.mkdir();
                    copyFileIntoNewDiffDir = this.copyFileIntoNewDiffDir(destinationDirectory, matchesBinary);
                    this.copyFileIntoNewDiffDir(destinationDirectory, binExportBinary);
                    this.copyFileIntoNewDiffDir(destinationDirectory, binExportBinary2);
                }
                this.getWorkspace().addDiff(copyFileIntoNewDiffDir, DiffLoader.preloadDiffMatches(copyFileIntoNewDiffDir), false);
            }
        }
        catch (IOException | SQLException ex3) {
            final SQLException ex2;
            final SQLException ex = ex2;
            Logger.logException(ex, "Add diff failed. Couldn't add diff to workspace.");
            final MainWindow mainWindow = this.getMainWindow();
            final String s = "Add diff failed. Couldn't add diff to workspace: ";
            final String value = String.valueOf(ex.getMessage());
            CMessageBox.showError(mainWindow, (value.length() != 0) ? s.concat(value) : new String(s));
        }
    }
    
    public void closeDialogs() {
        if (this.mainSettingsDialog != null) {
            this.mainSettingsDialog.dispose();
        }
        if (this.flowgraphSettingsDialog != null) {
            this.flowgraphSettingsDialog.dispose();
        }
        if (this.callgraphSettingsDialog != null) {
            this.callgraphSettingsDialog.dispose();
        }
    }
    
    public boolean closeDiffs(final Set set) {
        final ArrayList<ViewTabPanel> list = new ArrayList<ViewTabPanel>();
        final ArrayList<ViewTabPanel> list2 = new ArrayList<ViewTabPanel>();
        for (final ViewTabPanel viewTabPanel : this.getOpenViews(set)) {
            if (viewTabPanel.getController().hasChanged()) {
                if (viewTabPanel.getDiff().isFunctionDiff()) {
                    list.add(0, viewTabPanel);
                }
                else {
                    list.add(viewTabPanel);
                }
            }
            else {
                list2.add(viewTabPanel);
            }
        }
        if (this.closeViews(list, list2)) {
            final Iterator<Diff> iterator2 = set.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().closeDiff();
            }
            return true;
        }
        return false;
    }
    
    public void closeViews(final Set set) {
        final ArrayList<ViewTabPanel> list = new ArrayList<ViewTabPanel>();
        final ArrayList<ViewTabPanel> list2 = new ArrayList<ViewTabPanel>();
        for (final ViewTabPanel viewTabPanel : set) {
            if (viewTabPanel.getController().hasChanged()) {
                if (viewTabPanel.getDiff().isFunctionDiff()) {
                    list.add(0, viewTabPanel);
                }
                else {
                    list.add(viewTabPanel);
                }
            }
            else {
                list2.add(viewTabPanel);
            }
        }
        this.closeViews(list, list2);
    }
    
    public boolean closeWorkspace() {
        final HashSet set = new HashSet();
        set.addAll(this.getWorkspace().getDiffList());
        if (!this.closeDiffs(set)) {
            return false;
        }
        this.getWorkspace().closeWorkspace();
        return true;
    }
    
    public boolean deleteDiff(final Diff diff) {
        final Diff diff2 = (diff == null) ? this.getSelectedDiff() : diff;
        final Pair showYesNoQuestionWithCheckbox = CMessageBox.showYesNoQuestionWithCheckbox(this.getParentWindow(), String.format("Are you sure you want to remove '%s'?\n\n", diff2.getDiffName()), "Also delete diff contents on disk?");
        return (int)showYesNoQuestionWithCheckbox.first() == 0 && this.deleteDiff(diff2, (boolean)showYesNoQuestionWithCheckbox.second());
    }
    
    public boolean deleteFunctionDiffs(final List list) {
        if (list.isEmpty()) {
            return false;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Are you sure you want to delete this function diff views from disk?\n\n");
        int n = 0;
        for (final Diff diff : list) {
            if (n != 0) {
                sb.append("\n");
            }
            sb.append(String.format("'%s'", diff.getDiffName()));
            if (n++ == 4 && list.size() > 5) {
                sb.append("\n...");
                break;
            }
        }
        if (CMessageBox.showYesNoQuestion(this.getParentWindow(), sb.toString()) == 0) {
            boolean b = true;
            final Iterator<Diff> iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                final boolean deleteDiff = this.deleteDiff(iterator2.next(), true);
                if (b) {
                    b = deleteDiff;
                }
            }
            return b;
        }
        return false;
    }
    
    public void directoryDiff() {
        final MainWindow mainWindow = this.getMainWindow();
        final Workspace workspace = this.getWorkspace();
        final DirectoryDiffDialog directoryDiffDialog = new DirectoryDiffDialog(mainWindow, new File(workspace.getWorkspaceDir().getPath()));
        if (directoryDiffDialog.getDiffButtonPressed()) {
            final DirectoryDiffImplementation directoryDiffImplementation = new DirectoryDiffImplementation(mainWindow, workspace, directoryDiffDialog.getSourceBasePath(ESide.PRIMARY), directoryDiffDialog.getSourceBasePath(ESide.SECONDARY), directoryDiffDialog.getSelectedIdbPairs());
            try {
                ProgressDialog.show(mainWindow, "Directory Diffing...", directoryDiffImplementation);
            }
            catch (Exception ex) {
                Logger.logException(ex, "Directory diffing was canceled because an unexpected exception!");
                CMessageBox.showError(mainWindow, "Directory diffing was canceled because of an unexpected exception!");
            }
            if (directoryDiffImplementation.getDiffingErrorMessages().size() != 0) {
                int n = 0;
                final StringBuilder sb = new StringBuilder();
                for (final String s : directoryDiffImplementation.getDiffingErrorMessages()) {
                    if (++n == 10) {
                        sb.append("...");
                        break;
                    }
                    sb.append(String.valueOf(s).concat("\n"));
                }
                CMessageBox.showError(mainWindow, sb.toString());
            }
            if (directoryDiffImplementation.getOpeningDiffErrorMessages().size() != 0) {
                int n2 = 0;
                final StringBuilder sb2 = new StringBuilder();
                for (final String s2 : directoryDiffImplementation.getOpeningDiffErrorMessages()) {
                    if (++n2 == 10) {
                        sb2.append("...");
                        break;
                    }
                    sb2.append(String.valueOf(s2).concat("\n"));
                }
                CMessageBox.showError(mainWindow, sb2.toString());
            }
        }
    }
    
    public LinkedHashSet getOpenViews(final Set set) {
        final LinkedHashSet<ViewTabPanel> set2 = new LinkedHashSet<ViewTabPanel>();
        for (final ViewTabPanel viewTabPanel : new ArrayList<ViewTabPanel>(this.getMainWindow().getController().getTabPanelManager().getViewTabPanels())) {
            if (!set.contains(viewTabPanel.getDiff())) {
                continue;
            }
            set2.add(viewTabPanel);
        }
        return set2;
    }
    
    public Diff getSelectedDiff() {
        return ((AbstractTreeNode)this.getWorkspaceTree().getSelectionModel().getSelectionPath().getLastPathComponent()).getDiff();
    }
    
    public WorkspaceTree getWorkspaceTree() {
        return this.workspaceTree;
    }
    
    public void loadDefaultWorkspace() {
        final String defaultWorkspace = BinDiffConfigFile.getInstance().getMainSettings().getDefaultWorkspace();
        if (defaultWorkspace == null || "".equals(defaultWorkspace)) {
            return;
        }
        final File file = new File(defaultWorkspace);
        if (file.exists() && file.canWrite()) {
            this.loadWorkspace(file, false);
        }
    }
    
    public void loadDiff(Diff selectedDiff) {
        if (selectedDiff == null) {
            selectedDiff = this.getSelectedDiff();
        }
        if (selectedDiff.isLoaded()) {
            return;
        }
        final LinkedHashSet<Diff> set = new LinkedHashSet<Diff>();
        set.add(selectedDiff);
        final DiffLoader diffLoader = new DiffLoader(set);
        final CUnlimitedProgressDialog progressDescriptionTarget = new CUnlimitedProgressDialog(this.getParentWindow(), "BinDiff", String.format("Loading '%s'", selectedDiff.getDiffName()), diffLoader);
        diffLoader.setProgressDescriptionTarget(progressDescriptionTarget);
        progressDescriptionTarget.setVisible(true);
        final Exception exception = progressDescriptionTarget.getException();
        if (exception != null) {
            Logger.logException(exception, exception.getMessage());
            CMessageBox.showError(this.getMainWindow(), exception.getMessage());
        }
    }
    
    public void loadFunctionDiffs() {
        final LinkedHashSet<Diff> set = new LinkedHashSet<Diff>();
        for (final Diff diff : this.getWorkspace().getDiffList(true)) {
            if (!diff.isLoaded()) {
                set.add(diff);
            }
        }
        this.loadFunctionDiffs(set);
    }
    
    public void loadFunctionDiffs(final LinkedHashSet set) {
        final DiffLoader diffLoader = new DiffLoader(set);
        final CUnlimitedProgressDialog progressDescriptionTarget = new CUnlimitedProgressDialog(this.getParentWindow(), "BinDiff", "Loading Function Diffs", diffLoader);
        diffLoader.setProgressDescriptionTarget(progressDescriptionTarget);
        progressDescriptionTarget.setVisible(true);
        final Exception exception = progressDescriptionTarget.getException();
        if (exception != null) {
            Logger.logException(exception, exception.getMessage());
            CMessageBox.showError(this.getMainWindow(), exception.getMessage());
        }
    }
    
    public void loadWorkspace() {
        if ("".equals(BinDiffConfigFile.getInstance().getMainSettings().getWorkspaceDirectory())) {
            BinDiffConfigFile.getInstance().getMainSettings().setWorkspaceDirectory(SystemUtils.getCurrentUserPersonalFolder());
        }
        final File currentDirectory = new File(BinDiffConfigFile.getInstance().getMainSettings().getWorkspaceDirectory());
        final CFileChooser cFileChooser = new CFileChooser("BinDiffWorkspace", "BinDiff Workspace");
        cFileChooser.setDialogTitle("Open Workspace");
        cFileChooser.setApproveButtonText("Open");
        cFileChooser.setCheckBox("Use as default workspace");
        if (currentDirectory.exists()) {
            cFileChooser.setCurrentDirectory(currentDirectory);
        }
        if (0 == cFileChooser.showOpenDialog(this.getMainWindow())) {
            final File selectedFile = cFileChooser.getSelectedFile();
            this.loadWorkspace(selectedFile, true);
            if (cFileChooser.isSelectedCheckBox()) {
                BinDiffConfigFile.getInstance().getMainSettings().setDefaultWorkspace(selectedFile.getAbsolutePath());
            }
        }
    }
    
    public void loadWorkspace(final String s) {
        final File file = new File(s);
        if (!file.exists()) {
            Logger.logSevere("Load workspace failed. Workspace folder does not exist.", new Object[0]);
            CMessageBox.showError(this.getMainWindow(), "Load workspace failed. Workspace folder does not exist.");
            return;
        }
        this.loadWorkspace(file, true);
    }
    
    public void newDiff() {
        final MainWindow mainWindow = this.getMainWindow();
        final Workspace workspace = this.getWorkspace();
        final NewDiffDialog newDiffDialog = new NewDiffDialog(mainWindow, new File(workspace.getWorkspaceDir().getPath()));
        if (newDiffDialog.getDiffButtonPressed()) {
            final File idb = newDiffDialog.getIdb(ESide.PRIMARY);
            final File idb2 = newDiffDialog.getIdb(ESide.SECONDARY);
            final File binExportBinary = newDiffDialog.getBinExportBinary(ESide.PRIMARY);
            final File binExportBinary2 = newDiffDialog.getBinExportBinary(ESide.SECONDARY);
            final File destinationDirectory = newDiffDialog.getDestinationDirectory();
            final NewDiffImplementation newDiffImplementation = new NewDiffImplementation(mainWindow, workspace, idb, idb2, binExportBinary, binExportBinary2, destinationDirectory);
            try {
                ProgressDialog.show(this.getMainWindow(), String.format("New single Diff '%s'", destinationDirectory.getName()), newDiffImplementation);
            }
            catch (Exception ex) {
                Logger.logException(ex, ex.getMessage());
                CMessageBox.showError(this.getMainWindow(), "Unkown error while diffing.");
            }
        }
    }
    
    public void newWorkspace() {
        final NewWorkspaceDialog newWorkspaceDialog = new NewWorkspaceDialog((Window)this.getParentWindow(), "New Workspace");
        newWorkspaceDialog.setVisible(true);
        if (!newWorkspaceDialog.isOkPressed()) {
            return;
        }
        if (this.getWorkspace().isLoaded() && !this.closeWorkspace()) {
            return;
        }
        final String ensureTrailingSlash = FileUtils.ensureTrailingSlash(newWorkspaceDialog.getWorkspacePath());
        final File file = new File(ensureTrailingSlash);
        if (!file.exists()) {
            file.mkdir();
        }
        final File file2 = new File(String.format("%s%s.%s", ensureTrailingSlash, newWorkspaceDialog.getWorkspaceName(), "BinDiffWorkspace"));
        try {
            this.getWorkspace().newWorkspace(file2);
            if (newWorkspaceDialog.isDefaultWorkspace()) {
                BinDiffConfigFile.getInstance().getMainSettings().setDefaultWorkspace(file2.getAbsolutePath());
            }
        }
        catch (IOException | SQLException ex3) {
            final SQLException ex2;
            final SQLException ex = ex2;
            Logger.logException(ex);
            CMessageBox.showError(this.getMainWindow(), ex.getMessage());
        }
    }
    
    public void openCallgraphView(final MainWindow mainWindow, final Diff diff) {
        try {
            final TabPanelManager tabPanelManager = mainWindow.getController().getTabPanelManager();
            if (diff.getViewManager().containsView(null, null)) {
                tabPanelManager.selectTabPanel(null, null, diff);
            }
            else {
                ProgressDialog.show(this.getMainWindow(), String.format("Loading call graph '%s'", diff.getDiffName()), new CallGraphViewLoader(diff, this.getMainWindow(), tabPanelManager, this.getWorkspace()));
                final Iterator iterator = diff.getListener().iterator();
                while (iterator.hasNext()) {
                    iterator.next().loadedView(diff);
                }
            }
        }
        catch (Exception ex) {
            Logger.logException(ex, "Open call graph view failed. Couldn't create graph.");
            CMessageBox.showError(this.getMainWindow(), "Open call graph view failed. Couldn't create graph.");
        }
    }
    
    public void openFlowgraphView(final MainWindow mainWindow, final Diff diff, final IAddress address, final IAddress address2) {
        if (this.isImportThunkView(diff, address, address2, true)) {
            return;
        }
        final TabPanelManager tabPanelManager = mainWindow.getController().getTabPanelManager();
        if (diff.getViewManager().containsView(address, address2)) {
            tabPanelManager.selectTabPanel(address, address2, diff);
            return;
        }
        try {
            final LinkedHashSet<Triple> set = new LinkedHashSet<Triple>();
            set.add(Triple.make(diff, address, address2));
            ProgressDialog.show(this.getMainWindow(), String.format("Loading flow graph '%s'", diff.getDiffName()), new FlowGraphViewLoader(this.getMainWindow(), tabPanelManager, this.getWorkspace(), set));
            final Iterator iterator = diff.getListener().iterator();
            while (iterator.hasNext()) {
                iterator.next().loadedView(diff);
            }
        }
        catch (Exception ex) {
            Logger.logException(ex, "Open flow graph view failed. Couldn't create flowgraph.");
            CMessageBox.showError(this.getMainWindow(), "Open flow graph view failed. Couldn't create flowgraph.");
        }
    }
    
    public void openFlowgraphViews(final MainWindow mainWindow, final LinkedHashSet set) {
        final TabPanelManager tabPanelManager = mainWindow.getController().getTabPanelManager();
        final LinkedHashSet<Triple> set2 = new LinkedHashSet<Triple>();
        int n = 0;
        for (final Triple triple : set) {
            final Diff diff = (Diff)triple.first();
            final IAddress address = (IAddress)triple.second();
            final IAddress address2 = (IAddress)triple.third();
            if (!diff.getViewManager().containsView(address, address2)) {
                if (this.isImportThunkView(diff, address, address2, false)) {
                    ++n;
                }
                else {
                    set2.add(triple);
                }
            }
        }
        if (n > 0) {
            CMessageBox.showInformation(this.getParentWindow(), String.format("%d import thunk views have not been opened since they do not contain any code.", n));
            if (set2.size() == 0) {
                return;
            }
        }
        try {
            ProgressDialog.show(this.getMainWindow(), "Loading flow graph views.", new FlowGraphViewLoader(this.getMainWindow(), tabPanelManager, this.getWorkspace(), set2));
            final HashSet<Diff> set3 = new HashSet<Diff>();
            final Iterator<Triple> iterator2 = set.iterator();
            while (iterator2.hasNext()) {
                final Diff diff2 = (Diff)iterator2.next().first();
                if (!set3.contains(diff2)) {
                    set3.add(diff2);
                    final Iterator iterator3 = diff2.getListener().iterator();
                    while (iterator3.hasNext()) {
                        iterator3.next().loadedView(diff2);
                    }
                }
            }
        }
        catch (Exception ex) {
            Logger.logException(ex, "Open flow graph view failed. Couldn't create flow graph.");
            CMessageBox.showError(this.getMainWindow(), "Open flow graph view failed. Couldn't create flow graph.");
        }
    }
    
    public void openFunctionDiffView(final FunctionDiffSocketXmlData functionDiffSocketXmlData) {
        try {
            final MainWindow mainWindow = this.getMainWindow();
            ProgressDialog.show(this.getMainWindow(), "Loading function diff from IDA", new FunctionDiffViewLoader(functionDiffSocketXmlData, mainWindow, mainWindow.getController().getTabPanelManager(), this.getWorkspace()));
            if (functionDiffSocketXmlData.getDiff() != null) {
                final Iterator iterator = functionDiffSocketXmlData.getDiff().getListener().iterator();
                while (iterator.hasNext()) {
                    iterator.next().loadedView(functionDiffSocketXmlData.getDiff());
                }
            }
        }
        catch (Exception ex) {
            Logger.logException(ex, "Open function diff view failed. Couldn't create graph.");
            CMessageBox.showError(this.getMainWindow(), "Open function diff view failed. Couldn't create graph.");
        }
    }
    
    public void openFunctionDiffView(final MainWindow mainWindow, final Diff diff) {
        Preconditions.checkArgument(diff.isFunctionDiff());
        if (this.isImportThunkView(diff, diff.getCallgraph(ESide.PRIMARY).getNodes().get(0).getAddress(), diff.getCallgraph(ESide.SECONDARY).getNodes().get(0).getAddress(), true)) {
            return;
        }
        final TabPanelManager tabPanelManager = mainWindow.getController().getTabPanelManager();
        for (final TabPanel selectedComponent : tabPanelManager) {
            if (selectedComponent instanceof FunctionDiffViewTabPanel && ((FunctionDiffViewTabPanel)selectedComponent).getView().getGraphs().getDiff() == diff) {
                tabPanelManager.getTabbedPane().setSelectedComponent(selectedComponent);
                return;
            }
        }
        final FunctionDiffMetaData functionDiffMetaData = (FunctionDiffMetaData)diff.getMetaData();
        final FunctionDiffSocketXmlData functionDiffSocketXmlData = new FunctionDiffSocketXmlData(diff);
        functionDiffSocketXmlData.setFlowgraphOffset(functionDiffMetaData.getFlowgraphOffset(ESide.PRIMARY), ESide.PRIMARY);
        functionDiffSocketXmlData.setFlowgraphOffset(functionDiffMetaData.getFlowgraphOffset(ESide.SECONDARY), ESide.SECONDARY);
        functionDiffSocketXmlData.setFlowgraphsPath(diff.getExportFile(ESide.PRIMARY).getPath(), ESide.PRIMARY);
        functionDiffSocketXmlData.setFlowgraphsPath(diff.getExportFile(ESide.SECONDARY).getPath(), ESide.SECONDARY);
        functionDiffSocketXmlData.setMatchesDBPath(diff.getMatchesDatabase().getPath());
        this.openFunctionDiffView(functionDiffSocketXmlData);
    }
    
    public boolean saveDescription(final Diff diff, final String s) {
        try (final MatchesDatabase matchesDatabase = new MatchesDatabase(diff.getMatchesDatabase())) {
            matchesDatabase.saveDiffDescription(s);
            return true;
        }
        catch (SQLException ex) {
            Logger.logException(ex, "Database error. Couldn't save diff description.");
            final MainWindow mainWindow = this.getMainWindow();
            final String s2 = "Database error. Couldn't save diff description: ";
            final String value = String.valueOf(ex.getMessage());
            CMessageBox.showError(mainWindow, (value.length() != 0) ? s2.concat(value) : new String(s2));
            return false;
        }
    }
    
    public void setTreeNodeContextComponent(final Component component) {
        if (component == null) {
            return;
        }
        final JPanel treeNodeContextContainer = this.getWorkspaceTabPanel().getTreeNodeContextContainer();
        treeNodeContextContainer.removeAll();
        treeNodeContextContainer.add(component, "Center");
        treeNodeContextContainer.updateUI();
    }
    
    public void setWorkspaceTree(final WorkspaceTree workspaceTree) {
        this.workspaceTree = workspaceTree;
    }
    
    public void showInCallgraph(final Diff diff, final Set set) {
        if (!diff.getViewManager().containsView(null, null)) {
            this.openCallgraphView(this.getMainWindow(), diff);
        }
        else {
            this.getMainWindow().getController().getTabPanelManager().selectTabPanel(null, null, diff);
        }
        final ArrayList<CombinedDiffNode> list = new ArrayList<CombinedDiffNode>();
        final ArrayList<CombinedDiffNode> list2 = new ArrayList<CombinedDiffNode>();
        final CallGraphViewData callgraphViewData = diff.getViewManager().getCallgraphViewData(diff);
        if (callgraphViewData != null) {
            final CombinedGraph combinedGraph = callgraphViewData.getGraphs().getCombinedGraph();
            for (final CombinedDiffNode combinedDiffNode : combinedGraph.getNodes()) {
                final RawCombinedFunction rawCombinedFunction = (RawCombinedFunction)combinedDiffNode.getRawNode();
                if (set.contains(Pair.make(rawCombinedFunction.getAddress(ESide.PRIMARY), rawCombinedFunction.getAddress(ESide.SECONDARY)))) {
                    list.add(combinedDiffNode);
                }
                else {
                    list2.add(combinedDiffNode);
                }
            }
            combinedGraph.selectNodes(list, list2);
        }
    }
    
    public void showInitialCallgraphSettingsDialog() {
        if (this.callgraphSettingsDialog == null) {
            this.callgraphSettingsDialog = new InitialCallGraphSettingsDialog((Window)this.getMainWindow());
        }
        this.callgraphSettingsDialog.setVisible(true);
    }
    
    public void showInitialFlowgraphSettingsDialog() {
        if (this.flowgraphSettingsDialog == null) {
            this.flowgraphSettingsDialog = new InitialFlowGraphSettingsDialog((Window)this.getMainWindow());
        }
        this.flowgraphSettingsDialog.setVisible(true);
    }
    
    public void showMainSettingsDialog() {
        if (this.mainSettingsDialog == null) {
            this.mainSettingsDialog = new MainSettingsDialog((Window)this.getMainWindow());
        }
        this.mainSettingsDialog.setVisible(true);
    }
}
