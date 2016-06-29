package com.google.security.zynamics.bindiff.config;

import com.google.security.zynamics.common.config.AbstractConfigItem;
import com.google.security.zynamics.common.config.TypedPropertiesWrapper;

public abstract class GraphViewSettingsConfigItem extends AbstractConfigItem {
   private static final String DEFAULT_GRAPH_LAYOUT = "DefaultGraphLayout";
   private static final int DEFAULT_GRAPH_LAYOUT_DEFAULT = 0;
   private int defaultGraphLayout = 0;
   private static final String AUTO_LAYOUTING = "AutoLayouting";
   private static final boolean AUTO_LAYOUTING_DEFAULT = true;
   private boolean autoLayouting = true;
   private static final String PROXIMITY_BROWSING = "ProximityBrowsing";
   private static final boolean PROXIMITY_BROWSING_DEFAULT = true;
   private boolean proximityBrowsing = true;
   private static final String PROXIMITY_BROWSING_CHILD_DEPTH = "ProximityBrowsingChildDepth";
   private int proximityBrowsingChildDepth = this.getProximityBrowsingChildDepthDefaultValue();
   private static final String PROXIMITY_BROWSING_PARENT_DEPTH = "ProximityBrowsingParentDepth";
   private int proximityBrowsingParentDepth = this.getProximityBrowsingParentDepthDefaultValue();
   private static final String AUTO_PROXIMITY_BROWSING_ACTIVATION_THRESHOLD = "AutoProximityBrowsingActivationThreshold";
   private int autoProximityBrowsingActivationThreshold = this.getAutoProximityBrowsingActivationThresholdDefaultValue();
   private static final String VISIBILITY_WARNING_THRESHOLD = "VisibilityWarningThreshold";
   private int visibilityWarningThreshold = this.getVisibilityWarningThresholdDefaultValue();
   private static final String DRAW_BENDS = "DrawBends";
   private static final boolean DRAW_BENDS_DEFAULT = false;
   private boolean drawBends = false;
   private static final String HIERARCHICAL_ORTHOGONAL_EDGEROUTING = "HierarchicalOrthogonalEdgeRouting";
   private static final boolean HIERARCHICAL_ORTHOGONAL_EDGEROUTING_DEFAULT = false;
   private boolean hierarchicalOrthogonalEdgeRouting = false;
   private static final String HIERARCHICAL_ORIENTATION = "HierarchicalOrientation";
   private int hierarchicalOrientation = this.getHierarchicalOrientationDefaultValue();
   private static final String HIERARCHICAL_MINIMUM_LAYER_DISTANCE = "HierarchicalMinimumLayerDistance";
   private static final int HIERARCHICAL_MINIMUM_LAYER_DISTANCE_DEFAULT = 50;
   private int hierarchicalMinimumLayerDistance = 50;
   private static final String HIERARCHICAL_MINIMUM_NODE_DISTANCE = "HierarchicalMinimumNodeDistance";
   private static final int HIERARCHICAL_MINIMUM_NODE_DISTANCE_DEFAULT = 25;
   private int hierarchicalMinimumNodeDistance = 25;
   private static final String ORTHOGONAL_LAYOUT_STYLE = "OrthogonalLayoutStyle";
   private static final int ORTHOGONAL_LAYOUT_STYLE_DEFAULT = 0;
   private int orthogonalLayoutStyle = 0;
   private static final String ORTHOGONAL_ORIENTATION = "OrthogonalOrientation";
   private static final int ORTHOGONAL_ORIENTATION_DEFAULT = 0;
   private int orthogonalOrientation = 0;
   private static final String ORTHOGONAL_MINIMUM_NODE_DISTANCE = "OrthogonalMinimumNodeDistance";
   private static final int ORTHOGONAL_MINIMUM_NODE_DISTANCE_DEFAULT = 50;
   private int orthogonalMinimumNodeDistance = 50;
   private static final String CIRCULAR_LAYOUT_STYLE = "CircularLayoutStyle";
   private static final int CIRCULAR_LAYOUT_STYLE_DEFAULT = 1;
   private int circularLayoutStyle = 1;
   private static final String CIRCULAR_MINIMUM_NODE_DISTANCE = "CircularMinimumNodeDistance";
   private static final int CIRCULAR_MINIMUM_NODE_DISTANCE_DEFAULT = 50;
   private int circularMinimumNodeDistance = 50;
   private static final String SCROLL_SENSITIVITY = "ScrollSensitivity";
   private static final int SCROLL_SENSITIVITY_DEFAULT = 4;
   private int scrollSensitivity = 4;
   private static final String ZOOM_SENSITIVITY = "ZoomSensitivity";
   private static final int ZOOM_SENSITIVITY_DEFAULT = 4;
   private int zoomSensitivity = 4;
   private static final String MOUSE_WHEEL_ACTION = "MouseWheelAction";
   private static final int MOUSE_WHEEL_ACTION_DEFAULT = 4;
   private int mouseWheelAction = 4;
   private static final String VIEW_SYNCHRONIZATION = "ViewSynchronization";
   private static final boolean VIEW_SYNCHRONIZATION_DEFAULT = true;
   private boolean viewSynchronization = true;
   private static final String GRADIENT_BACKGROUND = "GradientBackground";
   private static final boolean GRADIENT_BACKGROUND_DEFAULT = false;
   private boolean gradientBackground = false;
   private static final String SHOW_SCROLLBARS = "ShowScrollbars";
   private static final boolean SHOW_SCROLLBARS_DEFAULT = false;
   private boolean showScrollbars = false;
   private static final String LAYOUT_ANIMATION = "LayoutAnimation";
   private static final boolean LAYOUT_ANIMATION_DEFAULT = true;
   private boolean layoutAnimation = true;
   private static final String ANIMATION_SPEED = "AnimationSpeed";
   private static final int ANIMATION_SPEED_DEFAULT = 5;
   private int animationSpeed = 5;

