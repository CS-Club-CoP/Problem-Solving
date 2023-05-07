// 5.1~5.7 백준1991번 트리순회 기본문제

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);
        
        // 입력 갑 저장 변수
        int n = sc.nextInt();             // 노드 개수
        char[][] input = new char[n][3];  // 부모, 자식 노드 값 저장 임시변수
      
        Node[] nodes = new Node[n];
        
		

		
        // 트리의 모든 노드값 배열에 저장. (각각라인 맨 앞문자가 부모노드이므로 맨 앞 문자만 배열에 저장)
        for (int i = 0; i < n; i++) {
            if (sc.hasNext()) {
                
                sc.nextLine();
                char nodeData = sc.next().charAt(0);
                char leftChildNodeData = sc.next().charAt(0);
                char RightChildNodeData = sc.next().charAt(0);
				
				input[i][0] = nodeData;
                input[i][1] = leftChildNodeData;
                input[i][2] = RightChildNodeData;
                
                // 노드 값
                nodes[i] = new Node(nodeData);
            }
        }
        
        for (int i = 0; i < n; i++) {	
            for (int j = 0; j < n; j++) {
                // 왼쪽 자식 노드
                if (nodes[j].data == input[i][1]) {
                    nodes[i].setLeftChildNode(nodes[j]);                  
                }

                // 오른쪽 자식 노드
                if (nodes[j].data == input[i][2]) {
                    nodes[i].setRightChildNode(nodes[j]);
                }                      
            }
        } 
        
        
        
		
		
		// System.out.println(nodes[0].data);
		// System.out.println(nodes[0].leftChildNode);
		// System.out.println(nodes[0].rightChildNode);
		
		preorder(nodes[0]);
		System.out.println();
        
		inorder(nodes[0]);
		System.out.println();
        
		postorder(nodes[0]);
		// System.out.println();
		// System.out.println("종료점");
        
        

        
    }
    
    // 추후 수정
    static class Node {
        char data;
        Node leftChildNode;
        Node rightChildNode;
        
        public Node(char data) {
            this.data = data;
        }
        
        void setLeftChildNode(Node node) {
            this.leftChildNode = node;
        }
        
        void setRightChildNode(Node node) {
            this.rightChildNode = node;
        }
        
        
    }
    
    static void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data);
            preorder(node.leftChildNode);
            preorder(node.rightChildNode);
        } else return;
    }
    
    static void inorder(Node node) {
        if (node != null) {
            inorder(node.leftChildNode);
            System.out.print(node.data);
            inorder(node.rightChildNode);
        } else return;
    }
    
    static void postorder(Node node) {
        if (node != null) {
            postorder(node.leftChildNode);
            postorder(node.rightChildNode);
            System.out.print(node.data);
        } else return;
    }
}
