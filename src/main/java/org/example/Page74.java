package org.example;

import java.util.*;
import java.io.*;

public class Page74 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int windowSize = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.peekLast().value > now) {
                deque.pollLast();
            }
            deque.addLast(new Node(now, i));
            if (deque.peekFirst().index <= i - windowSize) {
                deque.pollFirst();
            }
            sb.append(deque.peekFirst().value).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static class Node {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
