package com.google.common.base;

import com.google.common.annotations.*;
import javax.annotation.*;

@Deprecated
@CheckReturnValue
@GoogleInternal
public class GoogleException extends Exception
{
    private static final long serialVersionUID = 1L;
    private String internalMessage;
    private String externalMessage;
    
    public GoogleException() {
        this.externalMessage = "A system error has occurred";
    }
    
    public GoogleException(@Nullable final Throwable t) {
        super(t);
        this.externalMessage = "A system error has occurred";
        this.setInternalMessage(Throwables.getStackTraceAsString(t));
    }
    
    public GoogleException(@Nullable final Throwable t, @Nullable final String externalMessage) {
        super(externalMessage, t);
        this.externalMessage = "A system error has occurred";
        this.setInternalMessage(Throwables.getStackTraceAsString(t));
        this.setExternalMessage(externalMessage);
    }
    
    public GoogleException(@Nullable final String internalMessage) {
        super(internalMessage);
        this.externalMessage = "A system error has occurred";
        this.setInternalMessage(internalMessage);
    }
    
    public GoogleException(@Nullable final String internalMessage, @Nullable final String externalMessage) {
        super(internalMessage);
        this.externalMessage = "A system error has occurred";
        this.setInternalMessage(internalMessage);
        this.setExternalMessage(externalMessage);
    }
    
    @Nullable
    public String getInternalMessage() {
        return this.internalMessage;
    }
    
    public final void setInternalMessage(@Nullable final String internalMessage) {
        this.internalMessage = internalMessage;
    }
    
    @Nullable
    public String getExternalMessage() {
        return this.externalMessage;
    }
    
    public final void setExternalMessage(@Nullable final String externalMessage) {
        this.externalMessage = externalMessage;
    }
    
    @Nullable
    @Override
    public String getMessage() {
        return this.getInternalMessage();
    }
}
