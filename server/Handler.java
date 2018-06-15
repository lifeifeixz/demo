package server;

/**
 * Created by flysLi on 2017/9/25.
 */
public interface Handler {

    /**
     * 响应信息
     * <p>
     * 无论你所构造的数据结构是什么鬼样子，最终传出去的时候都得转换成这个鸟样
     * </P>
     *
     * @param responseText
     */
    void send(String responseText);

    /**
     * 简直不知道这二逼方法有何用处
     */
    default void test() {

    }
}
