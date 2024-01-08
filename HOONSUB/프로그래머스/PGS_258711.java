import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        // step 1. 그래프 간선 정보 설정 및 In/Out Count 정보 설정
        Node[] map = new Node[1000001];

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (map[from] == null) map[from] = new Node(from);
            if (map[to] == null) map[to] = new Node(to);
            map[from].outNodes.add(map[to]);
            map[from].outCount++;
            map[to].inCount++;
        }

        // step 2. 생성된 정점 찾기
        Node createdNode = null;
        for (Node node : map) {
            if (node != null && node.inCount == 0 && node.outCount >= 2) {
                answer[0] = node.number;
                createdNode = node;
                break;
            }
        }

        // step 3. 생성된 정점과 연결된 노드들을 제거
        int totalGraphCount = createdNode.outCount;

        for (Node node : createdNode.outNodes) {
            node.inCount--;
        }
        map[createdNode.number] = null;
        
        // step 4. 각 그래프에 맞는 노드를 확인
        for (Node node : map) {
            if (node != null) {
                if (node.outCount == 0) {
                    answer[2]++;
                }
                
                if (node.outCount == 2 && node.inCount == 2) {
                    answer[3]++;
                }
            }
        }

        // step 5. 도넛 그래프 = 전체 그래프 수 - (막대 그래프 + 8자 그래프)
        answer[1] = totalGraphCount - (answer[2] + answer[3]);

        return answer;
    }
}

class Node {
    int number;
    int outCount;
    int inCount;
    List<Node> outNodes;

    public Node(int number) {
        this.number = number;
        this.outNodes = new ArrayList<>();
    }
}
