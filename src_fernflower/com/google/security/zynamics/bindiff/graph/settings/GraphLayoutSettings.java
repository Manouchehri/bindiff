package com.google.security.zynamics.bindiff.graph.settings;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.enums.ECircularLayoutStyle;
import com.google.security.zynamics.bindiff.enums.EGraphLayout;
import com.google.security.zynamics.bindiff.enums.ELayoutOrientation;
import com.google.security.zynamics.bindiff.enums.EOrthogonalLayoutStyle;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCreator;
import com.google.security.zynamics.bindiff.graph.settings.IGraphSettingsChangedListener;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.settings.ILayoutSettings;
import java.util.Iterator;
import y.f.c;

public class GraphLayoutSettings implements ILayoutSettings {
   private EGraphLayout defaultGraphLayout;
   private boolean autoLayouting;
   private int visibilityWarningThreshold;
   private boolean layoutAnimation;
   private ELayoutOrientation hierarchicLayoutOrientation;
   private boolean hierarchicOrthogonalEdgeRouting;
   private int hierarchicLayoutMinLayerDistance;
   private int hierarchicLayoutMinNodeDistance;
   private int orthogonalLayoutMinNodeDistance;
   private ELayoutOrientation orthogonalLayoutOrientation;
   private EOrthogonalLayoutStyle orthogonalLayoutStyle;
   private ECircularLayoutStyle circularLayoutStyle;
   private int circularLayoutMinNodeDistance;
   private c currentLayouter;
   private final ListenerProvider settingsListeners = new ListenerProvider();

   public GraphLayoutSettings(GraphViewSettingsConfigItem var1) {
      this.defaultGraphLayout = EGraphLayout.getEnum(var1.getDefaultGraphLayout());
      this.autoLayouting = var1.getAutoLayouting();
      this.visibilityWarningThreshold = var1.getVisibilityWarningThreshold();
      this.layoutAnimation = var1.getLayoutAnimation();
      this.circularLayoutStyle = ECircularLayoutStyle.getEnum(var1.getCircularLayoutStyle());
      this.circularLayoutMinNodeDistance = var1.getCircularMinimumNodeDistance();
      this.hierarchicOrthogonalEdgeRouting = var1.getHierarchicalOrthogonalEdgeRouting();
      this.hierarchicLayoutOrientation = ELayoutOrientation.getEnum(var1.getHierarchicalOrientation());
      this.hierarchicLayoutMinLayerDistance = var1.getHierarchicalMinimumNodeDistance();
      this.hierarchicLayoutMinNodeDistance = var1.getHierarchicalMinimumLayerDistance();
      this.orthogonalLayoutStyle = EOrthogonalLayoutStyle.getEnum(var1.getOrthogonalLayoutStyle());
      this.orthogonalLayoutOrientation = ELayoutOrientation.getEnum(var1.getOrthogonalOrientation());
      this.orthogonalLayoutMinNodeDistance = var1.getOrthogonalMinimumNodeDistance();
      this.updateLayouter();
   }

   private void setCurrentLayouter(c var1) {
      Preconditions.checkNotNull(var1);
      this.currentLayouter = var1;
   }

   protected void addListener(IGraphSettingsChangedListener var1) {
      try {
         this.settingsListeners.addListener(var1);
      } catch (IllegalStateException var3) {
         Logger.logWarning("Listener is already listening.", new Object[0]);
      }

   }

   protected void removeListener(IGraphSettingsChangedListener var1) {
      try {
         this.settingsListeners.removeListener(var1);
      } catch (IllegalStateException var3) {
         Logger.logWarning("Listener was not listening.", new Object[0]);
      }

   }

   public boolean getAnimateLayout() {
      return this.layoutAnimation;
   }

   public int getAnimateLayoutEdgeThreshold() {
      return 0;
   }

   public int getAnimateLayoutNodeThreshold() {
      return 0;
   }

   public boolean getAutomaticLayouting() {
      return this.autoLayouting;
   }

   public ECircularLayoutStyle getCircularLayoutStyle() {
      return this.circularLayoutStyle;
   }

   public c getCurrentLayouter() {
      return this.currentLayouter;
   }

   public EGraphLayout getDefaultGraphLayout() {
      return this.defaultGraphLayout;
   }

   public boolean getHierarchicalOrthogonalEdgeRouting() {
      return this.hierarchicOrthogonalEdgeRouting;
   }

   public ELayoutOrientation getHierarchicOrientation() {
      return this.hierarchicLayoutOrientation;
   }

   public long getMinimumCircularNodeDistance() {
      return (long)this.circularLayoutMinNodeDistance;
   }

   public long getMinimumHierarchicLayerDistance() {
      return (long)this.hierarchicLayoutMinLayerDistance;
   }

