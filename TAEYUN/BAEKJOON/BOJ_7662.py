import heapq
import sys

"""
삭제시 연산 명령에 따라
- 우선순위 가장 높은 데이터 삭제
- 또는 가장 낮은 데이터 삭제

데이터 삽입 연산
삭제 연산
- 가장 높
- 가장 낮

최종적으로 저장된 데이터 중 최댓값, 최솟값 출력
I 삽입
D 1 -> 최댓값 삭제
D -1 -> 최솟값 삭제
중복 값 존재시 1개만 삭제
"""
input = sys.stdin.readline

T = int(input().strip())

for _ in range(T):
    N = int(input())
    min_arr = []
    max_arr = []
    inter = dict()
    for i in range(N):
        cmd, num = input().rstrip().split()
        if cmd == "I":
            if int(num) in inter:
                inter[int(num)] += 1
            else:
                inter[int(num)] = 1
            heapq.heappush(min_arr, int(num))
            heapq.heappush(max_arr, -int(num))
        else:
            if num == "1":
                while max_arr and inter[-max_arr[0]] < 1:
                    heapq.heappop(max_arr)

                if not max_arr:
                    continue

                inter[-max_arr[0]] -= 1
            else:
                while min_arr and inter[min_arr[0]] < 1:
                    heapq.heappop(min_arr)

                if not min_arr:
                    continue

                inter[min_arr[0]] -= 1

    result = list(filter(lambda x: inter[x] > 0, inter.keys()))
    if result:
        result.sort()
        print(result[-1], result[0])
    else:
        print("EMPTY")
