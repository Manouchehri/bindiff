package com.google.security.zynamics.bindiff.project.diff;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.bindiff.io.proto.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.database.*;
import com.google.security.zynamics.bindiff.log.*;
import java.sql.*;
import javax.swing.*;
import java.io.*;
import com.google.security.zynamics.bindiff.io.matches.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import java.util.*;
import com.google.common.collect.*;
import com.google.security.zynamics.bindiff.project.matches.*;

public class DiffLoader implements ICommand
{
    private IProgressDescription descriptionTarget;
    private final LinkedHashSet diffs;
    
    public DiffLoader() {
        this.descriptionTarget = null;
        this.diffs = null;
    }
    
    public DiffLoader(final LinkedHashSet set) {
        this.descriptionTarget = null;
        this.diffs = (LinkedHashSet)Preconditions.checkNotNull(set);
    }
    
    private static void setBasicblockComments(final RawFlowGraph rawFlowGraph, final Map map) {
        for (final Map.Entry<IAddress, V> entry : map.entrySet()) {
            rawFlowGraph.getBasicblock(entry.getKey()).setComment((String)entry.getValue());
        }
    }
    
    private static void setInstructionComment(final RawFlowGraph rawFlowGraph, final Map map) {
        final Iterator<RawBasicBlock> iterator = rawFlowGraph.getNodes().iterator();
        while (iterator.hasNext()) {
            for (final Map.Entry<IAddress, V> entry : iterator.next().getInstructions().entrySet()) {
                final IAddress address = entry.getKey();
                if (((RawInstruction)entry.getValue()).getComments() != null) {
                    for (final RawInstructionComment rawInstructionComment : ((RawInstruction)entry.getValue()).getComments()) {
                        final String text = map.get(Pair.make(address, rawInstructionComment.getPlacement()));
                        if (text != null) {
                            final String text2 = rawInstructionComment.getText();
                            if (!text.equals(text2) && text.indexOf(text2) != 0) {
                                final String value = String.valueOf(text2);
                                new StringBuilder(4 + String.valueOf(value).length() + String.valueOf(text).length()).append(value).append(" // ").append(text).toString();
                            }
                            rawInstructionComment.setText(text);
                        }
                    }
                }
                else {
                    final Pair make = Pair.make(address, ECommentPlacement.ABOVE_LINE);
                    final Pair make2 = Pair.make(address, ECommentPlacement.BEHIND_LINE);
                    final String s = map.get(make);
                    final String s2 = map.get(make2);
                    if (s != null) {
                        ((RawInstruction)entry.getValue()).setComment(s, ECommentPlacement.ABOVE_LINE);
                    }
                    if (s2 == null) {
                        continue;
                    }
                    ((RawInstruction)entry.getValue()).setComment(s2, ECommentPlacement.BEHIND_LINE);
                }
            }
        }
    }
    
    public static RawFlowGraph loadRawFlowgraph(final CommentsDatabase commentsDatabase, final Diff diff, final IAddress address, final ESide eSide) {
        final BinExportReader binExportReader = new BinExportReader(diff.getExportFile(ESide.PRIMARY), ESide.PRIMARY);
        final BinExportReader binExportReader2 = new BinExportReader(diff.getExportFile(ESide.SECONDARY), ESide.SECONDARY);
        final RawFunction function = diff.getCallgraph(eSide).getFunction(address);
        if (function == null) {
            return null;
        }
        if (function.getFunctionType() == EFunctionType.IMPORTED) {
            return new RawFlowGraph(address, function.getName(), function.getFunctionType(), new ArrayList(), new ArrayList(), eSide);
        }
        final RawFlowGraph rawFlowGraph = (eSide == ESide.PRIMARY) ? binExportReader.readFlowgraph(diff, address) : binExportReader2.readFlowgraph(diff, address);
        final String imageHash = diff.getDiffMetaData().getImageHash(eSide);
        if (commentsDatabase != null) {
            final Map instructionComments = commentsDatabase.readInstructionComments(imageHash, address);
            setBasicblockComments(rawFlowGraph, commentsDatabase.readBasicblockComments(imageHash, address));
            setInstructionComment(rawFlowGraph, instructionComments);
        }
        return rawFlowGraph;
    }
    
