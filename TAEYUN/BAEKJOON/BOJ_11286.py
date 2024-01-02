import heapq
import sys

input = sys.stdin.readline


heap = []

N = int(input().strip())

for __ in range(N):

    num = int(input().strip())

    if num == 0:
        if not heap:
            print(0)

        else:
            _max = heapq.heappop(heap)
            print(_max[1])
    else:
        heapq.heappush(heap, (abs(num), num))
