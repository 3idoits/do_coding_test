import sys
from functools import reduce

input = sys.stdin.readline

N = int(input())
A = reduce(lambda prev, cur: prev * cur, list(map(int, input().split())))

M = int(input())
B = reduce(lambda prev, cur: prev * cur, list(map(int, input().split())))

_max = max(A, B)
_min = min(A, B)

while _max % _min != 0:

    tmp = _min
    _min = _max % _min
    _max = tmp

if len(str(_min)) > 9:
    print(str(_min)[-9:])

else:
    print(_min)
