# 3980 G5

import sys

input = sys.stdin.readline

C = int(input().strip())

def backtracking(idx, nums, visited):

    global result

    if len(nums) == 11:
        result = max(sum(nums), result)
        return

    for i in range(11):
        if visited[i] == False and graph[idx][i] != 0:
            visited[i] = True
            nums.append(graph[idx][i])
            backtracking(idx + 1, nums, visited)
            nums.pop()
            visited[i] = False


for _ in range(C):
    graph = [list(map(int, input().split())) for __ in range(11)]

    visited = [False] * 11
    result = 0
    """
    col 보면서 가장 큰거 선택
    해당 row에서는 더이상 다른거 선택 불가
    """
    backtracking(0, [], visited)
    print(result)
