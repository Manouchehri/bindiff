package com.google.security.zynamics.bindiff.io.matches;

import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.enums.*;

public class FunctionDiffSocketXmlData implements IReadXmlHandlerData
{
    private String matchesDBPath;
    private String priFlowgraphsPath;
    private String secFlowgraphsPath;
    private int priFlowgraphOffset;
    private int secFlowgraphOffset;
    private final Diff diff;
    
    public FunctionDiffSocketXmlData() {
        this.matchesDBPath = "";
        this.priFlowgraphsPath = "";
        this.secFlowgraphsPath = "";
        this.priFlowgraphOffset = -1;
        this.secFlowgraphOffset = -1;
        this.diff = null;
    }
    
    public FunctionDiffSocketXmlData(final Diff diff) {
        this.matchesDBPath = "";
        this.priFlowgraphsPath = "";
        this.secFlowgraphsPath = "";
        this.priFlowgraphOffset = -1;
        this.secFlowgraphOffset = -1;
        this.diff = diff;
    }
    
    public Diff getDiff() {
        return this.diff;
    }
    
    public int getFlowgraphOffset(final ESide eSide) {
        return (ESide.PRIMARY == eSide) ? this.priFlowgraphOffset : this.secFlowgraphOffset;
    }
    
    public String getFlowgraphsPath(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.priFlowgraphsPath : this.secFlowgraphsPath;
    }
    
    public String getMatchesDBPath() {
        return this.matchesDBPath;
    }
    
    public void setFlowgraphOffset(final int n, final ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.priFlowgraphOffset = n;
        }
        else {
            this.secFlowgraphOffset = n;
        }
    }
    
    public void setFlowgraphsPath(final String s, final ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.priFlowgraphsPath = s;
        }
        else {
            this.secFlowgraphsPath = s;
        }
    }
    
    public void setMatchesDBPath(final String matchesDBPath) {
        this.matchesDBPath = matchesDBPath;
    }
}