   public long getMinimumHierarchicNodeDistance() {
      return (long)this.hierarchicLayoutMinNodeDistance;
   }

   public long getMinimumOrthogonalNodeDistance() {
      return (long)this.orthogonalLayoutMinNodeDistance;
   }

   public ELayoutOrientation getOrthogonalLayoutOrientation() {
      return this.orthogonalLayoutOrientation;
   }

   public EOrthogonalLayoutStyle getOrthogonalLayoutStyle() {
      return this.orthogonalLayoutStyle;
   }

   public int getVisibilityWarningThreshold() {
      return this.visibilityWarningThreshold;
   }

   public void setAnimateLayout(boolean var1) {
      if(var1 != this.layoutAnimation) {
         this.layoutAnimation = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.layoutAnimationChanged(this);
         }

      }
   }

   public void setAutomaticLayouting(boolean var1) {
      if(this.autoLayouting != var1) {
         this.autoLayouting = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.autoLayoutChanged(this);
         }

      }
   }

   public void setCircularLayoutStyle(ECircularLayoutStyle var1) {
      if(var1 != this.circularLayoutStyle) {
         this.circularLayoutStyle = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.circularLayoutStyleChanged(this);
         }

      }
   }

   public void setDefaultGraphLayout(EGraphLayout var1) {
      if(var1 != this.defaultGraphLayout) {
         this.defaultGraphLayout = var1;
         this.updateLayouter();
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.layoutChanged(this);
         }

      }
   }

   public void setHierarchicOrientation(ELayoutOrientation var1) {
      if(var1 != this.hierarchicLayoutOrientation) {
         this.hierarchicLayoutOrientation = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.hierarchicalLayoutOrientationChanged(this);
         }

      }
   }

   public void setHierarchicOrthogonalEdgeRouting(boolean var1) {
      if(var1 != this.hierarchicOrthogonalEdgeRouting) {
         this.hierarchicOrthogonalEdgeRouting = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.hierarchicalOrthogonalEdgeRoutingChanged(this);
         }

      }
   }

   public void setMinimumCircularNodeDistance(int var1) {
      if(var1 != this.circularLayoutMinNodeDistance) {
         this.circularLayoutMinNodeDistance = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.circularLayoutMinNodeDistanceChanged(this);
         }

      }
   }

   public void setMinimumHierarchicLayerDistance(int var1) {
      if(var1 != this.hierarchicLayoutMinLayerDistance) {
         this.hierarchicLayoutMinLayerDistance = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.hierarchicalLayoutMinLayerDistanceChanged(this);
         }

      }
   }

   public void setMinimumHierarchicNodeDistance(int var1) {
      if(var1 != this.hierarchicLayoutMinNodeDistance) {
         this.hierarchicLayoutMinNodeDistance = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.hierarchicalLayoutMinNodeDistanceChanged(this);
         }

      }
   }

   public void setMinimumOrthogonalNodeDistance(int var1) {
      if(var1 != this.orthogonalLayoutMinNodeDistance) {
         this.orthogonalLayoutMinNodeDistance = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.orthogonalLayoutMinNodeDistanceChanged(this);
         }

      }
   }

   public void setOrthogonalLayoutOrientation(ELayoutOrientation var1) {
      if(var1 != this.orthogonalLayoutOrientation) {
         this.orthogonalLayoutOrientation = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.orthogonalLayoutOrientationChanged(this);
         }

      }
   }

   public void setOrthogonalLayoutStyle(EOrthogonalLayoutStyle var1) {
      if(var1 != this.orthogonalLayoutStyle) {
         this.orthogonalLayoutStyle = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.orthogonalLayoutStyleChanged(this);
         }

      }
   }

   public void setVisibilityWarningThreshold(int var1) {
      if(this.visibilityWarningThreshold != var1) {
         this.visibilityWarningThreshold = var1;
         Iterator var2 = this.settingsListeners.iterator();

         while(var2.hasNext()) {
            IGraphSettingsChangedListener var3 = (IGraphSettingsChangedListener)var2.next();
            var3.visibilityWarningThresholdChanged(this);
         }

      }
   }

   public void updateLayouter() {
      if(this.getDefaultGraphLayout() == EGraphLayout.HIERARCHICAL) {
         this.setCurrentLayouter(LayoutCreator.getHierarchicalLayout(this));
      } else if(this.getDefaultGraphLayout() == EGraphLayout.ORTHOGONAL) {
         this.setCurrentLayouter(LayoutCreator.getOrthogonalLayout(this));
      } else {
         this.setCurrentLayouter(LayoutCreator.getCircularLayout(this));
      }

   }
}
