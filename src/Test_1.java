

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;



public class Test_1 {
//	public static void main(String[] args) {
//	}
//@Test
	public void regular()
	{
		ArrayList<String> names= new ArrayList<String>();
		
	   names.add("Ananda");
	   names.add("Ravi");
	   names.add("Vighnesh");
	   names.add("Vijay");
	   names.add("Janu");
	   names.add("Jesu");
	   int count=0;
	   for(int i=0;i<names.size();i++)
	   {
		   String s=names.get(i);
		   if(s.startsWith("V"))
		   {
			   count++;
		   }
		   
	   }
	   System.out.println(count);
	}
//@Test
public void StreamFilter()
{
	ArrayList<String> names= new ArrayList<String>();

	   names.add("Ananda");
	   names.add("Ravi");
	   names.add("Vighnesh");
	   names.add("Vijay");
	   names.add("Janu");
	   names.add("Jesu");
	  
	  Long count= names.stream().filter(v->v.startsWith("V")).count();
	  System.out.println(count);
	  
long a=Stream.of("Ananda","Ravi","Vighnesh","Vijay","Janu","Jesu").filter(s->
{
	s.startsWith("V");
	return true;
}).count();
System.out.println(a);
//names.stream().filter(s->s.length()>5).forEach(s->System.out.println(s));
names.stream().filter(s->s.startsWith("V")).forEach(s->System.out.println(s));
}
@Test
public void streamMap()
{
	//print the name which have ends with letter u
	Stream.of("Ananda","Ravi","Vighnesh","Vijay","Janu","Jesu").filter(s->s.endsWith("u")).map(s->s.toUpperCase())
	.forEach(s->System.out.println(s));
	// print the name which have start with uppercase
//	Stream.of("Ananda","Ravi","Vighnesh","Vijay","Janu","Jesu").filter(s->s.startsWith("V"))
	//.forEach(s->System.out.println(s));
	List<String>names=Arrays.asList("Ananda","Ravi","Vighnesh","Vijay","Janu","Jesu","Kiran","Khusi","Kamal");
//	names.stream().filter(s->s.startsWith("K")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
//Stream.of("Ananda","Ravi","Vighnesh","Vijay","Janu","Jesu","Kiran","Khusi","Kamal").filter(s->s.startsWith("K"))
//.sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));

     List<String> title=Arrays.asList("Paila","Lenka");
    Stream<String> newStream= Stream.concat(names.stream(),title.stream());
    //newStream.forEach(s->System.out.println(s));
   boolean brand= newStream.anyMatch(s->s.equalsIgnoreCase("Vijay"));
   System.out.println(brand);
   Assert.assertTrue(brand);
   }
@Test
public void CollectStream()
{
	List<String> list=Stream.of("Ananda","Ravi","Vighnesh","Vijay","Janu","Jesu").filter(s->s.endsWith("u")).map(s->s.toUpperCase())
	.collect(Collectors.toList());
	System.out.println(list.get(0));
	
	List<Integer>values=Arrays.asList(2,5,5,6,9,4,8,2,3,6);
	//print unique number from this array
	//sort the array 4th index- 2,3,4,5,6,8,9
	List<Integer> numbers= values.stream().distinct().sorted().collect(Collectors.toList());
	System.out.println(numbers);
	List<Integer>descending=values.stream().sorted((i1,i2)->i1.compareTo(i2)).collect(Collectors.toList());
	System.out.println(descending);
	
	
}



}