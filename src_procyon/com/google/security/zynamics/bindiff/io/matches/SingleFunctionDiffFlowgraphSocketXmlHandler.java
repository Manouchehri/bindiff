package com.google.security.zynamics.bindiff.io.matches;

import org.xml.sax.*;
import com.google.security.zynamics.bindiff.enums.*;

public class SingleFunctionDiffFlowgraphSocketXmlHandler extends AbstractXmlHandler
{
    private static String DATABASE;
    private static String PRIMARY;
    private static String SECONDARY;
    private static String PATH;
    private static String OFFSET;
    private final FunctionDiffSocketXmlData recievedData;
    
    public SingleFunctionDiffFlowgraphSocketXmlHandler() {
        this.recievedData = new FunctionDiffSocketXmlData();
    }
    
    @Override
    void endElement(final String s) {
    }
    
    @Override
    void startElement(final String s, final Attributes attributes) {
        if (s.equals(SingleFunctionDiffFlowgraphSocketXmlHandler.DATABASE)) {
            this.recievedData.setMatchesDBPath(attributes.getValue(SingleFunctionDiffFlowgraphSocketXmlHandler.PATH));
        }
        else if (s.equals(SingleFunctionDiffFlowgraphSocketXmlHandler.PRIMARY)) {
            this.recievedData.setFlowgraphsPath(attributes.getValue(SingleFunctionDiffFlowgraphSocketXmlHandler.PATH), ESide.PRIMARY);
            this.recievedData.setFlowgraphOffset(Integer.valueOf(attributes.getValue(SingleFunctionDiffFlowgraphSocketXmlHandler.OFFSET)), ESide.PRIMARY);
        }
        else if (s.equals(SingleFunctionDiffFlowgraphSocketXmlHandler.SECONDARY)) {
            this.recievedData.setFlowgraphsPath(attributes.getValue(SingleFunctionDiffFlowgraphSocketXmlHandler.PATH), ESide.SECONDARY);
            this.recievedData.setFlowgraphOffset(Integer.valueOf(attributes.getValue(SingleFunctionDiffFlowgraphSocketXmlHandler.OFFSET)), ESide.SECONDARY);
        }
    }
    
    @Override
    public FunctionDiffSocketXmlData getReadData() {
        return this.recievedData;
    }
    
    static {
        SingleFunctionDiffFlowgraphSocketXmlHandler.DATABASE = "Database";
        SingleFunctionDiffFlowgraphSocketXmlHandler.PRIMARY = "Primary";
        SingleFunctionDiffFlowgraphSocketXmlHandler.SECONDARY = "Secondary";
        SingleFunctionDiffFlowgraphSocketXmlHandler.PATH = "path";
        SingleFunctionDiffFlowgraphSocketXmlHandler.OFFSET = "offset";
    }
}
