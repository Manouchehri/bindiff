package org.jfree.ui;

import java.util.*;
import java.awt.event.*;
import java.text.*;
import java.awt.*;
import org.jfree.date.*;
import javax.swing.*;

public class DateChooserPanel extends JPanel implements ActionListener
{
    private Calendar chosenDate;
    private Color chosenDateButtonColor;
    private Color chosenMonthButtonColor;
    private Color chosenOtherButtonColor;
    private int firstDayOfWeek;
    private int yearSelectionRange;
    private Font dateFont;
    private JComboBox monthSelector;
    private JComboBox yearSelector;
    private JButton todayButton;
    private JButton[] buttons;
    private boolean refreshing;
    private int[] WEEK_DAYS;
    
    public DateChooserPanel() {
        this(Calendar.getInstance(), false);
    }
    
    public DateChooserPanel(final Calendar chosenDate, final boolean b) {
        super(new BorderLayout());
        this.yearSelectionRange = 20;
        this.dateFont = new Font("SansSerif", 0, 10);
        this.refreshing = false;
        this.chosenDateButtonColor = UIManager.getColor("textHighlight");
        this.chosenMonthButtonColor = UIManager.getColor("control");
        this.chosenOtherButtonColor = UIManager.getColor("controlShadow");
        this.chosenDate = chosenDate;
        this.firstDayOfWeek = chosenDate.getFirstDayOfWeek();
        this.WEEK_DAYS = new int[7];
        for (int i = 0; i < 7; ++i) {
            this.WEEK_DAYS[i] = (this.firstDayOfWeek + i - 1) % 7 + 1;
        }
        this.add(this.constructSelectionPanel(), "North");
        this.add(this.getCalendarPanel(), "Center");
        if (b) {
            this.add(this.constructControlPanel(), "South");
        }
        this.setDate(chosenDate.getTime());
    }
    
    public void setDate(final Date time) {
        this.chosenDate.setTime(time);
        this.monthSelector.setSelectedIndex(this.chosenDate.get(2));
        this.refreshYearSelector();
        this.refreshButtons();
    }
    
