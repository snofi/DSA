import java.util.*;

public class MergeSort<E> implements Comparator<E>{

  public List<E> mergeSort(List<E> list){
    if(list.size()<=1) return list;
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
    int a=0, b=0;
    while(a< l1.size()&&  b<l2.size()){
      if (compare(l1.get(a),l2.get(b))<=0){
        result.add(l1.get(a));
        a++;
      }
      else{
        result.add(l2.get(b));
        b++;
      }
    }
    if(a < l1.size())
      for(int i=a; i<l1.size(); i++)
        result.add(l1.get(i));
    else
      for(int i=b; i<l2.size(); i++)
        result.add(l2.get(i));

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


  public int compare(Object a, Object b){
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
