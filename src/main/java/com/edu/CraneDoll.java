package com.edu;

import java.util.Stack;

public class CraneDoll {

    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int answer = 0;

        for (int i = 0; i < moves.length; i++) {
            for (int k = 0; k < board.length; k++) {
                int movesValue = moves[i];
                if (board[k][movesValue - 1] != 0) {
                    if (stack.peek() == board[k][movesValue - 1]) {
                        stack.pop();
                        answer += 2;
                        board[k][movesValue - 1] = 0;
                        break;
                    }

                    if (stack.peek() != board[k][movesValue - 1]) {
                        stack.push(board[k][movesValue - 1]);
                        board[k][movesValue - 1] = 0;
                        break;
                    }
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0
                , 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        CraneDoll one = new CraneDoll();
        System.out.println(one.solution(board, moves));
    }

}
