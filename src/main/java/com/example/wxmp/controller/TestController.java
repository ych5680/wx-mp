package com.example.wxmp.controller;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private WxMpService mpService;
    @GetMapping("/webhook")
    public String webhook(HttpServletRequest request) throws WxErrorException {
        String token = "123";
        // 获取请求参数
        // 验证失败，返回错误信息
        return "success";

    }
    @GetMapping("/test")
    public String test(HttpServletRequest request) throws WxErrorException {
        String token = "123";
        // 获取请求参数
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        // 将参数排序并拼接
        String[] params = {token, timestamp, nonce};
        Arrays.sort(params);
        String paramStr = params[0] + params[1] + params[2];

        // 使用SHA-1算法加密
        String sha1 = sha1(paramStr);

        // 验证签名
        if (sha1.equals(signature)) {
            // 验证通过，返回echostr给微信服务器
            return echostr;
        }
            // 验证失败，返回错误信息
            return "Verification failed";

    }
    @GetMapping("/test1")
    public String test1() throws WxErrorException {
        WxMpTemplateMessage wxMpTemplateMessage = new WxMpTemplateMessage();
        wxMpTemplateMessage.setTemplateId("WTxq1rBHRevv-aJ82af5-ytxObZJc3acG-XLbGKrdHY");
        wxMpTemplateMessage.setToUser("obXBL65rcL_WdtZ0544ys5TriLGA");
        List list = new ArrayList();
        WxMpTemplateData data = new WxMpTemplateData();
        data.setName("username");
        data.setValue("俞");
        data.setColor("#173177");
        WxMpTemplateData data2 = new WxMpTemplateData();
        data2.setName("order_number");
        data2.setValue("4564678643563");
        data2.setColor("#173177");
        WxMpTemplateData data3 = new WxMpTemplateData();
        data3.setName("amount");
        data3.setValue("10000000");
        data3.setColor("#173177");
        list.add(data);
        list.add(data2);
        list.add(data3);
        wxMpTemplateMessage.setData(list);
        System.out.println(wxMpTemplateMessage.toJson());
        this.mpService.getTemplateMsgService().sendTemplateMsg(wxMpTemplateMessage);
        // this.mpService.getWxMpConfigStorage().getAppId();
        return wxMpTemplateMessage.toJson();
    }

    // SHA-1加密方法
    private String sha1(String input) {
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] bytes = sha1.digest(input.getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : bytes) {
                String hex = Integer.toHexString(b & 0xff);
                if (hex.length() == 1) {
                    builder.append('0');
                }
                builder.append(hex);
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
