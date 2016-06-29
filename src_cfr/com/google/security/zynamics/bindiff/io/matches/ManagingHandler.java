/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.io.matches;

import com.google.common.base.CharMatcher;
import com.google.security.zynamics.bindiff.io.matches.AbstractXmlHandler;
import com.google.security.zynamics.bindiff.io.matches.IReadXmlHandlerData;
import com.google.security.zynamics.bindiff.io.matches.SingleFunctionDiffFlowgraphSocketXmlHandler;
import java.util.Arrays;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public final class ManagingHandler
extends DefaultHandler {
    private static final String ELEMENT_TYPE = "Type";
    private static final String ATTRIBUTE_VALUE = "value";
    private static final String TYPE_VALUE_FLOWGRAPH = "flowgraph";
    private final Stack router = new Stack();
    private final SingleFunctionDiffFlowgraphSocketXmlHandler flowgraphHander = new SingleFunctionDiffFlowgraphSocketXmlHandler();

    @Override
    public void characters(char[] arrc, int n2, int n3) {
        if (this.router.isEmpty()) {
            return;
        }
        String string = new String(Arrays.copyOfRange(arrc, n2, n2 + n3));
        string = CharMatcher.anyOf("\\\"\n\r\t").removeFrom(string);
        AbstractXmlHandler abstractXmlHandler = (AbstractXmlHandler)this.router.peek();
        abstractXmlHandler.setValue(string);
    }

    @Override
    public void endDocument() {
    }

    @Override
    public void endElement(String string, String string2, String string3) {
    }

    public IReadXmlHandlerData getReadData() {
        return ((AbstractXmlHandler)this.router.peek()).getReadData();
    }

    @Override
    public void startDocument() {
    }

    @Override
    public void startElement(String string, String string2, String string3, Attributes attributes) {
        if (string2.equals("Type")) {
            if (!attributes.getValue("value").equals("flowgraph")) return;
            this.router.push(this.flowgraphHander);
            return;
        }
        if (this.router.size() <= 0) return;
        ((AbstractXmlHandler)this.router.peek()).startElement(string2, attributes);
    }
}

