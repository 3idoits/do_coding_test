# 15663 S2
import sys

input = sys.stdin.readline

N, M = map(int, input().split())

nums = sorted(list(map(int, input().split())))


visited = [False] * N

def backtracking(tmp):
    if len(tmp) == M:
        print(*tmp)
        return
    
    prev = 0
    for i in range(N):
        if not visited[i] and prev != nums[i]:
            visited[i] = True
            tmp.append(nums[i])
            prev = nums[i]
            backtracking(tmp)
            visited[i] = False
            tmp.pop()

backtracking([])
