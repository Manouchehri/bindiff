/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Method;
import com.google.protobuf.MethodOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContextOrBuilder;
import java.util.List;

public interface ApiOrBuilder
extends MessageOrBuilder {
    public String getName();

    public ByteString getNameBytes();

    public List getMethodsList();

    public Method getMethods(int var1);

    public int getMethodsCount();

    public List getMethodsOrBuilderList();

    public MethodOrBuilder getMethodsOrBuilder(int var1);

    public List getOptionsList();

    public Option getOptions(int var1);

    public int getOptionsCount();

    public List getOptionsOrBuilderList();

    public OptionOrBuilder getOptionsOrBuilder(int var1);

    public String getVersion();

    public ByteString getVersionBytes();

    public boolean hasSourceContext();

    public SourceContext getSourceContext();

    public SourceContextOrBuilder getSourceContextOrBuilder();
}

