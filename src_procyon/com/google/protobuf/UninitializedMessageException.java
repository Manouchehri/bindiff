package com.google.protobuf;

import java.util.*;

public class UninitializedMessageException extends RuntimeException
{
    private static final long serialVersionUID = -7466929953374883507L;
    private final List missingFields;
    
    public UninitializedMessageException(final MessageLite messageLite) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }
    
    public UninitializedMessageException(final List missingFields) {
        super(buildDescription(missingFields));
        this.missingFields = missingFields;
    }
    
    public List getMissingFields() {
        return Collections.unmodifiableList((List<?>)this.missingFields);
    }
    
    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(this.getMessage());
    }
    
    private static String buildDescription(final List list) {
        final StringBuilder sb = new StringBuilder("Message missing required fields: ");
        int n = 1;
        for (final String s : list) {
            if (n != 0) {
                n = 0;
            }
            else {
                sb.append(", ");
            }
            sb.append(s);
        }
        return sb.toString();
    }
}
