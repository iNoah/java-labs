# Lab 8
- Using two threads recreate the famous race between the tortoise and the hare
- Your solution will create a tortoise Thread and an hare Thread, which will accumulate randomly generated values from 1 to 5.
- The first thread to reach or surpass 100 will win the race.

## Sample output…
```
Tortoise: 2, Hare: 6
…
Tortoise: 17, Hare: 20
…
Tortoise: 42, Hare: 44
…
Tortoise: 61, Hare: 62
…
Tortoise: 87, Hare: 82
…
Tortoise: 102, Hare: 90
Tortoise WINS!!!
```

## Features
- The solution must use two threads which share a single run() method.
- Output will be to the console
- Each thread will sleep for a short time in order for the program to operate at a moderate pace. I suggest you sleep for at 200 milliseconds after each move.
- Consider using booleans to help control Threads.