    public static DiffMetaData preloadDiffMatches(final File file) {
        try (final MatchesDatabase matchesDatabase = new MatchesDatabase(file)) {
            return matchesDatabase.loadDiffMetaData(file);
        }
    }
    
    private void loadDiff(final Diff changedFunctionsCount) {
        if (changedFunctionsCount.isLoaded()) {
            Logger.logInfo("Diff is already loaded!", new Object[0]);
            return;
        }
        this.descriptionTarget.setDescription(String.format("Loading Diff '%s'", changedFunctionsCount.getDiffName()));
        Logger.logInfo("Loading Diff '%s'", changedFunctionsCount.getDiffName());
        this.validateInputFiles(changedFunctionsCount);
        try {
            this.setSubDescription("Loading function matches...");
            this.loadDiffMatches(changedFunctionsCount);
            this.loadRawCallgraphs(changedFunctionsCount);
            this.setSubDescription("Setting function matches...");
            this.setFunctionMatches(changedFunctionsCount);
            this.setSubDescription("Loading call matches...");
            this.setCallMatches(changedFunctionsCount);
            this.setChangedFunctionsCount(changedFunctionsCount);
            changedFunctionsCount.setLoaded(true);
        }
        catch (SQLException ex) {
            Logger.logException(ex);
            throw ex;
        }
        this.setSubDescription("Preparing UI...");
        SwingUtilities.invokeLater(new DiffLoader$1(this, changedFunctionsCount));
    }
    
    private void loadDiffMatches(final Diff diff) {
        final File matchesDatabase = diff.getMatchesDatabase();
        if (!matchesDatabase.exists()) {
            throw new IOException(String.format("Couldn't find '%s%s%s'.", matchesDatabase.getPath(), File.separator, matchesDatabase.getName()));
        }
        final String value = String.valueOf(matchesDatabase.getPath());
        Logger.logInfo(new StringBuilder(18 + String.valueOf(value).length()).append(" - Loading Diff '").append(value).append("'").toString(), new Object[0]);
        try (final MatchesDatabase matchesDatabase2 = new MatchesDatabase(matchesDatabase)) {
            diff.setMatches(matchesDatabase2.loadFunctionMatches(diff));
        }
    }
    
    private void loadRawCallgraphs(final Diff diff) {
        final BinExportReader binExportReader = new BinExportReader(diff.getExportFile(ESide.PRIMARY), ESide.PRIMARY);
        final BinExportReader binExportReader2 = new BinExportReader(diff.getExportFile(ESide.SECONDARY), ESide.SECONDARY);
        RawCallGraph callgraph;
        RawCallGraph callgraph2;
        if (!diff.isFunctionDiff()) {
            this.setSubDescription("Read raw primary callgraph...");
            callgraph = binExportReader.readCallgraph();
            this.setSubDescription("Read raw secondary callgraph...");
            callgraph2 = binExportReader2.readCallgraph();
        }
        else {
            final FunctionDiffMetaData functionDiffMetaData = (FunctionDiffMetaData)diff.getMetaData();
            final RawFunction rawFunction = new RawFunction(diff.getMatches().getFunctionMatches()[0].getIAddress(ESide.PRIMARY), functionDiffMetaData.getFunctionName(ESide.PRIMARY), functionDiffMetaData.getFunctionType(ESide.PRIMARY), ESide.PRIMARY);
            final ArrayList<RawFunction> list = new ArrayList<RawFunction>();
            list.add(rawFunction);
            callgraph = new RawCallGraph(list, new ArrayList(), ESide.PRIMARY);
            final RawFunction rawFunction2 = new RawFunction(diff.getMatches().getFunctionMatches()[0].getIAddress(ESide.SECONDARY), functionDiffMetaData.getFunctionName(ESide.SECONDARY), functionDiffMetaData.getFunctionType(ESide.SECONDARY), ESide.SECONDARY);
            final ArrayList<RawFunction> list2 = new ArrayList<RawFunction>();
            list2.add(rawFunction2);
            callgraph2 = new RawCallGraph(list2, new ArrayList(), ESide.SECONDARY);
            try (final MatchesDatabase matchesDatabase = new MatchesDatabase(diff.getMatchesDatabase())) {
                matchesDatabase.setFunctionDiffCounts(rawFunction, rawFunction2);
            }
        }
        diff.setCallgraph(callgraph, ESide.PRIMARY);
        diff.setCallgraph(callgraph2, ESide.SECONDARY);
        if (!diff.isFunctionDiff()) {
            this.setSubDescription("Preprocessing raw primary flowgraphs...");
            binExportReader.readFlowgraphsStatistics(diff);
            this.setSubDescription("Preprocessing raw secondary flowgraphs...");
            binExportReader2.readFlowgraphsStatistics(diff);
        }
    }
    
