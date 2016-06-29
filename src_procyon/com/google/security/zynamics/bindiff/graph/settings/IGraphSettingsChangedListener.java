package com.google.security.zynamics.bindiff.graph.settings;

public interface IGraphSettingsChangedListener
{
    void animationSpeedChanged(final GraphDisplaySettings p0);
    
    void autoLayoutChanged(final GraphLayoutSettings p0);
    
    void autoProximityBrowsingActivationThresholdChanged(final GraphProximityBrowsingSettings p0);
    
    void circularLayoutMinNodeDistanceChanged(final GraphLayoutSettings p0);
    
    void circularLayoutStyleChanged(final GraphLayoutSettings p0);
    
    void diffViewModeChanged(final GraphSettings p0);
    
    void drawBendsChanged(final GraphSettings p0);
    
    void focusSideChanged(final GraphSettings p0);
    
    void gradientBackgroundChanged(final GraphDisplaySettings p0);
    
    void graphSyncChanged(final GraphSettings p0);
    
    void hierarchicalLayoutMinLayerDistanceChanged(final GraphLayoutSettings p0);
    
    void hierarchicalLayoutMinNodeDistanceChanged(final GraphLayoutSettings p0);
    
    void hierarchicalLayoutOrientationChanged(final GraphLayoutSettings p0);
    
    void hierarchicalOrthogonalEdgeRoutingChanged(final GraphLayoutSettings p0);
    
    void layoutAnimationChanged(final GraphLayoutSettings p0);
    
    void layoutChanged(final GraphLayoutSettings p0);
    
    void mouseWheelActionChanged(final GraphMouseSettings p0);
    
    void orthogonalLayoutMinNodeDistanceChanged(final GraphLayoutSettings p0);
    
    void orthogonalLayoutOrientationChanged(final GraphLayoutSettings p0);
    
    void orthogonalLayoutStyleChanged(final GraphLayoutSettings p0);
    
    void proximityBrowsingChanged(final GraphProximityBrowsingSettings p0);
    
    void proximityBrowsingChildDepthChanged(final GraphProximityBrowsingSettings p0);
    
    void proximityBrowsingFrozenChanged(final GraphProximityBrowsingSettings p0);
    
    void proximityBrowsingParentDepthChanged(final GraphProximityBrowsingSettings p0);
    
    void scrollSensitivityChanged(final GraphMouseSettings p0);
    
    void showScrollbarsChanged(final GraphSettings p0);
    
    void visibilityWarningThresholdChanged(final GraphLayoutSettings p0);
    
    void zoomSensitivityChanged(final GraphMouseSettings p0);
}
