/*
 * Decompiled with CFR 0_115.
 */
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

public class GraphLayoutSettings
implements ILayoutSettings {
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

    public GraphLayoutSettings(GraphViewSettingsConfigItem graphViewSettingsConfigItem) {
        this.defaultGraphLayout = EGraphLayout.getEnum(graphViewSettingsConfigItem.getDefaultGraphLayout());
        this.autoLayouting = graphViewSettingsConfigItem.getAutoLayouting();
        this.visibilityWarningThreshold = graphViewSettingsConfigItem.getVisibilityWarningThreshold();
        this.layoutAnimation = graphViewSettingsConfigItem.getLayoutAnimation();
        this.circularLayoutStyle = ECircularLayoutStyle.getEnum(graphViewSettingsConfigItem.getCircularLayoutStyle());
        this.circularLayoutMinNodeDistance = graphViewSettingsConfigItem.getCircularMinimumNodeDistance();
        this.hierarchicOrthogonalEdgeRouting = graphViewSettingsConfigItem.getHierarchicalOrthogonalEdgeRouting();
        this.hierarchicLayoutOrientation = ELayoutOrientation.getEnum(graphViewSettingsConfigItem.getHierarchicalOrientation());
        this.hierarchicLayoutMinLayerDistance = graphViewSettingsConfigItem.getHierarchicalMinimumNodeDistance();
        this.hierarchicLayoutMinNodeDistance = graphViewSettingsConfigItem.getHierarchicalMinimumLayerDistance();
        this.orthogonalLayoutStyle = EOrthogonalLayoutStyle.getEnum(graphViewSettingsConfigItem.getOrthogonalLayoutStyle());
        this.orthogonalLayoutOrientation = ELayoutOrientation.getEnum(graphViewSettingsConfigItem.getOrthogonalOrientation());
        this.orthogonalLayoutMinNodeDistance = graphViewSettingsConfigItem.getOrthogonalMinimumNodeDistance();
        this.updateLayouter();
    }

    private void setCurrentLayouter(c c2) {
        Preconditions.checkNotNull(c2);
        this.currentLayouter = c2;
    }

    protected void addListener(IGraphSettingsChangedListener iGraphSettingsChangedListener) {
        try {
            this.settingsListeners.addListener(iGraphSettingsChangedListener);
            return;
        }
        catch (IllegalStateException var2_2) {
            Logger.logWarning("Listener is already listening.", new Object[0]);
        }
    }

    protected void removeListener(IGraphSettingsChangedListener iGraphSettingsChangedListener) {
        try {
            this.settingsListeners.removeListener(iGraphSettingsChangedListener);
            return;
        }
        catch (IllegalStateException var2_2) {
            Logger.logWarning("Listener was not listening.", new Object[0]);
        }
    }

    @Override
    public boolean getAnimateLayout() {
        return this.layoutAnimation;
    }

    @Override
    public int getAnimateLayoutEdgeThreshold() {
        return 0;
    }

    @Override
    public int getAnimateLayoutNodeThreshold() {
        return 0;
    }

    @Override
    public boolean getAutomaticLayouting() {
        return this.autoLayouting;
    }

    public ECircularLayoutStyle getCircularLayoutStyle() {
        return this.circularLayoutStyle;
    }

    @Override
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
        return this.circularLayoutMinNodeDistance;
    }

    public long getMinimumHierarchicLayerDistance() {
        return this.hierarchicLayoutMinLayerDistance;
    }

    public long getMinimumHierarchicNodeDistance() {
        return this.hierarchicLayoutMinNodeDistance;
    }

    public long getMinimumOrthogonalNodeDistance() {
        return this.orthogonalLayoutMinNodeDistance;
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

    public void setAnimateLayout(boolean bl2) {
        if (bl2 == this.layoutAnimation) {
            return;
        }
        this.layoutAnimation = bl2;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.layoutAnimationChanged(this);
        }
    }

    public void setAutomaticLayouting(boolean bl2) {
        if (this.autoLayouting == bl2) {
            return;
        }
        this.autoLayouting = bl2;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.autoLayoutChanged(this);
        }
    }

    public void setCircularLayoutStyle(ECircularLayoutStyle eCircularLayoutStyle) {
        if (eCircularLayoutStyle == this.circularLayoutStyle) {
            return;
        }
        this.circularLayoutStyle = eCircularLayoutStyle;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.circularLayoutStyleChanged(this);
        }
    }

    public void setDefaultGraphLayout(EGraphLayout eGraphLayout) {
        if (eGraphLayout == this.defaultGraphLayout) {
            return;
        }
        this.defaultGraphLayout = eGraphLayout;
        this.updateLayouter();
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.layoutChanged(this);
        }
    }

    public void setHierarchicOrientation(ELayoutOrientation eLayoutOrientation) {
        if (eLayoutOrientation == this.hierarchicLayoutOrientation) {
            return;
        }
        this.hierarchicLayoutOrientation = eLayoutOrientation;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.hierarchicalLayoutOrientationChanged(this);
        }
    }

    public void setHierarchicOrthogonalEdgeRouting(boolean bl2) {
        if (bl2 == this.hierarchicOrthogonalEdgeRouting) {
            return;
        }
        this.hierarchicOrthogonalEdgeRouting = bl2;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.hierarchicalOrthogonalEdgeRoutingChanged(this);
        }
    }

    public void setMinimumCircularNodeDistance(int n2) {
        if (n2 == this.circularLayoutMinNodeDistance) {
            return;
        }
        this.circularLayoutMinNodeDistance = n2;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.circularLayoutMinNodeDistanceChanged(this);
        }
    }

    public void setMinimumHierarchicLayerDistance(int n2) {
        if (n2 == this.hierarchicLayoutMinLayerDistance) {
            return;
        }
        this.hierarchicLayoutMinLayerDistance = n2;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.hierarchicalLayoutMinLayerDistanceChanged(this);
        }
    }

    public void setMinimumHierarchicNodeDistance(int n2) {
        if (n2 == this.hierarchicLayoutMinNodeDistance) {
            return;
        }
        this.hierarchicLayoutMinNodeDistance = n2;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.hierarchicalLayoutMinNodeDistanceChanged(this);
        }
    }

    public void setMinimumOrthogonalNodeDistance(int n2) {
        if (n2 == this.orthogonalLayoutMinNodeDistance) {
            return;
        }
        this.orthogonalLayoutMinNodeDistance = n2;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.orthogonalLayoutMinNodeDistanceChanged(this);
        }
    }

    public void setOrthogonalLayoutOrientation(ELayoutOrientation eLayoutOrientation) {
        if (eLayoutOrientation == this.orthogonalLayoutOrientation) {
            return;
        }
        this.orthogonalLayoutOrientation = eLayoutOrientation;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.orthogonalLayoutOrientationChanged(this);
        }
    }

    public void setOrthogonalLayoutStyle(EOrthogonalLayoutStyle eOrthogonalLayoutStyle) {
        if (eOrthogonalLayoutStyle == this.orthogonalLayoutStyle) {
            return;
        }
        this.orthogonalLayoutStyle = eOrthogonalLayoutStyle;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.orthogonalLayoutStyleChanged(this);
        }
    }

    public void setVisibilityWarningThreshold(int n2) {
        if (this.visibilityWarningThreshold == n2) {
            return;
        }
        this.visibilityWarningThreshold = n2;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.visibilityWarningThresholdChanged(this);
        }
    }

    public void updateLayouter() {
        if (this.getDefaultGraphLayout() == EGraphLayout.HIERARCHICAL) {
            this.setCurrentLayouter(LayoutCreator.getHierarchicalLayout(this));
            return;
        }
        if (this.getDefaultGraphLayout() == EGraphLayout.ORTHOGONAL) {
            this.setCurrentLayouter(LayoutCreator.getOrthogonalLayout(this));
            return;
        }
        this.setCurrentLayouter(LayoutCreator.getCircularLayout(this));
    }
}

