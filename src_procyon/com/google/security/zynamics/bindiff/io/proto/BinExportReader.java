package com.google.security.zynamics.bindiff.io.proto;

import java.io.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.protobuf.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.protos.BinExport.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import java.util.*;
import com.google.security.zynamics.bindiff.io.matches.*;

public class BinExportReader
{
    private static final byte ANTERIOR_COMMENT_TYPE_BIT = 3;
    private final File file;
    private final ESide side;
    private final int metaOffset;
    private final int callgraphOffset;
    private final long[] flowgraphAddrs;
    private final int[] flowgraphFileOffsets;
    private int addressSpaceBits;
    private String architectureName;
    private int maxMnemonicLen;
    
    public BinExportReader(final File file, final ESide side) {
        this.file = file;
        this.side = side;
        try (final BufferedInputStream openStream = openStream(file)) {
            this.metaOffset = IoReaderUtils.readIntegerValue(openStream, 4);
            this.callgraphOffset = IoReaderUtils.readIntegerValue(openStream, 4);
            final int integerValue = IoReaderUtils.readIntegerValue(openStream, 4);
            this.flowgraphAddrs = new long[integerValue];
            this.flowgraphFileOffsets = new int[integerValue];
            this.readFlowgraphOffsets(openStream);
            final BinExport$Meta from = BinExport$Meta.parseFrom(new LimitedInputStream(openStream, this.callgraphOffset - this.metaOffset));
            this.addressSpaceBits = (from.hasInputAddressSpace() ? from.getInputAddressSpace() : 32);
            this.architectureName = (from.hasArchitectureName() ? from.getArchitectureName() : new StringBuilder(19).append("GENERIC-").append(this.addressSpaceBits).toString());
            this.maxMnemonicLen = (from.hasMaxMnemonicLen() ? from.getMaxMnemonicLen() : 12);
        }
        catch (IOException ex) {
            final String s = "Couldn't read exported file header: ";
            final String value = String.valueOf(ex.getMessage());
            throw new IOException((value.length() != 0) ? s.concat(value) : new String(s), ex);
        }
    }
    
    private static BufferedInputStream openStream(final File file) {
        if (!file.exists()) {
            throw new IOException("Load Diff graphs failed. BinExport binary does not exist.");
        }
        if (!file.canRead()) {
            throw new IOException("Load Diff graphs failed. BinExport binary couldn't be read.");
        }
        try {
            return new BufferedInputStream(new FileInputStream(file));
        }
        catch (IOException ex) {
            final String s = "Load Diff graphs failed. Could not load BinExport file: ";
            final String value = String.valueOf(ex.getMessage());
            throw new IOException((value.length() != 0) ? s.concat(value) : new String(s), ex);
        }
    }
    
    private long getFunctionAddress(final int n) {
        int n2 = 0;
        final int[] flowgraphFileOffsets = this.flowgraphFileOffsets;
        for (int length = flowgraphFileOffsets.length, i = 0; i < length; ++i) {
            if (flowgraphFileOffsets[i] == n) {
                return this.flowgraphAddrs[n2];
            }
            ++n2;
        }
        throw new IOException("Illegal flow graph offset. Couldn't find entry address.");
    }
    
    private List readBasicblocks(final Diff diff, final FunctionMatchData functionMatchData, final BinExport$Flowgraph binExport$Flowgraph) {
        final ArrayList<RawBasicBlock> list = new ArrayList<RawBasicBlock>();
        try {
            final CAddress cAddress = new CAddress(binExport$Flowgraph.getAddress());
            final String name = diff.getCallgraph(this.side).getFunction(cAddress).getName();
            for (final BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex : binExport$Flowgraph.getVerticesList()) {
                EMatchState matched = (this.side == ESide.PRIMARY) ? EMatchState.PRIMARY_UNMATCHED : EMatchState.SECONDRAY_UNMATCHED;
                final CAddress cAddress2 = new CAddress(binExport$Flowgraph$Vertex.getInstructions(0).getAddress());
                if (functionMatchData != null && functionMatchData.getBasicblockMatch(cAddress2, this.side) != null) {
                    matched = EMatchState.MATCHED;
                }
                list.add(new RawBasicBlock(cAddress, name, cAddress2, this.readInstructions(binExport$Flowgraph$Vertex, this.maxMnemonicLen), binExport$Flowgraph$Vertex.getPrime(), this.side, matched));
            }
        }
        catch (Exception ex) {
            throw new IOException("Couldn't read exported basicblocks. Failed to read flowgraph.", ex);
        }
        return list;
    }
    
