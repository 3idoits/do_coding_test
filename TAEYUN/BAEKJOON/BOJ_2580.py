# 2580 G4

import sys

input = sys.stdin.readline


graph = [list(map(int, input().split())) for __ in range(9)]


blank_list = []
for i in range(9):
    for j in range(9):
        if graph[i][j] == 0:
            blank_list.append((i, j))

def backtracking(count):

    if count == len(blank_list):
        for row in graph:
            print(*row)
        exit()
    
    for i in range(1, 10):
        x = blank_list[count][0]
        y = blank_list[count][1]
        if check_3x3(x, y, i) and check_row(x, i) and check_col(y, i):
            graph[x][y] = i
            backtracking(count + 1)
            graph[x][y] = 0


def check_row(idx, n):
    for i in range(9):
        if n == graph[idx][i]:
            return False
        
    return True

def check_col(idx, n):
    for i in range(9):
        if n == graph[i][idx]:
            return False
        
    return True

def check_3x3(x, y, n):
    # x, y가 포함된 정사각형 내부 탐색
    nx = x // 3 * 3
    ny = y // 3 * 3
    for i in range(3):
        for j in range(3):
            if n == graph[nx + i][ny + j]:
                return False
        
            
    return True


backtracking(0)
