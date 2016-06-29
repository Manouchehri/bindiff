/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.config;

import com.google.security.zynamics.common.config.AbstractConfigItem;
import com.google.security.zynamics.common.config.TypedPropertiesWrapper;

public abstract class GraphViewSettingsConfigItem
extends AbstractConfigItem {
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
    private int proximityBrowsingChildDepth;
    private static final String PROXIMITY_BROWSING_PARENT_DEPTH = "ProximityBrowsingParentDepth";
    private int proximityBrowsingParentDepth;
    private static final String AUTO_PROXIMITY_BROWSING_ACTIVATION_THRESHOLD = "AutoProximityBrowsingActivationThreshold";
    private int autoProximityBrowsingActivationThreshold;
    private static final String VISIBILITY_WARNING_THRESHOLD = "VisibilityWarningThreshold";
    private int visibilityWarningThreshold;
    private static final String DRAW_BENDS = "DrawBends";
    private static final boolean DRAW_BENDS_DEFAULT = false;
    private boolean drawBends = false;
    private static final String HIERARCHICAL_ORTHOGONAL_EDGEROUTING = "HierarchicalOrthogonalEdgeRouting";
    private static final boolean HIERARCHICAL_ORTHOGONAL_EDGEROUTING_DEFAULT = false;
    private boolean hierarchicalOrthogonalEdgeRouting = false;
    private static final String HIERARCHICAL_ORIENTATION = "HierarchicalOrientation";
    private int hierarchicalOrientation;
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

    GraphViewSettingsConfigItem() {
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
    public void load(TypedPropertiesWrapper typedPropertiesWrapper) {
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
    public void store(TypedPropertiesWrapper typedPropertiesWrapper) {
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

    public final void setDefaultGraphLayout(int n2) {
        this.defaultGraphLayout = n2;
    }

    public final void setAutoLayouting(boolean bl2) {
        this.autoLayouting = bl2;
    }

    public final void setProximityBrowsing(boolean bl2) {
        this.proximityBrowsing = bl2;
    }

    public final void setProximityBrowsingChildDepth(int n2) {
        this.proximityBrowsingChildDepth = n2;
    }

    public final void setProximityBrowsingParentDepth(int n2) {
        this.proximityBrowsingParentDepth = n2;
    }

    public final void setAutoProximityBrowsingActivationThreshold(int n2) {
        this.autoProximityBrowsingActivationThreshold = n2;
    }

    public final void setVisibilityWarningThreshold(int n2) {
        this.visibilityWarningThreshold = n2;
    }

    public final void setDrawBends(boolean bl2) {
        this.drawBends = bl2;
    }

    public final void setHierarchicalOrthogonalEdgeRouting(boolean bl2) {
        this.hierarchicalOrthogonalEdgeRouting = bl2;
    }

    public final void setHierarchicalOrientation(int n2) {
        this.hierarchicalOrientation = n2;
    }

    public final void setHierarchicalMinimumLayerDistance(int n2) {
        this.hierarchicalMinimumLayerDistance = n2;
    }

    public final void setHierarchicalMinimumNodeDistance(int n2) {
        this.hierarchicalMinimumNodeDistance = n2;
    }

    public final void setOrthogonalLayoutStyle(int n2) {
        this.orthogonalLayoutStyle = n2;
    }

    public final void setOrthogonalOrientation(int n2) {
        this.orthogonalOrientation = n2;
    }

    public final void setOrthogonalMinimumNodeDistance(int n2) {
        this.orthogonalMinimumNodeDistance = n2;
    }

    public final void setCircularLayoutStyle(int n2) {
        this.circularLayoutStyle = n2;
    }

    public final void setCircularMinimumNodeDistance(int n2) {
        this.circularMinimumNodeDistance = n2;
    }

    public final void setScrollSensitivity(int n2) {
        this.scrollSensitivity = n2;
    }

    public final void setZoomSensitivity(int n2) {
        this.zoomSensitivity = n2;
    }

    public final void setMouseWheelAction(int n2) {
        this.mouseWheelAction = n2;
    }

    public final void setViewSynchronization(boolean bl2) {
        this.viewSynchronization = bl2;
    }

    public final void setGradientBackground(boolean bl2) {
        this.gradientBackground = bl2;
    }

    public final void setShowScrollbars(boolean bl2) {
        this.showScrollbars = bl2;
    }

    public final void setLayoutAnimation(boolean bl2) {
        this.layoutAnimation = bl2;
    }

    public final void setAnimationSpeed(int n2) {
        this.animationSpeed = n2;
    }
}

