package com.google.security.zynamics.bindiff.config;

import com.google.security.zynamics.common.config.*;

public abstract class GraphViewSettingsConfigItem extends AbstractConfigItem
{
    private static final String DEFAULT_GRAPH_LAYOUT = "DefaultGraphLayout";
    private static final int DEFAULT_GRAPH_LAYOUT_DEFAULT = 0;
    private int defaultGraphLayout;
    private static final String AUTO_LAYOUTING = "AutoLayouting";
    private static final boolean AUTO_LAYOUTING_DEFAULT = true;
    private boolean autoLayouting;
    private static final String PROXIMITY_BROWSING = "ProximityBrowsing";
    private static final boolean PROXIMITY_BROWSING_DEFAULT = true;
    private boolean proximityBrowsing;
    private static final String PROXIMITY_BROWSING_CHILD_DEPTH = "ProximityBrowsingChildDepth";
    private int proximityBrowsingChildDepth;
    private static final String PROXIMITY_BROWSING_PARENT_DEPTH = "ProximityBrowsingParentDepth";
    private int proximityBrowsingParentDepth;
    private static final String AUTO_PROXIMITY_BROWSING_ACTIVATION_THRESHOLD = "AutoProximityBrowsingActivationThreshold";
    private int autoProximityBrowsingActivationThreshold;
    private static final String VISIBILITY_WARNING_THRESHOLD = "VisibilityWarningThreshold";
    private int visibilityWarningThreshold;
    private static final String DRAW_BENDS = "DrawBends";
    private static final boolean DRAW_BENDS_DEFAULT = false;
    private boolean drawBends;
    private static final String HIERARCHICAL_ORTHOGONAL_EDGEROUTING = "HierarchicalOrthogonalEdgeRouting";
    private static final boolean HIERARCHICAL_ORTHOGONAL_EDGEROUTING_DEFAULT = false;
    private boolean hierarchicalOrthogonalEdgeRouting;
    private static final String HIERARCHICAL_ORIENTATION = "HierarchicalOrientation";
    private int hierarchicalOrientation;
    private static final String HIERARCHICAL_MINIMUM_LAYER_DISTANCE = "HierarchicalMinimumLayerDistance";
    private static final int HIERARCHICAL_MINIMUM_LAYER_DISTANCE_DEFAULT = 50;
    private int hierarchicalMinimumLayerDistance;
    private static final String HIERARCHICAL_MINIMUM_NODE_DISTANCE = "HierarchicalMinimumNodeDistance";
    private static final int HIERARCHICAL_MINIMUM_NODE_DISTANCE_DEFAULT = 25;
    private int hierarchicalMinimumNodeDistance;
    private static final String ORTHOGONAL_LAYOUT_STYLE = "OrthogonalLayoutStyle";
    private static final int ORTHOGONAL_LAYOUT_STYLE_DEFAULT = 0;
    private int orthogonalLayoutStyle;
    private static final String ORTHOGONAL_ORIENTATION = "OrthogonalOrientation";
    private static final int ORTHOGONAL_ORIENTATION_DEFAULT = 0;
    private int orthogonalOrientation;
    private static final String ORTHOGONAL_MINIMUM_NODE_DISTANCE = "OrthogonalMinimumNodeDistance";
    private static final int ORTHOGONAL_MINIMUM_NODE_DISTANCE_DEFAULT = 50;
    private int orthogonalMinimumNodeDistance;
    private static final String CIRCULAR_LAYOUT_STYLE = "CircularLayoutStyle";
    private static final int CIRCULAR_LAYOUT_STYLE_DEFAULT = 1;
    private int circularLayoutStyle;
    private static final String CIRCULAR_MINIMUM_NODE_DISTANCE = "CircularMinimumNodeDistance";
    private static final int CIRCULAR_MINIMUM_NODE_DISTANCE_DEFAULT = 50;
    private int circularMinimumNodeDistance;
    private static final String SCROLL_SENSITIVITY = "ScrollSensitivity";
    private static final int SCROLL_SENSITIVITY_DEFAULT = 4;
    private int scrollSensitivity;
    private static final String ZOOM_SENSITIVITY = "ZoomSensitivity";
    private static final int ZOOM_SENSITIVITY_DEFAULT = 4;
    private int zoomSensitivity;
    private static final String MOUSE_WHEEL_ACTION = "MouseWheelAction";
    private static final int MOUSE_WHEEL_ACTION_DEFAULT = 4;
    private int mouseWheelAction;
    private static final String VIEW_SYNCHRONIZATION = "ViewSynchronization";
    private static final boolean VIEW_SYNCHRONIZATION_DEFAULT = true;
    private boolean viewSynchronization;
    private static final String GRADIENT_BACKGROUND = "GradientBackground";
    private static final boolean GRADIENT_BACKGROUND_DEFAULT = false;
    private boolean gradientBackground;
    private static final String SHOW_SCROLLBARS = "ShowScrollbars";
    private static final boolean SHOW_SCROLLBARS_DEFAULT = false;
    private boolean showScrollbars;
    private static final String LAYOUT_ANIMATION = "LayoutAnimation";
    private static final boolean LAYOUT_ANIMATION_DEFAULT = true;
    private boolean layoutAnimation;
    private static final String ANIMATION_SPEED = "AnimationSpeed";
    private static final int ANIMATION_SPEED_DEFAULT = 5;
    private int animationSpeed;
    
