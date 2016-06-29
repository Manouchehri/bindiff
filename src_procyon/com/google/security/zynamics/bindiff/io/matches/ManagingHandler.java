package com.google.security.zynamics.bindiff.io.matches;

import org.xml.sax.helpers.*;
import com.google.common.base.*;
import java.util.*;
import org.xml.sax.*;

public final class ManagingHandler extends DefaultHandler
{
    private static final String ELEMENT_TYPE = "Type";
    private static final String ATTRIBUTE_VALUE = "value";
    private static final String TYPE_VALUE_FLOWGRAPH = "flowgraph";
    private final Stack router;
    private final SingleFunctionDiffFlowgraphSocketXmlHandler flowgraphHander;
    
    public ManagingHandler() {
        this.router = new Stack();
        this.flowgraphHander = new SingleFunctionDiffFlowgraphSocketXmlHandler();
    }
    
    @Override
    public void characters(final char[] array, final int n, final int n2) {
        if (this.router.isEmpty()) {
            return;
        }
        this.router.peek().setValue(CharMatcher.anyOf("\\\"\n\r\t").removeFrom(new String(Arrays.copyOfRange(array, n, n + n2))));
    }
    
    @Override
    public void endDocument() {
    }
    
    @Override
    public void endElement(final String s, final String s2, final String s3) {
    }
    
    public IReadXmlHandlerData getReadData() {
        return this.router.peek().getReadData();
    }
    
    @Override
    public void startDocument() {
    }
    
    @Override
    public void startElement(final String s, final String s2, final String s3, final Attributes attributes) {
        if (s2.equals("Type")) {
            if (attributes.getValue("value").equals("flowgraph")) {
                this.router.push(this.flowgraphHander);
            }
        }
        else if (this.router.size() > 0) {
            this.router.peek().startElement(s2, attributes);
        }
    }
}
