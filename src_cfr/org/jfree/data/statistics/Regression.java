/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.statistics;

import org.jfree.data.xy.XYDataset;

public abstract class Regression {
    public static double[] getOLSRegression(double[][] arrd) {
        int n2 = arrd.length;
        if (n2 < 2) {
            throw new IllegalArgumentException("Not enough data.");
        }
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                double d6 = d4 - d2 * d2 / (double)n2;
                double d7 = d5 - d2 * d3 / (double)n2;
                double d8 = d2 / (double)n2;
                double d9 = d3 / (double)n2;
                double[] arrd2 = new double[2];
                arrd2[1] = d7 / d6;
                arrd2[0] = d9 - arrd2[1] * d8;
                return arrd2;
            }
            double d10 = arrd[n3][0];
            double d11 = arrd[n3][1];
            d2 += d10;
            d3 += d11;
            double d12 = d10 * d10;
            d4 += d12;
            double d13 = d10 * d11;
            d5 += d13;
            ++n3;
        } while (true);
    }

    public static double[] getOLSRegression(XYDataset xYDataset, int n2) {
        int n3 = xYDataset.getItemCount(n2);
        if (n3 < 2) {
            throw new IllegalArgumentException("Not enough data.");
        }
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        int n4 = 0;
        do {
            if (n4 >= n3) {
                double d6 = d4 - d2 * d2 / (double)n3;
                double d7 = d5 - d2 * d3 / (double)n3;
                double d8 = d2 / (double)n3;
                double d9 = d3 / (double)n3;
                double[] arrd = new double[2];
                arrd[1] = d7 / d6;
                arrd[0] = d9 - arrd[1] * d8;
                return arrd;
            }
            double d10 = xYDataset.getXValue(n2, n4);
            double d11 = xYDataset.getYValue(n2, n4);
            d2 += d10;
            d3 += d11;
            double d12 = d10 * d10;
            d4 += d12;
            double d13 = d10 * d11;
            d5 += d13;
            ++n4;
        } while (true);
    }

    public static double[] getPowerRegression(double[][] arrd) {
        int n2 = arrd.length;
        if (n2 < 2) {
            throw new IllegalArgumentException("Not enough data.");
        }
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                double d6 = d4 - d2 * d2 / (double)n2;
                double d7 = d5 - d2 * d3 / (double)n2;
                double d8 = d2 / (double)n2;
                double d9 = d3 / (double)n2;
                double[] arrd2 = new double[2];
                arrd2[1] = d7 / d6;
                arrd2[0] = Math.pow(Math.exp(1.0), d9 - arrd2[1] * d8);
                return arrd2;
            }
            double d10 = Math.log(arrd[n3][0]);
            double d11 = Math.log(arrd[n3][1]);
            d2 += d10;
            d3 += d11;
            double d12 = d10 * d10;
            d4 += d12;
            double d13 = d10 * d11;
            d5 += d13;
            ++n3;
        } while (true);
    }

    public static double[] getPowerRegression(XYDataset xYDataset, int n2) {
        int n3 = xYDataset.getItemCount(n2);
        if (n3 < 2) {
            throw new IllegalArgumentException("Not enough data.");
        }
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        int n4 = 0;
        do {
            if (n4 >= n3) {
                double d6 = d4 - d2 * d2 / (double)n3;
                double d7 = d5 - d2 * d3 / (double)n3;
                double d8 = d2 / (double)n3;
                double d9 = d3 / (double)n3;
                double[] arrd = new double[2];
                arrd[1] = d7 / d6;
                arrd[0] = Math.pow(Math.exp(1.0), d9 - arrd[1] * d8);
                return arrd;
            }
            double d10 = Math.log(xYDataset.getXValue(n2, n4));
            double d11 = Math.log(xYDataset.getYValue(n2, n4));
            d2 += d10;
            d3 += d11;
            double d12 = d10 * d10;
            d4 += d12;
            double d13 = d10 * d11;
            d5 += d13;
            ++n4;
        } while (true);
    }
}

