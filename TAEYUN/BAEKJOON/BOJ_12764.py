#12764 G3

import heapq
import sys

input = sys.stdin.readline

N = int(input().strip())

seat_num = 1
com_heap = []
empty_heap = []
cnt = [0] * (N + 1)
use = [False] * (N + 1)


t = sorted([tuple(map(int, input().split())) for __ in range(N)])


for s, e in t:
    if not com_heap or com_heap[0][0] > s:
        if empty_heap:
            snum = heapq.heappop(empty_heap)
            cnt[snum] += 1
            heapq.heappush(com_heap, (e, snum))
        else:
            cnt[seat_num] += 1
            use[seat_num] = True
            heapq.heappush(com_heap, (e, seat_num))
            seat_num += 1
    else:
        while com_heap and com_heap[0][0] < s:
            snum = heapq.heappop(com_heap)[1]
            heapq.heappush(empty_heap, snum)

        nnum = heapq.heappop(empty_heap)
        cnt[nnum] += 1
        heapq.heappush(com_heap, (e, nnum))


print(use.count(True))

for u in cnt[1:]:
    if u != 0:
        print(u, end=' ')
