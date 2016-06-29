/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xml;

import org.jfree.data.xml.DatasetTags;
import org.jfree.data.xml.ItemHandler;
import org.jfree.data.xml.RootHandler;
import org.jfree.data.xml.ValueHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class KeyHandler
extends DefaultHandler
implements DatasetTags {
    private RootHandler rootHandler;
    private ItemHandler itemHandler;
    private StringBuffer currentText;

    public KeyHandler(RootHandler rootHandler, ItemHandler itemHandler) {
        this.rootHandler = rootHandler;
        this.itemHandler = itemHandler;
        this.currentText = new StringBuffer();
    }

    @Override
    public void startElement(String string, String string2, String string3, Attributes attributes) {
        if (!string3.equals("Key")) throw new SAXException(new StringBuffer().append("Expecting <Key> but found ").append(string3).toString());
        this.clearCurrentText();
    }

    @Override
    public void endElement(String string, String string2, String string3) {
        if (!string3.equals("Key")) throw new SAXException(new StringBuffer().append("Expecting </Key> but found ").append(string3).toString());
        this.itemHandler.setKey((Comparable)((Object)this.getCurrentText()));
        this.rootHandler.popSubHandler();
        this.rootHandler.pushSubHandler(new ValueHandler(this.rootHandler, this.itemHandler));
    }

    @Override
    public void characters(char[] arrc, int n2, int n3) {
        if (this.currentText == null) return;
        this.currentText.append(String.copyValueOf(arrc, n2, n3));
    }

    protected String getCurrentText() {
        return this.currentText.toString();
    }

    protected void clearCurrentText() {
        this.currentText.delete(0, this.currentText.length());
    }
}

