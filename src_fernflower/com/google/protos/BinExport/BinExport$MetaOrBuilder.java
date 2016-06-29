package com.google.protos.BinExport;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface BinExport$MetaOrBuilder extends MessageOrBuilder {
   boolean hasInputBinary();

   String getInputBinary();

   ByteString getInputBinaryBytes();

   boolean hasInputHash();

   ByteString getInputHash();

   boolean hasInputAddressSpace();

   int getInputAddressSpace();

   boolean hasArchitectureName();

   String getArchitectureName();

   ByteString getArchitectureNameBytes();

   boolean hasMaxMnemonicLen();

   int getMaxMnemonicLen();

   boolean hasNumInstructions();

   int getNumInstructions();

   boolean hasNumFunctions();

   int getNumFunctions();

   boolean hasNumBasicblocks();

   int getNumBasicblocks();

   boolean hasNumEdges();

   int getNumEdges();
}
