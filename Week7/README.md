# 学习笔记

1. Trie树
	- 基本性质：
		1. 结点本身不存完整单词；
		2. 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串；
		3. 每个结点的所有子结点路径代表的字符都不相同。
	- 核心思想：空间换时间，利用字符串的公共前缀来见底查询时间的开销以达到提高效率的目的。
	
2. 并查集：处理组团配对问题
	- 基本操作：makeSet(s), unionSet(x,y), find(x)
	- Java实现
	```
	class UnionFind {
		private int count = 0;
		private int[] parent;
		
		public UnionFind(int n) {
			count = n;
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}

		public int find(int p) {
			while (p != parent[p]) {
				parent[p] = parent[parent[p]];
				p = parent[p];
			}
			return p;
		}
		
		public void union(int p, int q) {
			int rootP = find(p);
			int rootQ = find(q);
			if (rootP == rootQ) return;
			parent[rootP] = rootQ;
			count--;
		}
	}
	```

3. 剪枝
	- 例如：三子棋的状态空间（X走左上角，O走右上角，X已经赢了）
	- 题目：数独
	
4. 双向BFS
	- 例题：127

5. 启发式搜索
	- 基于BFS，添加启发式函数（估价函数）

6. AVL树
	- 平衡二叉搜索树
	- 平衡因子： 是它的左子树高度减去右（有时相反）。每个结点存balance factor = {-1, 0, 1}
	- 通过旋转操作来进行平衡（左旋、右旋、左右旋、右左旋）
	- 不足：结点需要存储额外信息、且调整次数频繁
	
7. 红黑树
	- 红黑树是一种近似平衡的二叉搜索树，它能够确保任何一个结点的左右子树高度差小于两倍。具体来说，红黑树是满足如下条件的二叉搜索树 ：
		- 每个结点要么是红色，要么是黑色
		- 根结点是黑色
		- 每个叶结点（NIL结点，空结点）是黑色的 。
		- 不能有相邻接的两个红色结点
		- 从任一结点到其每个叶子的所有路径都包含相同数目黑色结点
	- 关键性质：从根到叶子的最长可能路径不多于最短可能路径的两倍。

8. AVL树和红黑树对比
	- AVL查找更快，更加严格平衡
	- 红黑树插入和删除更快
	- AVL要存的额外信息更多，需要更多内存
	- 红黑树常用在高级语言的库里面，AVL常用在数据库里
	