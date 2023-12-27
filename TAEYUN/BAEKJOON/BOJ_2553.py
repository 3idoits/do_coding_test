import math
import sys

input = sys.stdin.readline

N = int(input())

result = 1
result = str(math.factorial(N))
for i in range(len(result) - 1, -1, -1):
    if result[i] != '0':
        print(result[i])
        break
