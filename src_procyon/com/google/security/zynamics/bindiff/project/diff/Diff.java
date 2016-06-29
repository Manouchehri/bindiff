package com.google.security.zynamics.bindiff.project.diff;

import com.google.security.zynamics.zylib.general.*;
import java.io.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.log.*;
import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.io.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;

public final class Diff
{
    private final ListenerProvider listenerProvider;
    private File matchesDatabaseFile;
    private File primaryExportFile;
    private File secondaryExportFile;
    private String priExportMD5;
    private String secExportMD5;
    private final ViewManager viewManager;
    private RawCallGraph primaryCallgraph;
    private RawCallGraph secondaryCallgraph;
    private final DiffMetaData metaData;
    private final boolean isFunctionDiff;
    private MatchData matches;
    private boolean loaded;
    
    public Diff(final DiffMetaData diffMetaData, final File file, final File file2, final File file3, final boolean isFunctionDiff) {
        this.listenerProvider = new ListenerProvider();
        this.priExportMD5 = null;
        this.secExportMD5 = null;
        this.viewManager = new ViewManager();
        this.primaryCallgraph = null;
        this.secondaryCallgraph = null;
        this.loaded = false;
        this.metaData = (DiffMetaData)Preconditions.checkNotNull(diffMetaData);
        this.matchesDatabaseFile = (File)Preconditions.checkNotNull(file);
        this.primaryExportFile = (File)Preconditions.checkNotNull(file2);
        this.secondaryExportFile = (File)Preconditions.checkNotNull(file3);
        this.isFunctionDiff = isFunctionDiff;
    }
    
    private void close() {
        this.primaryCallgraph = null;
        this.secondaryCallgraph = null;
        if (this.matches != null) {
            this.matches.close();
        }
        this.loaded = false;
    }
    
    protected Diff cloneDiffObjectOnSaveAs(final File file, final File primaryExportFile, final File secondaryExportFile, final FlowGraphViewData flowGraphViewData) {
        this.viewManager.removeView(flowGraphViewData);
        final Diff diff = new Diff(this.metaData, file, primaryExportFile, secondaryExportFile, true);
        diff.primaryExportFile = primaryExportFile;
        diff.secondaryExportFile = secondaryExportFile;
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
    
    public void addListener(final IDiffListener diffListener) {
        this.listenerProvider.addListener(diffListener);
    }
    
    public void closeDiff() {
        final String diffName = this.getDiffName();
        Logger.logInfo(new StringBuilder(17 + String.valueOf(diffName).length()).append("Unloading Diff '").append(diffName).append("'").toString(), new Object[0]);
        if (this.matches == null) {
            return;
        }
        this.close();
        final Iterator iterator = this.listenerProvider.iterator();
        while (iterator.hasNext()) {
            iterator.next().unloadedDiff(this);
        }
    }
    
    public String getBinExportMD5(final ESide eSide) {
        if (this.priExportMD5 == null) {
            this.priExportMD5 = FileUtils.calcMD5(this.primaryExportFile);
        }
        if (this.secExportMD5 == null) {
            this.secExportMD5 = FileUtils.calcMD5(this.secondaryExportFile);
        }
        return (ESide.PRIMARY == eSide) ? this.priExportMD5 : this.secExportMD5;
    }
    
    public RawCallGraph getCallgraph(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.primaryCallgraph : this.secondaryCallgraph;
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
    
    public File getExportFile(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.primaryExportFile : this.secondaryExportFile;
    }
    
    public RawFunction getFunction(final IAddress address, final ESide eSide) {
        return this.getCallgraph(eSide).getFunction(address);
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
        final String diffName = this.getDiffName();
        Logger.logInfo(new StringBuilder(16 + String.valueOf(diffName).length()).append("Removing Diff '").append(diffName).append("'").toString(), new Object[0]);
        this.close();
        final Iterator iterator = this.listenerProvider.iterator();
        while (iterator.hasNext()) {
            iterator.next().unloadedDiff(this);
        }
        final Iterator iterator2 = this.listenerProvider.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().removedDiff(this);
        }
    }
    
    public void removeListener(final IDiffListener diffListener) {
        this.listenerProvider.removeListener(diffListener);
    }
    
    public void setCallgraph(final RawCallGraph rawCallGraph, final ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.primaryCallgraph = rawCallGraph;
        }
        else {
            this.secondaryCallgraph = rawCallGraph;
        }
    }
    
    public void setExportFile(final File file, final ESide eSide) {
        if (!this.isFunctionDiff()) {
            throw new UnsupportedOperationException("Unsupported operation: Export file names can only be updated if the diff is a function diff.");
        }
        if (eSide == ESide.PRIMARY) {
            this.primaryExportFile = file;
            this.priExportMD5 = null;
        }
        else {
            this.secondaryExportFile = file;
            this.secExportMD5 = null;
        }
    }
    
    public void setLoaded(final boolean loaded) {
        this.loaded = loaded;
    }
    
    public void setMatches(final MatchData matches) {
        this.matches = matches;
    }
    
    public void setMatchesDatabase(final File matchesDatabaseFile) {
        if (!this.isFunctionDiff()) {
            throw new UnsupportedOperationException("Matches database file can only be updated if the diff is a function diff.");
        }
        this.matchesDatabaseFile = matchesDatabaseFile;
    }
    
    public void willOverwriteDiff(final String s) {
        final Iterator iterator = this.listenerProvider.iterator();
        while (iterator.hasNext()) {
            iterator.next().willOverwriteDiff(s);
        }
    }
}
