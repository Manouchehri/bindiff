/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;

public class GeneratedMessageLite$DefaultInstanceBasedParser
extends AbstractParser {
    private GeneratedMessageLite defaultInstance;

    public GeneratedMessageLite$DefaultInstanceBasedParser(GeneratedMessageLite generatedMessageLite) {
        this.defaultInstance = generatedMessageLite;
    }

    @Override
    public GeneratedMessageLite parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return GeneratedMessageLite.parsePartialFrom(this.defaultInstance, codedInputStream, extensionRegistryLite);
    }
}

