/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.io.matches;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.io.matches.AbstractXmlHandler;
import com.google.security.zynamics.bindiff.io.matches.FunctionDiffSocketXmlData;
import com.google.security.zynamics.bindiff.io.matches.IReadXmlHandlerData;
import org.xml.sax.Attributes;

public class SingleFunctionDiffFlowgraphSocketXmlHandler
extends AbstractXmlHandler {
    private static String DATABASE = "Database";
    private static String PRIMARY = "Primary";
    private static String SECONDARY = "Secondary";
    private static String PATH = "path";
    private static String OFFSET = "offset";
    private final FunctionDiffSocketXmlData recievedData = new FunctionDiffSocketXmlData();

    @Override
    void endElement(String string) {
    }

    @Override
    void startElement(String string, Attributes attributes) {
        if (string.equals(DATABASE)) {
            this.recievedData.setMatchesDBPath(attributes.getValue(PATH));
            return;
        }
        if (string.equals(PRIMARY)) {
            this.recievedData.setFlowgraphsPath(attributes.getValue(PATH), ESide.PRIMARY);
            this.recievedData.setFlowgraphOffset(Integer.valueOf(attributes.getValue(OFFSET)), ESide.PRIMARY);
            return;
        }
        if (!string.equals(SECONDARY)) return;
        this.recievedData.setFlowgraphsPath(attributes.getValue(PATH), ESide.SECONDARY);
        this.recievedData.setFlowgraphOffset(Integer.valueOf(attributes.getValue(OFFSET)), ESide.SECONDARY);
    }

    @Override
    public FunctionDiffSocketXmlData getReadData() {
        return this.recievedData;
    }
}

