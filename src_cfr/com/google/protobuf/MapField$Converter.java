/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Message;
import java.util.Map;

interface MapField$Converter {
    public Message convertKeyAndValueToMessage(Object var1, Object var2);

    public void convertMessageToKeyAndValue(Message var1, Map var2);

    public Message getMessageDefaultInstance();
}

