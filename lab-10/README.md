# Lab 10
## Purpose
To demonstrate knowledge of Singletons & Model-View-Controller

## Singleton
- Convert the Database class to be a Singleton
- Modify the Lab10 class to use the singleton – note you’ve have to figure out how to use the Database class without passing the properties in the constructor
- Do not pass the database instance to the PlayerDao or the MainFrame – those classes can retrieve the singleton database instance themselves

## MVC
- Create a new MainFrame inner class which extends AbstractListModel
- Use an instance of this class to pass to a Jlist
- When the list item  is clicked, the PlayerDialog will be displayed
