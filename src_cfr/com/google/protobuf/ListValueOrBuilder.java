/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Value;
import com.google.protobuf.ValueOrBuilder;
import java.util.List;

public interface ListValueOrBuilder
extends MessageOrBuilder {
    public List getValuesList();

    public Value getValues(int var1);

    public int getValuesCount();

    public List getValuesOrBuilderList();

    public ValueOrBuilder getValuesOrBuilder(int var1);
}

