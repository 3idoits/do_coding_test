#15656 S3

import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())

nums = sorted(list(map(int, input().split())))

def backtracking(tmp):
    if len(tmp) == M:
        print(*tmp)
        return
    
    for i in range(N):
        tmp.append(nums[i])
        backtracking(tmp)
        tmp.pop()


backtracking([])
