import sys

input = sys.stdin.readline

n, m = map(int, input().split())


def get_multiple(start, end):

    result = 1

    for i in range(start, end + 1):
        result *= i

    return result

print(get_multiple(n - m + 1, n) // get_multiple(1, m))
