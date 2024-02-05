import java.util.*;

class Solution {

    public int solution(String[] friends, String[] gifts) {
        int friendCount = friends.length;
        Map<String, Integer> friendIndex = new HashMap<>(friendCount);
        for (int index = 0; index < friendCount; index++) {
            friendIndex.put(friends[index], index);
        }

        int[][] statistics = new int[friendCount][friendCount+1]; // 선물 주고 받기, 지수 통계 테이블
        int giftRate = friendCount; // 선물 지수를 저장할 컬럼의 인덱스
        StringTokenizer tokenizer;
        for (String gift : gifts) {
            tokenizer = new StringTokenizer(gift);
            int giverIndex = friendIndex.get(tokenizer.nextToken());
            int receiverIndex = friendIndex.get(tokenizer.nextToken());

            statistics[giverIndex][receiverIndex] += 1;
            // 선물 지수 계산
            statistics[giverIndex][giftRate] += 1;
            statistics[receiverIndex][giftRate] -= 1;
        }

        // 다음 달에 받을 선물 계산
        int[] giftCount = new int[friendCount];
        for (int giver = 0; giver < friendCount; giver++) {
            for (int receiver = giver+1; receiver < friendCount; receiver++) {
                int giveCount = statistics[giver][receiver];
                int receiveCount = statistics[receiver][giver];

                if (giveCount > receiveCount) giftCount[giver] += 1;
                else if (giveCount < receiveCount) giftCount[receiver] += 1;
                else {
                    int giverRate = statistics[giver][giftRate];
                    int receiverRate = statistics[receiver][giftRate];
                    if (giverRate == receiverRate) continue;
                    
                    if (giverRate > receiverRate) giftCount[giver] += 1;
                    else giftCount[receiver] += 1;
                }
                System.out.println(Arrays.toString(giftCount));
            }
        }

        // 제일 많이 받을 선물 계산
        int maxGift = 0;
        for (int count : giftCount) {
            if (maxGift < count) maxGift = count;
        }
        return maxGift;
    }
}
