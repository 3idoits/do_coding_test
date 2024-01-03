import sys

input = sys.stdin.readline


def is_sang_gen_number(num):

    nums = set()

    tmp = num

    while True:
        _sum = 0
        for i in range(len(str(tmp))):
            _sum += int(str(tmp)[i]) ** 2

        if _sum == 1:
            return True
        
        if _sum in nums:
            return False
        
        nums.add(_sum)

        tmp = _sum

def get_prime_nums(size):
    is_prime = [True] * (size + 1)
    is_prime[0] = False
    is_prime[1] = False
    is_prime[2] = True

    for i in range(2, size + 1):
        if is_prime[i]:
            for j in range(i * 2, size + 1, i):
                is_prime[j] = False

    return is_prime

n = int(input())
is_prime = get_prime_nums(n)

for i in range(2, n + 1):
    if is_prime[i] and is_sang_gen_number(i):
        print(i)
