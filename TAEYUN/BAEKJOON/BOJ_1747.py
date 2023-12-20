import sys

input = sys.stdin.readline


def is_palindrome(num):
    str_num = str(num)

    for i in range(len(str_num) // 2):
        if str_num[i] != str_num[- i - 1]:
            return False
        
    return True

def is_prime(num):

    if num == 1:
        return False

    for i in range(2, int(num ** 0.5) + 1):
        if num % i == 0:
            return False
        
    return True


n = int(input())

while True:

    if is_palindrome(n) and is_prime(n):
        print(n)
        break

    n += 1
