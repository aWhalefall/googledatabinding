官方虽然已经给出了教程 - Data Binding Guide （中文版 - Data Binding（数据绑定）用户指南） ，但是实践之后发现槽点实在太多，于是就有了这个教程，针对每个知识点给出更详实的例子同时也总结了遇到的一些坑，希望对你有所帮助：）

Data Binding 解决了 Android UI 编程的一个痛点，官方原生支持 MVVM 模型可以让我们在不改变既有代码框架的前提下，非常容易地使用这些新特性。

Data Binding 框架如果能够推广开来，也许 RoboGuice、ButterKnife 这样的依赖注入框架会慢慢失去市场，因为在 Java 代码中直接使用 View 变量的情况会越来越少。

##准备

新建一个 Project，确保 Android 的 Gradle 插件版本不低于 1.5.0-alpha1：

classpath 'com.android.tools.build:gradle:1.5.0'
然后修改对应模块（Module）的 build.gradle：

```
dataBinding {
    enabled true
}
```

##基础

工程创建完成后，我们通过一个最简单的例子来说明 Data Binding 的基本用法。

##布局文件

使用 Data Binding 之后，xml 的布局文件就不再用于单纯地展示 UI 元素，还需要定义 UI 元素用到的变量。所以，它的根节点不再是一个 ViewGroup，而是变成了 layout，并且新增了一个节点 data。

```
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <data>
    </data>
    <!--原先的根节点（Root Element）-->
    <LinearLayout>
    ....
    </LinearLayout>
</layout>
```

要实现 MVVM 的 ViewModel 就需要把数据（Model）与 UI（View） 进行绑定，data 节点的作用就像一个桥梁，搭建了 View 和 Model 之间的通路。

我们先在 xml 布局文件的 data 节点中声明一个 variable，这个变量会为 UI 元素提供数据（例如 TextView 的 android:text），然后在 Java 代码中把『后台』数据与这个 variable 进行绑定。

下面我们使用 Data Binding 创建一个展示用户信息的表格。

##数据对象

添加一个 POJO 类 - User，非常简单，两个属性以及他们的 getter 和 setter。

```
package dragger2.nuoyuan.com.myapplication.bean;

public class Xuser implements Cloneable {
    private final String firstName;
    private final String lastName;

    public Xuser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public Xuser clone() throws CloneNotSupportedException {
        Xuser mail = (Xuser) super.clone();
        return mail;
    }


}
```

稍后，我们会新建一个 User 类型的变量，然后把它跟布局文件中声明的变量进行绑定。

定义 Variable

回到布局文件，在 data 节点中声明一个 Xuser 类型的变量 user。

```
<data>
	<variable name="user" type="dragger2.nuoyuan.com.myapplication.bean.Xuser" />
</data>
```

其中 type 属性就是我们在 Java 文件中定义的 Xuser类。

当然，data 节点也支持 import，所以上面的代码可以换一种形式来写。

```
<data>
    <import type="dragger2.nuoyuan.com.myapplication.bean.Xuser" />
    <variable name="user" type="User" />
</data>
```

然后我们刚才在 build.gradle 中添加的那个插件 - com.android.databinding 会根据 xml 文件的名称 Generate 一个继承自 ViewDataBinding 的类。 当然，IDE 中看不到这个文件，需要手动去 build 目录下找。

例如，这里 xml 的文件名叫 activity_basic.xml，那么生成的类就是 ActivityBasicBinding。

###注意

java.lang.* 包中的类会被自动导入，可以直接使用，例如要定义一个 String 类型的变量：

```
<variable name="firstName" type="String" />
```

绑定 **Variable** (变量)

```
 TestdataactivityBinding testdataactivityBinding = DataBindingUtil.setContentView(this, R.layout.testdataactivity);
 Xuser user = new Xuser("Test", "User");
 testdataactivityBinding.setUser(user);
```

除了使用框架自动生成的 TestdataactivityBinding ，我们也可以通过如下方式自定义类名。

<data class="CustomBinding">
</data>
注意

TestdataactivityBinding 类是自动生成的，所有的 set 方法也是根据 variable 名称生成的。例如，我们定义了两个变量。

```
<data>
    <variable name="firstName" type="String" />
    <variable name="lastName" type="String" />
</data>
```

那么就会生成对应的两个 set 方法。

```
setFirstName(String firstName);
setLastName(String lastName);
```

使用 Variable

数据与 Variable 绑定之后，xml 的 UI 元素就可以直接使用了。

```
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@{user.lastName}" />
```

至此，一个简单的数据绑定就完成了，可参考完整代码

