package com.google.security.zynamics.bindiff.config;

import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;

public class InitialCallGraphViewSettingsConfigItem extends GraphViewSettingsConfigItem {
   private static final int PROXIMITY_BROWSING_CHILD_DEPTH_DEFAULT = 1;
   private static final int PROXIMITY_BROWSING_PARENT_DEPTH_DEFAULT = 1;
   private static final int AUTO_PROXIMITY_BROWSING_ACTIVATION_THRESHOLD_DEFAULT = 300;
   private static final int VISIBILITY_WARNING_THRESHOLD_DEFAULT = 400;
   private static final int HIERARCHICAL_ORIENTATION_DEFAULT = 0;

   protected int getProximityBrowsingChildDepthDefaultValue() {
      return 1;
   }

   protected int getProximityBrowsingParentDepthDefaultValue() {
      return 1;
   }

   protected int getAutoProximityBrowsingActivationThresholdDefaultValue() {
      return 300;
   }

   protected int getVisibilityWarningThresholdDefaultValue() {
      return 400;
   }

   protected int getHierarchicalOrientationDefaultValue() {
      return 0;
   }
}
