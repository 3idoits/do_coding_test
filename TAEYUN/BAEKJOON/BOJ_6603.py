import sys

input = sys.stdin.readline

def get_combinations(idx, inputs, nums):

    if len(nums) == 6:
        print(*nums)
        return
    
    for i in range(idx, len(inputs)):
            if inputs[i] not in nums:
                nums.append(inputs[i])
                get_combinations(i + 1, inputs, nums)
                nums.pop()

while True:
    inputs = list(map(int, input().split()))
    size = inputs[0]

    if size == 0:
        break

    nums = inputs[1:]

    get_combinations(0, nums, [])
    print()
