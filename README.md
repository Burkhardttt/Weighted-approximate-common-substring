# Weighted-approximate-common-substring
Given two input strings, not necessarily of the same length, based on alphanumeric characters [A-Z], determine the best common substring. 
A substring is a contiguous sequence of characters within a string, and the score that determines the best substring is defined as the sum of the weights  w_l  for each character in the sequence (i.e.  w_A is the weight of matching letter A) 
and a penalty − δ for each mismatch (negative penalty term to drive down the score).   
In your experiments, consider situations in which  w_l = 1 and δ = 10 and in which  w_l is proportional to the frequency of the letter 
in English and δ takes values between the smallest and the largest weight (multiple experiments for 10 intermediate values). 
Note: you are now allowed to add gaps in the solution, i.e. both matched substring have the same length. 
Example: inputs "ABCAABCAA" and "ABBCAACCBBBBBB". The substring "CAABC" that starts at position 3 in the first string and position 4 in the second, 
has a score  2 ∗ w_C + 2 ∗ w_A − δ since the B is mismatched in the second string.
