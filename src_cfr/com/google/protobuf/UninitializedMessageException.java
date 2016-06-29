/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class UninitializedMessageException
extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    private final List missingFields;

    public UninitializedMessageException(MessageLite messageLite) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }

    public UninitializedMessageException(List list) {
        super(UninitializedMessageException.buildDescription(list));
        this.missingFields = list;
    }

    public List getMissingFields() {
        return Collections.unmodifiableList(this.missingFields);
    }

    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(this.getMessage());
    }

    private static String buildDescription(List list) {
        StringBuilder stringBuilder = new StringBuilder("Message missing required fields: ");
        boolean bl2 = true;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            if (bl2) {
                bl2 = false;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}

