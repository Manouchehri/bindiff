package org.jfree.chart.imagemap;

public class StandardURLTagFragmentGenerator implements URLTagFragmentGenerator
{
    public String generateURLFragment(final String s) {
        return " href=\"" + s + "\"";
    }
}
