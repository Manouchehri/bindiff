package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;
import com.google.security.zynamics.bindiff.utils.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

class CallGraphsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener extends DiffChangeAdapter
{
    final /* synthetic */ CallGraphsTreeNodeContextPanel this$0;
    
    private CallGraphsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener(final CallGraphsTreeNodeContextPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void basicblocksCountChanged() {
        final MatchData matches = this.this$0.diff.getMatches();
        final int sizeOfMatchedBasicblocks = matches.getSizeOfMatchedBasicblocks();
        final int sizeOfUnmatchedBasicblocks = matches.getSizeOfUnmatchedBasicblocks(ESide.PRIMARY);
        final int sizeOfUnmatchedBasicblocks2 = matches.getSizeOfUnmatchedBasicblocks(ESide.SECONDARY);
        this.this$0.primaryBasicblocks.updateData(sizeOfMatchedBasicblocks, sizeOfUnmatchedBasicblocks);
        this.this$0.secondaryBasicblocks.updateData(sizeOfMatchedBasicblocks, sizeOfUnmatchedBasicblocks2);
    }
    
    @Override
    public void callsCountChanged() {
        final MatchData matches = this.this$0.diff.getMatches();
        final int sizeOfMatchedCalls = matches.getSizeOfMatchedCalls();
        final int sizeOfChangedCalls = matches.getSizeOfChangedCalls();
        final int sizeOfUnmatchedCalls = matches.getSizeOfUnmatchedCalls(ESide.PRIMARY);
        final int sizeOfUnmatchedCalls2 = matches.getSizeOfUnmatchedCalls(ESide.SECONDARY);
        this.this$0.primaryCalls.updateData(sizeOfMatchedCalls, sizeOfChangedCalls, sizeOfUnmatchedCalls);
        this.this$0.secondaryCalls.updateData(sizeOfMatchedCalls, sizeOfChangedCalls, sizeOfUnmatchedCalls2);
    }
    
    @Override
    public void functionsCountChanged() {
        final MatchData matches = this.this$0.diff.getMatches();
        final int sizeOfMatchedFunctions = matches.getSizeOfMatchedFunctions();
        final int sizeOfChangedFunctions = matches.getSizeOfChangedFunctions();
        final int sizeOfUnmatchedFunctions = matches.getSizeOfUnmatchedFunctions(ESide.PRIMARY);
        final int sizeOfUnmatchedFunctions2 = matches.getSizeOfUnmatchedFunctions(ESide.SECONDARY);
        this.this$0.primaryFunctions.updateData(sizeOfMatchedFunctions, sizeOfChangedFunctions, sizeOfUnmatchedFunctions);
        this.this$0.secondaryFunctions.updateData(sizeOfMatchedFunctions, sizeOfChangedFunctions, sizeOfUnmatchedFunctions2);
    }
    
    @Override
    public void instructionsCountsChanged() {
        final MatchData matches = this.this$0.diff.getMatches();
        final int sizeOfMatchedInstructions = matches.getSizeOfMatchedInstructions();
        final int sizeOfUnmatchedInstructions = matches.getSizeOfUnmatchedInstructions(ESide.PRIMARY);
        final int sizeOfUnmatchedInstructions2 = matches.getSizeOfUnmatchedInstructions(ESide.SECONDARY);
        this.this$0.primaryInstructions.updateData(sizeOfMatchedInstructions, sizeOfUnmatchedInstructions);
        this.this$0.secondaryInstructions.updateData(sizeOfMatchedInstructions, sizeOfUnmatchedInstructions2);
    }
    
    @Override
    public void jumpsCountChanged() {
        final MatchData matches = this.this$0.diff.getMatches();
        final int sizeOfMatchedJumps = matches.getSizeOfMatchedJumps();
        final int sizeOfUnmatchedJumps = matches.getSizeOfUnmatchedJumps(ESide.PRIMARY);
        final int sizeOfUnmatchedJumps2 = matches.getSizeOfUnmatchedJumps(ESide.SECONDARY);
        this.this$0.primaryJumps.updateData(sizeOfMatchedJumps, sizeOfUnmatchedJumps);
        this.this$0.secondaryJumps.updateData(sizeOfMatchedJumps, sizeOfUnmatchedJumps2);
    }
}
