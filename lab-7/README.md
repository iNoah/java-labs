# Lab 7

## Purpose
To demonstrate knowledge of JDBC

## Goal
- Building on Lab 5, modify the application to use JDBC
- Load the players from a file to the database
- Only do this if the data has not already been loaded

## Database Class
Responsibilities:
- Loading the JDBC driver
- Establishing the database connection
- Closing the connection

Use the Database class from the examples – it should provide everything you need

Call the shutdown() method before your app exits

## Database Helper Method
```
public static boolean tableExists(String tableName) throws SQLException {
		DatabaseMetaData databaseMetaData = _connection.getMetaData();
		ResultSet resultSet = databaseMetaData.getTables(_connection.getCatalog(), "%", "%", null);
		String name = null;
		while (resultSet.next()) {
			name = resultSet.getString("TABLE_NAME");
			if (name.equalsIgnoreCase(tableName)) {
				return true;
			}
		}
		return false;
	}
```

## PlayerDAO
- Model a PlayerDAO class after the StudentDAO class example
- You MUST add all the create, read, update, delete (CRUD) operations, although you won’t be using all of these methods in the lab 
- Add a List<String> getGamertags() method and use this method to retrieve a list of gamertags
- Also add a Player getPlayer(String gamertag) method to retrieve a single player using their gamertag

## Testing
- For this lab use Derby.
- Create a test method in a PlayerDaoTester class that will retrieve a list of gamertags then retrieve a Player from the DB and print the player

  **See out.log for a sample log output**
- To re-test the creation of the database, simply delete the derby database folder
