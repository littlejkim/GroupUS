package com.example.android.groupus;

/**
 * Created by littlejkim on 06/04/2018.
 */
import android.content.Intent;
import android.widget.Toast;
import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BasicActivity extends BaseActivity {
    String userEmail = "littlejkim@gmail.com";
    String friend1LionPathUsername;
    String friend1LionPathPassword;

    String friend2LionPathUsername;
    String friend2LionPathPassword;

    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();
        WeekViewEvent event;
        int idnum = 1;

        String  input  = "TuTh 1:35PM - 2:50PM\n" +
                "TuTh 3:05PM - 4:20PM\n" +
                "We 1:25PM - 2:15PM\n" +
                "MoWeFr 2:30PM - 3:20PM\n" +
                "MoWeFr 10:10AM - 11:00AM\n" +
                "MoWeFr 4:40PM - 5:30PM";

        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            StringTokenizer st = new StringTokenizer(line);
            String[] container = new String[4];
            int conti = 0;
            while (st.hasMoreTokens()) {
                container[conti] = st.nextToken();
                conti++;
            }
            int startHour = 0;
            int startMinute = 0;
            int endHour = 0;
            int endMinute = 0;

            if (container[1].length() == 6){
                startHour = Integer.parseInt(Character.toString(container[1].charAt(0)));

                String minute;
                minute = Character.toString(container[1].charAt(2)) + Character.toString(container[1].charAt(3));
                startMinute = Integer.parseInt(minute);

                String PM;
                PM = Character.toString(container[1].charAt(4)) + Character.toString(container[1].charAt(5));
                if (PM.equals("PM"))
                    startHour+=12;
            }
            else if (container[1].length() == 7){
                String hour;
                hour = Character.toString(container[1].charAt(0)) + Character.toString(container[1].charAt(1));
                startHour = Integer.parseInt(hour);

                String minute;
                minute = Character.toString(container[1].charAt(3)) + Character.toString(container[1].charAt(4));
                startMinute = Integer.parseInt(minute);

                String PM;
                PM = Character.toString(container[1].charAt(5)) + Character.toString(container[1].charAt(6));
                if (PM.equals("PM"))
                    startHour+=12;
            }

            if (container[3].length() == 6){
                endHour = Integer.parseInt(Character.toString(container[3].charAt(0)));

                String minute;
                minute = Character.toString(container[3].charAt(2)) + Character.toString(container[3].charAt(3));
                endMinute = Integer.parseInt(minute);

                String PM;
                PM = Character.toString(container[3].charAt(4)) + Character.toString(container[3].charAt(5));
                if (PM.equals("PM"))
                    endHour+=12;
            }
            else if (container[3].length() == 7){
                String hour;
                hour = Character.toString(container[3].charAt(0)) + Character.toString(container[3].charAt(1));
                endMinute = Integer.parseInt(hour);

                String minute;
                minute = Character.toString(container[3].charAt(3)) + Character.toString(container[3].charAt(4));
                endMinute = Integer.parseInt(minute);

                String PM;
                PM = Character.toString(container[3].charAt(5)) + Character.toString(container[3].charAt(6));
                if (PM.equals("PM"))
                    endHour+=12;
            }


            for (int i = 0; i < container[0].length(); i+=2){
                String dayOfWeek;
                dayOfWeek = Character.toString(container[0].charAt(i)) + Character.toString(container[0].charAt(i+1));
                Calendar startTime;
                Calendar endTime;

                switch (dayOfWeek){
                    case "Mo":
                        //System.out.println("MONDAY" + " " + startHour + " " + startMinute + " " + endHour + " " + endMinute);
                        startTime = Calendar.getInstance();
                        startTime.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                        startTime.set(Calendar.HOUR_OF_DAY, startHour);
                        startTime.set(Calendar.MINUTE,  startMinute);
                        startTime.set(Calendar.MONTH, newMonth - 1);
                        startTime.set(Calendar.YEAR, newYear);
                        endTime = Calendar.getInstance();
                        endTime.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                        endTime.set(Calendar.HOUR_OF_DAY, endHour);
                        endTime.set(Calendar.MINUTE,  endMinute);
                        endTime.set(Calendar.MONTH, newMonth - 1);
                        event = new WeekViewEvent(idnum, getEventTitle(startTime), startTime, endTime);
                        event.setColor(getResources().getColor(R.color.event_color_02));
                        events.add(event);
                        idnum++;
                        break;
                    case "Tu":
                        //System.out.println("TUESDAY" + " " + startHour + " " + startMinute + " " + endHour + " " + endMinute);
                        startTime = Calendar.getInstance();
                        startTime.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                        startTime.set(Calendar.HOUR_OF_DAY, startHour);
                        startTime.set(Calendar.MINUTE,  startMinute);
                        startTime.set(Calendar.MONTH, newMonth - 1);
                        startTime.set(Calendar.YEAR, newYear);
                        endTime = Calendar.getInstance();
                        endTime.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                        endTime.set(Calendar.HOUR_OF_DAY, endHour);
                        endTime.set(Calendar.MINUTE,  endMinute);
                        endTime.set(Calendar.MONTH, newMonth - 1);
                        event = new WeekViewEvent(idnum, getEventTitle(startTime), startTime, endTime);
                        event.setColor(getResources().getColor(R.color.event_color_02));
                        events.add(event);
                        idnum++;
                        break;
                    case "We":
                        //System.out.println("WEDNESDAY" + " " + startHour + " " + startMinute + " " + endHour + " " + endMinute);
                        startTime = Calendar.getInstance();
                        startTime.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                        startTime.set(Calendar.HOUR_OF_DAY, startHour);
                        startTime.set(Calendar.MINUTE,  startMinute);
                        startTime.set(Calendar.MONTH, newMonth - 1);
                        startTime.set(Calendar.YEAR, newYear);
                        endTime = Calendar.getInstance();
                        endTime.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                        endTime.set(Calendar.HOUR_OF_DAY, endHour);
                        endTime.set(Calendar.MINUTE,  endMinute);
                        endTime.set(Calendar.MONTH, newMonth - 1);
                        event = new WeekViewEvent(idnum, getEventTitle(startTime), startTime, endTime);
                        event.setColor(getResources().getColor(R.color.event_color_02));
                        events.add(event);
                        idnum++;
                        break;
                    case "Th":
                        //System.out.println("THURSDAY" + " " + startHour + " " + startMinute + " " + endHour + " " + endMinute);
                        startTime = Calendar.getInstance();
                        startTime.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                        startTime.set(Calendar.HOUR_OF_DAY, startHour);
                        startTime.set(Calendar.MINUTE,  startMinute);
                        startTime.set(Calendar.MONTH, newMonth - 1);
                        startTime.set(Calendar.YEAR, newYear);
                        endTime = Calendar.getInstance();
                        endTime.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                        endTime.set(Calendar.HOUR_OF_DAY, endHour);
                        endTime.set(Calendar.MINUTE,  endMinute);
                        endTime.set(Calendar.MONTH, newMonth - 1);
                        event = new WeekViewEvent(idnum, getEventTitle(startTime), startTime, endTime);
                        event.setColor(getResources().getColor(R.color.event_color_02));
                        events.add(event);
                        idnum++;
                        break;
                    case "Fr":
                        //System.out.println("FRIDAY" + " " + startHour + " " + startMinute + " " + endHour + " " + endMinute);
                        startTime = Calendar.getInstance();
                        startTime.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                        startTime.set(Calendar.HOUR_OF_DAY, startHour);
                        startTime.set(Calendar.MINUTE,  startMinute);
                        startTime.set(Calendar.MONTH, newMonth - 1);
                        startTime.set(Calendar.YEAR, newYear);
                        endTime = Calendar.getInstance();
                        endTime.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                        endTime.set(Calendar.HOUR_OF_DAY, endHour);
                        endTime.set(Calendar.MINUTE,  endMinute);
                        endTime.set(Calendar.MONTH, newMonth - 1);
                        event = new WeekViewEvent(idnum, getEventTitle(startTime), startTime, endTime);
                        event.setColor(getResources().getColor(R.color.event_color_02));
                        events.add(event);
                        idnum++;
                        break;
                    default:
                        break;
                }


            }
        }
        scanner.close();



        String input2 = "MoWeFr 4:40PM - 5:30PM\n" +
                "Tu 3:35PM - 5:30PM\n" +
                "MoWeFr 11:15AM - 12:05PM\n" +
                "Tu 11:15AM - 2:15PM\n" +
                "TuTh 9:05AM - 9:55AM\n" +
                "We 6:30PM - 8:25PM";

        Scanner scanner2 = new Scanner(input2);
        while (scanner2.hasNextLine()) {
            String line = scanner2.nextLine();
            StringTokenizer st = new StringTokenizer(line);
            String[] container = new String[4];
            int conti = 0;
            while (st.hasMoreTokens()) {
                container[conti] = st.nextToken();
                conti++;
            }
            int startHour = 0;
            int startMinute = 0;
            int endHour = 0;
            int endMinute = 0;

            if (container[1].length() == 6){
                startHour = Integer.parseInt(Character.toString(container[1].charAt(0)));

                String minute;
                minute = Character.toString(container[1].charAt(2)) + Character.toString(container[1].charAt(3));
                startMinute = Integer.parseInt(minute);

                String PM;
                PM = Character.toString(container[1].charAt(4)) + Character.toString(container[1].charAt(5));
                if (PM.equals("PM"))
                    startHour+=12;
            }
            else if (container[1].length() == 7){
                String hour;
                hour = Character.toString(container[1].charAt(0)) + Character.toString(container[1].charAt(1));
                startHour = Integer.parseInt(hour);

                String minute;
                minute = Character.toString(container[1].charAt(3)) + Character.toString(container[1].charAt(4));
                startMinute = Integer.parseInt(minute);

                String PM;
                PM = Character.toString(container[1].charAt(5)) + Character.toString(container[1].charAt(6));
                if (PM.equals("PM"))
                    startHour+=12;
            }

            if (container[3].length() == 6){
                endHour = Integer.parseInt(Character.toString(container[3].charAt(0)));

                String minute;
                minute = Character.toString(container[3].charAt(2)) + Character.toString(container[3].charAt(3));
                endMinute = Integer.parseInt(minute);

                String PM;
                PM = Character.toString(container[3].charAt(4)) + Character.toString(container[3].charAt(5));
                if (PM.equals("PM"))
                    endHour+=12;
            }
            else if (container[3].length() == 7){
                String hour;
                hour = Character.toString(container[3].charAt(0)) + Character.toString(container[3].charAt(1));
                endMinute = Integer.parseInt(hour);

                String minute;
                minute = Character.toString(container[3].charAt(3)) + Character.toString(container[3].charAt(4));
                endMinute = Integer.parseInt(minute);

                String PM;
                PM = Character.toString(container[3].charAt(5)) + Character.toString(container[3].charAt(6));
                if (PM.equals("PM"))
                    endHour+=12;
            }


            for (int i = 0; i < container[0].length(); i+=2){
                String dayOfWeek;
                dayOfWeek = Character.toString(container[0].charAt(i)) + Character.toString(container[0].charAt(i+1));
                Calendar startTime;
                Calendar endTime;

                switch (dayOfWeek){
                    case "Mo":
                        //System.out.println("MONDAY" + " " + startHour + " " + startMinute + " " + endHour + " " + endMinute);
                        startTime = Calendar.getInstance();
                        startTime.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                        startTime.set(Calendar.HOUR_OF_DAY, startHour);
                        startTime.set(Calendar.MINUTE,  startMinute);
                        startTime.set(Calendar.MONTH, newMonth - 1);
                        startTime.set(Calendar.YEAR, newYear);
                        endTime = Calendar.getInstance();
                        endTime.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                        endTime.set(Calendar.HOUR_OF_DAY, endHour);
                        endTime.set(Calendar.MINUTE,  endMinute);
                        endTime.set(Calendar.MONTH, newMonth - 1);
                        event = new WeekViewEvent(idnum, getEventTitle(startTime), startTime, endTime);
                        event.setColor(getResources().getColor(R.color.event_color_03));
                        events.add(event);
                        idnum++;
                        break;
                    case "Tu":
                        //System.out.println("TUESDAY" + " " + startHour + " " + startMinute + " " + endHour + " " + endMinute);
                        startTime = Calendar.getInstance();
                        startTime.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                        startTime.set(Calendar.HOUR_OF_DAY, startHour);
                        startTime.set(Calendar.MINUTE,  startMinute);
                        startTime.set(Calendar.MONTH, newMonth - 1);
                        startTime.set(Calendar.YEAR, newYear);
                        endTime = Calendar.getInstance();
                        endTime.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                        endTime.set(Calendar.HOUR_OF_DAY, endHour);
                        endTime.set(Calendar.MINUTE,  endMinute);
                        endTime.set(Calendar.MONTH, newMonth - 1);
                        event = new WeekViewEvent(idnum, getEventTitle(startTime), startTime, endTime);
                        event.setColor(getResources().getColor(R.color.event_color_03));
                        events.add(event);
                        idnum++;
                        break;
                    case "We":
                        //System.out.println("WEDNESDAY" + " " + startHour + " " + startMinute + " " + endHour + " " + endMinute);
                        startTime = Calendar.getInstance();
                        startTime.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                        startTime.set(Calendar.HOUR_OF_DAY, startHour);
                        startTime.set(Calendar.MINUTE,  startMinute);
                        startTime.set(Calendar.MONTH, newMonth - 1);
                        startTime.set(Calendar.YEAR, newYear);
                        endTime = Calendar.getInstance();
                        endTime.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                        endTime.set(Calendar.HOUR_OF_DAY, endHour);
                        endTime.set(Calendar.MINUTE,  endMinute);
                        endTime.set(Calendar.MONTH, newMonth - 1);
                        event = new WeekViewEvent(idnum, getEventTitle(startTime), startTime, endTime);
                        event.setColor(getResources().getColor(R.color.event_color_03));
                        events.add(event);
                        idnum++;
                        break;
                    case "Th":
                        //System.out.println("THURSDAY" + " " + startHour + " " + startMinute + " " + endHour + " " + endMinute);
                        startTime = Calendar.getInstance();
                        startTime.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                        startTime.set(Calendar.HOUR_OF_DAY, startHour);
                        startTime.set(Calendar.MINUTE,  startMinute);
                        startTime.set(Calendar.MONTH, newMonth - 1);
                        startTime.set(Calendar.YEAR, newYear);
                        endTime = Calendar.getInstance();
                        endTime.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                        endTime.set(Calendar.HOUR_OF_DAY, endHour);
                        endTime.set(Calendar.MINUTE,  endMinute);
                        endTime.set(Calendar.MONTH, newMonth - 1);
                        event = new WeekViewEvent(idnum, getEventTitle(startTime), startTime, endTime);
                        event.setColor(getResources().getColor(R.color.event_color_03));
                        events.add(event);
                        idnum++;
                        break;
                    case "Fr":
                        //System.out.println("FRIDAY" + " " + startHour + " " + startMinute + " " + endHour + " " + endMinute);
                        startTime = Calendar.getInstance();
                        startTime.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                        startTime.set(Calendar.HOUR_OF_DAY, startHour);
                        startTime.set(Calendar.MINUTE,  startMinute);
                        startTime.set(Calendar.MONTH, newMonth - 1);
                        startTime.set(Calendar.YEAR, newYear);
                        endTime = Calendar.getInstance();
                        endTime.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                        endTime.set(Calendar.HOUR_OF_DAY, endHour);
                        endTime.set(Calendar.MINUTE,  endMinute);
                        endTime.set(Calendar.MONTH, newMonth - 1);
                        event = new WeekViewEvent(idnum, getEventTitle(startTime), startTime, endTime);
                        event.setColor(getResources().getColor(R.color.event_color_03));
                        events.add(event);
                        idnum++;
                        break;
                    default:
                        break;
                }


            }
        }
        scanner.close();


        // Populate the week view with some events.


        /*Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth - 1);
        startTime.set(Calendar.YEAR, newYear);
        Calendar endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 1);
        endTime.set(Calendar.MONTH, newMonth - 1);
        WeekViewEvent event = new WeekViewEvent(1, getEventTitle(startTime), startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 4);
        endTime.set(Calendar.MINUTE, 30);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(10, getEventTitle(startTime), startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_02));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 4);
        startTime.set(Calendar.MINUTE, 20);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 5);
        endTime.set(Calendar.MINUTE, 0);
        event = new WeekViewEvent(10, getEventTitle(startTime), startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 5);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 2);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(2, getEventTitle(startTime), startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_02));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 5);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth - 1);
        startTime.set(Calendar.YEAR, newYear);
        startTime.add(Calendar.DATE, 1);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        endTime.set(Calendar.MONTH, newMonth - 1);
        event = new WeekViewEvent(3, getEventTitle(startTime), startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_03));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 15);
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent(4, getEventTitle(startTime), startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_04));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 1);
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent(5, getEventTitle(startTime), startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_01));
        events.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, startTime.getActualMaximum(Calendar.DAY_OF_MONTH));
        startTime.set(Calendar.HOUR_OF_DAY, 15);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent(5, getEventTitle(startTime), startTime, endTime);
        event.setColor(getResources().getColor(R.color.event_color_02));
        events.add(event);*/

        return events;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                userEmail = data.getStringExtra("email");
                Toast.makeText(BasicActivity.this, userEmail, Toast.LENGTH_LONG).show();
            }
        }


    }

    @Override
    public void onBackPressed() {

    }


}