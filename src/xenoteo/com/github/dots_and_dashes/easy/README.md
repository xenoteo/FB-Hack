# Problem B1: Dots and Dashes - Easy
*10 points*

## Problem
*Dots and Dashes* is a text encoding, similar to (but not the same as!) other formats used in electric telegraphy. 
Like those [other formats](https://www.wikiwand.com/en/Morse_code?fbclid=IwAR2Gae5IwPFEjTK0Xgx8qhBp1wRfpqmEwhij2B-t6Pts6Sz7OM6HV_voRj0), 
it uses sequences of dots “.” and dashes “-” to encode characters, but unlike those other 
formats, it uses the following translation table:
<pre>
+----------+----------+----------+----------+----------+----------+
| A  .     | B  ...   | C  ..-   | D  .-.   | E  -     | F  .--   |
| G  -..   | H  -.-   | I  ..    | J  --.   | K  ---   | L  ....  | 
| M  ...-  | N  ..-.  | O  .-    | P  ..--  | Q  .-..  | R  .-.-  |
| S  .--.  | T  .---  | U  -.    | V  -...  | W  -..-  | X  -.-.  |
| Y  --    | Z  -.--  | .  ..... | ,  ....- | !  ...-. | ?  ...-- |
| '  ..-.. | "  ..-.- | ;  ..--. | :  ..--- | (  .-... | )  .-..- |
| [  .-.-. | ]  .-.-- | {  .--.. | }  .--.- | 0  --..  | 1  --.-  |
| 2  ---.  | 3  ----  | 4  --... | 5  --..- | 6  --.-. | 7  --.-- |
| 8  ---.. | 9  ---.- | +  ----. | -  ----- | *  -.--. | /  -.--- |
| %  -.-.- |          |          |          |          |          |
+----------+----------+----------+----------+----------+----------+
</pre>

As an optional aid, a copy of the translation table can be found [here](../encoding), 
with each translation on its own line, i.e.
<pre>
A .
B ...
C ..-
etc...
</pre>

Your telegraph machine is connected to a service describing open source projects using 
the *dots and dashes* protocol. Your task is to **decode these descriptions**.

You’ve got a state of the art telegraph machine which can distinguish dots and dashes, as 
well as the gaps between characters and words. It outputs onto a ticker tape; your input
contains *N* messages from it according to the following format:
- Dots are represented by the “.” symbol.
- Dashes are represented by the “-” symbol.
- An individual character is represented by a contiguous sequence of dots and dashes (according to the translation table, above).
- Characters are separated by a single space.
- Words are separated by the “/” symbol, with a space on either side.

## Constraints
1 ≤ *N* ≤ 20

## Input
Your input file starts with a non-negative integer, *N* on the first line, followed by 
*N* lines, each containing the description of an open source project, encoded using 
*dots and dashes*.

## Output
Your output should be a file containing *N* lines, with the *i*th line containing the
decoded version of the *i*th encoded message in the input, **in all-caps**.

## Sample
### Sample Input
<pre>
2
.-- ... / -.- . ..- --- ...-.
.... .. ..-. -. -.-. / --- - .-.- ..-. - .... / ..- .- ..-. .--- .-.- .- .... / -.. .-.- .- -. ..-- .--. .....
</pre>

### Sample Output
<pre>
FB HACK!
LINUX KERNEL CONTROL GROUPS.
</pre>

### Explanation of Sample
The first message consists of two words (separated by a slash), and the encoding of
"!" is appended to the end of the last word.

The second message is an example of a longer message encoded using dots and dashes.

Note how the expected output is in all-caps.