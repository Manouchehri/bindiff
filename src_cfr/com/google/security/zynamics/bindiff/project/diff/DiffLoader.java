/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.diff;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.security.zynamics.bindiff.database.CommentsDatabase;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.io.matches.FunctionDiffSocketXmlData;
import com.google.security.zynamics.bindiff.io.proto.BinExportReader;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffLoader$1;
import com.google.security.zynamics.bindiff.project.diff.DiffLoader$2;
import com.google.security.zynamics.bindiff.project.diff.DiffLoader$3;
import com.google.security.zynamics.bindiff.project.matches.AddressPair;
import com.google.security.zynamics.bindiff.project.matches.AddressTriple;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionDiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstructionComment;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IProgressDescription;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import com.google.security.zynamics.zylib.types.common.ICommand;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.Stack;
import javax.swing.SwingUtilities;

public class DiffLoader
implements ICommand {
    private IProgressDescription descriptionTarget = null;
    private final LinkedHashSet diffs;

    public DiffLoader() {
        this.diffs = null;
    }

    public DiffLoader(LinkedHashSet linkedHashSet) {
        this.diffs = (LinkedHashSet)Preconditions.checkNotNull(linkedHashSet);
    }

    private static void setBasicblockComments(RawFlowGraph rawFlowGraph, Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            RawBasicBlock rawBasicBlock = rawFlowGraph.getBasicblock((IAddress)entry.getKey());
            rawBasicBlock.setComment((String)entry.getValue());
        }
    }

    private static void setInstructionComment(RawFlowGraph rawFlowGraph, Map map) {
        Iterator iterator = rawFlowGraph.getNodes().iterator();
        block0 : while (iterator.hasNext()) {
            RawBasicBlock rawBasicBlock = (RawBasicBlock)iterator.next();
            Iterator iterator2 = rawBasicBlock.getInstructions().entrySet().iterator();
            block1 : do {
                Object object;
                String string;
                Object object2;
                Object object3;
                if (!iterator2.hasNext()) continue block0;
                Map.Entry entry = iterator2.next();
                IAddress iAddress = (IAddress)entry.getKey();
                if (((RawInstruction)entry.getValue()).getComments() != null) {
                    object = ((RawInstruction)entry.getValue()).getComments().iterator();
                    do {
                        if (!object.hasNext()) continue block1;
                        object3 = (RawInstructionComment)object.next();
                        object2 = Pair.make(iAddress, (Object)object3.getPlacement());
                        string = (String)map.get(object2);
                        if (string == null) continue;
                        String string2 = object3.getText();
                        if (!string.equals(string2) && string.indexOf(string2) != 0) {
                            String string3 = String.valueOf(string2);
                            string2 = new StringBuilder(4 + String.valueOf(string3).length() + String.valueOf(string).length()).append(string3).append(" // ").append(string).toString();
                        }
                        string2 = string;
                        object3.setText(string2);
                    } while (true);
                }
                object = Pair.make(iAddress, (Object)ECommentPlacement.ABOVE_LINE);
                object3 = Pair.make(iAddress, (Object)ECommentPlacement.BEHIND_LINE);
                object2 = (String)map.get(object);
                string = (String)map.get(object3);
                if (object2 != null) {
                    ((RawInstruction)entry.getValue()).setComment((String)object2, ECommentPlacement.ABOVE_LINE);
                }
                if (string == null) continue;
                ((RawInstruction)entry.getValue()).setComment(string, ECommentPlacement.BEHIND_LINE);
            } while (true);
            break;
        }
        return;
    }

    public static RawFlowGraph loadRawFlowgraph(CommentsDatabase commentsDatabase, Diff diff, IAddress iAddress, ESide eSide) {
        BinExportReader binExportReader = new BinExportReader(diff.getExportFile(ESide.PRIMARY), ESide.PRIMARY);
        BinExportReader binExportReader2 = new BinExportReader(diff.getExportFile(ESide.SECONDARY), ESide.SECONDARY);
        RawFunction rawFunction = diff.getCallgraph(eSide).getFunction(iAddress);
        if (rawFunction == null) {
            return null;
        }
        if (rawFunction.getFunctionType() == EFunctionType.IMPORTED) {
            return new RawFlowGraph(iAddress, rawFunction.getName(), rawFunction.getFunctionType(), new ArrayList(), new ArrayList(), eSide);
        }
        RawFlowGraph rawFlowGraph = eSide == ESide.PRIMARY ? binExportReader.readFlowgraph(diff, iAddress) : binExportReader2.readFlowgraph(diff, iAddress);
        String string = diff.getDiffMetaData().getImageHash(eSide);
        if (commentsDatabase == null) return rawFlowGraph;
        Map map = commentsDatabase.readInstructionComments(string, iAddress);
        Map map2 = commentsDatabase.readBasicblockComments(string, iAddress);
        DiffLoader.setBasicblockComments(rawFlowGraph, map2);
        DiffLoader.setInstructionComment(rawFlowGraph, map);
        return rawFlowGraph;
    }

    public static DiffMetaData preloadDiffMatches(File file) {
        MatchesDatabase matchesDatabase = new MatchesDatabase(file);
        Throwable throwable = null;
        try {
            DiffMetaData diffMetaData = matchesDatabase.loadDiffMetaData(file);
            return diffMetaData;
        }
        catch (Throwable var3_4) {
            throwable = var3_4;
            throw var3_4;
        }
        finally {
            if (matchesDatabase != null) {
                if (throwable != null) {
                    try {
                        matchesDatabase.close();
                    }
                    catch (Throwable var4_5) {
                        throwable.addSuppressed(var4_5);
                    }
                } else {
                    matchesDatabase.close();
                }
            }
        }
    }

    private void loadDiff(Diff diff) {
        if (diff.isLoaded()) {
            Logger.logInfo("Diff is already loaded!", new Object[0]);
            return;
        }
        this.descriptionTarget.setDescription(String.format("Loading Diff '%s'", diff.getDiffName()));
        Logger.logInfo("Loading Diff '%s'", diff.getDiffName());
        this.validateInputFiles(diff);
        try {
            this.setSubDescription("Loading function matches...");
            this.loadDiffMatches(diff);
            this.loadRawCallgraphs(diff);
            this.setSubDescription("Setting function matches...");
            this.setFunctionMatches(diff);
            this.setSubDescription("Loading call matches...");
            this.setCallMatches(diff);
            this.setChangedFunctionsCount(diff);
            diff.setLoaded(true);
        }
        catch (SQLException var2_2) {
            Logger.logException(var2_2);
            throw var2_2;
        }
        this.setSubDescription("Preparing UI...");
        SwingUtilities.invokeLater(new DiffLoader$1(this, diff));
    }

    private void loadDiffMatches(Diff diff) {
        File file = diff.getMatchesDatabase();
        if (!file.exists()) {
            throw new IOException(String.format("Couldn't find '%s%s%s'.", file.getPath(), File.separator, file.getName()));
        }
        Object object = String.valueOf(file.getPath());
        Logger.logInfo(new StringBuilder(18 + String.valueOf(object).length()).append(" - Loading Diff '").append((String)object).append("'").toString(), new Object[0]);
        object = new MatchesDatabase(file);
        Throwable throwable = null;
        try {
            diff.setMatches(object.loadFunctionMatches(diff));
            return;
        }
        catch (Throwable var5_6) {
            throwable = var5_6;
            throw var5_6;
        }
        finally {
            if (object != null) {
                if (throwable != null) {
                    try {
                        object.close();
                    }
                    catch (Throwable var5_5) {
                        throwable.addSuppressed(var5_5);
                    }
                } else {
                    object.close();
                }
            }
        }
    }

    private void loadRawCallgraphs(Diff diff) {
        RawCallGraph rawCallGraph;
        BinExportReader binExportReader;
        RawCallGraph rawCallGraph2;
        BinExportReader binExportReader2;
        binExportReader2 = new BinExportReader(diff.getExportFile(ESide.PRIMARY), ESide.PRIMARY);
        binExportReader = new BinExportReader(diff.getExportFile(ESide.SECONDARY), ESide.SECONDARY);
        if (!diff.isFunctionDiff()) {
            this.setSubDescription("Read raw primary callgraph...");
            rawCallGraph2 = binExportReader2.readCallgraph();
            this.setSubDescription("Read raw secondary callgraph...");
            rawCallGraph = binExportReader.readCallgraph();
        } else {
            FunctionDiffMetaData functionDiffMetaData = (FunctionDiffMetaData)diff.getMetaData();
            String string = functionDiffMetaData.getFunctionName(ESide.PRIMARY);
            EFunctionType eFunctionType = functionDiffMetaData.getFunctionType(ESide.PRIMARY);
            IAddress iAddress = diff.getMatches().getFunctionMatches()[0].getIAddress(ESide.PRIMARY);
            RawFunction rawFunction = new RawFunction(iAddress, string, eFunctionType, ESide.PRIMARY);
            ArrayList<RawFunction> arrayList = new ArrayList<RawFunction>();
            arrayList.add(rawFunction);
            rawCallGraph2 = new RawCallGraph(arrayList, new ArrayList(), ESide.PRIMARY);
            String string2 = functionDiffMetaData.getFunctionName(ESide.SECONDARY);
            EFunctionType eFunctionType2 = functionDiffMetaData.getFunctionType(ESide.SECONDARY);
            IAddress iAddress2 = diff.getMatches().getFunctionMatches()[0].getIAddress(ESide.SECONDARY);
            RawFunction rawFunction2 = new RawFunction(iAddress2, string2, eFunctionType2, ESide.SECONDARY);
            ArrayList<RawFunction> arrayList2 = new ArrayList<RawFunction>();
            arrayList2.add(rawFunction2);
            rawCallGraph = new RawCallGraph(arrayList2, new ArrayList(), ESide.SECONDARY);
            MatchesDatabase matchesDatabase = new MatchesDatabase(diff.getMatchesDatabase());
            Throwable throwable = null;
            try {
                matchesDatabase.setFunctionDiffCounts(rawFunction, rawFunction2);
            }
            catch (Throwable var19_20) {
                throwable = var19_20;
                throw var19_20;
            }
            finally {
                if (matchesDatabase != null) {
                    if (throwable != null) {
                        try {
                            matchesDatabase.close();
                        }
                        catch (Throwable var19_19) {
                            throwable.addSuppressed(var19_19);
                        }
                    } else {
                        matchesDatabase.close();
                    }
                }
            }
        }
        diff.setCallgraph(rawCallGraph2, ESide.PRIMARY);
        diff.setCallgraph(rawCallGraph, ESide.SECONDARY);
        if (diff.isFunctionDiff()) return;
        this.setSubDescription("Preprocessing raw primary flowgraphs...");
        binExportReader2.readFlowgraphsStatistics(diff);
        this.setSubDescription("Preprocessing raw secondary flowgraphs...");
        binExportReader.readFlowgraphsStatistics(diff);
    }

    private void loadSingleFunctionDiffRawCallgraphs(Diff diff, FunctionDiffSocketXmlData functionDiffSocketXmlData) {
        BinExportReader binExportReader = new BinExportReader(diff.getExportFile(ESide.PRIMARY), ESide.PRIMARY);
        BinExportReader binExportReader2 = new BinExportReader(diff.getExportFile(ESide.SECONDARY), ESide.SECONDARY);
        this.setSubDescription("Read raw primary callgraph...");
        RawCallGraph rawCallGraph = binExportReader.readSingleFunctionDiffCallgraph(functionDiffSocketXmlData);
        diff.setCallgraph(rawCallGraph, ESide.PRIMARY);
        this.setSubDescription("Read raw secondary callgraph...");
        RawCallGraph rawCallGraph2 = binExportReader2.readSingleFunctionDiffCallgraph(functionDiffSocketXmlData);
        diff.setCallgraph(rawCallGraph2, ESide.SECONDARY);
    }

    private void setCallMatches(Diff diff) {
        File file = diff.getMatchesDatabase();
        if (!file.exists()) {
            throw new IOException(String.format("Couldn't find '%s%s%s'.", file.getPath(), File.separator, file.getName()));
        }
        MatchesDatabase matchesDatabase = new MatchesDatabase(file);
        Throwable throwable = null;
        try {
            long l2;
            long l3;
            int n2 = 0;
            Map map = matchesDatabase.loadMatchedCallAddresses(diff);
            ImmutableMap immutableMap = Maps.uniqueIndex(diff.getCallgraph(ESide.SECONDARY).getEdges(), (Function)new DiffLoader$2(this));
            for (Object object : diff.getCallgraph(ESide.PRIMARY).getEdges()) {
                RawCall rawCall;
                long l4;
                AddressTriple addressTriple;
                Object object2 = (RawFunction)object.getSource();
                Object object3 = (RawFunction)object.getTarget();
                l3 = object2.getAddress().toLong();
                l2 = object.getSourceInstructionAddr().toLong();
                if (object2.getMatchedFunction() == null || object3.getMatchedFunction() == null) continue;
                long l5 = object2.getMatchedFunction().getAddress().toLong();
                long l6 = object3.getMatchedFunction().getAddress().toLong();
                AddressPair addressPair = new AddressPair(l3, l2);
                AddressPair addressPair2 = (AddressPair)map.get(addressPair);
                if (addressPair2 == null || (rawCall = (RawCall)immutableMap.get(addressTriple = new AddressTriple(l5, l6, l4 = addressPair2.getAddress(ESide.SECONDARY)))) == null) continue;
                object.setMatchState(true, rawCall);
                rawCall.setMatchState(true, (RawCall)object);
                ++n2;
            }
            HashMap hashMap = new HashMap();
            for (Object object2 : diff.getCallgraph(ESide.SECONDARY).getEdges()) {
                long l7;
                if (object2.getMatchedCall() != null) continue;
                long l8 = ((RawFunction)object2.getSource()).getAddress().toLong();
                AddressPair addressPair = new AddressPair(l8, l7 = object2.getSourceInstructionAddr().toLong());
                Stack stack = (Stack)hashMap.get(addressPair);
                if (stack == null) {
                    stack = new Stack();
                    hashMap.put(addressPair, stack);
                }
                stack.push(object2);
            }
            int n3 = 0;
            for (Object object3 : diff.getCallgraph(ESide.PRIMARY).getEdges()) {
                Stack stack;
                AddressPair addressPair;
                AddressPair addressPair3;
                if (object3.getMatchedCall() != null) continue;
                l3 = ((RawFunction)object3.getSource()).getAddress().toLong();
                l2 = object3.getSourceInstructionAddr().toLong();
                if (((RawFunction)object3.getSource()).getMatchedFunction() == null || (addressPair3 = (AddressPair)map.get(addressPair = new AddressPair(l3, l2))) == null || (stack = (Stack)hashMap.get(addressPair3)) == null || stack.size() <= 0) continue;
                RawCall rawCall = (RawCall)stack.pop();
                object3.setMatchState(false, rawCall);
                rawCall.setMatchState(false, (RawCall)object3);
                ++n3;
            }
            diff.getMatches().setSizeOfMatchedCalls(n2 + n3);
            diff.getMatches().setSizeOfChangedCalls(n3);
            return;
        }
        catch (Throwable var5_7) {
            throwable = var5_7;
            throw var5_7;
        }
        finally {
            if (matchesDatabase != null) {
                if (throwable != null) {
                    try {
                        matchesDatabase.close();
                    }
                    catch (Throwable var5_6) {
                        throwable.addSuppressed(var5_6);
                    }
                } else {
                    matchesDatabase.close();
                }
            }
        }
    }

    private void setChangedFunctionsCount(Diff diff) {
        int n2 = 0;
        Iterator iterator = diff.getCallgraph(ESide.PRIMARY).getNodes().iterator();
        do {
            if (!iterator.hasNext()) {
                diff.getMatches().setSizeOfChangedFunctions(n2);
                return;
            }
            RawFunction rawFunction = (RawFunction)iterator.next();
            if (!rawFunction.isChanged()) continue;
            ++n2;
        } while (true);
    }

    private void setFunctionMatches(Diff diff) {
        RawCallGraph rawCallGraph = diff.getCallgraph(ESide.PRIMARY);
        RawCallGraph rawCallGraph2 = diff.getCallgraph(ESide.SECONDARY);
        FunctionMatchData[] arrfunctionMatchData = diff.getMatches().getFunctionMatches();
        int n2 = arrfunctionMatchData.length;
        int n3 = 0;
        while (n3 < n2) {
            FunctionMatchData functionMatchData = arrfunctionMatchData[n3];
            RawFunction rawFunction = rawCallGraph.getFunction(functionMatchData.getIAddress(ESide.PRIMARY));
            RawFunction rawFunction2 = rawCallGraph2.getFunction(functionMatchData.getIAddress(ESide.SECONDARY));
            if (rawFunction != null && rawFunction2 != null) {
                rawFunction.setMatch(rawFunction2, functionMatchData);
                rawFunction2.setMatch(rawFunction, functionMatchData);
            }
            ++n3;
        }
    }

    private void setSubDescription(String string) {
        if (this.descriptionTarget == null) return;
        this.descriptionTarget.setSubDescription(string);
    }

    private void validateInputFiles(Diff diff) {
        if (!diff.getMatchesDatabase().exists()) {
            throw new IOException("Load Diff graphs failed. Matches dababase file can not be found.");
        }
        if (!diff.getExportFile(ESide.PRIMARY).exists()) {
            throw new IOException("Load Diff graphs failed. Primary exported file can not be found.");
        }
        if (!diff.getExportFile(ESide.SECONDARY).exists()) {
            throw new IOException("Load Diff graphs failed. Secondary exported file can not be found.");
        }
        if (!diff.getExportFile(ESide.PRIMARY).canRead()) {
            throw new IOException("Load Diff graphs failed. Couldn't read primary exported call graph file.");
        }
        if (diff.getExportFile(ESide.SECONDARY).canRead()) return;
        throw new IOException("Load Diff graphs failed. Couldn't read secondary exported call graph file.");
    }

    @Override
    public void execute() {
        Iterator iterator = this.diffs.iterator();
        while (iterator.hasNext()) {
            Diff diff = (Diff)iterator.next();
            this.loadDiff(diff);
        }
    }

    public void loadDiff(Diff diff, FunctionDiffSocketXmlData functionDiffSocketXmlData) {
        if (diff.isLoaded()) {
            Logger.logInfo("Single function diff is already loaded! Loading process canceled.", new Object[0]);
            return;
        }
        if (this.descriptionTarget != null) {
            this.descriptionTarget.setDescription(String.format("Loading Diff '%s'", diff.getDiffName()));
        }
        Logger.logInfo("Loading single function diff '%s'", diff.getDiffName());
        this.validateInputFiles(diff);
        boolean bl2 = false;
        try {
            this.loadSingleFunctionDiffRawCallgraphs(diff, functionDiffSocketXmlData);
            this.setSubDescription("Loading function matches...");
            this.loadDiffMatches(diff);
            this.setSubDescription("Setting function matches...");
            this.setFunctionMatches(diff);
            this.setChangedFunctionsCount(diff);
            diff.setLoaded(!bl2);
        }
        catch (IOException | SQLException var4_4) {
            try {
                String string;
                bl2 = true;
                Logger.logException(var4_4, "");
                String string2 = String.valueOf(var4_4.getMessage());
                if (string2.length() != 0) {
                    string = "Load Diff graphs failed: ".concat(string2);
                    throw new IOException(string);
                }
                string = new String("Load Diff graphs failed: ");
                throw new IOException(string);
            }
            catch (Throwable var5_5) {
                diff.setLoaded(!bl2);
                throw var5_5;
            }
        }
        this.setSubDescription("Preparing UI...");
        if (!diff.isFunctionDiff()) return;
        SwingUtilities.invokeLater(new DiffLoader$3(this, diff));
    }

    public void setProgressDescriptionTarget(IProgressDescription iProgressDescription) {
        this.descriptionTarget = iProgressDescription;
    }
}

