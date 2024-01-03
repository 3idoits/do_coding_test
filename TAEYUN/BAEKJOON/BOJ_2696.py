# 2696 G2

import heapq
import sys

input = sys.stdin.readline

T = int(input().strip())

for _ in range(T):
    M = int(input().strip())

    nums = []
    if M <= 10:
        nums = list(map(int, input().strip().split()))

    else:
        for __ in range(M // 10 + 1):
            nums.extend(list(map(int, input().strip().split())))

    heap = []
    left_mid = []
    right_mid = []
    result = []
    tmp = []

    mid = nums[0]
    tmp = [mid]

    for i in range(1, len(nums)):
        if nums[i] > mid:
            heapq.heappush(right_mid, nums[i])
        else:
            heapq.heappush(left_mid, -nums[i])

        if i % 2 == 0:
            if len(left_mid) < len(right_mid):
                heapq.heappush(left_mid, -mid)
                mid = heapq.heappop(right_mid)
            elif len(left_mid) > len(right_mid):
                heapq.heappush(right_mid, mid)
                mid = -heapq.heappop(left_mid)
            
            tmp.append(mid)
            if len(tmp) == 10:
                result.append(tmp)
                tmp = []
    
    if tmp:
        result.append(tmp)

    print(M // 2 + 1)

    for r in result:
        print(*r)


