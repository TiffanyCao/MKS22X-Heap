public class MyHeap{
  //We discussed these 2 methods already:
  /*
  - size  is the number of elements in the data array.
  - push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided that child is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
  - precondition: index is between 0 and size-1 inclusive
  - precondition: size is between 0 and data.length-1 inclusive.
  */
  private static void pushDown(int[]data, int size, int index){
    boolean done = false;
    while(!done){
      int child1 = index * 2 + 1;
      int child2 = index * 2 + 2;
      if(child1 >= size && child2 >= size) done = true;
        int larger = Math.max(data[index], data[child1]);
        int largest = Math.max(larger, data[child2]);
        if(largest != data[index]){
          if(largest == data[child1]){
            data[child1] = data[index];
            data[index] = largest;
            index = child1;
          }else{
            data[child2] = data[index];
            data[index] = largest;
            index = child2;
          }
        }else done = true;
      }
  }

  /*
  private static void pushUp(int[]data,int index)
     - push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
     - precondition: index is between 0 and data.length-1 inclusive.


  //We will discuss this today:
  public static void heapify(int[])
     - convert the array into a valid heap. [ should be O(n) ]

  public static void heapsort(int[])
     - sort the array by converting it into a heap then removing the largest value n-1 times. [ should be O(nlogn) ]
  */

}