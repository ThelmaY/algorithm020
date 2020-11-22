# 学习笔记

## LeetCode的使用方法
1. 不要死磕，5分钟想不出来就去看题解。写完自己的AC之后也要去看高质量题解，思考优化方式。
2. 过遍数，至少5遍。
	1. 读题、思考、想不出来的话学习别人的题解
	2. 立刻自己写，然后优化
	3. 一天后重复
	4. 一周后重复
	5. 面试前一周恢复性训练
3. 要去国际站看top3高票回答

编码技巧和Code Style
1. Code Style可以搜 Google Code Style看
2. 可以去搜索 top tips IDE名称 进行学习
3. 行头：home，command+left(Mac)
   行尾：end，command+right(Mac)
   删除光标右边：fn+delete(Mac)
   光标按单词划分：control+left/right, option+left/right(Mac)
   删除单词：control+backspace, option+delete(Mac)
   选中整行(光标在行头时)：shift+command+right(Mac)
   
跳表(Skip List)：在元素有序的情况下，对原链表增加多级索引。时间复杂度O(logN), 空间复杂度O(n)

Deque(Double-End Queue):两端可以进出的Queue，增删都是O(1)

Priority Queue: 插入O(1), 取出O(logN)。按照元素的优先级取出。


***

# 作业

**1. 用 add first 或 add last 这套新的 API 改写 Deque 的代码**
```Deque<String> deque = new LinkedList<String>();
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);
String str = deque.peekFirst();
System.out.println(str);
System.out.println(deque);
while (deque.size() > 0) {
System.out.println(deque.removeFirst());
}
System.out.println(deque);
```

**2. 分析 Queue 和 Priority Queue 的源码**
1. Queue的源码
Java7中的Queue是Interface，继承于Collection，声明了add(),offer(),remove(),poll(),element(),peek()6个方法。
AbstractQueue这个类实现了Queue，add()、remove()、element()三个方法分别是通过调用offer()、poll()、peek()实现的，区别是通过判断语句来添加了异常抛出。

2. Priority Queue 的源码
PriorityQueue是个类，继承于AbstractQueue。
如果不使用参数，默认初始容量是11。
包含一个queue和一个comparator（用于排序），以及一个变量size记录queue的长度。
每次grow的时候判断，如果旧容量<64，那么新容量翻倍+2，否则新容量增加50%。然后把queue复制到新数组里面。
每次插入元素时，使用siftUp()方法来维护堆，使得新插入的元素大于等于它的父节点或为根节点。
每次取出元素时，取出队首元素，队尾置空，并通过siftDown()方法将原队尾元素放入堆中合适位置。
每次删除元素时，使用siftDown()和siftUp()来维护堆。