    GraphViewSettingsConfigItem() {
        this.defaultGraphLayout = 0;
        this.autoLayouting = true;
        this.proximityBrowsing = true;
        this.drawBends = false;
        this.hierarchicalOrthogonalEdgeRouting = false;
        this.hierarchicalMinimumLayerDistance = 50;
        this.hierarchicalMinimumNodeDistance = 25;
        this.orthogonalLayoutStyle = 0;
        this.orthogonalOrientation = 0;
        this.orthogonalMinimumNodeDistance = 50;
        this.circularLayoutStyle = 1;
        this.circularMinimumNodeDistance = 50;
        this.scrollSensitivity = 4;
        this.zoomSensitivity = 4;
        this.mouseWheelAction = 4;
        this.viewSynchronization = true;
        this.gradientBackground = false;
        this.showScrollbars = false;
        this.layoutAnimation = true;
        this.animationSpeed = 5;
        this.proximityBrowsingChildDepth = this.getProximityBrowsingChildDepthDefaultValue();
        this.proximityBrowsingParentDepth = this.getProximityBrowsingParentDepthDefaultValue();
        this.autoProximityBrowsingActivationThreshold = this.getAutoProximityBrowsingActivationThresholdDefaultValue();
        this.visibilityWarningThreshold = this.getVisibilityWarningThresholdDefaultValue();
        this.hierarchicalOrientation = this.getHierarchicalOrientationDefaultValue();
    }
    
    protected abstract int getProximityBrowsingChildDepthDefaultValue();
    
    protected abstract int getProximityBrowsingParentDepthDefaultValue();
    
    protected abstract int getAutoProximityBrowsingActivationThresholdDefaultValue();
    
    protected abstract int getVisibilityWarningThresholdDefaultValue();
    
    protected abstract int getHierarchicalOrientationDefaultValue();
    
