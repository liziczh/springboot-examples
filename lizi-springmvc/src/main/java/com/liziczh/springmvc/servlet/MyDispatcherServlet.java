package com.liziczh.springmvc.servlet;

import com.liziczh.springmvc.annotation.MyController;
import com.liziczh.springmvc.annotation.MyRequestMapping;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;


public class MyDispatcherServlet extends HttpServlet {

    private Properties properties = new Properties();

    private List<String> classNames = new ArrayList<>();

    private Map<String, Object> ioc = new HashMap<>();

    private Map<String, Method> handlerMapping = new HashMap<>();

    private Map<String, Object> controllerMap = new HashMap<>();

    @Override
    public void init(ServletConfig config) {
        // 1.加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));
        // 2.初始化所有关联类，扫描用户设定的包下的所有类。
        doScanner(properties.getProperty("scanPackage"));
        // 3.拿到扫描到的类，通过反射机制实例化，放入ioc容器中，
        doInstance();
        // 4.初始化HandlerMapping，URL与method的映射
        initHandlerMapping();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (handlerMapping.isEmpty()) {
            return;
        }
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();

        url = url.replace(contextPath, "").replaceAll("/+", "");

        if (!this.handlerMapping.containsKey(url)) {
            resp.getWriter().write("404 NOT FOUND!");
            return;
        }
        // 获取处理器
        Method method = this.handlerMapping.get(url);
        // 获取方法的参数列表
        Class<?>[] parameterTypes = method.getParameterTypes();
        // 获取请求参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 保存参数值
        Object[] paramValues = new Object[parameterTypes.length];
        // 方法的参数列表
        for (int i = 0; i < parameterTypes.length; i++) {
            // 根据参数名称，做某些处理
            String requestParam = parameterTypes[i].getSimpleName();


            if (requestParam.equals("HttpServletRequest")) {
                // 参数类型已明确，这边强转类型
                paramValues[i] = req;
                continue;
            }
            if (requestParam.equals("HttpServletResponse")) {
                paramValues[i] = resp;
                continue;
            }
            if (requestParam.equals("String")) {
                for (Entry<String, String[]> param : parameterMap.entrySet()) {
                    String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "").replaceAll(",\\s", ",");
                    paramValues[i] = value;
                }
            }
        }
        // 利用反射机制来调用
        try {
            method.invoke(this.controllerMap.get(url), paramValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 4、初始化HandlerMapping，URL与method的映射
     */
    private void initHandlerMapping() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<? extends Object> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(MyController.class)) {
                continue;
            }
            // 拼url
            String baseUrl = "";
            if (clazz.isAnnotationPresent(MyRequestMapping.class)) {
                MyRequestMapping annotation = clazz.getAnnotation(MyRequestMapping.class);
                baseUrl = annotation.value();
            }
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (!method.isAnnotationPresent(MyRequestMapping.class)) {
                    continue;
                }
                MyRequestMapping annotation = method.getAnnotation(MyRequestMapping.class);
                String url = annotation.value();
                url = (baseUrl + "/" + url).replaceAll("/+", "/");
                handlerMapping.put(url, method);
                try {
                    controllerMap.put(url, clazz.newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                System.out.println(url + "," + method);
            }
        }
    }

    /**
     * 3、实例化所有类，放入IOC容器中
     */
    private void doInstance() {
        if (classNames.isEmpty()) {
            return;
        }
        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(MyController.class)) {
                    ioc.put(toLowerFirstWord(clazz.getSimpleName()), clazz.newInstance());
                } else {
                    continue;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 2、扫描包下所有类
     *
     * @param packageName 包名
     */
    private void doScanner(String packageName) {
        URL url = this.getClass().getClassLoader().getResource("/" + packageName.replace("\\.", "/"));
        File dir = new File(url.getFile());
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                // 递归读包
                doScanner(packageName + "." + file.getName());
            } else {
                String className = packageName + "." + file.getName().replace(".class", "");
                classNames.add(className);
            }
        }

    }

    /**
     * 1、加载配置文件
     *
     * @param contextConfigLocation 配置路径位置
     */
    private void doLoadConfig(String contextConfigLocation) {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 首字母小写
     *
     * @param name
     * @return
     */
    private String toLowerFirstWord(String name) {
        char[] charArray = name.toCharArray();
        charArray[0] += 32;
        return String.valueOf(charArray);
    }
}
