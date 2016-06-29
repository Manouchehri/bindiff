package com.google.security.zynamics.bindiff.graph.settings;

import com.google.security.zynamics.bindiff.graph.settings.GraphDisplaySettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphMouseSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;

public interface IGraphSettingsChangedListener {
   void animationSpeedChanged(GraphDisplaySettings var1);

   void autoLayoutChanged(GraphLayoutSettings var1);

   void autoProximityBrowsingActivationThresholdChanged(GraphProximityBrowsingSettings var1);

   void circularLayoutMinNodeDistanceChanged(GraphLayoutSettings var1);

   void circularLayoutStyleChanged(GraphLayoutSettings var1);

   void diffViewModeChanged(GraphSettings var1);

   void drawBendsChanged(GraphSettings var1);

   void focusSideChanged(GraphSettings var1);

   void gradientBackgroundChanged(GraphDisplaySettings var1);

   void graphSyncChanged(GraphSettings var1);

   void hierarchicalLayoutMinLayerDistanceChanged(GraphLayoutSettings var1);

   void hierarchicalLayoutMinNodeDistanceChanged(GraphLayoutSettings var1);

   void hierarchicalLayoutOrientationChanged(GraphLayoutSettings var1);

   void hierarchicalOrthogonalEdgeRoutingChanged(GraphLayoutSettings var1);

   void layoutAnimationChanged(GraphLayoutSettings var1);

   void layoutChanged(GraphLayoutSettings var1);

   void mouseWheelActionChanged(GraphMouseSettings var1);

   void orthogonalLayoutMinNodeDistanceChanged(GraphLayoutSettings var1);

   void orthogonalLayoutOrientationChanged(GraphLayoutSettings var1);

   void orthogonalLayoutStyleChanged(GraphLayoutSettings var1);

   void proximityBrowsingChanged(GraphProximityBrowsingSettings var1);

   void proximityBrowsingChildDepthChanged(GraphProximityBrowsingSettings var1);

   void proximityBrowsingFrozenChanged(GraphProximityBrowsingSettings var1);

   void proximityBrowsingParentDepthChanged(GraphProximityBrowsingSettings var1);

   void scrollSensitivityChanged(GraphMouseSettings var1);

   void showScrollbarsChanged(GraphSettings var1);

   void visibilityWarningThresholdChanged(GraphLayoutSettings var1);

   void zoomSensitivityChanged(GraphMouseSettings var1);
}
