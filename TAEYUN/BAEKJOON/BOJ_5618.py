import math
import sys

input = sys.stdin.readline

n = int(input())

nums = list(map(int, input().split()))

_max_gcd = math.gcd(*nums)

for i in range(1, _max_gcd + 1):
    if _max_gcd % i == 0:
        print(i)
