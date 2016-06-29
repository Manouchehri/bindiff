/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.config;

import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;

public class InitialFlowGraphViewSettingsConfigItem
extends GraphViewSettingsConfigItem {
    private static final int PROXIMITY_BROWSING_CHILD_DEPTH_DEFAULT = 2;
    private static final int PROXIMITY_BROWSING_PARENT_DEPTH_DEFAULT = 2;
    private static final int AUTO_PROXIMITY_BROWSING_ACTIVATION_THRESHOLD_DEFAULT = 200;
    private static final int VISIBILITY_WARNING_THRESHOLD_DEFAULT = 300;
    private static final int HIERARCHICAL_ORIENTATION_DEFAULT = 1;

    @Override
    protected int getProximityBrowsingChildDepthDefaultValue() {
        return 2;
    }

    @Override
    protected int getProximityBrowsingParentDepthDefaultValue() {
        return 2;
    }

    @Override
    protected int getAutoProximityBrowsingActivationThresholdDefaultValue() {
        return 200;
    }

    @Override
    protected int getVisibilityWarningThresholdDefaultValue() {
        return 300;
    }

    @Override
    protected int getHierarchicalOrientationDefaultValue() {
        return 1;
    }
}

