# 4358 S2

import sys
from collections import defaultdict

input = sys.stdin.readline
trees = defaultdict(int)

total = 0

while True:
    tree_name = input().strip()
    if not tree_name:
        break
    trees[tree_name] += 1
    total += 1

for name in sorted(trees.keys()):
    print("%s %.4f" % (name, round(trees[name] / total * 100, 4)))

