/*
 * Decompiled with CFR 0_115.
 */
package com.google.protos.BinExport;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protos.BinExport.BinExport$1;
import java.util.List;

public final class BinExport {
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

    private BinExport() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
    }

    public static Descriptors$FileDescriptor getDescriptor() {
        return descriptor;
    }

    static /* synthetic */ Descriptors$Descriptor access$000() {
        return internal_static_BinExport_Meta_descriptor;
    }

    static /* synthetic */ GeneratedMessage$FieldAccessorTable access$100() {
        return internal_static_BinExport_Meta_fieldAccessorTable;
    }

    static /* synthetic */ Descriptors$Descriptor access$1800() {
        return internal_static_BinExport_Callgraph_descriptor;
    }

    static /* synthetic */ GeneratedMessage$FieldAccessorTable access$1900() {
        return internal_static_BinExport_Callgraph_fieldAccessorTable;
    }

    static /* synthetic */ Descriptors$Descriptor access$2000() {
        return internal_static_BinExport_Callgraph_Vertex_descriptor;
    }

    static /* synthetic */ GeneratedMessage$FieldAccessorTable access$2100() {
        return internal_static_BinExport_Callgraph_Vertex_fieldAccessorTable;
    }

    static /* synthetic */ Descriptors$Descriptor access$3500() {
        return internal_static_BinExport_Callgraph_Edge_descriptor;
    }

    static /* synthetic */ GeneratedMessage$FieldAccessorTable access$3600() {
        return internal_static_BinExport_Callgraph_Edge_fieldAccessorTable;
    }

    static /* synthetic */ Descriptors$Descriptor access$5700() {
        return internal_static_BinExport_Flowgraph_descriptor;
    }

    static /* synthetic */ GeneratedMessage$FieldAccessorTable access$5800() {
        return internal_static_BinExport_Flowgraph_fieldAccessorTable;
    }

    static /* synthetic */ Descriptors$Descriptor access$5900() {
        return internal_static_BinExport_Flowgraph_Vertex_descriptor;
    }

    static /* synthetic */ GeneratedMessage$FieldAccessorTable access$6000() {
        return internal_static_BinExport_Flowgraph_Vertex_fieldAccessorTable;
    }

    static /* synthetic */ Descriptors$Descriptor access$6100() {
        return internal_static_BinExport_Flowgraph_Vertex_Instruction_descriptor;
    }

    static /* synthetic */ GeneratedMessage$FieldAccessorTable access$6200() {
        return internal_static_BinExport_Flowgraph_Vertex_Instruction_fieldAccessorTable;
    }

    static /* synthetic */ Descriptors$Descriptor access$6300() {
        return internal_static_BinExport_Flowgraph_Vertex_Instruction_Comment_descriptor;
    }

    static /* synthetic */ GeneratedMessage$FieldAccessorTable access$6400() {
        return internal_static_BinExport_Flowgraph_Vertex_Instruction_Comment_fieldAccessorTable;
    }

    static /* synthetic */ Descriptors$Descriptor access$10000() {
        return internal_static_BinExport_Flowgraph_Edge_descriptor;
    }

    static /* synthetic */ GeneratedMessage$FieldAccessorTable access$10100() {
        return internal_static_BinExport_Flowgraph_Edge_fieldAccessorTable;
    }

    static /* synthetic */ Descriptors$FileDescriptor access$12402(Descriptors$FileDescriptor descriptors$FileDescriptor) {
        descriptor = descriptors$FileDescriptor;
        return descriptor;
    }

    static {
        String[] arrstring = new String[]{"\n\u000fbinexport.proto\u0012\tBinExport\"\u00df\u0001\n\u0004Meta\u0012\u0014\n\finput_binary\u0018\u0001 \u0001(\t\u0012\u0012\n\ninput_hash\u0018\u0002 \u0001(\f\u0012\u001b\n\u0013input_address_space\u0018\u0003 \u0001(\r\u0012\u0019\n\u0011architecture_name\u0018\u0004 \u0001(\t\u0012\u0018\n\u0010max_mnemonic_len\u0018\u0005 \u0001(\r\u0012\u0018\n\u0010num_instructions\u0018\u0006 \u0001(\r\u0012\u0015\n\rnum_functions\u0018\u0007 \u0001(\r\u0012\u0017\n\u000fnum_basicblocks\u0018\b \u0001(\r\u0012\u0011\n\tnum_edges\u0018\t \u0001(\r\"\u00d8\u0003\n\tCallgraph\u0012-\n\bvertices\u0018\u0001 \u0003(\u000b2\u001b.BinExport.Callgraph.Vertex\u0012(\n\u0005edges\u0018\u0002 \u0003(\u000b2\u0019.BinExport.Callgraph.Edge\u001a\u008c\u0002\n\u0006Vertex\u0012\u000f\n\u0007address\u0018\u0001 \u0002(\u0004\u0012\r\n\u0005prime\u0018\u0002 \u0002(\u0004", "\u0012G\n\rfunction_type\u0018\u0003 \u0001(\u000e2(.BinExport.Callgraph.Vertex.FunctionType:\u0006NORMAL\u0012\u001c\n\rhas_real_name\u0018\u0004 \u0001(\b:\u0005false\u0012\u0014\n\fmangled_name\u0018\u0005 \u0001(\t\u0012\u0016\n\u000edemangled_name\u0018\u0006 \u0001(\t\"M\n\fFunctionType\u0012\n\n\u0006NORMAL\u0010\u0000\u0012\u000b\n\u0007LIBRARY\u0010\u0001\u0012\f\n\bIMPORTED\u0010\u0002\u0012\t\n\u0005THUNK\u0010\u0003\u0012\u000b\n\u0007INVALID\u0010\u0004\u001ac\n\u0004Edge\u0012\u001f\n\u0017source_function_address\u0018\u0001 \u0002(\u0004\u0012\"\n\u001asource_instruction_address\u0018\u0002 \u0002(\u0004\u0012\u0016\n\u000etarget_address\u0018\u0003 \u0002(\u0004\"\u00a4\u0005\n\tFlowgraph\u0012\u000f\n\u0007address\u0018\u0001 \u0002(\u0004\u0012-\n\bvertices\u0018\u0002 \u0003(\u000b2\u001b.BinExport.Flowgraph", ".Vertex\u0012(\n\u0005edges\u0018\u0003 \u0003(\u000b2\u0019.BinExport.Flowgraph.Edge\u001a\u00de\u0002\n\u0006Vertex\u0012\r\n\u0005prime\u0018\u0001 \u0002(\u0004\u0012=\n\finstructions\u0018\u0002 \u0003(\u000b2'.BinExport.Flowgraph.Vertex.Instruction\u001a\u0085\u0002\n\u000bInstruction\u0012\u000f\n\u0007address\u0018\u0001 \u0002(\u0004\u0012\r\n\u0005prime\u0018\u0002 \u0002(\r\u0012\u001b\n\u0010string_reference\u0018\u0003 \u0001(\r:\u00010\u0012\u0010\n\bmnemonic\u0018\u0004 \u0001(\t\u0012\u0010\n\boperands\u0018\u0005 \u0001(\t\u0012\u0011\n\traw_bytes\u0018\u0006 \u0001(\f\u0012\u0014\n\fcall_targets\u0018\u0007 \u0003(\u0004\u0012A\n\bcomments\u0018\b \u0003(\u000b2/.BinExport.Flowgraph.Vertex.Instruction.Comment\u001a)\n\u0007Comment\u0012\u000f\n\u0007comment\u0018\u0001 \u0002(\t\u0012\r\n\u0005flags\u0018\u0002 \u0002", "(\r\u001a\u00cb\u0001\n\u0004Edge\u0012\u0016\n\u000esource_address\u0018\u0001 \u0002(\u0004\u0012\u0016\n\u000etarget_address\u0018\u0002 \u0002(\u0004\u0012?\n\u0004type\u0018\u0003 \u0001(\u000e2\".BinExport.Flowgraph.Edge.EdgeType:\rUNCONDITIONAL\"R\n\bEdgeType\u0012\u0012\n\u000eCONDITION_TRUE\u0010\u0001\u0012\u0013\n\u000fCONDITION_FALSE\u0010\u0002\u0012\u0011\n\rUNCONDITIONAL\u0010\u0003\u0012\n\n\u0006SWITCH\u0010\u0004B(\n\u001bcom.google.protos.BinExportB\tBinExport"};
        BinExport$1 binExport$1 = new BinExport$1();
        Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(arrstring, new Descriptors$FileDescriptor[0], binExport$1);
        internal_static_BinExport_Meta_descriptor = (Descriptors$Descriptor)BinExport.getDescriptor().getMessageTypes().get(0);
        internal_static_BinExport_Meta_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_BinExport_Meta_descriptor, new String[]{"InputBinary", "InputHash", "InputAddressSpace", "ArchitectureName", "MaxMnemonicLen", "NumInstructions", "NumFunctions", "NumBasicblocks", "NumEdges"});
        internal_static_BinExport_Callgraph_descriptor = (Descriptors$Descriptor)BinExport.getDescriptor().getMessageTypes().get(1);
        internal_static_BinExport_Callgraph_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_BinExport_Callgraph_descriptor, new String[]{"Vertices", "Edges"});
        internal_static_BinExport_Callgraph_Vertex_descriptor = (Descriptors$Descriptor)internal_static_BinExport_Callgraph_descriptor.getNestedTypes().get(0);
        internal_static_BinExport_Callgraph_Vertex_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_BinExport_Callgraph_Vertex_descriptor, new String[]{"Address", "Prime", "FunctionType", "HasRealName", "MangledName", "DemangledName"});
        internal_static_BinExport_Callgraph_Edge_descriptor = (Descriptors$Descriptor)internal_static_BinExport_Callgraph_descriptor.getNestedTypes().get(1);
        internal_static_BinExport_Callgraph_Edge_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_BinExport_Callgraph_Edge_descriptor, new String[]{"SourceFunctionAddress", "SourceInstructionAddress", "TargetAddress"});
        internal_static_BinExport_Flowgraph_descriptor = (Descriptors$Descriptor)BinExport.getDescriptor().getMessageTypes().get(2);
        internal_static_BinExport_Flowgraph_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_BinExport_Flowgraph_descriptor, new String[]{"Address", "Vertices", "Edges"});
        internal_static_BinExport_Flowgraph_Vertex_descriptor = (Descriptors$Descriptor)internal_static_BinExport_Flowgraph_descriptor.getNestedTypes().get(0);
        internal_static_BinExport_Flowgraph_Vertex_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_BinExport_Flowgraph_Vertex_descriptor, new String[]{"Prime", "Instructions"});
        internal_static_BinExport_Flowgraph_Vertex_Instruction_descriptor = (Descriptors$Descriptor)internal_static_BinExport_Flowgraph_Vertex_descriptor.getNestedTypes().get(0);
        internal_static_BinExport_Flowgraph_Vertex_Instruction_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_BinExport_Flowgraph_Vertex_Instruction_descriptor, new String[]{"Address", "Prime", "StringReference", "Mnemonic", "Operands", "RawBytes", "CallTargets", "Comments"});
        internal_static_BinExport_Flowgraph_Vertex_Instruction_Comment_descriptor = (Descriptors$Descriptor)internal_static_BinExport_Flowgraph_Vertex_Instruction_descriptor.getNestedTypes().get(0);
        internal_static_BinExport_Flowgraph_Vertex_Instruction_Comment_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_BinExport_Flowgraph_Vertex_Instruction_Comment_descriptor, new String[]{"Comment", "Flags"});
        internal_static_BinExport_Flowgraph_Edge_descriptor = (Descriptors$Descriptor)internal_static_BinExport_Flowgraph_descriptor.getNestedTypes().get(1);
        internal_static_BinExport_Flowgraph_Edge_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_BinExport_Flowgraph_Edge_descriptor, new String[]{"SourceAddress", "TargetAddress", "Type"});
    }
}

