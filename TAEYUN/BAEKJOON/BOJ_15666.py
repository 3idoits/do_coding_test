# 15666 S2

import sys

input = sys.stdin.readline


N, M = map(int, input().split())

nums = sorted(list(set(sorted(list(map(int, input().split()))))))

def backtracking(tmp):

    if len(tmp) == M:
        print(*tmp)
        return
    

    for i in range(0, len(nums)):
        
        if not tmp:
            tmp.append(nums[i])
            backtracking(tmp)
            tmp.pop()
            continue
        

        if nums[i] >= tmp[-1]:
            tmp.append(nums[i])
            backtracking(tmp)
            tmp.pop()


backtracking([])

