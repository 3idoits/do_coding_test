# 15665 S2

import sys

input = sys.stdin.readline

# 같은 수 여러번 고를 수 있음

N, M = map(int, input().split())

nums = sorted(list(set(sorted(list(map(int, input().split()))))))

def backtracking(tmp):

    if len(tmp) == M:
        print(*tmp)
        return
    

    for i in range(0, len(nums)):
        tmp.append(nums[i])
        backtracking(tmp)
        tmp.pop()


backtracking([])

