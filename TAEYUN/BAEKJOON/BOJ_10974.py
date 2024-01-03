import sys

input = sys.stdin.readline

N = int(input())

def get_permutations(N, tmp):
    if len(tmp) == N:
        print(*tmp)

    for i in range(1, N + 1):
        if i not in tmp:
            tmp.append(i)
            get_permutations(N, tmp)
            tmp.pop()


get_permutations(N, [])
