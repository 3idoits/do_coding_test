#18430 G4
import sys

input = sys.stdin.readline

N, M = map(int, input().split())

graph = [list(map(int, input().split())) for __ in range(N)]

result = 0

visited = [[False] * M for __ in range(N)]

def backtracking(x, y, _sum):

    global result

    if y == M:
        y = 0
        x += 1

    if x == N:
        result = max(result, _sum)
        return
    
    
    
    if not visited[x][y]:
        # x, y(중심)가 좌상
        if x + 1 < N and y + 1 < M and not visited[x + 1][y] and not visited[x][y + 1]:
            visited[x][y] = True
            visited[x + 1][y] = True
            visited[x][y + 1] = True
            _cursum = _sum + 2 * graph[x][y] + graph[x + 1][y] + graph[x][y + 1]
            backtracking(x, y + 1, _cursum)
            visited[x][y] = False
            visited[x + 1][y] = False
            visited[x][y + 1] = False


        # 우상
        if x + 1 < N and y - 1 >= 0 and not visited[x + 1][y] and not visited[x][y - 1]:
            visited[x][y] = True
            visited[x + 1][y] = True
            visited[x][y - 1] = True
            _cursum = _sum + 2 * graph[x][y] + graph[x + 1][y] + graph[x][y - 1]
            backtracking(x, y + 1, _cursum)
            visited[x][y] = False
            visited[x + 1][y] = False
            visited[x][y - 1] = False

        # 좌하
        if x - 1 >= 0 and y + 1 < M and not visited[x - 1][y] and not visited[x][y + 1]:
            visited[x][y] = True
            visited[x - 1][y] = True
            visited[x][y + 1] = True
            _cursum = _sum + 2 * graph[x][y] + graph[x - 1][y] + graph[x][y + 1]
            backtracking(x, y + 1, _cursum)
            visited[x][y] = False
            visited[x - 1][y] = False
            visited[x][y + 1] = False

        # 우하
        if x - 1 >= 0 and y - 1 >= 0 and not visited[x - 1][y] and not visited[x][y - 1]:
            visited[x][y] = True
            visited[x - 1][y] = True
            visited[x][y - 1] = True
            _cursum = _sum + 2 * graph[x][y] + graph[x - 1][y] + graph[x][y - 1]
            backtracking(x, y + 1, _cursum)
            visited[x][y] = False
            visited[x - 1][y] = False
            visited[x][y - 1] = False
    backtracking(x, y + 1, _sum)


backtracking(0, 0, 0)

print(result)