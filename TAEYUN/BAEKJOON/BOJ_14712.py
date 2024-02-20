#14712 G5

import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())

graph = [[0] * (M + 1) for __ in range(N + 1)]
answer = 0

def dfs(depth):

    global answer
    
    if depth == N * M:
        answer += 1
        return
    
    x = depth // M + 1
    y = depth % M + 1

    dfs(depth + 1)

    if graph[x - 1][y] == 0 or graph[x - 1][y - 1] == 0 or graph[x][y - 1] == 0:
        graph[x][y] = 1
        dfs(depth + 1)
        graph[x][y] = 0


dfs(0)
print(answer)
