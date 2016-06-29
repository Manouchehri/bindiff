/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.tabbedui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.Window;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeListener;
import org.jfree.ui.tabbedui.AbstractTabbedUI$ExitAction;
import org.jfree.ui.tabbedui.AbstractTabbedUI$TabChangeHandler;
import org.jfree.ui.tabbedui.AbstractTabbedUI$TabEnableChangeListener;
import org.jfree.ui.tabbedui.RootEditor;

public abstract class AbstractTabbedUI
extends JComponent {
    public static final String JMENUBAR_PROPERTY = "jMenuBar";
    public static final String GLOBAL_MENU_PROPERTY = "globalMenu";
    private ArrayList rootEditors;
    private JTabbedPane tabbedPane;
    private int selectedRootEditor = -1;
    private JComponent currentToolbar;
    private JPanel toolbarContainer = new JPanel();
    private Action closeAction;
    private JMenuBar jMenuBar;
    private boolean globalMenu;

    public AbstractTabbedUI() {
        this.toolbarContainer.setLayout(new BorderLayout());
        this.tabbedPane = new JTabbedPane(3);
        this.tabbedPane.addChangeListener(new AbstractTabbedUI$TabChangeHandler(this, this.tabbedPane));
        this.rootEditors = new ArrayList();
        this.setLayout(new BorderLayout());
        this.add((Component)this.toolbarContainer, "North");
        this.add((Component)this.tabbedPane, "Center");
        this.closeAction = this.createCloseAction();
    }

    protected JTabbedPane getTabbedPane() {
        return this.tabbedPane;
    }

    public boolean isGlobalMenu() {
        return this.globalMenu;
    }

    public void setGlobalMenu(boolean bl2) {
        this.globalMenu = bl2;
        if (this.isGlobalMenu()) {
            this.setJMenuBar(this.updateGlobalMenubar());
            return;
        }
        if (this.getRootEditorCount() <= 0) return;
        this.setJMenuBar(this.createEditorMenubar(this.getRootEditor(this.getSelectedEditor())));
    }

    public JMenuBar getJMenuBar() {
        return this.jMenuBar;
    }

    protected void setJMenuBar(JMenuBar jMenuBar) {
        JMenuBar jMenuBar2 = this.jMenuBar;
        this.jMenuBar = jMenuBar;
        this.firePropertyChange("jMenuBar", jMenuBar2, jMenuBar);
    }

    protected Action createCloseAction() {
        return new AbstractTabbedUI$ExitAction(this);
    }

    public Action getCloseAction() {
        return this.closeAction;
    }

    protected abstract JMenu[] getPrefixMenus();

    protected abstract JMenu[] getPostfixMenus();

    private void addMenus(JMenuBar jMenuBar, JMenu[] arrjMenu) {
        int n2 = 0;
        while (n2 < arrjMenu.length) {
            jMenuBar.add(arrjMenu[n2]);
            ++n2;
        }
    }

    private JMenuBar updateGlobalMenubar() {
        JMenuBar jMenuBar = this.getJMenuBar();
        if (jMenuBar == null) {
            jMenuBar = new JMenuBar();
        } else {
            jMenuBar.removeAll();
        }
        this.addMenus(jMenuBar, this.getPrefixMenus());
        int n2 = 0;
        do {
            if (n2 >= this.rootEditors.size()) {
                this.addMenus(jMenuBar, this.getPostfixMenus());
                return jMenuBar;
            }
            RootEditor rootEditor = (RootEditor)this.rootEditors.get(n2);
            this.addMenus(jMenuBar, rootEditor.getMenus());
            ++n2;
        } while (true);
    }

    private JMenuBar createEditorMenubar(RootEditor rootEditor) {
        JMenuBar jMenuBar = this.getJMenuBar();
        if (jMenuBar == null) {
            jMenuBar = new JMenuBar();
        } else {
            jMenuBar.removeAll();
        }
        this.addMenus(jMenuBar, this.getPrefixMenus());
        if (this.isGlobalMenu()) {
            for (int i2 = 0; i2 < this.rootEditors.size(); ++i2) {
                RootEditor rootEditor2 = (RootEditor)this.rootEditors.get(i2);
                this.addMenus(jMenuBar, rootEditor2.getMenus());
            }
        } else {
            this.addMenus(jMenuBar, rootEditor.getMenus());
        }
        this.addMenus(jMenuBar, this.getPostfixMenus());
        return jMenuBar;
    }

    public void addRootEditor(RootEditor rootEditor) {
        this.rootEditors.add(rootEditor);
        this.tabbedPane.add(rootEditor.getEditorName(), rootEditor.getMainPanel());
        rootEditor.addPropertyChangeListener("enabled", new AbstractTabbedUI$TabEnableChangeListener(this));
        this.updateRootEditorEnabled(rootEditor);
        if (this.getRootEditorCount() == 1) {
            this.setSelectedEditor(0);
            return;
        }
        if (!this.isGlobalMenu()) return;
        this.setJMenuBar(this.updateGlobalMenubar());
    }

    public int getRootEditorCount() {
        return this.rootEditors.size();
    }

    public RootEditor getRootEditor(int n2) {
        return (RootEditor)this.rootEditors.get(n2);
    }

    public int getSelectedEditor() {
        return this.selectedRootEditor;
    }

    public void setSelectedEditor(int n2) {
        boolean bl2;
        RootEditor rootEditor;
        int n3;
        int n4 = this.selectedRootEditor;
        if (n4 == n2) {
            return;
        }
        this.selectedRootEditor = n2;
        for (n3 = 0; n3 < this.rootEditors.size(); ++n3) {
            bl2 = n3 == n2;
            rootEditor = (RootEditor)this.rootEditors.get(n3);
            if (!rootEditor.isActive() || bl2) continue;
            rootEditor.setActive(false);
        }
        if (this.currentToolbar != null) {
            this.closeToolbar();
            this.toolbarContainer.removeAll();
            this.currentToolbar = null;
        }
        n3 = 0;
        while (n3 < this.rootEditors.size()) {
            bl2 = n3 == n2;
            rootEditor = (RootEditor)this.rootEditors.get(n3);
            if (!rootEditor.isActive() && bl2) {
                rootEditor.setActive(true);
                this.setJMenuBar(this.createEditorMenubar(rootEditor));
                this.currentToolbar = rootEditor.getToolbar();
                if (this.currentToolbar != null) {
                    this.toolbarContainer.add((Component)this.currentToolbar, "Center");
                    this.toolbarContainer.setVisible(true);
                    this.currentToolbar.setVisible(true);
                } else {
                    this.toolbarContainer.setVisible(false);
                }
                this.getJMenuBar().repaint();
            }
            ++n3;
        }
    }

    private void closeToolbar() {
        Window window;
        if (this.currentToolbar == null) return;
        if (this.currentToolbar.getParent() != this.toolbarContainer && (window = SwingUtilities.windowForComponent(this.currentToolbar)) != null) {
            window.setVisible(false);
            window.dispose();
        }
        this.currentToolbar.setVisible(false);
    }

    protected abstract void attempExit();

    protected void updateRootEditorEnabled(RootEditor rootEditor) {
        boolean bl2 = rootEditor.isEnabled();
        int n2 = 0;
        while (n2 < this.tabbedPane.getTabCount()) {
            Component component = this.tabbedPane.getComponentAt(n2);
            if (component == rootEditor.getMainPanel()) {
                this.tabbedPane.setEnabledAt(n2, bl2);
                return;
            }
            ++n2;
        }
    }
}

