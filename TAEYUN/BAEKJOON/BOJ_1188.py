import math
import sys

input = sys.stdin.readline

"""
쏘시지 이어붙이기
M빵침 (인원 수)
서로소일때 인원수 - 1 == gcd(쏘세지, 인원수)만큼 짜름
아닐 때 인원수 - gcd(쏘세지, 인원수)
이어붙인 부분은 자를 필요 없음
"""

N, M = map(int, input().split())

print(M - math.gcd(N, M))
