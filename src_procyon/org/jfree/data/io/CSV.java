package org.jfree.data.io;

import org.jfree.data.category.*;
import java.io.*;
import java.util.*;

public class CSV
{
    private char fieldDelimiter;
    private char textDelimiter;
    
    public CSV() {
        this(',', '\"');
    }
    
    public CSV(final char fieldDelimiter, final char textDelimiter) {
        this.fieldDelimiter = fieldDelimiter;
        this.textDelimiter = textDelimiter;
    }
    
    public CategoryDataset readCategoryDataset(final Reader reader) {
        final DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        final BufferedReader bufferedReader = new BufferedReader(reader);
        List columnKeys = null;
        int n = 0;
        for (String s = bufferedReader.readLine(); s != null; s = bufferedReader.readLine(), ++n) {
            if (n == 0) {
                columnKeys = this.extractColumnKeys(s);
            }
            else {
                this.extractRowKeyAndData(s, defaultCategoryDataset, columnKeys);
            }
        }
        return defaultCategoryDataset;
    }
    
    private List extractColumnKeys(final String s) {
        final ArrayList<String> list = new ArrayList<String>();
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == this.fieldDelimiter) {
                if (n > 0) {
                    list.add(this.removeStringDelimiters(s.substring(n2, i)));
                }
                n2 = i + 1;
                ++n;
            }
        }
        list.add(this.removeStringDelimiters(s.substring(n2, s.length())));
        return list;
    }
    
    private void extractRowKeyAndData(final String s, final DefaultCategoryDataset defaultCategoryDataset, final List list) {
        Comparable removeStringDelimiters = null;
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == this.fieldDelimiter) {
                if (n == 0) {
                    removeStringDelimiters = this.removeStringDelimiters(s.substring(n2, i));
                }
                else {
                    defaultCategoryDataset.addValue(Double.valueOf(this.removeStringDelimiters(s.substring(n2, i))), removeStringDelimiters, list.get(n - 1));
                }
                n2 = i + 1;
                ++n;
            }
        }
        defaultCategoryDataset.addValue(Double.valueOf(this.removeStringDelimiters(s.substring(n2, s.length()))), removeStringDelimiters, list.get(n - 1));
    }
    
    private String removeStringDelimiters(final String s) {
        String s2 = s.trim();
        if (s2.charAt(0) == this.textDelimiter) {
            s2 = s2.substring(1);
        }
        if (s2.charAt(s2.length() - 1) == this.textDelimiter) {
            s2 = s2.substring(0, s2.length() - 1);
        }
        return s2;
    }
}
