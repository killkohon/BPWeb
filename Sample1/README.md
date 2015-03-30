
运行本项目：

   1、请到http://servicemix.apache.org,下载servicemix，目前建议下载5.1.4 release；
   
   2、解压servciemix后，找到<servicemix path>/etc/org.apache.karaf.features.cfg文件里的一行“featuresBoot=......",按格式添加camel-blueprint和war两个feature;
   
   3、将本项目编译打包，得到BPWeb-1.0.jar，复制到<servicemix path>/deploy/下;
   
   4、启动<servicemix path>/bin/servicemix (for linux)或<servicemix path>/bin/servicemix.bat (for windows);
   
   5、待servicemix启动完毕后，在浏览器上输入http://<ip>:<port>/BPWeb/
 	 

如果对OSGI、blueprint、servicemix、camel等方面感兴趣，可以参考博客http://killko.iteye.com

也欢迎通过邮箱killko#qq.com（#置换为@）和我交流。
