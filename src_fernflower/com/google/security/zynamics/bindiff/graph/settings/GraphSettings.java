package com.google.security.zynamics.bindiff.graph.settings;

import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.EGraphSynchronization;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.settings.GraphDisplaySettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphMouseSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.IGraphSettingsChangedListener;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import java.util.Iterator;

public class GraphSettings extends AbstractZyGraphSettings {
   public static final int MAX_SELECTION_UNDO_CACHE = 30;
   private final ListenerProvider settingsListeners = new ListenerProvider();
   private final GraphLayoutSettings layoutSettings;
   private final GraphProximityBrowsingSettings proximitySettings;
   private final GraphDisplaySettings displaySettings;
   private final GraphMouseSettings mouseSettings;
   private boolean drawBends;
   private boolean showScrollbars;
   private ESide focusSide;
   private EDiffViewMode diffViewMode;
   private EGraphSynchronization graphSync;

   public GraphSettings(GraphViewSettingsConfigItem var1) {
      this.layoutSettings = new GraphLayoutSettings(var1);
      this.proximitySettings = new GraphProximityBrowsingSettings(var1);
      this.displaySettings = new GraphDisplaySettings(var1);
      this.mouseSettings = new GraphMouseSettings(var1);
      this.drawBends = var1.getDrawBends();
      this.showScrollbars = var1.getShowScrollbars();
      this.graphSync = var1.getViewSynchronization()?EGraphSynchronization.SYNC:EGraphSynchronization.ASYNC;
      this.focusSide = ESide.PRIMARY;
      this.diffViewMode = EDiffViewMode.NORMAL_VIEW;
   }

   public void addListener(IGraphSettingsChangedListener var1) {
      this.settingsListeners.addListener(var1);
      this.layoutSettings.addListener(var1);
      this.proximitySettings.addListener(var1);
      this.displaySettings.addListener(var1);
      this.mouseSettings.addListener(var1);
   }

   public EDiffViewMode getDiffViewMode() {
      return this.diffViewMode;
   }

   public GraphDisplaySettings getDisplaySettings() {
      return this.displaySettings;
   }

   public boolean getDrawBends() {
      return this.drawBends;
   }

   public ESide getFocus() {
      return this.focusSide;
   }

   public EGraphSynchronization getGraphSyncMode() {
      return this.graphSync;
   }

   public GraphLayoutSettings getLayoutSettings() {
      return this.layoutSettings;
   }

   public GraphMouseSettings getMouseSettings() {
      return this.mouseSettings;
   }

   public GraphProximityBrowsingSettings getProximitySettings() {
      return this.proximitySettings;
   }

   public boolean getShowScrollbars() {
      return this.showScrollbars;
   }

   public boolean isAsync() {
      return EGraphSynchronization.ASYNC == this.getGraphSyncMode();
   }

   public boolean isSync() {
      return EGraphSynchronization.SYNC == this.getGraphSyncMode();
   }

   public void removeListener(IGraphSettingsChangedListener var1) {
      try {
         this.layoutSettings.removeListener(var1);
         this.proximitySettings.removeListener(var1);
         this.displaySettings.removeListener(var1);
         this.mouseSettings.removeListener(var1);
      } catch (Exception var3) {
         Logger.logWarning("Listener was not listening.", new Object[0]);
      }

   }

   public void setDiffViewMode(EDiffViewMode var1) {
      this.diffViewMode = var1;
      Iterator var2 = this.settingsListeners.iterator();

      while(var2.hasNext()) {
         IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
         var3.diffViewModeChanged(this);
      }

   }

   public void setDrawBends(boolean var1) {
      if(this.drawBends != var1) {
         this.drawBends = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.drawBendsChanged(this);
         }

      }
   }

   public void setFocusSide(ESide var1) {
      if(this.focusSide != var1) {
         this.focusSide = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.focusSideChanged(this);
         }

      }
   }

   public void setGraphSyncMode(EGraphSynchronization var1) {
      if(this.graphSync != var1) {
         this.graphSync = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.graphSyncChanged(this);
         }

      }
   }

   public void setShowScrollbars(boolean var1) {
      if(this.showScrollbars != var1) {
         this.showScrollbars = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.showScrollbarsChanged(this);
         }

      }
   }
}
