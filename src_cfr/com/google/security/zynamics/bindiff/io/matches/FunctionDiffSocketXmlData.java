/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.io.matches;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.io.matches.IReadXmlHandlerData;
import com.google.security.zynamics.bindiff.project.diff.Diff;

public class FunctionDiffSocketXmlData
implements IReadXmlHandlerData {
    private String matchesDBPath = "";
    private String priFlowgraphsPath = "";
    private String secFlowgraphsPath = "";
    private int priFlowgraphOffset = -1;
    private int secFlowgraphOffset = -1;
    private final Diff diff;

    public FunctionDiffSocketXmlData() {
        this.diff = null;
    }

    public FunctionDiffSocketXmlData(Diff diff) {
        this.diff = diff;
    }

    public Diff getDiff() {
        return this.diff;
    }

    public int getFlowgraphOffset(ESide eSide) {
        int n2;
        if (ESide.PRIMARY == eSide) {
            n2 = this.priFlowgraphOffset;
            return n2;
        }
        n2 = this.secFlowgraphOffset;
        return n2;
    }

    public String getFlowgraphsPath(ESide eSide) {
        String string;
        if (eSide == ESide.PRIMARY) {
            string = this.priFlowgraphsPath;
            return string;
        }
        string = this.secFlowgraphsPath;
        return string;
    }

    public String getMatchesDBPath() {
        return this.matchesDBPath;
    }

    public void setFlowgraphOffset(int n2, ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.priFlowgraphOffset = n2;
            return;
        }
        this.secFlowgraphOffset = n2;
    }

    public void setFlowgraphsPath(String string, ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.priFlowgraphsPath = string;
            return;
        }
        this.secFlowgraphsPath = string;
    }

    public void setMatchesDBPath(String string) {
        this.matchesDBPath = string;
    }
}