    @Override
    public void load(final TypedPropertiesWrapper typedPropertiesWrapper) {
        this.defaultGraphLayout = typedPropertiesWrapper.getInteger("DefaultGraphLayout", 0);
        this.autoLayouting = typedPropertiesWrapper.getBoolean("AutoLayouting", true);
        this.proximityBrowsing = typedPropertiesWrapper.getBoolean("ProximityBrowsing", true);
        this.proximityBrowsingChildDepth = typedPropertiesWrapper.getInteger("ProximityBrowsingChildDepth", this.getProximityBrowsingChildDepthDefaultValue());
        this.proximityBrowsingParentDepth = typedPropertiesWrapper.getInteger("ProximityBrowsingParentDepth", this.getProximityBrowsingParentDepthDefaultValue());
        this.autoProximityBrowsingActivationThreshold = typedPropertiesWrapper.getInteger("AutoProximityBrowsingActivationThreshold", this.getAutoProximityBrowsingActivationThresholdDefaultValue());
        this.visibilityWarningThreshold = typedPropertiesWrapper.getInteger("VisibilityWarningThreshold", this.getVisibilityWarningThresholdDefaultValue());
        this.drawBends = typedPropertiesWrapper.getBoolean("DrawBends", false);
        this.hierarchicalOrthogonalEdgeRouting = typedPropertiesWrapper.getBoolean("HierarchicalOrthogonalEdgeRouting", false);
        this.hierarchicalOrientation = typedPropertiesWrapper.getInteger("HierarchicalOrientation", this.getHierarchicalOrientationDefaultValue());
        this.hierarchicalMinimumLayerDistance = typedPropertiesWrapper.getInteger("HierarchicalMinimumLayerDistance", 50);
        this.hierarchicalMinimumNodeDistance = typedPropertiesWrapper.getInteger("HierarchicalMinimumNodeDistance", 25);
        this.orthogonalLayoutStyle = typedPropertiesWrapper.getInteger("OrthogonalLayoutStyle", 0);
        this.orthogonalOrientation = typedPropertiesWrapper.getInteger("OrthogonalOrientation", 0);
        this.orthogonalMinimumNodeDistance = typedPropertiesWrapper.getInteger("OrthogonalMinimumNodeDistance", 50);
        this.circularLayoutStyle = typedPropertiesWrapper.getInteger("CircularLayoutStyle", 1);
        this.circularMinimumNodeDistance = typedPropertiesWrapper.getInteger("CircularMinimumNodeDistance", 50);
        this.scrollSensitivity = typedPropertiesWrapper.getInteger("ScrollSensitivity", 4);
        this.zoomSensitivity = typedPropertiesWrapper.getInteger("ZoomSensitivity", 4);
        this.mouseWheelAction = typedPropertiesWrapper.getInteger("MouseWheelAction", 4);
        this.viewSynchronization = typedPropertiesWrapper.getBoolean("ViewSynchronization", true);
        this.gradientBackground = typedPropertiesWrapper.getBoolean("GradientBackground", false);
        this.showScrollbars = typedPropertiesWrapper.getBoolean("ShowScrollbars", false);
        this.layoutAnimation = typedPropertiesWrapper.getBoolean("LayoutAnimation", true);
        this.animationSpeed = typedPropertiesWrapper.getInteger("AnimationSpeed", 5);
    }
    
