package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.enums.*;

public class FunctionDiffMetaData extends DiffMetaData
{
    private IAddress priFunctionAddr;
    private IAddress secFunctionAddr;
    private String priFunctionName;
    private String secFunctionName;
    private EFunctionType priFunctionType;
    private EFunctionType secFunctionType;
    private Integer priFlowgraphOffset;
    private Integer secFlowgraphOffset;
    
    public FunctionDiffMetaData(final DiffMetaData diffMetaData, final IAddress priFunctionAddr, final IAddress secFunctionAddr, final String priFunctionName, final String secFunctionName, final EFunctionType priFunctionType, final EFunctionType secFunctionType, final Integer priFlowgraphOffset, final Integer secFlowgraphOffset) {
        super(diffMetaData.getVersion(), diffMetaData.getDiffDescription(), diffMetaData.getDate(), diffMetaData.getTotalSimilarity(), diffMetaData.getTotalConfidence(), diffMetaData.getIdbName(ESide.PRIMARY), diffMetaData.getIdbName(ESide.SECONDARY), diffMetaData.getImageName(ESide.PRIMARY), diffMetaData.getImageName(ESide.SECONDARY), diffMetaData.getImageHash(ESide.PRIMARY), diffMetaData.getImageHash(ESide.SECONDARY), diffMetaData.getSimilarityIntervalCounts(), diffMetaData.getSizeOfMatchedFunctions(), diffMetaData.getSizeOfUnmatchedFunctions(ESide.PRIMARY), diffMetaData.getSizeOfUnmatchedFunctions(ESide.SECONDARY), diffMetaData.getSizeOfCalls(ESide.PRIMARY), diffMetaData.getSizeOfCalls(ESide.SECONDARY), diffMetaData.getSizeOfBasicblocks(ESide.PRIMARY), diffMetaData.getSizeOfBasicblocks(ESide.SECONDARY), diffMetaData.getSizeOfJumps(ESide.PRIMARY), diffMetaData.getSizeOfJumps(ESide.SECONDARY), diffMetaData.getSizeOfInstructions(ESide.PRIMARY), diffMetaData.getSizeOfInstructions(ESide.SECONDARY));
        this.priFunctionAddr = priFunctionAddr;
        this.secFunctionAddr = secFunctionAddr;
        this.priFunctionName = priFunctionName;
        this.secFunctionName = secFunctionName;
        this.priFunctionType = priFunctionType;
        this.secFunctionType = secFunctionType;
        this.priFlowgraphOffset = priFlowgraphOffset;
        this.secFlowgraphOffset = secFlowgraphOffset;
    }
    
    public int getFlowgraphOffset(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.priFlowgraphOffset : this.secFlowgraphOffset;
    }
    
    public IAddress getFunctionAddr(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.priFunctionAddr : this.secFunctionAddr;
    }
    
    public String getFunctionName(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.priFunctionName : this.secFunctionName;
    }
    
    public EFunctionType getFunctionType(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.priFunctionType : this.secFunctionType;
    }
    
    public void setFlowgraphOffset(final int n, final ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.priFlowgraphOffset = n;
        }
        else {
            this.secFlowgraphOffset = n;
        }
    }
    
    public void setFunctionAddr(final IAddress address, final ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.priFunctionAddr = address;
        }
        else {
            this.secFunctionAddr = address;
        }
    }
    
    public void setFunctionName(final String s, final ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.priFunctionName = s;
        }
        else {
            this.secFunctionName = s;
        }
    }
    
    public void setFunctionType(final EFunctionType eFunctionType, final ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.priFunctionType = eFunctionType;
        }
        else {
            this.secFunctionType = eFunctionType;
        }
    }
}
