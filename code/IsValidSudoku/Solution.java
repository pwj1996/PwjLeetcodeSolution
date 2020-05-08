class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        return selfisValidSudoku(board);
    }
    
    private boolean selfisValidSudoku(char[][] board) {
        //
        Set<Character>[] setRow = new HashSet[9];
        Set<Character>[] setCol = new HashSet[9];  
        Set<Character>[] setBox = new HashSet[9];  

        for (int i = 0; i < 9; i++) {
            setRow[i] = new HashSet<>();
            setCol[i] = new HashSet<>();
            setBox[i] = new HashSet<>();
            
        }
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                char tempChar = board[row][col];

                //进行判断
                if (tempChar != '.') {
                    int box_index = (row / 3 ) * 3 + col / 3;
                    
                    //对于row
                    if (setRow[row].contains(tempChar)) {
                        //System.out.println(row + " " + col + tempChar);
                        return false;
                    } else {
                        setRow[row].add(tempChar);
                    }
                    //对于col
                    if (setCol[col].contains(tempChar)) {
                        //System.out.println(row + " " + col + tempChar);
                        return false;
                    } else {
                        setCol[col].add(tempChar);
                    }
                    //对于row
                    if (setBox[box_index].contains(tempChar)) {
                        //System.out.println(row + " " + col + tempChar);
                        return false;
                    } else {
                        setBox[box_index].add(tempChar);
                    }
                }
            }
        }

        return true;
    }
}
