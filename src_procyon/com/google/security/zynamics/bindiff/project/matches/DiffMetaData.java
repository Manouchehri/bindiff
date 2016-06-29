package com.google.security.zynamics.bindiff.project.matches;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.log.*;
import java.text.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.date.*;
import com.google.common.base.*;
import java.util.*;

public class DiffMetaData
{
    private final String version;
    private final String description;
    private final String primaryIdbName;
    private final String secondaryIdbName;
    private final String primaryImageName;
    private final String secondaryImageName;
    private final String primaryHash;
    private final String secondaryHash;
    private String primaryArchitectureName;
    private String secondaryArchitectureName;
    private int primaryMaxMnemonicLen;
    private int secondaryMaxMnemonicLen;
    private final GregorianCalendar date;
    private final double totalSimilarity;
    private final double totalConfidence;
    private final int[] similarityIntervalCounts;
    private int matchedFunctions;
    private int changedFunctions;
    private final int priFunctions;
    private final int secFunctions;
    private int matchedCalls;
    private int changedCalls;
    private final int priCalls;
    private final int secCalls;
    private final int priBasicblocks;
    private final int secBasicblocks;
    private final int priJumps;
    private final int secJumps;
    private final int priInstructions;
    private final int secInstructions;
    private int matchedBasicblocks;
    private int matchedJumps;
    private int matchedInstrutions;
    private int priAddressSpace;
    private int secAddressSpace;
    private final ListenerProvider listeners;
    
    public DiffMetaData(final String version, final String description, final GregorianCalendar date, final double totalSimilarity, final double totalConfidence, final String primaryIdbName, final String secondaryIdbName, final String primaryImageName, final String secondaryImageName, final String primaryHash, final String secondaryHash, final int[] similarityIntervalCounts, final int matchedFunctions, final int priFunctions, final int secFunctions, final int priCalls, final int secCalls, final int priBasicblocks, final int secBasicblocks, final int priJumps, final int secJumps, final int priInstructions, final int secInstructions) {
        this.listeners = new ListenerProvider();
        this.version = version;
        this.description = description;
        this.primaryIdbName = primaryIdbName;
        this.secondaryIdbName = secondaryIdbName;
        this.primaryImageName = primaryImageName;
        this.secondaryImageName = secondaryImageName;
        this.primaryHash = primaryHash;
        this.secondaryHash = secondaryHash;
        this.date = date;
        this.totalSimilarity = totalSimilarity;
        this.totalConfidence = totalConfidence;
        this.similarityIntervalCounts = similarityIntervalCounts;
        this.matchedFunctions = matchedFunctions;
        this.priFunctions = priFunctions;
        this.secFunctions = secFunctions;
        this.priCalls = priCalls;
        this.secCalls = secCalls;
        this.priBasicblocks = priBasicblocks;
        this.secBasicblocks = secBasicblocks;
        this.priJumps = priJumps;
        this.secJumps = secJumps;
        this.priInstructions = priInstructions;
        this.secInstructions = secInstructions;
        this.priAddressSpace = 0;
        this.secAddressSpace = 0;
        this.changedFunctions = 0;
        this.matchedCalls = 0;
        this.changedCalls = 0;
    }
    
