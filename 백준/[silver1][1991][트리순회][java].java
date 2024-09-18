import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    static HashMap<Character, Node> tree = new HashMap<>();

    static class Node {
        char left, right;

        public Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void preorder(char root) {
        if (root == '.') return;
        System.out.print(root);
        preorder(tree.get(root).left);
        preorder(tree.get(root).right);
    }

    public static void inorder(char root) {
        if (root == '.') return;
        inorder(tree.get(root).left);
        System.out.print(root);
        inorder(tree.get(root).right);
    }

    public static void postorder(char root) {
        if (root == '.') return;
        postorder(tree.get(root).left);
        postorder(tree.get(root).right);
        System.out.print(root);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            char root = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);
            tree.put(root, new Node(left, right));
        }

        preorder('A');
        System.out.println();
        inorder('A');
        System.out.println();
        postorder('A');
        System.out.println();
    }
}
