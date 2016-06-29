/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import java.util.List;

public interface MethodOrBuilder
extends MessageOrBuilder {
    public String getName();

    public ByteString getNameBytes();

    public String getRequestTypeUrl();

    public ByteString getRequestTypeUrlBytes();

    public boolean getRequestStreaming();

    public String getResponseTypeUrl();

    public ByteString getResponseTypeUrlBytes();

    public boolean getResponseStreaming();

    public List getOptionsList();

    public Option getOptions(int var1);

    public int getOptionsCount();

    public List getOptionsOrBuilderList();

    public OptionOrBuilder getOptionsOrBuilder(int var1);
}

