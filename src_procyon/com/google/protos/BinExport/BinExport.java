package com.google.protos.BinExport;

import com.google.protobuf.*;

public final class BinExport
{
    private static Descriptors$Descriptor internal_static_BinExport_Meta_descriptor;
    private static GeneratedMessage$FieldAccessorTable internal_static_BinExport_Meta_fieldAccessorTable;
    private static Descriptors$Descriptor internal_static_BinExport_Callgraph_descriptor;
    private static GeneratedMessage$FieldAccessorTable internal_static_BinExport_Callgraph_fieldAccessorTable;
    private static Descriptors$Descriptor internal_static_BinExport_Callgraph_Vertex_descriptor;
    private static GeneratedMessage$FieldAccessorTable internal_static_BinExport_Callgraph_Vertex_fieldAccessorTable;
    private static Descriptors$Descriptor internal_static_BinExport_Callgraph_Edge_descriptor;
    private static GeneratedMessage$FieldAccessorTable internal_static_BinExport_Callgraph_Edge_fieldAccessorTable;
    private static Descriptors$Descriptor internal_static_BinExport_Flowgraph_descriptor;
    private static GeneratedMessage$FieldAccessorTable internal_static_BinExport_Flowgraph_fieldAccessorTable;
    private static Descriptors$Descriptor internal_static_BinExport_Flowgraph_Vertex_descriptor;
    private static GeneratedMessage$FieldAccessorTable internal_static_BinExport_Flowgraph_Vertex_fieldAccessorTable;
    private static Descriptors$Descriptor internal_static_BinExport_Flowgraph_Vertex_Instruction_descriptor;
    private static GeneratedMessage$FieldAccessorTable internal_static_BinExport_Flowgraph_Vertex_Instruction_fieldAccessorTable;
    private static Descriptors$Descriptor internal_static_BinExport_Flowgraph_Vertex_Instruction_Comment_descriptor;
    private static GeneratedMessage$FieldAccessorTable internal_static_BinExport_Flowgraph_Vertex_Instruction_Comment_fieldAccessorTable;
    private static Descriptors$Descriptor internal_static_BinExport_Flowgraph_Edge_descriptor;
    private static GeneratedMessage$FieldAccessorTable internal_static_BinExport_Flowgraph_Edge_fieldAccessorTable;
    private static Descriptors$FileDescriptor descriptor;
    
    public static void registerAllExtensions(final ExtensionRegistry extensionRegistry) {
    }
    
    public static Descriptors$FileDescriptor getDescriptor() {
        return BinExport.descriptor;
    }
    
