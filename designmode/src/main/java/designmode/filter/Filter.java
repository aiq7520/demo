package designmode.filter;
/**
 * ������ģʽ��Filter Pattern�����׼ģʽ��Criteria Pattern����һ�����ģʽ������ģʽ��������Աʹ�ò�ͬ�ı�׼������һ�����
 * ͨ���߼������Խ���ķ�ʽ�����������������������͵����ģʽ���ڽṹ��ģʽ������϶����׼����õ�һ��׼��
 * @author lenove1
 *
 */
public interface Filter {
	public String doFilter(String msg);
}
