package com.google.security.zynamics.bindiff.io.matches;

import org.xml.sax.*;

public abstract class AbstractXmlHandler
{
    private String value;
    
    public AbstractXmlHandler() {
        this.value = "";
    }
    
    protected String getValue() {
        return this.value;
    }
    
    protected void setValue(final String value) {
        this.value = value;
    }
    
    abstract void endElement(final String p0);
    
    abstract void startElement(final String p0, final Attributes p1);
    
    public abstract IReadXmlHandlerData getReadData();
}
