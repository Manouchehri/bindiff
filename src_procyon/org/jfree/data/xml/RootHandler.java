package org.jfree.data.xml;

import org.xml.sax.helpers.*;
import java.util.*;

public class RootHandler extends DefaultHandler implements DatasetTags
{
    private Stack subHandlers;
    
    public RootHandler() {
        this.subHandlers = new Stack();
    }
    
    public Stack getSubHandlers() {
        return this.subHandlers;
    }
    
    public void characters(final char[] array, final int n, final int n2) {
        final DefaultHandler currentHandler = this.getCurrentHandler();
        if (currentHandler != this) {
            currentHandler.characters(array, n, n2);
        }
    }
    
    public DefaultHandler getCurrentHandler() {
        DefaultHandler defaultHandler = this;
        if (this.subHandlers != null && this.subHandlers.size() > 0) {
            final DefaultHandler peek = this.subHandlers.peek();
            if (peek != null) {
                defaultHandler = peek;
            }
        }
        return defaultHandler;
    }
    
    public void pushSubHandler(final DefaultHandler defaultHandler) {
        this.subHandlers.push(defaultHandler);
    }
    
    public DefaultHandler popSubHandler() {
        return this.subHandlers.pop();
    }
}
