package 结构性模式.proxy.dynamicproxy;

/**
 * 模拟动态生成的代理的结构
 */
public class ProxyStar implements Star {
    StartHandle handle;

    public ProxyStar(StartHandle handle) {
        this.handle = handle;
    }

    @Override
    public void conFer() {
//        handle.invoke(this,当前方法,args);
    }

    @Override
    public void signContract() {
//        handle.invoke(this,当前方法,args);

    }

    @Override
    public void sing() {
//        handle.invoke(this,当前方法,args);

    }

    @Override
    public void collectMoney() {
//        handle.invoke(this,当前方法,args);
    }
}
