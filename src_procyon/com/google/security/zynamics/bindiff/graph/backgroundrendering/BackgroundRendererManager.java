package com.google.security.zynamics.bindiff.graph.backgroundrendering;

import java.awt.*;
import y.h.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.resources.*;

public class BackgroundRendererManager
{
    private final Color COMBINED_GRADIENT_END_COLOR;
    private final GraphSettings settings;
    private final BackgroundRendererManager$InternalGraphSettingsChangedListener settingsChangedListener;
    private final ch view;
    private final ImageBackgroundRenderer imageBackgroundRenderer;
    private final GradientBackgroundRenderer gradientBackgroundRenderer;
    
    public BackgroundRendererManager(final ViewData viewData, final ch view, final EGraph eGraph, final GraphSettings graphSettings) {
        this.COMBINED_GRADIENT_END_COLOR = new Color(200, 210, 190);
        this.settingsChangedListener = new BackgroundRendererManager$InternalGraphSettingsChangedListener(this, null);
        Preconditions.checkNotNull(viewData);
        Preconditions.checkNotNull(eGraph);
        this.settings = (GraphSettings)Preconditions.checkNotNull(graphSettings);
        this.view = view;
        this.imageBackgroundRenderer = new ImageBackgroundRenderer(viewData, this.view, eGraph);
        this.gradientBackgroundRenderer = new GradientBackgroundRenderer(viewData, this.view, this.getGradientEndColor(eGraph), eGraph);
        this.settingsChangedListener.gradientBackgroundChanged(graphSettings.getDisplaySettings());
        graphSettings.addListener(this.settingsChangedListener);
    }
    
    protected static String buildTitle(final ViewData viewData, final EGraph eGraph) {
        if (viewData instanceof FlowGraphViewData) {
            final FlowGraphViewData flowGraphViewData = (FlowGraphViewData)viewData;
            switch (BackgroundRendererManager$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[eGraph.ordinal()]) {
                case 1: {
                    String string;
                    if (flowGraphViewData.getAddress(ESide.PRIMARY) == null) {
                        string = "";
                    }
                    else {
                        final String value = String.valueOf(flowGraphViewData.getAddress(ESide.PRIMARY));
                        final String functionName = flowGraphViewData.getFunctionName(ESide.PRIMARY);
                        string = new StringBuilder(3 + String.valueOf(value).length() + String.valueOf(functionName).length()).append(value).append("   ").append(functionName).toString();
                    }
                    return string;
                }
                case 2: {
                    String string2;
                    if (flowGraphViewData.getAddress(ESide.SECONDARY) == null) {
                        string2 = "";
                    }
                    else {
                        final String functionName2 = flowGraphViewData.getFunctionName(ESide.SECONDARY);
                        final String value2 = String.valueOf(flowGraphViewData.getAddress(ESide.SECONDARY));
                        string2 = new StringBuilder(3 + String.valueOf(functionName2).length() + String.valueOf(value2).length()).append(functionName2).append("   ").append(value2).toString();
                    }
                    return string2;
                }
                case 3: {
                    final String s = "%s%s%s%s%s";
                    final Object[] array = new Object[5];
                    final int n = 0;
                    String string3;
                    if (flowGraphViewData.getAddress(ESide.PRIMARY) == null) {
                        string3 = "";
                    }
                    else {
                        final String value3 = String.valueOf(flowGraphViewData.getAddress(ESide.PRIMARY));
                        string3 = new StringBuilder(3 + String.valueOf(value3).length()).append(value3).append("   ").toString();
                    }
                    array[n] = string3;
                    array[1] = ((flowGraphViewData.getFunctionName(ESide.PRIMARY) == null) ? "" : flowGraphViewData.getFunctionName(ESide.PRIMARY));
                    array[2] = ((flowGraphViewData.getAddress(ESide.PRIMARY) == null || flowGraphViewData.getAddress(ESide.SECONDARY) == null) ? "" : "   vs   ");
                    final int n2 = 3;
                    String string4;
                    if (flowGraphViewData.getAddress(ESide.SECONDARY) == null) {
                        string4 = "";
                    }
                    else {
                        final String value4 = String.valueOf(flowGraphViewData.getAddress(ESide.SECONDARY));
                        string4 = new StringBuilder(3 + String.valueOf(value4).length()).append(value4).append("   ").toString();
                    }
                    array[n2] = string4;
                    array[4] = ((flowGraphViewData.getFunctionName(ESide.SECONDARY) == null) ? "" : flowGraphViewData.getFunctionName(ESide.SECONDARY));
                    return String.format(s, array);
                }
            }
        }
        else if (viewData instanceof CallGraphViewData) {
            final CallGraphViewData callGraphViewData = (CallGraphViewData)viewData;
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
        }
        return "";
    }
    
    private Color getGradientEndColor(final EGraph eGraph) {
        switch (BackgroundRendererManager$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[eGraph.ordinal()]) {
            case 1: {
                return Colors.PRIMARY_BASE;
            }
            case 2: {
                return Colors.SECONDARY_BASE;
            }
            default: {
                return this.COMBINED_GRADIENT_END_COLOR;
            }
        }
    }
    
    public void addListeners() {
        this.settings.addListener(this.settingsChangedListener);
    }
    
    public void removeListener() {
        this.settings.removeListener(this.settingsChangedListener);
    }
}
