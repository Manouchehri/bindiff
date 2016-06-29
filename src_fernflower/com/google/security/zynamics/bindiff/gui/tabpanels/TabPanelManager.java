package com.google.security.zynamics.bindiff.gui.tabpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
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
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.Color;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public final class TabPanelManager implements Iterable {
   private static Color WORKSPACE_TAB_COLOR;
   private static Color SINGLE_FUNCTION_DIFF_VIEWS_TAB_COLOR;
   private static final TabPanelManager$ColorSlot[] colorSlots;
   private final TabPanelManager$InternalCloseTabButtonListener closeTabListener = new TabPanelManager$InternalCloseTabButtonListener(this, (TabPanelManager$1)null);
   private final TabPanelManager$InternalTabListener tablistener = new TabPanelManager$InternalTabListener(this, (TabPanelManager$1)null);
   private final MainWindow window;
   private final JTabbedPane tabbedPane = new JTabbedPane();
   private final List tabPanels = new ArrayList();
   private final Workspace workspace;

   public TabPanelManager(MainWindow var1, Workspace var2) {
      this.window = (MainWindow)Preconditions.checkNotNull(var1);
      this.workspace = (Workspace)Preconditions.checkNotNull(var2);
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

   private Color getTabColor(TabPanel var1) {
      if(var1 instanceof FunctionDiffViewTabPanel) {
         return SINGLE_FUNCTION_DIFF_VIEWS_TAB_COLOR;
      } else {
         if(var1 instanceof ViewTabPanel) {
            Diff var2 = ((ViewTabPanel)var1).getDiff();
            TabPanelManager$ColorSlot[] var3 = colorSlots;
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               TabPanelManager$ColorSlot var6 = var3[var5];
               if(var6.diff == var2) {
                  return var6.color;
               }
            }
         }

         return Colors.GRAY240;
      }
   }

   private void registerTabColor(TabPanel var1) {
      if(var1 instanceof ViewTabPanel) {
         Diff var2 = ((ViewTabPanel)var1).getDiff();
         if(var2.isFunctionDiff()) {
            return;
         }

         TabPanelManager$ColorSlot[] var3 = colorSlots;
         int var4 = var3.length;

         int var5;
         TabPanelManager$ColorSlot var6;
         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            if(var6.diff == var2) {
               return;
            }
         }

         var3 = colorSlots;
         var4 = var3.length;

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var3[var5];
            if(var6.diff == null) {
               TabPanelManager$InternalDiffListener var7 = new TabPanelManager$InternalDiffListener(this, (TabPanelManager$1)null);
               var2.addListener(var7);
               var6.diff = var2;
               var6.diffListener = var7;
               return;
            }
         }
      }

   }

   private void unregisterTabColor(Diff var1) {
      Iterator var2 = this.window.getController().getTabPanelManager().getViewTabPanels().iterator();

      ViewTabPanel var3;
      do {
         if(!var2.hasNext()) {
            TabPanelManager$ColorSlot[] var6 = colorSlots;
            int var7 = var6.length;

            for(int var4 = 0; var4 < var7; ++var4) {
               TabPanelManager$ColorSlot var5 = var6[var4];
               if(var5.diff == var1) {
                  var5.diff.removeListener(var5.diffListener);
                  var5.diff = null;
                  var5.diffListener = null;
               }
            }

            return;
         }

         var3 = (ViewTabPanel)var2.next();
      } while(var3.getDiff() != var1);

   }

   public void addTab(TabPanel var1) {
      this.tabbedPane.addTab(var1.getTitle().toString(), var1);
      int var2 = this.tabbedPane.getTabCount() - 1;
      Color var4 = Color.WHITE;
      TabButtonComponent var3;
      if(var1 instanceof WorkspaceTabPanel) {
         var3 = new TabButtonComponent(this.tabbedPane, var1, var1.getIcon(), false);
         var4 = WORKSPACE_TAB_COLOR;
      } else {
         this.registerTabColor(var1);
         var4 = this.getTabColor(var1);
         var3 = new TabButtonComponent(this.tabbedPane, var1, var1.getIcon(), true);
         var3.addListener(this.closeTabListener);
      }

      this.tabbedPane.setTabComponentAt(var2, var3);
      this.tabbedPane.setBackgroundAt(var2, var4);
      this.tabPanels.add(var1);
   }

   public JTabbedPane getTabbedPane() {
      return this.tabbedPane;
   }

   public ViewTabPanel getTabPanel(IAddress var1, IAddress var2, Diff var3) {
      Iterator var4 = this.tabPanels.iterator();

      TabPanel var5;
      boolean var9;
      boolean var10;
      do {
         ViewData var6;
         IAddress var7;
         IAddress var8;
         do {
            do {
               do {
                  if(!var4.hasNext()) {
                     return null;
                  }

                  var5 = (TabPanel)var4.next();
               } while(!(var5 instanceof ViewTabPanel));

               var6 = ((ViewTabPanel)var5).getView();
            } while(var6.getGraphs().getDiff() != var3);

            var7 = var6.getAddress(ESide.PRIMARY);
            var8 = var6.getAddress(ESide.SECONDARY);
            if(var6.isCallgraphView() && var7 == null && var8 == null && var1 == null && var2 == null) {
               return (ViewTabPanel)var5;
            }
         } while(!var6.isFlowgraphView());

         var9 = var7 == null && var1 == null;
         if(var7 != null && var1 != null) {
            var9 = var7.equals(var1);
         }

         var10 = var8 == null && var2 == null;
         if(var8 != null && var2 != null) {
            var10 = var8.equals(var2);
         }
      } while(!var9 || !var10);

      return (ViewTabPanel)var5;
   }

   public List getViewTabPanels() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.tabPanels.iterator();

      while(var2.hasNext()) {
         TabPanel var3 = (TabPanel)var2.next();
         if(var3 instanceof ViewTabPanel) {
            var1.add((ViewTabPanel)var3);
         }
      }

      return var1;
   }

   public List getViewTabPanels(boolean var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.tabPanels.iterator();

      while(var3.hasNext()) {
         TabPanel var4 = (TabPanel)var3.next();
         if(var4 instanceof ViewTabPanel && ((ViewTabPanel)var4).getDiff().isFunctionDiff() == var1) {
            var2.add((ViewTabPanel)var4);
         }
      }

      return var2;
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

   public void removeTab(TabPanel var1) {
      this.tabPanels.remove(var1);
      int var2 = this.tabbedPane.indexOfComponent(var1);
      this.tabbedPane.remove(var2);
   }

   public void selectTab(TabPanel var1) {
      this.tabbedPane.setSelectedComponent(var1);
   }

   public void selectTabPanel(IAddress var1, IAddress var2, Diff var3) {
      ViewTabPanel var4 = this.getTabPanel(var1, var2, var3);
      if(var4 != null) {
         this.selectTab(var4);
      }

   }

   public void udpateSelectedTabIcon() {
      int var1 = this.tabbedPane.getSelectedIndex();
      TabButtonComponent var2 = (TabButtonComponent)this.tabbedPane.getTabComponentAt(var1);
      if(var2 != null) {
         var2.setIcon(((TabPanel)this.tabPanels.get(var1)).getIcon());
         var2.updateUI();
      }

   }

   public void updateSelectedTabTitel(String var1) {
      int var2 = this.tabbedPane.getSelectedIndex();
      TabButtonComponent var3 = (TabButtonComponent)this.tabbedPane.getTabComponentAt(var2);
      if(var3 != null) {
         var3.setTitle(var1);
         var3.updateUI();
      }

   }

   // $FF: synthetic method
   static MainWindow access$300(TabPanelManager var0) {
      return var0.window;
   }

   // $FF: synthetic method
   static void access$400(TabPanelManager var0, Diff var1) {
      var0.unregisterTabColor(var1);
   }

   // $FF: synthetic method
   static JTabbedPane access$500(TabPanelManager var0) {
      return var0.tabbedPane;
   }

   // $FF: synthetic method
   static Workspace access$600(TabPanelManager var0) {
      return var0.workspace;
   }

   // $FF: synthetic method
   static List access$700(TabPanelManager var0) {
      return var0.tabPanels;
   }

   static {
      WORKSPACE_TAB_COLOR = Color.WHITE;
      SINGLE_FUNCTION_DIFF_VIEWS_TAB_COLOR = Color.WHITE;
      colorSlots = new TabPanelManager$ColorSlot[]{TabPanelManager$ColorSlot.make(Colors.DIFF_A_VIEW_TABS_COLOR), TabPanelManager$ColorSlot.make(Colors.DIFF_B_VIEW_TABS_COLOR), TabPanelManager$ColorSlot.make(Colors.DIFF_C_VIEW_TABS_COLOR), TabPanelManager$ColorSlot.make(Colors.DIFF_D_VIEW_TABS_COLOR)};
   }
}
