# Problem F1: Auto-correct - Easy
*5 points*

## Problem
Spelling is hard and spelling on a keyboard is even harder - this is what you realized after
your best friend Alex gave you their latest school essay to proof-read. Luckily you’re a 
good friend, and what you decided to return was not only a print-out of Alex’s essay, all 
in red,  but also a script autocorrecting text automatically (you really are a good friend).

This challenge will take you through the process of designing a simple autocorrection 
system. Apart from the input, each variant of the problem will require additional textual 
resources - all the variants will need to use a *dictionary* and in case of the hard 
variant you will also need to use a *confusion matrix*. Download instructions and format 
details of those can be found at the end in the *Extra resources* section.

The first step in your autocorrection script involves identifying potential misspellings. 
Use the provided dictionary to decide if a word is spelled correctly.

## Input Format
The input will consist of a single, non-negative integer 0 < **N** <= 1000 in the first 
line, followed by **N** lines, each consisting of a single word of length <= 50 characters.
Words contain only lowercase letters from *a* to *z*.

## Output Format
For each word in the input, print a single output line saying `IN` if the corresponding 
input word exists in the dictionary or `OUT` if it doesn’t.

## Sample
### Sample Input
<pre>
2
hello
wotld
</pre>

### Sample Output
<pre>
IN
OUT
</pre>

## Extra resources
### Dictionary
You can download the dictionary following [this link](https://www.dropbox.com/s/tg7vizspnwtewli/dictionary.tsv?dl=0&fbclid=IwAR0tPLOXlWc0N8QBhDRYX718wIvS6sU-1nR15TkxiV8eTjk2vGp2DLJ4Znk) 
(you can also find it [here](dict.txt)). The dictionary was created by taking all the 
words in a snapshot of English Wikipedia (modulo some basic filtering), and counting their
occurrences. Each line in the dictionary consists of a unique word (only lowercase letters
between a and z) and a positive integer representing the number of occurrences of the word
in Wikipedia, separated by tab.
