# 1799 G1

import sys

input = sys.stdin.readline

N = int(input().strip())

"""
1은 놓을 수 있는 곳
0은 놓을 수 없는 곳
"""

chess_board = [list(map(int, input().strip().split())) for __ in range(N)]

white_board = [[0] * N for __ in range(N)]
black_board = [[0] * N for __ in range(N)]

result = 0
coords = []

for i in range(N):
    for j in range(N):
        if chess_board[i][j] == 1:
            if i % 2 == 0 and j % 2 == 0:
                white_board[i][j] = 1
            
            if i % 2 == 1 and j % 2 == 1:
                white_board[i][j] = 1

            if i % 2 == 0 and j % 2 == 1:
                black_board[i][j] = 1

            if i % 2 == 1 and j % 2 == 0:
                black_board[i][j] = 1

def backtracking(x, y, coords, board):
    
    global result
    if y == N:
        x += 1
        y = 0

    if x == N and y == 0:
        result = max(result, len(coords))
        return
    
    if board[x][y] == 0:
        backtracking(x, y + 1, coords, board)
        return
    
    if (x, y) not in coords:
        for px, py in coords:
            if abs(x - px) == abs(y - py):
                break

        else:
            coords.append((x, y))
            backtracking(x, y + 1, coords, board)
            coords.pop()

        backtracking(x, y + 1, coords, board)

answer = 0
backtracking(0, 0, [], white_board)
answer += result
result = 0
backtracking(0, 0, [], black_board)
answer += result
print(answer)
