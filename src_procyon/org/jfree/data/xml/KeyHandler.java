package org.jfree.data.xml;

import org.xml.sax.helpers.*;
import org.xml.sax.*;

public class KeyHandler extends DefaultHandler implements DatasetTags
{
    private RootHandler rootHandler;
    private ItemHandler itemHandler;
    private StringBuffer currentText;
    
    public KeyHandler(final RootHandler rootHandler, final ItemHandler itemHandler) {
        this.rootHandler = rootHandler;
        this.itemHandler = itemHandler;
        this.currentText = new StringBuffer();
    }
    
    public void startElement(final String s, final String s2, final String s3, final Attributes attributes) {
        if (s3.equals("Key")) {
            this.clearCurrentText();
            return;
        }
        throw new SAXException("Expecting <Key> but found " + s3);
    }
    
    public void endElement(final String s, final String s2, final String s3) {
        if (s3.equals("Key")) {
            this.itemHandler.setKey(this.getCurrentText());
            this.rootHandler.popSubHandler();
            this.rootHandler.pushSubHandler(new ValueHandler(this.rootHandler, this.itemHandler));
            return;
        }
        throw new SAXException("Expecting </Key> but found " + s3);
    }
    
    public void characters(final char[] array, final int n, final int n2) {
        if (this.currentText != null) {
            this.currentText.append(String.copyValueOf(array, n, n2));
        }
    }
    
    protected String getCurrentText() {
        return this.currentText.toString();
    }
    
    protected void clearCurrentText() {
        this.currentText.delete(0, this.currentText.length());
    }
}
