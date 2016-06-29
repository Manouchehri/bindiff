/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.EnumValue;
import com.google.protobuf.EnumValueOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContextOrBuilder;
import java.util.List;

public interface EnumOrBuilder
extends MessageOrBuilder {
    public String getName();

    public ByteString getNameBytes();

    public List getEnumvalueList();

    public EnumValue getEnumvalue(int var1);

    public int getEnumvalueCount();

    public List getEnumvalueOrBuilderList();

    public EnumValueOrBuilder getEnumvalueOrBuilder(int var1);

    public List getOptionsList();

    public Option getOptions(int var1);

    public int getOptionsCount();

    public List getOptionsOrBuilderList();

    public OptionOrBuilder getOptionsOrBuilder(int var1);

    public boolean hasSourceContext();

    public SourceContext getSourceContext();

    public SourceContextOrBuilder getSourceContextOrBuilder();
}

