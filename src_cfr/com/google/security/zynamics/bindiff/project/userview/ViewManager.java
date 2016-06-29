/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.userview;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.CallGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ViewManager {
    private final Set views = new HashSet();

    public void addView(ViewData viewData) {
        this.views.add(viewData);
    }

    public boolean containsView(IAddress iAddress, IAddress iAddress2) {
        ViewData viewData;
        Iterator iterator = this.views.iterator();
        do {
            if (!iterator.hasNext()) return false;
            viewData = (ViewData)iterator.next();
            if (!viewData.isFlowgraphView()) continue;
            FlowGraphViewData flowGraphViewData = (FlowGraphViewData)viewData;
            boolean bl2 = iAddress == null && flowGraphViewData.getRawGraph(ESide.PRIMARY) == null;
            IAddress iAddress3 = null;
            if (flowGraphViewData.getRawGraph(ESide.PRIMARY) != null) {
                iAddress3 = flowGraphViewData.getRawGraph(ESide.PRIMARY).getAddress();
            }
            if (iAddress != null && iAddress3 != null) {
                bl2 = iAddress.equals(iAddress3);
            }
            boolean bl3 = iAddress2 == null && flowGraphViewData.getRawGraph(ESide.SECONDARY) == null;
            IAddress iAddress4 = null;
            if (flowGraphViewData.getRawGraph(ESide.SECONDARY) != null) {
                iAddress4 = flowGraphViewData.getRawGraph(ESide.SECONDARY).getAddress();
            }
            if (iAddress2 != null && iAddress4 != null) {
                bl3 = iAddress2.equals(iAddress4);
            }
            if (!bl2 || !bl3) continue;
            return true;
        } while (!viewData.isCallgraphView() || viewData.getAddress(ESide.PRIMARY) != null || iAddress != null || viewData.getAddress(ESide.SECONDARY) != null || iAddress2 != null);
        return true;
    }

    public CallGraphViewData getCallgraphViewData(Diff diff) {
        CallGraphViewData callGraphViewData;
        Iterator iterator = this.getCallgraphViewsData().iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while ((callGraphViewData = (CallGraphViewData)iterator.next()).getGraphs().getDiff() != diff);
        return callGraphViewData;
    }

    public List getCallgraphViewsData() {
        ArrayList<CallGraphViewData> arrayList = new ArrayList<CallGraphViewData>();
        Iterator iterator = this.views.iterator();
        while (iterator.hasNext()) {
            ViewData viewData = (ViewData)iterator.next();
            if (!(viewData instanceof CallGraphViewData)) continue;
            arrayList.add((CallGraphViewData)viewData);
        }
        return arrayList;
    }

    /*
     * Unable to fully structure code
     */
    public FlowGraphViewData getFlowgraphViewData(IAddress var1_1, IAddress var2_2) {
        var3_3 = this.views.iterator();
        do lbl-1000: // 3 sources:
        {
            if (var3_3.hasNext() == false) return null;
            var4_4 = (ViewData)var3_3.next();
            if (!var4_4.isFlowgraphView() || var4_4.getMatchState() != EMatchState.MATCHED) ** GOTO lbl-1000
            var5_5 = (FlowGraphViewData)var4_4;
            var6_6 = var5_5.getAddress(ESide.PRIMARY);
            var7_7 = var5_5.getAddress(ESide.SECONDARY);
        } while (!var6_6.equals(var1_1) || !var7_7.equals(var2_2));
        return var5_5;
    }

    public List getFlowgraphViewsData() {
        ArrayList<FlowGraphViewData> arrayList = new ArrayList<FlowGraphViewData>();
        Iterator iterator = this.views.iterator();
        while (iterator.hasNext()) {
            ViewData viewData = (ViewData)iterator.next();
            if (!(viewData instanceof FlowGraphViewData)) continue;
            arrayList.add((FlowGraphViewData)viewData);
        }
        return arrayList;
    }

    public void removeView(ViewData viewData) {
        this.views.remove(viewData);
    }
}

