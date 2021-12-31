package javaMap;//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
	public static void main(String []argh)
	{
		Scanner in = new Scanner(new StringBufferInputStream("3\n" +
				"uncle sam\n" +
				"99912222\n" +
				"tom\n" +
				"11122222\n" +
				"harry\n" +
				"12299933\n" +
				"uncle sam\n" +
				"uncle tom\n" +
				"harry"));
		int n=in.nextInt();
		in.nextLine();
		Map<String, Integer> agenda = new HashMap<>();
		List<String> listCheckExist = new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			agenda.putIfAbsent(name, phone);
			in.nextLine();
		}
		while(in.hasNext())
		{
			String s=in.nextLine();
			if(agenda.containsKey(s)) {
				System.out.println(s+"="+agenda.get(s));
			}else {
				System.out.println("Not Found");
			}
		}

	}
}



