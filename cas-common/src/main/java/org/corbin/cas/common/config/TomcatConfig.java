//package org.corbin.cas.common.config;
////
//import org.apache.catalina.connector.Connector;
//import org.apache.coyote.http11.Http11NioProtocol;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.*;
//
///**
// * @author yin
// * @date 2019/06/05
// */
//@Configuration
//public class TomcatConfig {
//    @Value("${https.port}")
//    private Integer port;
//
//    @Value("${https.ssl.key-store}")
//    private String keyStore;
//
//    @Value("${https.ssl.key-store-password}")
//    private String keyStorePassword;
//    //这是spring boot 2.0.X版本的 添加这个，上一个就不用添加了
//    @Bean
//    public ServletWebServerFactory servletContainer() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        tomcat.addAdditionalTomcatConnectors(createSslConnector()); // 添加http
//        return tomcat;
//    }
//
//
//
//    // 配置https
//    private Connector createSslConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
//
//        try {
//            connector.setScheme("https");
//            connector.setSecure(true);
//            connector.setPort(port);
//            protocol.setSSLEnabled(true);
//            protocol.setKeystoreFile(getKeyStore(this.getClass().getClassLoader().getResourceAsStream(keyStore)));
//            protocol.setKeystorePass(keyStorePassword);
//            return connector;
//        }
//        catch (IOException ex) {
//            throw new IllegalStateException("can't access keystore: [" + "keystore"
//                    + "] or truststore: [" + "keystore" + "]", ex);
//        }
//
//    }
//
//    private String getKeyStore(InputStream is) throws IOException{
//        OutputStream os = null;
//        File file = new File(keyStore);
//        if (!file.exists()) {
//            try {
//                os = new FileOutputStream(file);
//                int len = 0;
//                byte[] buffer = new byte[8192];
//
//                while ((len = is.read(buffer)) != -1) {
//                    os.write(buffer, 0, len);
//                }
//            } finally {
//                if (os != null) {
//                    os.close();
//                }
//                if (is != null) {
//                    is.close();
//                }
//            }
//        }
//
//        return file.getAbsolutePath();
//    }
//
//}
