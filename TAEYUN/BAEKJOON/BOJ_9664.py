# 9664 G4

import sys

input = sys.stdin.readline

N = int(input())

result = 0

rows = [0] * N

def backtracking(x):

    global result

    if x == N:
        result += 1
        return
    
    for i in range(N):
        rows[x] = i
        if isValid(x):
            backtracking(x + 1)

def isValid(x):
    for i in range(x):
        if rows[x] == rows[i] or (abs(rows[x] - rows[i]) == abs(x - i)):
            return False
        
    return True

backtracking(0)
print(result)
