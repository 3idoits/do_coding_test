import math
import sys

input = sys.stdin.readline

"""
N명 찾기
현 위치 S
"""

N, S = map(int, input().split())
positions = list(map(int, input().split()))

print(math.gcd(*list(map(lambda x: abs(x - S), positions))))