   protected abstract int getProximityBrowsingChildDepthDefaultValue();

   protected abstract int getProximityBrowsingParentDepthDefaultValue();

   protected abstract int getAutoProximityBrowsingActivationThresholdDefaultValue();

   protected abstract int getVisibilityWarningThresholdDefaultValue();

   protected abstract int getHierarchicalOrientationDefaultValue();

   public void load(TypedPropertiesWrapper var1) {
      this.defaultGraphLayout = var1.getInteger("DefaultGraphLayout", 0);
      this.autoLayouting = var1.getBoolean("AutoLayouting", true);
      this.proximityBrowsing = var1.getBoolean("ProximityBrowsing", true);
      this.proximityBrowsingChildDepth = var1.getInteger("ProximityBrowsingChildDepth", this.getProximityBrowsingChildDepthDefaultValue());
      this.proximityBrowsingParentDepth = var1.getInteger("ProximityBrowsingParentDepth", this.getProximityBrowsingParentDepthDefaultValue());
      this.autoProximityBrowsingActivationThreshold = var1.getInteger("AutoProximityBrowsingActivationThreshold", this.getAutoProximityBrowsingActivationThresholdDefaultValue());
      this.visibilityWarningThreshold = var1.getInteger("VisibilityWarningThreshold", this.getVisibilityWarningThresholdDefaultValue());
      this.drawBends = var1.getBoolean("DrawBends", false);
      this.hierarchicalOrthogonalEdgeRouting = var1.getBoolean("HierarchicalOrthogonalEdgeRouting", false);
      this.hierarchicalOrientation = var1.getInteger("HierarchicalOrientation", this.getHierarchicalOrientationDefaultValue());
      this.hierarchicalMinimumLayerDistance = var1.getInteger("HierarchicalMinimumLayerDistance", 50);
      this.hierarchicalMinimumNodeDistance = var1.getInteger("HierarchicalMinimumNodeDistance", 25);
      this.orthogonalLayoutStyle = var1.getInteger("OrthogonalLayoutStyle", 0);
      this.orthogonalOrientation = var1.getInteger("OrthogonalOrientation", 0);
      this.orthogonalMinimumNodeDistance = var1.getInteger("OrthogonalMinimumNodeDistance", 50);
      this.circularLayoutStyle = var1.getInteger("CircularLayoutStyle", 1);
      this.circularMinimumNodeDistance = var1.getInteger("CircularMinimumNodeDistance", 50);
      this.scrollSensitivity = var1.getInteger("ScrollSensitivity", 4);
      this.zoomSensitivity = var1.getInteger("ZoomSensitivity", 4);
      this.mouseWheelAction = var1.getInteger("MouseWheelAction", 4);
      this.viewSynchronization = var1.getBoolean("ViewSynchronization", true);
      this.gradientBackground = var1.getBoolean("GradientBackground", false);
      this.showScrollbars = var1.getBoolean("ShowScrollbars", false);
      this.layoutAnimation = var1.getBoolean("LayoutAnimation", true);
      this.animationSpeed = var1.getInteger("AnimationSpeed", 5);
   }

