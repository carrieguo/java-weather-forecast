# java-weather-forecast
## 面向对象的基础认知
### 介绍类与对象
#### java创建类的语法
```java
public class 类名 {
    //类的内容
}
```
> * 类名要有直白意义，最好是英文
> * 首字母大写：Dog, BigDecimal
> * 不要数字开头，不要包含特殊字符
#### 创建类的实例对象
```java
类名 对象名 = new 类名()
```
```java
Dog doudou = new Dog()
Dog lucky = new Dog()
```
> * new关键字是创建实例对象最重要的标志

#### 成员变量
> * 成员变量就是隶属于对象的变量
> * 成员变量用于保存对象的静态特征
> * 同类型的不同对象拥有相同的成员变量，但值彼此独立
#### 包-package
>* 把功能相似或相关的类组织在同一个包中
>* 包也采用了树形目录的存储方式
>* 通过包也可限定类的访问权限
#### 包的命名规范
>* 包采用“逆域名法”进行命名，用“.”分隔，单词全部小写
>* 标准格式：域名后缀.组织机构名.项目名[.模块名].包的职能
```java
com.imooc.weather.ui
com.alibaba.taobao.customer.data
```
#### 在包中定义类
```java
//在类的第一行声明类所在的包名
package com.imooc.sample.group1;
//在java工程中尽量不要出现同名的类
public class PackageSample1{
    
}
```
#### 引用其他包的类
```java
//在类的第一行声明类所在的包名
package com.imooc.sample.group2;
import com.imooc.sample.group1.PackageSample02;
public class PackageSample2{
   public static void main(String[] args) {
      PackageSample1 s1 = new PackageSample1();
   }
}
```
#### 访问修饰符
>* 用于控制类、成员变量、方法的访问范围

   | 访问修饰符     |  名称 |     说明      |
|-----------|----:|:-----------:|
   | private   |  私有 |  只能在类的内部访问  |
   | public    |  公共 | 在任何地方都可以访问  |
   | (default) |  默认 | 相同包的其他类可以访问 |
   | protected |  继承 | 只有继承的子类能访问到 |
#### 面向对象 三大特征 封装 继承 多态
##### 封装
>* 封装即隐藏功能的实现细节
>* 利用对象与方法是实现封装的直接途径
>* 良好的封装让代码更容易阅读与维护
##### 继承
访问修饰符作用范围总结

| 访问修饰符 |  本类 |同一个包的类 | 继承类 |   其他类   |
|----------|----:|:-----:|:-----:|:-------:|
| private   |   √ |  ×    | ×|    ×    |
| (default) |   √ |   √   | ×|    ×    |
| protected |   √ |   √   | √|    ×    |
| public    |   √ |   √   | √|    √    |

##### 多态
>* 多态是同一个行为具有多个不同表现形式或形态的能力
###### 实现多态的关键是接口
>* 接口（Interface)是一个抽象的类型，只提供方法的定义
>* 实现类是一个接口的具体实现，要实现每一个接口方法的功能
#### ArrayList列表类
>* ArrayList是Java内置的数据集合，用于存储多个数据
>* ArrayList是数组替代品，提供了更多的数据操作方法
>* ArrayList几乎是每一个项目中必用的类
## 实现天气预报项目
>* jar 是Java中的组件包，对于已有的功能可以通过jar包装引用。可以看作由第三方开发好的功能完善的代码，可以直接拿来使用。类似于windows编程的dll。
### 利用字符串格式化替代拼接字符串
```java
//老写法
String result = a + "-" + b + "-" + c;

//新写法 %s代表一个占位符
String template = "%s-%s-%s"
String row = String.format(template, new String[]{a,b,c});
```