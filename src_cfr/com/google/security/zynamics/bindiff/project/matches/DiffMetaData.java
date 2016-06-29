/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.matches;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.ICountsChangeListener;
import com.google.security.zynamics.zylib.date.DateHelpers;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;

public class DiffMetaData {
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
    private final ListenerProvider listeners = new ListenerProvider();

    public DiffMetaData(String string, String string2, GregorianCalendar gregorianCalendar, double d2, double d3, String string3, String string4, String string5, String string6, String string7, String string8, int[] arrn, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        this.version = string;
        this.description = string2;
        this.primaryIdbName = string3;
        this.secondaryIdbName = string4;
        this.primaryImageName = string5;
        this.secondaryImageName = string6;
        this.primaryHash = string7;
        this.secondaryHash = string8;
        this.date = gregorianCalendar;
        this.totalSimilarity = d2;
        this.totalConfidence = d3;
        this.similarityIntervalCounts = arrn;
        this.matchedFunctions = n2;
        this.priFunctions = n3;
        this.secFunctions = n4;
        this.priCalls = n5;
        this.secCalls = n6;
        this.priBasicblocks = n7;
        this.secBasicblocks = n8;
        this.priJumps = n9;
        this.secJumps = n10;
        this.priInstructions = n11;
        this.secInstructions = n12;
        this.priAddressSpace = 0;
        this.secAddressSpace = 0;
        this.changedFunctions = 0;
        this.matchedCalls = 0;
        this.changedCalls = 0;
    }

