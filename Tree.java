import java.util.*;
public class Tree
{
	static class Node
	{
		public Node parent;
		public int numberOfChildren;
		public Node[] children;
		public int content;
		public Node(int num)
		{
			numberOfChildren = num;
			parent = null;
			children = new Node[numberOfChildren];
			content = null;
		}
	}
	static class TreeList
	{
		public final int height;
		public Node root;
		public final int numberOfChildren;
		public TreeList(int height, int numberOfChildren)
		{
			this.height = height;
			this.numberOfChildren = numberOfChildren;
			root = null;
		}
		public void preorderAdd(Node parent, int level, Scanner sc) //How to refer back to the parent node
		{
			if (level == 0)
			{
				root = new Node(numberOfChildren); 
				System.out.println("Please enter the root: ");
				root.content = sc.nextInt();
				if (height != 0)
				{
					for (child: root.children)
						preorderAdd(child, level + 1, sc);
				}
			}
			else
			{
				Node n = new Node(numberOfChildren); 
				System.out.println("Please enter a child: ");
				n.content = sc.nextInt();
				n.parent = parent;
				if (level < height)
				{
					for (child: n.children)
						preorderAdd(child, level + 1, sc);
				}
			}
		}
	}
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input the height: ");
		int height = sc.nextInt();
		System.out.println("Please input the number of children of each node: ");
		int numberOfChildren = sc.nextInt();
		TreeList tl = new TreeList(height, numberOfChildren);
		tl.preorderAdd(null, 0, sc);
	}
}
