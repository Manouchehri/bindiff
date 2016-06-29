package com.google.security.zynamics.bindiff.project.userview;

import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.types.graphs.*;

public abstract class ViewData
{
    private final GraphsContainer graphs;
    private String viewName;
    private String viewComment;
    private Date creationDate;
    private Date modificationDate;
    private final EViewType viewType;
    
    public ViewData(final GraphsContainer graphsContainer, final String s, final EViewType viewType) {
        this.graphs = (GraphsContainer)Preconditions.checkNotNull(graphsContainer);
        this.viewName = (String)Preconditions.checkNotNull(s);
        this.viewType = viewType;
        this.viewComment = "";
        this.creationDate = null;
        this.modificationDate = null;
    }
    
    public static String getViewName(final GraphsContainer graphsContainer) {
        final Diff diff = graphsContainer.getDiff();
        if (diff.isFunctionDiff()) {
            return CFileUtils.forceFilenameEndsNotWithExtension(diff.getDiffName(), "BinDiff");
        }
        final IAddress functionAddress = graphsContainer.getPrimaryGraph().getFunctionAddress();
        final IAddress functionAddress2 = graphsContainer.getSecondaryGraph().getFunctionAddress();
        String s = diff.getMetaData().getImageName(ESide.PRIMARY);
        if (functionAddress != null) {
            final RawFunction function = diff.getFunction(functionAddress, ESide.PRIMARY);
            if (function != null) {
                s = function.getName();
            }
        }
        else if (functionAddress2 != null) {
            s = null;
        }
        String s2 = diff.getMetaData().getImageName(ESide.SECONDARY);
        if (functionAddress2 != null) {
            final RawFunction function2 = diff.getFunction(functionAddress2, ESide.SECONDARY);
            if (function2 != null) {
                s2 = function2.getName();
            }
        }
        else if (functionAddress != null) {
            s2 = null;
        }
        if (s == null) {
            return s2;
        }
        if (s2 == null) {
            return s;
        }
        return String.format("%s vs %s", s, s2);
    }
    
    public abstract IAddress getAddress(final ESide p0);
    
    public Date getCreationDate() {
        return this.creationDate;
    }
    
    public GraphsContainer getGraphs() {
        return this.graphs;
    }
    
    public EMatchState getMatchState() {
        if (this.isCallgraphView()) {
            return null;
        }
        if (this.getAddress(ESide.PRIMARY) != null && this.getAddress(ESide.SECONDARY) != null) {
            return EMatchState.MATCHED;
        }
        if (this.getAddress(ESide.PRIMARY) != null && this.getAddress(ESide.SECONDARY) == null) {
            return EMatchState.PRIMARY_UNMATCHED;
        }
        if (this.getAddress(ESide.PRIMARY) == null && this.getAddress(ESide.SECONDARY) != null) {
            return EMatchState.SECONDRAY_UNMATCHED;
        }
        return null;
    }
    
    public Date getModificationDate() {
        return this.modificationDate;
    }
    
    public abstract MutableDirectedGraph getRawGraph(final ESide p0);
    
    public String getViewComment() {
        return this.viewComment;
    }
    
    public String getViewName() {
        return this.viewName;
    }
    
    public abstract boolean isCallgraphView();
    
    public abstract boolean isFlowgraphView();
    
    public boolean isSingleFunctionDiffView() {
        return this.viewType == EViewType.SINGLE_FUNCTION_DIFF_VIEW;
    }
    
    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }
    
    public void setModificationDate(final Date modificationDate) {
        this.modificationDate = modificationDate;
    }
    
    public void setViewComment(final String viewComment) {
        this.viewComment = viewComment;
    }
    
    public void setViewName(final String viewName) {
        this.viewName = viewName;
    }
}
