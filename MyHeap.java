public class MyHeap{
  //We discussed these 2 methods already:

  /**A method that pushes an element at a given index downward
  *@param int[] data
  *@param int size
  *@param int index
  - size  is the number of elements in the data array.
  - push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided that child is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
  - precondition: index is between 0 and size-1 inclusive
  - precondition: size is between 0 and data.length-1 inclusive.
  */
  private static void pushDown(int[]data, int size, int index){
    boolean done = false;
    while(!done){
      int child1 = index * 2 + 1; //left child
      int child2 = index * 2 + 2; //right child
      if(child1 >= size && child2 >= size) done = true; //if the children do not exist
      if(child1 < size && child2 < size){ //if both children exist
        int larger = Math.max(data[index], data[child1]); //find the largest of the three
        int largest = Math.max(larger, data[child2]);
        if(largest != data[index]){ //if the parent is not the largest
          if(largest == data[child1]){ //swap with the larger one of the two children
            data[child1] = data[index];
            data[index] = largest;
            index = child1; //new index of element
          }else{
            data[child2] = data[index];
            data[index] = largest;
            index = child2; //new index of element
          }
        }else done = true; //if the parent is the largest, function stops
      }else if(child1 < size){ //if only the left child exists
        int larger = Math.max(data[index], data[child1]); //find the larger of the child and parent
        if(larger != data[index]){ //if the parent is not the larger one
          data[child1] = data[index]; //swap with the child
          data[index] = larger;
          index = child1; //new index of element
        }else done = true; //if the parent is larger, function stops;
      }
    }
  }

  /**A method that pushes an element at a given index upward
  *@param int[] data
  *@param int index
  - push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
  - precondition: index is between 0 and data.length-1 inclusive.
  */
  private static void pushUp(int[]data, int index){
    boolean done = false;
    while(!done){
      if(index == 0) done = true; //if index is the root
      else{
        int parent;
        if(index % 2 == 0) parent = (index / 2) - 1; //find the parent, using if the index is odd or even
        else parent = index / 2;
        if(parent >= 0){ //checks if the parent is greater than or equal to zero
          int temp = data[index];
          if(data[index] >= data[parent]){ //swap with the parent if it's smaller or equal
            data[index] = data[parent];
            data[parent] = temp;
            index = parent; //new index of element
          }else done = true; //if parent isn't smaller than the child, the function stops
        }else done = true; //if the parent index isn't greater than or equal to zero, the function stops
      }
    }
  }

  /**A method for printing out an array/heap
  *@param int[] data;
  *@param int size;
  *@return String
  */
  public static String printA(int[] data, int size){
    String result = "[";
    for(int i = 0; i < size; i++){
      result += data[i];
      if(i != size - 1) result += ", ";
    }
    result += "]";
    return result;
  }


  //We will discuss this today:
  /**A method that converts an array into a heap array
  - convert the array into a valid heap. [ should be O(n) ]
  *@param int[] data
  */
  public static void heapify(int[] data){
    for(int i = data.length - 1; i >= 0; i--){
      pushDown(data, data.length, i);
    }
  }

  /*
  public static void heapsort(int[])
     - sort the array by converting it into a heap then removing the largest value n-1 times. [ should be O(nlogn) ]
  */
  public static void main(String[] args){
    int[] test1 = {10, 11, 8, 7, 6, 5, 4, 2, 1};
    System.out.println("test1 before: " + printA(test1, test1.length));
    pushDown(test1, test1.length, 0);
    System.out.println("test1 after: " + printA(test1, test1.length) + "\n");

    int[] test2 = new int[10];
    test2[0] = 10;
    test2[1] = 9;
    test2[2] = 1;
    test2[3] = 8;
    test2[4] = 7;
    test2[5] = 6;
    System.out.println("test2 before: " + printA(test2, 6));
    pushDown(test2, 6, 2);
    System.out.println("test2 after: " + printA(test2, 6) + "\n");

    test2[3] = 4;
    System.out.println("test2 before: " + printA(test2, 6));
    pushDown(test2, 6, 3);
    System.out.println("test2 after: " + printA(test2, 6) + "\n");

    test2[3] = 8;
    test2[5] = 11;
    System.out.println("test2 before: " + printA(test2, 6));
    pushUp(test2, 5);
    System.out.println("test2 after: " + printA(test2, 6) + "\n");

    int[] test3 = {1, 10, 9, 8, 7, 1, 9};
    System.out.println("test3 before: " + printA(test3, test3.length));
    pushUp(test3, 6);
    System.out.println("test3 after: " + printA(test3, test3.length) + "\n");

    int[] test4 = {1, 2, 3, 4, 5, 6};
    System.out.println("test4: " + printA(test4, test4.length));
    heapify(test4);
    System.out.println("test4 heap: " + printA(test4, test4.length) + "\n");

    int[] test5 = {1, 2, 3, 4, 5, 6, 7, 8};
    System.out.println("test5: " + printA(test5, test5.length));
    heapify(test5);
    System.out.println("test5 heap: " + printA(test5, test5.length) + "\n");
  }
}
