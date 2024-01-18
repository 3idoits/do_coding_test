# 17255 G4

import sys

input = sys.stdin.readline

def dfs(l, r, sen, t, result, num, n):

    if len(sen) == t:
        result.add(sen)
        return
    
    if l > 0:
        dfs(l - 1, r, sen + num[l - 1:r + 1], t, result, num, n)
    if r < n:
        dfs(l, r + 1, sen + num[l:r + 2], t, result, num, n)


num = input().strip()
t = len(num) * (len(num) + 1) // 2

result = set()

for i in range(len(num)):
    dfs(i, i, num[i], t, result, num, len(num))

print(len(result))
