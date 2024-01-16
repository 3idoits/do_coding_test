import sys
from collections import defaultdict

N = int(input().strip())
count = defaultdict(int)

for __ in range(N):
    count[input()] += 1

for key in sorted(count.keys()):
    if count[key] == max(count.values()):
        print(key)
        break
