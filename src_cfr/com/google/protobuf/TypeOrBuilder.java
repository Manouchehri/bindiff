/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.Field;
import com.google.protobuf.FieldOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContextOrBuilder;
import java.util.List;

public interface TypeOrBuilder
extends MessageOrBuilder {
    public String getName();

    public ByteString getNameBytes();

    public List getFieldsList();

    public Field getFields(int var1);

    public int getFieldsCount();

    public List getFieldsOrBuilderList();

    public FieldOrBuilder getFieldsOrBuilder(int var1);

    public ProtocolStringList getOneofsList();

    public int getOneofsCount();

    public String getOneofs(int var1);

    public ByteString getOneofsBytes(int var1);

    public List getOptionsList();

    public Option getOptions(int var1);

    public int getOptionsCount();

    public List getOptionsOrBuilderList();

    public OptionOrBuilder getOptionsOrBuilder(int var1);

    public boolean hasSourceContext();

    public SourceContext getSourceContext();

    public SourceContextOrBuilder getSourceContextOrBuilder();
}

