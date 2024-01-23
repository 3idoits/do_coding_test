#15654 S3

import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())

nums = sorted(list(map(int, input().split())))

def backtracking(tmp):
    if len(tmp) == M:
        print(*tmp)
        return
    
    for i in range(0, N):
        if nums[i] not in tmp:
            tmp.append(nums[i])
            backtracking(i, tmp)
            tmp.pop()


backtracking([])
