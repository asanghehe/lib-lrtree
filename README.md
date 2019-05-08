# lib-lrtree
Java 左右值 树构建/平坦化 构建工具 以及数据库示例，利用左右值 处理 树结构

## 关于左右值
左右值详细描述见：
*  [左右值无限分类实现算法](https://www.cnblogs.com/hellowzd/p/4773261.html "左右值无限分类实现算法"). 
*  [mysql左右值无限分类原理及实现](https://blog.csdn.net/liwenxia626/article/details/81316747 "mysql左右值无限分类原理及实现"). 

这里简单说一下使用左右值的好处。目前数据库经常会存到树结构的数据，比如菜单/地区/分类/部门等，一般存储方式为下级存储上级的ID，
要组织成树结构时，一层一层递归查询数据库，然后挂载到上级的children上。这种方式显然有一个很大的缺点，就是有多少个部门就要执行多少次数据库查询，
效率极低。如果在传统的这种下级存储上级ID方式上，增加left value/right value 可以直接一次性查询出数据，然后代码中直接构建出树结构，效率极大的提高了，速度非常快

使用左右值，另外还提供了一些树结构查询的一些特别方便的功能特点，比如如果需要查询某个节点的所有子节点，
 可以 以条件 ：**表中左值大于当前记录的左值+右值小于当前记录的右值** 直接查询出所有子节点，
 再比如如果需要查询所有叶子节点，
 可以 以条件 ：**右值等于左值+1** 直接查询出所有叶子节点
 
 以上就是左右值的特点简单介绍
 
 
## 关于本项目
为方便利用以上所描述左右值的功能，特意设计了本库，减少重复编码，提高开发效率。
本项目 抽象化出了一个LrTree接口，以及子接口，实现了接口的基类。以及一个LrTreeUtils工具类，
用户可以直接继承 **LrBaseNumberIdEntity** 或者 **LrBaseStringIdEntity** 两个基类，两者区别是Id的数据类型。
继承后，从数据库查询出来的对应实体对象列表将可以直接由本库的 LrTreeUtils 构建成树，树可以直接解构成列表
如果用户的Entity类有自己需要继承的基类，无法继承本库提供的基类，可以实现LrSortedBuildableTree接口，这样提供的LrTreeUtils就可以直接操作实现类，构建树结构以及解构树


### 样例代码

Java代码：

```java
		List<LrNumberIdTreeEntity> list = new ArrayList<LrNumberIdTreeEntity>();
		//模拟从数据库查询出来的结果
		for(long i =1; i<10; i++) {
			LrNumberIdTreeEntity de = new LrNumberIdTreeEntity();
			de.setId(i);
			de.setOtherField("继承数字ID树结构"+i);
			de.setParentId(i-1);
			list.add(de);
		}
		
		//构建树
		List<LrNumberIdTreeEntity> result = LrTreeUtils.buildListToSortedTree(list, 0L);
		String r = JSON.toJSONString(result, true);
		System.out.println(r);
```
第1个输出的数据样式：

```json
[
	{
		"children":[
			{
				"children":[
					{
						"children":[
							{
								"children":[],
								"id":4,
								"leaf":false,
								"otherField":"继承数字ID树结构4",
								"parentId":3
							}
						],
						"id":3,
						"leaf":false,
						"otherField":"继承数字ID树结构3",
						"parentId":2
					}
				],
				"id":2,
				"leaf":false,
				"otherField":"继承数字ID树结构2",
				"parentId":1
			}
		],
		"id":1,
		"leaf":false,
		"otherField":"继承数字ID树结构1",
		"parentId":0
	}
]
```
第2个输出的数据样式：

```json
[
	{
		"children":[
			{
				"children":[
					{
						"children":[
							{
								"children":[],
								"id":4,
								"leaf":true,
								"leftValue":4,
								"level":4,
								"otherField":"继承数字ID树结构4",
								"parentId":3,
								"rightValue":5
							}
						],
						"id":3,
						"leaf":false,
						"leftValue":3,
						"level":3,
						"otherField":"继承数字ID树结构3",
						"parentId":2,
						"rightValue":6
					}
				],
				"id":2,
				"leaf":false,
				"leftValue":2,
				"level":2,
				"otherField":"继承数字ID树结构2",
				"parentId":1,
				"rightValue":7
			}
		],
		"id":1,
		"leaf":false,
		"leftValue":1,
		"level":1,
		"otherField":"继承数字ID树结构1",
		"parentId":0,
		"rightValue":8
	}
]
```

将树结构扁平化

```java
		//构造测试数据
		List<CustLrTreeEntity> list = new ArrayList<CustLrTreeEntity>();
		for(long i =1; i<10; i++) {
			CustLrTreeEntity de = new CustLrTreeEntity();
			de.setId(i);
			de.setOtherField("自定义实体类实现树接口"+i);
			de.setParentId(i-1);
			list.add(de);
		}
		List<CustLrTreeEntity> result = LrTreeUtils.buildListToSortedTree(list, 0L);
		String r = JSON.toJSONString(result, true);
		System.out.println(r);
		
		//解构后列表形式的所有元素（元素的children 仍然有对象，涉及到Java的循环引用）
		result = LrTreeUtils.flatformTree(result);
```

### maven 仓库

目前先完善文档，文档完善好后打包放到maven中央仓库