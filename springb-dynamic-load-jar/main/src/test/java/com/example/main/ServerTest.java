package com.example.main;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.assertj.core.util.Lists;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-04-24
 * Time 15:21
 */
public class ServerTest {
    private static int port = 443;
    private static Socket accept;
    private static ServerSocket socket;
    private static BufferedWriter bw;
    public static void main(String[] args) throws Exception {

        int a=1;
        List<Map<String, Object>> lst= Lists.newArrayList();
        for(int i=0;i<3;i++) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("name"+i, "llf");
            map.put("y0", "llf0");
            map.put("y1", "llf1");
            map.put("y2", "llf2");
            lst.add(map);
        }


        System.out.println(JSON.toJSONString(lst));

        if(a==1){
            return;
        }
        socket = new ServerSocket(port);
        System.out.println("服务器开启，等待连接....");
        while (true){
            accept = socket.accept();
            InputStreamReader r = new InputStreamReader(accept.getInputStream());
            System.out.println("浏览器请求成功!");
            BufferedReader br = new BufferedReader(r);
            String readLine = br.readLine();
            System.out.println("---------------------");
            //打印请求消息
            String filePath="log";
            int i=0;
            while(readLine != null && !readLine.equals("")){
                System.out.println(readLine);
                if (i==0){
                    String[] split = readLine.split(" ");
                    if (split[1].endsWith("html")) {
                        filePath += split[1];
                    }
                }
                i++;
                readLine=br.readLine();
            }
            System.out.println("----------------------");
            //发送响应请求
            System.out.println(filePath);
            writeHtml(filePath);
        }
    }

    public static void writeHtml(String filePath) throws Exception{
        if (!"log/index.html".equals(filePath)){
            filePath="log/404.html";
        }
        FileInputStream fis = new FileInputStream(filePath);
        int len=0;
        byte[] b = new byte[1024];
        StringBuilder sb = new StringBuilder();
        //拼装http响应的数据格式
        sb.append("http/1.1 200 ok").append("\n\n");
        while ((len=fis.read(b))!=-1){
            sb.append(new String(b,0,len));
        }
        bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
