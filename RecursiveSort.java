/*
Dhruv K. Saligram
2/15/2020
The purpose of this class/program is to sort a list using the merge sort method
--------------------------------------------------------------------------------
PSUEDOCODE FOR MAIN METHOD:
--------------------------------------------------------------------------------
user inputs values
receive values into arraylist<integer> list
print list as unsorted list
convert list to int[] original
pass original to mergeSort method
--------------------------------------------------------------------------------
PSUEDOCODE FOR MERGE SORT METHOD:
--------------------------------------------------------------------------------
receive int[] original
calculate for int lastIndex using original.length - 1
set int firstIndex = 0
create int[] temporary = new int[original.length]
pass original int[], firstIndex, lastIndex, and temporary int[] to mergeSortDivide
--------------------------------------------------------------------------------
PSUEDOCODE FOR MERGE SORT DIVIDE METHOD:
--------------------------------------------------------------------------------
receive original int[], firstIndex, lastIndex, and temporary int[]
if firstIndex < lastIndex
    int middle = (firstIndex+lastIndex)/2
    use recursion to call method again
    pass original int[], firstIndex, middle, and temporary int[] to mergeSortDivide
    use recursion to call method again
    pass original int[], middle+1, lastIndex, and temporary int[] to mergeSortDivide
    pass original int[], firstIndex, middle, lastIndex, and temporary int[] to mergeLists
end if statement
--------------------------------------------------------------------------------
PSUEDOCODE FOR MERGE LISTS METHOD:
--------------------------------------------------------------------------------
receive original int[], firstIndex, middle, lastIndex, and temporary int[]
int left = firstIndex
int right = middle+1
int temporaryIndex = firstIndex
while left <= middle and right <= lastIndex
    if original[left] < original[right]
        temporary[temporaryIndex] = original[left]
        left = left + 1
    else
        temporary[temporaryIndex] = original[right]
        right = right + 1
    end if else chain
    temporaryIndex = temporaryIndex + 1
end while
while left <= middle
    temporary[temporaryIndex] = original[left]
    left = left + 1
    temporaryIndex = temporaryIndex + 1
end while
while right <= lastIndex
    temporary[temporaryIndex] = original[right]
    right = right + 1
    temporaryIndex = temporaryIndex + 1
end while
for int x from firstIndex to lastIndex, increasing by 1 each iteration
    original[x] = temporary[x]
end for
--------------------------------------------------------------------------------
*/
//Package below:
package mergesort;
//Imports below:
import java.util.ArrayList;
import java.util.Scanner;
//Creating class below:
public class RecursiveSort {
    //Creating mergeSort method below:
    public void mergeSort(int[] numberList) {
        //Defining first index for all arrays below:
        final int FIRST_INDEX = 0;
        int lengthOfList = numberList.length;
        //Creating temporary array for sorting below:
        int[] temporaryList = new int[lengthOfList];
        int lastIndex = lengthOfList - 1;
//        System.out.println("BEGIN");
        //Passing values to mergeSortDivide below:
        mergeSortDivide(numberList, FIRST_INDEX, lastIndex, temporaryList);
    }
    //Creating mergeSortDivide method below:
    public void mergeSortDivide(int[] numberList, int firstIndex, int lastIndex, int[] temporaryList) {
//        System.out.println("START OF PROCESS");
//        System.out.println("-------------");
        //Checking if passed indexes are equal or overlapping below:
        if (firstIndex < lastIndex) {
//            System.out.println("-");
//            System.out.println("BOUNDARIES NOT OVERLAPPING");
            //Finding the middle index below:
            int leftMiddleIndex = (firstIndex + lastIndex) / 2;
//            System.out.println("MIDDLE = " + leftMiddleIndex);
            int rightMiddleIndex = leftMiddleIndex + 1;
            //Sorting the left half of the list below:
            mergeSortDivide(numberList, firstIndex, leftMiddleIndex, temporaryList);
//            System.out.println("FIRST RECURSIVE CALL COMPLETE");
            //Sorting the right half of the list below:
            mergeSortDivide(numberList, rightMiddleIndex, lastIndex, temporaryList);
//            System.out.println("SECOND RECURSIVE CALL COMPLETE");
            //Merging the two sides together below:
            mergeLists(numberList, firstIndex, leftMiddleIndex, rightMiddleIndex, lastIndex, temporaryList);
//            System.out.println("LIST UPDATED");
//            System.out.println("-");
        }
//        System.out.println("FINAL STEP");
//        System.out.println("-------------");
//        System.out.println("DONE");
    }
    //Creating mergeLists method below:
    public void mergeLists(int[] numberList, int firstIndex, int leftMiddleIndex, int rightMiddleIndex, int lastIndex, int[] temporaryList) {
        //Defining indexes below:
        int frontOfLeftSide = firstIndex;
        int frontOfRightSide = rightMiddleIndex;
        int frontOfTemporary = firstIndex;
        //Checking if both the left and ride side still have values below:
        while (frontOfLeftSide <= leftMiddleIndex && frontOfRightSide <= lastIndex) {
//            System.out.println("BOTH SIDES HAVE VALUES");
            //Checking if left value is less than right value below:
            if (numberList[frontOfLeftSide] < numberList[frontOfRightSide]) {
//                System.out.println("LEFT < RIGHT");
                //Storing front value of left side in the temporary list below:
                temporaryList[frontOfTemporary] = numberList[frontOfLeftSide];
//                System.out.println("temporaryList[" + frontOfTemporary + "] = " + temporaryList[frontOfTemporary]);
                //Moving the index of the left side up by one below:
                frontOfLeftSide++;
            //Checking if right value is less than left value below:
            } else {
//                System.out.println("LEFT > RIGHT");
                //Storing front value of right side in the temporary list below:
                temporaryList[frontOfTemporary] = numberList[frontOfRightSide];
//                System.out.println("temporaryList[" + frontOfTemporary + "] = " + temporaryList[frontOfTemporary]);
                //Moving the index of the right side up by one below:
                frontOfRightSide++;
            }
            //Moving the index of the temporary list up by one below:
            frontOfTemporary++;
        }
        //Checking if left side of list still has values in it below:
        while (frontOfLeftSide <= leftMiddleIndex) {
//            System.out.println("LEFT SIDE STILL HAS VALUES");
            //Storing next value in left side of list in temporary list below:
            temporaryList[frontOfTemporary] = numberList[frontOfLeftSide];
//            System.out.println("temporaryList[" + frontOfTemporary + "] = " + temporaryList[frontOfTemporary]);
            //Moving the index of the temporary list up by one below:
            frontOfTemporary++;
            //Moving the index of the left side up by one below:
            frontOfLeftSide++;
        }
        //Checking if right side of list still has values in it below:
        while (frontOfRightSide <= lastIndex) {
//            System.out.println("RIGHT SIDE STILL HAS VALUES");
            //Storing next value in right side of list in temporary list below:
            temporaryList[frontOfTemporary] = numberList[frontOfRightSide];
//            System.out.println("temporaryList[" + frontOfTemporary + "] = " + temporaryList[frontOfTemporary]);
            //Moving the index of the temporary list up by one below:
            frontOfTemporary++;
            //Moving the index of the right side up by one below:
            frontOfRightSide++;
        }
//        System.out.println("UPDATED NUMBERS:");
        //Transferring all values in the temporary list over to the original list below:
        for (int i = firstIndex; i <= lastIndex; i++) {
            numberList[i] = temporaryList[i];
//            System.out.println(numberList[i]);
        }
    }
    //Creating arrayListToArray method below:
    public int[] arrayListToArray(ArrayList<Integer> arrayList) {
        //Converting arraylist to array below:
        int[] array = new int[arrayList.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayList.get(i);
        }
        return array;
    }
    //Creating main method below:
    public static void main(String[] args) {
        //Creating object of class below:
        RecursiveSort sorter = new RecursiveSort();
        //Creaing new scanner below:
        Scanner reader = new Scanner(System.in);
        //Defining first index for all arrays below:
        final int FIRST_INDEX = 0;
        //Creating new arraylist below:
        ArrayList<Integer> dynamicList = new ArrayList<>();
        //Prompting user for numbers below:
        System.out.println("Please enter an integer for the list. Enter 0 to exit:");
        //Receiving user input as integer below:
        int numberForList = reader.nextInt();
        //Checking if user has asked to exit below:
        while (numberForList != 0) {
            //Adding number to arraylist if user wishes to continue below:
            dynamicList.add(numberForList);
            //Prompting user for numbers below:
            System.out.println("Please enter an integer for the list. Enter 0 to exit:");
            //Receiving user input as integer below:
            numberForList = reader.nextInt();
        }
        //Receiving size of list inputted by user below:
        int lengthOfList = dynamicList.size();
        //Determining final index of total list below:
        int lastIndex = lengthOfList - 1;
        //Printing user's inputted list below:
        System.out.println();
        System.out.println("ENTERED LIST:");
        //Running for loop from first index to last index below:
        for (int i = FIRST_INDEX; i < dynamicList.size(); i++) {
            //Checking if loop has reached the final index below:
            if (i == lastIndex) {
                //Printing value below:
                System.out.println(dynamicList.get(i));
            } else {
                //Printing value below:
                System.out.print(dynamicList.get(i));
                System.out.print(", ");
            }
        }
        //Converting arraylist to array below:
        int[] list = sorter.arrayListToArray(dynamicList);
        //Sorting array below:
        sorter.mergeSort(list);
        //Printing sorted list below:
        System.out.println();
        System.out.println("SORTED LIST:");
        //Running for loop from first index to last index below:
        for (int i = FIRST_INDEX; i < lengthOfList; i++) {
            //Checking if loop has reached the final index below:
            if (i == lastIndex) {
                //Printing value below:
                System.out.println(list[i]);
            } else {
                //Printing value below:
                System.out.print(list[i]);
                System.out.print(", ");
            }
        }
    }
}