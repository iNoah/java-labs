# Lab 3
## Purpose
- To demonstrate knowledge of
- Annotations
- Exceptions
- Date & time formatting
## Goal
- Extend Lab 2 to make use of date and time processing, annotations and exceptions
## Input
The input data has changed to include a birthdate field:
- Use GregorianCalendar for the field type.
```
"1|Fred|Fish|fredfish@gamer.net|Ithroeann|19770322:2|Laurie|Nash|laurieeenash@gmail.com|Mazzzap|19820828:3|Conrad|Washington|fredfish@gamer.net|Crayonbreath|19720712:4|Jeanette|Price|priceizrite@hotmail.com|Quinesia|20011003:5|Mark|Chan|mchan@1minutemail.com|CastleRock|19950401”
```
- Update Player appropriately
## Annotations
Make use of the following annotations in your solution as appropriate
- @Override
- @Deprecated
- @SuppressWarnings
## Exceptions
- Create a new class, ApplicationException, which subclasses Exception and overrides all the Exception constructors
- If not enough data elements are in one record, then the PlayerReader.Read method will throw an ApplicationException similar to the following:
```
Expected 6 elements but got 5
```
- You must display the number of elements provided - this can’t be hard-coded
- This exception should be thrown by PlayerReader.read(…) and caught and printed by the Lab3 object
- After an exception is thrown, the application will stop
- I’ll only test one missing field
- A source of problems in Lab2 was the email address:
- In this lab, if an invalid email is provided, your program will print
```
a00123456.ApplicationException: ‘mchan’ is an invalid email address
```
- The program will stop after the bad data is encountered
## Date & Time
- When your program starts, print the date and time and also print the date and time and program duration when it ends
- Use the Java 8 java.time classes
- Hint: Look at the Instant class and the java.time examples
- Do NOT use the 'old' Data, GregorianCalendar, or DateFormatter classes
- Your input data now includes the user’s birthdate. Convert the input value to an appropriate java.time class and print the value in the report
## Output
```
2015-09-28T03:21:55.855Z
Players Report
-------------------------------------------------------------------------------------------------------
 # . ID     First name   Last name    Email                    Gamer tag                Birthdate      
-------------------------------------------------------------------------------------------------------
  1. 000001 Fred         Fish         fredfish@gamer.net       Ithroeann                Tue Mar 22 1977
  2. 000002 Laurie       Nash         laurieeenash@gmail.com   Mazzzap                  Sat Aug 28 1982
  3. 000003 Conrad       Washington   fredfish@gamer.net       Crayonbreath             Wed Jul 12 1972
  4. 000004 Jeanette     Price        priceizrite@hotmail.com  Quinesia                 Wed Oct 03 2001
  5. 000005 Mark         Chan         mchan@oneminutemail.com  CastleRock               Sat Apr 01 1995
2015-09-28T03:21:55.937Z
Duration: 82 ms
```