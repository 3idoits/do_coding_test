#10546

import sys
from collections import defaultdict

input = sys.stdin.readline


N = int(input().strip())

marathon = defaultdict(int)
for __ in range(N):
    marathon[input().strip()] += 1

for __ in range(N - 1):
    marathon[input().strip()] -= 1

for key in marathon.keys():
    if marathon[key] == 1:
        print(key)
