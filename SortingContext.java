import java.util.Arrays;
import java.util.Date;

public class SortingContext{
    SortingStrategy ss;
    int[] a;
    void setType(SortingStrategy ss, int[] a){
        this.ss = ss;
        this.a = a;
    }
    void execute(){
        long time =  ss.doSortGetTime(a);
        System.out.println(ss);
        System.out.println(time);
    }
}
abstract class SortingStrategy
{
    abstract int[] sort(int[] arr);
    long doSortGetTime(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] +" ");
        }
        System.out.println();

        long startTime = System.nanoTime();
        int[] a = sort(arr);
        long endTime = System.nanoTime();

        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] +" ");
        }
        System.out.println();

        return (endTime - startTime);
    }
}
class Insertion extends SortingStrategy
{
    @Override
    int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++)
        {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp < arr[j])
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        return arr;
    }
}
class Selection extends SortingStrategy
{
    @Override
    int[] sort(int[] arr) {
        for (int i = 0; i < arr.length ; i++)
        {
            int min = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[min] > arr[j])
                {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }
}
class Bubble extends SortingStrategy
{
    @Override
    int[] sort(int[] arr) {
        for (int i = 0; i < arr.length ; i++)
        {
            int min = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[min] > arr[j])
                {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }
}