package com.google.security.zynamics.bindiff.graph.settings;

import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.graph.settings.IGraphSettingsChangedListener;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IProximitySettings;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IProximitySettingsListener;
import java.util.Iterator;

public class GraphProximityBrowsingSettings implements IProximitySettings {
   private boolean proximityBrowsing;
   private boolean proximityBrowsingFrozen;
   private int proximityBrowsingChildDepth;
   private int proximityBrowsingParentDepth;
   private int autoProximityBrowsingActivationThreshold;
   private final ListenerProvider zySettingsListeners = new ListenerProvider();
   private final ListenerProvider settingsListeners = new ListenerProvider();

   public GraphProximityBrowsingSettings(GraphViewSettingsConfigItem var1) {
      this.proximityBrowsing = var1.getProximityBrowsing();
      this.proximityBrowsingFrozen = false;
      this.proximityBrowsingChildDepth = var1.getProximityBrowsingChildDepth();
      this.proximityBrowsingParentDepth = var1.getProximityBrowsingParentDepth();
      this.autoProximityBrowsingActivationThreshold = var1.getAutoProximityBrowsingActivationThreshold();
   }

   protected void addListener(IGraphSettingsChangedListener var1) {
      try {
         this.settingsListeners.addListener(var1);
      } catch (Exception var3) {
         Logger.logWarning("Listener is already listening.", new Object[0]);
      }

   }

   protected void removeListener(IGraphSettingsChangedListener var1) {
      try {
         this.settingsListeners.removeListener(var1);
      } catch (Exception var3) {
         Logger.logWarning("Listener was not listening.", new Object[0]);
      }

   }

   public void addListener(IProximitySettingsListener var1) {
      this.zySettingsListeners.addListener(var1);
   }

   public int getAutoProximityBrowsingActivationThreshold() {
      return this.autoProximityBrowsingActivationThreshold;
   }

   public boolean getProximityBrowsing() {
      return this.proximityBrowsing;
   }

   public int getProximityBrowsingChildren() {
      return this.proximityBrowsingChildDepth;
   }

   public boolean getProximityBrowsingFrozen() {
      return this.proximityBrowsingFrozen;
   }

   public int getProximityBrowsingParents() {
      return this.proximityBrowsingParentDepth;
   }

   public void removeListener(IProximitySettingsListener var1) {
      this.zySettingsListeners.removeListener(var1);
   }

   public void setAutoProximityBrowsingActivationThreshold(int var1) {
      if(var1 != this.autoProximityBrowsingActivationThreshold) {
         this.autoProximityBrowsingActivationThreshold = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.autoProximityBrowsingActivationThresholdChanged(this);
         }

      }
   }

   public void setProximityBrowsing(boolean var1) {
      if(this.proximityBrowsing != var1) {
         this.proximityBrowsing = var1;
         Iterator var2 = this.zySettingsListeners.iterator();

         while(var2.hasNext()) {
            IProximitySettingsListener var3 = (IProximitySettingsListener)var2.next();
            var3.changedProximityBrowsing(var1);
         }

         var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var4 = (IGraphSettingsChangedListener)var2.next();
            var4.proximityBrowsingChanged(this);
         }

      }
   }

   public void setProximityBrowsingChildren(int var1) {
      if(var1 != this.proximityBrowsingChildDepth) {
         this.proximityBrowsingChildDepth = var1;
         Iterator var2 = this.zySettingsListeners.iterator();

         while(var2.hasNext()) {
            IProximitySettingsListener var3 = (IProximitySettingsListener)var2.next();
            var3.changedProximityBrowsingDepth(var1, this.getProximityBrowsingParents());
         }

         var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var4 = (IGraphSettingsChangedListener)var2.next();
            var4.proximityBrowsingChildDepthChanged(this);
         }

      }
   }

   public void setProximityBrowsingFrozen(boolean var1) {
      if(this.proximityBrowsingFrozen != var1) {
         this.proximityBrowsingFrozen = var1;
         Iterator var2 = this.zySettingsListeners.iterator();

         while(var2.hasNext()) {
            IProximitySettingsListener var3 = (IProximitySettingsListener)var2.next();
            var3.changedProximityBrowsingFrozen(this.getProximityBrowsingFrozen());
         }

         var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var4 = (IGraphSettingsChangedListener)var2.next();
            var4.proximityBrowsingFrozenChanged(this);
         }

      }
   }

   public void setProximityBrowsingParents(int var1) {
      if(var1 != this.proximityBrowsingParentDepth) {
         this.proximityBrowsingParentDepth = var1;
         Iterator var2 = this.zySettingsListeners.iterator();

         while(var2.hasNext()) {
            IProximitySettingsListener var3 = (IProximitySettingsListener)var2.next();
            var3.changedProximityBrowsingDepth(this.getProximityBrowsingChildren(), var1);
         }

         var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var4 = (IGraphSettingsChangedListener)var2.next();
            var4.proximityBrowsingParentDepthChanged(this);
         }

      }
   }
}