    static {
        Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\u000fbinexport.proto\u0012\tBinExport\"\u00df\u0001\n\u0004Meta\u0012\u0014\n\finput_binary\u0018\u0001 \u0001(\t\u0012\u0012\n\ninput_hash\u0018\u0002 \u0001(\f\u0012\u001b\n\u0013input_address_space\u0018\u0003 \u0001(\r\u0012\u0019\n\u0011architecture_name\u0018\u0004 \u0001(\t\u0012\u0018\n\u0010max_mnemonic_len\u0018\u0005 \u0001(\r\u0012\u0018\n\u0010num_instructions\u0018\u0006 \u0001(\r\u0012\u0015\n\rnum_functions\u0018\u0007 \u0001(\r\u0012\u0017\n\u000fnum_basicblocks\u0018\b \u0001(\r\u0012\u0011\n\tnum_edges\u0018\t \u0001(\r\"\u00d8\u0003\n\tCallgraph\u0012-\n\bvertices\u0018\u0001 \u0003(\u000b2\u001b.BinExport.Callgraph.Vertex\u0012(\n\u0005edges\u0018\u0002 \u0003(\u000b2\u0019.BinExport.Callgraph.Edge\u001a\u008c\u0002\n\u0006Vertex\u0012\u000f\n\u0007address\u0018\u0001 \u0002(\u0004\u0012\r\n\u0005prime\u0018\u0002 \u0002(\u0004", "\u0012G\n\rfunction_type\u0018\u0003 \u0001(\u000e2(.BinExport.Callgraph.Vertex.FunctionType:\u0006NORMAL\u0012\u001c\n\rhas_real_name\u0018\u0004 \u0001(\b:\u0005false\u0012\u0014\n\fmangled_name\u0018\u0005 \u0001(\t\u0012\u0016\n\u000edemangled_name\u0018\u0006 \u0001(\t\"M\n\fFunctionType\u0012\n\n\u0006NORMAL\u0010\u0000\u0012\u000b\n\u0007LIBRARY\u0010\u0001\u0012\f\n\bIMPORTED\u0010\u0002\u0012\t\n\u0005THUNK\u0010\u0003\u0012\u000b\n\u0007INVALID\u0010\u0004\u001ac\n\u0004Edge\u0012\u001f\n\u0017source_function_address\u0018\u0001 \u0002(\u0004\u0012\"\n\u001asource_instruction_address\u0018\u0002 \u0002(\u0004\u0012\u0016\n\u000etarget_address\u0018\u0003 \u0002(\u0004\"¤\u0005\n\tFlowgraph\u0012\u000f\n\u0007address\u0018\u0001 \u0002(\u0004\u0012-\n\bvertices\u0018\u0002 \u0003(\u000b2\u001b.BinExport.Flowgraph", ".Vertex\u0012(\n\u0005edges\u0018\u0003 \u0003(\u000b2\u0019.BinExport.Flowgraph.Edge\u001a\u00de\u0002\n\u0006Vertex\u0012\r\n\u0005prime\u0018\u0001 \u0002(\u0004\u0012=\n\finstructions\u0018\u0002 \u0003(\u000b2'.BinExport.Flowgraph.Vertex.Instruction\u001a\u0085\u0002\n\u000bInstruction\u0012\u000f\n\u0007address\u0018\u0001 \u0002(\u0004\u0012\r\n\u0005prime\u0018\u0002 \u0002(\r\u0012\u001b\n\u0010string_reference\u0018\u0003 \u0001(\r:\u00010\u0012\u0010\n\bmnemonic\u0018\u0004 \u0001(\t\u0012\u0010\n\boperands\u0018\u0005 \u0001(\t\u0012\u0011\n\traw_bytes\u0018\u0006 \u0001(\f\u0012\u0014\n\fcall_targets\u0018\u0007 \u0003(\u0004\u0012A\n\bcomments\u0018\b \u0003(\u000b2/.BinExport.Flowgraph.Vertex.Instruction.Comment\u001a)\n\u0007Comment\u0012\u000f\n\u0007comment\u0018\u0001 \u0002(\t\u0012\r\n\u0005flags\u0018\u0002 \u0002", "(\r\u001a\u00cb\u0001\n\u0004Edge\u0012\u0016\n\u000esource_address\u0018\u0001 \u0002(\u0004\u0012\u0016\n\u000etarget_address\u0018\u0002 \u0002(\u0004\u0012?\n\u0004type\u0018\u0003 \u0001(\u000e2\".BinExport.Flowgraph.Edge.EdgeType:\rUNCONDITIONAL\"R\n\bEdgeType\u0012\u0012\n\u000eCONDITION_TRUE\u0010\u0001\u0012\u0013\n\u000fCONDITION_FALSE\u0010\u0002\u0012\u0011\n\rUNCONDITIONAL\u0010\u0003\u0012\n\n\u0006SWITCH\u0010\u0004B(\n\u001bcom.google.protos.BinExportB\tBinExport" }, new Descriptors$FileDescriptor[0], new BinExport$1());
        BinExport.internal_static_BinExport_Meta_descriptor = getDescriptor().getMessageTypes().get(0);
        BinExport.internal_static_BinExport_Meta_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(BinExport.internal_static_BinExport_Meta_descriptor, new String[] { "InputBinary", "InputHash", "InputAddressSpace", "ArchitectureName", "MaxMnemonicLen", "NumInstructions", "NumFunctions", "NumBasicblocks", "NumEdges" });
        BinExport.internal_static_BinExport_Callgraph_descriptor = getDescriptor().getMessageTypes().get(1);
        BinExport.internal_static_BinExport_Callgraph_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(BinExport.internal_static_BinExport_Callgraph_descriptor, new String[] { "Vertices", "Edges" });
        BinExport.internal_static_BinExport_Callgraph_Vertex_descriptor = BinExport.internal_static_BinExport_Callgraph_descriptor.getNestedTypes().get(0);
        BinExport.internal_static_BinExport_Callgraph_Vertex_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(BinExport.internal_static_BinExport_Callgraph_Vertex_descriptor, new String[] { "Address", "Prime", "FunctionType", "HasRealName", "MangledName", "DemangledName" });
        BinExport.internal_static_BinExport_Callgraph_Edge_descriptor = BinExport.internal_static_BinExport_Callgraph_descriptor.getNestedTypes().get(1);
        BinExport.internal_static_BinExport_Callgraph_Edge_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(BinExport.internal_static_BinExport_Callgraph_Edge_descriptor, new String[] { "SourceFunctionAddress", "SourceInstructionAddress", "TargetAddress" });
        BinExport.internal_static_BinExport_Flowgraph_descriptor = getDescriptor().getMessageTypes().get(2);
        BinExport.internal_static_BinExport_Flowgraph_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(BinExport.internal_static_BinExport_Flowgraph_descriptor, new String[] { "Address", "Vertices", "Edges" });
        BinExport.internal_static_BinExport_Flowgraph_Vertex_descriptor = BinExport.internal_static_BinExport_Flowgraph_descriptor.getNestedTypes().get(0);
        BinExport.internal_static_BinExport_Flowgraph_Vertex_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(BinExport.internal_static_BinExport_Flowgraph_Vertex_descriptor, new String[] { "Prime", "Instructions" });
        BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_descriptor = BinExport.internal_static_BinExport_Flowgraph_Vertex_descriptor.getNestedTypes().get(0);
        BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_descriptor, new String[] { "Address", "Prime", "StringReference", "Mnemonic", "Operands", "RawBytes", "CallTargets", "Comments" });
        BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_Comment_descriptor = BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_descriptor.getNestedTypes().get(0);
        BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_Comment_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(BinExport.internal_static_BinExport_Flowgraph_Vertex_Instruction_Comment_descriptor, new String[] { "Comment", "Flags" });
        BinExport.internal_static_BinExport_Flowgraph_Edge_descriptor = BinExport.internal_static_BinExport_Flowgraph_descriptor.getNestedTypes().get(1);
        BinExport.internal_static_BinExport_Flowgraph_Edge_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(BinExport.internal_static_BinExport_Flowgraph_Edge_descriptor, new String[] { "SourceAddress", "TargetAddress", "Type" });
    }
}
