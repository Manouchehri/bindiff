package com.google.security.zynamics.bindiff.config;

public interface IInitialGraphViewSettings {
   int getAnimationSpeed();

   boolean getAutoLayouting();

   int getAutoProximityBrowsingActivationThreshold();

   int getCircularMinimumNodeDistance();

   int getCircularLayoutStyle();

   int getDefaultGraphLayout();

   boolean getDrawBends();

   boolean getGradientBackground();

   boolean getHierarchicalOrthogonalEdgeRouting();

   int getHierarchicalMinimumNodeDistance();

   int getHierarchicalMinimumLayerDistance();

   int getHierarchicalOrientation();

   boolean getLayoutAnimation();

   int getMouseWheelAction();

   int getOrthogonalMinimumNodeDistance();

   int getOrthogonalOrientation();

   int getOrthogonalLayoutStyle();

   boolean getProximityBrowsing();

   int getProximityBrowsingChildDepth();

   int getProximityBrowsingParentDepth();

   int getScrollSensitivity();

   boolean getShowScrollbars();

   boolean getViewSynchronization();

   int getVisibilityWarningThreshold();

   int getZoomSensitivity();

   void setAnimationSpeed(int var1);

   void setAutoLayouting(boolean var1);

   void setAutoProximityBrowsingActivationThreshold(int var1);

   void setCircularMinimumNodeDistance(int var1);

   void setCircularLayoutStyle(int var1);

   void setDefaultGraphLayout(int var1);

   void setDrawBends(boolean var1);

   void setGradientBackground(boolean var1);

   void setHierarchicalOrthogonalEdgeRouting(boolean var1);

   void setHierarchicalMinimumLayerDistance(int var1);

   void setHierarchicalMinimumNodeDistance(int var1);

   void setHierarchicalOrientation(int var1);

   void setLayoutAnimation(boolean var1);

   void setMouseWheelAction(int var1);

   void setOrthogonalMinimumNodeDistance(int var1);

   void setOrthogonalOrientation(int var1);

   void setOrthogonalLayoutStyle(int var1);

   void setProximityBrowsing(boolean var1);

   void setProximityBrowsingChildDepth(int var1);

   void setProximityBrowsingParentDepth(int var1);

   void setScrollSensitivity(int var1);

   void setShowScrollbars(boolean var1);

   void setViewSynchronization(boolean var1);

   void setVisibilityWarningThreshold(int var1);

   void setZoomSensitivity(int var1);
}
