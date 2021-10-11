# Problem A3: Keymaster - Hard
*50 points*

## Problem
You’re trying to find where the swag is kept in the Facebook office and, as expected, all the best stuff is hidden in 
hard to reach places.  Fortunately, you manage to make your way to one of the screens on the wall that shows you the 
map of the floor and the location of the most coveted swag (a Wayfinder).  

Since swag is such a valuable commodity at Facebook, a number of doors, *D*, stand between you and your goal. 
Doors are opened using tokens and luckily for you, the map also shows you where they have been left in the office.

Your task is to determine whether it is possible to reach your goal (the swag) by using tokens to open the doors in your 
way, in each of the *N* maps in your input.

After you changed teams again, you’re now on a floor with high security. **Doors need just one token to open them and 
tokens can be used for any door, but they can be used only once**, after which they get invalidated and won’t open any 
other door. Doors in the map are, again, represented by the letter `D`.

Your office consists of a *W* * *H* grid, filled with the following elements:
- Empty space, represented by .
- Walls, represented by `#`.
- Doors, represented by `D`.
- Tokens, represented by `T`.
- Your starting position, represented by `S`.
- Your goal (the swag!), represented by `G`.

You and your colleagues prove too adept at getting to the swag, so its keepers are changing things up again. Doors are 
back to costing one token to unlock, but they consume the token used to open them. As before, tokens are picked up by 
walking into them, and doors are unlocked by walking into them while holding a token. Walking into a door to unlock it
reduces the tokens in your hand by one. There is no cost to moving through an already unlocked door. You can move 
orthogonally (up, down, left or right) but not diagonally, and you can’t walk into walls at any point, or a locked door 
unless you are holding a token to unlock it.

## Constrains
- Each map will contain exactly one starting position and goal
- 0 ≤ *W* ≤ 50
- 0 ≤ *H* ≤ 50
- 0 ≤ *N* ≤ 100
- 0 ≤ *D* ≤ 100 

## Input
Your input file consists of *N*, *W* * *H* maps, separated by blank lines, and encoded using the characters 
described above (`.`, `#`, `D`, `T`, `S`, `G`).

## Output
Your output should be a file containing a single line consisting of *N* characters, separated by spaces:  
*O<sub>0</sub> O<sub>1</sub> ... O<sub>N - 1</sub>*  
where O<sub>i</sub> should be **`P` if it is possible** to reach the swag in the *i*-th map and **`I` otherwise**.

## Sample
### Sample Input
```
..........
.....G....
..........
..........
####D#####
.T........
####D#####
..........
....S.....
.........T

.G....#...
......#...
###D###...
......#T..
......#...
......D...
####D#####
..........
....S..T..
..........

...#......
...#......
...D......
#D##.##D##
G..#.#.T..
...#.#..T.
####D#####
T.#.......
..D.S...T.
T.#.......

...#......
...#......
...D......
#D##.##D##
G..#.#.T..
...#.#....
####D#####
T.#.......
..D.S...T.
T.#.......
```

### Sample Output
```
P I P I
```

### Explanation of Sample
- In the first map, you pick up the token in your starting room, feed it into the first door to gain access to another 
  token, which you feed into the door to the swag, gaining access.
- In the second map, the token in the starting room can be used to open the first door, but you are unable to make
  further progress, because you used your only token opening the first door, and are not able to reach any more to open
  further doors.
- In the third map, you start by picking up the token in the room you start in, and use it to unlock the door to the 
  west. Although you spend the token to unlock the door, you are able to pick up a further two tokens from the room 
  behind it. You move back to your starting room and use one token to open the door to the north, walk up the hallway,
  and open the door to the east with your one remaining token. You gain another two tokens in that room, which is enough
  to open the only two remaining locked doors in the map, to access the swag. 
- The last map is similar to the third.  The only difference is that the second room containing two tokens now contains only two, so while it is possible  to reach the north-westerly room, you cannot unlock the final door to reach the swag.