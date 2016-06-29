package com.google.security.zynamics.bindiff.graph.settings;

import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.graph.settings.IGraphSettingsChangedListener;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IDisplaySettings;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IDisplaySettingsListener;
import java.util.Iterator;

public class GraphDisplaySettings implements IDisplaySettings {
   private boolean gradientBackground;
   private int animationSpeed;
   private final ListenerProvider zySettingsListeners = new ListenerProvider();
   private final ListenerProvider settingsListeners = new ListenerProvider();

   public GraphDisplaySettings(GraphViewSettingsConfigItem var1) {
      this.animationSpeed = var1.getAnimationSpeed();
      this.gradientBackground = var1.getGradientBackground();
   }

   protected void addListener(IGraphSettingsChangedListener var1) {
      try {
         this.settingsListeners.addListener(var1);
      } catch (RuntimeException var3) {
         Logger.logWarning("Listener is already listening.", new Object[0]);
      }

   }

   protected void removeListener(IGraphSettingsChangedListener var1) {
      try {
         this.settingsListeners.removeListener(var1);
      } catch (RuntimeException var3) {
         Logger.logWarning("Listener was not listening.", new Object[0]);
      }

   }

   public void addListener(IDisplaySettingsListener var1) {
      this.zySettingsListeners.addListener(var1);
   }

   public int getAnimationSpeed() {
      return this.animationSpeed;
   }

   public boolean getGradientBackground() {
      return this.gradientBackground;
   }

   public boolean getMagnifyingGlassMode() {
      return false;
   }

   public void removeListener(IDisplaySettingsListener var1) {
      this.zySettingsListeners.removeListener(var1);
   }

   public void setAnimationSpeed(int var1) {
      if(this.animationSpeed != var1) {
         this.animationSpeed = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.animationSpeedChanged(this);
         }

      }
   }

   public void setGradientBackground(boolean var1) {
      if(this.gradientBackground != var1) {
         this.gradientBackground = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.gradientBackgroundChanged(this);
         }

      }
   }

   public void setMagnifyingGlassMode(boolean var1) {
   }
}
