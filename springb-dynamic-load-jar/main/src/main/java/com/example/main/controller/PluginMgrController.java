package com.example.main.controller;

import com.example.main.service.PluginService;
import com.example.main.util.ClassUtil;
import com.example.main.util.SpringManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-04-18
 * Time 17:01
 */
@RestController
@Api(tags = "插件管理")
public class PluginMgrController {
    @Autowired
    private PluginService pluginService;

    @RequestMapping("/load")
    public String loadPlugin() {
        beanLoad("F:\\testplugin");
        return "sucess";
    }

    @RequestMapping("/loadPlugin2")
    @ApiOperation(value = "加载分析组件", notes = "加载分析组件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pluginFileName", value = "组件文件名(包含路径)", required = true, dataType = "String")
    })
    public String loadPlugin2() {
       loadPluginFromJar("F:\\code\\linewell\\daydayup\\springb-dynamic-load-jar\\my-plugin-jar\\target");
        return "sucess";
    }

    /**
     * @exception Exception 说明
     * Description
     * @return 返回值说明
     * @param 参数名 参数说明
     * @author luolifeng
     * Date  2019/4/19
     */
    private void beanLoad(String path) {
        ApplicationContext applicationContext = SpringManager.getApplicationContext();
        ConfigurableApplicationContext context = (ConfigurableApplicationContext) applicationContext;
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        ClassLoader beanClassLoader = beanFactory.getBeanClassLoader();
        Map<String, Object> controllerMap = new HashMap<>(8);
        List<Class> classList = ClassUtil.LoadClass(path, beanClassLoader);

        classList.forEach(aClass -> {
            Annotation[] annotations = aClass.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation.toString());
                if (annotation.annotationType().getName().startsWith("org.springframework")){
                    registerBean(aClass, beanFactory);
                    System.out.println(applicationContext.getBean(aClass));
                }
                if (aClass.getAnnotation(RestController.class)!=null) {
                    controllerMap.put(aClass.getName(), aClass);
                }
            }
        });

        for (String s : controllerMap.keySet()) {
            try {
                registerController(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


//        String[] beans = applicationContext.getBeanDefinitionNames();
//        for (String name : beans) {
//            System.out.println(name);
//        }

    }

    private static void registerBean(Class aClass, DefaultListableBeanFactory beanFactory) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(aClass);
        beanFactory.registerBeanDefinition(aClass.getName(), beanDefinitionBuilder.getRawBeanDefinition());
    }

    /**
     * Description 卸载Controller的Mapping
     * @return 返回值说明
     * @param controllerBeanName 参数说明
     * @author luolifeng
     * Date  2019/4/19
     */
    private static void unregisterController(String controllerBeanName) {
        final RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping)
                SpringManager.getBean("requestMappingHandlerMapping");
        if (requestMappingHandlerMapping != null) {

            Object controller = SpringManager.getBean(controllerBeanName);
            if (controller == null) {
                return;
            }
            final Class<?> targetClass = controller.getClass();
            ReflectionUtils.doWithMethods(targetClass, method -> {
                Method specificMethod = ClassUtils.getMostSpecificMethod(method, targetClass);
                try {
                    Method createMappingMethod = RequestMappingHandlerMapping.class.
                            getDeclaredMethod("getMappingForMethod", Method.class, Class.class);
                    createMappingMethod.setAccessible(true);
                    RequestMappingInfo requestMappingInfo = (RequestMappingInfo)
                            createMappingMethod.invoke(requestMappingHandlerMapping, specificMethod, targetClass);
                    if (requestMappingInfo != null) {
                        requestMappingHandlerMapping.unregisterMapping(requestMappingInfo);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, ReflectionUtils.USER_DECLARED_METHODS);
        }
    }
    /**
     * @exception Exception 说明
     * Description  注册Controller
     * @return 返回值说明
     * @param controllerBeanName 参数说明
     * @author luolifeng
     * Date  2019/4/19
     */
    private static void registerController(String controllerBeanName) throws Exception {
        final RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping)
                SpringManager.getBean("requestMappingHandlerMapping");
        if (requestMappingHandlerMapping != null) {
            Object controller = SpringManager.getBean(controllerBeanName);
            if (controller == null) {
                return;
            }
            unregisterController(controllerBeanName);
            //注册Controller
            Method method = requestMappingHandlerMapping.getClass().getSuperclass().getSuperclass().
                    getDeclaredMethod("detectHandlerMethods", Object.class);
            method.setAccessible(true);
            method.invoke(requestMappingHandlerMapping, controllerBeanName);
        }
    }


    private static List<URL> findDependencyJar(File file) throws MalformedURLException {
        List<URL> list = new ArrayList<>();
        File parentFile = file.getParentFile();
        File libFile = new File(file.getParent() + File.separator + "lib");
        libFile = file;
        if (libFile.exists() && parentFile.isDirectory()) {
            for (File jar : libFile.listFiles()) {
                if (jar.isFile() && jar.getName().toLowerCase().endsWith(".jar")) {
                    list.add(jar.toURI().toURL());
                }
            }
        }
//        list.add(file.toURI().toURL());
        return list;

    }


    public Set<BeanDefinition> getBeanDefinitions(ClassLoader classLoader) throws Exception {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();

        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver(classLoader);
        Resource[] resources = resourcePatternResolver.getResources("classpath*:org/llf/spb/plugin/**/*.**");

        MetadataReaderFactory metadata = new SimpleMetadataReaderFactory();
        for (Resource resource : resources) {
            MetadataReader metadataReader = metadata.getMetadataReader(resource);
            boolean isController= metadataReader.getAnnotationMetadata().hasAnnotation("org.springframework.stereotype.Controller");
            boolean isRestController= metadataReader.getAnnotationMetadata().hasAnnotation("org.springframework.web.bind.annotation.RestController");
            boolean isRestComponent= metadataReader.getAnnotationMetadata().hasAnnotation("org.springframework.stereotype.Component");
            boolean isRestService= metadataReader.getAnnotationMetadata().hasAnnotation("org.springframework.stereotype.Service");
            if(!isController && !isRestController && !isRestComponent && !isRestService){
                continue;
            }

            ScannedGenericBeanDefinition sbd = new ScannedGenericBeanDefinition(metadataReader);
            sbd.setResource(resource);
            sbd.setSource(resource);
            candidates.add(sbd);
        }
        for (BeanDefinition beanDefinition : candidates) {
            String classname = beanDefinition.getBeanClassName();
            System.out.println(classname);
        }
        return candidates;
    }


    public void loadPluginFromJar(String path) {
        try {
            File file = new File(path);
            //查找依赖的jar包，同级目录下的lib/
            List<URL> dependencyJar = findDependencyJar(file);
            ApplicationContext applicationContext = SpringManager.getApplicationContext();
            ConfigurableApplicationContext context = (ConfigurableApplicationContext) applicationContext;
            DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
            ClassLoader beanClassLoader = beanFactory.getBeanClassLoader();

            URL[] urls = dependencyJar.toArray(new URL[dependencyJar.size()]);
            //新建classloader 核心
            URLClassLoader urlClassLoader = new URLClassLoader(urls, beanClassLoader);

            //获取导入的jar的controller  service  等类，并且创建BeanDefinition
            Set<BeanDefinition> beanDefinitions = getBeanDefinitions(urlClassLoader);
            beanDefinitions.forEach(item -> {
                //根据beanDefinition通过BeanFactory注册bean
                beanFactory.registerBeanDefinition(item.getBeanClassName(), item);
          });

            //修改BeanFactory的ClassLoader
//            annotationConfigEmbeddedWebApplicationContext.getDefaultListableBeanFactory().setBeanClassLoader(urlClassLoader);
            beanFactory.setBeanClassLoader(urlClassLoader);

            beanDefinitions.forEach(item -> {
                String classname = item.getBeanClassName();
                try {
                    Class<?> c = Class.forName(classname, false, urlClassLoader);
                    Controller annotationController = c.getAnnotation(Controller.class);
                    RestController annotationRestController = c.getAnnotation(RestController.class);
                    //获取该bean 真正的创建
                    System.out.println(item.getBeanClassName());
                    //如果此bean是Controller，则注册到RequestMappingHandlerMapping里面
                    if (annotationRestController != null || annotationController != null) {
                        registerController(item.getBeanClassName());
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