   public void store(TypedPropertiesWrapper var1) {
      var1.setInteger("DefaultGraphLayout", this.defaultGraphLayout);
      var1.setBoolean("AutoLayouting", this.autoLayouting);
      var1.setBoolean("ProximityBrowsing", this.proximityBrowsing);
      var1.setInteger("ProximityBrowsingChildDepth", this.proximityBrowsingChildDepth);
      var1.setInteger("ProximityBrowsingParentDepth", this.proximityBrowsingParentDepth);
      var1.setInteger("AutoProximityBrowsingActivationThreshold", this.autoProximityBrowsingActivationThreshold);
      var1.setInteger("VisibilityWarningThreshold", this.visibilityWarningThreshold);
      var1.setBoolean("DrawBends", this.drawBends);
      var1.setBoolean("HierarchicalOrthogonalEdgeRouting", this.hierarchicalOrthogonalEdgeRouting);
      var1.setInteger("HierarchicalOrientation", this.hierarchicalOrientation);
      var1.setInteger("HierarchicalMinimumLayerDistance", this.hierarchicalMinimumLayerDistance);
      var1.setInteger("HierarchicalMinimumNodeDistance", this.hierarchicalMinimumNodeDistance);
      var1.setInteger("OrthogonalLayoutStyle", this.orthogonalLayoutStyle);
      var1.setInteger("OrthogonalOrientation", this.orthogonalOrientation);
      var1.setInteger("OrthogonalMinimumNodeDistance", this.orthogonalMinimumNodeDistance);
      var1.setInteger("CircularLayoutStyle", this.circularLayoutStyle);
      var1.setInteger("CircularMinimumNodeDistance", this.circularMinimumNodeDistance);
      var1.setInteger("ScrollSensitivity", this.scrollSensitivity);
      var1.setInteger("ZoomSensitivity", this.zoomSensitivity);
      var1.setInteger("MouseWheelAction", this.mouseWheelAction);
      var1.setBoolean("ViewSynchronization", this.viewSynchronization);
      var1.setBoolean("GradientBackground", this.gradientBackground);
      var1.setBoolean("ShowScrollbars", this.showScrollbars);
      var1.setBoolean("LayoutAnimation", this.layoutAnimation);
      var1.setInteger("AnimationSpeed", this.animationSpeed);
   }

   public final int getDefaultGraphLayout() {
      return this.defaultGraphLayout;
   }

   public final boolean getAutoLayouting() {
      return this.autoLayouting;
   }

   public final boolean getProximityBrowsing() {
      return this.proximityBrowsing;
   }

   public final int getProximityBrowsingChildDepth() {
      return this.proximityBrowsingChildDepth;
   }

   public final int getProximityBrowsingParentDepth() {
      return this.proximityBrowsingParentDepth;
   }

   public final int getAutoProximityBrowsingActivationThreshold() {
      return this.autoProximityBrowsingActivationThreshold;
   }

   public final int getVisibilityWarningThreshold() {
      return this.visibilityWarningThreshold;
   }

   public final boolean getDrawBends() {
      return this.drawBends;
   }

   public final boolean getHierarchicalOrthogonalEdgeRouting() {
      return this.hierarchicalOrthogonalEdgeRouting;
   }

   public final int getHierarchicalOrientation() {
      return this.hierarchicalOrientation;
   }

   public final int getHierarchicalMinimumLayerDistance() {
      return this.hierarchicalMinimumLayerDistance;
   }

