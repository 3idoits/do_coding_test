import sys

input = sys.stdin.readline

N, M = map(int, input().split())

words = set([input().strip() for __ in range(N)])

count = 0

for __ in range(M):
    word = input().strip()
    if word in words:
        count += 1

print(count)
