/*
  Given a date, return the corresponding day of the week for that date.

  The input is given as three integers representing the day,
  month and year respectively.

  Return the answer as one of the following values
  {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.

 

  Example 1:

  Input: day = 31, month = 8, year = 2019
  Output: "Saturday"

  Example 2:

  Input: day = 18, month = 7, year = 1999
  Output: "Sunday"

  Example 3:

  Input: day = 15, month = 8, year = 1993
  Output: "Sunday"
 

  Constraints:

  The given dates are valid dates between the years 1971 and 2100.
*/

class Solution {
    private int dayOfWeek(int day, int month, int year) {
        int offset = -2;  
        for (int i = 1971; i < year; i++) {
            offset += 365;
            if (i % 4 == 0) offset++;
        }
        for (int i = 1; i < month; i++) {
            if (i < 8) {
                offset += 30 + (i % 2);
                if (i == 2) {
                    offset -= 2;
                    if (year % 4 == 0) offset++;
                }
            } else {
                offset += 30 + ((i + 1) % 2);
            }
        }
        offset+= day - 1;
        
        return offset % 7;
    }
    public String dayOfTheWeek(int day, int month, int year) {
        switch(dayOfWeek(day, month, year)) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
                
        }
        return "";
    }
}
