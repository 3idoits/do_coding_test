# 1174 G5

import sys

input = sys.stdin.readline

"""
0 ~ 9 10
10 1
20 21 2
30 31 32 3
40 41 42 43 4
"""

N = int(input())

arr = []
result = set()

def backtracking():
    if len(arr) > 0:
        result.add(int("".join(map(str, arr))))

    for i in range(10):
        if len(arr) == 0 or arr[-1] > i:
            arr.append(i)
            backtracking()
            arr.pop()

backtracking()
result = sorted(result)
print(result[N - 1] if len(result) >= N else -1)
