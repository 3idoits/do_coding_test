import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // step 1. 입력 값 정리
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            meetings[i] = new Meeting(start, end);
        }

        // step 2. Comparable 조건에 맞게 Meeting 정렬
        Arrays.sort(meetings);

        // step 3. 최소 회의실 개수를 선택
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.offer(meetings[0].end);
        for (int i = 1; i < meetings.length; i++) {
            Meeting currentMeeting = meetings[i];

            // 가장 빠른 회의 종료 시간보다 현재 회의의 시작 시간이 뒤쪽에 있으면 이어서 진행할 수 있는 회의
            // 가장 빠른 회의 종료 시간보다도 현재 회의의 시작 시간이 빠르다면 뒤에 있는 종료 시간은 확인해볼 필요도 없기 때문에 가능한 로직
            if (!endTimes.isEmpty() && endTimes.peek() <= currentMeeting.start) {
                endTimes.poll();
            }
            endTimes.offer(currentMeeting.end);
        }
        System.out.println(endTimes.size());
    }
}

class Meeting implements Comparable<Meeting> {
    int start, end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * 회의 시작 시간을 기준으로 오름차순 정렬
     * : 추후 로직에서 종료시간만을 가지고 비교하기 때문에 이전 회의가 현재 회의보다 먼저 시작된 회의임을 확신하기 위함
     */
    @Override
    public int compareTo(Meeting meeting) {
        return this.start - meeting.start;
    }
}