   public final int getHierarchicalMinimumNodeDistance() {
      return this.hierarchicalMinimumNodeDistance;
   }

   public final int getOrthogonalLayoutStyle() {
      return this.orthogonalLayoutStyle;
   }

   public final int getOrthogonalOrientation() {
      return this.orthogonalOrientation;
   }

   public final int getOrthogonalMinimumNodeDistance() {
      return this.orthogonalMinimumNodeDistance;
   }

   public final int getCircularLayoutStyle() {
      return this.circularLayoutStyle;
   }

   public final int getCircularMinimumNodeDistance() {
      return this.circularMinimumNodeDistance;
   }

   public final int getScrollSensitivity() {
      return this.scrollSensitivity;
   }

   public final int getZoomSensitivity() {
      return this.zoomSensitivity;
   }

   public final int getMouseWheelAction() {
      return this.mouseWheelAction;
   }

   public final boolean getViewSynchronization() {
      return this.viewSynchronization;
   }

   public final boolean getGradientBackground() {
      return this.gradientBackground;
   }

   public final boolean getShowScrollbars() {
      return this.showScrollbars;
   }

   public final boolean getLayoutAnimation() {
      return this.layoutAnimation;
   }

   public final int getAnimationSpeed() {
      return this.animationSpeed;
   }

   public final void setDefaultGraphLayout(int var1) {
      this.defaultGraphLayout = var1;
   }

   public final void setAutoLayouting(boolean var1) {
      this.autoLayouting = var1;
   }

   public final void setProximityBrowsing(boolean var1) {
      this.proximityBrowsing = var1;
   }

   public final void setProximityBrowsingChildDepth(int var1) {
      this.proximityBrowsingChildDepth = var1;
   }

   public final void setProximityBrowsingParentDepth(int var1) {
      this.proximityBrowsingParentDepth = var1;
   }

   public final void setAutoProximityBrowsingActivationThreshold(int var1) {
      this.autoProximityBrowsingActivationThreshold = var1;
   }

   public final void setVisibilityWarningThreshold(int var1) {
      this.visibilityWarningThreshold = var1;
   }

   public final void setDrawBends(boolean var1) {
      this.drawBends = var1;
   }

   public final void setHierarchicalOrthogonalEdgeRouting(boolean var1) {
      this.hierarchicalOrthogonalEdgeRouting = var1;
   }

   public final void setHierarchicalOrientation(int var1) {
      this.hierarchicalOrientation = var1;
   }

   public final void setHierarchicalMinimumLayerDistance(int var1) {
      this.hierarchicalMinimumLayerDistance = var1;
   }

   public final void setHierarchicalMinimumNodeDistance(int var1) {
      this.hierarchicalMinimumNodeDistance = var1;
   }

   public final void setOrthogonalLayoutStyle(int var1) {
      this.orthogonalLayoutStyle = var1;
   }

   public final void setOrthogonalOrientation(int var1) {
      this.orthogonalOrientation = var1;
   }

   public final void setOrthogonalMinimumNodeDistance(int var1) {
      this.orthogonalMinimumNodeDistance = var1;
   }

   public final void setCircularLayoutStyle(int var1) {
      this.circularLayoutStyle = var1;
   }

   public final void setCircularMinimumNodeDistance(int var1) {
      this.circularMinimumNodeDistance = var1;
   }

   public final void setScrollSensitivity(int var1) {
      this.scrollSensitivity = var1;
   }

   public final void setZoomSensitivity(int var1) {
      this.zoomSensitivity = var1;
   }

   public final void setMouseWheelAction(int var1) {
      this.mouseWheelAction = var1;
   }

   public final void setViewSynchronization(boolean var1) {
      this.viewSynchronization = var1;
   }

   public final void setGradientBackground(boolean var1) {
      this.gradientBackground = var1;
   }

   public final void setShowScrollbars(boolean var1) {
      this.showScrollbars = var1;
   }

   public final void setLayoutAnimation(boolean var1) {
      this.layoutAnimation = var1;
   }

   public final void setAnimationSpeed(int var1) {
      this.animationSpeed = var1;
   }
}