    private void readFlowgraphOffsets(final InputStream inputStream) {
        try {
            for (int i = 0; i < this.flowgraphAddrs.length; ++i) {
                this.flowgraphAddrs[i] = IoReaderUtils.readLongValue(inputStream, 8);
                this.flowgraphFileOffsets[i] = IoReaderUtils.readIntegerValue(inputStream, 4);
            }
        }
        catch (Exception ex) {
            throw new IOException("Couldn't read exported file header. Failed to read flow graph offsets.");
        }
    }
    
    private SortedMap readInstructions(final BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex, final int n) {
        final TreeMap<CAddress, RawInstruction> treeMap = new TreeMap<CAddress, RawInstruction>();
        try {
            for (final BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction : binExport$Flowgraph$Vertex.getInstructionsList()) {
                final CAddress cAddress = new CAddress(binExport$Flowgraph$Vertex$Instruction.getAddress());
                final String mnemonic = binExport$Flowgraph$Vertex$Instruction.getMnemonic();
                final byte[] byteArray = binExport$Flowgraph$Vertex$Instruction.getRawBytes().toByteArray();
                final byte[] byteArray2 = ByteString.copyFromUtf8(binExport$Flowgraph$Vertex$Instruction.getOperands()).toByteArray();
                int n2 = 0;
                final long[] array = new long[binExport$Flowgraph$Vertex$Instruction.getCallTargetsCount()];
                final Iterator iterator2 = binExport$Flowgraph$Vertex$Instruction.getCallTargetsList().iterator();
                while (iterator2.hasNext()) {
                    array[n2++] = iterator2.next();
                }
                final ArrayList list = (binExport$Flowgraph$Vertex$Instruction.getCommentsCount() == 0) ? null : new ArrayList<RawInstructionComment>();
                for (final BinExport$Flowgraph$Vertex$Instruction$Comment binExport$Flowgraph$Vertex$Instruction$Comment : binExport$Flowgraph$Vertex$Instruction.getCommentsList()) {
                    final String comment = binExport$Flowgraph$Vertex$Instruction$Comment.getComment();
                    final int n3 = binExport$Flowgraph$Vertex$Instruction$Comment.getFlags() >> 1 & 0xF;
                    ECommentPlacement eCommentPlacement = ECommentPlacement.BEHIND_LINE;
                    if (FlagUtils.parseFlag(n3, (byte)3)) {
                        eCommentPlacement = ECommentPlacement.ABOVE_LINE;
                    }
                    list.add(new RawInstructionComment(comment, eCommentPlacement));
                }
                treeMap.put(cAddress, new RawInstruction(cAddress, mnemonic, n, byteArray, byteArray2, array, list, binExport$Flowgraph$Vertex$Instruction.getPrime()));
            }
        }
        catch (Exception ex) {
            throw new IOException("Couldn't read exported instructions. Failed to read flowgraph.", ex);
        }
        return treeMap;
    }
    
    private List readJumps(final BinExport$Flowgraph binExport$Flowgraph, final List list) {
        final ArrayList<RawJump> list2 = new ArrayList<RawJump>();
        try {
            final HashMap<Object, RawBasicBlock> hashMap = new HashMap<Object, RawBasicBlock>();
            for (final RawBasicBlock rawBasicBlock : list) {
                hashMap.put(rawBasicBlock.getAddress().toLong(), rawBasicBlock);
            }
            for (final BinExport$Flowgraph$Edge binExport$Flowgraph$Edge : binExport$Flowgraph.getEdgesList()) {
                list2.add(new RawJump(hashMap.get(binExport$Flowgraph$Edge.getSourceAddress()), hashMap.get(binExport$Flowgraph$Edge.getTargetAddress()), this.translateJumpType(binExport$Flowgraph$Edge.getType().getNumber())));
            }
        }
        catch (Exception ex) {
            throw new IOException("Couldn't read exported jumps. Failed to read flowgraph.", ex);
        }
        return list2;
    }
    
