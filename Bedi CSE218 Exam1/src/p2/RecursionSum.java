package p2;

public class RecursionSum
{
	public static void main(String[] args)
	{
		System.out.println(sum(new double[] { 1, 2, 5, 5, 12, 0 }));
	}

	public static double sum(double[] a) 
	{
		if (a.length == 0)
			return 0.0;
		else {
			return sumTotal(a, 0);
		}
	}

	private static double sumTotal(double[] a, int i)
	{
		if (a.length - 1 == i) 
		{
			return a[i];
		} 
		else 
		{
			return a[i] + sumTotal(a, i + 1);
		}
	}

}
