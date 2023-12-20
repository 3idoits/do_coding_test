import sys

nums, formation = input().split()

alpha_dict = {}


for i in range(0, 26):
    alpha_dict[chr(ord('A') + i)] = 10 + i


_sum = 0
for i in range(len(nums)):
    if nums[-1-i].isdigit():
        _sum += int(nums[-1-i]) * (int(formation) ** i)
    else:
        _sum += alpha_dict[nums[-1-i]] * (int(formation) ** i)


print(_sum)