    private void setSizeOfFlowgraphElements(final Diff diff, final BinExport$Flowgraph binExport$Flowgraph) {
        final RawFunction function = diff.getCallgraph(this.side).getFunction(new CAddress(binExport$Flowgraph.getAddress()));
        function.setSizeOfBasicblocks(binExport$Flowgraph.getVerticesCount());
        function.setSizeOfJumps(binExport$Flowgraph.getEdgesCount());
        int sizeOfInstructions = 0;
        final Iterator<BinExport$Flowgraph$Vertex> iterator = binExport$Flowgraph.getVerticesList().iterator();
        while (iterator.hasNext()) {
            sizeOfInstructions += iterator.next().getInstructionsCount();
        }
        function.setSizeOfInstructions(sizeOfInstructions);
    }
    
    private EFunctionType translateFunctionType(int n) {
        if (n == 2) {
            n = 3;
        }
        else if (n == 3) {
            n = 2;
        }
        return EFunctionType.getType(n);
    }
    
    private EJumpType translateJumpType(final int n) {
        return EJumpType.getType(n - 1);
    }
    
    public RawCallGraph readCallgraph() {
        try (final BufferedInputStream openStream = openStream(this.file)) {
            IoReaderUtils.skip(openStream, this.callgraphOffset);
            final BinExport$Callgraph from = BinExport$Callgraph.parseFrom(new LimitedInputStream(openStream, this.flowgraphFileOffsets[0] - this.callgraphOffset));
            final HashMap<CAddress, RawFunction> hashMap = new HashMap<CAddress, RawFunction>();
            final ArrayList list = new ArrayList();
            final ArrayList<RawCall> list2 = new ArrayList<RawCall>();
            if (from.isInitialized()) {
                for (final BinExport$Callgraph$Vertex binExport$Callgraph$Vertex : from.getVerticesList()) {
                    final CAddress cAddress = new CAddress(binExport$Callgraph$Vertex.getAddress());
                    hashMap.put(cAddress, new RawFunction(cAddress, binExport$Callgraph$Vertex.getMangledName(), this.translateFunctionType(binExport$Callgraph$Vertex.getFunctionType().getNumber()), this.side));
                }
                for (final BinExport$Callgraph$Edge binExport$Callgraph$Edge : from.getEdgesList()) {
                    final CAddress cAddress2 = new CAddress(binExport$Callgraph$Edge.getSourceFunctionAddress());
                    final CAddress cAddress3 = new CAddress(binExport$Callgraph$Edge.getTargetAddress());
                    final CAddress cAddress4 = new CAddress(binExport$Callgraph$Edge.getSourceInstructionAddress());
                    final RawFunction rawFunction = hashMap.get(cAddress2);
                    final RawFunction rawFunction2 = hashMap.get(cAddress3);
                    if (rawFunction == null || rawFunction2 == null) {
                        throw new IOException("Load diff failed. Couldn't load malformed callgraph.");
                    }
                    list2.add(new RawCall(rawFunction, rawFunction2, cAddress4, this.side));
                }
                list.addAll(hashMap.values());
                return new RawCallGraph(list, list2, this.side);
            }
            throw new IOException("Load diff faileed. Not all required BinExport protocol buffer message fields have been set.");
        }
        catch (IOException ex) {
            final String s = "Couldn't load exported binary: ";
            final String value = String.valueOf(ex.getMessage());
            throw new IOException((value.length() != 0) ? s.concat(value) : new String(s), ex);
        }
    }
    
