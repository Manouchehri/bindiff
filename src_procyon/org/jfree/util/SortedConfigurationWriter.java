package org.jfree.util;

import java.io.*;
import java.util.*;

public class SortedConfigurationWriter
{
    private static final int ESCAPE_KEY = 0;
    private static final int ESCAPE_VALUE = 1;
    private static final int ESCAPE_COMMENT = 2;
    private static final String END_OF_LINE;
    private static final char[] HEX_CHARS;
    
    protected String getDescription(final String s) {
        return null;
    }
    
    public void save(final String s, final Configuration configuration) {
        this.save(new File(s), configuration);
    }
    
    public void save(final File file, final Configuration configuration) {
        final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        this.save(bufferedOutputStream, configuration);
        bufferedOutputStream.close();
    }
    
    public void save(final OutputStream outputStream, final Configuration configuration) {
        final ArrayList<Comparable> list = new ArrayList<Comparable>();
        final Iterator propertyKeys = configuration.findPropertyKeys("");
        while (propertyKeys.hasNext()) {
            list.add(propertyKeys.next());
        }
        Collections.sort(list);
        final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "iso-8859-1");
        for (int i = 0; i < list.size(); ++i) {
            final String s = list.get(i);
            final String configProperty = configuration.getConfigProperty(s);
            final String description = this.getDescription(s);
            if (description != null) {
                this.writeDescription(description, outputStreamWriter);
            }
            this.saveConvert(s, 0, outputStreamWriter);
            outputStreamWriter.write("=");
            this.saveConvert(configProperty, 1, outputStreamWriter);
            outputStreamWriter.write(SortedConfigurationWriter.END_OF_LINE);
        }
        outputStreamWriter.flush();
    }
    
    private void writeDescription(final String s, final Writer writer) {
        if (s.length() == 0) {
            return;
        }
        writer.write("# ");
        writer.write(SortedConfigurationWriter.END_OF_LINE);
        final LineBreakIterator lineBreakIterator = new LineBreakIterator(s);
        while (lineBreakIterator.hasNext()) {
            writer.write("# ");
            this.saveConvert((String)lineBreakIterator.next(), 2, writer);
            writer.write(SortedConfigurationWriter.END_OF_LINE);
        }
    }
    
    private void saveConvert(final String s, final int n, final Writer writer) {
        final char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            final char c = charArray[i];
            switch (c) {
                case 32: {
                    if (n != 2 && (i == 0 || n == 0)) {
                        writer.write(92);
                    }
                    writer.write(32);
                    break;
                }
                case 92: {
                    writer.write(92);
                    writer.write(92);
                    break;
                }
                case 9: {
                    if (n == 2) {
                        writer.write(c);
                        break;
                    }
                    writer.write(92);
                    writer.write(116);
                    break;
                }
                case 10: {
                    writer.write(92);
                    writer.write(110);
                    break;
                }
                case 13: {
                    writer.write(92);
                    writer.write(114);
                    break;
                }
                case 12: {
                    if (n == 2) {
                        writer.write(c);
                        break;
                    }
                    writer.write(92);
                    writer.write(102);
                    break;
                }
                case 33:
                case 34:
                case 35:
                case 58:
                case 61: {
                    if (n == 2) {
                        writer.write(c);
                        break;
                    }
                    writer.write(92);
                    writer.write(c);
                    break;
                }
                default: {
                    if (c < ' ' || c > '~') {
                        writer.write(92);
                        writer.write(117);
                        writer.write(SortedConfigurationWriter.HEX_CHARS[c >> 12 & '\u000f']);
                        writer.write(SortedConfigurationWriter.HEX_CHARS[c >> 8 & '\u000f']);
                        writer.write(SortedConfigurationWriter.HEX_CHARS[c >> 4 & '\u000f']);
                        writer.write(SortedConfigurationWriter.HEX_CHARS[c & '\u000f']);
                        break;
                    }
                    writer.write(c);
                    break;
                }
            }
        }
    }
    
    static {
        END_OF_LINE = StringUtils.getLineSeparator();
        HEX_CHARS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    }
}
