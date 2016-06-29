package org.jfree.ui.tabbedui;

import java.util.*;
import javax.swing.event.*;
import java.beans.*;
import javax.swing.*;
import java.awt.*;

public abstract class AbstractTabbedUI extends JComponent
{
    public static final String JMENUBAR_PROPERTY = "jMenuBar";
    public static final String GLOBAL_MENU_PROPERTY = "globalMenu";
    private ArrayList rootEditors;
    private JTabbedPane tabbedPane;
    private int selectedRootEditor;
    private JComponent currentToolbar;
    private JPanel toolbarContainer;
    private Action closeAction;
    private JMenuBar jMenuBar;
    private boolean globalMenu;
    
    public AbstractTabbedUI() {
        this.selectedRootEditor = -1;
        (this.toolbarContainer = new JPanel()).setLayout(new BorderLayout());
        (this.tabbedPane = new JTabbedPane(3)).addChangeListener(new AbstractTabbedUI$TabChangeHandler(this, this.tabbedPane));
        this.rootEditors = new ArrayList();
        this.setLayout(new BorderLayout());
        this.add(this.toolbarContainer, "North");
        this.add(this.tabbedPane, "Center");
        this.closeAction = this.createCloseAction();
    }
    
    protected JTabbedPane getTabbedPane() {
        return this.tabbedPane;
    }
    
    public boolean isGlobalMenu() {
        return this.globalMenu;
    }
    
    public void setGlobalMenu(final boolean globalMenu) {
        this.globalMenu = globalMenu;
        if (this.isGlobalMenu()) {
            this.setJMenuBar(this.updateGlobalMenubar());
        }
        else if (this.getRootEditorCount() > 0) {
            this.setJMenuBar(this.createEditorMenubar(this.getRootEditor(this.getSelectedEditor())));
        }
    }
    
    public JMenuBar getJMenuBar() {
        return this.jMenuBar;
    }
    
    protected void setJMenuBar(final JMenuBar jMenuBar) {
        this.firePropertyChange("jMenuBar", this.jMenuBar, this.jMenuBar = jMenuBar);
    }
    
    protected Action createCloseAction() {
        return new AbstractTabbedUI$ExitAction(this);
    }
    
    public Action getCloseAction() {
        return this.closeAction;
    }
    
    protected abstract JMenu[] getPrefixMenus();
    
    protected abstract JMenu[] getPostfixMenus();
    
    private void addMenus(final JMenuBar menuBar, final JMenu[] array) {
        for (int i = 0; i < array.length; ++i) {
            menuBar.add(array[i]);
        }
    }
    
    private JMenuBar updateGlobalMenubar() {
        JMenuBar jMenuBar = this.getJMenuBar();
        if (jMenuBar == null) {
            jMenuBar = new JMenuBar();
        }
        else {
            jMenuBar.removeAll();
        }
        this.addMenus(jMenuBar, this.getPrefixMenus());
        for (int i = 0; i < this.rootEditors.size(); ++i) {
            this.addMenus(jMenuBar, ((RootEditor)this.rootEditors.get(i)).getMenus());
        }
        this.addMenus(jMenuBar, this.getPostfixMenus());
        return jMenuBar;
    }
    
    private JMenuBar createEditorMenubar(final RootEditor rootEditor) {
        JMenuBar jMenuBar = this.getJMenuBar();
        if (jMenuBar == null) {
            jMenuBar = new JMenuBar();
        }
        else {
            jMenuBar.removeAll();
        }
        this.addMenus(jMenuBar, this.getPrefixMenus());
        if (this.isGlobalMenu()) {
            for (int i = 0; i < this.rootEditors.size(); ++i) {
                this.addMenus(jMenuBar, ((RootEditor)this.rootEditors.get(i)).getMenus());
            }
        }
        else {
            this.addMenus(jMenuBar, rootEditor.getMenus());
        }
        this.addMenus(jMenuBar, this.getPostfixMenus());
        return jMenuBar;
    }
    
    public void addRootEditor(final RootEditor rootEditor) {
        this.rootEditors.add(rootEditor);
        this.tabbedPane.add(rootEditor.getEditorName(), rootEditor.getMainPanel());
        rootEditor.addPropertyChangeListener("enabled", new AbstractTabbedUI$TabEnableChangeListener(this));
        this.updateRootEditorEnabled(rootEditor);
        if (this.getRootEditorCount() == 1) {
            this.setSelectedEditor(0);
        }
        else if (this.isGlobalMenu()) {
            this.setJMenuBar(this.updateGlobalMenubar());
        }
    }
    
    public int getRootEditorCount() {
        return this.rootEditors.size();
    }
    
    public RootEditor getRootEditor(final int n) {
        return this.rootEditors.get(n);
    }
    
    public int getSelectedEditor() {
        return this.selectedRootEditor;
    }
    
    public void setSelectedEditor(final int selectedRootEditor) {
        if (this.selectedRootEditor == selectedRootEditor) {
            return;
        }
        this.selectedRootEditor = selectedRootEditor;
        for (int i = 0; i < this.rootEditors.size(); ++i) {
            final boolean b = i == selectedRootEditor;
            final RootEditor rootEditor = this.rootEditors.get(i);
            if (rootEditor.isActive() && !b) {
                rootEditor.setActive(false);
            }
        }
        if (this.currentToolbar != null) {
            this.closeToolbar();
            this.toolbarContainer.removeAll();
            this.currentToolbar = null;
        }
        for (int j = 0; j < this.rootEditors.size(); ++j) {
            final boolean b2 = j == selectedRootEditor;
            final RootEditor rootEditor2 = this.rootEditors.get(j);
            if (!rootEditor2.isActive() && b2) {
                rootEditor2.setActive(true);
                this.setJMenuBar(this.createEditorMenubar(rootEditor2));
                this.currentToolbar = rootEditor2.getToolbar();
                if (this.currentToolbar != null) {
                    this.toolbarContainer.add(this.currentToolbar, "Center");
                    this.toolbarContainer.setVisible(true);
                    this.currentToolbar.setVisible(true);
                }
                else {
                    this.toolbarContainer.setVisible(false);
                }
                this.getJMenuBar().repaint();
            }
        }
    }
    
    private void closeToolbar() {
        if (this.currentToolbar != null) {
            if (this.currentToolbar.getParent() != this.toolbarContainer) {
                final Window windowForComponent = SwingUtilities.windowForComponent(this.currentToolbar);
                if (windowForComponent != null) {
                    windowForComponent.setVisible(false);
                    windowForComponent.dispose();
                }
            }
            this.currentToolbar.setVisible(false);
        }
    }
    
    protected abstract void attempExit();
    
    protected void updateRootEditorEnabled(final RootEditor rootEditor) {
        final boolean enabled = rootEditor.isEnabled();
        for (int i = 0; i < this.tabbedPane.getTabCount(); ++i) {
            if (this.tabbedPane.getComponentAt(i) == rootEditor.getMainPanel()) {
                this.tabbedPane.setEnabledAt(i, enabled);
                return;
            }
        }
    }
}
