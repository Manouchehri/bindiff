/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.ICloseTabButtonListener;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButtonComponent;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager$ColorSlot;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager$InternalCloseTabButtonListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager$InternalDiffListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager$InternalTabListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.FunctionDiffViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.window.CWindowFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.IDiffListener;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeListener;

public final class TabPanelManager
implements Iterable {
    private static Color WORKSPACE_TAB_COLOR = Color.WHITE;
    private static Color SINGLE_FUNCTION_DIFF_VIEWS_TAB_COLOR = Color.WHITE;
    private static final TabPanelManager$ColorSlot[] colorSlots = new TabPanelManager$ColorSlot[]{TabPanelManager$ColorSlot.make(Colors.DIFF_A_VIEW_TABS_COLOR), TabPanelManager$ColorSlot.make(Colors.DIFF_B_VIEW_TABS_COLOR), TabPanelManager$ColorSlot.make(Colors.DIFF_C_VIEW_TABS_COLOR), TabPanelManager$ColorSlot.make(Colors.DIFF_D_VIEW_TABS_COLOR)};
    private final TabPanelManager$InternalCloseTabButtonListener closeTabListener;
    private final TabPanelManager$InternalTabListener tablistener;
    private final MainWindow window;
    private final JTabbedPane tabbedPane;
    private final List tabPanels;
    private final Workspace workspace;

    public TabPanelManager(MainWindow mainWindow, Workspace workspace) {
        this.closeTabListener = new TabPanelManager$InternalCloseTabButtonListener(this, null);
        this.tablistener = new TabPanelManager$InternalTabListener(this, null);
        this.tabbedPane = new JTabbedPane();
        this.tabPanels = new ArrayList();
        this.window = (MainWindow)Preconditions.checkNotNull(mainWindow);
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
        this.tabbedPane.setBorder(new LineBorder(Color.WHITE));
        this.tabbedPane.setTabLayoutPolicy(0);
        this.tabbedPane.setFocusable(false);
        UIManager.put("TabbedPane.tabAreaInsets", new Insets(0, 0, 0, 0));
        UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
        SwingUtilities.updateComponentTreeUI(this.tabbedPane);
        this.addListener();
    }

    private void addListener() {
        this.tabbedPane.addChangeListener(this.tablistener);
    }

    private Color getTabColor(TabPanel tabPanel) {
        if (tabPanel instanceof FunctionDiffViewTabPanel) {
            return SINGLE_FUNCTION_DIFF_VIEWS_TAB_COLOR;
        }
        if (!(tabPanel instanceof ViewTabPanel)) return Colors.GRAY240;
        Diff diff = ((ViewTabPanel)tabPanel).getDiff();
        TabPanelManager$ColorSlot[] arrtabPanelManager$ColorSlot = colorSlots;
        int n2 = arrtabPanelManager$ColorSlot.length;
        int n3 = 0;
        while (n3 < n2) {
            TabPanelManager$ColorSlot tabPanelManager$ColorSlot = arrtabPanelManager$ColorSlot[n3];
            if (tabPanelManager$ColorSlot.diff == diff) {
                return tabPanelManager$ColorSlot.color;
            }
            ++n3;
        }
        return Colors.GRAY240;
    }

    private void registerTabColor(TabPanel tabPanel) {
        if (!(tabPanel instanceof ViewTabPanel)) return;
        Diff diff = ((ViewTabPanel)tabPanel).getDiff();
        if (diff.isFunctionDiff()) {
            return;
        }
        for (TabPanelManager$ColorSlot tabPanelManager$ColorSlot2 : colorSlots) {
            if (tabPanelManager$ColorSlot2.diff != diff) continue;
            return;
        }
        TabPanelManager$ColorSlot[] arrtabPanelManager$ColorSlot = colorSlots;
        int n2 = arrtabPanelManager$ColorSlot.length;
        int n3 = 0;
        while (n3 < n2) {
            TabPanelManager$ColorSlot tabPanelManager$ColorSlot2;
            tabPanelManager$ColorSlot2 = arrtabPanelManager$ColorSlot[n3];
            if (tabPanelManager$ColorSlot2.diff == null) {
                TabPanelManager$InternalDiffListener tabPanelManager$InternalDiffListener = new TabPanelManager$InternalDiffListener(this, null);
                diff.addListener(tabPanelManager$InternalDiffListener);
                tabPanelManager$ColorSlot2.diff = diff;
                tabPanelManager$ColorSlot2.diffListener = tabPanelManager$InternalDiffListener;
                return;
            }
            ++n3;
        }
    }

    private void unregisterTabColor(Diff diff) {
        for (ViewTabPanel viewTabPanel : this.window.getController().getTabPanelManager().getViewTabPanels()) {
            if (viewTabPanel.getDiff() != diff) continue;
            return;
        }
        TabPanelManager$ColorSlot[] arrtabPanelManager$ColorSlot = colorSlots;
        int n2 = arrtabPanelManager$ColorSlot.length;
        int n3 = 0;
        while (n3 < n2) {
            TabPanelManager$ColorSlot tabPanelManager$ColorSlot = arrtabPanelManager$ColorSlot[n3];
            if (tabPanelManager$ColorSlot.diff == diff) {
                tabPanelManager$ColorSlot.diff.removeListener(tabPanelManager$ColorSlot.diffListener);
                tabPanelManager$ColorSlot.diff = null;
                tabPanelManager$ColorSlot.diffListener = null;
            }
            ++n3;
        }
    }

    public void addTab(TabPanel tabPanel) {
        TabButtonComponent tabButtonComponent;
        this.tabbedPane.addTab(tabPanel.getTitle().toString(), tabPanel);
        int n2 = this.tabbedPane.getTabCount() - 1;
        Color color = Color.WHITE;
        if (tabPanel instanceof WorkspaceTabPanel) {
            tabButtonComponent = new TabButtonComponent(this.tabbedPane, tabPanel, tabPanel.getIcon(), false);
            color = WORKSPACE_TAB_COLOR;
        } else {
            this.registerTabColor(tabPanel);
            color = this.getTabColor(tabPanel);
            tabButtonComponent = new TabButtonComponent(this.tabbedPane, tabPanel, tabPanel.getIcon(), true);
            tabButtonComponent.addListener(this.closeTabListener);
        }
        this.tabbedPane.setTabComponentAt(n2, tabButtonComponent);
        this.tabbedPane.setBackgroundAt(n2, color);
        this.tabPanels.add(tabPanel);
    }

    public JTabbedPane getTabbedPane() {
        return this.tabbedPane;
    }

    /*
     * Unable to fully structure code
     */
    public ViewTabPanel getTabPanel(IAddress var1_1, IAddress var2_2, Diff var3_3) {
        var4_4 = this.tabPanels.iterator();
        do lbl-1000: // 4 sources:
        {
            if (var4_4.hasNext() == false) return null;
            var5_5 = (TabPanel)var4_4.next();
            if (!(var5_5 instanceof ViewTabPanel) || (var6_6 = ((ViewTabPanel)var5_5).getView()).getGraphs().getDiff() != var3_3) ** GOTO lbl-1000
            var7_7 = var6_6.getAddress(ESide.PRIMARY);
            var8_8 = var6_6.getAddress(ESide.SECONDARY);
            if (var6_6.isCallgraphView() && var7_7 == null && var8_8 == null && var1_1 == null && var2_2 == null) {
                return (ViewTabPanel)var5_5;
            }
            if (!var6_6.isFlowgraphView()) ** GOTO lbl-1000
            v0 = var9_9 = var7_7 == null && var1_1 == null;
            if (var7_7 != null && var1_1 != null) {
                var9_9 = var7_7.equals(var1_1);
            }
            v1 = var10_10 = var8_8 == null && var2_2 == null;
            if (var8_8 == null || var2_2 == null) continue;
            var10_10 = var8_8.equals(var2_2);
        } while (!var9_9 || !var10_10);
        return (ViewTabPanel)var5_5;
    }

    public List getViewTabPanels() {
        ArrayList<ViewTabPanel> arrayList = new ArrayList<ViewTabPanel>();
        Iterator iterator = this.tabPanels.iterator();
        while (iterator.hasNext()) {
            TabPanel tabPanel = (TabPanel)iterator.next();
            if (!(tabPanel instanceof ViewTabPanel)) continue;
            arrayList.add((ViewTabPanel)tabPanel);
        }
        return arrayList;
    }

    public List getViewTabPanels(boolean bl2) {
        ArrayList<ViewTabPanel> arrayList = new ArrayList<ViewTabPanel>();
        Iterator iterator = this.tabPanels.iterator();
        while (iterator.hasNext()) {
            TabPanel tabPanel = (TabPanel)iterator.next();
            if (!(tabPanel instanceof ViewTabPanel) || ((ViewTabPanel)tabPanel).getDiff().isFunctionDiff() != bl2) continue;
            arrayList.add((ViewTabPanel)tabPanel);
        }
        return arrayList;
    }

    public WorkspaceTabPanel getWorkspaceTabPanel() {
        return (WorkspaceTabPanel)this.tabbedPane.getComponentAt(0);
    }

    public Iterator iterator() {
        return this.tabPanels.iterator();
    }

    public void removeListener() {
        this.tabbedPane.addChangeListener(this.tablistener);
    }

    public void removeTab(TabPanel tabPanel) {
        this.tabPanels.remove(tabPanel);
        int n2 = this.tabbedPane.indexOfComponent(tabPanel);
        this.tabbedPane.remove(n2);
    }

    public void selectTab(TabPanel tabPanel) {
        this.tabbedPane.setSelectedComponent(tabPanel);
    }

    public void selectTabPanel(IAddress iAddress, IAddress iAddress2, Diff diff) {
        ViewTabPanel viewTabPanel = this.getTabPanel(iAddress, iAddress2, diff);
        if (viewTabPanel == null) return;
        this.selectTab(viewTabPanel);
    }

    public void udpateSelectedTabIcon() {
        int n2 = this.tabbedPane.getSelectedIndex();
        TabButtonComponent tabButtonComponent = (TabButtonComponent)this.tabbedPane.getTabComponentAt(n2);
        if (tabButtonComponent == null) return;
        tabButtonComponent.setIcon(((TabPanel)this.tabPanels.get(n2)).getIcon());
        tabButtonComponent.updateUI();
    }

    public void updateSelectedTabTitel(String string) {
        int n2 = this.tabbedPane.getSelectedIndex();
        TabButtonComponent tabButtonComponent = (TabButtonComponent)this.tabbedPane.getTabComponentAt(n2);
        if (tabButtonComponent == null) return;
        tabButtonComponent.setTitle(string);
        tabButtonComponent.updateUI();
    }

    static /* synthetic */ MainWindow access$300(TabPanelManager tabPanelManager) {
        return tabPanelManager.window;
    }

    static /* synthetic */ void access$400(TabPanelManager tabPanelManager, Diff diff) {
        tabPanelManager.unregisterTabColor(diff);
    }

    static /* synthetic */ JTabbedPane access$500(TabPanelManager tabPanelManager) {
        return tabPanelManager.tabbedPane;
    }

    static /* synthetic */ Workspace access$600(TabPanelManager tabPanelManager) {
        return tabPanelManager.workspace;
    }

    static /* synthetic */ List access$700(TabPanelManager tabPanelManager) {
        return tabPanelManager.tabPanels;
    }
}

