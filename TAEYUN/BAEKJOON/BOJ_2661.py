# 2661 G4

import sys

input = sys.stdin.readline

N = int(input())

result = sys.maxsize

def backtracking(nums):
    global result

    for i in range(1, len(nums) // 2 + 1):
        if nums[-i:] == nums[-2 * i: -i]:
            return


    if len(nums) == N:
        print(int("".join(map(str, nums))))
        exit()
    

    for i in range(1, 4):
        nums.append(i)
        backtracking(nums)
        nums.pop()

backtracking([])
