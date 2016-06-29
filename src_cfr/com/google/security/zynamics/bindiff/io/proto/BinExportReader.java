/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.io.proto;

import com.google.protobuf.ByteString;
import com.google.protos.BinExport.BinExport$Callgraph;
import com.google.protos.BinExport.BinExport$Callgraph$Edge;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex$FunctionType;
import com.google.protos.BinExport.BinExport$Flowgraph;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge$EdgeType;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction;
import com.google.protos.BinExport.BinExport$Meta;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.EJumpType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.io.matches.FunctionDiffSocketXmlData;
import com.google.security.zynamics.bindiff.io.proto.LimitedInputStream;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstructionComment;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;
import com.google.security.zynamics.bindiff.utils.FlagUtils;
import com.google.security.zynamics.bindiff.utils.IoReaderUtils;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class BinExportReader {
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

    public BinExportReader(File file, ESide eSide) {
        this.file = file;
        this.side = eSide;
        try {
            BufferedInputStream bufferedInputStream = BinExportReader.openStream(file);
            Throwable throwable = null;
            try {
                String string;
                this.metaOffset = IoReaderUtils.readIntegerValue(bufferedInputStream, 4);
                this.callgraphOffset = IoReaderUtils.readIntegerValue(bufferedInputStream, 4);
                int n2 = IoReaderUtils.readIntegerValue(bufferedInputStream, 4);
                this.flowgraphAddrs = new long[n2];
                this.flowgraphFileOffsets = new int[n2];
                this.readFlowgraphOffsets(bufferedInputStream);
                LimitedInputStream limitedInputStream = new LimitedInputStream(bufferedInputStream, this.callgraphOffset - this.metaOffset);
                BinExport$Meta binExport$Meta = BinExport$Meta.parseFrom(limitedInputStream);
                int n3 = this.addressSpaceBits = binExport$Meta.hasInputAddressSpace() ? binExport$Meta.getInputAddressSpace() : 32;
                if (binExport$Meta.hasArchitectureName()) {
                    string = binExport$Meta.getArchitectureName();
                } else {
                    int n4 = this.addressSpaceBits;
                    string = new StringBuilder(19).append("GENERIC-").append(n4).toString();
                }
                this.architectureName = string;
                this.maxMnemonicLen = binExport$Meta.hasMaxMnemonicLen() ? binExport$Meta.getMaxMnemonicLen() : 12;
                return;
            }
            catch (Throwable var5_8) {
                throwable = var5_8;
                throw var5_8;
            }
            finally {
                if (bufferedInputStream != null) {
                    if (throwable != null) {
                        try {
                            bufferedInputStream.close();
                        }
                        catch (Throwable var5_7) {
                            throwable.addSuppressed(var5_7);
                        }
                    } else {
                        bufferedInputStream.close();
                    }
                }
            }
        }
        catch (IOException var3_4) {
            String string;
            String string2 = String.valueOf(var3_4.getMessage());
            if (string2.length() != 0) {
                string = "Couldn't read exported file header: ".concat(string2);
                throw new IOException(string, var3_4);
            }
            string = new String("Couldn't read exported file header: ");
            throw new IOException(string, var3_4);
        }
    }

    private static BufferedInputStream openStream(File file) {
        if (!file.exists()) {
            throw new IOException("Load Diff graphs failed. BinExport binary does not exist.");
        }
        if (!file.canRead()) {
            throw new IOException("Load Diff graphs failed. BinExport binary couldn't be read.");
        }
        try {
            return new BufferedInputStream(new FileInputStream(file));
        }
        catch (IOException var1_1) {
            String string;
            String string2 = String.valueOf(var1_1.getMessage());
            if (string2.length() != 0) {
                string = "Load Diff graphs failed. Could not load BinExport file: ".concat(string2);
                throw new IOException(string, var1_1);
            }
            string = new String("Load Diff graphs failed. Could not load BinExport file: ");
            throw new IOException(string, var1_1);
        }
    }

    private long getFunctionAddress(int n2) {
        int n3 = 0;
        int[] arrn = this.flowgraphFileOffsets;
        int n4 = arrn.length;
        int n5 = 0;
        while (n5 < n4) {
            int n6 = arrn[n5];
            if (n6 == n2) {
                return this.flowgraphAddrs[n3];
            }
            ++n3;
            ++n5;
        }
        throw new IOException("Illegal flow graph offset. Couldn't find entry address.");
    }

    private List readBasicblocks(Diff diff, FunctionMatchData functionMatchData, BinExport$Flowgraph binExport$Flowgraph) {
        ArrayList<RawBasicBlock> arrayList = new ArrayList<RawBasicBlock>();
        try {
            CAddress cAddress = new CAddress(binExport$Flowgraph.getAddress());
            String string = diff.getCallgraph(this.side).getFunction(cAddress).getName();
            Iterator iterator = binExport$Flowgraph.getVerticesList().iterator();
            while (iterator.hasNext()) {
                BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex = (BinExport$Flowgraph$Vertex)iterator.next();
                EMatchState eMatchState = this.side == ESide.PRIMARY ? EMatchState.PRIMARY_UNMATCHED : EMatchState.SECONDRAY_UNMATCHED;
                CAddress cAddress2 = new CAddress(binExport$Flowgraph$Vertex.getInstructions(0).getAddress());
                BasicBlockMatchData basicBlockMatchData = null;
                if (functionMatchData != null && (basicBlockMatchData = functionMatchData.getBasicblockMatch(cAddress2, this.side)) != null) {
                    eMatchState = EMatchState.MATCHED;
                }
                SortedMap sortedMap = this.readInstructions(binExport$Flowgraph$Vertex, this.maxMnemonicLen);
                long l2 = binExport$Flowgraph$Vertex.getPrime();
                RawBasicBlock rawBasicBlock = new RawBasicBlock(cAddress, string, cAddress2, sortedMap, l2, this.side, eMatchState);
                arrayList.add(rawBasicBlock);
            }
            return arrayList;
        }
        catch (Exception var5_6) {
            throw new IOException("Couldn't read exported basicblocks. Failed to read flowgraph.", var5_6);
        }
    }

    private void readFlowgraphOffsets(InputStream inputStream) {
        try {
            int n2 = 0;
            while (n2 < this.flowgraphAddrs.length) {
                this.flowgraphAddrs[n2] = IoReaderUtils.readLongValue(inputStream, 8);
                this.flowgraphFileOffsets[n2] = IoReaderUtils.readIntegerValue(inputStream, 4);
                ++n2;
            }
            return;
        }
        catch (Exception var2_3) {
            throw new IOException("Couldn't read exported file header. Failed to read flow graph offsets.");
        }
    }

    private SortedMap readInstructions(BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex, int n2) {
        TreeMap<CAddress, Object> treeMap = new TreeMap<CAddress, Object>();
        try {
            Iterator iterator = binExport$Flowgraph$Vertex.getInstructionsList().iterator();
            while (iterator.hasNext()) {
                Object object2;
                BinExport$Flowgraph$Vertex$Instruction binExport$Flowgraph$Vertex$Instruction = (BinExport$Flowgraph$Vertex$Instruction)iterator.next();
                CAddress cAddress = new CAddress(binExport$Flowgraph$Vertex$Instruction.getAddress());
                String string = binExport$Flowgraph$Vertex$Instruction.getMnemonic();
                byte[] arrby = binExport$Flowgraph$Vertex$Instruction.getRawBytes().toByteArray();
                byte[] arrby2 = ByteString.copyFromUtf8(binExport$Flowgraph$Vertex$Instruction.getOperands()).toByteArray();
                int n3 = 0;
                long[] arrl = new long[binExport$Flowgraph$Vertex$Instruction.getCallTargetsCount()];
                Iterator iterator2 = binExport$Flowgraph$Vertex$Instruction.getCallTargetsList().iterator();
                while (iterator2.hasNext()) {
                    long l2 = (Long)iterator2.next();
                    arrl[n3++] = l2;
                }
                int n4 = binExport$Flowgraph$Vertex$Instruction.getCommentsCount();
                ArrayList<RawInstructionComment> arrayList = n4 == 0 ? null : new ArrayList<RawInstructionComment>();
                for (Object object2 : binExport$Flowgraph$Vertex$Instruction.getCommentsList()) {
                    String string2 = object2.getComment();
                    int n5 = object2.getFlags() >> 1 & 15;
                    ECommentPlacement eCommentPlacement = ECommentPlacement.BEHIND_LINE;
                    if (FlagUtils.parseFlag(n5, 3)) {
                        eCommentPlacement = ECommentPlacement.ABOVE_LINE;
                    }
                    RawInstructionComment rawInstructionComment = new RawInstructionComment(string2, eCommentPlacement);
                    arrayList.add(rawInstructionComment);
                }
                int n6 = binExport$Flowgraph$Vertex$Instruction.getPrime();
                object2 = new RawInstruction(cAddress, string, n2, arrby, arrby2, arrl, arrayList, n6);
                treeMap.put(cAddress, object2);
            }
            return treeMap;
        }
        catch (Exception var4_5) {
            throw new IOException("Couldn't read exported instructions. Failed to read flowgraph.", var4_5);
        }
    }

    private List readJumps(BinExport$Flowgraph binExport$Flowgraph, List list) {
        ArrayList<RawJump> arrayList = new ArrayList<RawJump>();
        try {
            HashMap<Long, RawBasicBlock> hashMap = new HashMap<Long, RawBasicBlock>();
            for (Object object2 : list) {
                hashMap.put(object2.getAddress().toLong(), (RawBasicBlock)object2);
            }
            Iterator iterator = binExport$Flowgraph.getEdgesList().iterator();
            while (iterator.hasNext()) {
                Object object2;
                object2 = (BinExport$Flowgraph$Edge)iterator.next();
                RawBasicBlock rawBasicBlock = (RawBasicBlock)hashMap.get(object2.getSourceAddress());
                RawBasicBlock rawBasicBlock2 = (RawBasicBlock)hashMap.get(object2.getTargetAddress());
                EJumpType eJumpType = this.translateJumpType(object2.getType().getNumber());
                arrayList.add(new RawJump(rawBasicBlock, rawBasicBlock2, eJumpType));
            }
            return arrayList;
        }
        catch (Exception var4_5) {
            throw new IOException("Couldn't read exported jumps. Failed to read flowgraph.", var4_5);
        }
    }

    private void setSizeOfFlowgraphElements(Diff diff, BinExport$Flowgraph binExport$Flowgraph) {
        CAddress cAddress = new CAddress(binExport$Flowgraph.getAddress());
        RawFunction rawFunction = diff.getCallgraph(this.side).getFunction(cAddress);
        rawFunction.setSizeOfBasicblocks(binExport$Flowgraph.getVerticesCount());
        rawFunction.setSizeOfJumps(binExport$Flowgraph.getEdgesCount());
        int n2 = 0;
        Iterator iterator = binExport$Flowgraph.getVerticesList().iterator();
        do {
            if (!iterator.hasNext()) {
                rawFunction.setSizeOfInstructions(n2);
                return;
            }
            BinExport$Flowgraph$Vertex binExport$Flowgraph$Vertex = (BinExport$Flowgraph$Vertex)iterator.next();
            n2 += binExport$Flowgraph$Vertex.getInstructionsCount();
        } while (true);
    }

    private EFunctionType translateFunctionType(int n2) {
        if (n2 == 2) {
            n2 = 3;
            return EFunctionType.getType(n2);
        }
        if (n2 != 3) return EFunctionType.getType(n2);
        n2 = 2;
        return EFunctionType.getType(n2);
    }

    private EJumpType translateJumpType(int n2) {
        return EJumpType.getType(n2 - 1);
    }

    public RawCallGraph readCallgraph() {
        try {
            BufferedInputStream bufferedInputStream = BinExportReader.openStream(this.file);
            Throwable throwable = null;
            try {
                Object object;
                Object object2;
                Object object32;
                Object object4;
                Object object5;
                IoReaderUtils.skip(bufferedInputStream, this.callgraphOffset);
                int n2 = this.flowgraphFileOffsets[0] - this.callgraphOffset;
                LimitedInputStream limitedInputStream = new LimitedInputStream(bufferedInputStream, n2);
                BinExport$Callgraph binExport$Callgraph = BinExport$Callgraph.parseFrom(limitedInputStream);
                HashMap<Object, RawFunction> hashMap = new HashMap<Object, RawFunction>();
                ArrayList arrayList = new ArrayList();
                ArrayList<RawCall> arrayList2 = new ArrayList<RawCall>();
                if (!binExport$Callgraph.isInitialized()) throw new IOException("Load diff faileed. Not all required BinExport protocol buffer message fields have been set.");
                Iterable iterable = binExport$Callgraph.getVerticesList();
                for (Object object32 : iterable) {
                    object = new CAddress(object32.getAddress());
                    object5 = object32.getMangledName();
                    object4 = this.translateFunctionType(object32.getFunctionType().getNumber());
                    object2 = new RawFunction((IAddress)object, (String)object5, (EFunctionType)((Object)object4), this.side);
                    hashMap.put(object, (RawFunction)object2);
                }
                List list = binExport$Callgraph.getEdgesList();
                object32 = list.iterator();
                while (object32.hasNext()) {
                    object = (BinExport$Callgraph$Edge)object32.next();
                    object5 = new CAddress(object.getSourceFunctionAddress());
                    object4 = new CAddress(object.getTargetAddress());
                    object2 = new CAddress(object.getSourceInstructionAddress());
                    RawFunction rawFunction = (RawFunction)hashMap.get(object5);
                    RawFunction rawFunction2 = (RawFunction)hashMap.get(object4);
                    if (rawFunction == null) throw new IOException("Load diff failed. Couldn't load malformed callgraph.");
                    if (rawFunction2 == null) {
                        throw new IOException("Load diff failed. Couldn't load malformed callgraph.");
                    }
                    arrayList2.add(new RawCall(rawFunction, rawFunction2, (IAddress)object2, this.side));
                }
                arrayList.addAll(hashMap.values());
                iterable = new RawCallGraph(arrayList, arrayList2, this.side);
                return iterable;
            }
            catch (Throwable var3_5) {
                throwable = var3_5;
                throw var3_5;
            }
            finally {
                if (bufferedInputStream != null) {
                    if (throwable != null) {
                        try {
                            bufferedInputStream.close();
                        }
                        catch (Throwable var10_13) {
                            throwable.addSuppressed(var10_13);
                        }
                    } else {
                        bufferedInputStream.close();
                    }
                }
            }
        }
        catch (IOException var1_2) {
            String string;
            String string2 = String.valueOf(var1_2.getMessage());
            if (string2.length() != 0) {
                string = "Couldn't load exported binary: ".concat(string2);
                throw new IOException(string, var1_2);
            }
            string = new String("Couldn't load exported binary: ");
            throw new IOException(string, var1_2);
        }
    }

    public RawFlowGraph readFlowgraph(Diff diff, IAddress iAddress) {
        try {
            BufferedInputStream bufferedInputStream = BinExportReader.openStream(this.file);
            Throwable throwable = null;
            try {
                Object object;
                int n2 = Arrays.binarySearch(this.flowgraphAddrs, iAddress.toLong());
                if (n2 < 0) {
                    throw new IOException("Couldn't find file offset.");
                }
                BinExport$Flowgraph binExport$Flowgraph = null;
                IoReaderUtils.skip(bufferedInputStream, this.flowgraphFileOffsets[n2]);
                if (n2 == this.flowgraphFileOffsets.length - 1) {
                    binExport$Flowgraph = BinExport$Flowgraph.parseFrom(bufferedInputStream);
                } else {
                    int n3 = this.flowgraphFileOffsets[n2 + 1] - this.flowgraphFileOffsets[n2];
                    object = new LimitedInputStream(bufferedInputStream, n3);
                    binExport$Flowgraph = BinExport$Flowgraph.parseFrom((InputStream)object);
                }
                CAddress cAddress = new CAddress(binExport$Flowgraph.getAddress());
                object = diff.getCallgraph(this.side).getFunction(cAddress);
                String string = object.getName();
                EFunctionType eFunctionType = object.getFunctionType();
                FunctionMatchData functionMatchData = object.getFunctionMatch();
                List list = this.readBasicblocks(diff, functionMatchData, binExport$Flowgraph);
                List list2 = this.readJumps(binExport$Flowgraph, list);
                RawFlowGraph rawFlowGraph = new RawFlowGraph(cAddress, string, eFunctionType, list, list2, this.side);
                return rawFlowGraph;
            }
            catch (Throwable var5_7) {
                throwable = var5_7;
                throw var5_7;
            }
            finally {
                if (bufferedInputStream != null) {
                    if (throwable != null) {
                        try {
                            bufferedInputStream.close();
                        }
                        catch (Throwable var15_18) {
                            throwable.addSuppressed(var15_18);
                        }
                    } else {
                        bufferedInputStream.close();
                    }
                }
            }
        }
        catch (Exception var3_4) {
            String string;
            String string2 = String.valueOf(var3_4.getMessage());
            if (string2.length() != 0) {
                string = "Could not read flowgraph: ".concat(string2);
                throw new IOException(string, var3_4);
            }
            string = new String("Could not read flowgraph: ");
            throw new IOException(string, var3_4);
        }
    }

    public void readFlowgraphsStatistics(Diff diff) {
        try {
            BufferedInputStream bufferedInputStream = BinExportReader.openStream(this.file);
            Throwable throwable = null;
            try {
                IoReaderUtils.skip(bufferedInputStream, this.flowgraphFileOffsets[0]);
                for (int i2 = 0; i2 < this.flowgraphFileOffsets.length - 1; ++i2) {
                    int n2 = this.flowgraphFileOffsets[i2 + 1] - this.flowgraphFileOffsets[i2];
                    LimitedInputStream limitedInputStream = new LimitedInputStream(bufferedInputStream, n2);
                    BinExport$Flowgraph binExport$Flowgraph = BinExport$Flowgraph.parseFrom(limitedInputStream);
                    this.setSizeOfFlowgraphElements(diff, binExport$Flowgraph);
                }
                BinExport$Flowgraph binExport$Flowgraph = BinExport$Flowgraph.parseFrom(bufferedInputStream);
                this.setSizeOfFlowgraphElements(diff, binExport$Flowgraph);
                return;
            }
            catch (Throwable var4_8) {
                throwable = var4_8;
                throw var4_8;
            }
            finally {
                if (bufferedInputStream != null) {
                    if (throwable != null) {
                        try {
                            bufferedInputStream.close();
                        }
                        catch (Throwable var4_7) {
                            throwable.addSuppressed(var4_7);
                        }
                    } else {
                        bufferedInputStream.close();
                    }
                }
            }
        }
        catch (IOException var2_3) {
            String string;
            String string2 = String.valueOf(var2_3.getMessage());
            if (string2.length() != 0) {
                string = "Couldn't read flow graphs statistics: ".concat(string2);
                throw new IOException(string, var2_3);
            }
            string = new String("Couldn't read flow graphs statistics: ");
            throw new IOException(string, var2_3);
        }
    }

    public RawCallGraph readSingleFunctionDiffCallgraph(FunctionDiffSocketXmlData functionDiffSocketXmlData) {
        try {
            BufferedInputStream bufferedInputStream = BinExportReader.openStream(this.file);
            Throwable throwable = null;
            try {
                IoReaderUtils.skip(bufferedInputStream, this.callgraphOffset);
                int n2 = this.flowgraphFileOffsets[0] - this.callgraphOffset;
                LimitedInputStream limitedInputStream = new LimitedInputStream(bufferedInputStream, n2);
                BinExport$Callgraph binExport$Callgraph = BinExport$Callgraph.parseFrom(limitedInputStream);
                ArrayList<RawFunction> arrayList = new ArrayList<RawFunction>();
                ArrayList arrayList2 = new ArrayList();
                long l2 = this.getFunctionAddress(functionDiffSocketXmlData.getFlowgraphOffset(this.side));
                if (!binExport$Callgraph.isInitialized()) throw new IOException("Load diff faileed. Not all required BinExport protocol buffer message fields have been set.");
                Iterable iterable = binExport$Callgraph.getVerticesList();
                for (BinExport$Callgraph$Vertex binExport$Callgraph$Vertex : iterable) {
                    long l3 = binExport$Callgraph$Vertex.getAddress();
                    if (l2 != l3) continue;
                    String string = binExport$Callgraph$Vertex.getMangledName();
                    EFunctionType eFunctionType = this.translateFunctionType(binExport$Callgraph$Vertex.getFunctionType().getNumber());
                    RawFunction rawFunction = new RawFunction(new CAddress(l2), string, eFunctionType, this.side);
                    arrayList.add(rawFunction);
                    break;
                }
                iterable = new RawCallGraph(arrayList, arrayList2, this.side);
                return iterable;
            }
            catch (Throwable var4_6) {
                throwable = var4_6;
                throw var4_6;
            }
            finally {
                if (bufferedInputStream != null) {
                    if (throwable != null) {
                        try {
                            bufferedInputStream.close();
                        }
                        catch (Throwable var12_14) {
                            throwable.addSuppressed(var12_14);
                        }
                    } else {
                        bufferedInputStream.close();
                    }
                }
            }
        }
        catch (IOException var2_3) {
            String string;
            String string2 = String.valueOf(var2_3.getMessage());
            if (string2.length() != 0) {
                string = "Couldn't load exported binary: ".concat(string2);
                throw new IOException(string, var2_3);
            }
            string = new String("Couldn't load exported binary: ");
            throw new IOException(string, var2_3);
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

