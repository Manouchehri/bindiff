package com.google.security.zynamics.bindiff.graph.settings;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.settings.*;
import com.google.security.zynamics.bindiff.enums.*;
import y.f.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.log.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.layout.*;

public class GraphLayoutSettings implements ILayoutSettings
{
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
    private final ListenerProvider settingsListeners;
    
    public GraphLayoutSettings(final GraphViewSettingsConfigItem graphViewSettingsConfigItem) {
        this.settingsListeners = new ListenerProvider();
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
    
    private void setCurrentLayouter(final c currentLayouter) {
        Preconditions.checkNotNull(currentLayouter);
        this.currentLayouter = currentLayouter;
    }
    
    protected void addListener(final IGraphSettingsChangedListener graphSettingsChangedListener) {
        try {
            this.settingsListeners.addListener(graphSettingsChangedListener);
        }
        catch (IllegalStateException ex) {
            Logger.logWarning("Listener is already listening.", new Object[0]);
        }
    }
    
    protected void removeListener(final IGraphSettingsChangedListener graphSettingsChangedListener) {
        try {
            this.settingsListeners.removeListener(graphSettingsChangedListener);
        }
        catch (IllegalStateException ex) {
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
    
    public void setAnimateLayout(final boolean layoutAnimation) {
        if (layoutAnimation == this.layoutAnimation) {
            return;
        }
        this.layoutAnimation = layoutAnimation;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().layoutAnimationChanged(this);
        }
    }
    
    public void setAutomaticLayouting(final boolean autoLayouting) {
        if (this.autoLayouting == autoLayouting) {
            return;
        }
        this.autoLayouting = autoLayouting;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().autoLayoutChanged(this);
        }
    }
    
    public void setCircularLayoutStyle(final ECircularLayoutStyle circularLayoutStyle) {
        if (circularLayoutStyle == this.circularLayoutStyle) {
            return;
        }
        this.circularLayoutStyle = circularLayoutStyle;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().circularLayoutStyleChanged(this);
        }
    }
    
    public void setDefaultGraphLayout(final EGraphLayout defaultGraphLayout) {
        if (defaultGraphLayout == this.defaultGraphLayout) {
            return;
        }
        this.defaultGraphLayout = defaultGraphLayout;
        this.updateLayouter();
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().layoutChanged(this);
        }
    }
    
    public void setHierarchicOrientation(final ELayoutOrientation hierarchicLayoutOrientation) {
        if (hierarchicLayoutOrientation == this.hierarchicLayoutOrientation) {
            return;
        }
        this.hierarchicLayoutOrientation = hierarchicLayoutOrientation;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().hierarchicalLayoutOrientationChanged(this);
        }
    }
    
    public void setHierarchicOrthogonalEdgeRouting(final boolean hierarchicOrthogonalEdgeRouting) {
        if (hierarchicOrthogonalEdgeRouting == this.hierarchicOrthogonalEdgeRouting) {
            return;
        }
        this.hierarchicOrthogonalEdgeRouting = hierarchicOrthogonalEdgeRouting;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().hierarchicalOrthogonalEdgeRoutingChanged(this);
        }
    }
    
    public void setMinimumCircularNodeDistance(final int circularLayoutMinNodeDistance) {
        if (circularLayoutMinNodeDistance == this.circularLayoutMinNodeDistance) {
            return;
        }
        this.circularLayoutMinNodeDistance = circularLayoutMinNodeDistance;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().circularLayoutMinNodeDistanceChanged(this);
        }
    }
    
    public void setMinimumHierarchicLayerDistance(final int hierarchicLayoutMinLayerDistance) {
        if (hierarchicLayoutMinLayerDistance == this.hierarchicLayoutMinLayerDistance) {
            return;
        }
        this.hierarchicLayoutMinLayerDistance = hierarchicLayoutMinLayerDistance;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().hierarchicalLayoutMinLayerDistanceChanged(this);
        }
    }
    
    public void setMinimumHierarchicNodeDistance(final int hierarchicLayoutMinNodeDistance) {
        if (hierarchicLayoutMinNodeDistance == this.hierarchicLayoutMinNodeDistance) {
            return;
        }
        this.hierarchicLayoutMinNodeDistance = hierarchicLayoutMinNodeDistance;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().hierarchicalLayoutMinNodeDistanceChanged(this);
        }
    }
    
    public void setMinimumOrthogonalNodeDistance(final int orthogonalLayoutMinNodeDistance) {
        if (orthogonalLayoutMinNodeDistance == this.orthogonalLayoutMinNodeDistance) {
            return;
        }
        this.orthogonalLayoutMinNodeDistance = orthogonalLayoutMinNodeDistance;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().orthogonalLayoutMinNodeDistanceChanged(this);
        }
    }
    
    public void setOrthogonalLayoutOrientation(final ELayoutOrientation orthogonalLayoutOrientation) {
        if (orthogonalLayoutOrientation == this.orthogonalLayoutOrientation) {
            return;
        }
        this.orthogonalLayoutOrientation = orthogonalLayoutOrientation;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().orthogonalLayoutOrientationChanged(this);
        }
    }
    
    public void setOrthogonalLayoutStyle(final EOrthogonalLayoutStyle orthogonalLayoutStyle) {
        if (orthogonalLayoutStyle == this.orthogonalLayoutStyle) {
            return;
        }
        this.orthogonalLayoutStyle = orthogonalLayoutStyle;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().orthogonalLayoutStyleChanged(this);
        }
    }
    
    public void setVisibilityWarningThreshold(final int visibilityWarningThreshold) {
        if (this.visibilityWarningThreshold == visibilityWarningThreshold) {
            return;
        }
        this.visibilityWarningThreshold = visibilityWarningThreshold;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().visibilityWarningThresholdChanged(this);
        }
    }
    
    public void updateLayouter() {
        if (this.getDefaultGraphLayout() == EGraphLayout.HIERARCHICAL) {
            this.setCurrentLayouter(LayoutCreator.getHierarchicalLayout(this));
        }
        else if (this.getDefaultGraphLayout() == EGraphLayout.ORTHOGONAL) {
            this.setCurrentLayouter(LayoutCreator.getOrthogonalLayout(this));
        }
        else {
            this.setCurrentLayouter(LayoutCreator.getCircularLayout(this));
        }
    }
}
