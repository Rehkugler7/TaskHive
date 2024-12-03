import processing.core.PApplet;

public class Calendar {

        String[] months = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Augosto", "Septimebre", "Octubre", "Noviembre", "Diciembre"};

        int year, month, day;
        int nDaysMonth, nDaysLastMonth;
        int weekDay, firstDay;
        boolean dateSelected = false;
        int selectedDay = 0, selectedMonth = 0, selectedYear = 0;

        java.util.Calendar currentMonth, lastMonth;

        calendarButtons[] calendarDay;

        float x, y, w, h;
        PApplet pcs;


        //Constructor

        public Calendar(PApplet pcs, float x, float y, float w, float h) {

            this.pcs = pcs;
            this.calendarDay = new calendarButtons[37];

            this.currentMonth = java.util.Calendar.getInstance();
            currentMonth.set(java.util.Calendar.DAY_OF_MONTH, 1);

            this.year = currentMonth.get(java.util.Calendar.YEAR);
            this.month = currentMonth.get(java.util.Calendar.MONTH) + 1;
            this.day = currentMonth.get(java.util.Calendar.DATE);

            this.nDaysMonth = currentMonth.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

            this.weekDay = currentMonth.get(java.util.Calendar.DAY_OF_WEEK);
            if (weekDay == java.util.Calendar.SUNDAY) {
                this.weekDay = 6;
            } else {
                this.weekDay = this.weekDay - 2;
            }

            currentMonth.set(java.util.Calendar.DAY_OF_WEEK, currentMonth.getFirstDayOfWeek());
            this.firstDay = currentMonth.get(java.util.Calendar.DATE);

            lastMonth = java.util.Calendar.getInstance();
            setPrevCalendar(1, this.month - 2, this.year);

            this.nDaysLastMonth = lastMonth.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            createCalendar(pcs, x, y, w, h);
        }

        // Getters & Setters
        public boolean isDateSelected() {
            return this.dateSelected;
        }

        public String getSelectedDate() {
            return this.selectedDay + "/" + this.selectedMonth + "/" + this.selectedYear;
        }

        public void setCalendar(int d, int m, int y) {
            currentMonth.set(java.util.Calendar.YEAR, y);
            currentMonth.set(java.util.Calendar.MONTH, m);
            currentMonth.set(java.util.Calendar.DATE, d);
        }

        public void setPrevCalendar(int d, int m, int y) {
            lastMonth.set(java.util.Calendar.YEAR, y);
            lastMonth.set(java.util.Calendar.MONTH, m);
            lastMonth.set(java.util.Calendar.DATE, d);
        }

        public void setSelectedDate(int d, int m, int y) {
            this.selectedDay = d;
            this.selectedMonth = m;
            this.selectedYear = y;
        }


        // Check the previous month

        public void lastMonth() {

            this.calendarDay = new calendarButtons[37];

            this.month--;
            if (this.month == 0) {
                this.month = 12;
                this.year--;
            }
            setCalendar(this.day, this.month - 1, this.year);

            this.nDaysMonth = currentMonth.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

            this.weekDay = currentMonth.get(java.util.Calendar.DAY_OF_WEEK);
            if (weekDay == java.util.Calendar.SUNDAY) {
                this.weekDay = 6;
            } else {
                this.weekDay = this.weekDay - 2;
            }

            currentMonth.set(java.util.Calendar.DAY_OF_WEEK, currentMonth.getFirstDayOfWeek());
            this.firstDay = currentMonth.get(java.util.Calendar.DATE);

            setPrevCalendar(1, this.month - 2, this.year);
            this.nDaysLastMonth = lastMonth.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

            createCalendar(pcs, x, y, w, h);
        }

        public void createCalendar(PApplet pcs, float x, float y, float w, float h) {

            float dayWidth = w / 7;
            float dayHeight = h / 6;
            int numDia = 1;
            int f = 0, nb = 0;

            while (numDia <= nDaysMonth) {

                if (firstDay != 1 && f == 0) {
                    int lastMonth = 0;
                    for (int p = firstDay, c = 0; p <= nDaysLastMonth; p++, c++) {
                        calendarDay[nb] = new calendarButtons(pcs, x + c * dayWidth, y + f * dayHeight, dayWidth, dayHeight, p, month, year);
                        calendarDay[nb].setEnabled(false);
                        lastMonth++;
                        nb++;
                    }
                    for (int c = lastMonth; c < 7; c++) {
                        calendarDay[nb] = new calendarButtons(pcs, x + c * dayWidth, y + f * dayHeight, dayWidth, dayHeight, numDia, month, year);
                        numDia++;
                        nb++;
                    }
                    f++;
                } else {
                    for (int c = 0; c < 7; c++) {
                        calendarDay[nb] = new calendarButtons(pcs, x + c * dayWidth, y + f * dayHeight, dayWidth, dayHeight, numDia, month, year);
                        numDia++;
                        nb++;
                        if (numDia > nDaysMonth) {
                            break;
                        }
                    }
                    f++;
                }
            }
        }

        // Go to next month
        public void nextMonth() {

            this.calendarDay = new calendarButtons[37];

            this.month++;
            if (this.month == 13) {
                this.month = 1;
                this.year++;
            }
            setCalendar(this.day, this.month - 1, this.year);

            this.nDaysMonth = currentMonth.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

            this.weekDay = currentMonth.get(java.util.Calendar.DAY_OF_WEEK);
            if (weekDay == java.util.Calendar.SUNDAY) {
                this.weekDay = 6;
            } else {
                this.weekDay = this.weekDay - 2;
            }

            currentMonth.set(java.util.Calendar.DAY_OF_WEEK, currentMonth.getFirstDayOfWeek());
            this.firstDay = currentMonth.get(java.util.Calendar.DATE);

            setPrevCalendar(1, this.month - 2, this.year);

            this.nDaysLastMonth = lastMonth.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

            createCalendar(pcs,x, y, w, h);
        }


        // Draw Calendar

        public void display(PApplet pcs) {
            pcs.pushStyle();
            pcs.fill(0);
            pcs.textSize(36);
            pcs.textAlign(pcs.LEFT);
            pcs.text(months[month - 1] + "/" + year, x, y - 30);
            for (calendarButtons b : calendarDay) {
                if (b != null) {
                    b.display(pcs);
                }
            }

            if (dateSelected) {
                String dateText = this.selectedDay + "/" + this.selectedMonth + "/" + this.selectedYear;
                pcs.fill(0);
                pcs.textSize(24);
                pcs.textAlign(pcs.RIGHT);
                pcs.text(dateText, x + w, y - 30);
            }
            pcs.popStyle();
        }


        // Comprova si pitjam sobre els botons del Calendari
        public void checkButtons(PApplet p5) {
            for (calendarButtons b : calendarDay) {
                if ((b != null) && (b.enabled) && (b.mouseOver(p5))) {
                    boolean prevState = b.selected;
                    deselectAll();
                    b.setSelected(!prevState);
                    if (b.selected) {
                        dateSelected = true;
                        setSelectedDate(b.day, b.month, b.year);
                    } else {
                        dateSelected = false;
                    }
                }
            }
        }

        // Deselecciona tots els botons del Calendari
        public void deselectAll() {
            for (calendarButtons b : calendarDay) {
                if (b != null) {
                    b.setSelected(false);
                }
            }
        }
    }
