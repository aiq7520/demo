package gege.shiro.service;

import java.util.Set;

public interface RoleService {
	Set<String> findRoles(Long... roleIds); //���ݽ�ɫ��ŵõ���ɫ��ʶ���б�  
    Set<String> findPermissions(Long[] roleIds); //���ݽ�ɫ��ŵõ�Ȩ���ַ����б� 
}
