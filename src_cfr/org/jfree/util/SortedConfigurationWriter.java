/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.jfree.util.Configuration;
import org.jfree.util.LineBreakIterator;
import org.jfree.util.StringUtils;

public class SortedConfigurationWriter {
    private static final int ESCAPE_KEY = 0;
    private static final int ESCAPE_VALUE = 1;
    private static final int ESCAPE_COMMENT = 2;
    private static final String END_OF_LINE = StringUtils.getLineSeparator();
    private static final char[] HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    protected String getDescription(String string) {
        return null;
    }

    public void save(String string, Configuration configuration) {
        this.save(new File(string), configuration);
    }

    public void save(File file, Configuration configuration) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        this.save(bufferedOutputStream, configuration);
        bufferedOutputStream.close();
    }

    public void save(OutputStream outputStream, Configuration configuration) {
        Object object;
        ArrayList<String> arrayList = new ArrayList<String>();
        Iterator iterator = configuration.findPropertyKeys("");
        while (iterator.hasNext()) {
            object = (String)iterator.next();
            arrayList.add((String)object);
        }
        Collections.sort(arrayList);
        object = new OutputStreamWriter(outputStream, "iso-8859-1");
        int n2 = 0;
        do {
            if (n2 >= arrayList.size()) {
                object.flush();
                return;
            }
            String string = (String)arrayList.get(n2);
            String string2 = configuration.getConfigProperty(string);
            String string3 = this.getDescription(string);
            if (string3 != null) {
                this.writeDescription(string3, (Writer)object);
            }
            this.saveConvert(string, 0, (Writer)object);
            object.write("=");
            this.saveConvert(string2, 1, (Writer)object);
            object.write(END_OF_LINE);
            ++n2;
        } while (true);
    }

    private void writeDescription(String string, Writer writer) {
        if (string.length() == 0) {
            return;
        }
        writer.write("# ");
        writer.write(END_OF_LINE);
        LineBreakIterator lineBreakIterator = new LineBreakIterator(string);
        while (lineBreakIterator.hasNext()) {
            writer.write("# ");
            this.saveConvert((String)lineBreakIterator.next(), 2, writer);
            writer.write(END_OF_LINE);
        }
    }

    /*
     * Unable to fully structure code
     */
    private void saveConvert(String var1_1, int var2_2, Writer var3_3) {
        var4_4 = var1_1.toCharArray();
        var5_5 = 0;
        while (var5_5 < var4_4.length) {
            var6_6 = var4_4[var5_5];
            switch (var6_6) {
                case ' ': {
                    if (var2_2 != 2 && (var5_5 == 0 || var2_2 == 0)) {
                        var3_3.write(92);
                    }
                    var3_3.write(32);
                    ** break;
                }
                case '\\': {
                    var3_3.write(92);
                    var3_3.write(92);
                    ** break;
                }
                case '\t': {
                    if (var2_2 == 2) {
                        var3_3.write(var6_6);
                        ** break;
                    }
                    var3_3.write(92);
                    var3_3.write(116);
                    ** break;
                }
                case '\n': {
                    var3_3.write(92);
                    var3_3.write(110);
                    ** break;
                }
                case '\r': {
                    var3_3.write(92);
                    var3_3.write(114);
                    ** break;
                }
                case '\f': {
                    if (var2_2 == 2) {
                        var3_3.write(var6_6);
                        ** break;
                    }
                    var3_3.write(92);
                    var3_3.write(102);
                    ** break;
                }
                case '!': 
                case '\"': 
                case '#': 
                case ':': 
                case '=': {
                    if (var2_2 == 2) {
                        var3_3.write(var6_6);
                        ** break;
                    }
                    var3_3.write(92);
                    var3_3.write(var6_6);
                    ** break;
                }
            }
            if (var6_6 < ' ' || var6_6 > '~') {
                var3_3.write(92);
                var3_3.write(117);
                var3_3.write(SortedConfigurationWriter.HEX_CHARS[var6_6 >> 12 & 15]);
                var3_3.write(SortedConfigurationWriter.HEX_CHARS[var6_6 >> 8 & 15]);
                var3_3.write(SortedConfigurationWriter.HEX_CHARS[var6_6 >> 4 & 15]);
                var3_3.write(SortedConfigurationWriter.HEX_CHARS[var6_6 & 15]);
                ** break;
            }
            var3_3.write(var6_6);
lbl53: // 12 sources:
            ++var5_5;
        }
    }
}

