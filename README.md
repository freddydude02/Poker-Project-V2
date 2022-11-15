# Poker-Project-V2
A version two of the original poker project. The main difference with this version is the added tests and application of OOP concepts and the file structure of the project.

**MVP:**
create app that takes in a array of ten values representing poker cards and determine
the winner based off the first five values vs the next five <br>
<br>
**Example of values**
<br>
2D -> 2 of Diamond
KS -> King of Spades

**Assumptions**
- their will always be ten values in the given array
- players are seperated based off the first and last five values in the array

**How to Run**
1. Clone the repo
2. Navigate to line sixteen at /pokerprojectv2/src/main/java/io/nology/pokerprojectv2/App.java and edit the file path to match your local directory
   pointing to the file poker-hands.txt
3. Edit the testing doc(poker-hands.txt) with your desired values (pre-existing doc includes 500 tests)
4. Run the app

**Approach**
1. Break the project down into smaller components seperated into Card, Game, hand, suit etc
2. Create tests to ensure code responds appropriately to invalid inputs

**Challenges**
- The most challenging part was developing the logic required to sa

**Future Changes**
- include more tests to deal with tie scores
- further split my hand sorting methods down to which type of hands it sorts e.g. Dupes, Straights, Flush etc.
