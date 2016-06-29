/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.BackgroundRendererManager$1;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.BackgroundRendererManager$InternalGraphSettingsChangedListener;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.GradientBackgroundRenderer;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.ImageBackgroundRenderer;
import com.google.security.zynamics.bindiff.graph.settings.GraphDisplaySettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.graph.settings.IGraphSettingsChangedListener;
import com.google.security.zynamics.bindiff.project.userview.CallGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.Color;
import y.h.ch;

public class BackgroundRendererManager {
    private final Color COMBINED_GRADIENT_END_COLOR = new Color(200, 210, 190);
    private final GraphSettings settings;
    private final BackgroundRendererManager$InternalGraphSettingsChangedListener settingsChangedListener;
    private final ch view;
    private final ImageBackgroundRenderer imageBackgroundRenderer;
    private final GradientBackgroundRenderer gradientBackgroundRenderer;

    public BackgroundRendererManager(ViewData viewData, ch ch2, EGraph eGraph, GraphSettings graphSettings) {
        this.settingsChangedListener = new BackgroundRendererManager$InternalGraphSettingsChangedListener(this, null);
        Preconditions.checkNotNull(viewData);
        Preconditions.checkNotNull((Object)eGraph);
        this.settings = (GraphSettings)Preconditions.checkNotNull(graphSettings);
        this.view = ch2;
        this.imageBackgroundRenderer = new ImageBackgroundRenderer(viewData, this.view, eGraph);
        this.gradientBackgroundRenderer = new GradientBackgroundRenderer(viewData, this.view, this.getGradientEndColor(eGraph), eGraph);
        this.settingsChangedListener.gradientBackgroundChanged(graphSettings.getDisplaySettings());
        graphSettings.addListener(this.settingsChangedListener);
    }

    protected static String buildTitle(ViewData viewData, EGraph eGraph) {
        if (viewData instanceof FlowGraphViewData) {
            FlowGraphViewData flowGraphViewData = (FlowGraphViewData)viewData;
            switch (BackgroundRendererManager$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[eGraph.ordinal()]) {
                case 1: {
                    if (flowGraphViewData.getAddress(ESide.PRIMARY) == null) {
                        return "";
                    }
                    String string = String.valueOf(flowGraphViewData.getAddress(ESide.PRIMARY));
                    String string2 = flowGraphViewData.getFunctionName(ESide.PRIMARY);
                    String string3 = new StringBuilder(3 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append("   ").append(string2).toString();
                    return string3;
                }
                case 2: {
                    if (flowGraphViewData.getAddress(ESide.SECONDARY) == null) {
                        return "";
                    }
                    String string = flowGraphViewData.getFunctionName(ESide.SECONDARY);
                    String string4 = String.valueOf(flowGraphViewData.getAddress(ESide.SECONDARY));
                    String string5 = new StringBuilder(3 + String.valueOf(string).length() + String.valueOf(string4).length()).append(string).append("   ").append(string4).toString();
                    return string5;
                }
                case 3: {
                    String string;
                    String string6;
                    String string7;
                    Object[] arrobject = new Object[5];
                    if (flowGraphViewData.getAddress(ESide.PRIMARY) == null) {
                        string6 = "";
                    } else {
                        string = String.valueOf(flowGraphViewData.getAddress(ESide.PRIMARY));
                        string6 = new StringBuilder(3 + String.valueOf(string).length()).append(string).append("   ").toString();
                    }
                    arrobject[0] = string6;
                    arrobject[1] = flowGraphViewData.getFunctionName(ESide.PRIMARY) == null ? "" : flowGraphViewData.getFunctionName(ESide.PRIMARY);
                    Object object = (v162068)[2] = flowGraphViewData.getAddress(ESide.PRIMARY) == null || flowGraphViewData.getAddress(ESide.SECONDARY) == null ? "" : "   vs   ";
                    if (flowGraphViewData.getAddress(ESide.SECONDARY) == null) {
                        string7 = "";
                    } else {
                        string = String.valueOf(flowGraphViewData.getAddress(ESide.SECONDARY));
                        string7 = new StringBuilder(3 + String.valueOf(string).length()).append(string).append("   ").toString();
                    }
                    arrobject[3] = string7;
                    arrobject[4] = flowGraphViewData.getFunctionName(ESide.SECONDARY) == null ? "" : flowGraphViewData.getFunctionName(ESide.SECONDARY);
                    return String.format("%s%s%s%s%s", arrobject);
                }
            }
            return "";
        }
        if (!(viewData instanceof CallGraphViewData)) return "";
        CallGraphViewData callGraphViewData = (CallGraphViewData)viewData;
        switch (BackgroundRendererManager$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[eGraph.ordinal()]) {
            case 1: {
                return callGraphViewData.getImageName(ESide.PRIMARY);
            }
            case 2: {
                return callGraphViewData.getImageName(ESide.SECONDARY);
            }
            case 3: {
                return String.format("%s vs %s", callGraphViewData.getImageName(ESide.PRIMARY), callGraphViewData.getImageName(ESide.SECONDARY));
            }
        }
        return "";
    }

    private Color getGradientEndColor(EGraph eGraph) {
        switch (eGraph) {
            case PRIMARY_GRAPH: {
                return Colors.PRIMARY_BASE;
            }
            case SECONDARY_GRAPH: {
                return Colors.SECONDARY_BASE;
            }
        }
        return this.COMBINED_GRADIENT_END_COLOR;
    }

    public void addListeners() {
        this.settings.addListener(this.settingsChangedListener);
    }

    public void removeListener() {
        this.settings.removeListener(this.settingsChangedListener);
    }

    static /* synthetic */ GradientBackgroundRenderer access$100(BackgroundRendererManager backgroundRendererManager) {
        return backgroundRendererManager.gradientBackgroundRenderer;
    }

    static /* synthetic */ ImageBackgroundRenderer access$200(BackgroundRendererManager backgroundRendererManager) {
        return backgroundRendererManager.imageBackgroundRenderer;
    }

    static /* synthetic */ ch access$300(BackgroundRendererManager backgroundRendererManager) {
        return backgroundRendererManager.view;
    }
}

