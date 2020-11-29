# 学习笔记

1. 哈希表（ Hash Hash table ）， 也叫散列表，是根据关键码值（ Key value ）而直接进行访问的数据结构 。
//比如OC和Python中的Dictionary
当发生冲突的时候，会在相应位置生成链表

2. 树和图最关键的差别是有无环。链表是特殊化的树，树是特殊化的图。
	树的遍历：
	- 前序（pre-order）: 根左右
	- 中序（in-order）: 左根右
	- 后序（post-order）: 左右根
	二叉搜索树的删除通常是取右子树中最小的节点取代根节点，然后进行相应调整。

3. 堆Heap：可以迅速找到一堆数中最大（大顶堆）or最小（小顶堆）的数据结构。常见有二叉堆和斐波那契堆。
	以大顶堆为例，常见操作的时间复杂度：
	- find-max: O(1)
	- delete-max: O(logN)
	- insert(create): O(logN) or O(1)（如斐波那契堆）

# 作业
**1. 写一个关于 HashMap 的小总结。**
- get方法：返回key对应的value。
	如果key为null，返回table[0]（有值且key为null）或null。
	如果key不为null，返回对应key的entry。在这个过程中，先对key进行hash。得到hash值之后遍历table中对应位置的链表，如果hash值和key值都相等则返回对应的entry。
- put方法：将特定的key和value在map中关联起来，如果key值之前有对应的value，那么旧的value会被替代
	如果key为null，在table[0]中增加key=null，value=value的键值对。
	如果key不为null，先对key进行hash，得到hash值之后遍历table中对应位置的链表，如果hash值和key值都相等则替代旧的value。如果未找到hash值和key值都相等的键值对对象，则新增一个键值对对象存入table中。
	