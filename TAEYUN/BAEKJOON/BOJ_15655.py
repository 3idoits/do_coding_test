#15655 S3

import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())

nums = sorted(list(map(int, input().split())))

def backtracking(idx, tmp):
    if len(tmp) == M:
        print(*tmp)
        return
    
    for i in range(idx, N):
        if nums[i] not in tmp:
            tmp.append(nums[i])
            backtracking(i + 1, tmp)
            tmp.pop()


backtracking(0, [])