    private void loadSingleFunctionDiffRawCallgraphs(final Diff diff, final FunctionDiffSocketXmlData functionDiffSocketXmlData) {
        final BinExportReader binExportReader = new BinExportReader(diff.getExportFile(ESide.PRIMARY), ESide.PRIMARY);
        final BinExportReader binExportReader2 = new BinExportReader(diff.getExportFile(ESide.SECONDARY), ESide.SECONDARY);
        this.setSubDescription("Read raw primary callgraph...");
        diff.setCallgraph(binExportReader.readSingleFunctionDiffCallgraph(functionDiffSocketXmlData), ESide.PRIMARY);
        this.setSubDescription("Read raw secondary callgraph...");
        diff.setCallgraph(binExportReader2.readSingleFunctionDiffCallgraph(functionDiffSocketXmlData), ESide.SECONDARY);
    }
    
    private void setCallMatches(final Diff diff) {
        final File matchesDatabase = diff.getMatchesDatabase();
        if (!matchesDatabase.exists()) {
            throw new IOException(String.format("Couldn't find '%s%s%s'.", matchesDatabase.getPath(), File.separator, matchesDatabase.getName()));
        }
        try (final MatchesDatabase matchesDatabase2 = new MatchesDatabase(matchesDatabase)) {
            int n = 0;
            final Map loadMatchedCallAddresses = matchesDatabase2.loadMatchedCallAddresses(diff);
            final ImmutableMap uniqueIndex = Maps.uniqueIndex(diff.getCallgraph(ESide.SECONDARY).getEdges(), new DiffLoader$2(this));
            for (final RawCall rawCall : diff.getCallgraph(ESide.PRIMARY).getEdges()) {
                final RawFunction rawFunction = (RawFunction)rawCall.getSource();
                final RawFunction rawFunction2 = (RawFunction)rawCall.getTarget();
                final long long1 = rawFunction.getAddress().toLong();
                final long long2 = rawCall.getSourceInstructionAddr().toLong();
                if (rawFunction.getMatchedFunction() != null && rawFunction2.getMatchedFunction() != null) {
                    final long long3 = rawFunction.getMatchedFunction().getAddress().toLong();
                    final long long4 = rawFunction2.getMatchedFunction().getAddress().toLong();
                    final AddressPair addressPair = loadMatchedCallAddresses.get(new AddressPair(long1, long2));
                    if (addressPair == null) {
                        continue;
                    }
                    final RawCall rawCall2 = (RawCall)uniqueIndex.get(new AddressTriple(long3, long4, addressPair.getAddress(ESide.SECONDARY)));
                    if (rawCall2 == null) {
                        continue;
                    }
                    rawCall.setMatchState(true, rawCall2);
                    rawCall2.setMatchState(true, rawCall);
                    ++n;
                }
            }
            final HashMap<AddressPair, Stack<?>> hashMap = (HashMap<AddressPair, Stack<?>>)new HashMap<Object, Stack<?>>();
            for (final RawCall rawCall3 : diff.getCallgraph(ESide.SECONDARY).getEdges()) {
                if (rawCall3.getMatchedCall() == null) {
                    final AddressPair addressPair2 = new AddressPair(((RawFunction)rawCall3.getSource()).getAddress().toLong(), rawCall3.getSourceInstructionAddr().toLong());
                    Stack<?> stack = hashMap.get(addressPair2);
                    if (stack == null) {
                        stack = new Stack<Object>();
                        hashMap.put(addressPair2, stack);
                    }
                    stack.push(rawCall3);
                }
            }
            int sizeOfChangedCalls = 0;
            for (final RawCall rawCall4 : diff.getCallgraph(ESide.PRIMARY).getEdges()) {
                if (rawCall4.getMatchedCall() == null) {
                    final long long5 = ((RawFunction)rawCall4.getSource()).getAddress().toLong();
                    final long long6 = rawCall4.getSourceInstructionAddr().toLong();
                    if (((RawFunction)rawCall4.getSource()).getMatchedFunction() == null) {
                        continue;
                    }
                    final AddressPair addressPair3 = loadMatchedCallAddresses.get(new AddressPair(long5, long6));
                    if (addressPair3 == null) {
                        continue;
                    }
                    final Stack<?> stack2 = hashMap.get(addressPair3);
                    if (stack2 == null || stack2.size() <= 0) {
                        continue;
                    }
                    final RawCall rawCall5 = (RawCall)stack2.pop();
                    rawCall4.setMatchState(false, rawCall5);
                    rawCall5.setMatchState(false, rawCall4);
                    ++sizeOfChangedCalls;
                }
            }
            diff.getMatches().setSizeOfMatchedCalls(n + sizeOfChangedCalls);
            diff.getMatches().setSizeOfChangedCalls(sizeOfChangedCalls);
        }
    }
    
