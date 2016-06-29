/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.Message$Builder;

interface GeneratedMessage$FieldAccessorTable$FieldAccessor {
    public Object get(GeneratedMessage var1);

    public Object get(GeneratedMessage$Builder var1);

    public Object getRaw(GeneratedMessage var1);

    public Object getRaw(GeneratedMessage$Builder var1);

    public void set(GeneratedMessage$Builder var1, Object var2);

    public Object getRepeated(GeneratedMessage var1, int var2);

    public Object getRepeated(GeneratedMessage$Builder var1, int var2);

    public Object getRepeatedRaw(GeneratedMessage var1, int var2);

    public Object getRepeatedRaw(GeneratedMessage$Builder var1, int var2);

    public void setRepeated(GeneratedMessage$Builder var1, int var2, Object var3);

    public void addRepeated(GeneratedMessage$Builder var1, Object var2);

    public boolean has(GeneratedMessage var1);

    public boolean has(GeneratedMessage$Builder var1);

    public int getRepeatedCount(GeneratedMessage var1);

    public int getRepeatedCount(GeneratedMessage$Builder var1);

    public void clear(GeneratedMessage$Builder var1);

    public Message$Builder newBuilder();

    public Message$Builder getBuilder(GeneratedMessage$Builder var1);

    public Message$Builder getRepeatedBuilder(GeneratedMessage$Builder var1, int var2);
}

