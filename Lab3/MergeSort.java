import java.util.*;

public class MergeSort<E> implements Comparator<E>{

  public List<E> mergeSort(List<E> list){
    //if(list.size()<=1) return list;
    if(list.size()<20) return bubbleSort(list);
    int mid = list.size()/2;
    List<E> l1 = new ArrayList<>();
    List<E> l2 = new ArrayList<>();
    l1.addAll(list.subList(0, mid));
    l2.addAll(list.subList(mid, list.size()));
    l1 = mergeSort(l1);
    l2 = mergeSort(l2);
    return merge(l1, l2);

  }
  public List<E> merge(List<E> l1, List<E> l2){

    List<E> result = new ArrayList<>();

    while(l1.size()>0 && l2.size()>0){
      if (compare(l1.get(0),l2.get(0))<=0){
        result.add(l1.get(0));
        l1.remove(0);
      }
      else{
        result.add(l2.get(0));
        l2.remove(0);
      }
    }
    if(l1.size()>0)
      result.addAll(l1);
    else
      result.addAll(l2);

    return result;
    
  }
  
  public List<E> bubbleSort(List<E> list){
    E tmp = null;
    for(int i = 0; i < list.size(); i++)
      for(int j = 1; j < list.size()-i; j++)
        if(compare(list.get(j-1) , list.get(j))>=0){
          tmp = list.get(j-1);
          list.set(j-1,list.get(j));
          list.set(j, tmp);
        }
    return list;
  }

  public int compare(E a, E b){
    if((int)a < (int)b) return -1;
    else if((int)a==(int)b) return 0;
    else return 1;
  }

  public static void main(String[] args){
    MergeSort<Integer> m = new MergeSort<>();
    List<Integer> list = new ArrayList<>();

    for(int i=0; i<1000; i++)
      list.add((int)(Math.random()*1000));

    long startTime = System.nanoTime();
    list = m.mergeSort(list);
    long endTime = System.nanoTime();

    for(int i=0; i<list.size(); i++)
      System.out.println(list.get(i));

    System.out.println("Sorted in " +(endTime- startTime)/1000000 + " milliseconds");
  }
}
