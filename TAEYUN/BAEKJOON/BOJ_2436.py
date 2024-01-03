import math
import sys

input = sys.stdin.readline

_gcd, _lcm = map(int, input().split())

_total = _gcd * _lcm

for i in range(int(_total ** 0.5), 1, -1):
    if _total % i == 0:
        if math.gcd(i, _total // i) == _gcd and _total / _gcd == _lcm:
            if i > _total // i:
                print(_total // i, i)
            else:
                print(i, _total // i)
            break
