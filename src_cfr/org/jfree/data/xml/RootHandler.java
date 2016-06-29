/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xml;

import java.util.Stack;
import org.jfree.data.xml.DatasetTags;
import org.xml.sax.helpers.DefaultHandler;

public class RootHandler
extends DefaultHandler
implements DatasetTags {
    private Stack subHandlers = new Stack();

    public Stack getSubHandlers() {
        return this.subHandlers;
    }

    @Override
    public void characters(char[] arrc, int n2, int n3) {
        DefaultHandler defaultHandler = this.getCurrentHandler();
        if (defaultHandler == this) return;
        defaultHandler.characters(arrc, n2, n3);
    }

    public DefaultHandler getCurrentHandler() {
        DefaultHandler defaultHandler = this;
        if (this.subHandlers == null) return defaultHandler;
        if (this.subHandlers.size() <= 0) return defaultHandler;
        Object e2 = this.subHandlers.peek();
        if (e2 == null) return defaultHandler;
        return (DefaultHandler)e2;
    }

    public void pushSubHandler(DefaultHandler defaultHandler) {
        this.subHandlers.push(defaultHandler);
    }

    public DefaultHandler popSubHandler() {
        return (DefaultHandler)this.subHandlers.pop();
    }
}

