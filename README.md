# JTools

Java JDK 基础类库增强，以便于我们日常开发，避免重复造轮子。本项目正在持续更新中...

目前，对 Java JDK 基础类库增强如下：

 - Map 的增强实现：根据Value对Map进行排序、根据Key对Map进行排序 和 保持Map插入顺序。
本工具类使得我们可以方便根据Value对Map进行排序，并将每条Map.Entry按序输出。但这种排序的稳定性是不确定的，其取决于Map的具体实现：若使用HashMap实现，由于HashMap是无序的，所以是不稳定的；
若使用LinkedHashMap实现，由于LinkedHashMap是保留插入顺序的，所以是稳定的。其中，所谓排序稳定是指，相同两项在排序后仍保持最初的顺序，不会颠倒。根据Key对Map进行排序与根据Value对Map进行排序的思想是一样的，不过这种排序是稳定的，和Map的具体实现无关，因为Key不同于Value，其在Map中是唯一的。
此外，如果需要使Map保持插入顺序，那么我们应该选用LinkedHashMap来实现Map，因为LinkedHashMap本身就具有这种特性，即其本身就可以使节点的输出顺序与输入顺序相同。