    public static GregorianCalendar dbDateStringToCalendar(String string) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        try {
            gregorianCalendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(string));
            return gregorianCalendar;
        }
        catch (ParseException var2_2) {
            Logger.logException(var2_2);
        }
        return gregorianCalendar;
    }

    public void addListener(ICountsChangeListener iCountsChangeListener) {
        this.listeners.addListener(iCountsChangeListener);
    }

    public int getAddressSpace(ESide eSide) {
        int n2;
        if (eSide == ESide.PRIMARY) {
            n2 = this.priAddressSpace;
            return n2;
        }
        n2 = this.secAddressSpace;
        return n2;
    }

    public String getArchitectureName(ESide eSide) {
        String string;
        if (eSide == ESide.PRIMARY) {
            string = this.primaryArchitectureName;
            return string;
        }
        string = this.secondaryArchitectureName;
        return string;
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

    public String getIdbName(ESide eSide) {
        String string;
        if (eSide == ESide.PRIMARY) {
            string = this.primaryIdbName;
            return string;
        }
        string = this.secondaryIdbName;
        return string;
    }

    public String getImageHash(ESide eSide) {
        String string;
        if (eSide == ESide.PRIMARY) {
            string = this.primaryHash;
            return string;
        }
        string = this.secondaryHash;
        return string;
    }

    public String getImageName(ESide eSide) {
        String string;
        if (eSide == ESide.PRIMARY) {
            string = this.primaryImageName;
            return string;
        }
        string = this.secondaryImageName;
        return string;
    }

    public int getMaxMnemonicLen() {
        int n2 = Math.max(this.primaryMaxMnemonicLen, this.secondaryMaxMnemonicLen);
        if (n2 != 0) return n2;
        return 12;
    }

    public int getMaxMnemonicLen(ESide eSide) {
        int n2;
        if (eSide == ESide.PRIMARY) {
            n2 = this.primaryMaxMnemonicLen;
            return n2;
        }
        n2 = this.secondaryMaxMnemonicLen;
        return n2;
    }

    public int getSimilarityIntervalCount(int n2) {
        Preconditions.checkArgument(n2 <= 10, "Confidence interval index cannot be greater than 10.");
        return this.similarityIntervalCounts[n2];
    }

    public int[] getSimilarityIntervalCounts() {
        return this.similarityIntervalCounts;
    }

    public int getSizeOfBasicblocks(ESide eSide) {
        int n2;
        if (eSide == ESide.PRIMARY) {
            n2 = this.priBasicblocks;
            return n2;
        }
        n2 = this.secBasicblocks;
        return n2;
    }

    public int getSizeOfCalls(ESide eSide) {
        int n2;
        if (eSide == ESide.PRIMARY) {
            n2 = this.priCalls;
            return n2;
        }
        n2 = this.secCalls;
        return n2;
    }

    public int getSizeOfChangedCalls() {
        return this.changedCalls;
    }

    public int getSizeOfChangedFunctions() {
        return this.changedFunctions;
    }

    public int getSizeOfFunctions(ESide eSide) {
        int n2;
        if (eSide == ESide.PRIMARY) {
            n2 = this.priFunctions;
            return n2;
        }
        n2 = this.secFunctions;
        return n2;
    }

    public int getSizeOfInstructions(ESide eSide) {
        int n2;
        if (eSide == ESide.PRIMARY) {
            n2 = this.priInstructions;
            return n2;
        }
        n2 = this.secInstructions;
        return n2;
    }

    public int getSizeOfJumps(ESide eSide) {
        int n2;
        if (eSide == ESide.PRIMARY) {
            n2 = this.priJumps;
            return n2;
        }
        n2 = this.secJumps;
        return n2;
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

    public int getSizeOfUnmatchedBasicblocks(ESide eSide) {
        int n2;
        if (eSide == ESide.PRIMARY) {
            n2 = this.priBasicblocks - this.matchedBasicblocks;
            return n2;
        }
        n2 = this.secBasicblocks - this.matchedBasicblocks;
        return n2;
    }

    public int getSizeOfUnmatchedCalls(ESide eSide) {
        int n2;
        if (eSide == ESide.PRIMARY) {
            n2 = this.priCalls - this.matchedCalls;
            return n2;
        }
        n2 = this.secCalls - this.matchedCalls;
        return n2;
    }

    public int getSizeOfUnmatchedFunctions(ESide eSide) {
        int n2;
        if (eSide == ESide.PRIMARY) {
            n2 = this.priFunctions - this.matchedFunctions;
            return n2;
        }
        n2 = this.secFunctions - this.matchedFunctions;
        return n2;
    }

    public int getSizeOfUnmatchedInstructions(ESide eSide) {
        int n2;
        if (eSide == ESide.PRIMARY) {
            n2 = this.priInstructions - this.matchedInstrutions;
            return n2;
        }
        n2 = this.secInstructions - this.matchedInstrutions;
        return n2;
    }

    public int getSizeOfUnmatchedJumps(ESide eSide) {
        int n2;
        if (eSide == ESide.PRIMARY) {
            n2 = this.priJumps - this.matchedJumps;
            return n2;
        }
        n2 = this.secJumps - this.matchedJumps;
        return n2;
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

    public void removeListener(ICountsChangeListener iCountsChangeListener) {
        this.listeners.removeListener(iCountsChangeListener);
    }

    public void setAddressSpace(int n2, ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.priAddressSpace = n2;
            return;
        }
        if (eSide != ESide.SECONDARY) return;
        this.secAddressSpace = n2;
    }

    public void setArchitectureName(String string, ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.primaryArchitectureName = string;
            return;
        }
        this.secondaryArchitectureName = string;
    }

    public void setMaxMnemonicLen(int n2, ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            this.primaryMaxMnemonicLen = n2;
            return;
        }
        this.secondaryMaxMnemonicLen = n2;
    }

    public void setSizeOfChangedCalls(int n2) {
        this.changedCalls = n2;
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ICountsChangeListener iCountsChangeListener = (ICountsChangeListener)iterator.next();
            iCountsChangeListener.callsCountChanged();
        }
    }

    public void setSizeOfChangedFunctions(int n2) {
        this.changedFunctions = n2;
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ICountsChangeListener iCountsChangeListener = (ICountsChangeListener)iterator.next();
            iCountsChangeListener.functionsCountChanged();
        }
    }

    public void setSizeOfMatchedBasicblocks(int n2) {
        this.matchedBasicblocks = n2;
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ICountsChangeListener iCountsChangeListener = (ICountsChangeListener)iterator.next();
            iCountsChangeListener.basicblocksCountChanged();
        }
    }

    public void setSizeOfMatchedCalls(int n2) {
        this.matchedCalls = n2;
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ICountsChangeListener iCountsChangeListener = (ICountsChangeListener)iterator.next();
            iCountsChangeListener.callsCountChanged();
        }
    }

    public void setSizeOfMatchedFunctions(int n2) {
        this.matchedFunctions = n2;
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ICountsChangeListener iCountsChangeListener = (ICountsChangeListener)iterator.next();
            iCountsChangeListener.functionsCountChanged();
        }
    }

    public void setSizeOfMatchedInstructions(int n2) {
        this.matchedInstrutions = n2;
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ICountsChangeListener iCountsChangeListener = (ICountsChangeListener)iterator.next();
            iCountsChangeListener.instructionsCountsChanged();
        }
    }

    public void setSizeOfMatchedJumps(int n2) {
        this.matchedJumps = n2;
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ICountsChangeListener iCountsChangeListener = (ICountsChangeListener)iterator.next();
            iCountsChangeListener.jumpsCountChanged();
        }
    }
}