    public static GregorianCalendar dbDateStringToCalendar(final String s) {
        final GregorianCalendar gregorianCalendar = new GregorianCalendar();
        try {
            gregorianCalendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s));
        }
        catch (ParseException ex) {
            Logger.logException(ex);
        }
        return gregorianCalendar;
    }
    
    public void addListener(final ICountsChangeListener countsChangeListener) {
        this.listeners.addListener(countsChangeListener);
    }
    
    public int getAddressSpace(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.priAddressSpace : this.secAddressSpace;
    }
    
    public String getArchitectureName(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.primaryArchitectureName : this.secondaryArchitectureName;
    }
    
    public GregorianCalendar getDate() {
        return this.date;
    }
    
    public String getDateString() {
        return DateHelpers.formatDate(this.date.getTime(), 2, Locale.getDefault());
    }
    
    public String getDiffDescription() {
        return this.description;
    }
    
    public String getIdbName(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.primaryIdbName : this.secondaryIdbName;
    }
    
    public String getImageHash(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.primaryHash : this.secondaryHash;
    }
    
    public String getImageName(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.primaryImageName : this.secondaryImageName;
    }
    
    public int getMaxMnemonicLen() {
        int max = Math.max(this.primaryMaxMnemonicLen, this.secondaryMaxMnemonicLen);
        if (max == 0) {
            max = 12;
        }
        return max;
    }
    
    public int getMaxMnemonicLen(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.primaryMaxMnemonicLen : this.secondaryMaxMnemonicLen;
    }
    
    public int getSimilarityIntervalCount(final int n) {
        Preconditions.checkArgument(n <= 10, (Object)"Confidence interval index cannot be greater than 10.");
        return this.similarityIntervalCounts[n];
    }
    
    public int[] getSimilarityIntervalCounts() {
        return this.similarityIntervalCounts;
    }
    
    public int getSizeOfBasicblocks(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.priBasicblocks : this.secBasicblocks;
    }
    
    public int getSizeOfCalls(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.priCalls : this.secCalls;
    }
    
    public int getSizeOfChangedCalls() {
        return this.changedCalls;
    }
    
    public int getSizeOfChangedFunctions() {
        return this.changedFunctions;
    }
    
    public int getSizeOfFunctions(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.priFunctions : this.secFunctions;
    }
    
    public int getSizeOfInstructions(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.priInstructions : this.secInstructions;
    }
    
    public int getSizeOfJumps(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.priJumps : this.secJumps;
    }
    
    public int getSizeOfMatchedBasicblocks() {
        return this.matchedBasicblocks;
    }
    
    public int getSizeOfMatchedCalls() {
        return this.matchedCalls;
    }
    
    public int getSizeOfMatchedFunctions() {
        return this.matchedFunctions;
    }
    
    public int getSizeOfMatchedInstructions() {
        return this.matchedInstrutions;
    }
    
    public int getSizeOfMatchedJumps() {
        return this.matchedJumps;
    }
    
    public int getSizeOfUnmatchedBasicblocks(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? (this.priBasicblocks - this.matchedBasicblocks) : (this.secBasicblocks - this.matchedBasicblocks);
    }
    
    public int getSizeOfUnmatchedCalls(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? (this.priCalls - this.matchedCalls) : (this.secCalls - this.matchedCalls);
    }
    
    public int getSizeOfUnmatchedFunctions(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? (this.priFunctions - this.matchedFunctions) : (this.secFunctions - this.matchedFunctions);
    }
    
    public int getSizeOfUnmatchedInstructions(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? (this.priInstructions - this.matchedInstrutions) : (this.secInstructions - this.matchedInstrutions);
    }
    
    public int getSizeOfUnmatchedJumps(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? (this.priJumps - this.matchedJumps) : (this.secJumps - this.matchedJumps);
    }
    
    public double getTotalConfidence() {
        return this.totalConfidence;
    }
    
    public double getTotalSimilarity() {
        return this.totalSimilarity;
    }
    
    public String getVersion() {
        return this.version;
    }
    
    public void removeListener(final ICountsChangeListener countsChangeListener) {
        this.listeners.removeListener(countsChangeListener);
    }
    
    public void setAddressSpace(final int n, final ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.priAddressSpace = n;
        }
        else if (eSide == ESide.SECONDARY) {
            this.secAddressSpace = n;
        }
    }
    
    public void setArchitectureName(final String s, final ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.primaryArchitectureName = s;
        }
        else {
            this.secondaryArchitectureName = s;
        }
    }
    
    public void setMaxMnemonicLen(final int n, final ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.primaryMaxMnemonicLen = n;
        }
        else {
            this.secondaryMaxMnemonicLen = n;
        }
    }
    
    public void setSizeOfChangedCalls(final int changedCalls) {
        this.changedCalls = changedCalls;
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().callsCountChanged();
        }
    }
    
    public void setSizeOfChangedFunctions(final int changedFunctions) {
        this.changedFunctions = changedFunctions;
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().functionsCountChanged();
        }
    }
    
    public void setSizeOfMatchedBasicblocks(final int matchedBasicblocks) {
        this.matchedBasicblocks = matchedBasicblocks;
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().basicblocksCountChanged();
        }
    }
    
    public void setSizeOfMatchedCalls(final int matchedCalls) {
        this.matchedCalls = matchedCalls;
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().callsCountChanged();
        }
    }
    
    public void setSizeOfMatchedFunctions(final int matchedFunctions) {
        this.matchedFunctions = matchedFunctions;
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().functionsCountChanged();
        }
    }
    
    public void setSizeOfMatchedInstructions(final int matchedInstrutions) {
        this.matchedInstrutions = matchedInstrutions;
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().instructionsCountsChanged();
        }
    }
    
    public void setSizeOfMatchedJumps(final int matchedJumps) {
        this.matchedJumps = matchedJumps;
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().jumpsCountChanged();
        }
    }
}
