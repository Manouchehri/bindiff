package com.google.security.zynamics.bindiff.project.userview;

import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;

public class ViewManager
{
    private final Set views;
    
    public ViewManager() {
        this.views = new HashSet();
    }
    
    public void addView(final ViewData viewData) {
        this.views.add(viewData);
    }
    
    public boolean containsView(final IAddress address, final IAddress address2) {
        for (final ViewData viewData : this.views) {
            if (viewData.isFlowgraphView()) {
                final FlowGraphViewData flowGraphViewData = (FlowGraphViewData)viewData;
                boolean equals = address == null && flowGraphViewData.getRawGraph(ESide.PRIMARY) == null;
                Object address3 = null;
                if (flowGraphViewData.getRawGraph(ESide.PRIMARY) != null) {
                    address3 = flowGraphViewData.getRawGraph(ESide.PRIMARY).getAddress();
                }
                if (address != null && address3 != null) {
                    equals = address.equals(address3);
                }
                boolean equals2 = address2 == null && flowGraphViewData.getRawGraph(ESide.SECONDARY) == null;
                Object address4 = null;
                if (flowGraphViewData.getRawGraph(ESide.SECONDARY) != null) {
                    address4 = flowGraphViewData.getRawGraph(ESide.SECONDARY).getAddress();
                }
                if (address2 != null && address4 != null) {
                    equals2 = address2.equals(address4);
                }
                if (equals && equals2) {
                    return true;
                }
            }
            if (viewData.isCallgraphView() && viewData.getAddress(ESide.PRIMARY) == null && address == null && viewData.getAddress(ESide.SECONDARY) == null && address2 == null) {
                return true;
            }
        }
        return false;
    }
    
    public CallGraphViewData getCallgraphViewData(final Diff diff) {
        for (final CallGraphViewData callGraphViewData : this.getCallgraphViewsData()) {
            if (callGraphViewData.getGraphs().getDiff() == diff) {
                return callGraphViewData;
            }
        }
        return null;
    }
    
    public List getCallgraphViewsData() {
        final ArrayList<CallGraphViewData> list = new ArrayList<CallGraphViewData>();
        for (final ViewData viewData : this.views) {
            if (viewData instanceof CallGraphViewData) {
                list.add((CallGraphViewData)viewData);
            }
        }
        return list;
    }
    
    public FlowGraphViewData getFlowgraphViewData(final IAddress address, final IAddress address2) {
        for (final ViewData viewData : this.views) {
            if (viewData.isFlowgraphView() && viewData.getMatchState() == EMatchState.MATCHED) {
                final FlowGraphViewData flowGraphViewData = (FlowGraphViewData)viewData;
                final IAddress address3 = flowGraphViewData.getAddress(ESide.PRIMARY);
                final IAddress address4 = flowGraphViewData.getAddress(ESide.SECONDARY);
                if (address3.equals(address) && address4.equals(address2)) {
                    return flowGraphViewData;
                }
                continue;
            }
        }
        return null;
    }
    
    public List getFlowgraphViewsData() {
        final ArrayList<FlowGraphViewData> list = new ArrayList<FlowGraphViewData>();
        for (final ViewData viewData : this.views) {
            if (viewData instanceof FlowGraphViewData) {
                list.add((FlowGraphViewData)viewData);
            }
        }
        return list;
    }
    
    public void removeView(final ViewData viewData) {
        this.views.remove(viewData);
    }
}
