����Ŀ������ServiceMix֮�ϣ�ͨ������Pax Web Extender��Blueprint��Camel��Camel-blueprint��Camel-VM�ȣ�ʵ�ֻ���IOC��·�ɵķ�ʽ��OSGI web���������

��Ϊ������ʽ��Actorģʽ�����ƣ����Կ����ٽ�һ����������Akka��ʵ��Actorģʽ��web��

���б���Ŀ��
   1���뵽http://servicemix.apache.org,����servicemix��Ŀǰ��������5.1.4 release��
   2����ѹservciemix���ҵ�<servicemix path>/etc/org.apache.karaf.features.cfg�ļ����һ�С�featuresBoot=......",����ʽ���camel-blueprint��war����feature;
   3��������Ŀ���������õ�BPWeb-1.0.jar�����Ƶ�<servicemix path>/deploy/�£�
 	 4������<servicemix path>/bin/servicemix (for linux)��<servicemix path>/bin/servicemix.bat (for windows);
 	 5����servicemix������Ϻ��������������http://<ip>:<port>/BPWeb/
 	 

�����OSGI��blueprint��servicemix��camel�ȷ������Ȥ�����Բο�����http://killko.iteye.com��Ҳ��ӭͨ������killko#qq.com��#�û�Ϊ@�����ҽ�����