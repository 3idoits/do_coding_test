#9375

import sys
from collections import Counter

input = sys.stdin.readline

T = int(input().strip())

for _ in range(T):
    N = int(input().strip())

    cloths = []
    for __ in range(N):
        name, type = input().strip().split()

        cloths.append(type)
    
    cloths_cnt = Counter(cloths)
    total = 1

    for key in cloths_cnt.keys():
        total *= cloths_cnt[key] + 1

    print(total - 1)
