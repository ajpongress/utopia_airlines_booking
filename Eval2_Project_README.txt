README for project Eval2
------------------------

Project notes:

- A semi-populated SQL database is included in Gitlab, called "Eval2 Utopia Database Dump.zip"
- Airports.java has the most complete input and error checking functionality (I wrote this section first)
- Other user front end menus have basic input error checking (ran out of time)
- All implimented back end CRUD operations have associated JUnit tests that successfully run
- All back end CRUD operations are implemented with the exception of "Updating" methods for:

    Flights
    Flight Details
    Bookings
    Employees
    
    ("Updating" front end functionality is also missing for these classes)
    
- Traveler "Updating" methods are implemented on the back end, but not the front end