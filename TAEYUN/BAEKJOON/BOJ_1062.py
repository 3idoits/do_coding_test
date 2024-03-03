# 1062 G4

import sys
from collections import defaultdict

input = sys.stdin.readline

N, K = map(int, input().strip().split())

words = [set(list(input().strip())) for __ in range(N)]

max_result = 0

"""
anta tica
a c i n t 기본 5개

r 추가 
anta rc tica
anta car tica
"""

if K < 5:
    print(0)
    exit()

# prob_dict = set(['a', 'c', 'i', 'n', 't'])
prob_dict = defaultdict(int)
prob_dict['a'] = 1
prob_dict['c'] = 1
prob_dict['i'] = 1
prob_dict['n'] = 1
prob_dict['t'] = 1

def backtracking(idx, depth):
    global max_result

    if depth == K:
        _sum = 0
        keys = set(list(filter(lambda x: prob_dict[x] == 1, list(prob_dict.keys()))))
        for word in words:
            if keys.issuperset(word):
                _sum += 1
        max_result = max(max_result, _sum)
        return
    
    for i in range(idx, 26):
        cur_char = chr(ord('a') + i)

        if prob_dict[cur_char] == 0:
            prob_dict[cur_char] = 1
            backtracking(i, depth + 1)
            prob_dict[cur_char] = 0


backtracking(0, 5)
print(max_result)