    private void setChangedFunctionsCount(final Diff diff) {
        int sizeOfChangedFunctions = 0;
        final Iterator<RawFunction> iterator = (Iterator<RawFunction>)diff.getCallgraph(ESide.PRIMARY).getNodes().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().isChanged()) {
                ++sizeOfChangedFunctions;
            }
        }
        diff.getMatches().setSizeOfChangedFunctions(sizeOfChangedFunctions);
    }
    
    private void setFunctionMatches(final Diff diff) {
        final RawCallGraph callgraph = diff.getCallgraph(ESide.PRIMARY);
        final RawCallGraph callgraph2 = diff.getCallgraph(ESide.SECONDARY);
        for (final FunctionMatchData functionMatchData : diff.getMatches().getFunctionMatches()) {
            final RawFunction function = callgraph.getFunction(functionMatchData.getIAddress(ESide.PRIMARY));
            final RawFunction function2 = callgraph2.getFunction(functionMatchData.getIAddress(ESide.SECONDARY));
            if (function != null && function2 != null) {
                function.setMatch(function2, functionMatchData);
                function2.setMatch(function, functionMatchData);
            }
        }
    }
    
    private void setSubDescription(final String subDescription) {
        if (this.descriptionTarget != null) {
            this.descriptionTarget.setSubDescription(subDescription);
        }
    }
    
    private void validateInputFiles(final Diff diff) {
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
        if (!diff.getExportFile(ESide.SECONDARY).canRead()) {
            throw new IOException("Load Diff graphs failed. Couldn't read secondary exported call graph file.");
        }
    }
    
    @Override
    public void execute() {
        final Iterator iterator = this.diffs.iterator();
        while (iterator.hasNext()) {
            this.loadDiff(iterator.next());
        }
    }
    
    public void loadDiff(final Diff diff, final FunctionDiffSocketXmlData functionDiffSocketXmlData) {
        if (diff.isLoaded()) {
            Logger.logInfo("Single function diff is already loaded! Loading process canceled.", new Object[0]);
            return;
        }
        if (this.descriptionTarget != null) {
            this.descriptionTarget.setDescription(String.format("Loading Diff '%s'", diff.getDiffName()));
        }
        Logger.logInfo("Loading single function diff '%s'", diff.getDiffName());
        this.validateInputFiles(diff);
        boolean b = false;
        try {
            this.loadSingleFunctionDiffRawCallgraphs(diff, functionDiffSocketXmlData);
            this.setSubDescription("Loading function matches...");
            this.loadDiffMatches(diff);
            this.setSubDescription("Setting function matches...");
            this.setFunctionMatches(diff);
            this.setChangedFunctionsCount(diff);
        }
        catch (IOException ex2) {}
        catch (SQLException ex) {
            b = true;
            Logger.logException(ex, "");
            final String s = "Load Diff graphs failed: ";
            final String value = String.valueOf(ex.getMessage());
            throw new IOException((value.length() != 0) ? s.concat(value) : new String(s));
        }
        finally {
            diff.setLoaded(!b);
        }
        this.setSubDescription("Preparing UI...");
        if (diff.isFunctionDiff()) {
            SwingUtilities.invokeLater(new DiffLoader$3(this, diff));
        }
    }
    
    public void setProgressDescriptionTarget(final IProgressDescription descriptionTarget) {
        this.descriptionTarget = descriptionTarget;
    }
}
