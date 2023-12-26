import sys

input = sys.stdin.readline

a, b = map(int, input().split())



def is_palindrome(num):

    str_num = str(num)

    for i in range(len(str_num) // 2):
        if str_num[i] != str_num[- i - 1]:
            return False
        
    return True

def get_prime_list():
    is_prime = [True] * (10_000 + 1)
    is_prime[0] = False
    is_prime[1] = False

    result = []

    for i in range(2, 10_000 + 1):
        if is_prime[i]:
            for j in range(i * 2, 10_000 + 1, i):
                is_prime[j] = False

    for i in range(2, 10_000 + 1):
        if is_prime[i]:
            result.append(i)
    
    return result

is_prime = get_prime_list()
for i in range(a, b + 1): 
    if is_palindrome(i):
        for j in range(len(is_prime)):
            if i != is_prime[j] and i % is_prime[j] == 0:
                break
        else:
            print(i)
print(-1)
