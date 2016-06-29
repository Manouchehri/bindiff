/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.Field$Cardinality;
import com.google.protobuf.Field$Kind;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import java.util.List;

public interface FieldOrBuilder
extends MessageOrBuilder {
    public int getKindValue();

    public Field$Kind getKind();

    public int getCardinalityValue();

    public Field$Cardinality getCardinality();

    public int getNumber();

    public String getName();

    public ByteString getNameBytes();

    public String getTypeUrl();

    public ByteString getTypeUrlBytes();

    public int getOneofIndex();

    public boolean getPacked();

    public List getOptionsList();

    public Option getOptions(int var1);

    public int getOptionsCount();

    public List getOptionsOrBuilderList();

    public OptionOrBuilder getOptionsOrBuilder(int var1);
}

