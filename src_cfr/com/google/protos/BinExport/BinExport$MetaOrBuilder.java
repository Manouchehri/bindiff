/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface BinExport$MetaOrBuilder
extends MessageOrBuilder {
    public boolean hasInputBinary();

    public String getInputBinary();

    public ByteString getInputBinaryBytes();

    public boolean hasInputHash();

    public ByteString getInputHash();

    public boolean hasInputAddressSpace();

    public int getInputAddressSpace();

    public boolean hasArchitectureName();

    public String getArchitectureName();

    public ByteString getArchitectureNameBytes();

    public boolean hasMaxMnemonicLen();

    public int getMaxMnemonicLen();

    public boolean hasNumInstructions();

    public int getNumInstructions();

    public boolean hasNumFunctions();

    public int getNumFunctions();

    public boolean hasNumBasicblocks();

    public int getNumBasicblocks();

    public boolean hasNumEdges();

    public int getNumEdges();
}

