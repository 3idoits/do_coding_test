import math
import sys

input = sys.stdin.readline

x, y = map(int, input().split())

"""
- x == y 같을 때 꼭짓점만 지남
- x != y 가로 + 세로 - 1
- 공약수가 있어서 같은 비율이 반복될 때 가장 작은 비율 지나는 직사각형을 공약수만큼 곱하면 됨
"""

if x == y:
    print(x)

else:
    gcd = math.gcd(x, y)

    if gcd == 1:
        print(x + y - 1)
    else:
        print(gcd * ((x // gcd) + (y // gcd) - 1))


