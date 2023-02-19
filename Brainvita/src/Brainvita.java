import java.util.*;

class Brainvita {
    class Move implements Comparable<Move> {
        int from;
        int hole;
        int to;
        Move(int from, int hole, int to) {
            this.from = from;
            this.hole = hole;
            this.to = to;
        }
        @Override
        public String toString() {
            return ("(" + (this.from+1) + "," + (this.hole+1) + "," + (this.to+1) + ")");
        }

        @Override
        public int compareTo(Move m) {
            return Integer.valueOf(this.from).compareTo(Integer.valueOf(m.from));
        }
    }
    ArrayList<ArrayList<Integer>> board;
    ArrayList<Move> moves;
    ArrayList<ArrayList<ArrayList<Integer>>> dp;
    ArrayList<ArrayList<ArrayList<Integer>>> ans;

    Brainvita(ArrayList<ArrayList<Integer>> board) {
        this.board = board;
        moves = new ArrayList<>();
        dp = new ArrayList<>();
        ans = new ArrayList<>();
    }

    void printOutput() {
        System.out.println("Visual Representation of steps to Do (from, hole ,to)");
        int i = 0;
        for(Move move : moves) {
            for(int j = 0; j < ans.get(i).size(); j++) {
                for(int k = 0; k < ans.get(i).get(j).size(); k++) {
                    if(ans.get(i).get(j).get(k) == 2) {
                        System.out.print("- ");
                    } else {
                        System.out.print(ans.get(i).get(j).get(k)+" ");
                    }
                }
                System.out.println();
            }
            i++;
            System.out.println(move.toString());
        }
    }

    void makeMove(Move move) {
        board.get(move.from/7).set(move.from%7, 0);
        board.get(move.hole/7).set(move.hole%7, 0);
        board.get(move.to/7).set(move.to%7, 1);
        ans.add(copy(board));
        moves.add(move);
    }

    void undoMove(Move move) {
        board.get(move.from/7).set(move.from%7, 1);
        board.get(move.hole/7).set(move.hole%7, 1);
        board.get(move.to/7).set(move.to%7, 0);
        ans.remove(ans.size()-1);
        moves.remove(moves.size()-1);
    }

    ArrayList<Move> computeAllMoves() {
        ArrayList<Move> possibilities = new ArrayList<>();
        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board.get(i).size(); j++) {
                if(board.get(i).get(j) == 0) {
                    if(i-2 >= 0) {
                        if((board.get(i-2).get(j) == 1) && (board.get(i-1).get(j) == 1)) {
                            possibilities.add(new Move((i-2)*7+j, (i-1)*7+j, i*7+j));
                        }
                    }
                    if(j-2 >= 0) {
                        if((board.get(i).get(j-2) == 1) && (board.get(i).get(j-1) == 1)) {
                            possibilities.add(new Move(i*7+j-2, i*7+j-1, i*7+j));
                        }
                    }
                    if(i+2 < 7) {
                        if((board.get(i+2).get(j) == 1) && (board.get(i+1).get(j) == 1)) {
                            possibilities.add(new Move((i+2)*7+j, (i+1)*7+j, i*7+j));
                        }
                    }
                    if(j+2 < 7) {
                        if((board.get(i).get(j+2) == 1) && (board.get(i).get(j+1) == 1)) {
                            possibilities.add(new Move(i*7+j+2, i*7+j+1, i*7+j));
                        }
                    }
                }
            }
        }
        return possibilities;
    }

    private int getCount() {
        int count = 0;
        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board.get(i).size(); j++) {
                if(board.get(i).get(j) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    ArrayList<ArrayList<Integer>> copy(ArrayList<ArrayList<Integer>> board) {
        ArrayList<ArrayList<Integer>> newBoard = new ArrayList<>();
        for(ArrayList<Integer> line : board) {
            ArrayList<Integer> cpLine = new ArrayList<>();
            for(Integer i : line) {
                cpLine.add(Integer.valueOf(i));
            }
            newBoard.add(cpLine);
        }
        return newBoard;
    }

    boolean solve() {
        if(dp.contains(board)) {
            return false;
        }
        if(getCount() == 1 && board.get(3).get(3) == 1) {
            printOutput();
            return true;
        } else {
            ArrayList<Move> moveList = computeAllMoves();
            Collections.sort(moveList);

            for(Move move : moveList) {
                makeMove(move);
                if(solve()) {
                    return true;
                } else {
                    undoMove(move);
                }
            }
        }
        if(!dp.contains(board)) {
            dp.add(copy(board));
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        Integer[] line1 = {2,2,1,1,1,2,2};
        Integer[] line2 = {2,2,1,1,1,2,2};
        Integer[] line3 = {1,1,1,1,1,1,1};
        Integer[] line4 = {1,1,1,0,1,1,1};
        Integer[] line5 = {1,1,1,1,1,1,1};
        Integer[] line6 = {2,2,1,1,1,2,2};
        Integer[] line7 = {2,2,1,1,1,2,2};

        board.add(new ArrayList<Integer>(Arrays.asList(line1)));
        board.add(new ArrayList<Integer>(Arrays.asList(line2)));
        board.add(new ArrayList<Integer>(Arrays.asList(line3)));
        board.add(new ArrayList<Integer>(Arrays.asList(line4)));
        board.add(new ArrayList<Integer>(Arrays.asList(line5)));
        board.add(new ArrayList<Integer>(Arrays.asList(line6)));
        board.add(new ArrayList<Integer>(Arrays.asList(line7)));

        new Brainvita(board).solve();
    }
}