    @Override
    public void store(final TypedPropertiesWrapper typedPropertiesWrapper) {
        typedPropertiesWrapper.setInteger("DefaultGraphLayout", this.defaultGraphLayout);
        typedPropertiesWrapper.setBoolean("AutoLayouting", this.autoLayouting);
        typedPropertiesWrapper.setBoolean("ProximityBrowsing", this.proximityBrowsing);
        typedPropertiesWrapper.setInteger("ProximityBrowsingChildDepth", this.proximityBrowsingChildDepth);
        typedPropertiesWrapper.setInteger("ProximityBrowsingParentDepth", this.proximityBrowsingParentDepth);
        typedPropertiesWrapper.setInteger("AutoProximityBrowsingActivationThreshold", this.autoProximityBrowsingActivationThreshold);
        typedPropertiesWrapper.setInteger("VisibilityWarningThreshold", this.visibilityWarningThreshold);
        typedPropertiesWrapper.setBoolean("DrawBends", this.drawBends);
        typedPropertiesWrapper.setBoolean("HierarchicalOrthogonalEdgeRouting", this.hierarchicalOrthogonalEdgeRouting);
        typedPropertiesWrapper.setInteger("HierarchicalOrientation", this.hierarchicalOrientation);
        typedPropertiesWrapper.setInteger("HierarchicalMinimumLayerDistance", this.hierarchicalMinimumLayerDistance);
        typedPropertiesWrapper.setInteger("HierarchicalMinimumNodeDistance", this.hierarchicalMinimumNodeDistance);
        typedPropertiesWrapper.setInteger("OrthogonalLayoutStyle", this.orthogonalLayoutStyle);
        typedPropertiesWrapper.setInteger("OrthogonalOrientation", this.orthogonalOrientation);
        typedPropertiesWrapper.setInteger("OrthogonalMinimumNodeDistance", this.orthogonalMinimumNodeDistance);
        typedPropertiesWrapper.setInteger("CircularLayoutStyle", this.circularLayoutStyle);
        typedPropertiesWrapper.setInteger("CircularMinimumNodeDistance", this.circularMinimumNodeDistance);
        typedPropertiesWrapper.setInteger("ScrollSensitivity", this.scrollSensitivity);
        typedPropertiesWrapper.setInteger("ZoomSensitivity", this.zoomSensitivity);
        typedPropertiesWrapper.setInteger("MouseWheelAction", this.mouseWheelAction);
        typedPropertiesWrapper.setBoolean("ViewSynchronization", this.viewSynchronization);
        typedPropertiesWrapper.setBoolean("GradientBackground", this.gradientBackground);
        typedPropertiesWrapper.setBoolean("ShowScrollbars", this.showScrollbars);
        typedPropertiesWrapper.setBoolean("LayoutAnimation", this.layoutAnimation);
        typedPropertiesWrapper.setInteger("AnimationSpeed", this.animationSpeed);
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
    
    public final void setDefaultGraphLayout(final int defaultGraphLayout) {
        this.defaultGraphLayout = defaultGraphLayout;
    }
    
    public final void setAutoLayouting(final boolean autoLayouting) {
        this.autoLayouting = autoLayouting;
    }
    
    public final void setProximityBrowsing(final boolean proximityBrowsing) {
        this.proximityBrowsing = proximityBrowsing;
    }
    
    public final void setProximityBrowsingChildDepth(final int proximityBrowsingChildDepth) {
        this.proximityBrowsingChildDepth = proximityBrowsingChildDepth;
    }
    
    public final void setProximityBrowsingParentDepth(final int proximityBrowsingParentDepth) {
        this.proximityBrowsingParentDepth = proximityBrowsingParentDepth;
    }
    
    public final void setAutoProximityBrowsingActivationThreshold(final int autoProximityBrowsingActivationThreshold) {
        this.autoProximityBrowsingActivationThreshold = autoProximityBrowsingActivationThreshold;
    }
    
    public final void setVisibilityWarningThreshold(final int visibilityWarningThreshold) {
        this.visibilityWarningThreshold = visibilityWarningThreshold;
    }
    
    public final void setDrawBends(final boolean drawBends) {
        this.drawBends = drawBends;
    }
    
    public final void setHierarchicalOrthogonalEdgeRouting(final boolean hierarchicalOrthogonalEdgeRouting) {
        this.hierarchicalOrthogonalEdgeRouting = hierarchicalOrthogonalEdgeRouting;
    }
    
    public final void setHierarchicalOrientation(final int hierarchicalOrientation) {
        this.hierarchicalOrientation = hierarchicalOrientation;
    }
    
    public final void setHierarchicalMinimumLayerDistance(final int hierarchicalMinimumLayerDistance) {
        this.hierarchicalMinimumLayerDistance = hierarchicalMinimumLayerDistance;
    }
    
    public final void setHierarchicalMinimumNodeDistance(final int hierarchicalMinimumNodeDistance) {
        this.hierarchicalMinimumNodeDistance = hierarchicalMinimumNodeDistance;
    }
    
    public final void setOrthogonalLayoutStyle(final int orthogonalLayoutStyle) {
        this.orthogonalLayoutStyle = orthogonalLayoutStyle;
    }
    
    public final void setOrthogonalOrientation(final int orthogonalOrientation) {
        this.orthogonalOrientation = orthogonalOrientation;
    }
    
    public final void setOrthogonalMinimumNodeDistance(final int orthogonalMinimumNodeDistance) {
        this.orthogonalMinimumNodeDistance = orthogonalMinimumNodeDistance;
    }
    
    public final void setCircularLayoutStyle(final int circularLayoutStyle) {
        this.circularLayoutStyle = circularLayoutStyle;
    }
    
    public final void setCircularMinimumNodeDistance(final int circularMinimumNodeDistance) {
        this.circularMinimumNodeDistance = circularMinimumNodeDistance;
    }
    
    public final void setScrollSensitivity(final int scrollSensitivity) {
        this.scrollSensitivity = scrollSensitivity;
    }
    
    public final void setZoomSensitivity(final int zoomSensitivity) {
        this.zoomSensitivity = zoomSensitivity;
    }
    
    public final void setMouseWheelAction(final int mouseWheelAction) {
        this.mouseWheelAction = mouseWheelAction;
    }
    
    public final void setViewSynchronization(final boolean viewSynchronization) {
        this.viewSynchronization = viewSynchronization;
    }
    
    public final void setGradientBackground(final boolean gradientBackground) {
        this.gradientBackground = gradientBackground;
    }
    
    public final void setShowScrollbars(final boolean showScrollbars) {
        this.showScrollbars = showScrollbars;
    }
    
    public final void setLayoutAnimation(final boolean layoutAnimation) {
        this.layoutAnimation = layoutAnimation;
    }
    
    public final void setAnimationSpeed(final int animationSpeed) {
        this.animationSpeed = animationSpeed;
    }
}
