# 学习笔记

1. 位运算
	1. 运算符
		- <<左移
		- `>>`右移
		- ~按位取反
		- ^按位异或
		- | 按位或
		- & 按位与
	2. 异或
		- x^0 = x
		- x^1s = ~x //1s = ~0
		- x^(~x) = 1s
		- x^x = 0
		- c = a^b => a^c = b, b^c = a //交换两个数
		- a^b^c = a^(b^c) = (a^b)^c //结合律associative
	3. 指定位置的位运算
		1. 将 x 最右边的 n 位清零： x & (~0 << n)
		2. 获取 x 的第 n 位值（ 0 或者 1）： (x >> n) & 1 
		3. 获取 x 的第 n 位的幂值： x& (1 << n)
		4. 仅将第 n 位置为 1：x | (1 << n) 
		5. 仅将第 n 位置为 0：x & (~ (1 << n))
		6. 将 x 最高位至第 n 位（含）清零： x& ((1 << n) -1)
	4. 实战常用
		1. 判断奇偶
			x%2 == 1 -> (x&1) == 1
			x%2 == 0 -> (x&1) == 0
		2. x>>1 -> x/2
		3. 清零最低位的1：x = x & (x-1)
		4. 得到最低位的1：x&-x ?
		5. x & ~x => 0

2. 布隆过滤器Bloom Filter
	- 一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中。挡在前面快速查询的缓存。
	- 优点是空间效率和查询时间都远远超过一般算法
	- 缺点是有一定的误识别率和删除困难
		二进制位有一个为0说明肯定不在其中，但全为零不一定说明在其中。

3. LRU Cache 最近最少使用缓存
	- 使用哈希表+双向链表实现

4. 排序算法
	1. 比较类排序
		- 交换排序
			- 冒泡排序：嵌套循环，每次查看相邻元素，如果逆序则交换
			- 快速排序：数组取标杆pivot，将小元素放pivot左边，大元素放右侧，然后依次对右边和右边的子数组继续快排，以达到整个序列有序。
		- 插入排序
			- 简单插入排序：从前到后逐步构建有序序列；对于未排序数据，在已排序序列中向前扫描，找到相应位置并插入。
			- 希尔排序
		- 选择排序
			- 简单选择排序：每次找最小值，然后放到待排序数组的起始位置
			- 堆排序：1. 数组元素依次建立小顶堆 2. 依次取堆顶元素并删除
		- 归并排序：分治
			- 二路归并排序
			- 多路归并排序
	2. 非比较类排序
		- 计数排序：输入数据是确定范围的整数。将输入的数据值转化为键存在额外开辟的数组空间中，然后依次把计数大于一的填充回原数组
		- 桶排序：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序。
		- 基数排序：按照低位先排序，然后收集；再按照高位排序，然后再收集；以此类推，直到最高位。有时候有些属性是有优先级顺序的，先按照低优先级排序，再按照高优先级排序。
	
	
	
	