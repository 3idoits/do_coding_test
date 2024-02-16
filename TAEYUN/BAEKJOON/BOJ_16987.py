# 16987 G5

import sys

input = sys.stdin.readline

N = int(input().strip())

# [내구도, 무게]
eggs = [list(map(int, input().split())) for __ in range(N)]


answer = 0
def backtracking(idx):
    global answer

    # 마지막까지 도착한 경우
    if idx == N:
        broken_eggs = 0
        for i in range(N):
            if eggs[i][0] <= 0:
                broken_eggs += 1

        answer = max(broken_eggs, answer)
        return

    # 현재 들고 있는 계란이 깨진 경우
    if eggs[idx][0] <= 0:
        backtracking(idx + 1)
        return

    # 현재 들고있는 계란을 제외하고 나머지가 모두 깨진 경우
    for i in range(N):
        if i != idx and eggs[i][0] > 0:
            break
    else:
        answer = max(N - 1, answer)
        return 
    
    # 현재 들고있는 계란이거나 치려는 계란이 깨진 경우
    # 계산 후 다음으로 넘어감
    for i in range(N):
        if i == idx or eggs[i][0] <= 0:
            continue

        eggs[idx][0] -= eggs[i][1]
        eggs[i][0] -= eggs[idx][1]
        backtracking(idx + 1)
        eggs[idx][0] += eggs[i][1]
        eggs[i][0] += eggs[idx][1]

backtracking(0)
print(answer)
