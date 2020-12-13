# 学习笔记

1. 搜索
	- 每个节点都要访问一次
	- 每个节点仅仅要访问一次
	- 按访问顺序：
		- 深度优先
		- 广度优先
		- 优先级优先（启发式搜索）：应用在各种推荐算法中

2. DFS
二叉树
```
	def dfs(node):
		if node in visited:
			#already visited
			return
		
		visited.add(node)
		
		#process current node
		#...# logic here
		dfs(node.left)
		dfs(node.right)
```

通用（递归写法）
```
	visited = set()
	
	def dfs(node, visited):
		visited.add(node)
		#process current node here.
		...
		for next_node in node.children():
			if not next_node in visited:
				dfs(next node, visited)
```

通用（非递归写法） 自己写栈
```
	def DFS(self, tree):
		if tree.root is None:
			return []
			
		visited, stack = [], [tree.root]
		
		while stack:
			node = stack.pop()
			visited.add(node)
			
			process(node)
			nodes = generate_relate_nodes(node)
			stack.push(nodes)
			
		#other processing work
		...
```

3. BFS
```
	def BFS(graph, start, end):
		
		queue = []
		queue.append([start])
		visited.add(start)
		
		while queue:
			node = queue.popleft()
			visited.add(node)
			
			process(node)
			nodes = generate_relate_nodes(node)
			queue.push(nodes)
		
		#other processing work
```

4. 二分查找的前提
	- 单调性
	- 存在上下界
	- 能够通过索引访问

```
	left, right = 0, len(array)-1
	while left <= right:
		mid = (left + right)/2
		if array[mid] == target:
			#find the target!!
			break or return result
		elif array[mid]<target:
			left = mid+1
		else:
			right = mid-1
```