class ArrayOperations {

    int[][] twoDimArray;

    public static void reverseElements(int[][] twoDimArray) {
        for (int[] row : twoDimArray) {
            int first = 0;
            int last = row.length - 1;
            int temp;

            while (first < last) {
                temp = row[first];
                row[first] = row[last];
                row[last] = temp;
                first++;
                last--;
            }
        }

    }

}