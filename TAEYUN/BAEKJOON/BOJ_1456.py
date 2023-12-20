import sys

input = sys.stdin.readline

A, B = map(int, input().split())

def get_primes(size):
    is_prime = [True] * (int(size ** 0.5) + 1)
    is_prime[0] = False
    is_prime[1] = False
    is_prime[2] = True
    
    for i in range(2, int(size ** 0.5) + 1):
        if is_prime[i] == True:
            for j in range(i * 2, int(size ** 0.5) + 1, i):
                is_prime[j] = False


    return is_prime

is_prime = get_primes(B)

_sum = 0
for i in range(2, len(is_prime)):
    if is_prime[i]:
        tmp = i ** 2

        while True:
            if tmp < A:
                tmp *= i
                continue

            if tmp > B:
                break

            tmp *= i
            _sum += 1

print(_sum)
