FINAL PROJECT DATA STRUCTURES

1) API data is retrieved and parsed into JSonNodes.  These JSonNodes are then parsed into College objects, which
are stored in a HashMap.  Keys for the HashMap are the college name Strings.  Big O complexity for retrieving and 
parsing objects is O(n), where n represents the total number of JSonNodes being retrieved.  For inserting College 
objects into the HashMap, Big O complexity is O(1), per insertion.

2) User profile data is stored in a HashMap of User objects.  The userid string is used as a key for the HashMap.  
As each new user is created, a check is performed to see if that key already has a value mapped to it.  (Big O = O(1)).  If 
there is no value mapped to that key, the profile is created and inserted into the HashMap (O(1)).  A HashMap
was used because the total number of users will be unknown.

3) User login module uses the previously mentioned user hashmap.  The user inputs their userid which is the key to
the HashMap.  Big O for the search is O(1).  The search returns the User object if the entered password matches
the saved password. 

4) The college search autocomplete function uses TextFields class to bind autocomplete to the searchfield.  As the college
objects were being created and stored in their hashmap in module 1, a seperate data structure (HashSet) was created 
consisting of the college name strings.  Big 0 for creation of the set was O(n), where n is the total number of
college names.  Autocomplete uses the College name HashSet as its data structure for autocompleting entries.  Retrieval
from the HashSet is O(1); total Big O for the autocomplete is O(n), where n represents the total number of keys 
returned from the autocomplete.  

5) College search combines the hashset from module 4 with the college HashMap from module 1.  A set of matched keys
is returned from college name HashSet.  Each of these keys is then used to retrieve a college object from the HashMap.
Big O for retrieving keys from the HashSet is O(1) per matched key, so O(n) where n is the total number of matched keys.
Big O for retrieving College items from the HashMap is O(1) for each key.  Total big O is O(n).  

6) College match value is calculated at runtime.  The user SAT scores are compared to the individual college's SAT
percentiles.  (No match value is generated for schools that do not post SAT scores).  If the User's SAT score is higher 
then each respective percentile, a tally is incremented.  User's chances are therefore between 0-4, 0 indicating "Poor"
and 45 indicating "Excellent".  Big O for this operation is O(1) per college.  