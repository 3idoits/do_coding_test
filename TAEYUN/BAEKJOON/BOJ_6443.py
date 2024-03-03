# 6443 G5

import sys
from collections import defaultdict

input = sys.stdin.readline

N = int(input().strip())

def backtracking(word, alphas):
    
    if len(alphas) == len(word):
        print("".join(alphas))
        return
    
    for alpha in alpha_count:
        if alpha_count[alpha] > 0:
            alpha_count[alpha] -= 1
            alphas.append(alpha)
            backtracking(word, alphas)
            alpha_count[alpha] += 1
            alphas.pop()

for __ in range(N):

    word = sorted(list(input().strip()))

    alpha_count = defaultdict(int)
    
    for alpha in word:
        alpha_count[alpha] += 1
        
    backtracking(word, [])

