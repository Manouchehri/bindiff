/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.io;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class CSV {
    private char fieldDelimiter;
    private char textDelimiter;

    public CSV() {
        this(',', '\"');
    }

    public CSV(char c2, char c3) {
        this.fieldDelimiter = c2;
        this.textDelimiter = c3;
    }

    public CategoryDataset readCategoryDataset(Reader reader) {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        BufferedReader bufferedReader = new BufferedReader(reader);
        List list = null;
        int n2 = 0;
        String string = bufferedReader.readLine();
        while (string != null) {
            if (n2 == 0) {
                list = this.extractColumnKeys(string);
            } else {
                this.extractRowKeyAndData(string, defaultCategoryDataset, list);
            }
            string = bufferedReader.readLine();
            ++n2;
        }
        return defaultCategoryDataset;
    }

    private List extractColumnKeys(String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        do {
            if (n4 >= string.length()) {
                String string2 = string.substring(n3, string.length());
                arrayList.add(this.removeStringDelimiters(string2));
                return arrayList;
            }
            if (string.charAt(n4) == this.fieldDelimiter) {
                if (n2 > 0) {
                    String string3 = string.substring(n3, n4);
                    arrayList.add(this.removeStringDelimiters(string3));
                }
                n3 = n4 + 1;
                ++n2;
            }
            ++n4;
        } while (true);
    }

    private void extractRowKeyAndData(String string, DefaultCategoryDataset defaultCategoryDataset, List list) {
        String string2 = null;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        do {
            if (n4 >= string.length()) {
                Double d2 = Double.valueOf(this.removeStringDelimiters(string.substring(n3, string.length())));
                defaultCategoryDataset.addValue(d2, (Comparable)((Object)string2), (Comparable)list.get(n2 - 1));
                return;
            }
            if (string.charAt(n4) == this.fieldDelimiter) {
                Object object;
                if (n2 == 0) {
                    object = string.substring(n3, n4);
                    string2 = this.removeStringDelimiters((String)object);
                } else {
                    object = Double.valueOf(this.removeStringDelimiters(string.substring(n3, n4)));
                    defaultCategoryDataset.addValue((Number)object, (Comparable)((Object)string2), (Comparable)list.get(n2 - 1));
                }
                n3 = n4 + 1;
                ++n2;
            }
            ++n4;
        } while (true);
    }

    private String removeStringDelimiters(String string) {
        String string2 = string.trim();
        if (string2.charAt(0) == this.textDelimiter) {
            string2 = string2.substring(1);
        }
        if (string2.charAt(string2.length() - 1) != this.textDelimiter) return string2;
        return string2.substring(0, string2.length() - 1);
    }
}

