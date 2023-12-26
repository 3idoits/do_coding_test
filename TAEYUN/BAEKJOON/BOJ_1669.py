import math
import sys

input = sys.stdin.readline

"""
원숭이 키 X, 멍멍이 키 Y
n + 2 * (n - 1) * n // 2
=> n^2
"""

X, Y = map(int, input().split())

if X == Y:
    print(0)

else:
    if math.sqrt(Y - X).is_integer():
        print(int(math.sqrt(Y - X)) * 2 - 1)
    else:
        if Y - X - int(math.sqrt(Y - X)) ** 2 <= int(math.sqrt(Y - X)):
            print(int(math.sqrt(Y - X)) * 2)
        else:
            print(int(math.sqrt(Y - X)) * 2 + 1)

