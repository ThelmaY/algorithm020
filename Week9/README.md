# 学习笔记

1. 动态规划：分治+最优子结构	

2. 字符串
	- Java: x==y 比较的是指针地址不是内容， x.equals(y), x.equalsIgnoreCase(y)比较内容

3. 字符串匹配算法
	1. 暴力法: O(m*n)
	2. Rabin-Karp 算法：计算目标字符串中每个长度为M的子串的hash值(N-M+1次)，如果hash值相同，再使用朴素算法计算。计算hash的时候使用滑动窗口法，可以在O(1)时间内算出1个hash。
	3. KMP算法: 当子串与目标字符串不匹配时，已经知道了前面已经匹配成功的字符，利用这个信息和根据子串前缀后缀算出的部分匹配值表，向后移动不止一步。