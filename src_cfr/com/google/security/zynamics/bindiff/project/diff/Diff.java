/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.diff;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.IDiffListener;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewManager;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.io.File;
import java.util.Iterator;

public final class Diff {
    private final ListenerProvider listenerProvider = new ListenerProvider();
    private File matchesDatabaseFile;
    private File primaryExportFile;
    private File secondaryExportFile;
    private String priExportMD5 = null;
    private String secExportMD5 = null;
    private final ViewManager viewManager = new ViewManager();
    private RawCallGraph primaryCallgraph = null;
    private RawCallGraph secondaryCallgraph = null;
    private final DiffMetaData metaData;
    private final boolean isFunctionDiff;
    private MatchData matches;
    private boolean loaded = false;

    public Diff(DiffMetaData diffMetaData, File file, File file2, File file3, boolean bl2) {
        this.metaData = (DiffMetaData)Preconditions.checkNotNull(diffMetaData);
        this.matchesDatabaseFile = (File)Preconditions.checkNotNull(file);
        this.primaryExportFile = (File)Preconditions.checkNotNull(file2);
        this.secondaryExportFile = (File)Preconditions.checkNotNull(file3);
        this.isFunctionDiff = bl2;
    }

    private void close() {
        this.primaryCallgraph = null;
        this.secondaryCallgraph = null;
        if (this.matches != null) {
            this.matches.close();
        }
        this.loaded = false;
    }

    protected Diff cloneDiffObjectOnSaveAs(File file, File file2, File file3, FlowGraphViewData flowGraphViewData) {
        this.viewManager.removeView(flowGraphViewData);
        Diff diff = new Diff(this.metaData, file, file2, file3, true);
        diff.primaryExportFile = file2;
        diff.secondaryExportFile = file3;
        diff.priExportMD5 = this.priExportMD5;
        diff.secExportMD5 = this.secExportMD5;
        diff.loaded = this.loaded;
        diff.viewManager.addView(flowGraphViewData);
        diff.primaryCallgraph = this.primaryCallgraph;
        diff.secondaryCallgraph = this.secondaryCallgraph;
        diff.matches = this.matches;
        flowGraphViewData.setViewName(CFileUtils.forceFilenameEndsNotWithExtension(file.getName(), "BinDiff"));
        flowGraphViewData.getGraphs().setDiff(diff);
        return diff;
    }

    public void addListener(IDiffListener iDiffListener) {
        this.listenerProvider.addListener(iDiffListener);
    }

    public void closeDiff() {
        Object object = this.getDiffName();
        Logger.logInfo(new StringBuilder(17 + String.valueOf(object).length()).append("Unloading Diff '").append((String)object).append("'").toString(), new Object[0]);
        if (this.matches == null) {
            return;
        }
        this.close();
        object = this.listenerProvider.iterator();
        while (object.hasNext()) {
            IDiffListener iDiffListener = (IDiffListener)object.next();
            iDiffListener.unloadedDiff(this);
        }
    }

    public String getBinExportMD5(ESide eSide) {
        String string;
        if (this.priExportMD5 == null) {
            this.priExportMD5 = FileUtils.calcMD5(this.primaryExportFile);
        }
        if (this.secExportMD5 == null) {
            this.secExportMD5 = FileUtils.calcMD5(this.secondaryExportFile);
        }
        if (ESide.PRIMARY == eSide) {
            string = this.priExportMD5;
            return string;
        }
        string = this.secExportMD5;
        return string;
    }

    public RawCallGraph getCallgraph(ESide eSide) {
        RawCallGraph rawCallGraph;
        if (eSide == ESide.PRIMARY) {
            rawCallGraph = this.primaryCallgraph;
            return rawCallGraph;
        }
        rawCallGraph = this.secondaryCallgraph;
        return rawCallGraph;
    }

    public String getDiffFolder() {
        return this.getMatchesDatabase().getParent();
    }

    public DiffMetaData getDiffMetaData() {
        return this.metaData;
    }

    public String getDiffName() {
        return this.matchesDatabaseFile.getName();
    }

    public File getExportFile(ESide eSide) {
        File file;
        if (eSide == ESide.PRIMARY) {
            file = this.primaryExportFile;
            return file;
        }
        file = this.secondaryExportFile;
        return file;
    }

    public RawFunction getFunction(IAddress iAddress, ESide eSide) {
        return this.getCallgraph(eSide).getFunction(iAddress);
    }

    public ListenerProvider getListener() {
        return this.listenerProvider;
    }

    public MatchData getMatches() {
        return this.matches;
    }

    public File getMatchesDatabase() {
        return this.matchesDatabaseFile;
    }

    public DiffMetaData getMetaData() {
        return this.metaData;
    }

    public ViewManager getViewManager() {
        return this.viewManager;
    }

    public boolean isFunctionDiff() {
        return this.isFunctionDiff;
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public void removeDiff() {
        Object object = this.getDiffName();
        Logger.logInfo(new StringBuilder(16 + String.valueOf(object).length()).append("Removing Diff '").append((String)object).append("'").toString(), new Object[0]);
        this.close();
        for (IDiffListener iDiffListener2 : this.listenerProvider) {
            iDiffListener2.unloadedDiff(this);
        }
        object = this.listenerProvider.iterator();
        while (object.hasNext()) {
            IDiffListener iDiffListener2;
            iDiffListener2 = (IDiffListener)object.next();
            iDiffListener2.removedDiff(this);
        }
    }

    public void removeListener(IDiffListener iDiffListener) {
        this.listenerProvider.removeListener(iDiffListener);
    }

    public void setCallgraph(RawCallGraph rawCallGraph, ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.primaryCallgraph = rawCallGraph;
            return;
        }
        this.secondaryCallgraph = rawCallGraph;
    }

    public void setExportFile(File file, ESide eSide) {
        if (!this.isFunctionDiff()) {
            throw new UnsupportedOperationException("Unsupported operation: Export file names can only be updated if the diff is a function diff.");
        }
        if (eSide == ESide.PRIMARY) {
            this.primaryExportFile = file;
            this.priExportMD5 = null;
            return;
        }
        this.secondaryExportFile = file;
        this.secExportMD5 = null;
    }

    public void setLoaded(boolean bl2) {
        this.loaded = bl2;
    }

    public void setMatches(MatchData matchData) {
        this.matches = matchData;
    }

    public void setMatchesDatabase(File file) {
        if (!this.isFunctionDiff()) {
            throw new UnsupportedOperationException("Matches database file can only be updated if the diff is a function diff.");
        }
        this.matchesDatabaseFile = file;
    }

    public void willOverwriteDiff(String string) {
        Iterator iterator = this.listenerProvider.iterator();
        while (iterator.hasNext()) {
            IDiffListener iDiffListener = (IDiffListener)iterator.next();
            iDiffListener.willOverwriteDiff(string);
        }
    }
}

