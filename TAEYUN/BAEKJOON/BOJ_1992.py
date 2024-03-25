# S1 1992
import sys

input = sys.stdin.readline

N = int(input().strip())

graph = [list(map(int, list(input().strip()))) for __ in range(N)]



def divide_conquer(x, y, N):

    point = graph[x][y]
    flag = 0

    for i in range(x, x + N):
        for j in range(y, y + N):
            if point != graph[i][j]:
                flag = 1
                break

    if flag == 1:
        print("(", end='')
        N //= 2
        divide_conquer(x, y, N)
        divide_conquer(x, y + N, N)
        divide_conquer(x + N, y, N)
        divide_conquer(x + N, y + N, N)
        print(")", end='')
        return
    
    if point == 1:
        print(1, end='')

    else:
        print(0, end='')
    

divide_conquer(0, 0, N)
