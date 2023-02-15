# Lab 2
## Purpose
To demonstrate knowledge of
- Strings
- Simple regular expressions
- Formatting output
- Object design
- Jar Files
## Goal
Create a command line program which reads player data, creates Player objects, adds them to an array, and prints a simple Player report
## Classes
- Lab2
- Player
- PlayerReader
- PlayerReport
- Validator
## Input
One single string:

```
"1|Fred|Fish|fredfish@gamer.net|Ithroeann:2|Laurie|Nash|laurieeenash@gmail.com|Mazzzap:3|Conrad|Washington|fredfish@gamer.net|Crayonbreath:4|Jeanette|Price|priceizrite@hotmail.com|Quinesia:5|Mark|Chan|mchan|CastleRock" 
```
**If an email is not valid, it’s replaced with “N/A”**
## Output
```
Players Report
-----------------------------------------------------------------------------------------------
  #. ID     First name      Last name       Email                          Gamertag
-----------------------------------------------------------------------------------------------
  1. 000001 Fred            Fish            fredfish@gamer.net             Ithroeann           
  2. 000002 Laurie          Nash            laurieeenash@gmail.com         Mazzzap             
  3. 000003 Conrad          Washington      fredfish@gamer.net             Crayonbreath        
  4. 000004 Jeanette        Price           priceizrite@hotmail.com        Quinesia            
  5. 000005 Mark            Chan            N/A                            CastleRock          

```
## Create the jar File
- File > Export > ‘Runnable Jar File’ > Next
- Select Lab2
- Destination is an ‘out’ folder at the same level as your src folder – you’ll need to create it in the save dialog



