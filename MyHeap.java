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
      if(child1 < size && child2 < size){
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
      }else if(child1 < size){
        int larger = Math.max(data[index], data[child1]);
        if(larger != data[index]){
          data[child1] = data[index];
          data[index] = larger;
          index = child1;
        }else done = true;
      }
    }
  }

  /*
  - push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
  - precondition: index is between 0 and data.length-1 inclusive.
  */
  private static void pushUp(int[]data, int index){
    boolean done = false;
    while(!done){
      if(index == 0) done = true;
      else{
        int parent;
        if(index % 2 == 0) parent = (index / 2) - 1;
        else parent = index / 2;
        if(parent >= 0){
          int temp = data[index];
          if(data[index] > data[parent]){
            data[index] = data[parent];
            data[parent] = temp;
            index = parent;
          }else done = true;
        }else done = true;
      }
    }
  }

  public static String printA(int[] data, int size){
    String result = "[";
    for(int i = 0; i < size; i++){
      result += data[i];
      if(i != size - 1) result += ", ";
    }
    result += "]";
    return result;
  }


  /*
  //We will discuss this today:
  public static void heapify(int[])
     - convert the array into a valid heap. [ should be O(n) ]

  public static void heapsort(int[])
     - sort the array by converting it into a heap then removing the largest value n-1 times. [ should be O(nlogn) ]
  */
  public static void main(String[] args){
    int[] test1 = {10, 11, 8, 7, 6, 5, 4, 2, 1};
    System.out.println("test1 before: " + printA(test1, test1.length));
    pushDown(test1, test1.length, 0);
    System.out.println("test1 after: " + printA(test1, test1.length));

    int[] test2 = new int[10];
    test2[0] = 10;
    test2[1] = 9;
    test2[2] = 1;
    test2[3] = 8;
    test2[4] = 7;
    test2[5] = 6;
    System.out.println("test2 before: " + printA(test2, 6));
    pushDown(test2, 6, 2);
    System.out.println("test2 after: " + printA(test2, 6));

  }
}
