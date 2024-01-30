#15657 S3

import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())

nums = sorted(list(map(int, input().strip().split())))

def backtracking(tmp, idx):
    if len(tmp) == M:
        print(*tmp)
        return
    
    for i in range(idx, N):
        tmp.append(nums[i])
        backtracking(tmp, i)
        tmp.pop()

backtracking([], 0)
