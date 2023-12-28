import sys

input = sys.stdin.readline

N, M = map(int, input().split())
pokemon = [input().strip() for __ in range(N)]

for __ in range(M):
    prob = input().rstrip()

    if prob.isdigit():
        print(pokemon[int(prob) - 1])
    else:
        print(pokemon.index(prob) + 1)
