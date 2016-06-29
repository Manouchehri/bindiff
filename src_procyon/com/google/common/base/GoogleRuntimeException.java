package com.google.common.base;

import com.google.common.annotations.*;
import javax.annotation.*;

@Deprecated
@CheckReturnValue
@GoogleInternal
public class GoogleRuntimeException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
    private String internalMessage;
    private String externalMessage;
    
    public GoogleRuntimeException() {
        this.externalMessage = "A system error has occurred";
    }
    
    public GoogleRuntimeException(@Nullable final String internalMessage) {
        super(internalMessage);
        this.externalMessage = "A system error has occurred";
        this.setInternalMessage(internalMessage);
    }
    
    public GoogleRuntimeException(@Nullable final String externalMessage, @Nullable final Throwable t) {
        super(externalMessage, t);
        this.externalMessage = "A system error has occurred";
        this.setInternalMessage(Throwables.getStackTraceAsString(t));
        this.setExternalMessage(externalMessage);
    }
    
    public GoogleRuntimeException(@Nullable final GoogleException ex) {
        super(ex);
        this.externalMessage = "A system error has occurred";
        this.setInternalMessage(ex.getInternalMessage());
        this.setExternalMessage(ex.getExternalMessage());
    }
    
    @Nullable
    public final String getInternalMessage() {
        return this.internalMessage;
    }
    
    public final void setInternalMessage(@Nullable final String internalMessage) {
        this.internalMessage = internalMessage;
    }
    
    @Nullable
    public final String getExternalMessage() {
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
