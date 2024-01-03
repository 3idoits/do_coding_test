import sys

input = sys.stdin.readline

"""
- 1부터 N까지 자연수 중 중복 없이 M개를 고른 수열
- 수열은 오름차순
"""

N, M = map(int, input().split())

nums = [i for i in range(1, N + 1)]

def print_sequence(idx, nums, tmp, size):

    if len(tmp) == size:
        print(*tmp)
        return
    
    for i in range(idx, len(nums)):
        if nums[i] not in tmp:
            tmp.append(nums[i])
            print_sequence(i + 1, nums, tmp, size)
            tmp.pop()


print_sequence(0, nums, [], M)
