package gege.shiro.service;

import java.util.List;
import java.util.Set;

import gege.shiro.entity.Resource;

public interface ResourceService {
	Set<String> findPermissions(Set<Long> resourceIds); //�õ���Դ��Ӧ��Ȩ���ַ���  
    List<Resource> findMenus(Set<String> permissions); //�����û�Ȩ�޵õ��˵�  
}
