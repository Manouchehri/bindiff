package com.google.security.zynamics.bindiff.config;

public class InitialCallGraphViewSettingsConfigItem extends GraphViewSettingsConfigItem
{
    private static final int PROXIMITY_BROWSING_CHILD_DEPTH_DEFAULT = 1;
    private static final int PROXIMITY_BROWSING_PARENT_DEPTH_DEFAULT = 1;
    private static final int AUTO_PROXIMITY_BROWSING_ACTIVATION_THRESHOLD_DEFAULT = 300;
    private static final int VISIBILITY_WARNING_THRESHOLD_DEFAULT = 400;
    private static final int HIERARCHICAL_ORIENTATION_DEFAULT = 0;
    
    @Override
    protected int getProximityBrowsingChildDepthDefaultValue() {
        return 1;
    }
    
    @Override
    protected int getProximityBrowsingParentDepthDefaultValue() {
        return 1;
    }
    
    @Override
    protected int getAutoProximityBrowsingActivationThresholdDefaultValue() {
        return 300;
    }
    
    @Override
    protected int getVisibilityWarningThresholdDefaultValue() {
        return 400;
    }
    
    @Override
    protected int getHierarchicalOrientationDefaultValue() {
        return 0;
    }
}
