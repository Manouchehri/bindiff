package com.google.security.zynamics.bindiff.gui.tabpanels;

import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.common.base.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.userview.*;

public final class TabPanelManager implements Iterable
{
    private static Color WORKSPACE_TAB_COLOR;
    private static Color SINGLE_FUNCTION_DIFF_VIEWS_TAB_COLOR;
    private static final TabPanelManager$ColorSlot[] colorSlots;
    private final TabPanelManager$InternalCloseTabButtonListener closeTabListener;
    private final TabPanelManager$InternalTabListener tablistener;
    private final MainWindow window;
    private final JTabbedPane tabbedPane;
    private final List tabPanels;
    private final Workspace workspace;
    
    public TabPanelManager(final MainWindow mainWindow, final Workspace workspace) {
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
    
    private Color getTabColor(final TabPanel tabPanel) {
        if (tabPanel instanceof FunctionDiffViewTabPanel) {
            return TabPanelManager.SINGLE_FUNCTION_DIFF_VIEWS_TAB_COLOR;
        }
        if (tabPanel instanceof ViewTabPanel) {
            final Diff diff = ((ViewTabPanel)tabPanel).getDiff();
            for (final TabPanelManager$ColorSlot tabPanelManager$ColorSlot : TabPanelManager.colorSlots) {
                if (tabPanelManager$ColorSlot.diff == diff) {
                    return tabPanelManager$ColorSlot.color;
                }
            }
        }
        return Colors.GRAY240;
    }
    
    private void registerTabColor(final TabPanel tabPanel) {
        if (tabPanel instanceof ViewTabPanel) {
            final Diff diff = ((ViewTabPanel)tabPanel).getDiff();
            if (diff.isFunctionDiff()) {
                return;
            }
            final TabPanelManager$ColorSlot[] colorSlots = TabPanelManager.colorSlots;
            for (int length = colorSlots.length, i = 0; i < length; ++i) {
                if (colorSlots[i].diff == diff) {
                    return;
                }
            }
            for (final TabPanelManager$ColorSlot tabPanelManager$ColorSlot : TabPanelManager.colorSlots) {
                if (tabPanelManager$ColorSlot.diff == null) {
                    final TabPanelManager$InternalDiffListener diffListener = new TabPanelManager$InternalDiffListener(this, null);
                    diff.addListener(diffListener);
                    tabPanelManager$ColorSlot.diff = diff;
                    tabPanelManager$ColorSlot.diffListener = diffListener;
                    return;
                }
            }
        }
    }
    
    private void unregisterTabColor(final Diff diff) {
        final Iterator<ViewTabPanel> iterator = (Iterator<ViewTabPanel>)this.window.getController().getTabPanelManager().getViewTabPanels().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getDiff() == diff) {
                return;
            }
        }
        for (final TabPanelManager$ColorSlot tabPanelManager$ColorSlot : TabPanelManager.colorSlots) {
            if (tabPanelManager$ColorSlot.diff == diff) {
                tabPanelManager$ColorSlot.diff.removeListener(tabPanelManager$ColorSlot.diffListener);
                tabPanelManager$ColorSlot.diff = null;
                tabPanelManager$ColorSlot.diffListener = null;
            }
        }
    }
    
    public void addTab(final TabPanel tabPanel) {
        this.tabbedPane.addTab(tabPanel.getTitle().toString(), tabPanel);
        final int n = this.tabbedPane.getTabCount() - 1;
        final Color white = Color.WHITE;
        TabButtonComponent tabButtonComponent;
        Color color;
        if (tabPanel instanceof WorkspaceTabPanel) {
            tabButtonComponent = new TabButtonComponent(this.tabbedPane, tabPanel, tabPanel.getIcon(), false);
            color = TabPanelManager.WORKSPACE_TAB_COLOR;
        }
        else {
            this.registerTabColor(tabPanel);
            color = this.getTabColor(tabPanel);
            tabButtonComponent = new TabButtonComponent(this.tabbedPane, tabPanel, tabPanel.getIcon(), true);
            tabButtonComponent.addListener(this.closeTabListener);
        }
        this.tabbedPane.setTabComponentAt(n, tabButtonComponent);
        this.tabbedPane.setBackgroundAt(n, color);
        this.tabPanels.add(tabPanel);
    }
    
    public JTabbedPane getTabbedPane() {
        return this.tabbedPane;
    }
    
    public ViewTabPanel getTabPanel(final IAddress address, final IAddress address2, final Diff diff) {
        for (final TabPanel tabPanel : this.tabPanels) {
            if (tabPanel instanceof ViewTabPanel) {
                final ViewData view = ((ViewTabPanel)tabPanel).getView();
                if (view.getGraphs().getDiff() != diff) {
                    continue;
                }
                final IAddress address3 = view.getAddress(ESide.PRIMARY);
                final IAddress address4 = view.getAddress(ESide.SECONDARY);
                if (view.isCallgraphView() && address3 == null && address4 == null && address == null && address2 == null) {
                    return (ViewTabPanel)tabPanel;
                }
                if (!view.isFlowgraphView()) {
                    continue;
                }
                boolean equals = address3 == null && address == null;
                if (address3 != null && address != null) {
                    equals = address3.equals(address);
                }
                boolean equals2 = address4 == null && address2 == null;
                if (address4 != null && address2 != null) {
                    equals2 = address4.equals(address2);
                }
                if (equals && equals2) {
                    return (ViewTabPanel)tabPanel;
                }
                continue;
            }
        }
        return null;
    }
    
    public List getViewTabPanels() {
        final ArrayList<ViewTabPanel> list = new ArrayList<ViewTabPanel>();
        for (final TabPanel tabPanel : this.tabPanels) {
            if (tabPanel instanceof ViewTabPanel) {
                list.add((ViewTabPanel)tabPanel);
            }
        }
        return list;
    }
    
    public List getViewTabPanels(final boolean b) {
        final ArrayList<ViewTabPanel> list = new ArrayList<ViewTabPanel>();
        for (final TabPanel tabPanel : this.tabPanels) {
            if (tabPanel instanceof ViewTabPanel && ((ViewTabPanel)tabPanel).getDiff().isFunctionDiff() == b) {
                list.add((ViewTabPanel)tabPanel);
            }
        }
        return list;
    }
    
    public WorkspaceTabPanel getWorkspaceTabPanel() {
        return (WorkspaceTabPanel)this.tabbedPane.getComponentAt(0);
    }
    
    @Override
    public Iterator iterator() {
        return this.tabPanels.iterator();
    }
    
    public void removeListener() {
        this.tabbedPane.addChangeListener(this.tablistener);
    }
    
    public void removeTab(final TabPanel tabPanel) {
        this.tabPanels.remove(tabPanel);
        this.tabbedPane.remove(this.tabbedPane.indexOfComponent(tabPanel));
    }
    
    public void selectTab(final TabPanel selectedComponent) {
        this.tabbedPane.setSelectedComponent(selectedComponent);
    }
    
    public void selectTabPanel(final IAddress address, final IAddress address2, final Diff diff) {
        final ViewTabPanel tabPanel = this.getTabPanel(address, address2, diff);
        if (tabPanel != null) {
            this.selectTab(tabPanel);
        }
    }
    
    public void udpateSelectedTabIcon() {
        final int selectedIndex = this.tabbedPane.getSelectedIndex();
        final TabButtonComponent tabButtonComponent = (TabButtonComponent)this.tabbedPane.getTabComponentAt(selectedIndex);
        if (tabButtonComponent != null) {
            tabButtonComponent.setIcon(this.tabPanels.get(selectedIndex).getIcon());
            tabButtonComponent.updateUI();
        }
    }
    
    public void updateSelectedTabTitel(final String title) {
        final TabButtonComponent tabButtonComponent = (TabButtonComponent)this.tabbedPane.getTabComponentAt(this.tabbedPane.getSelectedIndex());
        if (tabButtonComponent != null) {
            tabButtonComponent.setTitle(title);
            tabButtonComponent.updateUI();
        }
    }
    
    static {
        TabPanelManager.WORKSPACE_TAB_COLOR = Color.WHITE;
        TabPanelManager.SINGLE_FUNCTION_DIFF_VIEWS_TAB_COLOR = Color.WHITE;
        colorSlots = new TabPanelManager$ColorSlot[] { TabPanelManager$ColorSlot.make(Colors.DIFF_A_VIEW_TABS_COLOR), TabPanelManager$ColorSlot.make(Colors.DIFF_B_VIEW_TABS_COLOR), TabPanelManager$ColorSlot.make(Colors.DIFF_C_VIEW_TABS_COLOR), TabPanelManager$ColorSlot.make(Colors.DIFF_D_VIEW_TABS_COLOR) };
    }
}
