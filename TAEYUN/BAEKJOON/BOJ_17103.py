import sys

input = sys.stdin.readline

T = int(input())

"""
0.5s 512MB
"""

def get_prime_numbers(size):

    is_prime = [True] * (size + 1)
    is_prime[0] = False
    is_prime[1] = False

    for i in range(2, size + 1):
        if is_prime[i] == True:
            for j in range(i * 2, size + 1, i):
                is_prime[j] = False

    return is_prime


is_prime = get_prime_numbers(1_000_000)

for __ in range(T):
    num = int(input())

    _sum = 0

    for i in range(2, num // 2 + 1):
        if is_prime[i] and is_prime[num - i]:
            _sum += 1

    
    print(_sum)
