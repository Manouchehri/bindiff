/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import org.jfree.date.SerialDate;

public class DateChooserPanel
extends JPanel
implements ActionListener {
    private Calendar chosenDate;
    private Color chosenDateButtonColor = UIManager.getColor("textHighlight");
    private Color chosenMonthButtonColor = UIManager.getColor("control");
    private Color chosenOtherButtonColor = UIManager.getColor("controlShadow");
    private int firstDayOfWeek;
    private int yearSelectionRange = 20;
    private Font dateFont = new Font("SansSerif", 0, 10);
    private JComboBox monthSelector;
    private JComboBox yearSelector;
    private JButton todayButton;
    private JButton[] buttons;
    private boolean refreshing = false;
    private int[] WEEK_DAYS;

    public DateChooserPanel() {
        this(Calendar.getInstance(), false);
    }

    public DateChooserPanel(Calendar calendar, boolean bl2) {
        super(new BorderLayout());
        this.chosenDate = calendar;
        this.firstDayOfWeek = calendar.getFirstDayOfWeek();
        this.WEEK_DAYS = new int[7];
        for (int i2 = 0; i2 < 7; ++i2) {
            this.WEEK_DAYS[i2] = (this.firstDayOfWeek + i2 - 1) % 7 + 1;
        }
        this.add((Component)this.constructSelectionPanel(), "North");
        this.add((Component)this.getCalendarPanel(), "Center");
        if (bl2) {
            this.add((Component)this.constructControlPanel(), "South");
        }
        this.setDate(calendar.getTime());
    }

    public void setDate(Date date) {
        this.chosenDate.setTime(date);
        this.monthSelector.setSelectedIndex(this.chosenDate.get(2));
        this.refreshYearSelector();
        this.refreshButtons();
    }

    public Date getDate() {
        return this.chosenDate.getTime();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("monthSelectionChanged")) {
            JComboBox jComboBox = (JComboBox)actionEvent.getSource();
            int n2 = this.chosenDate.get(5);
            this.chosenDate.set(5, 1);
            this.chosenDate.set(2, jComboBox.getSelectedIndex());
            int n3 = this.chosenDate.getActualMaximum(5);
            this.chosenDate.set(5, Math.min(n2, n3));
            this.refreshButtons();
            return;
        }
        if (actionEvent.getActionCommand().equals("yearSelectionChanged")) {
            if (this.refreshing) return;
            JComboBox jComboBox = (JComboBox)actionEvent.getSource();
            Integer n4 = (Integer)jComboBox.getSelectedItem();
            int n5 = this.chosenDate.get(5);
            this.chosenDate.set(5, 1);
            this.chosenDate.set(1, n4);
            int n6 = this.chosenDate.getActualMaximum(5);
            this.chosenDate.set(5, Math.min(n5, n6));
            this.refreshYearSelector();
            this.refreshButtons();
            return;
        }
        if (actionEvent.getActionCommand().equals("todayButtonClicked")) {
            this.setDate(new Date());
            return;
        }
        if (!actionEvent.getActionCommand().equals("dateButtonClicked")) return;
        JButton jButton = (JButton)actionEvent.getSource();
        int n7 = Integer.parseInt(jButton.getName());
        Calendar calendar = this.getFirstVisibleDate();
        calendar.add(5, n7);
        this.setDate(calendar.getTime());
    }

    private JPanel getCalendarPanel() {
        int n2;
        JPanel jPanel = new JPanel(new GridLayout(7, 7));
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
        String[] arrstring = dateFormatSymbols.getShortWeekdays();
        for (n2 = 0; n2 < this.WEEK_DAYS.length; ++n2) {
            jPanel.add(new JLabel(arrstring[this.WEEK_DAYS[n2]], 0));
        }
        this.buttons = new JButton[42];
        n2 = 0;
        while (n2 < 42) {
            JButton jButton = new JButton("");
            jButton.setMargin(new Insets(1, 1, 1, 1));
            jButton.setName(Integer.toString(n2));
            jButton.setFont(this.dateFont);
            jButton.setFocusPainted(false);
            jButton.setActionCommand("dateButtonClicked");
            jButton.addActionListener(this);
            this.buttons[n2] = jButton;
            jPanel.add(jButton);
            ++n2;
        }
        return jPanel;
    }

    private Color getButtonColor(Calendar calendar) {
        if (this.equalDates(calendar, this.chosenDate)) {
            return this.chosenDateButtonColor;
        }
        if (calendar.get(2) != this.chosenDate.get(2)) return this.chosenOtherButtonColor;
        return this.chosenMonthButtonColor;
    }

    private boolean equalDates(Calendar calendar, Calendar calendar2) {
        if (calendar.get(5) != calendar2.get(5)) return false;
        if (calendar.get(2) != calendar2.get(2)) return false;
        if (calendar.get(1) != calendar2.get(1)) return false;
        return true;
    }

    private Calendar getFirstVisibleDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.chosenDate.get(1), this.chosenDate.get(2), 1);
        calendar.add(5, -1);
        while (calendar.get(7) != this.getFirstDayOfWeek()) {
            calendar.add(5, -1);
        }
        return calendar;
    }

    private int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    private void refreshButtons() {
        Calendar calendar = this.getFirstVisibleDate();
        int n2 = 0;
        while (n2 < 42) {
            JButton jButton = this.buttons[n2];
            jButton.setText(Integer.toString(calendar.get(5)));
            jButton.setBackground(this.getButtonColor(calendar));
            calendar.add(5, 1);
            ++n2;
        }
    }

    private void refreshYearSelector() {
        if (this.refreshing) return;
        this.refreshing = true;
        this.yearSelector.removeAllItems();
        Integer[] arrinteger = this.getYears(this.chosenDate.get(1));
        int n2 = 0;
        do {
            if (n2 >= arrinteger.length) {
                this.yearSelector.setSelectedItem(new Integer(this.chosenDate.get(1)));
                this.refreshing = false;
                return;
            }
            this.yearSelector.addItem(arrinteger[n2]);
            ++n2;
        } while (true);
    }

    private Integer[] getYears(int n2) {
        int n3 = this.yearSelectionRange * 2 + 1;
        int n4 = n2 - this.yearSelectionRange;
        Integer[] arrinteger = new Integer[n3];
        int n5 = 0;
        while (n5 < n3) {
            arrinteger[n5] = new Integer(n5 + n4);
            ++n5;
        }
        return arrinteger;
    }

    private JPanel constructSelectionPanel() {
        JPanel jPanel = new JPanel();
        int n2 = this.chosenDate.getMinimum(2);
        int n3 = this.chosenDate.getMaximum(2);
        String[] arrstring = new String[n3 - n2 + 1];
        System.arraycopy(SerialDate.getMonths(), n2, arrstring, 0, arrstring.length);
        this.monthSelector = new JComboBox<String>(arrstring);
        this.monthSelector.addActionListener(this);
        this.monthSelector.setActionCommand("monthSelectionChanged");
        jPanel.add(this.monthSelector);
        this.yearSelector = new JComboBox<Integer>(this.getYears(0));
        this.yearSelector.addActionListener(this);
        this.yearSelector.setActionCommand("yearSelectionChanged");
        jPanel.add(this.yearSelector);
        return jPanel;
    }

    private JPanel constructControlPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
        this.todayButton = new JButton("Today");
        this.todayButton.addActionListener(this);
        this.todayButton.setActionCommand("todayButtonClicked");
        jPanel.add(this.todayButton);
        return jPanel;
    }

    public Color getChosenDateButtonColor() {
        return this.chosenDateButtonColor;
    }

    public void setChosenDateButtonColor(Color color) {
        if (color == null) {
            throw new NullPointerException("UIColor must not be null.");
        }
        Color color2 = this.chosenDateButtonColor;
        this.chosenDateButtonColor = color;
        this.refreshButtons();
        this.firePropertyChange("chosenDateButtonColor", color2, color);
    }

    public Color getChosenMonthButtonColor() {
        return this.chosenMonthButtonColor;
    }

    public void setChosenMonthButtonColor(Color color) {
        if (color == null) {
            throw new NullPointerException("UIColor must not be null.");
        }
        Color color2 = this.chosenMonthButtonColor;
        this.chosenMonthButtonColor = color;
        this.refreshButtons();
        this.firePropertyChange("chosenMonthButtonColor", color2, color);
    }

    public Color getChosenOtherButtonColor() {
        return this.chosenOtherButtonColor;
    }

    public void setChosenOtherButtonColor(Color color) {
        if (color == null) {
            throw new NullPointerException("UIColor must not be null.");
        }
        Color color2 = this.chosenOtherButtonColor;
        this.chosenOtherButtonColor = color;
        this.refreshButtons();
        this.firePropertyChange("chosenOtherButtonColor", color2, color);
    }

    public int getYearSelectionRange() {
        return this.yearSelectionRange;
    }

    public void setYearSelectionRange(int n2) {
        int n3 = this.yearSelectionRange;
        this.yearSelectionRange = n2;
        this.refreshYearSelector();
        this.firePropertyChange("yearSelectionRange", n3, n2);
    }
}

