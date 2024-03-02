# 17136 G2

import sys
from itertools import chain

input = sys.stdin.readline

confettis = [list(map(int, input().split())) for __ in range(10)]

confetti_count = [0] + [5] * 5

result = sys.maxsize

if len(list(filter(lambda x: x == 0, list(chain(*confettis))))) == 100:
    print(0)
    exit()

def check_confettis(x, y, size):

    for i in range(x, x + size):
        if i >= 10:
            return False
        for j in range(y, y + size):
            if j >= 10:
                return False
            
            if confettis[i][j] == 0 or confettis[i][j] == -1:
                return False
    return True

def backtracking(i, j):

    global result 

    if j == 10:
        i += 1
        j = 0

    if i == 10 and j == 0:
        result = min(result, 25 - sum(confetti_count))
        return

    flag = False
    if confettis[i][j] == 1:
        for k in range(5, 0, -1):
            if confetti_count[k] > 0 and check_confettis(i, j, k):
                confetti_count[k] -= 1
                for l in range(i, i + k):
                    for m in range(j, j + k):
                        confettis[l][m] = -1
                backtracking(i, j + 1)
                confetti_count[k] += 1
                for l in range(i, i + k):
                    for m in range(j, j + k):
                        confettis[l][m] = 1
                flag = True
        
        if flag == False:
            return
            
    else:
        backtracking(i, j + 1)

backtracking(0, 0)


if result == sys.maxsize:
    print(-1)
else:
    print(result)
