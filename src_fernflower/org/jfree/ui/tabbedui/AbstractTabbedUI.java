package org.jfree.ui.tabbedui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import org.jfree.ui.tabbedui.AbstractTabbedUI$ExitAction;
import org.jfree.ui.tabbedui.AbstractTabbedUI$TabChangeHandler;
import org.jfree.ui.tabbedui.AbstractTabbedUI$TabEnableChangeListener;
import org.jfree.ui.tabbedui.RootEditor;

public abstract class AbstractTabbedUI extends JComponent {
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

   public void setGlobalMenu(boolean var1) {
      this.globalMenu = var1;
      if(this.isGlobalMenu()) {
         this.setJMenuBar(this.updateGlobalMenubar());
      } else if(this.getRootEditorCount() > 0) {
         this.setJMenuBar(this.createEditorMenubar(this.getRootEditor(this.getSelectedEditor())));
      }

   }

   public JMenuBar getJMenuBar() {
      return this.jMenuBar;
   }

   protected void setJMenuBar(JMenuBar var1) {
      JMenuBar var2 = this.jMenuBar;
      this.jMenuBar = var1;
      this.firePropertyChange("jMenuBar", var2, var1);
   }

   protected Action createCloseAction() {
      return new AbstractTabbedUI$ExitAction(this);
   }

   public Action getCloseAction() {
      return this.closeAction;
   }

   protected abstract JMenu[] getPrefixMenus();

   protected abstract JMenu[] getPostfixMenus();

   private void addMenus(JMenuBar var1, JMenu[] var2) {
      for(int var3 = 0; var3 < var2.length; ++var3) {
         var1.add(var2[var3]);
      }

   }

   private JMenuBar updateGlobalMenubar() {
      JMenuBar var1 = this.getJMenuBar();
      if(var1 == null) {
         var1 = new JMenuBar();
      } else {
         var1.removeAll();
      }

      this.addMenus(var1, this.getPrefixMenus());

      for(int var2 = 0; var2 < this.rootEditors.size(); ++var2) {
         RootEditor var3 = (RootEditor)this.rootEditors.get(var2);
         this.addMenus(var1, var3.getMenus());
      }

      this.addMenus(var1, this.getPostfixMenus());
      return var1;
   }

   private JMenuBar createEditorMenubar(RootEditor var1) {
      JMenuBar var2 = this.getJMenuBar();
      if(var2 == null) {
         var2 = new JMenuBar();
      } else {
         var2.removeAll();
      }

      this.addMenus(var2, this.getPrefixMenus());
      if(this.isGlobalMenu()) {
         for(int var3 = 0; var3 < this.rootEditors.size(); ++var3) {
            RootEditor var4 = (RootEditor)this.rootEditors.get(var3);
            this.addMenus(var2, var4.getMenus());
         }
      } else {
         this.addMenus(var2, var1.getMenus());
      }

      this.addMenus(var2, this.getPostfixMenus());
      return var2;
   }

   public void addRootEditor(RootEditor var1) {
      this.rootEditors.add(var1);
      this.tabbedPane.add(var1.getEditorName(), var1.getMainPanel());
      var1.addPropertyChangeListener("enabled", new AbstractTabbedUI$TabEnableChangeListener(this));
      this.updateRootEditorEnabled(var1);
      if(this.getRootEditorCount() == 1) {
         this.setSelectedEditor(0);
      } else if(this.isGlobalMenu()) {
         this.setJMenuBar(this.updateGlobalMenubar());
      }

   }

   public int getRootEditorCount() {
      return this.rootEditors.size();
   }

   public RootEditor getRootEditor(int var1) {
      return (RootEditor)this.rootEditors.get(var1);
   }

   public int getSelectedEditor() {
      return this.selectedRootEditor;
   }

   public void setSelectedEditor(int var1) {
      int var2 = this.selectedRootEditor;
      if(var2 != var1) {
         this.selectedRootEditor = var1;

         int var3;
         boolean var4;
         RootEditor var5;
         for(var3 = 0; var3 < this.rootEditors.size(); ++var3) {
            var4 = var3 == var1;
            var5 = (RootEditor)this.rootEditors.get(var3);
            if(var5.isActive() && !var4) {
               var5.setActive(false);
            }
         }

         if(this.currentToolbar != null) {
            this.closeToolbar();
            this.toolbarContainer.removeAll();
            this.currentToolbar = null;
         }

         for(var3 = 0; var3 < this.rootEditors.size(); ++var3) {
            var4 = var3 == var1;
            var5 = (RootEditor)this.rootEditors.get(var3);
            if(!var5.isActive() && var4) {
               var5.setActive(true);
               this.setJMenuBar(this.createEditorMenubar(var5));
               this.currentToolbar = var5.getToolbar();
               if(this.currentToolbar != null) {
                  this.toolbarContainer.add(this.currentToolbar, "Center");
                  this.toolbarContainer.setVisible(true);
                  this.currentToolbar.setVisible(true);
               } else {
                  this.toolbarContainer.setVisible(false);
               }

               this.getJMenuBar().repaint();
            }
         }

      }
   }

   private void closeToolbar() {
      if(this.currentToolbar != null) {
         if(this.currentToolbar.getParent() != this.toolbarContainer) {
            Window var1 = SwingUtilities.windowForComponent(this.currentToolbar);
            if(var1 != null) {
               var1.setVisible(false);
               var1.dispose();
            }
         }

         this.currentToolbar.setVisible(false);
      }

   }

   protected abstract void attempExit();

   protected void updateRootEditorEnabled(RootEditor var1) {
      boolean var2 = var1.isEnabled();

      for(int var3 = 0; var3 < this.tabbedPane.getTabCount(); ++var3) {
         Component var4 = this.tabbedPane.getComponentAt(var3);
         if(var4 == var1.getMainPanel()) {
            this.tabbedPane.setEnabledAt(var3, var2);
            return;
         }
      }

   }
}
