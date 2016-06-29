/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.GregorianCalendar;

public class FunctionDiffMetaData
extends DiffMetaData {
    private IAddress priFunctionAddr;
    private IAddress secFunctionAddr;
    private String priFunctionName;
    private String secFunctionName;
    private EFunctionType priFunctionType;
    private EFunctionType secFunctionType;
    private Integer priFlowgraphOffset;
    private Integer secFlowgraphOffset;

    public FunctionDiffMetaData(DiffMetaData diffMetaData, IAddress iAddress, IAddress iAddress2, String string, String string2, EFunctionType eFunctionType, EFunctionType eFunctionType2, Integer n2, Integer n3) {
        super(diffMetaData.getVersion(), diffMetaData.getDiffDescription(), diffMetaData.getDate(), diffMetaData.getTotalSimilarity(), diffMetaData.getTotalConfidence(), diffMetaData.getIdbName(ESide.PRIMARY), diffMetaData.getIdbName(ESide.SECONDARY), diffMetaData.getImageName(ESide.PRIMARY), diffMetaData.getImageName(ESide.SECONDARY), diffMetaData.getImageHash(ESide.PRIMARY), diffMetaData.getImageHash(ESide.SECONDARY), diffMetaData.getSimilarityIntervalCounts(), diffMetaData.getSizeOfMatchedFunctions(), diffMetaData.getSizeOfUnmatchedFunctions(ESide.PRIMARY), diffMetaData.getSizeOfUnmatchedFunctions(ESide.SECONDARY), diffMetaData.getSizeOfCalls(ESide.PRIMARY), diffMetaData.getSizeOfCalls(ESide.SECONDARY), diffMetaData.getSizeOfBasicblocks(ESide.PRIMARY), diffMetaData.getSizeOfBasicblocks(ESide.SECONDARY), diffMetaData.getSizeOfJumps(ESide.PRIMARY), diffMetaData.getSizeOfJumps(ESide.SECONDARY), diffMetaData.getSizeOfInstructions(ESide.PRIMARY), diffMetaData.getSizeOfInstructions(ESide.SECONDARY));
        this.priFunctionAddr = iAddress;
        this.secFunctionAddr = iAddress2;
        this.priFunctionName = string;
        this.secFunctionName = string2;
        this.priFunctionType = eFunctionType;
        this.secFunctionType = eFunctionType2;
        this.priFlowgraphOffset = n2;
        this.secFlowgraphOffset = n3;
    }

    public int getFlowgraphOffset(ESide eSide) {
        Integer n2;
        if (eSide == ESide.PRIMARY) {
            n2 = this.priFlowgraphOffset;
            return n2;
        }
        n2 = this.secFlowgraphOffset;
        return n2;
    }

    public IAddress getFunctionAddr(ESide eSide) {
        IAddress iAddress;
        if (eSide == ESide.PRIMARY) {
            iAddress = this.priFunctionAddr;
            return iAddress;
        }
        iAddress = this.secFunctionAddr;
        return iAddress;
    }

    public String getFunctionName(ESide eSide) {
        String string;
        if (eSide == ESide.PRIMARY) {
            string = this.priFunctionName;
            return string;
        }
        string = this.secFunctionName;
        return string;
    }

    public EFunctionType getFunctionType(ESide eSide) {
        EFunctionType eFunctionType;
        if (eSide == ESide.PRIMARY) {
            eFunctionType = this.priFunctionType;
            return eFunctionType;
        }
        eFunctionType = this.secFunctionType;
        return eFunctionType;
    }

    public void setFlowgraphOffset(int n2, ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.priFlowgraphOffset = n2;
            return;
        }
        this.secFlowgraphOffset = n2;
    }

    public void setFunctionAddr(IAddress iAddress, ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.priFunctionAddr = iAddress;
            return;
        }
        this.secFunctionAddr = iAddress;
    }

    public void setFunctionName(String string, ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.priFunctionName = string;
            return;
        }
        this.secFunctionName = string;
    }

    public void setFunctionType(EFunctionType eFunctionType, ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.priFunctionType = eFunctionType;
            return;
        }
        this.secFunctionType = eFunctionType;
    }
}

