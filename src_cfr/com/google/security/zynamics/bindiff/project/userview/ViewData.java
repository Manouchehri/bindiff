/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.userview;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.EViewType;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.types.graphs.MutableDirectedGraph;
import java.util.Date;

public abstract class ViewData {
    private final GraphsContainer graphs;
    private String viewName;
    private String viewComment;
    private Date creationDate;
    private Date modificationDate;
    private final EViewType viewType;

    public ViewData(GraphsContainer graphsContainer, String string, EViewType eViewType) {
        this.graphs = (GraphsContainer)Preconditions.checkNotNull(graphsContainer);
        this.viewName = (String)Preconditions.checkNotNull(string);
        this.viewType = eViewType;
        this.viewComment = "";
        this.creationDate = null;
        this.modificationDate = null;
    }

    public static String getViewName(GraphsContainer graphsContainer) {
        Object object;
        Diff diff = graphsContainer.getDiff();
        if (diff.isFunctionDiff()) {
            return CFileUtils.forceFilenameEndsNotWithExtension(diff.getDiffName(), "BinDiff");
        }
        IAddress iAddress = graphsContainer.getPrimaryGraph().getFunctionAddress();
        IAddress iAddress2 = graphsContainer.getSecondaryGraph().getFunctionAddress();
        String string = diff.getMetaData().getImageName(ESide.PRIMARY);
        if (iAddress != null) {
            object = diff.getFunction(iAddress, ESide.PRIMARY);
            if (object != null) {
                string = object.getName();
            }
        } else if (iAddress2 != null) {
            string = null;
        }
        object = diff.getMetaData().getImageName(ESide.SECONDARY);
        if (iAddress2 != null) {
            RawFunction rawFunction = diff.getFunction(iAddress2, ESide.SECONDARY);
            if (rawFunction != null) {
                object = rawFunction.getName();
            }
        } else if (iAddress != null) {
            object = null;
        }
        if (string != null) return string;
        return object;
    }

    public abstract IAddress getAddress(ESide var1);

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
        if (this.getAddress(ESide.PRIMARY) != null) return null;
        if (this.getAddress(ESide.SECONDARY) == null) return null;
        return EMatchState.SECONDRAY_UNMATCHED;
    }

    public Date getModificationDate() {
        return this.modificationDate;
    }

    public abstract MutableDirectedGraph getRawGraph(ESide var1);

    public String getViewComment() {
        return this.viewComment;
    }

    public String getViewName() {
        return this.viewName;
    }

    public abstract boolean isCallgraphView();

    public abstract boolean isFlowgraphView();

    public boolean isSingleFunctionDiffView() {
        if (this.viewType != EViewType.SINGLE_FUNCTION_DIFF_VIEW) return false;
        return true;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setModificationDate(Date date) {
        this.modificationDate = date;
    }

    public void setViewComment(String string) {
        this.viewComment = string;
    }

    public void setViewName(String string) {
        this.viewName = string;
    }
}

