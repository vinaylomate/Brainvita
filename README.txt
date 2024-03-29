#Peg Solitaire (Brainvita)

Peg Solitaire (Brainvita) Game Solver in Java

The goal is to remove all pegs but one by jumping pegs from one side of an occupied peg hole to an empty space, removing the peg which was jumped over.

Used Dynamic Programming and Backtracking for solving this problem and sorted the moves to reduce executing time.

Below is the example of Standard English Board:- 

- - 1 1 1 - -
- - 1 1 1 - -
1 1 1 1 1 1 1
1 1 1 0 1 1 1
1 1 1 1 1 1 1
- - 1 1 1 - -
- - 1 1 1 - -

Output :- 
Visual Representation of steps to Do (from, hole ,to)
Step No. 1
- - 1 1 1 - - 
- - 1 0 1 - - 
1 1 1 0 1 1 1 
1 1 1 1 1 1 1 
1 1 1 1 1 1 1 
- - 1 1 1 - - 
- - 1 1 1 - - 
(11,18,25)
Step No. 2
- - 1 1 1 - - 
- - 1 0 1 - - 
1 0 0 1 1 1 1 
1 1 1 1 1 1 1 
1 1 1 1 1 1 1 
- - 1 1 1 - - 
- - 1 1 1 - - 
(16,17,18)
Step No. 3
- - 0 1 1 - - 
- - 0 0 1 - - 
1 0 1 1 1 1 1 
1 1 1 1 1 1 1 
1 1 1 1 1 1 1 
- - 1 1 1 - - 
- - 1 1 1 - - 
(3,10,17)
Step No. 4
- - 1 0 0 - - 
- - 0 0 1 - - 
1 0 1 1 1 1 1 
1 1 1 1 1 1 1 
1 1 1 1 1 1 1 
- - 1 1 1 - - 
- - 1 1 1 - - 
(5,4,3)
Step No. 5
- - 1 0 0 - - 
- - 0 0 1 - - 
1 1 0 0 1 1 1 
1 1 1 1 1 1 1 
1 1 1 1 1 1 1 
- - 1 1 1 - - 
- - 1 1 1 - - 
(18,17,16)
Step No. 6
- - 1 0 0 - - 
- - 0 0 1 - - 
0 0 1 0 1 1 1 
1 1 1 1 1 1 1 
1 1 1 1 1 1 1 
- - 1 1 1 - - 
- - 1 1 1 - - 
(15,16,17)
Step No. 7
- - 1 0 1 - - 
- - 0 0 0 - - 
0 0 1 0 0 1 1 
1 1 1 1 1 1 1 
1 1 1 1 1 1 1 
- - 1 1 1 - - 
- - 1 1 1 - - 
(19,12,5)
Step No. 8
- - 1 0 1 - - 
- - 0 0 0 - - 
0 0 1 0 1 0 0 
1 1 1 1 1 1 1 
1 1 1 1 1 1 1 
- - 1 1 1 - - 
- - 1 1 1 - - 
(21,20,19)
Step No. 9
- - 1 0 1 - - 
- - 1 0 0 - - 
0 0 0 0 1 0 0 
1 1 0 1 1 1 1 
1 1 1 1 1 1 1 
- - 1 1 1 - - 
- - 1 1 1 - - 
(24,17,10)
Step No. 10
- - 0 0 1 - - 
- - 0 0 0 - - 
0 0 1 0 1 0 0 
1 1 0 1 1 1 1 
1 1 1 1 1 1 1 
- - 1 1 1 - - 
- - 1 1 1 - - 
(3,10,17)
Step No. 11
- - 0 0 1 - - 
- - 0 0 0 - - 
0 0 1 0 1 0 0 
0 0 1 1 1 1 1 
1 1 1 1 1 1 1 
- - 1 1 1 - - 
- - 1 1 1 - - 
(22,23,24)
Step No. 12
- - 0 0 1 - - 
- - 1 0 0 - - 
0 0 0 0 1 0 0 
0 0 0 1 1 1 1 
1 1 1 1 1 1 1 
- - 1 1 1 - - 
- - 1 1 1 - - 
(24,17,10)
Step No. 13
- - 0 0 1 - - 
- - 1 0 1 - - 
0 0 0 0 0 0 0 
0 0 0 1 0 1 1 
1 1 1 1 1 1 1 
- - 1 1 1 - - 
- - 1 1 1 - - 
(26,19,12)
Step No. 14
- - 0 0 0 - - 
- - 1 0 0 - - 
0 0 0 0 1 0 0 
0 0 0 1 0 1 1 
1 1 1 1 1 1 1 
- - 1 1 1 - - 
- - 1 1 1 - - 
(5,12,19)
Step No. 15
- - 0 0 0 - - 
- - 1 0 0 - - 
0 0 0 0 1 0 0 
0 0 0 1 1 0 0 
1 1 1 1 1 1 1 
- - 1 1 1 - - 
- - 1 1 1 - - 
(28,27,26)
Step No. 16
- - 0 0 0 - - 
- - 1 0 1 - - 
0 0 0 0 0 0 0 
0 0 0 1 0 0 0 
1 1 1 1 1 1 1 
- - 1 1 1 - - 
- - 1 1 1 - - 
(26,19,12)
Step No. 17
- - 0 0 0 - - 
- - 1 0 1 - - 
0 0 0 0 0 0 0 
0 0 1 1 0 0 0 
1 1 0 1 1 1 1 
- - 0 1 1 - - 
- - 1 1 1 - - 
(38,31,24)
Step No. 18
- - 0 0 0 - - 
- - 1 0 1 - - 
0 0 0 0 0 0 0 
0 0 1 1 0 0 0 
0 0 1 1 1 1 1 
- - 0 1 1 - - 
- - 1 1 1 - - 
(29,30,31)
Step No. 19
- - 0 0 0 - - 
- - 1 0 1 - - 
0 0 1 0 0 0 0 
0 0 0 1 0 0 0 
0 0 0 1 1 1 1 
- - 0 1 1 - - 
- - 1 1 1 - - 
(31,24,17)
Step No. 20
- - 0 0 0 - - 
- - 0 0 1 - - 
0 0 0 0 0 0 0 
0 0 1 1 0 0 0 
0 0 0 1 1 1 1 
- - 0 1 1 - - 
- - 1 1 1 - - 
(10,17,24)
Step No. 21
- - 0 0 0 - - 
- - 0 0 1 - - 
0 0 0 0 0 0 0 
0 0 0 0 1 0 0 
0 0 0 1 1 1 1 
- - 0 1 1 - - 
- - 1 1 1 - - 
(24,25,26)
Step No. 22
- - 0 0 0 - - 
- - 0 0 1 - - 
0 0 0 0 1 0 0 
0 0 0 0 0 0 0 
0 0 0 1 0 1 1 
- - 0 1 1 - - 
- - 1 1 1 - - 
(33,26,19)
Step No. 23
- - 0 0 0 - - 
- - 0 0 0 - - 
0 0 0 0 0 0 0 
0 0 0 0 1 0 0 
0 0 0 1 0 1 1 
- - 0 1 1 - - 
- - 1 1 1 - - 
(12,19,26)
Step No. 24
- - 0 0 0 - - 
- - 0 0 0 - - 
0 0 0 0 0 0 0 
0 0 0 0 1 0 0 
0 0 0 1 1 0 0 
- - 0 1 1 - - 
- - 1 1 1 - - 
(35,34,33)
Step No. 25
- - 0 0 0 - - 
- - 0 0 0 - - 
0 0 0 0 0 0 0 
0 0 0 0 1 0 0 
0 0 0 0 0 1 0 
- - 0 1 1 - - 
- - 1 1 1 - - 
(32,33,34)
Step No. 26
- - 0 0 0 - - 
- - 0 0 0 - - 
0 0 0 0 0 0 0 
0 0 0 0 1 0 0 
0 0 0 0 1 1 0 
- - 0 1 0 - - 
- - 1 1 0 - - 
(47,40,33)
Step No. 27
- - 0 0 0 - - 
- - 0 0 0 - - 
0 0 0 0 0 0 0 
0 0 0 0 0 0 0 
0 0 0 0 0 1 0 
- - 0 1 1 - - 
- - 1 1 0 - - 
(26,33,40)
Step No. 28
- - 0 0 0 - - 
- - 0 0 0 - - 
0 0 0 0 0 0 0 
0 0 0 0 0 0 0 
0 0 0 0 0 1 0 
- - 0 1 1 - - 
- - 0 0 1 - - 
(45,46,47)
Step No. 29
- - 0 0 0 - - 
- - 0 0 0 - - 
0 0 0 0 0 0 0 
0 0 0 0 0 0 0 
0 0 0 0 1 1 0 
- - 0 1 0 - - 
- - 0 0 0 - - 
(47,40,33)
Step No. 30
- - 0 0 0 - - 
- - 0 0 0 - - 
0 0 0 0 0 0 0 
0 0 0 0 0 0 0 
0 0 0 1 0 0 0 
- - 0 1 0 - - 
- - 0 0 0 - - 
(34,33,32)
Step No. 31
- - 0 0 0 - - 
- - 0 0 0 - - 
0 0 0 0 0 0 0 
0 0 0 1 0 0 0 
0 0 0 0 0 0 0 
- - 0 0 0 - - 
- - 0 0 0 - - 
(39,32,25)
