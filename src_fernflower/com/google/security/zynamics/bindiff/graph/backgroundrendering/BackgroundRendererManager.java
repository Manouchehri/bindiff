package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.BackgroundRendererManager$1;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.BackgroundRendererManager$InternalGraphSettingsChangedListener;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.GradientBackgroundRenderer;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.ImageBackgroundRenderer;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.project.userview.CallGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.Color;
import y.h.ch;

public class BackgroundRendererManager {
   private final Color COMBINED_GRADIENT_END_COLOR = new Color(200, 210, 190);
   private final GraphSettings settings;
   private final BackgroundRendererManager$InternalGraphSettingsChangedListener settingsChangedListener = new BackgroundRendererManager$InternalGraphSettingsChangedListener(this, (BackgroundRendererManager$1)null);
   private final ch view;
   private final ImageBackgroundRenderer imageBackgroundRenderer;
   private final GradientBackgroundRenderer gradientBackgroundRenderer;

   public BackgroundRendererManager(ViewData var1, ch var2, EGraph var3, GraphSettings var4) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var3);
      this.settings = (GraphSettings)Preconditions.checkNotNull(var4);
      this.view = var2;
      this.imageBackgroundRenderer = new ImageBackgroundRenderer(var1, this.view, var3);
      this.gradientBackgroundRenderer = new GradientBackgroundRenderer(var1, this.view, this.getGradientEndColor(var3), var3);
      this.settingsChangedListener.gradientBackgroundChanged(var4.getDisplaySettings());
      var4.addListener(this.settingsChangedListener);
   }

   protected static String buildTitle(ViewData var0, EGraph var1) {
      if(var0 instanceof FlowGraphViewData) {
         FlowGraphViewData var2 = (FlowGraphViewData)var0;
         String var10000;
         String var3;
         String var4;
         switch(BackgroundRendererManager$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[var1.ordinal()]) {
         case 1:
            if(var2.getAddress(ESide.PRIMARY) == null) {
               var10000 = "";
            } else {
               var3 = String.valueOf(var2.getAddress(ESide.PRIMARY));
               var4 = var2.getFunctionName(ESide.PRIMARY);
               var10000 = (new StringBuilder(3 + String.valueOf(var3).length() + String.valueOf(var4).length())).append(var3).append("   ").append(var4).toString();
            }

            return var10000;
         case 2:
            if(var2.getAddress(ESide.SECONDARY) == null) {
               var10000 = "";
            } else {
               var3 = var2.getFunctionName(ESide.SECONDARY);
               var4 = String.valueOf(var2.getAddress(ESide.SECONDARY));
               var10000 = (new StringBuilder(3 + String.valueOf(var3).length() + String.valueOf(var4).length())).append(var3).append("   ").append(var4).toString();
            }

            return var10000;
         case 3:
            Object[] var10001 = new Object[5];
            String var10004;
            if(var2.getAddress(ESide.PRIMARY) == null) {
               var10004 = "";
            } else {
               var3 = String.valueOf(var2.getAddress(ESide.PRIMARY));
               var10004 = (new StringBuilder(3 + String.valueOf(var3).length())).append(var3).append("   ").toString();
            }

            var10001[0] = var10004;
            var10001[1] = var2.getFunctionName(ESide.PRIMARY) == null?"":var2.getFunctionName(ESide.PRIMARY);
            var10001[2] = var2.getAddress(ESide.PRIMARY) != null && var2.getAddress(ESide.SECONDARY) != null?"   vs   ":"";
            if(var2.getAddress(ESide.SECONDARY) == null) {
               var10004 = "";
            } else {
               var3 = String.valueOf(var2.getAddress(ESide.SECONDARY));
               var10004 = (new StringBuilder(3 + String.valueOf(var3).length())).append(var3).append("   ").toString();
            }

            var10001[3] = var10004;
            var10001[4] = var2.getFunctionName(ESide.SECONDARY) == null?"":var2.getFunctionName(ESide.SECONDARY);
            return String.format("%s%s%s%s%s", var10001);
         }
      } else if(var0 instanceof CallGraphViewData) {
         CallGraphViewData var5 = (CallGraphViewData)var0;
         switch(BackgroundRendererManager$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[var1.ordinal()]) {
         case 1:
            return var5.getImageName(ESide.PRIMARY);
         case 2:
            return var5.getImageName(ESide.SECONDARY);
         case 3:
            return String.format("%s vs %s", new Object[]{var5.getImageName(ESide.PRIMARY), var5.getImageName(ESide.SECONDARY)});
         }
      }

      return "";
   }

   private Color getGradientEndColor(EGraph var1) {
      switch(BackgroundRendererManager$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[var1.ordinal()]) {
      case 1:
         return Colors.PRIMARY_BASE;
      case 2:
         return Colors.SECONDARY_BASE;
      default:
         return this.COMBINED_GRADIENT_END_COLOR;
      }
   }

   public void addListeners() {
      this.settings.addListener(this.settingsChangedListener);
   }

   public void removeListener() {
      this.settings.removeListener(this.settingsChangedListener);
   }

   // $FF: synthetic method
   static GradientBackgroundRenderer access$100(BackgroundRendererManager var0) {
      return var0.gradientBackgroundRenderer;
   }

   // $FF: synthetic method
   static ImageBackgroundRenderer access$200(BackgroundRendererManager var0) {
      return var0.imageBackgroundRenderer;
   }

   // $FF: synthetic method
   static ch access$300(BackgroundRendererManager var0) {
      return var0.view;
   }
}
