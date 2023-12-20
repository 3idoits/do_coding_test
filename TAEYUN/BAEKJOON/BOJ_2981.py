import math
import sys
from functools import reduce

input = sys.stdin.readline

N = int(input())

nums = sorted([int(input()) for __ in range(N)])

"""
n1 = x1 * M + y
n2 = x2 * M + y
n3 = x3 * M + y
n4 = x4 * M + y

n2 - n1 = (x2 - x1) * M
n3 - n2 = (x3 - x2) * M
n4 - n3 = (x4 - x3) * M

M은 수 차이의 공약수
"""

diffs = []

for i in range(1, len(nums)):
    diffs.append(nums[i] - nums[i - 1])

max_gcd = reduce(lambda prev, cur: math.gcd(prev, cur), diffs)

result = []
for i in range(2, max_gcd + 1):
    if max_gcd % i == 0:
        result.append(i)

print(*result)