    public RawFlowGraph readFlowgraph(final Diff diff, final IAddress address) {
        try (final BufferedInputStream openStream = openStream(this.file)) {
            final int binarySearch = Arrays.binarySearch(this.flowgraphAddrs, address.toLong());
            if (binarySearch < 0) {
                throw new IOException("Couldn't find file offset.");
            }
            IoReaderUtils.skip(openStream, this.flowgraphFileOffsets[binarySearch]);
            BinExport$Flowgraph binExport$Flowgraph;
            if (binarySearch == this.flowgraphFileOffsets.length - 1) {
                binExport$Flowgraph = BinExport$Flowgraph.parseFrom(openStream);
            }
            else {
                binExport$Flowgraph = BinExport$Flowgraph.parseFrom(new LimitedInputStream(openStream, this.flowgraphFileOffsets[binarySearch + 1] - this.flowgraphFileOffsets[binarySearch]));
            }
            final CAddress cAddress = new CAddress(binExport$Flowgraph.getAddress());
            final RawFunction function = diff.getCallgraph(this.side).getFunction(cAddress);
            final String name = function.getName();
            final EFunctionType functionType = function.getFunctionType();
            final List basicblocks = this.readBasicblocks(diff, function.getFunctionMatch(), binExport$Flowgraph);
            return new RawFlowGraph(cAddress, name, functionType, basicblocks, this.readJumps(binExport$Flowgraph, basicblocks), this.side);
        }
        catch (Exception ex) {
            final String s = "Could not read flowgraph: ";
            final String value = String.valueOf(ex.getMessage());
            throw new IOException((value.length() != 0) ? s.concat(value) : new String(s), ex);
        }
    }
    
    public void readFlowgraphsStatistics(final Diff diff) {
        try (final BufferedInputStream openStream = openStream(this.file)) {
            IoReaderUtils.skip(openStream, this.flowgraphFileOffsets[0]);
            for (int i = 0; i < this.flowgraphFileOffsets.length - 1; ++i) {
                this.setSizeOfFlowgraphElements(diff, BinExport$Flowgraph.parseFrom(new LimitedInputStream(openStream, this.flowgraphFileOffsets[i + 1] - this.flowgraphFileOffsets[i])));
            }
            this.setSizeOfFlowgraphElements(diff, BinExport$Flowgraph.parseFrom(openStream));
        }
        catch (IOException ex) {
            final String s = "Couldn't read flow graphs statistics: ";
            final String value = String.valueOf(ex.getMessage());
            throw new IOException((value.length() != 0) ? s.concat(value) : new String(s), ex);
        }
    }
    
    public RawCallGraph readSingleFunctionDiffCallgraph(final FunctionDiffSocketXmlData functionDiffSocketXmlData) {
        try (final BufferedInputStream openStream = openStream(this.file)) {
            IoReaderUtils.skip(openStream, this.callgraphOffset);
            final BinExport$Callgraph from = BinExport$Callgraph.parseFrom(new LimitedInputStream(openStream, this.flowgraphFileOffsets[0] - this.callgraphOffset));
            final ArrayList<RawFunction> list = new ArrayList<RawFunction>();
            final ArrayList list2 = new ArrayList();
            final long functionAddress = this.getFunctionAddress(functionDiffSocketXmlData.getFlowgraphOffset(this.side));
            if (from.isInitialized()) {
                for (final BinExport$Callgraph$Vertex binExport$Callgraph$Vertex : from.getVerticesList()) {
                    if (functionAddress == binExport$Callgraph$Vertex.getAddress()) {
                        list.add(new RawFunction(new CAddress(functionAddress), binExport$Callgraph$Vertex.getMangledName(), this.translateFunctionType(binExport$Callgraph$Vertex.getFunctionType().getNumber()), this.side));
                        break;
                    }
                }
                return new RawCallGraph(list, list2, this.side);
            }
            throw new IOException("Load diff faileed. Not all required BinExport protocol buffer message fields have been set.");
        }
        catch (IOException ex) {
            final String s = "Couldn't load exported binary: ";
            final String value = String.valueOf(ex.getMessage());
            throw new IOException((value.length() != 0) ? s.concat(value) : new String(s), ex);
        }
    }
    
    public int getAddressSpaceBits() {
        return this.addressSpaceBits;
    }
    
    public String getArchitectureName() {
        return this.architectureName;
    }
    
    public int getMaxMnemonicLen() {
        return this.maxMnemonicLen;
    }
}
