import heapq
import sys

input = sys.stdin.readline

"""
숫자는 모두 다름

한 칸 위 수보다 크다는 것

N번째 큰 수
"""

N = int(input().strip())
heap = list(map(int, input().strip().split()))
heapq.heapify(heap)

for __ in range(1, N):
    _input = list(map(int, input().strip().split()))

    for num in _input:
        if heap[0] < num:
            heapq.heappop(heap)
            heapq.heappush(heap, num)
        else:
            continue

print(sorted(heap)[0])
