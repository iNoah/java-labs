# Lab 5
## Purpose
To demonstrate knowledge of
- File IO
- (log4j) Logging
## File I/O
- Read the items from a file instead of passing them in on the commandline
**the input file must be named players.txt**
- Output the Players Report to a file named players_report.txt

**Note! Your jar file will run with no commandline arguments as it will be using default file names as input**
- log.properties and players.txt 
**Doesn’t run?... Well you know what happens**

## Logging
- Replace any System.out.println statements – except the usage message - with appropriate level logging statements
- Use a PropertyConfigurator to configure log4j logging 
- The property file must be named log.properties
 ## Exceptions
- All exceptions must be logged at error level
- If players.txt doesn’t exist, print an error message to the console and to the log file and exit
- Ensure you are handling any other exceptions
- Make sure you’ve closed any open resources

## Note
The lab input file was edited on a unix-based system which has a different line terminator than windows. If the file is opened in notepad++ it should look 'normal'. Scanner and other file input objects are also able to figure out the line terminator.
