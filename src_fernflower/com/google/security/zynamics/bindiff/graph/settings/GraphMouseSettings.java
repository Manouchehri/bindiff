package com.google.security.zynamics.bindiff.graph.settings;

import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.enums.EMouseAction;
import com.google.security.zynamics.bindiff.graph.settings.IGraphSettingsChangedListener;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.MouseWheelAction;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IMouseSettings;
import java.util.Iterator;

public class GraphMouseSettings implements IMouseSettings {
   private EMouseAction mouseWheelAction;
   private int scrollSensitivity;
   private int zoomSensitivity;
   private final ListenerProvider settingsListeners = new ListenerProvider();

   public GraphMouseSettings(GraphViewSettingsConfigItem var1) {
      this.mouseWheelAction = EMouseAction.getEnum(var1.getMouseWheelAction());
      this.scrollSensitivity = var1.getScrollSensitivity();
      this.zoomSensitivity = var1.getZoomSensitivity();
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

   public MouseWheelAction getMouseWheelAction() {
      return this.mouseWheelAction == EMouseAction.ZOOM?MouseWheelAction.ZOOM:MouseWheelAction.SCROLL;
   }

   public int getScrollSensitivity() {
      return this.scrollSensitivity;
   }

   public int getZoomSensitivity() {
      return this.zoomSensitivity;
   }

   public void setMousewheelAction(EMouseAction var1) {
      if(this.mouseWheelAction != var1) {
         this.mouseWheelAction = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.mouseWheelActionChanged(this);
         }

      }
   }

   public void setScrollSensitivity(int var1) {
      if(var1 != this.scrollSensitivity) {
         this.scrollSensitivity = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.scrollSensitivityChanged(this);
         }

      }
   }

   public void setZoomSensitivity(int var1) {
      if(var1 != this.zoomSensitivity) {
         this.zoomSensitivity = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.zoomSensitivityChanged(this);
         }

      }
   }
}
