package com.unimas.poi.contorller;


import com.unimas.poi.entity.*;
import com.unimas.utils.ExportExcel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

@Controller
public class PoiExcelController {


    @GetMapping("/exportXls")
    public void exportXls(HttpServletResponse response) throws Exception{

        ArrayList<User> users = new ArrayList<>();




        ArrayList<String> headers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            users.add(new User(i,"张三",12,111+i));
        }
        headers.add("编号");
        headers.add("id");
        headers.add("姓名");
        headers.add("年龄");
        headers.add("成绩");

        String fielpath="D:\\opt\\user"+new Random().nextInt()+".xls";

        System.out.println(fielpath+"路径名称");

        ExportExcel.doExportExcel("学生表","表格", headers,users,fielpath,"yyyy-MM-dd");

    }


    @RequestMapping("springUpload")
    public void   springUpload(HttpServletRequest request) throws IllegalStateException, IOException
    {
        long  startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path="D:\\opt\\unimas\\"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }

            }

        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");

    }



}
