package server;

/**
 * Created by flysLi on 2017/9/25.
 */
public interface Handler {

    /**
     * ��Ӧ��Ϣ
     * <p>
     * ����������������ݽṹ��ʲô�����ӣ����մ���ȥ��ʱ�򶼵�ת�����������
     * </P>
     *
     * @param responseText
     */
    void send(String responseText);

    /**
     * ��ֱ��֪������Ʒ����к��ô�
     */
    default void test() {

    }
}
