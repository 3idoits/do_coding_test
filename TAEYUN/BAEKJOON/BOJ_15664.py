# 15664 S2
import sys

input = sys.stdin.readline

N, M = map(int, input().split())

nums = sorted(list(map(int, input().split())))


visited = [False] * N

def backtracking(tmp, idx):
    if len(tmp) == M:
        print(*tmp)
        return
    
    prev = 0
    for i in range(idx, N):
        if not visited[i] and prev != nums[i]:
            visited[i] = True
            tmp.append(nums[i])
            prev = nums[i]
            backtracking(tmp, i + 1)
            visited[i] = False
            tmp.pop()

backtracking([], 0)