    public Date getDate() {
        return this.chosenDate.getTime();
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("monthSelectionChanged")) {
            final JComboBox comboBox = (JComboBox)actionEvent.getSource();
            final int value = this.chosenDate.get(5);
            this.chosenDate.set(5, 1);
            this.chosenDate.set(2, comboBox.getSelectedIndex());
            this.chosenDate.set(5, Math.min(value, this.chosenDate.getActualMaximum(5)));
            this.refreshButtons();
        }
        else if (actionEvent.getActionCommand().equals("yearSelectionChanged")) {
            if (!this.refreshing) {
                final Integer n = (Integer)((JComboBox)actionEvent.getSource()).getSelectedItem();
                final int value2 = this.chosenDate.get(5);
                this.chosenDate.set(5, 1);
                this.chosenDate.set(1, n);
                this.chosenDate.set(5, Math.min(value2, this.chosenDate.getActualMaximum(5)));
                this.refreshYearSelector();
                this.refreshButtons();
            }
        }
        else if (actionEvent.getActionCommand().equals("todayButtonClicked")) {
            this.setDate(new Date());
        }
        else if (actionEvent.getActionCommand().equals("dateButtonClicked")) {
            final int int1 = Integer.parseInt(((JButton)actionEvent.getSource()).getName());
            final Calendar firstVisibleDate = this.getFirstVisibleDate();
            firstVisibleDate.add(5, int1);
            this.setDate(firstVisibleDate.getTime());
        }
    }
    
    private JPanel getCalendarPanel() {
        final JPanel panel = new JPanel(new GridLayout(7, 7));
        final String[] shortWeekdays = new DateFormatSymbols().getShortWeekdays();
        for (int i = 0; i < this.WEEK_DAYS.length; ++i) {
            panel.add(new JLabel(shortWeekdays[this.WEEK_DAYS[i]], 0));
        }
        this.buttons = new JButton[42];
        for (int j = 0; j < 42; ++j) {
            final JButton button = new JButton("");
            button.setMargin(new Insets(1, 1, 1, 1));
            button.setName(Integer.toString(j));
            button.setFont(this.dateFont);
            button.setFocusPainted(false);
            button.setActionCommand("dateButtonClicked");
            button.addActionListener(this);
            panel.add(this.buttons[j] = button);
        }
        return panel;
    }
    
    private Color getButtonColor(final Calendar calendar) {
        if (this.equalDates(calendar, this.chosenDate)) {
            return this.chosenDateButtonColor;
        }
        if (calendar.get(2) == this.chosenDate.get(2)) {
            return this.chosenMonthButtonColor;
        }
        return this.chosenOtherButtonColor;
    }
    
    private boolean equalDates(final Calendar calendar, final Calendar calendar2) {
        return calendar.get(5) == calendar2.get(5) && calendar.get(2) == calendar2.get(2) && calendar.get(1) == calendar2.get(1);
    }
    
    private Calendar getFirstVisibleDate() {
        final Calendar instance = Calendar.getInstance();
        instance.set(this.chosenDate.get(1), this.chosenDate.get(2), 1);
        instance.add(5, -1);
        while (instance.get(7) != this.getFirstDayOfWeek()) {
            instance.add(5, -1);
        }
        return instance;
    }
    
    private int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }
    
    private void refreshButtons() {
        final Calendar firstVisibleDate = this.getFirstVisibleDate();
        for (int i = 0; i < 42; ++i) {
            final JButton button = this.buttons[i];
            button.setText(Integer.toString(firstVisibleDate.get(5)));
            button.setBackground(this.getButtonColor(firstVisibleDate));
            firstVisibleDate.add(5, 1);
        }
    }
    
    private void refreshYearSelector() {
        if (!this.refreshing) {
            this.refreshing = true;
            this.yearSelector.removeAllItems();
            final Integer[] years = this.getYears(this.chosenDate.get(1));
            for (int i = 0; i < years.length; ++i) {
                this.yearSelector.addItem(years[i]);
            }
            this.yearSelector.setSelectedItem(new Integer(this.chosenDate.get(1)));
            this.refreshing = false;
        }
    }
    
    private Integer[] getYears(final int n) {
        final int n2 = this.yearSelectionRange * 2 + 1;
        final int n3 = n - this.yearSelectionRange;
        final Integer[] array = new Integer[n2];
        for (int i = 0; i < n2; ++i) {
            array[i] = new Integer(i + n3);
        }
        return array;
    }
    
    private JPanel constructSelectionPanel() {
        final JPanel panel = new JPanel();
        final int minimum = this.chosenDate.getMinimum(2);
        final String[] array = new String[this.chosenDate.getMaximum(2) - minimum + 1];
        System.arraycopy(SerialDate.getMonths(), minimum, array, 0, array.length);
        (this.monthSelector = new JComboBox(array)).addActionListener(this);
        this.monthSelector.setActionCommand("monthSelectionChanged");
        panel.add(this.monthSelector);
        (this.yearSelector = new JComboBox((E[])this.getYears(0))).addActionListener(this);
        this.yearSelector.setActionCommand("yearSelectionChanged");
        panel.add(this.yearSelector);
        return panel;
    }
    
    private JPanel constructControlPanel() {
        final JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
        (this.todayButton = new JButton("Today")).addActionListener(this);
        this.todayButton.setActionCommand("todayButtonClicked");
        panel.add(this.todayButton);
        return panel;
    }
    
    public Color getChosenDateButtonColor() {
        return this.chosenDateButtonColor;
    }
    
    public void setChosenDateButtonColor(final Color chosenDateButtonColor) {
        if (chosenDateButtonColor == null) {
            throw new NullPointerException("UIColor must not be null.");
        }
        final Color chosenDateButtonColor2 = this.chosenDateButtonColor;
        this.chosenDateButtonColor = chosenDateButtonColor;
        this.refreshButtons();
        this.firePropertyChange("chosenDateButtonColor", chosenDateButtonColor2, chosenDateButtonColor);
    }
    
    public Color getChosenMonthButtonColor() {
        return this.chosenMonthButtonColor;
    }
    
    public void setChosenMonthButtonColor(final Color chosenMonthButtonColor) {
        if (chosenMonthButtonColor == null) {
            throw new NullPointerException("UIColor must not be null.");
        }
        final Color chosenMonthButtonColor2 = this.chosenMonthButtonColor;
        this.chosenMonthButtonColor = chosenMonthButtonColor;
        this.refreshButtons();
        this.firePropertyChange("chosenMonthButtonColor", chosenMonthButtonColor2, chosenMonthButtonColor);
    }
    
    public Color getChosenOtherButtonColor() {
        return this.chosenOtherButtonColor;
    }
    
    public void setChosenOtherButtonColor(final Color chosenOtherButtonColor) {
        if (chosenOtherButtonColor == null) {
            throw new NullPointerException("UIColor must not be null.");
        }
        final Color chosenOtherButtonColor2 = this.chosenOtherButtonColor;
        this.chosenOtherButtonColor = chosenOtherButtonColor;
        this.refreshButtons();
        this.firePropertyChange("chosenOtherButtonColor", chosenOtherButtonColor2, chosenOtherButtonColor);
    }
    
    public int getYearSelectionRange() {
        return this.yearSelectionRange;
    }
    
    public void setYearSelectionRange(final int yearSelectionRange) {
        final int yearSelectionRange2 = this.yearSelectionRange;
        this.yearSelectionRange = yearSelectionRange;
        this.refreshYearSelector();
        this.firePropertyChange("yearSelectionRange", yearSelectionRange2, yearSelectionRange);
    }
}
